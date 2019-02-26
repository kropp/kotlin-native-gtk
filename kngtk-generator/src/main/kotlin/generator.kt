import com.squareup.kotlinpoet.*
import com.squareup.kotlinpoet.ParameterizedTypeName.Companion.parameterizedBy
import org.jdom2.Element

fun Element.processClass(enums: Map<String, TypeName>): FileSpec? {
    val name = toName()
    val parent = getAttribute("parent")?.value

    val ctrElement = getChild("constructor", introspectionNs)
    if (ctrElement?.getAttribute("deprecated") != null) return null
    val ctrParams = ctrElement?.parameters
    if (name != "Widget" && ctrParams?.any { !it.toTypename().isSupported() } == true) return null

    val gtkClassPtr = ClassName(LIB, "Gtk$name").ptr

    val file = FileSpec.builder(NS, name).build {
        addType(name) {
            addAnnotation(Dsl)

            getChild("doc", introspectionNs)?.text?.let { addKdoc("%L", it) }

            addModifiers(if (name == "Widget" || ctrElement == null) KModifier.ABSTRACT else KModifier.OPEN)

            val isDerived = parent?.contains("GObject.InitiallyUnowned") == false
            if (isDerived) {
                superclass(ClassName(NS, parent!!))
            }

            if (isDerived && ctrElement != null) {
                primaryConstructor {
                    addModifiers(KModifier.INTERNAL)
                    addParameter(ParameterSpec.builder("widgetPtr", GtkWidget.ptr.asNullable()).defaultValue("null").build())
                    addProperty(PropertySpec.builder("widgetPtr", GtkWidget.ptr.asNullable(), KModifier.OVERRIDE).initializer("widgetPtr").build())
                }
                val ctr = ctrElement.getAttribute("identifier", cNs).value
                addImport(LIB, ctr)
                val instanceName = name.toInstanceName()
                ctr {
                    addImport(CINTEROP, "reinterpret")
                    val call = if (ctrParams!!.any()) {
                        "$ctr(" + ctrParams.joinToString(", ") {
                            val type = it.toTypename().igtptr(enums)
                            addParameter(it.toName(), type)
                            convertTypeFrom(it.toName(), type)
                        } + ")" + if (name == "ApplicationWindow") "" else "?.reinterpret()"
                    } else {
                        "$ctr()?.reinterpret()"
                    }

                    ctrElement.getChild("doc", introspectionNs)?.text?.let { addKdoc("%L", it) }
                    callThisConstructor(call)

                    // DSL

                    this@build.addFunction(instanceName) {
                        val ourWidget = name.toTypeName().asOurWidget(enums)

                        addModifiers(KModifier.INLINE)
                        receiver(Container)
                        returns(ourWidget)

                        val params = ctrParams.map {
                            addParameter(it.toName(), it.toTypename().igtptr(enums))
                            it.toName()
                        }
                        addParameter(ParameterSpec.builder("init", ourWidget.asBuilder()).defaultValue("{}").build())

                        addStatement("return $name(${params.joinToString(", ")}).apply·{·init(); this@$instanceName.add(this) }")
                    }
                }

                addPrivateProperty("self", gtkClassPtr.asNullable()) {
                    addImport(CINTEROP, "reinterpret")
                    addStatement("return widgetPtr!!.reinterpret()")
                }

                if (name !in listOf("Label")) {
                    addProperty(instanceName, gtkClassPtr.asNullable()) {
                        addImport(CINTEROP, "reinterpret")
                        addStatement("return widgetPtr!!.reinterpret()")
                    }
                }
            } else {
                when {
                    ctrElement == null -> {
                        addImport(CINTEROP, "reinterpret")
                        addPrivateProperty("self", gtkClassPtr) { addStatement("return widgetPtr!!.reinterpret()") }
                    }
                    name != "Widget" -> {
                        val params = ctrElement.parameters
                        primaryConstructor {
                            params.forEach {
                                addParameter(it.toName(), it.toTypename().igtptr(enums))
                            }
                        }
                        val ctr = ctrElement.getAttribute("identifier", cNs).value
                        addImport(LIB, ctr)
                        val call = if (params.any()) {
                            "$ctr(" + params.joinToString(", ") {
                                it.toName()
                            } + ")"
                        } else {
                            "$ctr()"
                        }
                        addProperty(PropertySpec.builder("widgetPtr", gtkClassPtr).initializer("$call!!").build())
                        addPrivateProperty("self", gtkClassPtr) {
                            addStatement("return widgetPtr")
                        }
                    }
                    else -> {
                        // Widget
                        addProperty(PropertySpec.builder("widgetPtr", gtkClassPtr.asNullable(), KModifier.ABSTRACT).build())
                        addPrivateProperty("self", gtkClassPtr.asNullable()) {
                            addStatement("return widgetPtr")
                        }
                    }
                }
            }

            val properties = mutableMapOf<String,PropertyInfo>()
            getChildren("method", introspectionNs).filter {
                it.getAttribute("throws") == null &&
                        it.parameters.all { it.getChild("varargs", introspectionNs) == null && it.toTypename().isSupported() } &&
                        it.getAttribute("deprecated")?.value != "1" &&
                        it.toName().removePrefix("get_").removePrefix("set_") !in listOf("destroyed", "direction", "screen", "activate", "toggle_size_request") &&
                        (name != "Menu" || !it.toName().endsWith("_active")) &&
                        (name != "MenuShell" || !it.toName().endsWith("append"))
            }.forEach {
                val n = it.toName()
                val pCount = it.parameters.size
                when {
                    n.startsWith("get_") && pCount == 0 -> {
                        val trimmed = n.removePrefix("get_")
                        properties.compute(trimmed) { _, p -> PropertyInfo(trimmed, it, p?.setter)}
                    }
                    n.startsWith("set_") && pCount == 1 -> {
                        val trimmed = n.removePrefix("set_")
                        properties.compute(trimmed) { _, p -> PropertyInfo(trimmed, p?.getter, it)}
                    }
                    else -> {
                        val returnType = it.getChild("return-value", introspectionNs).toTypename()

                        val parameters = it.parameters
                        val arguments = parameters.map {
                            it.toName() to it.toTypename()
                        }

                        if (returnType.isSupported() && arguments.all { it.second.isSupported() } && parameters.all { it.getAttribute("direction")?.value != "out" }) {
                            addFunction(n.toInstanceName()) {
                                returns(returnType.igtptr(enums))
                                arguments.forEach {
                                    addParameter(it.first, it.second.igtptr(enums))
                                }

                                val f = it.getAttribute("identifier", cNs).value
                                addImport(LIB, f)

                                val call = if (arguments.any()) "$f(self, ${arguments.joinToString(", ") { convertTypeFrom(it.first, it.second) }})" else "$f(self)"
                                addStatement("return " + convertTypeTo(call, returnType.igtptr(enums)))

                                it.getChild("doc", introspectionNs)?.text?.let { addKdoc("%L", it) }
                            }

                            if (arguments.any { it.second.isWidgetPtr(enums) } && arguments.all {
                                    val name = (it.second as? ClassName)?.simpleName
                                    name !in skipInOverload && name?.startsWith("Gdk") != true
                                }) {
                                // add overload
                                addFunction(n.toInstanceName()) {
                                    returns(returnType.igtptr(enums))
                                    arguments.forEach {
                                        addParameter(it.first, it.second.asOurWidget(enums))
                                    }

                                    val f = it.getAttribute("identifier", cNs).value
                                    addImport(LIB, f)

                                    val call = if (arguments.any()) "$f(self, ${arguments.joinToString(", ") { convertTypeFrom(it.first, it.second.asOurWidget(enums)) }})" else "$f(self)"
                                    addStatement("return " + convertTypeTo(call, returnType.igtptr(enums)))

                                    it.getChild("doc", introspectionNs)?.text?.let { addKdoc("%L", it) }
                                }
                            }
                        }
                    }
                }
            }

            val signals = getChildren("signal", glibNs)
            if (signals.any()) {
                addImport(CINTEROP, "staticCFunction")
                addImport(CINTEROP, "asStableRef")

                signals.forEach { signal ->
                    val (signalName, params, funSpec) = generateSignalHandler(signal, name, enums)

                    this@build.addFunction(funSpec
                        .addParameter("data", COpaquePointer.asNullable())
                        .addStatement("data?.asStableRef<$name>()?.get()?.$signalName?.emit(${params.joinToString { convertTypeFrom(it.toName().escaped(), it.toTypename(), false) }})")
                        .build())
                }
            }

            properties.forEach { _, prop ->
                if (prop.getter == null) {
                    addFunction(("set_" + prop.name).toInstanceName()) {
                        val typeName = prop.setter!!.getChild("return-value", introspectionNs).toTypename()
                        returns(typeName)

                        val f = prop.setter.getAttribute("identifier", cNs).value
                        addImport(LIB, f)

                        val arguments = prop.setter.parameters.map {
                            val n = it.toName()
                            val t = it.toTypename()
                            addParameter(n, t.igtptr(enums))
                            convertTypeFrom(n, t)
                        }

                        if (arguments.any()) {
                            addStatement("return " + convertTypeTo("$f(self, ${arguments.joinToString(", ")})", typeName))
                        } else {
                            addStatement("return " + convertTypeTo("$f()", typeName))
                        }

                        prop.setter.getChild("doc", introspectionNs)?.text?.let { addKdoc("%L", it) }
                    }
                } else {
                    val rawTypeName = prop.getter.getChild("return-value", introspectionNs).toTypename()
                    if (rawTypeName.isSupported()) {
                        val typeName = rawTypeName.igtptr(enums)
                        if (prop.setter != null) {
                            addVarProperty(if (name == "Widget" && prop.name == "window") "gdkWindow" else prop.name.toInstanceName(), typeName) {
                                getter {
                                    val f = prop.getter.getAttribute("identifier", cNs).value
                                    addImport(LIB, f)
                                    addStatement("return " + convertTypeTo("$f(self)", typeName))
                                    prop.getter.getChild("doc", introspectionNs)?.text?.let { addKdoc("%L", it) }
                                }
                                setter(typeName) {
                                    val f = prop.setter.getAttribute("identifier", cNs).value
                                    addImport(LIB, f)
                                    addStatement("$f(self, " + convertTypeFrom("value", typeName) + ")")
                                    prop.setter.getChild("doc", introspectionNs)?.text?.let { addKdoc("%L", it) }
                                }
                            }
                        } else {
                            addProperty(prop.name.toInstanceName(), typeName) {
                                val f = prop.getter.getAttribute("identifier", cNs).value
                                addImport(LIB, f)
                                addStatement("return " + convertTypeTo("$f(self)", typeName))
                                prop.getter.getChild("doc", introspectionNs)?.text?.let { addKdoc("%L", it) }
                            }
                        }
                    }
                }
            }
        }
    }

    return file
}

private fun TypeSpec.Builder.generateSignalHandler(
    signal: Element,
    name: String,
    enums: Map<String, TypeName>
): Triple<String, List<Element>, FunSpec.Builder> {
    val signalName = ("on-" + signal.toName()).toInstanceName()
    val handler = "${name}_${signalName}_Handler"

    val params = signal.parameters

    // Signal2<PlacesSidebar, CPointer<libgtk3.GFile>?, GtkPlacesOpenFlags, CFunction<(CPointer<*>?, CPointer<GFile>?, GtkPlacesOpenFlags, COpaquePointer?) -> Unit>>
    val thisType = ClassName(NS, name)
    val wCPointed = WildcardTypeName.consumerOf(CPointed)

    val signalType = when (params.size) {
        4 -> Signal4.parameterizedBy(
            thisType,
            params[0].toTypename().igtptr(enums),
            params[1].toTypename().igtptr(enums),
            params[2].toTypename().igtptr(enums),
            params[3].toTypename().igtptr(enums),
            CFunction.parameterizedBy(
                LambdaTypeName.get(
                    null,
                    CPointer.parameterizedBy(wCPointed).asNullable(),
                    params[0].toTypename().igtptr(enums),
                    params[1].toTypename().igtptr(enums),
                    params[2].toTypename().igtptr(enums),
                    params[3].toTypename().igtptr(enums),
                    COpaquePointer.asNullable(),
                    returnType = UNIT
                )
            )
        )
        3 -> Signal3.parameterizedBy(
            thisType,
            params[0].toTypename().igtptr(enums),
            params[1].toTypename().igtptr(enums),
            params[2].toTypename().igtptr(enums),
            CFunction.parameterizedBy(
                LambdaTypeName.get(
                    null,
                    CPointer.parameterizedBy(wCPointed).asNullable(),
                    params[0].toTypename().igtptr(enums),
                    params[1].toTypename().igtptr(enums),
                    params[2].toTypename().igtptr(enums),
                    COpaquePointer.asNullable(),
                    returnType = UNIT
                )
            )
        )
        2 -> Signal2.parameterizedBy(
            thisType,
            params[0].toTypename().igtptr(enums),
            params[1].toTypename().igtptr(enums),
            CFunction.parameterizedBy(
                LambdaTypeName.get(
                    null,
                    CPointer.parameterizedBy(wCPointed).asNullable(),
                    params[0].toTypename().igtptr(enums),
                    params[1].toTypename().igtptr(enums),
                    COpaquePointer.asNullable(),
                    returnType = UNIT
                )
            )
        )
        1 -> Signal1.parameterizedBy(
            thisType,
            params[0].toTypename().igtptr(enums),
            CFunction.parameterizedBy(
                LambdaTypeName.get(
                    null,
                    CPointer.parameterizedBy(wCPointed).asNullable(),
                    params[0].toTypename().igtptr(enums),
                    COpaquePointer.asNullable(),
                    returnType = UNIT
                )
            )
        )
        else -> Signal.parameterizedBy(
            thisType,
            CFunction.parameterizedBy(
                LambdaTypeName.get(
                    null,
                    CPointer.parameterizedBy(wCPointed).asNullable(),
                    COpaquePointer.asNullable(),
                    returnType = UNIT
                )
            )
        )
    }

    addProperty(
        PropertySpec.builder(
            signalName,
            signalType
        ).delegate(
            "lazy·{·%T(widgetPtr!!, this, \"${signal.toName()}\", staticCFunction(::$handler)) }",
            signalType
        ).build()
    )

    val funSpec = FunSpec.builder(handler)
        .addModifiers(KModifier.PRIVATE)
        .addParameter("sender", CPointer.parameterizedBy(wCPointed).asNullable())

    params.forEach { param ->
        funSpec.addParameter(param.toName(), param.toTypename().igtptr(enums))
    }
    return Triple(signalName, params, funSpec)
}

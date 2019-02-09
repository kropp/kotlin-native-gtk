import com.squareup.kotlinpoet.*
import com.squareup.kotlinpoet.ParameterizedTypeName.Companion.parameterizedBy
import org.jdom2.Element
import java.io.File

fun Element.processClass() {
    val name = toName()
    val parent = getAttribute("parent")?.value

    val ctrElement = getChild("constructor", introspectionNs)
    if (ctrElement?.getAttribute("deprecated") != null) return
    val ctrParams = ctrElement?.parameters
    if (name != "Widget" && ctrParams?.any { !it.toTypename().isSupported() } == true) return

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
                            val type = it.toTypename().igtptr
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
                        val ourWidget = name.toTypeName().asOurWidget()

                        addModifiers(KModifier.INLINE)
                        receiver(Container)
                        returns(ourWidget)

                        val params = ctrParams.map {
                            addParameter(it.toName(), it.toTypename().igtptr)
                            it.toName()
                        }
                        addParameter(ParameterSpec.builder("init", ourWidget.asBuilder()).defaultValue("{}").build())

                        addStatement("return $name(${params.joinToString(", ")}).apply { init(); this@$instanceName.add(this) }")
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
                                addParameter(it.toName(), it.toTypename().igtptr)
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


            val signals = getChildren("signal", glibNs)
            if (signals.any()) {
                addImport(CINTEROP, "staticCFunction")
                addImport(CINTEROP, "asStableRef")

                signals.forEach { signal ->
                    val (signalName, params, funSpec) = generateSignalHandler(signal, name)

                    this@build.addFunction(funSpec
                        .addParameter("data", COpaquePointer.asNullable())
                        .addStatement("data?.asStableRef<$name>()?.get()?.$signalName?.invoke(${params.joinToString { convertTypeFrom(it.toName(), it.toTypename()) }})")
                        .build())
                }
            }

        }
    }

    file.writeTo(File("../gtk/src/main/kotlin/generated"))
}

private fun TypeSpec.Builder.generateSignalHandler(
    signal: Element,
    name: String
): Triple<String, List<Element>, FunSpec.Builder> {
    val signalName = ("on-" + signal.toName()).toInstanceName()
    val handler = "${name}_${signalName}_Handler"

    val params = signal.parameters

    // Signal2<PlacesSidebar, CPointer<libgtk3.GFile>?, GtkPlacesOpenFlags, CFunction<(CPointer<*>?, CPointer<GFile>?, GtkPlacesOpenFlags, COpaquePointer?) -> Unit>>
    val thisType = ClassName(NS, name)
    val wANY = WildcardTypeName.consumerOf(ANY)

    val signalType = when (params.size) {
        4 -> Signal4.parameterizedBy(
            thisType,
            params[0].toTypename().igtptr,
            params[1].toTypename().igtptr,
            params[2].toTypename().igtptr,
            params[3].toTypename().igtptr,
            CFunction.parameterizedBy(
                LambdaTypeName.get(
                    null,
                    CPointer.parameterizedBy(wANY).asNullable(),
                    params[0].toTypename().igtptr,
                    params[1].toTypename().igtptr,
                    params[2].toTypename().igtptr,
                    params[3].toTypename().igtptr,
                    COpaquePointer.asNullable(),
                    returnType = UNIT
                )
            )
        )
        3 -> Signal3.parameterizedBy(
            thisType,
            params[0].toTypename().igtptr,
            params[1].toTypename().igtptr,
            params[2].toTypename().igtptr,
            CFunction.parameterizedBy(
                LambdaTypeName.get(
                    null,
                    CPointer.parameterizedBy(wANY).asNullable(),
                    params[0].toTypename().igtptr,
                    params[1].toTypename().igtptr,
                    params[2].toTypename().igtptr,
                    COpaquePointer.asNullable(),
                    returnType = UNIT
                )
            )
        )
        2 -> Signal2.parameterizedBy(
            thisType,
            params[0].toTypename().igtptr,
            params[1].toTypename().igtptr,
            CFunction.parameterizedBy(
                LambdaTypeName.get(
                    null,
                    CPointer.parameterizedBy(wANY).asNullable(),
                    params[0].toTypename().igtptr,
                    params[1].toTypename().igtptr,
                    COpaquePointer.asNullable(),
                    returnType = UNIT
                )
            )
        )
        1 -> Signal1.parameterizedBy(
            thisType,
            params[0].toTypename().igtptr,
            CFunction.parameterizedBy(
                LambdaTypeName.get(
                    null,
                    CPointer.parameterizedBy(wANY).asNullable(),
                    params[0].toTypename().igtptr,
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
                    CPointer.parameterizedBy(wANY).asNullable(),
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
            "lazy { %T(widgetPtr!!, this, \"${signal.toName()}\", staticCFunction(::$handler)) }",
            signalType
        ).build()
    )

    val funSpec = FunSpec.builder(handler)
        .addModifiers(KModifier.PRIVATE)
        .addParameter("sender", CPointer.parameterizedBy(wANY).asNullable())

    params.forEach { param ->
        funSpec.addParameter(param.toName(), param.toTypename().igtptr)
    }
    return Triple(signalName, params, funSpec)
}

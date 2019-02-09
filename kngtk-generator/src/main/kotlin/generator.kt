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

            val signals = getChildren("signal", glibNs)
            if (signals.any()) {
                addImport(CINTEROP, "staticCFunction")
                addImport(CINTEROP, "asStableRef")

                signals.forEach { signal ->
                    val signalName = ("on-" + signal.toName()).toInstanceName()
                    val handler = "${name}_${signalName}_Handler"

                    val params = signal.parameters

                    // Signal2<PlacesSidebar, CPointer<libgtk3.GFile>?, GtkPlacesOpenFlags, CFunction<(CPointer<*>?, CPointer<GFile>?, GtkPlacesOpenFlags, COpaquePointer?) -> Unit>>
                    val thisType = ClassName(NS, name)
                    val wANY = WildcardTypeName.consumerOf(ANY)

                    val signalType = when(params.size) {
                        4 -> Signal4.parameterizedBy(thisType, params[0].toTypename().igtptr, params[1].toTypename().igtptr, params[2].toTypename().igtptr, params[3].toTypename().igtptr, CFunction.parameterizedBy(LambdaTypeName.get(null, CPointer.parameterizedBy(wANY).asNullable(), params[0].toTypename().igtptr, params[1].toTypename().igtptr, params[2].toTypename().igtptr, params[3].toTypename().igtptr, COpaquePointer.asNullable(), returnType = UNIT)))
                        3 -> Signal3.parameterizedBy(thisType, params[0].toTypename().igtptr, params[1].toTypename().igtptr, params[2].toTypename().igtptr, CFunction.parameterizedBy(LambdaTypeName.get(null, CPointer.parameterizedBy(wANY).asNullable(), params[0].toTypename().igtptr, params[1].toTypename().igtptr, params[2].toTypename().igtptr, COpaquePointer.asNullable(), returnType = UNIT)))
                        2 -> Signal2.parameterizedBy(thisType, params[0].toTypename().igtptr, params[1].toTypename().igtptr, CFunction.parameterizedBy(LambdaTypeName.get(null, CPointer.parameterizedBy(wANY).asNullable(), params[0].toTypename().igtptr, params[1].toTypename().igtptr, COpaquePointer.asNullable(), returnType = UNIT)))
                        1 -> Signal1.parameterizedBy(thisType, params[0].toTypename().igtptr, CFunction.parameterizedBy(LambdaTypeName.get(null, CPointer.parameterizedBy(wANY).asNullable(), params[0].toTypename().igtptr, COpaquePointer.asNullable(), returnType = UNIT)))
                        else -> Signal.parameterizedBy(thisType, CFunction.parameterizedBy(LambdaTypeName.get(null, CPointer.parameterizedBy(wANY).asNullable(), COpaquePointer.asNullable(), returnType = UNIT)))
                    }

                    addProperty(PropertySpec.builder(signalName, signalType).delegate("lazy { %T(widgetPtr!!, this, \"${signal.toName()}\", staticCFunction(::$handler)) }", signalType).build())

                    val funSpec = FunSpec.builder(handler)
                        .addModifiers(com.squareup.kotlinpoet.KModifier.PRIVATE)
                        .addParameter("sender", CPointer.parameterizedBy(wANY).asNullable())

                    params.forEach { param ->
                        funSpec.addParameter(param.toName(), param.toTypename().igtptr)
                    }

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

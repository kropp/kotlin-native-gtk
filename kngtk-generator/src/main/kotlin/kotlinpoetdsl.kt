import com.squareup.kotlinpoet.*

fun FileSpec.Builder.build(init: FileSpec.Builder.() -> Unit) = apply(init).build()

fun FileSpec.Builder.addType(name: String, init: TypeSpec.Builder.() -> Unit) {
    addType(TypeSpec.classBuilder(name).apply(init).build())
}

fun FileSpec.Builder.addFunction(name: String, init: FunSpec.Builder.() -> Unit) {
    addFunction(FunSpec.builder(name).apply(init).build())
}

fun TypeSpec.Builder.addFunction(name: String, init: FunSpec.Builder.() -> Unit) {
    addFunction(FunSpec.builder(name).apply(init).build())
}

fun TypeSpec.Builder.primaryConstructor(init: FunSpec.Builder.() -> Unit) {
    primaryConstructor(FunSpec.constructorBuilder().apply(init).build())
}

fun TypeSpec.Builder.ctr(init: FunSpec.Builder.() -> Unit) {
    addFunction(FunSpec.constructorBuilder().apply(init).build())
}

fun TypeSpec.Builder.addVarProperty(name: String, type: TypeName, init: PropertySpec.Builder.() -> Unit) {
    addProperty(PropertySpec.builder(name, type).apply(init).build())
}

fun PropertySpec.Builder.getter(init: FunSpec.Builder.() -> Unit) {
    getter(FunSpec.getterBuilder().apply(init).build())
}
fun PropertySpec.Builder.setter(type: TypeName, init: FunSpec.Builder.() -> Unit) {
    setter(FunSpec.setterBuilder().addParameter("value", type).apply(init).build())
}

fun TypeSpec.Builder.addProperty(name: String, type: TypeName, init: FunSpec.Builder.() -> Unit) {
    addProperty(PropertySpec.builder(name.validate(), type).getter(FunSpec.getterBuilder().apply(init).build()).build())
}

fun TypeSpec.Builder.addPrivateProperty(name: String, type: TypeName, init: FunSpec.Builder.() -> Unit) {
    addProperty(PropertySpec.builder(name, type, KModifier.PRIVATE).getter(FunSpec.getterBuilder().apply(init).build()).build())
}

private fun String.validate() = when(this) {
    "object" -> "obj"
    else -> this
}
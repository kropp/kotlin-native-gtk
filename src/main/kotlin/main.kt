import org.jdom2.Element
import org.jdom2.Namespace
import org.jdom2.input.SAXBuilder
import java.io.File
import java.io.PrintStream

val introspectionNs = Namespace.getNamespace("http://www.gtk.org/introspection/core/1.0")
val cNs = Namespace.getNamespace("http://www.gtk.org/introspection/c/1.0")

fun main(args: Array<String>) {
  val doc = SAXBuilder().build(File("gtk.xml"))

  doc.rootElement.getChild("namespace", introspectionNs)?.processNamespace(System.out)
}

private fun Element.processNamespace(out: PrintStream) {
  out.println("package " + toName())

  getChildren("class", introspectionNs).forEach {
    it.processClass(out)
  }
}

private fun Element.processClass(out: PrintStream) {
  val className = toName()
  if (className == "Widget") {
    out.print("abstract ")
  }
  out.print("class " + className)
  val implements = getChildren("implements", introspectionNs).map { it.toName() }.joinToString(", ")
  if (implements.isNotEmpty()) out.print(" : $implements")
  out.println(" {")
  if (className == "Widget") {
    out.println("  abstract val widgetPtr: CPointer<Widget>")
  } else {
    getChild("constructor", introspectionNs)?.let {
      out.println("  val widgetPtr = ${it.getAttribute("identifier", cNs).value}(${it.toArgumentsList()})!!")
    }
  }

  // methods
  for (e in getChildren("method", introspectionNs)) {
    print("  fun ${e.getAttribute("name").value}(${e.toParametersList()})")

    val returnValueElement = e.getChild("return-value", introspectionNs)
    val typeName = returnValueElement.toTypename()
    if (typeName != null) {
      convertType(typeName)?.let { print(" : $it") }
    } else {
      val returnArrayType = convertType(returnValueElement.getChild("array", introspectionNs).toTypename()!!)
      print(" : Array<$returnArrayType>")
    }
    println(" {")
    println("    return ${e.getAttribute("identifier", cNs).value}(${e.toArgumentsList("widgetPtr.reinterpret()")})")
    println("  }")
  }

  out.println("}")
}

private fun Element.toName() = getAttribute("name").value
private fun Element.toTypename() = getChild("type", introspectionNs)?.toName()
private fun Element.toParametersList(): String = getChild("parameters", introspectionNs)?.getChildren("parameter", introspectionNs)?.let {
  it.map { it.toName() + ": " + it.toTypename() }.joinToString(", ")
} ?: ""
private fun Element.toArgumentsList(argumentsBefore: String = ""): String {
  return getChild("parameters", introspectionNs)?.
      getChildren("parameter", introspectionNs)?.
      map(Element::toName)?.
      let { mutableListOf(argumentsBefore) + it }?.
      joinToString(", ") ?: argumentsBefore
}


private fun convertType(name: String) = when(name) {
  "none" -> null
  "any" -> "Any"
  "utf8" -> "String"
  "gint32" -> "Int"
  "gboolean" -> "Boolean"
  else -> name
}
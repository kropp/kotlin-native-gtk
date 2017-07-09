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
  out.print("class " + toName())
  val implements = getChildren("implements", introspectionNs).map { it.toName() }.joinToString(", ")
  if (implements.isNotEmpty()) out.print(" : $implements")
  out.println(" {")

  // methods
  for (e in getChildren("method", introspectionNs)) {
    print("  fun ${e.getAttribute("name").value}(")

    val parameters = e.getChild("parameters", introspectionNs)?.getChildren("parameter", introspectionNs)
    parameters?.let {
      print(it.map { it.toName() + ": " + it.toTypename() }.joinToString(", "))
    }

    print(")")

    val returnValueElement = e.getChild("return-value", introspectionNs)
    val typeName = returnValueElement.toTypename()
    if (typeName != null) {
      convertType(typeName)?.let { print(" : $it") }
    } else {
      val returnArrayType = convertType(returnValueElement.getChild("array", introspectionNs).toTypename()!!)
      print(" : Array<$returnArrayType>")
    }
    println(" {")
    print("    return ${e.getAttribute("identifier", cNs).value}(")
    print(parameters?.map(Element::toName)?.joinToString(", ") ?: "")
    println(")")
    println("  }")
  }

  out.println("}")
}

private fun Element.toName() = getAttribute("name").value
private fun Element.toTypename() = getChild("type", introspectionNs)?.toName()

private fun convertType(name: String) = when(name) {
  "none" -> null
  "any" -> "Any"
  "utf8" -> "String"
  "gint32" -> "Int"
  "gboolean" -> "Boolean"
  else -> name
}
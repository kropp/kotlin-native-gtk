import com.squareup.kotlinpoet.ClassName
import com.squareup.kotlinpoet.ParameterizedTypeName.Companion.parameterizedBy
import com.squareup.kotlinpoet.TypeName
import org.jdom2.Namespace

val introspectionNs = Namespace.getNamespace("http://www.gtk.org/introspection/core/1.0")
val cNs = Namespace.getNamespace("http://www.gtk.org/introspection/c/1.0")
val glibNs = Namespace.getNamespace("http://www.gtk.org/introspection/glib/1.0")

private const val NS = "gtk3"
private const val LIB = "libgtk3"

private const val CINTEROP = "kotlinx.cinterop"


val LIST = ClassName("kotlin.collections", "List")
val CPointer = ClassName(CINTEROP, "CPointer")
val COpaquePointer = ClassName(CINTEROP, "COpaquePointer")
val CFunction = ClassName(CINTEROP, "CFunction")
val TypeName.ptr get() = CPointer.parameterizedBy(this)
val GtkWidget = ClassName(LIB, "GtkWidget")
val Widget = ClassName(NS, "Widget")
val Container = ClassName(NS, "Container")
val Signal = ClassName(NS, "Signal")
val Signal1 = ClassName(NS, "Signal1")
val Signal2 = ClassName(NS, "Signal2")
val Signal3 = ClassName(NS, "Signal3")
val Signal4 = ClassName(NS, "Signal4")
val Dsl = ClassName(NS, "GtkDsl")

import com.squareup.kotlinpoet.*
import com.squareup.kotlinpoet.ParameterizedTypeName.Companion.parameterizedBy
import org.jdom2.Element

fun Element.toName(): String = getAttribute("name").value

fun String.escaped(): String = when(this) {
    "object" -> "`object`"
    else -> this
}

fun Element.shouldGenerateBindingClass(): Boolean {
    val name = getAttribute("name").value
    val parent = getAttribute("parent")?.value

    if (name.endsWith("Accessible")) return false
    if (name.startsWith("Gesture")) return false
    if (name.startsWith("CellRenderer")) return false
    if (name.startsWith("CellArea")) return false
    if (name.contains("ColorSelection")) return false // Deprecated
    if (name == "Plug" || name == "Socket") return false
    if (name == "HSV") return false
    if (name.startsWith("Popover")) return false // conflicting constructor
    if (name == "VolumeButton") return false // -> ScaleButton -> array
    if (parent == "EventController") return false
    if (parent == "GObject.Object") return false
    if (parent == "NativeDialog") return false
    if (parent == "IMContext") return false
    if (parent?.startsWith("Gio") == true) return false

    return true
}

val Element.parameters get() = getChild("parameters", introspectionNs)?.getChildren("parameter", introspectionNs)?.filter { it.getChild("varargs", introspectionNs) == null } ?: emptyList()

fun String.toInstanceName() = split('_', '-').joinToString("") { it.capitalize() }.let { it.first().toLowerCase() + it.substring(1) }

fun Element.toTypename(): TypeName {
    val arrayChild = getChild("array", introspectionNs)
    if (arrayChild != null) {
        val elementType = arrayChild.toTypename()
        return LIST.parameterizedBy(elementType)
    }
    val child = getChild("type", introspectionNs)
    val name = child.toName()
    if (name == "gint") {
        val candidate = child.getAttribute("type", cNs).value
        if ("*" !in candidate) return candidate.toTypeName()
    }
    return name.toTypeName()
}

val UINT = ClassName("kotlin", "UInt")
val USHORT = ClassName("kotlin", "UShort")
val ULONG = ClassName("kotlin", "ULong")

fun String?.toTypeName(): TypeName {
    return when(this) {
        null, "none" -> UNIT
        "any" -> ANY
        "utf8" -> STRING
        "filename" -> STRING
        "gboolean" -> BOOLEAN
        "gfloat" -> FLOAT
        "gdouble" -> DOUBLE
        "int" -> INT
        "gint" -> INT
        "gint16" -> SHORT
        "gint32" -> INT
        "guint" -> UINT
        "guint16" -> USHORT
        "guint32" -> UINT
        else -> {
/*
            if (this in enums) {
                enums[this]!!
            } else {
*/
                val res = when {
                    equals("GdkPixbuf.Pixbuf") -> "GdkPixbuf"
                    startsWith("Gio") -> this.replace("Gio", "G")
                    startsWith("GLib") -> this.replace("GLib", "G")
                    startsWith("Gtk") || startsWith("Gdk") -> this
                    else -> "Gtk$this"
                }
                ClassName(LIB, res.replace(".", ""))
//            }
        }
    }
}

fun TypeName.isSupported(): Boolean {
    if (this is ParameterizedTypeName) {
        return this.rawType == LIST && this.typeArguments.first() == STRING
    }
    if (this is ClassName) {
/*
    if (simpleName == "GtkGLibDestroyNotify") return false
    if (simpleName == "GtkGLibList") return false
*/
        if (simpleName == "GdkPixbufPixbufAnimation") return false
        if (simpleName == "Gtkgpointer") return false
        if (simpleName == "Gtkgunichar") return false
        if (simpleName == "Gtkfile") return false
        if (simpleName.startsWith("GtkGLib")) return false
        if (simpleName.startsWith("GLib.")) return false
        if (simpleName.startsWith("GObject")) return false
        if (simpleName.contains("GObject")) return false
        if (simpleName.contains("Atk")) return false
        if (simpleName.contains("GType")) return false
        if (simpleName.contains("GdkAtom")) return false
        if (simpleName.contains("cairo", ignoreCase = true)) return false
        if (simpleName.contains("pango", ignoreCase = true)) return false
        if (simpleName.contains("gio", ignoreCase = true)) return false
        if (simpleName.contains("Func")) return false
        if (simpleName.contains("va_list")) return false
    }
    return true
}

val skipInOverload = listOf("GtkTextIter", "GtkTextMark", "GtkTextChildAnchor", "GtkRecentFilterInfo", "GtkFileFilterInfo", "GtkAccelGroup", "GtkTargetList", "GtkTreePath", "GtkCellRenderer", "GtkTreeModel", "GtkTreeIter", "GtkTooltip", "GtkAllocation", "GtkSelectionData", "GFile", "GIcon", "GMenuModel", "GActionGroup")
fun TypeName.isWidgetPtr(enums: Map<String, TypeName>) = this is ClassName && packageName == LIB && !simpleName.startsWith("Gdk") && simpleName !in skipInOverload && this !in enums.values
fun TypeName.igtptr(enums: Map<String, TypeName>) = if (this is ClassName && packageName == LIB && this !in enums.values) ptr else this
fun TypeName.ptrInSignal(enums: Map<String, TypeName>): TypeName {
    if (this == STRING) {
        return ByteVarPtr
    }
    return igtptr(enums)
}

fun TypeName.asNullable() = copy(true)

fun TypeName.asOurWidget(enums: Map<String, TypeName>) = if (isWidgetPtr(enums)) {
    ClassName(NS, (this as ClassName).simpleName.removePrefix("Gtk"))
} else this

fun TypeName.asBuilder() = LambdaTypeName.get(receiver = this, returnType = UNIT)

class PropertyInfo(val name: String, val getter: Element?, val setter: Element?)
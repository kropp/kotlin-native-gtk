import com.squareup.kotlinpoet.*
import org.jdom2.Element

fun Element.toName(): String {
    val result = getAttribute("name").value
    return if (result == "object") "`$result`" else result
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
    if (parent == "GObject.Object") return false
    if (parent == "NativeDialog") return false
    if (parent == "IMContext") return false
    if (parent?.startsWith("Gio") == true) return false

    return true
}

private fun String?.toTypeName(): TypeName {
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
        "guint" -> INT
        "guint16" -> SHORT
        "guint32" -> INT
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

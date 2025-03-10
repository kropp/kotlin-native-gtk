package gtk3

import kotlin.Unit
import kotlinx.cinterop.CPointer
import kotlinx.cinterop.reinterpret
import libgtk3.GtkInvisible
import libgtk3.GtkWidget
import libgtk3.gtk_invisible_new

inline fun Container.invisible(init: Invisible.() -> Unit = {}): Invisible =
        Invisible().apply { init(); this@invisible.add(this) }

/**
 * The #GtkInvisible widget is used internally in GTK+, and is probably not
 * very useful for application developers.
 *
 * It is used for reliable pointer grabs and selection handling in the code
 * for drag-and-drop.
 */
@GtkDsl
open class Invisible internal constructor(override val widgetPtr: CPointer<GtkWidget>? = null) :
        Widget() {
    private val self: CPointer<GtkInvisible>?
        get() = widgetPtr!!.reinterpret()

    val invisible: CPointer<GtkInvisible>?
        get() = widgetPtr!!.reinterpret()

    /**
     * Creates a new #GtkInvisible. */
    constructor() : this(gtk_invisible_new()?.reinterpret())
}

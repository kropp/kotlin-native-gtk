package gtk3

import kotlin.Unit
import kotlinx.cinterop.CPointer
import kotlinx.cinterop.reinterpret
import libgtk3.GtkOrientation
import libgtk3.GtkSeparator
import libgtk3.GtkWidget
import libgtk3.gtk_separator_new

inline fun Container.separator(orientation: GtkOrientation, init: Separator.() -> Unit = {}):
        Separator = Separator(orientation).apply { init(); this@separator.add(this) }

/**
 * GtkSeparator is a horizontal or vertical separator widget, depending on the
 * value of the #GtkOrientable:orientation property, used to group the widgets
 * within a window. It displays a line with a shadow to make it appear sunken
 * into the interface.
 *
 * # CSS nodes
 *
 * GtkSeparator has a single CSS node with name separator. The node
 * gets one of the .horizontal or .vertical style classes.
 */
@GtkDsl
open class Separator internal constructor(override val widgetPtr: CPointer<GtkWidget>? = null) :
        Widget() {
    private val self: CPointer<GtkSeparator>?
        get() = widgetPtr!!.reinterpret()

    val separator: CPointer<GtkSeparator>?
        get() = widgetPtr!!.reinterpret()

    /**
     * Creates a new #GtkSeparator with the given orientation. */
    constructor(orientation: GtkOrientation) : this(gtk_separator_new(orientation)?.reinterpret())
}

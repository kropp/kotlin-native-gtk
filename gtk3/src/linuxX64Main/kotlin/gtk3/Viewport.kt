package gtk3

import kotlin.Unit
import kotlinx.cinterop.CPointer
import kotlinx.cinterop.reinterpret
import libgtk3.GdkWindow
import libgtk3.GtkAdjustment
import libgtk3.GtkShadowType
import libgtk3.GtkViewport
import libgtk3.GtkWidget
import libgtk3.gtk_viewport_get_bin_window
import libgtk3.gtk_viewport_get_shadow_type
import libgtk3.gtk_viewport_get_view_window
import libgtk3.gtk_viewport_new
import libgtk3.gtk_viewport_set_shadow_type

inline fun Container.viewport(
    hadjustment: CPointer<GtkAdjustment>,
    vadjustment: CPointer<GtkAdjustment>,
    init: Viewport.() -> Unit = {}
): Viewport = Viewport(hadjustment, vadjustment).apply { init(); this@viewport.add(this) }

/**
 * The #GtkViewport widget acts as an adaptor class, implementing
 * scrollability for child widgets that lack their own scrolling
 * capabilities. Use GtkViewport to scroll child widgets such as
 * #GtkGrid, #GtkBox, and so on.
 *
 * If a widget has native scrolling abilities, such as #GtkTextView,
 * #GtkTreeView or #GtkIconView, it can be added to a #GtkScrolledWindow
 * with gtk_container_add(). If a widget does not, you must first add the
 * widget to a #GtkViewport, then add the viewport to the scrolled window.
 * gtk_container_add() does this automatically if a child that does not
 * implement #GtkScrollable is added to a #GtkScrolledWindow, so you can
 * ignore the presence of the viewport.
 *
 * The GtkViewport will start scrolling content only if allocated less
 * than the child widget’s minimum size in a given orientation.
 *
 * # CSS nodes
 *
 * GtkViewport has a single CSS node with name viewport.Gets the bin window of the #GtkViewport.Gets
        the view window of the #GtkViewport.
 */
@GtkDsl
open class Viewport internal constructor(override val widgetPtr: CPointer<GtkWidget>? = null) :
        Bin() {
    private val self: CPointer<GtkViewport>?
        get() = widgetPtr!!.reinterpret()

    val viewport: CPointer<GtkViewport>?
        get() = widgetPtr!!.reinterpret()

    val binWindow: CPointer<GdkWindow>
        get() = gtk_viewport_get_bin_window(self)!!.reinterpret()

    /**
     * Gets the shadow type of the #GtkViewport. See
     * gtk_viewport_set_shadow_type().
     *
     * Sets the shadow type of the viewport. */
    var shadowType: GtkShadowType
        get() = gtk_viewport_get_shadow_type(self)
        set(value) {
            gtk_viewport_set_shadow_type(self, value)
        }

    val viewWindow: CPointer<GdkWindow>
        get() = gtk_viewport_get_view_window(self)!!.reinterpret()

    /**
     * Creates a new #GtkViewport with the given adjustments, or with default
     * adjustments if none are given. */
    constructor(hadjustment: CPointer<GtkAdjustment>, vadjustment: CPointer<GtkAdjustment>) :
            this(gtk_viewport_new(hadjustment?.reinterpret(),
            vadjustment?.reinterpret())?.reinterpret())
}

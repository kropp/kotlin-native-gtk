package gtk3

import kotlin.Boolean
import kotlin.Int
import kotlin.Unit
import kotlinx.cinterop.CFunction
import kotlinx.cinterop.COpaquePointer
import kotlinx.cinterop.CPointed
import kotlinx.cinterop.CPointer
import kotlinx.cinterop.asStableRef
import kotlinx.cinterop.reinterpret
import kotlinx.cinterop.staticCFunction
import libgtk3.GdkRectangle
import libgtk3.GtkOverlay
import libgtk3.GtkWidget
import libgtk3.gtk_false
import libgtk3.gtk_overlay_add_overlay
import libgtk3.gtk_overlay_get_overlay_pass_through
import libgtk3.gtk_overlay_new
import libgtk3.gtk_overlay_reorder_overlay
import libgtk3.gtk_overlay_set_overlay_pass_through
import libgtk3.gtk_true

inline fun Container.overlay(init: Overlay.() -> Unit = {}): Overlay = Overlay().apply { init();
        this@overlay.add(this) }

private fun Overlay_onGetChildPosition_Handler(
    sender: CPointer<in CPointed>?,
    widget: CPointer<GtkWidget>,
    allocation: CPointer<GdkRectangle>,
    _data: COpaquePointer?
) {
    _data?.asStableRef<Overlay>()?.get()?.onGetChildPosition?.emit(widget?.reinterpret(),
            allocation?.reinterpret())
}

/**
 * GtkOverlay is a container which contains a single main child, on top
 * of which it can place “overlay” widgets. The position of each overlay
 * widget is determined by its #GtkWidget:halign and #GtkWidget:valign
 * properties. E.g. a widget with both alignments set to %GTK_ALIGN_START
 * will be placed at the top left corner of the GtkOverlay container,
 * whereas an overlay with halign set to %GTK_ALIGN_CENTER and valign set
 * to %GTK_ALIGN_END will be placed a the bottom edge of the GtkOverlay,
 * horizontally centered. The position can be adjusted by setting the margin
 * properties of the child to non-zero values.
 *
 * More complicated placement of overlays is possible by connecting
 * to the #GtkOverlay::get-child-position signal.
 *
 * # GtkOverlay as GtkBuildable
 *
 * The GtkOverlay implementation of the GtkBuildable interface
 * supports placing a child as an overlay by specifying “overlay” as
 * the “type” attribute of a `<child>` element.
 *
 * # CSS nodes
 *
 * GtkOverlay has a single CSS node with the name “overlay”. Overlay children
 * whose alignments cause them to be positioned at an edge get the style classes
 * “.left”, “.right”, “.top”, and/or “.bottom” according to their position.
 */
@GtkDsl
open class Overlay internal constructor(override val widgetPtr: CPointer<GtkWidget>? = null) : Bin()
        {
    private val self: CPointer<GtkOverlay>?
        get() = widgetPtr!!.reinterpret()

    val overlay: CPointer<GtkOverlay>?
        get() = widgetPtr!!.reinterpret()

    val onGetChildPosition: Signal2<Overlay, CPointer<GtkWidget>, CPointer<GdkRectangle>,
            CFunction<(
        CPointer<in CPointed>?,
        CPointer<GtkWidget>,
        CPointer<GdkRectangle>,
        COpaquePointer?
    ) -> Unit>> by lazy { Signal2<Overlay, CPointer<GtkWidget>, CPointer<GdkRectangle>, CFunction<(
                CPointer<in CPointed>?,
                CPointer<GtkWidget>,
                CPointer<GdkRectangle>,
                COpaquePointer?
            ) -> Unit>>(widgetPtr!!, this, "get-child-position",
                    staticCFunction(::Overlay_onGetChildPosition_Handler)) }

    /**
     * Creates a new #GtkOverlay. */
    constructor() : this(gtk_overlay_new()?.reinterpret())

    /**
     * Adds @widget to @overlay.
     *
     * The widget will be stacked on top of the main widget
     * added with gtk_container_add().
     *
     * The position at which @widget is placed is determined
     * from its #GtkWidget:halign and #GtkWidget:valign properties.
     */
    fun addOverlay(widget: CPointer<GtkWidget>): Unit = gtk_overlay_add_overlay(self, widget)

    /**
     * Adds @widget to @overlay.
     *
     * The widget will be stacked on top of the main widget
     * added with gtk_container_add().
     *
     * The position at which @widget is placed is determined
     * from its #GtkWidget:halign and #GtkWidget:valign properties.
     */
    fun addOverlay(widget: Widget): Unit = gtk_overlay_add_overlay(self,
            widget.widgetPtr?.reinterpret())

    /**
     * Convenience function to get the value of the #GtkOverlay:pass-through
     * child property for @widget.
     */
    fun getOverlayPassThrough(widget: CPointer<GtkWidget>): Boolean =
            gtk_overlay_get_overlay_pass_through(self, widget) != 0

    /**
     * Convenience function to get the value of the #GtkOverlay:pass-through
     * child property for @widget.
     */
    fun getOverlayPassThrough(widget: Widget): Boolean = gtk_overlay_get_overlay_pass_through(self,
            widget.widgetPtr?.reinterpret()) != 0

    /**
     * Moves @child to a new @index in the list of @overlay children.
     * The list contains overlays in the order that these were
     * added to @overlay.
     *
     * A widget’s index in the @overlay children list determines which order
     * the children are drawn if they overlap. The first child is drawn at
     * the bottom. It also affects the default focus chain order.
     */
    fun reorderOverlay(child: CPointer<GtkWidget>, position: Int): Unit =
            gtk_overlay_reorder_overlay(self, child, position)

    /**
     * Moves @child to a new @index in the list of @overlay children.
     * The list contains overlays in the order that these were
     * added to @overlay.
     *
     * A widget’s index in the @overlay children list determines which order
     * the children are drawn if they overlap. The first child is drawn at
     * the bottom. It also affects the default focus chain order.
     */
    fun reorderOverlay(child: Widget, position: Int): Unit = gtk_overlay_reorder_overlay(self,
            child.widgetPtr?.reinterpret(), position)

    /**
     * Convenience function to set the value of the #GtkOverlay:pass-through
     * child property for @widget.
     */
    fun setOverlayPassThrough(widget: CPointer<GtkWidget>, pass_through: Boolean): Unit =
            gtk_overlay_set_overlay_pass_through(self, widget,
            if (pass_through) gtk_true() else gtk_false())

    /**
     * Convenience function to set the value of the #GtkOverlay:pass-through
     * child property for @widget.
     */
    fun setOverlayPassThrough(widget: Widget, pass_through: Boolean): Unit =
            gtk_overlay_set_overlay_pass_through(self, widget.widgetPtr?.reinterpret(),
            if (pass_through) gtk_true() else gtk_false())
}

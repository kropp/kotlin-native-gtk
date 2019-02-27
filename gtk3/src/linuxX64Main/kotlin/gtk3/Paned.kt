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
import libgtk3.GdkWindow
import libgtk3.GtkOrientation
import libgtk3.GtkPaned
import libgtk3.GtkWidget
import libgtk3.gtk_false
import libgtk3.gtk_paned_add1
import libgtk3.gtk_paned_add2
import libgtk3.gtk_paned_get_child1
import libgtk3.gtk_paned_get_child2
import libgtk3.gtk_paned_get_handle_window
import libgtk3.gtk_paned_get_position
import libgtk3.gtk_paned_get_wide_handle
import libgtk3.gtk_paned_new
import libgtk3.gtk_paned_pack1
import libgtk3.gtk_paned_pack2
import libgtk3.gtk_paned_set_position
import libgtk3.gtk_paned_set_wide_handle
import libgtk3.gtk_true

inline fun Container.paned(orientation: GtkOrientation, init: Paned.() -> Unit = {}): Paned =
        Paned(orientation).apply { init(); this@paned.add(this) }

private fun Paned_onAcceptPosition_Handler(sender: CPointer<in CPointed>?, _data: COpaquePointer?) {
    _data?.asStableRef<Paned>()?.get()?.onAcceptPosition?.emit()
}

private fun Paned_onCancelPosition_Handler(sender: CPointer<in CPointed>?, _data: COpaquePointer?) {
    _data?.asStableRef<Paned>()?.get()?.onCancelPosition?.emit()
}

private fun Paned_onCycleChildFocus_Handler(
    sender: CPointer<in CPointed>?,
    reversed: Boolean,
    _data: COpaquePointer?
) {
    _data?.asStableRef<Paned>()?.get()?.onCycleChildFocus?.emit(reversed)
}

private fun Paned_onCycleHandleFocus_Handler(
    sender: CPointer<in CPointed>?,
    reversed: Boolean,
    _data: COpaquePointer?
) {
    _data?.asStableRef<Paned>()?.get()?.onCycleHandleFocus?.emit(reversed)
}

private fun Paned_onToggleHandleFocus_Handler(sender: CPointer<in CPointed>?, _data:
        COpaquePointer?) {
    _data?.asStableRef<Paned>()?.get()?.onToggleHandleFocus?.emit()
}

/**
 * #GtkPaned has two panes, arranged either
 * horizontally or vertically. The division between
 * the two panes is adjustable by the user by dragging
 * a handle.
 *
 * Child widgets are
 * added to the panes of the widget with gtk_paned_pack1() and
 * gtk_paned_pack2(). The division between the two children is set by default
 * from the size requests of the children, but it can be adjusted by the
 * user.
 *
 * A paned widget draws a separator between the two child widgets and a
 * small handle that the user can drag to adjust the division. It does not
 * draw any relief around the children or around the separator. (The space
 * in which the separator is called the gutter.) Often, it is useful to put
 * each child inside a #GtkFrame with the shadow type set to %GTK_SHADOW_IN
 * so that the gutter appears as a ridge. No separator is drawn if one of
 * the children is missing.
 *
 * Each child has two options that can be set, @resize and @shrink. If
 * @resize is true, then when the #GtkPaned is resized, that child will
 * expand or shrink along with the paned widget. If @shrink is true, then
 * that child can be made smaller than its requisition by the user.
 * Setting @shrink to %FALSE allows the application to set a minimum size.
 * If @resize is false for both children, then this is treated as if
 * @resize is true for both children.
 *
 * The application can set the position of the slider as if it were set
 * by the user, by calling gtk_paned_set_position().
 *
 * # CSS nodes
 *
 * |[<!-- language="plain" -->
 * paned
 * ├── <child>
 * ├── separator[.wide]
 * ╰── <child>
 * ]|
 *
 * GtkPaned has a main CSS node with name paned, and a subnode for
 * the separator with name separator. The subnode gets a .wide style
 * class when the paned is supposed to be wide.
 *
 * In horizontal orientation, the nodes of the children are always arranged
 * from left to right. So :first-child will always select the leftmost child,
 * regardless of text direction.
 *
 * ## Creating a paned widget with minimum sizes.
 *
 * |[<!-- language="C" -->
 * GtkWidget *hpaned = gtk_paned_new (GTK_ORIENTATION_HORIZONTAL);
 * GtkWidget *frame1 = gtk_frame_new (NULL);
 * GtkWidget *frame2 = gtk_frame_new (NULL);
 * gtk_frame_set_shadow_type (GTK_FRAME (frame1), GTK_SHADOW_IN);
 * gtk_frame_set_shadow_type (GTK_FRAME (frame2), GTK_SHADOW_IN);
 *
 * gtk_widget_set_size_request (hpaned, 200, -1);
 *
 * gtk_paned_pack1 (GTK_PANED (hpaned), frame1, TRUE, FALSE);
 * gtk_widget_set_size_request (frame1, 50, -1);
 *
 * gtk_paned_pack2 (GTK_PANED (hpaned), frame2, FALSE, FALSE);
 * gtk_widget_set_size_request (frame2, 50, -1);
 * ]|Obtains the first child of the paned widget.Obtains the second child of the paned
        widget.Returns the #GdkWindow of the handle. This function is
 * useful when handling button or motion events because it
 * enables the callback to distinguish between the window
 * of the paned, a child and the handle.
 */
@GtkDsl
open class Paned internal constructor(override val widgetPtr: CPointer<GtkWidget>? = null) :
        Container() {
    private val self: CPointer<GtkPaned>?
        get() = widgetPtr!!.reinterpret()

    val paned: CPointer<GtkPaned>?
        get() = widgetPtr!!.reinterpret()

    val onAcceptPosition: Signal<Paned, CFunction<(CPointer<in CPointed>?, COpaquePointer?) ->
            Unit>> by lazy { Signal<Paned, CFunction<(CPointer<in CPointed>?, COpaquePointer?) ->
            Unit>>(widgetPtr!!, this, "accept-position",
            staticCFunction(::Paned_onAcceptPosition_Handler)) }

    val onCancelPosition: Signal<Paned, CFunction<(CPointer<in CPointed>?, COpaquePointer?) ->
            Unit>> by lazy { Signal<Paned, CFunction<(CPointer<in CPointed>?, COpaquePointer?) ->
            Unit>>(widgetPtr!!, this, "cancel-position",
            staticCFunction(::Paned_onCancelPosition_Handler)) }

    val onCycleChildFocus: Signal1<Paned, Boolean, CFunction<(
        CPointer<in CPointed>?,
        Boolean,
        COpaquePointer?
    ) -> Unit>> by lazy { Signal1<Paned, Boolean, CFunction<(
                CPointer<in CPointed>?,
                Boolean,
                COpaquePointer?
            ) -> Unit>>(widgetPtr!!, this, "cycle-child-focus",
                    staticCFunction(::Paned_onCycleChildFocus_Handler)) }

    val onCycleHandleFocus: Signal1<Paned, Boolean, CFunction<(
        CPointer<in CPointed>?,
        Boolean,
        COpaquePointer?
    ) -> Unit>> by lazy { Signal1<Paned, Boolean, CFunction<(
                CPointer<in CPointed>?,
                Boolean,
                COpaquePointer?
            ) -> Unit>>(widgetPtr!!, this, "cycle-handle-focus",
                    staticCFunction(::Paned_onCycleHandleFocus_Handler)) }

    val onToggleHandleFocus: Signal<Paned, CFunction<(CPointer<in CPointed>?, COpaquePointer?) ->
            Unit>> by lazy { Signal<Paned, CFunction<(CPointer<in CPointed>?, COpaquePointer?) ->
            Unit>>(widgetPtr!!, this, "toggle-handle-focus",
            staticCFunction(::Paned_onToggleHandleFocus_Handler)) }

    val child1: CPointer<GtkWidget>
        get() = gtk_paned_get_child1(self)!!.reinterpret()

    val child2: CPointer<GtkWidget>
        get() = gtk_paned_get_child2(self)!!.reinterpret()

    val handleWindow: CPointer<GdkWindow>
        get() = gtk_paned_get_handle_window(self)!!.reinterpret()

    /**
     * Obtains the position of the divider between the two panes.
     *
     * Sets the position of the divider between the two panes. */
    var position: Int
        get() = gtk_paned_get_position(self)
        set(value) {
            gtk_paned_set_position(self, value)
        }

    /**
     * Gets the #GtkPaned:wide-handle property.
     *
     * Sets the #GtkPaned:wide-handle property. */
    var wideHandle: Boolean
        get() = gtk_paned_get_wide_handle(self) != 0
        set(value) {
            gtk_paned_set_wide_handle(self, if (value) gtk_true() else gtk_false())
        }

    /**
     * Creates a new #GtkPaned widget. */
    constructor(orientation: GtkOrientation) : this(gtk_paned_new(orientation)?.reinterpret())

    /**
     * Adds a child to the top or left pane with default parameters. This is
     * equivalent to
     * `gtk_paned_pack1 (paned, child, FALSE, TRUE)`.
     */
    fun add1(child: CPointer<GtkWidget>): Unit = gtk_paned_add1(self, child)

    /**
     * Adds a child to the top or left pane with default parameters. This is
     * equivalent to
     * `gtk_paned_pack1 (paned, child, FALSE, TRUE)`.
     */
    fun add1(child: Widget): Unit = gtk_paned_add1(self, child.widgetPtr?.reinterpret())

    /**
     * Adds a child to the bottom or right pane with default parameters. This
     * is equivalent to
     * `gtk_paned_pack2 (paned, child, TRUE, TRUE)`.
     */
    fun add2(child: CPointer<GtkWidget>): Unit = gtk_paned_add2(self, child)

    /**
     * Adds a child to the bottom or right pane with default parameters. This
     * is equivalent to
     * `gtk_paned_pack2 (paned, child, TRUE, TRUE)`.
     */
    fun add2(child: Widget): Unit = gtk_paned_add2(self, child.widgetPtr?.reinterpret())

    /**
     * Adds a child to the top or left pane.
     */
    fun pack1(
        child: CPointer<GtkWidget>,
        resize: Boolean,
        shrink: Boolean
    ): Unit = gtk_paned_pack1(self, child, if (resize) gtk_true() else gtk_false(),
            if (shrink) gtk_true() else gtk_false())

    /**
     * Adds a child to the top or left pane.
     */
    fun pack1(
        child: Widget,
        resize: Boolean,
        shrink: Boolean
    ): Unit = gtk_paned_pack1(self, child.widgetPtr?.reinterpret(),
            if (resize) gtk_true() else gtk_false(), if (shrink) gtk_true() else gtk_false())

    /**
     * Adds a child to the bottom or right pane.
     */
    fun pack2(
        child: CPointer<GtkWidget>,
        resize: Boolean,
        shrink: Boolean
    ): Unit = gtk_paned_pack2(self, child, if (resize) gtk_true() else gtk_false(),
            if (shrink) gtk_true() else gtk_false())

    /**
     * Adds a child to the bottom or right pane.
     */
    fun pack2(
        child: Widget,
        resize: Boolean,
        shrink: Boolean
    ): Unit = gtk_paned_pack2(self, child.widgetPtr?.reinterpret(),
            if (resize) gtk_true() else gtk_false(), if (shrink) gtk_true() else gtk_false())
}

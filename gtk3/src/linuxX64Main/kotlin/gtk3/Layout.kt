package gtk3

import kotlin.Int
import kotlin.UInt
import kotlin.Unit
import kotlinx.cinterop.CPointer
import kotlinx.cinterop.reinterpret
import libgtk3.GdkWindow
import libgtk3.GtkAdjustment
import libgtk3.GtkLayout
import libgtk3.GtkWidget
import libgtk3.gtk_layout_get_bin_window
import libgtk3.gtk_layout_move
import libgtk3.gtk_layout_new
import libgtk3.gtk_layout_put
import libgtk3.gtk_layout_set_size

inline fun Container.layout(
    hadjustment: CPointer<GtkAdjustment>,
    vadjustment: CPointer<GtkAdjustment>,
    init: Layout.() -> Unit = {}
): Layout = Layout(hadjustment, vadjustment).apply { init(); this@layout.add(this) }

/**
 * #GtkLayout is similar to #GtkDrawingArea in that it’s a “blank slate” and
 * doesn’t do anything except paint a blank background by default. It’s
 * different in that it supports scrolling natively due to implementing
 * #GtkScrollable, and can contain child widgets since it’s a #GtkContainer.
 *
 * If you just want to draw, a #GtkDrawingArea is a better choice since it has
 * lower overhead. If you just need to position child widgets at specific
 * points, then #GtkFixed provides that functionality on its own.
 *
 * When handling expose events on a #GtkLayout, you must draw to the #GdkWindow
 * returned by gtk_layout_get_bin_window(), rather than to the one returned by
 * gtk_widget_get_window() as you would for a #GtkDrawingArea.Retrieve the bin window of the layout
        used for drawing operations.
 */
@GtkDsl
open class Layout internal constructor(override val widgetPtr: CPointer<GtkWidget>? = null) :
        Container() {
    private val self: CPointer<GtkLayout>?
        get() = widgetPtr!!.reinterpret()

    val layout: CPointer<GtkLayout>?
        get() = widgetPtr!!.reinterpret()

    val binWindow: CPointer<GdkWindow>
        get() = gtk_layout_get_bin_window(self)!!.reinterpret()

    /**
     * Creates a new #GtkLayout. Unless you have a specific adjustment
     * you’d like the layout to use for scrolling, pass %NULL for
     * @hadjustment and @vadjustment. */
    constructor(hadjustment: CPointer<GtkAdjustment>, vadjustment: CPointer<GtkAdjustment>) :
            this(gtk_layout_new(hadjustment?.reinterpret(),
            vadjustment?.reinterpret())?.reinterpret())

    /**
     * Moves a current child of @layout to a new position.
     */
    fun move(
        child_widget: CPointer<GtkWidget>,
        x: Int,
        y: Int
    ): Unit = gtk_layout_move(self, child_widget, x, y)

    /**
     * Moves a current child of @layout to a new position.
     */
    fun move(
        child_widget: Widget,
        x: Int,
        y: Int
    ): Unit = gtk_layout_move(self, child_widget.widgetPtr?.reinterpret(), x, y)

    /**
     * Adds @child_widget to @layout, at position (@x,@y).
     * @layout becomes the new parent container of @child_widget.
     */
    fun put(
        child_widget: CPointer<GtkWidget>,
        x: Int,
        y: Int
    ): Unit = gtk_layout_put(self, child_widget, x, y)

    /**
     * Adds @child_widget to @layout, at position (@x,@y).
     * @layout becomes the new parent container of @child_widget.
     */
    fun put(
        child_widget: Widget,
        x: Int,
        y: Int
    ): Unit = gtk_layout_put(self, child_widget.widgetPtr?.reinterpret(), x, y)

    /**
     * Sets the size of the scrollable area of the layout.
     */
    fun setSize(width: UInt, height: UInt): Unit = gtk_layout_set_size(self, width, height)
}

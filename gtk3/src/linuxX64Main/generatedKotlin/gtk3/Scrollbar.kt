package gtk3

import kotlin.Unit
import kotlinx.cinterop.CPointer
import kotlinx.cinterop.reinterpret
import libgtk3.GtkAdjustment
import libgtk3.GtkOrientation
import libgtk3.GtkScrollbar
import libgtk3.GtkWidget
import libgtk3.gtk_scrollbar_new

inline fun Container.scrollbar(
    orientation: GtkOrientation,
    adjustment: CPointer<GtkAdjustment>,
    init: Scrollbar.() -> Unit = {}
): Scrollbar = Scrollbar(orientation, adjustment).apply { init(); this@scrollbar.add(this) }

/**
 * The #GtkScrollbar widget is a horizontal or vertical scrollbar,
 * depending on the value of the #GtkOrientable:orientation property.
 *
 * Its position and movement are controlled by the adjustment that is passed to
 * or created by gtk_scrollbar_new(). See #GtkAdjustment for more details. The
 * #GtkAdjustment:value field sets the position of the thumb and must be between
 * #GtkAdjustment:lower and #GtkAdjustment:upper - #GtkAdjustment:page-size. The
 * #GtkAdjustment:page-size represents the size of the visible scrollable area.
 * The fields #GtkAdjustment:step-increment and #GtkAdjustment:page-increment
 * fields are added to or subtracted from the #GtkAdjustment:value when the user
 * asks to move by a step (using e.g. the cursor arrow keys or, if present, the
 * stepper buttons) or by a page (using e.g. the Page Down/Up keys).
 *
 * # CSS nodes
 *
 * |[<!-- language="plain" -->
 * scrollbar[.fine-tune]
 * ╰── contents
 *     ├── [button.up]
 *     ├── [button.down]
 *     ├── trough
 *     │   ╰── slider
 *     ├── [button.up]
 *     ╰── [button.down]
 * ]|
 *
 * GtkScrollbar has a main CSS node with name scrollbar and a subnode for its
 * contents, with subnodes named trough and slider.
 *
 * The main node gets the style class .fine-tune added when the scrollbar is
 * in 'fine-tuning' mode.
 *
 * If steppers are enabled, they are represented by up to four additional
 * subnodes with name button. These get the style classes .up and .down to
 * indicate in which direction they are moving.
 *
 * Other style classes that may be added to scrollbars inside #GtkScrolledWindow
 * include the positional classes (.left, .right, .top, .bottom) and style
 * classes related to overlay scrolling (.overlay-indicator, .dragging, .hovering).
 */
@GtkDsl
open class Scrollbar internal constructor(override val widgetPtr: CPointer<GtkWidget>? = null) :
        Range() {
    private val self: CPointer<GtkScrollbar>?
        get() = widgetPtr!!.reinterpret()

    val scrollbar: CPointer<GtkScrollbar>?
        get() = widgetPtr!!.reinterpret()

    /**
     * Creates a new scrollbar with the given orientation. */
    constructor(orientation: GtkOrientation, adjustment: CPointer<GtkAdjustment>) :
            this(gtk_scrollbar_new(orientation, adjustment?.reinterpret())?.reinterpret())
}

package gtk3

import kotlin.Boolean
import kotlin.Int
import kotlin.Unit
import kotlinx.cinterop.CPointer
import kotlinx.cinterop.asStableRef
import kotlinx.cinterop.reinterpret
import kotlinx.cinterop.staticCFunction
import libgtk3.GtkAdjustment
import libgtk3.GtkCornerType
import libgtk3.GtkPolicyType
import libgtk3.GtkScrolledWindow
import libgtk3.GtkShadowType
import libgtk3.GtkWidget
import libgtk3.gtk_false
import libgtk3.gtk_scrolled_window_get_capture_button_press
import libgtk3.gtk_scrolled_window_get_hadjustment
import libgtk3.gtk_scrolled_window_get_hscrollbar
import libgtk3.gtk_scrolled_window_get_kinetic_scrolling
import libgtk3.gtk_scrolled_window_get_max_content_height
import libgtk3.gtk_scrolled_window_get_max_content_width
import libgtk3.gtk_scrolled_window_get_min_content_height
import libgtk3.gtk_scrolled_window_get_min_content_width
import libgtk3.gtk_scrolled_window_get_overlay_scrolling
import libgtk3.gtk_scrolled_window_get_placement
import libgtk3.gtk_scrolled_window_get_propagate_natural_height
import libgtk3.gtk_scrolled_window_get_propagate_natural_width
import libgtk3.gtk_scrolled_window_get_shadow_type
import libgtk3.gtk_scrolled_window_get_vadjustment
import libgtk3.gtk_scrolled_window_get_vscrollbar
import libgtk3.gtk_scrolled_window_new
import libgtk3.gtk_scrolled_window_set_capture_button_press
import libgtk3.gtk_scrolled_window_set_hadjustment
import libgtk3.gtk_scrolled_window_set_kinetic_scrolling
import libgtk3.gtk_scrolled_window_set_max_content_height
import libgtk3.gtk_scrolled_window_set_max_content_width
import libgtk3.gtk_scrolled_window_set_min_content_height
import libgtk3.gtk_scrolled_window_set_min_content_width
import libgtk3.gtk_scrolled_window_set_overlay_scrolling
import libgtk3.gtk_scrolled_window_set_placement
import libgtk3.gtk_scrolled_window_set_policy
import libgtk3.gtk_scrolled_window_set_propagate_natural_height
import libgtk3.gtk_scrolled_window_set_propagate_natural_width
import libgtk3.gtk_scrolled_window_set_shadow_type
import libgtk3.gtk_scrolled_window_set_vadjustment
import libgtk3.gtk_scrolled_window_unset_placement
import libgtk3.gtk_true

inline fun Container.scrolledWindow(
    hadjustment: CPointer<GtkAdjustment>?,
    vadjustment: CPointer<GtkAdjustment>?,
    init: ScrolledWindow.() -> Unit = {}
): ScrolledWindow = ScrolledWindow(hadjustment, vadjustment).apply { init();
        this@scrolledWindow.add(this) }

/**
 * GtkScrolledWindow is a container that accepts a single child widget, makes
 * that child scrollable using either internally added scrollbars or externally
 * associated adjustments, and optionally draws a frame around the child.
 *
 * Widgets with native scrolling support, i.e. those whose classes implement the
 * #GtkScrollable interface, are added directly. For other types of widget, the
 * class #GtkViewport acts as an adaptor, giving scrollability to other widgets.
 * GtkScrolledWindow’s implementation of gtk_container_add() intelligently
 * accounts for whether or not the added child is a #GtkScrollable. If it isn’t,
 * #GtkScrolledWindow wraps the child in a #GtkViewport and adds that for you.
 * Therefore, you can just add any child widget and not worry about the details.
 *
 * If gtk_container_add() has added a #GtkViewport for you, you can remove
 * both your added child widget from the #GtkViewport, and the #GtkViewport
 * from the GtkScrolledWindow, like this:
 *
 * |[<!-- language="C" -->
 * GtkWidget *scrolled_window = gtk_scrolled_window_new (NULL, NULL);
 * GtkWidget *child_widget = gtk_button_new ();
 *
 * // GtkButton is not a GtkScrollable, so GtkScrolledWindow will automatically
 * // add a GtkViewport.
 * gtk_container_add (GTK_CONTAINER (scrolled_window),
 *                    child_widget);
 *
 * // Either of these will result in child_widget being unparented:
 * gtk_container_remove (GTK_CONTAINER (scrolled_window),
 *                       child_widget);
 * // or
 * gtk_container_remove (GTK_CONTAINER (scrolled_window),
 *                       gtk_bin_get_child (GTK_BIN (scrolled_window)));
 * ]|
 *
 * Unless #GtkScrolledWindow:policy is GTK_POLICY_NEVER or GTK_POLICY_EXTERNAL,
 * GtkScrolledWindow adds internal #GtkScrollbar widgets around its child. The
 * scroll position of the child, and if applicable the scrollbars, is controlled
 * by the #GtkScrolledWindow:hadjustment and #GtkScrolledWindow:vadjustment
 * that are associated with the GtkScrolledWindow. See the docs on #GtkScrollbar
 * for the details, but note that the “step_increment” and “page_increment”
 * fields are only effective if the policy causes scrollbars to be present.
 *
 * If a GtkScrolledWindow doesn’t behave quite as you would like, or
 * doesn’t have exactly the right layout, it’s very possible to set up
 * your own scrolling with #GtkScrollbar and for example a #GtkGrid.
 *
 * # Touch support
 *
 * GtkScrolledWindow has built-in support for touch devices. When a
 * touchscreen is used, swiping will move the scrolled window, and will
 * expose 'kinetic' behavior. This can be turned off with the
 * #GtkScrolledWindow:kinetic-scrolling property if it is undesired.
 *
 * GtkScrolledWindow also displays visual 'overshoot' indication when
 * the content is pulled beyond the end, and this situation can be
 * captured with the #GtkScrolledWindow::edge-overshot signal.
 *
 * If no mouse device is present, the scrollbars will overlayed as
 * narrow, auto-hiding indicators over the content. If traditional
 * scrollbars are desired although no mouse is present, this behaviour
 * can be turned off with the #GtkScrolledWindow:overlay-scrolling
 * property.
 *
 * # CSS nodes
 *
 * GtkScrolledWindow has a main CSS node with name scrolledwindow.
 *
 * It uses subnodes with names overshoot and undershoot to
 * draw the overflow and underflow indications. These nodes get
 * the .left, .right, .top or .bottom style class added depending
 * on where the indication is drawn.
 *
 * GtkScrolledWindow also sets the positional style classes (.left,
 * .right, .top, .bottom) and style classes related to overlay
 * scrolling (.overlay-indicator, .dragging, .hovering) on its scrollbars.
 *
 * If both scrollbars are visible, the area where they meet is drawn
 * with a subnode named junction.Returns the horizontal scrollbar of @scrolled_window.Returns the
        vertical scrollbar of @scrolled_window.
 */
@GtkDsl
open class ScrolledWindow internal constructor(override val widgetPtr: CPointer<GtkWidget>? = null)
        : Bin() {
    private val self: CPointer<GtkScrolledWindow>?
        get() = widgetPtr!!.reinterpret()

    val scrolledWindow: CPointer<GtkScrolledWindow>?
        get() = widgetPtr!!.reinterpret()

    /**
     * Return whether button presses are captured during kinetic
     * scrolling. See gtk_scrolled_window_set_capture_button_press().
     *
     * Changes the behaviour of @scrolled_window with regard to the initial
     * event that possibly starts kinetic scrolling. When @capture_button_press
     * is set to %TRUE, the event is captured by the scrolled window, and
     * then later replayed if it is meant to go to the child widget.
     *
     * This should be enabled if any child widgets perform non-reversible
     * actions on #GtkWidget::button-press-event. If they don't, and handle
     * additionally handle #GtkWidget::grab-broken-event, it might be better
     * to set @capture_button_press to %FALSE.
     *
     * This setting only has an effect if kinetic scrolling is enabled. */
    var captureButtonPress: Boolean
        get() = gtk_scrolled_window_get_capture_button_press(self) != 0
        set(value) {
            gtk_scrolled_window_set_capture_button_press(self,
                    if (value) gtk_true() else gtk_false())
        }

    /**
     * Returns the horizontal scrollbar’s adjustment, used to connect the
     * horizontal scrollbar to the child widget’s horizontal scroll
     * functionality.
     *
     * Sets the #GtkAdjustment for the horizontal scrollbar. */
    var hadjustment: CPointer<GtkAdjustment>
        get() = gtk_scrolled_window_get_hadjustment(self)!!.reinterpret()
        set(value) {
            gtk_scrolled_window_set_hadjustment(self, value?.reinterpret())
        }

    val hscrollbar: CPointer<GtkWidget>
        get() = gtk_scrolled_window_get_hscrollbar(self)!!.reinterpret()

    /**
     * Returns the specified kinetic scrolling behavior.
     *
     * Turns kinetic scrolling on or off.
     * Kinetic scrolling only applies to devices with source
     * %GDK_SOURCE_TOUCHSCREEN. */
    var kineticScrolling: Boolean
        get() = gtk_scrolled_window_get_kinetic_scrolling(self) != 0
        set(value) {
            gtk_scrolled_window_set_kinetic_scrolling(self, if (value) gtk_true() else gtk_false())
        }

    /**
     * Returns the maximum content height set.
     *
     * Sets the maximum height that @scrolled_window should keep visible. The
     * @scrolled_window will grow up to this height before it starts scrolling
     * the content.
     *
     * It is a programming error to set the maximum content height to a value
     * smaller than #GtkScrolledWindow:min-content-height. */
    var maxContentHeight: Int
        get() = gtk_scrolled_window_get_max_content_height(self)
        set(value) {
            gtk_scrolled_window_set_max_content_height(self, value)
        }

    /**
     * Returns the maximum content width set.
     *
     * Sets the maximum width that @scrolled_window should keep visible. The
     * @scrolled_window will grow up to this width before it starts scrolling
     * the content.
     *
     * It is a programming error to set the maximum content width to a value
     * smaller than #GtkScrolledWindow:min-content-width. */
    var maxContentWidth: Int
        get() = gtk_scrolled_window_get_max_content_width(self)
        set(value) {
            gtk_scrolled_window_set_max_content_width(self, value)
        }

    /**
     * Gets the minimal content height of @scrolled_window, or -1 if not set.
     *
     * Sets the minimum height that @scrolled_window should keep visible.
     * Note that this can and (usually will) be smaller than the minimum
     * size of the content.
     *
     * It is a programming error to set the minimum content height to a
     * value greater than #GtkScrolledWindow:max-content-height. */
    var minContentHeight: Int
        get() = gtk_scrolled_window_get_min_content_height(self)
        set(value) {
            gtk_scrolled_window_set_min_content_height(self, value)
        }

    /**
     * Gets the minimum content width of @scrolled_window, or -1 if not set.
     *
     * Sets the minimum width that @scrolled_window should keep visible.
     * Note that this can and (usually will) be smaller than the minimum
     * size of the content.
     *
     * It is a programming error to set the minimum content width to a
     * value greater than #GtkScrolledWindow:max-content-width. */
    var minContentWidth: Int
        get() = gtk_scrolled_window_get_min_content_width(self)
        set(value) {
            gtk_scrolled_window_set_min_content_width(self, value)
        }

    /**
     * Returns whether overlay scrolling is enabled for this scrolled window.
     *
     * Enables or disables overlay scrolling for this scrolled window. */
    var overlayScrolling: Boolean
        get() = gtk_scrolled_window_get_overlay_scrolling(self) != 0
        set(value) {
            gtk_scrolled_window_set_overlay_scrolling(self, if (value) gtk_true() else gtk_false())
        }

    /**
     * Gets the placement of the contents with respect to the scrollbars
     * for the scrolled window. See gtk_scrolled_window_set_placement().
     *
     * Sets the placement of the contents with respect to the scrollbars
     * for the scrolled window.
     *
     * The default is %GTK_CORNER_TOP_LEFT, meaning the child is
     * in the top left, with the scrollbars underneath and to the right.
     * Other values in #GtkCornerType are %GTK_CORNER_TOP_RIGHT,
     * %GTK_CORNER_BOTTOM_LEFT, and %GTK_CORNER_BOTTOM_RIGHT.
     *
     * See also gtk_scrolled_window_get_placement() and
     * gtk_scrolled_window_unset_placement(). */
    var placement: GtkCornerType
        get() = gtk_scrolled_window_get_placement(self)
        set(value) {
            gtk_scrolled_window_set_placement(self, value)
        }

    /**
     * Reports whether the natural height of the child will be calculated and propagated
     * through the scrolled window’s requested natural height.
     *
     * Sets whether the natural height of the child should be calculated and propagated
     * through the scrolled window’s requested natural height. */
    var propagateNaturalHeight: Boolean
        get() = gtk_scrolled_window_get_propagate_natural_height(self) != 0
        set(value) {
            gtk_scrolled_window_set_propagate_natural_height(self,
                    if (value) gtk_true() else gtk_false())
        }

    /**
     * Reports whether the natural width of the child will be calculated and propagated
     * through the scrolled window’s requested natural width.
     *
     * Sets whether the natural width of the child should be calculated and propagated
     * through the scrolled window’s requested natural width. */
    var propagateNaturalWidth: Boolean
        get() = gtk_scrolled_window_get_propagate_natural_width(self) != 0
        set(value) {
            gtk_scrolled_window_set_propagate_natural_width(self,
                    if (value) gtk_true() else gtk_false())
        }

    /**
     * Gets the shadow type of the scrolled window. See
     * gtk_scrolled_window_set_shadow_type().
     *
     * Changes the type of shadow drawn around the contents of
     * @scrolled_window. */
    var shadowType: GtkShadowType
        get() = gtk_scrolled_window_get_shadow_type(self)
        set(value) {
            gtk_scrolled_window_set_shadow_type(self, value)
        }

    /**
     * Returns the vertical scrollbar’s adjustment, used to connect the
     * vertical scrollbar to the child widget’s vertical scroll functionality.
     *
     * Sets the #GtkAdjustment for the vertical scrollbar. */
    var vadjustment: CPointer<GtkAdjustment>
        get() = gtk_scrolled_window_get_vadjustment(self)!!.reinterpret()
        set(value) {
            gtk_scrolled_window_set_vadjustment(self, value?.reinterpret())
        }

    val vscrollbar: CPointer<GtkWidget>
        get() = gtk_scrolled_window_get_vscrollbar(self)!!.reinterpret()

    /**
     * Creates a new scrolled window.
     *
     * The two arguments are the scrolled window’s adjustments; these will be
     * shared with the scrollbars and the child widget to keep the bars in sync
     * with the child. Usually you want to pass %NULL for the adjustments, which
     * will cause the scrolled window to create them for you. */
    constructor(hadjustment: CPointer<GtkAdjustment>?, vadjustment: CPointer<GtkAdjustment>?) :
            this(gtk_scrolled_window_new(hadjustment?.reinterpret(),
            vadjustment?.reinterpret())?.reinterpret())

    /**
     * Sets the scrollbar policy for the horizontal and vertical scrollbars.
     *
     * The policy determines when the scrollbar should appear; it is a value
     * from the #GtkPolicyType enumeration. If %GTK_POLICY_ALWAYS, the
     * scrollbar is always present; if %GTK_POLICY_NEVER, the scrollbar is
     * never present; if %GTK_POLICY_AUTOMATIC, the scrollbar is present only
     * if needed (that is, if the slider part of the bar would be smaller
     * than the trough — the display is larger than the page size).
     */
    fun setPolicy(hscrollbar_policy: GtkPolicyType, vscrollbar_policy: GtkPolicyType): Unit =
            gtk_scrolled_window_set_policy(self, hscrollbar_policy, vscrollbar_policy)

    /**
     * Unsets the placement of the contents with respect to the scrollbars
     * for the scrolled window. If no window placement is set for a scrolled
     * window, it defaults to %GTK_CORNER_TOP_LEFT.
     *
     * See also gtk_scrolled_window_set_placement() and
     * gtk_scrolled_window_get_placement().
     */
    fun unsetPlacement(): Unit = gtk_scrolled_window_unset_placement(self)
}

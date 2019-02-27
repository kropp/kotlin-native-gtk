package gtk3

import kotlin.Boolean
import kotlin.Double
import kotlin.Int
import kotlin.String
import kotlin.Unit
import kotlinx.cinterop.CFunction
import kotlinx.cinterop.COpaquePointer
import kotlinx.cinterop.CPointed
import kotlinx.cinterop.CPointer
import kotlinx.cinterop.asStableRef
import kotlinx.cinterop.reinterpret
import kotlinx.cinterop.staticCFunction
import libgtk3.GtkAdjustment
import libgtk3.GtkOrientation
import libgtk3.GtkPositionType
import libgtk3.GtkScale
import libgtk3.GtkWidget
import libgtk3.gtk_false
import libgtk3.gtk_scale_add_mark
import libgtk3.gtk_scale_clear_marks
import libgtk3.gtk_scale_get_digits
import libgtk3.gtk_scale_get_draw_value
import libgtk3.gtk_scale_get_has_origin
import libgtk3.gtk_scale_get_value_pos
import libgtk3.gtk_scale_new
import libgtk3.gtk_scale_set_digits
import libgtk3.gtk_scale_set_draw_value
import libgtk3.gtk_scale_set_has_origin
import libgtk3.gtk_scale_set_value_pos
import libgtk3.gtk_true

inline fun Container.scale(
    orientation: GtkOrientation,
    adjustment: CPointer<GtkAdjustment>,
    init: Scale.() -> Unit = {}
): Scale = Scale(orientation, adjustment).apply { init(); this@scale.add(this) }

private fun Scale_onFormatValue_Handler(
    sender: CPointer<in CPointed>?,
    value: Double,
    _data: COpaquePointer?
) {
    _data?.asStableRef<Scale>()?.get()?.onFormatValue?.emit(value)
}

/**
 * A GtkScale is a slider control used to select a numeric value.
 * To use it, you’ll probably want to investigate the methods on
 * its base class, #GtkRange, in addition to the methods for GtkScale itself.
 * To set the value of a scale, you would normally use gtk_range_set_value().
 * To detect changes to the value, you would normally use the
 * #GtkRange::value-changed signal.
 *
 * Note that using the same upper and lower bounds for the #GtkScale (through
 * the #GtkRange methods) will hide the slider itself. This is useful for
 * applications that want to show an undeterminate value on the scale, without
 * changing the layout of the application (such as movie or music players).
 *
 * # GtkScale as GtkBuildable
 *
 * GtkScale supports a custom <marks> element, which can contain multiple
 * <mark> elements. The “value” and “position” attributes have the same
 * meaning as gtk_scale_add_mark() parameters of the same name. If the
 * element is not empty, its content is taken as the markup to show at
 * the mark. It can be translated with the usual ”translatable” and
 * “context” attributes.
 *
 * # CSS nodes
 *
 * |[<!-- language="plain" -->
 * scale[.fine-tune][.marks-before][.marks-after]
 * ├── marks.top
 * │   ├── mark
 * │   ┊    ├── [label]
 * │   ┊    ╰── indicator
 * ┊   ┊
 * │   ╰── mark
 * ├── [value]
 * ├── contents
 * │   ╰── trough
 * │       ├── slider
 * │       ├── [highlight]
 * │       ╰── [fill]
 * ╰── marks.bottom
 *     ├── mark
 *     ┊    ├── indicator
 *     ┊    ╰── [label]
 *     ╰── mark
 * ]|
 *
 * GtkScale has a main CSS node with name scale and a subnode for its contents,
 * with subnodes named trough and slider.
 *
 * The main node gets the style class .fine-tune added when the scale is in
 * 'fine-tuning' mode.
 *
 * If the scale has an origin (see gtk_scale_set_has_origin()), there is a
 * subnode with name highlight below the trough node that is used for rendering
 * the highlighted part of the trough.
 *
 * If the scale is showing a fill level (see gtk_range_set_show_fill_level()),
 * there is a subnode with name fill below the trough node that is used for
 * rendering the filled in part of the trough.
 *
 * If marks are present, there is a marks subnode before or after the contents
 * node, below which each mark gets a node with name mark. The marks nodes get
 * either the .top or .bottom style class.
 *
 * The mark node has a subnode named indicator. If the mark has text, it also
 * has a subnode named label. When the mark is either above or left of the
 * scale, the label subnode is the first when present. Otherwise, the indicator
 * subnode is the first.
 *
 * The main CSS node gets the 'marks-before' and/or 'marks-after' style classes
 * added depending on what marks are present.
 *
 * If the scale is displaying the value (see #GtkScale:draw-value), there is
 * subnode with name value.
 */
@GtkDsl
open class Scale internal constructor(override val widgetPtr: CPointer<GtkWidget>? = null) : Range()
        {
    private val self: CPointer<GtkScale>?
        get() = widgetPtr!!.reinterpret()

    val scale: CPointer<GtkScale>?
        get() = widgetPtr!!.reinterpret()

    val onFormatValue: Signal1<Scale, Double, CFunction<(
        CPointer<in CPointed>?,
        Double,
        COpaquePointer?
    ) -> Unit>> by lazy { Signal1<Scale, Double, CFunction<(
                CPointer<in CPointed>?,
                Double,
                COpaquePointer?
            ) -> Unit>>(widgetPtr!!, this, "format-value",
                    staticCFunction(::Scale_onFormatValue_Handler)) }

    /**
     * Gets the number of decimal places that are displayed in the value.
     *
     * Sets the number of decimal places that are displayed in the value. Also
     * causes the value of the adjustment to be rounded to this number of digits,
     * so the retrieved value matches the displayed one, if #GtkScale:draw-value is
     * %TRUE when the value changes. If you want to enforce rounding the value when
     * #GtkScale:draw-value is %FALSE, you can set #GtkRange:round-digits instead.
     *
     * Note that rounding to a small number of digits can interfere with
     * the smooth autoscrolling that is built into #GtkScale. As an alternative,
     * you can use the #GtkScale::format-value signal to format the displayed
     * value yourself. */
    var digits: Int
        get() = gtk_scale_get_digits(self)
        set(value) {
            gtk_scale_set_digits(self, value)
        }

    /**
     * Returns whether the current value is displayed as a string
     * next to the slider.
     *
     * Specifies whether the current value is displayed as a string next
     * to the slider. */
    var drawValue: Boolean
        get() = gtk_scale_get_draw_value(self) != 0
        set(value) {
            gtk_scale_set_draw_value(self, if (value) gtk_true() else gtk_false())
        }

    /**
     * Returns whether the scale has an origin.
     *
     * If #GtkScale:has-origin is set to %TRUE (the default), the scale will
     * highlight the part of the trough between the origin (bottom or left side)
     * and the current value. */
    var hasOrigin: Boolean
        get() = gtk_scale_get_has_origin(self) != 0
        set(value) {
            gtk_scale_set_has_origin(self, if (value) gtk_true() else gtk_false())
        }

    /**
     * Gets the position in which the current value is displayed.
     *
     * Sets the position in which the current value is displayed. */
    var valuePos: GtkPositionType
        get() = gtk_scale_get_value_pos(self)
        set(value) {
            gtk_scale_set_value_pos(self, value)
        }

    /**
     * Creates a new #GtkScale. */
    constructor(orientation: GtkOrientation, adjustment: CPointer<GtkAdjustment>) :
            this(gtk_scale_new(orientation, adjustment?.reinterpret())?.reinterpret())

    /**
     * Adds a mark at @value.
     *
     * A mark is indicated visually by drawing a tick mark next to the scale,
     * and GTK+ makes it easy for the user to position the scale exactly at the
     * marks value.
     *
     * If @markup is not %NULL, text is shown next to the tick mark.
     *
     * To remove marks from a scale, use gtk_scale_clear_marks().
     */
    fun addMark(
        value: Double,
        position: GtkPositionType,
        markup: String
    ): Unit = gtk_scale_add_mark(self, value, position, markup)

    /**
     * Removes any marks that have been added with gtk_scale_add_mark().
     */
    fun clearMarks(): Unit = gtk_scale_clear_marks(self)
}

package gtk3

import kotlin.Boolean
import kotlin.Double
import kotlin.Int
import kotlin.Unit
import kotlinx.cinterop.CFunction
import kotlinx.cinterop.COpaquePointer
import kotlinx.cinterop.CPointed
import kotlinx.cinterop.CPointer
import kotlinx.cinterop.asStableRef
import kotlinx.cinterop.reinterpret
import kotlinx.cinterop.staticCFunction
import libgtk3.GtkAdjustment
import libgtk3.GtkRange
import libgtk3.GtkSensitivityType
import libgtk3.gtk_false
import libgtk3.gtk_range_get_adjustment
import libgtk3.gtk_range_get_fill_level
import libgtk3.gtk_range_get_flippable
import libgtk3.gtk_range_get_inverted
import libgtk3.gtk_range_get_lower_stepper_sensitivity
import libgtk3.gtk_range_get_restrict_to_fill_level
import libgtk3.gtk_range_get_round_digits
import libgtk3.gtk_range_get_show_fill_level
import libgtk3.gtk_range_get_slider_size_fixed
import libgtk3.gtk_range_get_upper_stepper_sensitivity
import libgtk3.gtk_range_get_value
import libgtk3.gtk_range_set_adjustment
import libgtk3.gtk_range_set_fill_level
import libgtk3.gtk_range_set_flippable
import libgtk3.gtk_range_set_increments
import libgtk3.gtk_range_set_inverted
import libgtk3.gtk_range_set_lower_stepper_sensitivity
import libgtk3.gtk_range_set_range
import libgtk3.gtk_range_set_restrict_to_fill_level
import libgtk3.gtk_range_set_round_digits
import libgtk3.gtk_range_set_show_fill_level
import libgtk3.gtk_range_set_slider_size_fixed
import libgtk3.gtk_range_set_upper_stepper_sensitivity
import libgtk3.gtk_range_set_value
import libgtk3.gtk_true

private fun Range_onAdjustBounds_Handler(
    sender: CPointer<in CPointed>?,
    value: Double,
    _data: COpaquePointer?
) {
    _data?.asStableRef<Range>()?.get()?.onAdjustBounds?.emit(value)
}

private fun Range_onValueChanged_Handler(sender: CPointer<in CPointed>?, _data: COpaquePointer?) {
    _data?.asStableRef<Range>()?.get()?.onValueChanged?.emit()
}

/**
 * #GtkRange is the common base class for widgets which visualize an
 * adjustment, e.g #GtkScale or #GtkScrollbar.
 *
 * Apart from signals for monitoring the parameters of the adjustment,
 * #GtkRange provides properties and methods for influencing the sensitivity
 * of the “steppers”. It also provides properties and methods for setting a
 * “fill level” on range widgets. See gtk_range_set_fill_level(). */
@GtkDsl
abstract class Range : Widget() {
    private val self: CPointer<GtkRange>
        get() = widgetPtr!!.reinterpret()

    val onAdjustBounds: Signal1<Range, Double, CFunction<(
        CPointer<in CPointed>?,
        Double,
        COpaquePointer?
    ) -> Unit>> by lazy { Signal1<Range, Double, CFunction<(
                CPointer<in CPointed>?,
                Double,
                COpaquePointer?
            ) -> Unit>>(widgetPtr!!, this, "adjust-bounds",
                    staticCFunction(::Range_onAdjustBounds_Handler)) }

    val onValueChanged: Signal<Range, CFunction<(CPointer<in CPointed>?, COpaquePointer?) -> Unit>>
            by lazy { Signal<Range, CFunction<(CPointer<in CPointed>?, COpaquePointer?) ->
            Unit>>(widgetPtr!!, this, "value-changed",
            staticCFunction(::Range_onValueChanged_Handler)) }

    /**
     * Get the #GtkAdjustment which is the “model” object for #GtkRange.
     * See gtk_range_set_adjustment() for details.
     * The return value does not have a reference added, so should not
     * be unreferenced.
     *
     * Sets the adjustment to be used as the “model” object for this range
     * widget. The adjustment indicates the current range value, the
     * minimum and maximum range values, the step/page increments used
     * for keybindings and scrolling, and the page size. The page size
     * is normally 0 for #GtkScale and nonzero for #GtkScrollbar, and
     * indicates the size of the visible area of the widget being scrolled.
     * The page size affects the size of the scrollbar slider. */
    var adjustment: CPointer<GtkAdjustment>
        get() = gtk_range_get_adjustment(self)!!.reinterpret()
        set(value) {
            gtk_range_set_adjustment(self, value?.reinterpret())
        }

    /**
     * Gets the current position of the fill level indicator.
     *
     * Set the new position of the fill level indicator.
     *
     * The “fill level” is probably best described by its most prominent
     * use case, which is an indicator for the amount of pre-buffering in
     * a streaming media player. In that use case, the value of the range
     * would indicate the current play position, and the fill level would
     * be the position up to which the file/stream has been downloaded.
     *
     * This amount of prebuffering can be displayed on the range’s trough
     * and is themeable separately from the trough. To enable fill level
     * display, use gtk_range_set_show_fill_level(). The range defaults
     * to not showing the fill level.
     *
     * Additionally, it’s possible to restrict the range’s slider position
     * to values which are smaller than the fill level. This is controller
     * by gtk_range_set_restrict_to_fill_level() and is by default
     * enabled. */
    var fillLevel: Double
        get() = gtk_range_get_fill_level(self)
        set(value) {
            gtk_range_set_fill_level(self, value)
        }

    /**
     * Gets the value set by gtk_range_set_flippable().
     *
     * If a range is flippable, it will switch its direction if it is
     * horizontal and its direction is %GTK_TEXT_DIR_RTL.
     *
     * See gtk_widget_get_direction(). */
    var flippable: Boolean
        get() = gtk_range_get_flippable(self) != 0
        set(value) {
            gtk_range_set_flippable(self, if (value) gtk_true() else gtk_false())
        }

    /**
     * Gets the value set by gtk_range_set_inverted().
     *
     * Ranges normally move from lower to higher values as the
     * slider moves from top to bottom or left to right. Inverted
     * ranges have higher values at the top or on the right rather than
     * on the bottom or left. */
    var inverted: Boolean
        get() = gtk_range_get_inverted(self) != 0
        set(value) {
            gtk_range_set_inverted(self, if (value) gtk_true() else gtk_false())
        }

    /**
     * Gets the sensitivity policy for the stepper that points to the
     * 'lower' end of the GtkRange’s adjustment.
     *
     * Sets the sensitivity policy for the stepper that points to the
     * 'lower' end of the GtkRange’s adjustment. */
    var lowerStepperSensitivity: GtkSensitivityType
        get() = gtk_range_get_lower_stepper_sensitivity(self)
        set(value) {
            gtk_range_set_lower_stepper_sensitivity(self, value)
        }

    /**
     * Gets whether the range is restricted to the fill level.
     *
     * Sets whether the slider is restricted to the fill level. See
     * gtk_range_set_fill_level() for a general description of the fill
     * level concept. */
    var restrictToFillLevel: Boolean
        get() = gtk_range_get_restrict_to_fill_level(self) != 0
        set(value) {
            gtk_range_set_restrict_to_fill_level(self, if (value) gtk_true() else gtk_false())
        }

    /**
     * Gets the number of digits to round the value to when
     * it changes. See #GtkRange::change-value.
     *
     * Sets the number of digits to round the value to when
     * it changes. See #GtkRange::change-value. */
    var roundDigits: Int
        get() = gtk_range_get_round_digits(self)
        set(value) {
            gtk_range_set_round_digits(self, value)
        }

    /**
     * Gets whether the range displays the fill level graphically.
     *
     * Sets whether a graphical fill level is show on the trough. See
     * gtk_range_set_fill_level() for a general description of the fill
     * level concept. */
    var showFillLevel: Boolean
        get() = gtk_range_get_show_fill_level(self) != 0
        set(value) {
            gtk_range_set_show_fill_level(self, if (value) gtk_true() else gtk_false())
        }

    /**
     * This function is useful mainly for #GtkRange subclasses.
     *
     * See gtk_range_set_slider_size_fixed().
     *
     * Sets whether the range’s slider has a fixed size, or a size that
     * depends on its adjustment’s page size.
     *
     * This function is useful mainly for #GtkRange subclasses. */
    var sliderSizeFixed: Boolean
        get() = gtk_range_get_slider_size_fixed(self) != 0
        set(value) {
            gtk_range_set_slider_size_fixed(self, if (value) gtk_true() else gtk_false())
        }

    /**
     * Gets the sensitivity policy for the stepper that points to the
     * 'upper' end of the GtkRange’s adjustment.
     *
     * Sets the sensitivity policy for the stepper that points to the
     * 'upper' end of the GtkRange’s adjustment. */
    var upperStepperSensitivity: GtkSensitivityType
        get() = gtk_range_get_upper_stepper_sensitivity(self)
        set(value) {
            gtk_range_set_upper_stepper_sensitivity(self, value)
        }

    /**
     * Gets the current value of the range.
     *
     * Sets the current value of the range; if the value is outside the
     * minimum or maximum range values, it will be clamped to fit inside
     * them. The range emits the #GtkRange::value-changed signal if the
     * value changes. */
    var value: Double
        get() = gtk_range_get_value(self)
        set(value) {
            gtk_range_set_value(self, value)
        }

    /**
     * Sets the step and page sizes for the range.
     * The step size is used when the user clicks the #GtkScrollbar
     * arrows or moves #GtkScale via arrow keys. The page size
     * is used for example when moving via Page Up or Page Down keys.
     */
    fun setIncrements(step: Double, page: Double): Unit = gtk_range_set_increments(self, step, page)

    /**
     * Sets the allowable values in the #GtkRange, and clamps the range
     * value to be between @min and @max. (If the range has a non-zero
     * page size, it is clamped between @min and @max - page-size.)
     */
    fun setRange(min: Double, max: Double): Unit = gtk_range_set_range(self, min, max)
}

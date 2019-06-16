package gtk3

import kotlin.Double
import kotlin.Unit
import kotlinx.cinterop.CFunction
import kotlinx.cinterop.COpaquePointer
import kotlinx.cinterop.CPointed
import kotlinx.cinterop.CPointer
import kotlinx.cinterop.asStableRef
import kotlinx.cinterop.staticCFunction
import libgtk3.GtkAdjustment
import libgtk3.gtk_adjustment_clamp_page
import libgtk3.gtk_adjustment_configure
import libgtk3.gtk_adjustment_get_lower
import libgtk3.gtk_adjustment_get_minimum_increment
import libgtk3.gtk_adjustment_get_page_increment
import libgtk3.gtk_adjustment_get_page_size
import libgtk3.gtk_adjustment_get_step_increment
import libgtk3.gtk_adjustment_get_upper
import libgtk3.gtk_adjustment_get_value
import libgtk3.gtk_adjustment_new
import libgtk3.gtk_adjustment_set_lower
import libgtk3.gtk_adjustment_set_page_increment
import libgtk3.gtk_adjustment_set_page_size
import libgtk3.gtk_adjustment_set_step_increment
import libgtk3.gtk_adjustment_set_upper
import libgtk3.gtk_adjustment_set_value

private fun Adjustment_onChanged_Handler(sender: CPointer<in CPointed>?, _data: COpaquePointer?) {
    _data?.asStableRef<Adjustment>()?.get()?.onChanged?.emit()
}

private fun Adjustment_onValueChanged_Handler(sender: CPointer<in CPointed>?, _data:
        COpaquePointer?) {
    _data?.asStableRef<Adjustment>()?.get()?.onValueChanged?.emit()
}

/**
 * The #GtkAdjustment object represents a value which has an associated lower
 * and upper bound, together with step and page increments, and a page size.
 * It is used within several GTK+ widgets, including #GtkSpinButton, #GtkViewport,
 * and #GtkRange (which is a base class for #GtkScrollbar and #GtkScale).
 *
 * The #GtkAdjustment object does not update the value itself. Instead
 * it is left up to the owner of the #GtkAdjustment to control the value.Gets the smaller of step
        increment and page increment.
 */
@GtkDsl
open class Adjustment(
    value: Double,
    lower: Double,
    upper: Double,
    step_increment: Double,
    page_increment: Double,
    page_size: Double
) {
    val widgetPtr: CPointer<GtkAdjustment> = gtk_adjustment_new(value, lower, upper, step_increment,
            page_increment, page_size)!!

    private val self: CPointer<GtkAdjustment>
        get() = widgetPtr

    val onChanged: Signal<Adjustment, CFunction<(CPointer<in CPointed>?, COpaquePointer?) -> Unit>>
            by lazy { Signal<Adjustment, CFunction<(CPointer<in CPointed>?, COpaquePointer?) ->
            Unit>>(widgetPtr!!, this, "changed", staticCFunction(::Adjustment_onChanged_Handler)) }

    val onValueChanged: Signal<Adjustment, CFunction<(CPointer<in CPointed>?, COpaquePointer?) ->
            Unit>> by lazy { Signal<Adjustment, CFunction<(CPointer<in CPointed>?,
            COpaquePointer?) -> Unit>>(widgetPtr!!, this, "value-changed",
            staticCFunction(::Adjustment_onValueChanged_Handler)) }

    /**
     * Retrieves the minimum value of the adjustment.
     *
     * Sets the minimum value of the adjustment.
     *
     * When setting multiple adjustment properties via their individual
     * setters, multiple #GtkAdjustment::changed signals will be emitted.
     * However, since the emission of the #GtkAdjustment::changed signal
     * is tied to the emission of the #GObject::notify signals of the changed
     * properties, it’s possible to compress the #GtkAdjustment::changed
     * signals into one by calling g_object_freeze_notify() and
     * g_object_thaw_notify() around the calls to the individual setters.
     *
     * Alternatively, using a single g_object_set() for all the properties
     * to change, or using gtk_adjustment_configure() has the same effect
     * of compressing #GtkAdjustment::changed emissions. */
    var lower: Double
        get() = gtk_adjustment_get_lower(self)
        set(value) {
            gtk_adjustment_set_lower(self, value)
        }

    val minimumIncrement: Double
        get() = gtk_adjustment_get_minimum_increment(self)

    /**
     * Retrieves the page increment of the adjustment.
     *
     * Sets the page increment of the adjustment.
     *
     * See gtk_adjustment_set_lower() about how to compress multiple
     * emissions of the #GtkAdjustment::changed signal when setting
     * multiple adjustment properties. */
    var pageIncrement: Double
        get() = gtk_adjustment_get_page_increment(self)
        set(value) {
            gtk_adjustment_set_page_increment(self, value)
        }

    /**
     * Retrieves the page size of the adjustment.
     *
     * Sets the page size of the adjustment.
     *
     * See gtk_adjustment_set_lower() about how to compress multiple
     * emissions of the GtkAdjustment::changed signal when setting
     * multiple adjustment properties. */
    var pageSize: Double
        get() = gtk_adjustment_get_page_size(self)
        set(value) {
            gtk_adjustment_set_page_size(self, value)
        }

    /**
     * Retrieves the step increment of the adjustment.
     *
     * Sets the step increment of the adjustment.
     *
     * See gtk_adjustment_set_lower() about how to compress multiple
     * emissions of the #GtkAdjustment::changed signal when setting
     * multiple adjustment properties. */
    var stepIncrement: Double
        get() = gtk_adjustment_get_step_increment(self)
        set(value) {
            gtk_adjustment_set_step_increment(self, value)
        }

    /**
     * Retrieves the maximum value of the adjustment.
     *
     * Sets the maximum value of the adjustment.
     *
     * Note that values will be restricted by `upper - page-size`
     * if the page-size property is nonzero.
     *
     * See gtk_adjustment_set_lower() about how to compress multiple
     * emissions of the #GtkAdjustment::changed signal when setting
     * multiple adjustment properties. */
    var upper: Double
        get() = gtk_adjustment_get_upper(self)
        set(value) {
            gtk_adjustment_set_upper(self, value)
        }

    /**
     * Gets the current value of the adjustment.
     * See gtk_adjustment_set_value().
     *
     * Sets the #GtkAdjustment value. The value is clamped to lie between
     * #GtkAdjustment:lower and #GtkAdjustment:upper.
     *
     * Note that for adjustments which are used in a #GtkScrollbar, the
     * effective range of allowed values goes from #GtkAdjustment:lower to
     * #GtkAdjustment:upper - #GtkAdjustment:page-size. */
    var value: Double
        get() = gtk_adjustment_get_value(self)
        set(value) {
            gtk_adjustment_set_value(self, value)
        }

    /**
     * Updates the #GtkAdjustment:value property to ensure that the range
     * between @lower and @upper is in the current page (i.e. between
     * #GtkAdjustment:value and #GtkAdjustment:value + #GtkAdjustment:page-size).
     * If the range is larger than the page size, then only the start of it will
     * be in the current page.
     *
     * A #GtkAdjustment::value-changed signal will be emitted if the value is changed.
     */
    fun clampPage(lower: Double, upper: Double): Unit = gtk_adjustment_clamp_page(self, lower,
            upper)

    /**
     * Sets all properties of the adjustment at once.
     *
     * Use this function to avoid multiple emissions of the
     * #GtkAdjustment::changed signal. See gtk_adjustment_set_lower()
     * for an alternative way of compressing multiple emissions of
     * #GtkAdjustment::changed into one.
     */
    fun configure(
        value: Double,
        lower: Double,
        upper: Double,
        step_increment: Double,
        page_increment: Double,
        page_size: Double
    ): Unit = gtk_adjustment_configure(self, value, lower, upper, step_increment, page_increment,
            page_size)
}

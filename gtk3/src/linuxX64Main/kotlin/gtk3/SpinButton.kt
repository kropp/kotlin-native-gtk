package gtk3

import kotlin.Boolean
import kotlin.Double
import kotlin.Int
import kotlin.UInt
import kotlin.Unit
import kotlinx.cinterop.CFunction
import kotlinx.cinterop.COpaquePointer
import kotlinx.cinterop.CPointed
import kotlinx.cinterop.CPointer
import kotlinx.cinterop.asStableRef
import kotlinx.cinterop.reinterpret
import kotlinx.cinterop.staticCFunction
import libgtk3.GtkAdjustment
import libgtk3.GtkSpinButton
import libgtk3.GtkSpinButtonUpdatePolicy
import libgtk3.GtkSpinType
import libgtk3.GtkWidget
import libgtk3.gtk_false
import libgtk3.gtk_spin_button_configure
import libgtk3.gtk_spin_button_get_adjustment
import libgtk3.gtk_spin_button_get_digits
import libgtk3.gtk_spin_button_get_numeric
import libgtk3.gtk_spin_button_get_snap_to_ticks
import libgtk3.gtk_spin_button_get_update_policy
import libgtk3.gtk_spin_button_get_value
import libgtk3.gtk_spin_button_get_value_as_int
import libgtk3.gtk_spin_button_get_wrap
import libgtk3.gtk_spin_button_new
import libgtk3.gtk_spin_button_set_adjustment
import libgtk3.gtk_spin_button_set_digits
import libgtk3.gtk_spin_button_set_increments
import libgtk3.gtk_spin_button_set_numeric
import libgtk3.gtk_spin_button_set_range
import libgtk3.gtk_spin_button_set_snap_to_ticks
import libgtk3.gtk_spin_button_set_update_policy
import libgtk3.gtk_spin_button_set_value
import libgtk3.gtk_spin_button_set_wrap
import libgtk3.gtk_spin_button_spin
import libgtk3.gtk_spin_button_update
import libgtk3.gtk_true

inline fun Container.spinButton(
    adjustment: CPointer<GtkAdjustment>,
    climb_rate: Double,
    digits: UInt,
    init: SpinButton.() -> Unit = {}
): SpinButton = SpinButton(adjustment, climb_rate, digits).apply { init(); this@spinButton.add(this)
        }

private fun SpinButton_onInput_Handler(
    sender: CPointer<in CPointed>?,
    new_value: Double,
    _data: COpaquePointer?
) {
    _data?.asStableRef<SpinButton>()?.get()?.onInput?.emit(new_value)
}

private fun SpinButton_onOutput_Handler(sender: CPointer<in CPointed>?, _data: COpaquePointer?) {
    _data?.asStableRef<SpinButton>()?.get()?.onOutput?.emit()
}

private fun SpinButton_onValueChanged_Handler(sender: CPointer<in CPointed>?, _data:
        COpaquePointer?) {
    _data?.asStableRef<SpinButton>()?.get()?.onValueChanged?.emit()
}

private fun SpinButton_onWrapped_Handler(sender: CPointer<in CPointed>?, _data: COpaquePointer?) {
    _data?.asStableRef<SpinButton>()?.get()?.onWrapped?.emit()
}

/**
 * A #GtkSpinButton is an ideal way to allow the user to set the value of
 * some attribute. Rather than having to directly type a number into a
 * #GtkEntry, GtkSpinButton allows the user to click on one of two arrows
 * to increment or decrement the displayed value. A value can still be
 * typed in, with the bonus that it can be checked to ensure it is in a
 * given range.
 *
 * The main properties of a GtkSpinButton are through an adjustment.
 * See the #GtkAdjustment section for more details about an adjustment's
 * properties. Note that GtkSpinButton will by default make its entry
 * large enough to accomodate the lower and upper bounds of the adjustment,
 * which can lead to surprising results. Best practice is to set both
 * the #GtkEntry:width-chars and #GtkEntry:max-width-chars poperties
 * to the desired number of characters to display in the entry.
 *
 * # CSS nodes
 *
 * |[<!-- language="plain" -->
 * spinbutton.horizontal
 * ├── undershoot.left
 * ├── undershoot.right
 * ├── entry
 * │   ╰── ...
 * ├── button.down
 * ╰── button.up
 * ]|
 *
 * |[<!-- language="plain" -->
 * spinbutton.vertical
 * ├── undershoot.left
 * ├── undershoot.right
 * ├── button.up
 * ├── entry
 * │   ╰── ...
 * ╰── button.down
 * ]|
 *
 * GtkSpinButtons main CSS node has the name spinbutton. It creates subnodes
 * for the entry and the two buttons, with these names. The button nodes have
 * the style classes .up and .down. The GtkEntry subnodes (if present) are put
 * below the entry node. The orientation of the spin button is reflected in
 * the .vertical or .horizontal style class on the main node.
 *
 * ## Using a GtkSpinButton to get an integer
 *
 * |[<!-- language="C" -->
 * // Provides a function to retrieve an integer value from a GtkSpinButton
 * // and creates a spin button to model percentage values.
 *
 * gint
 * grab_int_value (GtkSpinButton *button,
 *                 gpointer       user_data)
 * {
 *   return gtk_spin_button_get_value_as_int (button);
 * }
 *
 * void
 * create_integer_spin_button (void)
 * {
 *
 *   GtkWidget *window, *button;
 *   GtkAdjustment *adjustment;
 *
 *   adjustment = gtk_adjustment_new (50.0, 0.0, 100.0, 1.0, 5.0, 0.0);
 *
 *   window = gtk_window_new (GTK_WINDOW_TOPLEVEL);
 *   gtk_container_set_border_width (GTK_CONTAINER (window), 5);
 *
 *   // creates the spinbutton, with no decimal places
 *   button = gtk_spin_button_new (adjustment, 1.0, 0);
 *   gtk_container_add (GTK_CONTAINER (window), button);
 *
 *   gtk_widget_show_all (window);
 * }
 * ]|
 *
 * ## Using a GtkSpinButton to get a floating point value
 *
 * |[<!-- language="C" -->
 * // Provides a function to retrieve a floating point value from a
 * // GtkSpinButton, and creates a high precision spin button.
 *
 * gfloat
 * grab_float_value (GtkSpinButton *button,
 *                   gpointer       user_data)
 * {
 *   return gtk_spin_button_get_value (button);
 * }
 *
 * void
 * create_floating_spin_button (void)
 * {
 *   GtkWidget *window, *button;
 *   GtkAdjustment *adjustment;
 *
 *   adjustment = gtk_adjustment_new (2.500, 0.0, 5.0, 0.001, 0.1, 0.0);
 *
 *   window = gtk_window_new (GTK_WINDOW_TOPLEVEL);
 *   gtk_container_set_border_width (GTK_CONTAINER (window), 5);
 *
 *   // creates the spinbutton, with three decimal places
 *   button = gtk_spin_button_new (adjustment, 0.001, 3);
 *   gtk_container_add (GTK_CONTAINER (window), button);
 *
 *   gtk_widget_show_all (window);
 * }
 * ]|Get the value @spin_button represented as an integer.
 */
@GtkDsl
open class SpinButton internal constructor(override val widgetPtr: CPointer<GtkWidget>? = null) :
        Entry() {
    private val self: CPointer<GtkSpinButton>?
        get() = widgetPtr!!.reinterpret()

    val spinButton: CPointer<GtkSpinButton>?
        get() = widgetPtr!!.reinterpret()

    val onInput: Signal1<SpinButton, Double, CFunction<(
        CPointer<in CPointed>?,
        Double,
        COpaquePointer?
    ) -> Unit>> by lazy { Signal1<SpinButton, Double, CFunction<(
                CPointer<in CPointed>?,
                Double,
                COpaquePointer?
            ) -> Unit>>(widgetPtr!!, this, "input", staticCFunction(::SpinButton_onInput_Handler)) }

    val onOutput: Signal<SpinButton, CFunction<(CPointer<in CPointed>?, COpaquePointer?) -> Unit>>
            by lazy { Signal<SpinButton, CFunction<(CPointer<in CPointed>?, COpaquePointer?) ->
            Unit>>(widgetPtr!!, this, "output", staticCFunction(::SpinButton_onOutput_Handler)) }

    val onValueChanged: Signal<SpinButton, CFunction<(CPointer<in CPointed>?, COpaquePointer?) ->
            Unit>> by lazy { Signal<SpinButton, CFunction<(CPointer<in CPointed>?,
            COpaquePointer?) -> Unit>>(widgetPtr!!, this, "value-changed",
            staticCFunction(::SpinButton_onValueChanged_Handler)) }

    val onWrapped: Signal<SpinButton, CFunction<(CPointer<in CPointed>?, COpaquePointer?) -> Unit>>
            by lazy { Signal<SpinButton, CFunction<(CPointer<in CPointed>?, COpaquePointer?) ->
            Unit>>(widgetPtr!!, this, "wrapped", staticCFunction(::SpinButton_onWrapped_Handler)) }

    /**
     * Get the adjustment associated with a #GtkSpinButton
     *
     * Replaces the #GtkAdjustment associated with @spin_button. */
    var adjustment: CPointer<GtkAdjustment>
        get() = gtk_spin_button_get_adjustment(self)!!.reinterpret()
        set(value) {
            gtk_spin_button_set_adjustment(self, value?.reinterpret())
        }

    /**
     * Fetches the precision of @spin_button. See gtk_spin_button_set_digits().
     *
     * Set the precision to be displayed by @spin_button. Up to 20 digit precision
     * is allowed. */
    var digits: UInt
        get() = gtk_spin_button_get_digits(self)
        set(value) {
            gtk_spin_button_set_digits(self, value)
        }

    /**
     * Returns whether non-numeric text can be typed into the spin button.
     * See gtk_spin_button_set_numeric().
     *
     * Sets the flag that determines if non-numeric text can be typed
     * into the spin button. */
    var numeric: Boolean
        get() = gtk_spin_button_get_numeric(self) != 0
        set(value) {
            gtk_spin_button_set_numeric(self, if (value) gtk_true() else gtk_false())
        }

    /**
     * Returns whether the values are corrected to the nearest step.
     * See gtk_spin_button_set_snap_to_ticks().
     *
     * Sets the policy as to whether values are corrected to the
     * nearest step increment when a spin button is activated after
     * providing an invalid value. */
    var snapToTicks: Boolean
        get() = gtk_spin_button_get_snap_to_ticks(self) != 0
        set(value) {
            gtk_spin_button_set_snap_to_ticks(self, if (value) gtk_true() else gtk_false())
        }

    /**
     * Gets the update behavior of a spin button.
     * See gtk_spin_button_set_update_policy().
     *
     * Sets the update behavior of a spin button.
     * This determines whether the spin button is always updated
     * or only when a valid value is set. */
    var updatePolicy: GtkSpinButtonUpdatePolicy
        get() = gtk_spin_button_get_update_policy(self)
        set(value) {
            gtk_spin_button_set_update_policy(self, value)
        }

    /**
     * Get the value in the @spin_button.
     *
     * Sets the value of @spin_button. */
    var value: Double
        get() = gtk_spin_button_get_value(self)
        set(value) {
            gtk_spin_button_set_value(self, value)
        }

    val valueAsInt: Int
        get() = gtk_spin_button_get_value_as_int(self)

    /**
     * Returns whether the spin button’s value wraps around to the
     * opposite limit when the upper or lower limit of the range is
     * exceeded. See gtk_spin_button_set_wrap().
     *
     * Sets the flag that determines if a spin button value wraps
     * around to the opposite limit when the upper or lower limit
     * of the range is exceeded. */
    var wrap: Boolean
        get() = gtk_spin_button_get_wrap(self) != 0
        set(value) {
            gtk_spin_button_set_wrap(self, if (value) gtk_true() else gtk_false())
        }

    /**
     * Creates a new #GtkSpinButton. */
    constructor(
        adjustment: CPointer<GtkAdjustment>,
        climb_rate: Double,
        digits: UInt
    ) : this(gtk_spin_button_new(adjustment?.reinterpret(), climb_rate, digits)?.reinterpret())

    /**
     * Changes the properties of an existing spin button. The adjustment,
     * climb rate, and number of decimal places are updated accordingly.
     */
    fun configure(
        adjustment: CPointer<GtkAdjustment>,
        climb_rate: Double,
        digits: UInt
    ): Unit = gtk_spin_button_configure(self, adjustment, climb_rate, digits)

    /**
     * Changes the properties of an existing spin button. The adjustment,
     * climb rate, and number of decimal places are updated accordingly.
     */
    fun configure(
        adjustment: Adjustment,
        climb_rate: Double,
        digits: UInt
    ): Unit = gtk_spin_button_configure(self, adjustment.widgetPtr?.reinterpret(), climb_rate,
            digits)

    /**
     * Sets the step and page increments for spin_button.  This affects how
     * quickly the value changes when the spin button’s arrows are activated.
     */
    fun setIncrements(step: Double, page: Double): Unit = gtk_spin_button_set_increments(self, step,
            page)

    /**
     * Sets the minimum and maximum allowable values for @spin_button.
     *
     * If the current value is outside this range, it will be adjusted
     * to fit within the range, otherwise it will remain unchanged.
     */
    fun setRange(min: Double, max: Double): Unit = gtk_spin_button_set_range(self, min, max)

    /**
     * Increment or decrement a spin button’s value in a specified
     * direction by a specified amount.
     */
    fun spin(direction: GtkSpinType, increment: Double): Unit = gtk_spin_button_spin(self,
            direction, increment)

    /**
     * Manually force an update of the spin button.
     */
    fun update(): Unit = gtk_spin_button_update(self)
}

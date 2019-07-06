package gtk3

import kotlin.Double
import kotlin.String
import kotlin.Unit
import kotlin.collections.List
import kotlinx.cinterop.CFunction
import kotlinx.cinterop.COpaquePointer
import kotlinx.cinterop.CPointed
import kotlinx.cinterop.CPointer
import kotlinx.cinterop.asStableRef
import kotlinx.cinterop.cstr
import kotlinx.cinterop.memScoped
import kotlinx.cinterop.ptr
import kotlinx.cinterop.reinterpret
import kotlinx.cinterop.staticCFunction
import kotlinx.cinterop.toCValues
import libgtk3.GtkAdjustment
import libgtk3.GtkButton
import libgtk3.GtkIconSize
import libgtk3.GtkScaleButton
import libgtk3.GtkWidget
import libgtk3.gtk_scale_button_get_adjustment
import libgtk3.gtk_scale_button_get_minus_button
import libgtk3.gtk_scale_button_get_plus_button
import libgtk3.gtk_scale_button_get_popup
import libgtk3.gtk_scale_button_get_value
import libgtk3.gtk_scale_button_new
import libgtk3.gtk_scale_button_set_adjustment
import libgtk3.gtk_scale_button_set_icons
import libgtk3.gtk_scale_button_set_value

inline fun Container.scaleButton(
    size: GtkIconSize,
    min: Double,
    max: Double,
    step: Double,
    icons: List<String>,
    init: ScaleButton.() -> Unit = {}
): ScaleButton = ScaleButton(size, min, max, step, icons).apply { init(); this@scaleButton.add(this)
        }

private fun ScaleButton_onPopdown_Handler(sender: CPointer<in CPointed>?, _data: COpaquePointer?) {
    _data?.asStableRef<ScaleButton>()?.get()?.onPopdown?.emit()
}

private fun ScaleButton_onPopup_Handler(sender: CPointer<in CPointed>?, _data: COpaquePointer?) {
    _data?.asStableRef<ScaleButton>()?.get()?.onPopup?.emit()
}

private fun ScaleButton_onValueChanged_Handler(
    sender: CPointer<in CPointed>?,
    value: Double,
    _data: COpaquePointer?
) {
    _data?.asStableRef<ScaleButton>()?.get()?.onValueChanged?.emit(value)
}

/**
 * #GtkScaleButton provides a button which pops up a scale widget.
 * This kind of widget is commonly used for volume controls in multimedia
 * applications, and GTK+ provides a #GtkVolumeButton subclass that
 * is tailored for this use case.
 *
 * # CSS nodes
 *
 * GtkScaleButton has a single CSS node with name button. To differentiate
 * it from a plain #GtkButton, it gets the .scale style class.Retrieves the minus button of the
        #GtkScaleButton.Retrieves the plus button of the #GtkScaleButton.Retrieves the popup of the
        #GtkScaleButton.
 */
@GtkDsl
open class ScaleButton internal constructor(override val widgetPtr: CPointer<GtkWidget>? = null) :
        Button() {
    private val self: CPointer<GtkScaleButton>?
        get() = widgetPtr!!.reinterpret()

    val scaleButton: CPointer<GtkScaleButton>?
        get() = widgetPtr!!.reinterpret()

    val onPopdown: Signal<ScaleButton, CFunction<(CPointer<in CPointed>?, COpaquePointer?) -> Unit>>
            by lazy { Signal<ScaleButton, CFunction<(CPointer<in CPointed>?, COpaquePointer?) ->
            Unit>>(widgetPtr!!, this, "popdown", staticCFunction(::ScaleButton_onPopdown_Handler)) }

    val onPopup: Signal<ScaleButton, CFunction<(CPointer<in CPointed>?, COpaquePointer?) -> Unit>>
            by lazy { Signal<ScaleButton, CFunction<(CPointer<in CPointed>?, COpaquePointer?) ->
            Unit>>(widgetPtr!!, this, "popup", staticCFunction(::ScaleButton_onPopup_Handler)) }

    val onValueChanged: Signal1<ScaleButton, Double, CFunction<(
        CPointer<in CPointed>?,
        Double,
        COpaquePointer?
    ) -> Unit>> by lazy { Signal1<ScaleButton, Double, CFunction<(
                CPointer<in CPointed>?,
                Double,
                COpaquePointer?
            ) -> Unit>>(widgetPtr!!, this, "value-changed",
                    staticCFunction(::ScaleButton_onValueChanged_Handler)) }

    /**
     * Gets the #GtkAdjustment associated with the #GtkScaleButton’s scale.
     * See gtk_range_get_adjustment() for details.
     *
     * Sets the #GtkAdjustment to be used as a model
     * for the #GtkScaleButton’s scale.
     * See gtk_range_set_adjustment() for details. */
    var adjustment: CPointer<GtkAdjustment>
        get() = gtk_scale_button_get_adjustment(self)!!.reinterpret()
        set(value) {
            gtk_scale_button_set_adjustment(self, value?.reinterpret())
        }

    val minusButton: CPointer<GtkButton>
        get() = gtk_scale_button_get_minus_button(self)!!.reinterpret()

    val plusButton: CPointer<GtkButton>
        get() = gtk_scale_button_get_plus_button(self)!!.reinterpret()

    val popup: CPointer<GtkWidget>
        get() = gtk_scale_button_get_popup(self)!!.reinterpret()

    /**
     * Gets the current value of the scale button.
     *
     * Sets the current value of the scale; if the value is outside
     * the minimum or maximum range values, it will be clamped to fit
     * inside them. The scale button emits the #GtkScaleButton::value-changed
     * signal if the value changes. */
    var value: Double
        get() = gtk_scale_button_get_value(self)
        set(value) {
            gtk_scale_button_set_value(self, value)
        }

    /**
     * Creates a #GtkScaleButton, with a range between @min and @max, with
     * a stepping of @step. */
    constructor(
        size: GtkIconSize,
        min: Double,
        max: Double,
        step: Double,
        icons: List<String>
    ) : this(gtk_scale_button_new(size, min, max, step, memScoped { (icons.map { it.cstr.ptr } +
            listOf(null)).toCValues() })?.reinterpret())

    /**
     * Sets the icons to be used by the scale button.
     * For details, see the #GtkScaleButton:icons property.
     */
    fun setIcons(icons: List<String>): Unit = gtk_scale_button_set_icons(self, memScoped {
            (icons.map { it.cstr.ptr } + listOf(null)).toCValues() })
}

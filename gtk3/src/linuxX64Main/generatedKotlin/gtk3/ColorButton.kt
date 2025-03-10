package gtk3

import kotlin.String
import kotlin.Unit
import kotlinx.cinterop.CFunction
import kotlinx.cinterop.COpaquePointer
import kotlinx.cinterop.CPointed
import kotlinx.cinterop.CPointer
import kotlinx.cinterop.asStableRef
import kotlinx.cinterop.reinterpret
import kotlinx.cinterop.staticCFunction
import kotlinx.cinterop.toKString
import libgtk3.GtkColorButton
import libgtk3.GtkWidget
import libgtk3.gtk_color_button_get_title
import libgtk3.gtk_color_button_new
import libgtk3.gtk_color_button_set_title

inline fun Container.colorButton(init: ColorButton.() -> Unit = {}): ColorButton =
        ColorButton().apply { init(); this@colorButton.add(this) }

private fun ColorButton_onColorSet_Handler(sender: CPointer<in CPointed>?, _data: COpaquePointer?) {
    _data?.asStableRef<ColorButton>()?.get()?.onColorSet?.emit()
}

/**
 * The #GtkColorButton is a button which displays the currently selected
 * color and allows to open a color selection dialog to change the color.
 * It is suitable widget for selecting a color in a preference dialog.
 *
 * # CSS nodes
 *
 * GtkColorButton has a single CSS node with name button. To differentiate
 * it from a plain #GtkButton, it gets the .color style class.
 */
@GtkDsl
open class ColorButton internal constructor(override val widgetPtr: CPointer<GtkWidget>? = null) :
        Button() {
    private val self: CPointer<GtkColorButton>?
        get() = widgetPtr!!.reinterpret()

    val colorButton: CPointer<GtkColorButton>?
        get() = widgetPtr!!.reinterpret()

    val onColorSet: Signal<ColorButton, CFunction<(CPointer<in CPointed>?, COpaquePointer?) ->
            Unit>> by lazy { Signal<ColorButton, CFunction<(CPointer<in CPointed>?,
            COpaquePointer?) -> Unit>>(widgetPtr!!, this, "color-set",
            staticCFunction(::ColorButton_onColorSet_Handler)) }

    /**
     * Gets the title of the color selection dialog.
     *
     * Sets the title for the color selection dialog. */
    var title: String
        get() = gtk_color_button_get_title(self)?.toKString() ?: ""
        set(value) {
            gtk_color_button_set_title(self, value)
        }

    /**
     * Creates a new color button.
     *
     * This returns a widget in the form of a small button containing
     * a swatch representing the current selected color. When the button
     * is clicked, a color-selection dialog will open, allowing the user
     * to select a color. The swatch will be updated to reflect the new
     * color when the user finishes. */
    constructor() : this(gtk_color_button_new()?.reinterpret())
}

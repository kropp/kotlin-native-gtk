package gtk3

import kotlin.Boolean
import kotlin.String
import kotlin.Unit
import kotlinx.cinterop.CFunction
import kotlinx.cinterop.COpaquePointer
import kotlinx.cinterop.CPointer
import kotlinx.cinterop.asStableRef
import kotlinx.cinterop.reinterpret
import kotlinx.cinterop.staticCFunction
import kotlinx.cinterop.toKString
import libgtk3.GtkFontButton
import libgtk3.GtkWidget
import libgtk3.gtk_false
import libgtk3.gtk_font_button_get_show_size
import libgtk3.gtk_font_button_get_show_style
import libgtk3.gtk_font_button_get_title
import libgtk3.gtk_font_button_get_use_font
import libgtk3.gtk_font_button_get_use_size
import libgtk3.gtk_font_button_new
import libgtk3.gtk_font_button_set_show_size
import libgtk3.gtk_font_button_set_show_style
import libgtk3.gtk_font_button_set_title
import libgtk3.gtk_font_button_set_use_font
import libgtk3.gtk_font_button_set_use_size
import libgtk3.gtk_true

inline fun Container.fontButton(init: FontButton.() -> Unit = {}): FontButton = FontButton().apply { init(); this@fontButton.add(this) }

private fun FontButton_onFontSet_Handler(sender: CPointer<*>?, data: COpaquePointer?) {
    data?.asStableRef<FontButton>()?.get()?.onFontSet?.invoke()
}

/**
 * The #GtkFontButton is a button which displays the currently selected
 * font an allows to open a font chooser dialog to change the font.
 * It is suitable widget for selecting a font in a preference dialog.
 *
 * # CSS nodes
 *
 * GtkFontButton has a single CSS node with name button and style class .font. */
@GtkDsl
open class FontButton internal constructor(override val widgetPtr: CPointer<GtkWidget>? = null) : Button() {
    private val self: CPointer<GtkFontButton>?
        get() = widgetPtr!!.reinterpret()

    val fontButton: CPointer<GtkFontButton>?
        get() = widgetPtr!!.reinterpret()

    val onFontSet: Signal<FontButton, CFunction<(CPointer<*>?, COpaquePointer?) -> Unit>> by lazy { Signal<FontButton, CFunction<(CPointer<*>?, COpaquePointer?) -> Unit>>(widgetPtr!!, this, "font-set", staticCFunction(::FontButton_onFontSet_Handler)) }

    var showSize: Boolean
        /**
         * Returns whether the font size will be shown in the label. */
        get() = gtk_font_button_get_show_size(self) != 0
        /**
         * If @show_size is %TRUE, the font size will be displayed along with the name of the selected font. */
        set(value) {
            gtk_font_button_set_show_size(self, if (value) gtk_true() else gtk_false())
        }

    var showStyle: Boolean
        /**
         * Returns whether the name of the font style will be shown in the label. */
        get() = gtk_font_button_get_show_style(self) != 0
        /**
         * If @show_style is %TRUE, the font style will be displayed along with name of the selected font. */
        set(value) {
            gtk_font_button_set_show_style(self, if (value) gtk_true() else gtk_false())
        }

    var title: String
        /**
         * Retrieves the title of the font chooser dialog. */
        get() = gtk_font_button_get_title(self)?.toKString() ?: ""
        /**
         * Sets the title for the font chooser dialog. */
        set(value) {
            gtk_font_button_set_title(self, value)
        }

    var useFont: Boolean
        /**
         * Returns whether the selected font is used in the label. */
        get() = gtk_font_button_get_use_font(self) != 0
        /**
         * If @use_font is %TRUE, the font name will be written using the selected font. */
        set(value) {
            gtk_font_button_set_use_font(self, if (value) gtk_true() else gtk_false())
        }

    var useSize: Boolean
        /**
         * Returns whether the selected size is used in the label. */
        get() = gtk_font_button_get_use_size(self) != 0
        /**
         * If @use_size is %TRUE, the font name will be written using the selected size. */
        set(value) {
            gtk_font_button_set_use_size(self, if (value) gtk_true() else gtk_false())
        }

    /**
     * Creates a new font picker widget. */
    constructor() : this(gtk_font_button_new()?.reinterpret())
}

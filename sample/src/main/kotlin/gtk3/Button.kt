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
import libgtk3.GdkWindow
import libgtk3.GtkButton
import libgtk3.GtkPositionType
import libgtk3.GtkReliefStyle
import libgtk3.GtkWidget
import libgtk3.gtk_button_clicked
import libgtk3.gtk_button_get_always_show_image
import libgtk3.gtk_button_get_event_window
import libgtk3.gtk_button_get_image
import libgtk3.gtk_button_get_image_position
import libgtk3.gtk_button_get_label
import libgtk3.gtk_button_get_relief
import libgtk3.gtk_button_get_use_underline
import libgtk3.gtk_button_new
import libgtk3.gtk_button_set_always_show_image
import libgtk3.gtk_button_set_image
import libgtk3.gtk_button_set_image_position
import libgtk3.gtk_button_set_label
import libgtk3.gtk_button_set_relief
import libgtk3.gtk_button_set_use_underline
import libgtk3.gtk_false
import libgtk3.gtk_true

inline fun Container.button(init: Button.() -> Unit = {}): Button = Button().apply { init(); this@button.add(this) }

private fun Button_onActivate_Handler(sender: CPointer<*>?, data: COpaquePointer?) {
    data?.asStableRef<Button>()?.get()?.onActivate?.invoke()
}

private fun Button_onClicked_Handler(sender: CPointer<*>?, data: COpaquePointer?) {
    data?.asStableRef<Button>()?.get()?.onClicked?.invoke()
}

private fun Button_onEnter_Handler(sender: CPointer<*>?, data: COpaquePointer?) {
    data?.asStableRef<Button>()?.get()?.onEnter?.invoke()
}

private fun Button_onLeave_Handler(sender: CPointer<*>?, data: COpaquePointer?) {
    data?.asStableRef<Button>()?.get()?.onLeave?.invoke()
}

private fun Button_onPressed_Handler(sender: CPointer<*>?, data: COpaquePointer?) {
    data?.asStableRef<Button>()?.get()?.onPressed?.invoke()
}

private fun Button_onReleased_Handler(sender: CPointer<*>?, data: COpaquePointer?) {
    data?.asStableRef<Button>()?.get()?.onReleased?.invoke()
}

/**
 * The #GtkButton widget is generally used to trigger a callback function that is
 * called when the button is pressed.  The various signals and how to use them
 * are outlined below.
 *
 * The #GtkButton widget can hold any valid child widget.  That is, it can hold
 * almost any other standard #GtkWidget.  The most commonly used child is the
 * #GtkLabel.
 *
 * # CSS nodes
 *
 * GtkButton has a single CSS node with name button. The node will get the
 * style classes .image-button or .text-button, if the content is just an
 * image or label, respectively. It may also receive the .flat style class.
 *
 * Other style classes that are commonly used with GtkButton include
 * .suggested-action and .destructive-action. In special cases, buttons
 * can be made round by adding the .circular style class.
 *
 * Button-like widgets like #GtkToggleButton, #GtkMenuButton, #GtkVolumeButton,
 * #GtkLockButton, #GtkColorButton, #GtkFontButton or #GtkFileChooserButton use
 * style classes such as .toggle, .popup, .scale, .lock, .color, .font, .file
 * to differentiate themselves from a plain GtkButton. */
@GtkDsl
open class Button internal constructor(override val widgetPtr: CPointer<GtkWidget>? = null) : Bin() {
    private val self: CPointer<GtkButton>?
        get() = widgetPtr!!.reinterpret()

    val button: CPointer<GtkButton>?
        get() = widgetPtr!!.reinterpret()

    val onActivate: Signal<Button, CFunction<(CPointer<*>?, COpaquePointer?) -> Unit>> by lazy { Signal<Button, CFunction<(CPointer<*>?, COpaquePointer?) -> Unit>>(widgetPtr!!, this, "activate", staticCFunction(::Button_onActivate_Handler)) }

    val onClicked: Signal<Button, CFunction<(CPointer<*>?, COpaquePointer?) -> Unit>> by lazy { Signal<Button, CFunction<(CPointer<*>?, COpaquePointer?) -> Unit>>(widgetPtr!!, this, "clicked", staticCFunction(::Button_onClicked_Handler)) }

    val onEnter: Signal<Button, CFunction<(CPointer<*>?, COpaquePointer?) -> Unit>> by lazy { Signal<Button, CFunction<(CPointer<*>?, COpaquePointer?) -> Unit>>(widgetPtr!!, this, "enter", staticCFunction(::Button_onEnter_Handler)) }

    val onLeave: Signal<Button, CFunction<(CPointer<*>?, COpaquePointer?) -> Unit>> by lazy { Signal<Button, CFunction<(CPointer<*>?, COpaquePointer?) -> Unit>>(widgetPtr!!, this, "leave", staticCFunction(::Button_onLeave_Handler)) }

    val onPressed: Signal<Button, CFunction<(CPointer<*>?, COpaquePointer?) -> Unit>> by lazy { Signal<Button, CFunction<(CPointer<*>?, COpaquePointer?) -> Unit>>(widgetPtr!!, this, "pressed", staticCFunction(::Button_onPressed_Handler)) }

    val onReleased: Signal<Button, CFunction<(CPointer<*>?, COpaquePointer?) -> Unit>> by lazy { Signal<Button, CFunction<(CPointer<*>?, COpaquePointer?) -> Unit>>(widgetPtr!!, this, "released", staticCFunction(::Button_onReleased_Handler)) }

    var alwaysShowImage: Boolean
        /**
         * Returns whether the button will ignore the #GtkSettings:gtk-button-images
         * setting and always show the image, if available. */
        get() = gtk_button_get_always_show_image(self) != 0
        /**
         * If %TRUE, the button will ignore the #GtkSettings:gtk-button-images
         * setting and always show the image, if available.
         *
         * Use this property if the button  would be useless or hard to use
         * without the image. */
        set(value) {
            gtk_button_set_always_show_image(self, if (value) gtk_true() else gtk_false())
        }

    val eventWindow: CPointer<GdkWindow>?
        /**
         * Returns the button’s event window if it is realized, %NULL otherwise.
         * This function should be rarely needed. */
        get() = gtk_button_get_event_window(self)!!.reinterpret()

    var image: CPointer<GtkWidget>?
        /**
         * Gets the widget that is currenty set as the image of @button.
         * This may have been explicitly set by gtk_button_set_image()
         * or constructed by gtk_button_new_from_stock(). */
        get() = gtk_button_get_image(self)!!.reinterpret()
        /**
         * Set the image of @button to the given widget. The image will be
         * displayed if the label text is %NULL or if
         * #GtkButton:always-show-image is %TRUE. You don’t have to call
         * gtk_widget_show() on @image yourself. */
        set(value) {
            gtk_button_set_image(self, value?.reinterpret())
        }

    var imagePosition: GtkPositionType
        /**
         * Gets the position of the image relative to the text
         * inside the button. */
        get() = gtk_button_get_image_position(self)
        /**
         * Sets the position of the image relative to the text
         * inside the button. */
        set(value) {
            gtk_button_set_image_position(self, value)
        }

    var label: String
        /**
         * Fetches the text from the label of the button, as set by
         * gtk_button_set_label(). If the label text has not
         * been set the return value will be %NULL. This will be the
         * case if you create an empty button with gtk_button_new() to
         * use as a container. */
        get() = gtk_button_get_label(self)?.toKString() ?: ""
        /**
         * Sets the text of the label of the button to @str. This text is
         * also used to select the stock item if gtk_button_set_use_stock()
         * is used.
         *
         * This will also clear any previously set labels. */
        set(value) {
            gtk_button_set_label(self, value)
        }

    var relief: GtkReliefStyle
        /**
         * Returns the current relief style of the given #GtkButton. */
        get() = gtk_button_get_relief(self)
        /**
         * Sets the relief style of the edges of the given #GtkButton widget.
         * Two styles exist, %GTK_RELIEF_NORMAL and %GTK_RELIEF_NONE.
         * The default style is, as one can guess, %GTK_RELIEF_NORMAL.
         * The deprecated value %GTK_RELIEF_HALF behaves the same as
         * %GTK_RELIEF_NORMAL. */
        set(value) {
            gtk_button_set_relief(self, value)
        }

    var useUnderline: Boolean
        /**
         * Returns whether an embedded underline in the button label indicates a
         * mnemonic. See gtk_button_set_use_underline (). */
        get() = gtk_button_get_use_underline(self) != 0
        /**
         * If true, an underline in the text of the button label indicates
         * the next character should be used for the mnemonic accelerator key. */
        set(value) {
            gtk_button_set_use_underline(self, if (value) gtk_true() else gtk_false())
        }

    /**
     * Creates a new #GtkButton widget. To add a child widget to the button,
     * use gtk_container_add(). */
    constructor() : this(gtk_button_new()?.reinterpret())

    /**
     * Emits a #GtkButton::clicked signal to the given #GtkButton. */
    fun clicked(): Unit = gtk_button_clicked(self)
}

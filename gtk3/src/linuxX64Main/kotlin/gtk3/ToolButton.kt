package gtk3

import kotlin.Boolean
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
import libgtk3.GtkToolButton
import libgtk3.GtkWidget
import libgtk3.gtk_false
import libgtk3.gtk_tool_button_get_icon_name
import libgtk3.gtk_tool_button_get_icon_widget
import libgtk3.gtk_tool_button_get_label
import libgtk3.gtk_tool_button_get_label_widget
import libgtk3.gtk_tool_button_get_use_underline
import libgtk3.gtk_tool_button_new
import libgtk3.gtk_tool_button_set_icon_name
import libgtk3.gtk_tool_button_set_icon_widget
import libgtk3.gtk_tool_button_set_label
import libgtk3.gtk_tool_button_set_label_widget
import libgtk3.gtk_tool_button_set_use_underline
import libgtk3.gtk_true

inline fun Container.toolButton(
    icon_widget: CPointer<GtkWidget>,
    label: String,
    init: ToolButton.() -> Unit = {}
): ToolButton = ToolButton(icon_widget, label).apply { init(); this@toolButton.add(this) }

private fun ToolButton_onClicked_Handler(sender: CPointer<in CPointed>?, _data: COpaquePointer?) {
    _data?.asStableRef<ToolButton>()?.get()?.onClicked?.emit()
}

/**
 * #GtkToolButtons are #GtkToolItems containing buttons.
 *
 * Use gtk_tool_button_new() to create a new #GtkToolButton.
 *
 * The label of a #GtkToolButton is determined by the properties
 * #GtkToolButton:label-widget, #GtkToolButton:label, and
 * #GtkToolButton:stock-id. If #GtkToolButton:label-widget is
 * non-%NULL, then that widget is used as the label. Otherwise, if
 * #GtkToolButton:label is non-%NULL, that string is used as the label.
 * Otherwise, if #GtkToolButton:stock-id is non-%NULL, the label is
 * determined by the stock item. Otherwise, the button does not have a label.
 *
 * The icon of a #GtkToolButton is determined by the properties
 * #GtkToolButton:icon-widget and #GtkToolButton:stock-id. If
 * #GtkToolButton:icon-widget is non-%NULL, then
 * that widget is used as the icon. Otherwise, if #GtkToolButton:stock-id is
 * non-%NULL, the icon is determined by the stock item. Otherwise,
 * the button does not have a icon.
 *
 * # CSS nodes
 *
 * GtkToolButton has a single CSS node with name toolbutton.
 */
@GtkDsl
open class ToolButton internal constructor(override val widgetPtr: CPointer<GtkWidget>? = null) :
        ToolItem() {
    private val self: CPointer<GtkToolButton>?
        get() = widgetPtr!!.reinterpret()

    val toolButton: CPointer<GtkToolButton>?
        get() = widgetPtr!!.reinterpret()

    val onClicked: Signal<ToolButton, CFunction<(CPointer<in CPointed>?, COpaquePointer?) -> Unit>>
            by lazy { Signal<ToolButton, CFunction<(CPointer<in CPointed>?, COpaquePointer?) ->
            Unit>>(widgetPtr!!, this, "clicked", staticCFunction(::ToolButton_onClicked_Handler)) }

    /**
     * Returns the name of the themed icon for the tool button,
     * see gtk_tool_button_set_icon_name().
     *
     * Sets the icon for the tool button from a named themed icon.
     * See the docs for #GtkIconTheme for more details.
     * The #GtkToolButton:icon-name property only has an effect if not
     * overridden by non-%NULL #GtkToolButton:label-widget,
     * #GtkToolButton:icon-widget and #GtkToolButton:stock-id properties. */
    var iconName: String
        get() = gtk_tool_button_get_icon_name(self)?.toKString() ?: ""
        set(value) {
            gtk_tool_button_set_icon_name(self, value)
        }

    /**
     * Return the widget used as icon widget on @button.
     * See gtk_tool_button_set_icon_widget().
     *
     * Sets @icon as the widget used as icon on @button. If @icon_widget is
     * %NULL the icon is determined by the #GtkToolButton:stock-id property. If the
     * #GtkToolButton:stock-id property is also %NULL, @button will not have an icon. */
    var iconWidget: CPointer<GtkWidget>
        get() = gtk_tool_button_get_icon_widget(self)!!.reinterpret()
        set(value) {
            gtk_tool_button_set_icon_widget(self, value?.reinterpret())
        }

    /**
     * Returns the label used by the tool button, or %NULL if the tool button
     * doesn’t have a label. or uses a the label from a stock item. The returned
     * string is owned by GTK+, and must not be modified or freed.
     *
     * Sets @label as the label used for the tool button. The #GtkToolButton:label
     * property only has an effect if not overridden by a non-%NULL
     * #GtkToolButton:label-widget property. If both the #GtkToolButton:label-widget
     * and #GtkToolButton:label properties are %NULL, the label is determined by the
     * #GtkToolButton:stock-id property. If the #GtkToolButton:stock-id property is
     * also %NULL, @button will not have a label. */
    var label: String
        get() = gtk_tool_button_get_label(self)?.toKString() ?: ""
        set(value) {
            gtk_tool_button_set_label(self, value)
        }

    /**
     * Returns the widget used as label on @button.
     * See gtk_tool_button_set_label_widget().
     *
     * Sets @label_widget as the widget that will be used as the label
     * for @button. If @label_widget is %NULL the #GtkToolButton:label property is used
     * as label. If #GtkToolButton:label is also %NULL, the label in the stock item
     * determined by the #GtkToolButton:stock-id property is used as label. If
     * #GtkToolButton:stock-id is also %NULL, @button does not have a label. */
    var labelWidget: CPointer<GtkWidget>
        get() = gtk_tool_button_get_label_widget(self)!!.reinterpret()
        set(value) {
            gtk_tool_button_set_label_widget(self, value?.reinterpret())
        }

    /**
     * Returns whether underscores in the label property are used as mnemonics
     * on menu items on the overflow menu. See gtk_tool_button_set_use_underline().
     *
     * If set, an underline in the label property indicates that the next character
     * should be used for the mnemonic accelerator key in the overflow menu. For
     * example, if the label property is “_Open” and @use_underline is %TRUE,
     * the label on the tool button will be “Open” and the item on the overflow
     * menu will have an underlined “O”.
     *
     * Labels shown on tool buttons never have mnemonics on them; this property
     * only affects the menu item on the overflow menu. */
    var useUnderline: Boolean
        get() = gtk_tool_button_get_use_underline(self) != 0
        set(value) {
            gtk_tool_button_set_use_underline(self, if (value) gtk_true() else gtk_false())
        }

    /**
     * Creates a new #GtkToolButton using @icon_widget as contents and @label as
     * label. */
    constructor(icon_widget: CPointer<GtkWidget>, label: String) :
            this(gtk_tool_button_new(icon_widget?.reinterpret(), label)?.reinterpret())
}

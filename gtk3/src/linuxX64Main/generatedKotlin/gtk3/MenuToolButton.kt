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
import libgtk3.GtkMenuToolButton
import libgtk3.GtkWidget
import libgtk3.gtk_menu_tool_button_get_menu
import libgtk3.gtk_menu_tool_button_new
import libgtk3.gtk_menu_tool_button_set_arrow_tooltip_markup
import libgtk3.gtk_menu_tool_button_set_arrow_tooltip_text
import libgtk3.gtk_menu_tool_button_set_menu

inline fun Container.menuToolButton(
    icon_widget: CPointer<GtkWidget>,
    label: String,
    init: MenuToolButton.() -> Unit = {}
): MenuToolButton = MenuToolButton(icon_widget, label).apply { init(); this@menuToolButton.add(this)
        }

private fun MenuToolButton_onShowMenu_Handler(sender: CPointer<in CPointed>?, _data:
        COpaquePointer?) {
    _data?.asStableRef<MenuToolButton>()?.get()?.onShowMenu?.emit()
}

/**
 * A #GtkMenuToolButton is a #GtkToolItem that contains a button and
 * a small additional button with an arrow. When clicked, the arrow
 * button pops up a dropdown menu.
 *
 * Use gtk_menu_tool_button_new() to create a new
 * #GtkMenuToolButton.
 *
 * # GtkMenuToolButton as GtkBuildable
 *
 * The GtkMenuToolButton implementation of the GtkBuildable interface
 * supports adding a menu by specifying “menu” as the “type” attribute
 * of a <child> element.
 *
 * An example for a UI definition fragment with menus:
 * |[
 * <object class="GtkMenuToolButton">
 *   <child type="menu">
 *     <object class="GtkMenu"/>
 *   </child>
 * </object>
 * ]|
 */
@GtkDsl
open class MenuToolButton internal constructor(override val widgetPtr: CPointer<GtkWidget>? = null)
        : ToolButton() {
    private val self: CPointer<GtkMenuToolButton>?
        get() = widgetPtr!!.reinterpret()

    val menuToolButton: CPointer<GtkMenuToolButton>?
        get() = widgetPtr!!.reinterpret()

    val onShowMenu: Signal<MenuToolButton, CFunction<(CPointer<in CPointed>?, COpaquePointer?) ->
            Unit>> by lazy { Signal<MenuToolButton, CFunction<(CPointer<in CPointed>?,
            COpaquePointer?) -> Unit>>(widgetPtr!!, this, "show-menu",
            staticCFunction(::MenuToolButton_onShowMenu_Handler)) }

    /**
     * Gets the #GtkMenu associated with #GtkMenuToolButton.
     *
     * Sets the #GtkMenu that is popped up when the user clicks on the arrow.
     * If @menu is NULL, the arrow button becomes insensitive. */
    var menu: CPointer<GtkWidget>
        get() = gtk_menu_tool_button_get_menu(self)!!.reinterpret()
        set(value) {
            gtk_menu_tool_button_set_menu(self, value?.reinterpret())
        }

    /**
     * Creates a new #GtkMenuToolButton using @icon_widget as icon and
     * @label as label. */
    constructor(icon_widget: CPointer<GtkWidget>, label: String) :
            this(gtk_menu_tool_button_new(icon_widget?.reinterpret(), label)?.reinterpret())

    /**
     * Sets the tooltip markup text to be used as tooltip for the arrow button
     * which pops up the menu.  See gtk_tool_item_set_tooltip_text() for setting
     * a tooltip on the whole #GtkMenuToolButton.
     */
    fun setArrowTooltipMarkup(markup: String): Unit =
            gtk_menu_tool_button_set_arrow_tooltip_markup(self, markup)

    /**
     * Sets the tooltip text to be used as tooltip for the arrow button which
     * pops up the menu.  See gtk_tool_item_set_tooltip_text() for setting a tooltip
     * on the whole #GtkMenuToolButton.
     */
    fun setArrowTooltipText(text: String): Unit = gtk_menu_tool_button_set_arrow_tooltip_text(self,
            text)
}

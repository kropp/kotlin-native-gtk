package gtk3

import kotlin.Boolean
import kotlin.Unit
import kotlinx.cinterop.CPointer
import kotlinx.cinterop.reinterpret
import libgtk3.GMenuModel
import libgtk3.GtkMenu
import libgtk3.GtkMenuButton
import libgtk3.GtkPopover
import libgtk3.GtkWidget
import libgtk3.gtk_false
import libgtk3.gtk_menu_button_get_align_widget
import libgtk3.gtk_menu_button_get_menu_model
import libgtk3.gtk_menu_button_get_popover
import libgtk3.gtk_menu_button_get_popup
import libgtk3.gtk_menu_button_get_use_popover
import libgtk3.gtk_menu_button_new
import libgtk3.gtk_menu_button_set_align_widget
import libgtk3.gtk_menu_button_set_menu_model
import libgtk3.gtk_menu_button_set_popover
import libgtk3.gtk_menu_button_set_popup
import libgtk3.gtk_menu_button_set_use_popover
import libgtk3.gtk_true

inline fun Container.menuButton(init: MenuButton.() -> Unit = {}): MenuButton =
        MenuButton().apply { init(); this@menuButton.add(this) }

/**
 * The #GtkMenuButton widget is used to display a popup when clicked on.
 * This popup can be provided either as a #GtkMenu, a #GtkPopover or an
 * abstract #GMenuModel.
 *
 * The #GtkMenuButton widget can hold any valid child widget. That is, it
 * can hold almost any other standard #GtkWidget. The most commonly used
 * child is #GtkImage. If no widget is explicitely added to the #GtkMenuButton,
 * a #GtkImage is automatically created, using an arrow image oriented
 * according to #GtkMenuButton:direction or the generic “open-menu-symbolic”
 * icon if the direction is not set.
 *
 * The positioning of the popup is determined by the #GtkMenuButton:direction
 * property of the menu button.
 *
 * For menus, the #GtkWidget:halign and #GtkWidget:valign properties of the
 * menu are also taken into account. For example, when the direction is
 * %GTK_ARROW_DOWN and the horizontal alignment is %GTK_ALIGN_START, the
 * menu will be positioned below the button, with the starting edge
 * (depending on the text direction) of the menu aligned with the starting
 * edge of the button. If there is not enough space below the button, the
 * menu is popped up above the button instead. If the alignment would move
 * part of the menu offscreen, it is “pushed in”.
 *
 * ## Direction = Down
 *
 * - halign = start
 *
 *     ![](down-start.png)
 *
 * - halign = center
 *
 *     ![](down-center.png)
 *
 * - halign = end
 *
 *     ![](down-end.png)
 *
 * ## Direction = Up
 *
 * - halign = start
 *
 *     ![](up-start.png)
 *
 * - halign = center
 *
 *     ![](up-center.png)
 *
 * - halign = end
 *
 *     ![](up-end.png)
 *
 * ## Direction = Left
 *
 * - valign = start
 *
 *     ![](left-start.png)
 *
 * - valign = center
 *
 *     ![](left-center.png)
 *
 * - valign = end
 *
 *     ![](left-end.png)
 *
 * ## Direction = Right
 *
 * - valign = start
 *
 *     ![](right-start.png)
 *
 * - valign = center
 *
 *     ![](right-center.png)
 *
 * - valign = end
 *
 *     ![](right-end.png)
 *
 * # CSS nodes
 *
 * GtkMenuButton has a single CSS node with name button. To differentiate
 * it from a plain #GtkButton, it gets the .popup style class.
 */
@GtkDsl
open class MenuButton internal constructor(override val widgetPtr: CPointer<GtkWidget>? = null) :
        ToggleButton() {
    private val self: CPointer<GtkMenuButton>?
        get() = widgetPtr!!.reinterpret()

    val menuButton: CPointer<GtkMenuButton>?
        get() = widgetPtr!!.reinterpret()

    /**
     * Returns the parent #GtkWidget to use to line up with menu.
     *
     * Sets the #GtkWidget to use to line the menu with when popped up.
     * Note that the @align_widget must contain the #GtkMenuButton itself.
     *
     * Setting it to %NULL means that the menu will be aligned with the
     * button itself.
     *
     * Note that this property is only used with menus currently,
     * and not for popovers. */
    var alignWidget: CPointer<GtkWidget>
        get() = gtk_menu_button_get_align_widget(self)!!.reinterpret()
        set(value) {
            gtk_menu_button_set_align_widget(self, value?.reinterpret())
        }

    /**
     * Returns the #GMenuModel used to generate the popup.
     *
     * Sets the #GMenuModel from which the popup will be constructed,
     * or %NULL to dissociate any existing menu model and disable the button.
     *
     * Depending on the value of #GtkMenuButton:use-popover, either a
     * #GtkMenu will be created with gtk_menu_new_from_model(), or a
     * #GtkPopover with gtk_popover_new_from_model(). In either case,
     * actions will be connected as documented for these functions.
     *
     * If #GtkMenuButton:popup or #GtkMenuButton:popover are already set, those
     * widgets are dissociated from the @menu_button, and those properties are set
     * to %NULL. */
    var menuModel: CPointer<GMenuModel>
        get() = gtk_menu_button_get_menu_model(self)!!.reinterpret()
        set(value) {
            gtk_menu_button_set_menu_model(self, value?.reinterpret())
        }

    /**
     * Returns the #GtkPopover that pops out of the button.
     * If the button is not using a #GtkPopover, this function
     * returns %NULL.
     *
     * Sets the #GtkPopover that will be popped up when the @menu_button is clicked,
     * or %NULL to dissociate any existing popover and disable the button.
     *
     * If #GtkMenuButton:menu-model or #GtkMenuButton:popup are set, those objects
     * are dissociated from the @menu_button, and those properties are set to %NULL. */
    var popover: CPointer<GtkPopover>
        get() = gtk_menu_button_get_popover(self)!!.reinterpret()
        set(value) {
            gtk_menu_button_set_popover(self, value?.reinterpret())
        }

    /**
     * Returns the #GtkMenu that pops out of the button.
     * If the button does not use a #GtkMenu, this function
     * returns %NULL.
     *
     * Sets the #GtkMenu that will be popped up when the @menu_button is clicked, or
     * %NULL to dissociate any existing menu and disable the button.
     *
     * If #GtkMenuButton:menu-model or #GtkMenuButton:popover are set, those objects
     * are dissociated from the @menu_button, and those properties are set to %NULL. */
    var popup: CPointer<GtkMenu>
        get() = gtk_menu_button_get_popup(self)!!.reinterpret()
        set(value) {
            gtk_menu_button_set_popup(self, value?.reinterpret())
        }

    /**
     * Returns whether a #GtkPopover or a #GtkMenu will be constructed
     * from the menu model.
     *
     * Sets whether to construct a #GtkPopover instead of #GtkMenu
     * when gtk_menu_button_set_menu_model() is called. Note that
     * this property is only consulted when a new menu model is set. */
    var usePopover: Boolean
        get() = gtk_menu_button_get_use_popover(self) != 0
        set(value) {
            gtk_menu_button_set_use_popover(self, if (value) gtk_true() else gtk_false())
        }

    /**
     * Creates a new #GtkMenuButton widget with downwards-pointing
     * arrow as the only child. You can replace the child widget
     * with another #GtkWidget should you wish to. */
    constructor() : this(gtk_menu_button_new()?.reinterpret())
}

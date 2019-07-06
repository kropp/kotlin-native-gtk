package gtk3

import kotlin.Boolean
import kotlin.Int
import kotlin.String
import kotlin.UInt
import kotlin.Unit
import kotlinx.cinterop.CPointer
import kotlinx.cinterop.asStableRef
import kotlinx.cinterop.reinterpret
import kotlinx.cinterop.staticCFunction
import kotlinx.cinterop.toKString
import libgtk3.GdkEvent
import libgtk3.GdkGravity
import libgtk3.GdkMonitor
import libgtk3.GdkRectangle
import libgtk3.GdkWindow
import libgtk3.GtkAccelGroup
import libgtk3.GtkMenu
import libgtk3.GtkWidget
import libgtk3.gtk_false
import libgtk3.gtk_menu_attach
import libgtk3.gtk_menu_detach
import libgtk3.gtk_menu_get_accel_group
import libgtk3.gtk_menu_get_accel_path
import libgtk3.gtk_menu_get_attach_widget
import libgtk3.gtk_menu_get_monitor
import libgtk3.gtk_menu_get_reserve_toggle_size
import libgtk3.gtk_menu_new
import libgtk3.gtk_menu_place_on_monitor
import libgtk3.gtk_menu_popdown
import libgtk3.gtk_menu_popup_at_pointer
import libgtk3.gtk_menu_popup_at_rect
import libgtk3.gtk_menu_popup_at_widget
import libgtk3.gtk_menu_reorder_child
import libgtk3.gtk_menu_reposition
import libgtk3.gtk_menu_set_accel_group
import libgtk3.gtk_menu_set_accel_path
import libgtk3.gtk_menu_set_monitor
import libgtk3.gtk_menu_set_reserve_toggle_size
import libgtk3.gtk_true

inline fun Container.menu(init: Menu.() -> Unit = {}): Menu = Menu().apply { init();
        this@menu.add(this) }

/**
 * A #GtkMenu is a #GtkMenuShell that implements a drop down menu
 * consisting of a list of #GtkMenuItem objects which can be navigated
 * and activated by the user to perform application functions.
 *
 * A #GtkMenu is most commonly dropped down by activating a
 * #GtkMenuItem in a #GtkMenuBar or popped up by activating a
 * #GtkMenuItem in another #GtkMenu.
 *
 * A #GtkMenu can also be popped up by activating a #GtkComboBox.
 * Other composite widgets such as the #GtkNotebook can pop up a
 * #GtkMenu as well.
 *
 * Applications can display a #GtkMenu as a popup menu by calling the
 * gtk_menu_popup() function.  The example below shows how an application
 * can pop up a menu when the 3rd mouse button is pressed.
 *
 * ## Connecting the popup signal handler.
 *
 * |[<!-- language="C" -->
 *   // connect our handler which will popup the menu
 *   g_signal_connect_swapped (window, "button_press_event",
 * G_CALLBACK (my_popup_handler), menu);
 * ]|
 *
 * ## Signal handler which displays a popup menu.
 *
 * |[<!-- language="C" -->
 * static gint
 * my_popup_handler (GtkWidget *widget, GdkEvent *event)
 * {
 *   GtkMenu *menu;
 *   GdkEventButton *event_button;
 *
 *   g_return_val_if_fail (widget != NULL, FALSE);
 *   g_return_val_if_fail (GTK_IS_MENU (widget), FALSE);
 *   g_return_val_if_fail (event != NULL, FALSE);
 *
 *   // The "widget" is the menu that was supplied when
 *   // g_signal_connect_swapped() was called.
 *   menu = GTK_MENU (widget);
 *
 *   if (event->type == GDK_BUTTON_PRESS)
 *     {
 *       event_button = (GdkEventButton *) event;
 *       if (event_button->button == GDK_BUTTON_SECONDARY)
 *         {
 *           gtk_menu_popup (menu, NULL, NULL, NULL, NULL,
 *                           event_button->button, event_button->time);
 *           return TRUE;
 *         }
 *     }
 *
 *   return FALSE;
 * }
 * ]|
 *
 * # CSS nodes
 *
 * |[<!-- language="plain" -->
 * menu
 * ├── arrow.top
 * ├── <child>
 * ┊
 * ├── <child>
 * ╰── arrow.bottom
 * ]|
 *
 * The main CSS node of GtkMenu has name menu, and there are two subnodes
 * with name arrow, for scrolling menu arrows. These subnodes get the
 * .top and .bottom style classes.Returns the #GtkWidget that the menu is attached to.
 */
@GtkDsl
open class Menu internal constructor(override val widgetPtr: CPointer<GtkWidget>? = null) :
        MenuShell() {
    private val self: CPointer<GtkMenu>?
        get() = widgetPtr!!.reinterpret()

    val menu: CPointer<GtkMenu>?
        get() = widgetPtr!!.reinterpret()

    /**
     * Gets the #GtkAccelGroup which holds global accelerators for the
     * menu. See gtk_menu_set_accel_group().
     *
     * Set the #GtkAccelGroup which holds global accelerators for the
     * menu.  This accelerator group needs to also be added to all windows
     * that this menu is being used in with gtk_window_add_accel_group(),
     * in order for those windows to support all the accelerators
     * contained in this group. */
    var accelGroup: CPointer<GtkAccelGroup>
        get() = gtk_menu_get_accel_group(self)!!.reinterpret()
        set(value) {
            gtk_menu_set_accel_group(self, value?.reinterpret())
        }

    /**
     * Retrieves the accelerator path set on the menu.
     *
     * Sets an accelerator path for this menu from which accelerator paths
     * for its immediate children, its menu items, can be constructed.
     * The main purpose of this function is to spare the programmer the
     * inconvenience of having to call gtk_menu_item_set_accel_path() on
     * each menu item that should support runtime user changable accelerators.
     * Instead, by just calling gtk_menu_set_accel_path() on their parent,
     * each menu item of this menu, that contains a label describing its
     * purpose, automatically gets an accel path assigned.
     *
     * For example, a menu containing menu items “New” and “Exit”, will, after
     * `gtk_menu_set_accel_path (menu, "<Gnumeric-Sheet>/File");` has been
     * called, assign its items the accel paths: `"<Gnumeric-Sheet>/File/New"`
     * and `"<Gnumeric-Sheet>/File/Exit"`.
     *
     * Assigning accel paths to menu items then enables the user to change
     * their accelerators at runtime. More details about accelerator paths
     * and their default setups can be found at gtk_accel_map_add_entry().
     *
     * Note that @accel_path string will be stored in a #GQuark. Therefore,
     * if you pass a static string, you can save some memory by interning
     * it first with g_intern_static_string(). */
    var accelPath: String
        get() = gtk_menu_get_accel_path(self)?.toKString() ?: ""
        set(value) {
            gtk_menu_set_accel_path(self, value)
        }

    val attachWidget: CPointer<GtkWidget>
        get() = gtk_menu_get_attach_widget(self)!!.reinterpret()

    /**
     * Retrieves the number of the monitor on which to show the menu.
     *
     * Informs GTK+ on which monitor a menu should be popped up.
     * See gdk_monitor_get_geometry().
     *
     * This function should be called from a #GtkMenuPositionFunc
     * if the menu should not appear on the same monitor as the pointer.
     * This information can’t be reliably inferred from the coordinates
     * returned by a #GtkMenuPositionFunc, since, for very long menus,
     * these coordinates may extend beyond the monitor boundaries or even
     * the screen boundaries. */
    var monitor: Int
        get() = gtk_menu_get_monitor(self)
        set(value) {
            gtk_menu_set_monitor(self, value)
        }

    /**
     * Returns whether the menu reserves space for toggles and
     * icons, regardless of their actual presence.
     *
     * Sets whether the menu should reserve space for drawing toggles
     * or icons, regardless of their actual presence. */
    var reserveToggleSize: Boolean
        get() = gtk_menu_get_reserve_toggle_size(self) != 0
        set(value) {
            gtk_menu_set_reserve_toggle_size(self, if (value) gtk_true() else gtk_false())
        }

    /**
     * Creates a new #GtkMenu */
    constructor() : this(gtk_menu_new()?.reinterpret())

    /**
     * Adds a new #GtkMenuItem to a (table) menu. The number of “cells” that
     * an item will occupy is specified by @left_attach, @right_attach,
     * @top_attach and @bottom_attach. These each represent the leftmost,
     * rightmost, uppermost and lower column and row numbers of the table.
     * (Columns and rows are indexed from zero).
     *
     * Note that this function is not related to gtk_menu_detach().
     */
    fun attach(
        child: CPointer<GtkWidget>,
        left_attach: UInt,
        right_attach: UInt,
        top_attach: UInt,
        bottom_attach: UInt
    ): Unit = gtk_menu_attach(self, child, left_attach, right_attach, top_attach, bottom_attach)

    /**
     * Adds a new #GtkMenuItem to a (table) menu. The number of “cells” that
     * an item will occupy is specified by @left_attach, @right_attach,
     * @top_attach and @bottom_attach. These each represent the leftmost,
     * rightmost, uppermost and lower column and row numbers of the table.
     * (Columns and rows are indexed from zero).
     *
     * Note that this function is not related to gtk_menu_detach().
     */
    fun attach(
        child: Widget,
        left_attach: UInt,
        right_attach: UInt,
        top_attach: UInt,
        bottom_attach: UInt
    ): Unit = gtk_menu_attach(self, child.widgetPtr?.reinterpret(), left_attach, right_attach,
            top_attach, bottom_attach)

    /**
     * Detaches the menu from the widget to which it had been attached.
     * This function will call the callback function, @detacher, provided
     * when the gtk_menu_attach_to_widget() function was called.
     */
    fun detach(): Unit = gtk_menu_detach(self)

    /**
     * Places @menu on the given monitor.
     */
    fun placeOnMonitor(monitor: CPointer<GdkMonitor>): Unit = gtk_menu_place_on_monitor(self,
            monitor)

    /**
     * Removes the menu from the screen.
     */
    fun popdown(): Unit = gtk_menu_popdown(self)

    /**
     * Displays @menu and makes it available for selection.
     *
     * See gtk_menu_popup_at_widget () to pop up a menu at a widget.
     * gtk_menu_popup_at_rect () also allows you to position a menu at an arbitrary
     * rectangle.
     *
     * @menu will be positioned at the pointer associated with @trigger_event.
     *
     * Properties that influence the behaviour of this function are
     * #GtkMenu:anchor-hints, #GtkMenu:rect-anchor-dx, #GtkMenu:rect-anchor-dy, and
     * #GtkMenu:menu-type-hint. Connect to the #GtkMenu::popped-up signal to find
     * out how it was actually positioned.
     */
    fun popupAtPointer(trigger_event: CPointer<GdkEvent>): Unit = gtk_menu_popup_at_pointer(self,
            trigger_event)

    /**
     * Displays @menu and makes it available for selection.
     *
     * See gtk_menu_popup_at_widget () and gtk_menu_popup_at_pointer (), which
     * handle more common cases for popping up menus.
     *
     * @menu will be positioned at @rect, aligning their anchor points. @rect is
     * relative to the top-left corner of @rect_window. @rect_anchor and
     * @menu_anchor determine anchor points on @rect and @menu to pin together.
     * @menu can optionally be offset by #GtkMenu:rect-anchor-dx and
     * #GtkMenu:rect-anchor-dy.
     *
     * Anchors should be specified under the assumption that the text direction is
     * left-to-right; they will be flipped horizontally automatically if the text
     * direction is right-to-left.
     *
     * Other properties that influence the behaviour of this function are
     * #GtkMenu:anchor-hints and #GtkMenu:menu-type-hint. Connect to the
     * #GtkMenu::popped-up signal to find out how it was actually positioned.
     */
    fun popupAtRect(
        rect_window: CPointer<GdkWindow>,
        rect: CPointer<GdkRectangle>,
        rect_anchor: GdkGravity,
        menu_anchor: GdkGravity,
        trigger_event: CPointer<GdkEvent>
    ): Unit = gtk_menu_popup_at_rect(self, rect_window, rect, rect_anchor, menu_anchor,
            trigger_event)

    /**
     * Displays @menu and makes it available for selection.
     *
     * See gtk_menu_popup_at_pointer () to pop up a menu at the master pointer.
     * gtk_menu_popup_at_rect () also allows you to position a menu at an arbitrary
     * rectangle.
     *
     * ![](popup-anchors.png)
     *
     * @menu will be positioned at @widget, aligning their anchor points.
     * @widget_anchor and @menu_anchor determine anchor points on @widget and @menu
     * to pin together. @menu can optionally be offset by #GtkMenu:rect-anchor-dx
     * and #GtkMenu:rect-anchor-dy.
     *
     * Anchors should be specified under the assumption that the text direction is
     * left-to-right; they will be flipped horizontally automatically if the text
     * direction is right-to-left.
     *
     * Other properties that influence the behaviour of this function are
     * #GtkMenu:anchor-hints and #GtkMenu:menu-type-hint. Connect to the
     * #GtkMenu::popped-up signal to find out how it was actually positioned.
     */
    fun popupAtWidget(
        widget: CPointer<GtkWidget>,
        widget_anchor: GdkGravity,
        menu_anchor: GdkGravity,
        trigger_event: CPointer<GdkEvent>
    ): Unit = gtk_menu_popup_at_widget(self, widget, widget_anchor, menu_anchor, trigger_event)

    /**
     * Moves @child to a new @position in the list of @menu
     * children.
     */
    fun reorderChild(child: CPointer<GtkWidget>, position: Int): Unit = gtk_menu_reorder_child(self,
            child, position)

    /**
     * Moves @child to a new @position in the list of @menu
     * children.
     */
    fun reorderChild(child: Widget, position: Int): Unit = gtk_menu_reorder_child(self,
            child.widgetPtr?.reinterpret(), position)

    /**
     * Repositions the menu according to its position function.
     */
    fun reposition(): Unit = gtk_menu_reposition(self)
}

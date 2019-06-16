package gtk3

import kotlin.Boolean
import kotlin.UInt
import kotlin.Unit
import kotlinx.cinterop.CPointer
import kotlinx.cinterop.reinterpret
import libgtk3.GtkApplication
import libgtk3.GtkApplicationWindow
import libgtk3.GtkShortcutsWindow
import libgtk3.GtkWidget
import libgtk3.gtk_application_window_get_help_overlay
import libgtk3.gtk_application_window_get_id
import libgtk3.gtk_application_window_get_show_menubar
import libgtk3.gtk_application_window_new
import libgtk3.gtk_application_window_set_help_overlay
import libgtk3.gtk_application_window_set_show_menubar
import libgtk3.gtk_false
import libgtk3.gtk_true

inline fun Container.applicationWindow(application: CPointer<GtkApplication>, init:
        ApplicationWindow.() -> Unit = {}): ApplicationWindow =
        ApplicationWindow(application).apply { init(); this@applicationWindow.add(this) }

/**
 * #GtkApplicationWindow is a #GtkWindow subclass that offers some
 * extra functionality for better integration with #GtkApplication
 * features.  Notably, it can handle both the application menu as well
 * as the menubar. See gtk_application_set_app_menu() and
 * gtk_application_set_menubar().
 *
 * This class implements the #GActionGroup and #GActionMap interfaces,
 * to let you add window-specific actions that will be exported by the
 * associated #GtkApplication, together with its application-wide
 * actions.  Window-specific actions are prefixed with the “win.”
 * prefix and application-wide actions are prefixed with the “app.”
 * prefix.  Actions must be addressed with the prefixed name when
 * referring to them from a #GMenuModel.
 *
 * Note that widgets that are placed inside a #GtkApplicationWindow
 * can also activate these actions, if they implement the
 * #GtkActionable interface.
 *
 * As with #GtkApplication, the GDK lock will be acquired when
 * processing actions arriving from other processes and should therefore
 * be held when activating actions locally (if GDK threads are enabled).
 *
 * The settings #GtkSettings:gtk-shell-shows-app-menu and
 * #GtkSettings:gtk-shell-shows-menubar tell GTK+ whether the
 * desktop environment is showing the application menu and menubar
 * models outside the application as part of the desktop shell.
 * For instance, on OS X, both menus will be displayed remotely;
 * on Windows neither will be. gnome-shell (starting with version 3.4)
 * will display the application menu, but not the menubar.
 *
 * If the desktop environment does not display the menubar, then
 * #GtkApplicationWindow will automatically show a #GtkMenuBar for it.
 * This behaviour can be overridden with the #GtkApplicationWindow:show-menubar
 * property. If the desktop environment does not display the application
 * menu, then it will automatically be included in the menubar or in the
 * windows client-side decorations.
 *
 * ## A GtkApplicationWindow with a menubar
 *
 * |[<!-- language="C" -->
 * GtkApplication *app = gtk_application_new ("org.gtk.test", 0);
 *
 * GtkBuilder *builder = gtk_builder_new_from_string (
 *     "<interface>"
 *     "  <menu id='menubar'>"
 *     "    <submenu label='_Edit'>"
 *     "      <item label='_Copy' action='win.copy'/>"
 *     "      <item label='_Paste' action='win.paste'/>"
 *     "    </submenu>"
 *     "  </menu>"
 *     "</interface>",
 *     -1);
 *
 * GMenuModel *menubar = G_MENU_MODEL (gtk_builder_get_object (builder,
 *                                                             "menubar"));
 * gtk_application_set_menubar (GTK_APPLICATION (app), menubar);
 * g_object_unref (builder);
 *
 * // ...
 *
 * GtkWidget *window = gtk_application_window_new (app);
 * ]|
 *
 * ## Handling fallback yourself
 *
 * [A simple example](https://git.gnome.org/browse/gtk+/tree/examples/sunny.c)
 *
 * The XML format understood by #GtkBuilder for #GMenuModel consists
 * of a toplevel `<menu>` element, which contains one or more `<item>`
 * elements. Each `<item>` element contains `<attribute>` and `<link>`
 * elements with a mandatory name attribute. `<link>` elements have the
 * same content model as `<menu>`. Instead of `<link name="submenu>` or
 * `<link name="section">`, you can use `<submenu>` or `<section>`
 * elements.
 *
 * Attribute values can be translated using gettext, like other #GtkBuilder
 * content. `<attribute>` elements can be marked for translation with a
 * `translatable="yes"` attribute. It is also possible to specify message
 * context and translator comments, using the context and comments attributes.
 * To make use of this, the #GtkBuilder must have been given the gettext
 * domain to use.
 *
 * The following attributes are used when constructing menu items:
 * - "label": a user-visible string to display
 * - "action": the prefixed name of the action to trigger
 * - "target": the parameter to use when activating the action
 * - "icon" and "verb-icon": names of icons that may be displayed
 * - "submenu-action": name of an action that may be used to determine
 *      if a submenu can be opened
 * - "hidden-when": a string used to determine when the item will be hidden.
 *      Possible values include "action-disabled", "action-missing", "macos-menubar".
 *
 * The following attributes are used when constructing sections:
 * - "label": a user-visible string to use as section heading
 * - "display-hint": a string used to determine special formatting for the section.
 *     Possible values include "horizontal-buttons".
 * - "text-direction": a string used to determine the #GtkTextDirection to use
 *     when "display-hint" is set to "horizontal-buttons". Possible values
 *     include "rtl", "ltr", and "none".
 *
 * The following attributes are used when constructing submenus:
 * - "label": a user-visible string to display
 * - "icon": icon name to displayReturns the unique ID of the window. If the window has not yet been
        added to
 * a #GtkApplication, returns `0`.
 */
@GtkDsl
open class ApplicationWindow internal constructor(override val widgetPtr: CPointer<GtkWidget>? =
        null) : Window() {
    private val self: CPointer<GtkApplicationWindow>?
        get() = widgetPtr!!.reinterpret()

    val applicationWindow: CPointer<GtkApplicationWindow>?
        get() = widgetPtr!!.reinterpret()

    /**
     * Gets the #GtkShortcutsWindow that has been set up with
     * a prior call to gtk_application_window_set_help_overlay().
     *
     * Associates a shortcuts window with the application window, and
     * sets up an action with the name win.show-help-overlay to present
     * it.
     *
     * @window takes resposibility for destroying @help_overlay. */
    var helpOverlay: CPointer<GtkShortcutsWindow>
        get() = gtk_application_window_get_help_overlay(self)!!.reinterpret()
        set(value) {
            gtk_application_window_set_help_overlay(self, value?.reinterpret())
        }

    val id: UInt
        get() = gtk_application_window_get_id(self)

    /**
     * Returns whether the window will display a menubar for the app menu
     * and menubar as needed.
     *
     * Sets whether the window will display a menubar for the app menu
     * and menubar as needed. */
    var showMenubar: Boolean
        get() = gtk_application_window_get_show_menubar(self) != 0
        set(value) {
            gtk_application_window_set_show_menubar(self, if (value) gtk_true() else gtk_false())
        }

    /**
     * Creates a new #GtkApplicationWindow. */
    constructor(application: CPointer<GtkApplication>) :
            this(gtk_application_window_new(application?.reinterpret()))
}

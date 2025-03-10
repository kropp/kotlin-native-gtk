package gtk3

import kotlin.Boolean
import kotlin.Unit
import kotlinx.cinterop.CPointer
import kotlinx.cinterop.reinterpret
import libgtk3.GtkRecentChooserMenu
import libgtk3.GtkWidget
import libgtk3.gtk_false
import libgtk3.gtk_recent_chooser_menu_get_show_numbers
import libgtk3.gtk_recent_chooser_menu_new
import libgtk3.gtk_recent_chooser_menu_set_show_numbers
import libgtk3.gtk_true

inline fun Container.recentChooserMenu(init: RecentChooserMenu.() -> Unit = {}): RecentChooserMenu =
        RecentChooserMenu().apply { init(); this@recentChooserMenu.add(this) }

/**
 * #GtkRecentChooserMenu is a widget suitable for displaying recently used files
 * inside a menu.  It can be used to set a sub-menu of a #GtkMenuItem using
 * gtk_menu_item_set_submenu(), or as the menu of a #GtkMenuToolButton.
 *
 * Note that #GtkRecentChooserMenu does not have any methods of its own. Instead,
 * you should use the functions that work on a #GtkRecentChooser.
 *
 * Note also that #GtkRecentChooserMenu does not support multiple filters, as it
 * has no way to let the user choose between them as the #GtkRecentChooserWidget
 * and #GtkRecentChooserDialog widgets do. Thus using gtk_recent_chooser_add_filter()
 * on a #GtkRecentChooserMenu widget will yield the same effects as using
 * gtk_recent_chooser_set_filter(), replacing any currently set filter
 * with the supplied filter; gtk_recent_chooser_remove_filter() will remove
 * any currently set #GtkRecentFilter object and will unset the current filter;
 * gtk_recent_chooser_list_filters() will return a list containing a single
 * #GtkRecentFilter object.
 *
 * Recently used files are supported since GTK+ 2.10.
 */
@GtkDsl
open class RecentChooserMenu internal constructor(override val widgetPtr: CPointer<GtkWidget>? =
        null) : Menu() {
    private val self: CPointer<GtkRecentChooserMenu>?
        get() = widgetPtr!!.reinterpret()

    val recentChooserMenu: CPointer<GtkRecentChooserMenu>?
        get() = widgetPtr!!.reinterpret()

    /**
     * Returns the value set by gtk_recent_chooser_menu_set_show_numbers().
     *
     * Sets whether a number should be added to the items of @menu.  The
     * numbers are shown to provide a unique character for a mnemonic to
     * be used inside ten menu item’s label.  Only the first the items
     * get a number to avoid clashes. */
    var showNumbers: Boolean
        get() = gtk_recent_chooser_menu_get_show_numbers(self) != 0
        set(value) {
            gtk_recent_chooser_menu_set_show_numbers(self, if (value) gtk_true() else gtk_false())
        }

    /**
     * Creates a new #GtkRecentChooserMenu widget.
     *
     * This kind of widget shows the list of recently used resources as
     * a menu, each item as a menu item.  Each item inside the menu might
     * have an icon, representing its MIME type, and a number, for mnemonic
     * access.
     *
     * This widget implements the #GtkRecentChooser interface.
     *
     * This widget creates its own #GtkRecentManager object.  See the
     * gtk_recent_chooser_menu_new_for_manager() function to know how to create
     * a #GtkRecentChooserMenu widget bound to another #GtkRecentManager object. */
    constructor() : this(gtk_recent_chooser_menu_new()?.reinterpret())
}

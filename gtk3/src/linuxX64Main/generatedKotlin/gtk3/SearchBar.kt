package gtk3

import kotlin.Boolean
import kotlin.Unit
import kotlinx.cinterop.CPointer
import kotlinx.cinterop.reinterpret
import libgtk3.GdkEvent
import libgtk3.GtkEntry
import libgtk3.GtkSearchBar
import libgtk3.GtkWidget
import libgtk3.gtk_false
import libgtk3.gtk_search_bar_connect_entry
import libgtk3.gtk_search_bar_get_search_mode
import libgtk3.gtk_search_bar_get_show_close_button
import libgtk3.gtk_search_bar_handle_event
import libgtk3.gtk_search_bar_new
import libgtk3.gtk_search_bar_set_search_mode
import libgtk3.gtk_search_bar_set_show_close_button
import libgtk3.gtk_true

inline fun Container.searchBar(init: SearchBar.() -> Unit = {}): SearchBar =
        SearchBar().apply { init(); this@searchBar.add(this) }

/**
 * #GtkSearchBar is a container made to have a search entry (possibly
 * with additional connex widgets, such as drop-down menus, or buttons)
 * built-in. The search bar would appear when a search is started through
 * typing on the keyboard, or the application’s search mode is toggled on.
 *
 * For keyboard presses to start a search, events will need to be
 * forwarded from the top-level window that contains the search bar.
 * See gtk_search_bar_handle_event() for example code. Common shortcuts
 * such as Ctrl+F should be handled as an application action, or through
 * the menu items.
 *
 * You will also need to tell the search bar about which entry you
 * are using as your search entry using gtk_search_bar_connect_entry().
 * The following example shows you how to create a more complex search
 * entry.
 *
 * # CSS nodes
 *
 * GtkSearchBar has a single CSS node with name searchbar.
 *
 * ## Creating a search bar
 *
 * [A simple example](https://gitlab.gnome.org/GNOME/gtk/blob/gtk-3-24/examples/search-bar.c)
 */
@GtkDsl
open class SearchBar internal constructor(override val widgetPtr: CPointer<GtkWidget>? = null) :
        Bin() {
    private val self: CPointer<GtkSearchBar>?
        get() = widgetPtr!!.reinterpret()

    val searchBar: CPointer<GtkSearchBar>?
        get() = widgetPtr!!.reinterpret()

    /**
     * Returns whether the search mode is on or off.
     *
     * Switches the search mode on or off. */
    var searchMode: Boolean
        get() = gtk_search_bar_get_search_mode(self) != 0
        set(value) {
            gtk_search_bar_set_search_mode(self, if (value) gtk_true() else gtk_false())
        }

    /**
     * Returns whether the close button is shown.
     *
     * Shows or hides the close button. Applications that
     * already have a “search” toggle button should not show a close
     * button in their search bar, as it duplicates the role of the
     * toggle button. */
    var showCloseButton: Boolean
        get() = gtk_search_bar_get_show_close_button(self) != 0
        set(value) {
            gtk_search_bar_set_show_close_button(self, if (value) gtk_true() else gtk_false())
        }

    /**
     * Creates a #GtkSearchBar. You will need to tell it about
     * which widget is going to be your text entry using
     * gtk_search_bar_connect_entry(). */
    constructor() : this(gtk_search_bar_new()?.reinterpret())

    /**
     * Connects the #GtkEntry widget passed as the one to be used in
     * this search bar. The entry should be a descendant of the search bar.
     * This is only required if the entry isn’t the direct child of the
     * search bar (as in our main example).
     */
    fun connectEntry(entry: CPointer<GtkEntry>): Unit = gtk_search_bar_connect_entry(self, entry)

    /**
     * Connects the #GtkEntry widget passed as the one to be used in
     * this search bar. The entry should be a descendant of the search bar.
     * This is only required if the entry isn’t the direct child of the
     * search bar (as in our main example).
     */
    fun connectEntry(entry: Entry): Unit = gtk_search_bar_connect_entry(self,
            entry.widgetPtr?.reinterpret())

    /**
     * This function should be called when the top-level
     * window which contains the search bar received a key event.
     *
     * If the key event is handled by the search bar, the bar will
     * be shown, the entry populated with the entered text and %GDK_EVENT_STOP
     * will be returned. The caller should ensure that events are
     * not propagated further.
     *
     * If no entry has been connected to the search bar, using
     * gtk_search_bar_connect_entry(), this function will return
     * immediately with a warning.
     *
     * ## Showing the search bar on key presses
     *
     * |[<!-- language="C" -->
     * static gboolean
     * on_key_press_event (GtkWidget *widget,
     *                     GdkEvent  *event,
     *                     gpointer   user_data)
     * {
     *   GtkSearchBar *bar = GTK_SEARCH_BAR (user_data);
     *   return gtk_search_bar_handle_event (bar, event);
     * }
     *
     * static void
     * create_toplevel (void)
     * {
     *   GtkWidget *window = gtk_window_new (GTK_WINDOW_TOPLEVEL);
     *   GtkWindow *search_bar = gtk_search_bar_new ();
     *
     *  // Add more widgets to the window...
     *
     *   g_signal_connect (window,
     *                    "key-press-event",
     *                     G_CALLBACK (on_key_press_event),
     *                     search_bar);
     * }
     * ]|
     */
    fun handleEvent(event: CPointer<GdkEvent>): Boolean = gtk_search_bar_handle_event(self,
            event) != 0
}

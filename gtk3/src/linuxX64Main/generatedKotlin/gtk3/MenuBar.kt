package gtk3

import kotlin.Unit
import kotlinx.cinterop.CPointer
import kotlinx.cinterop.reinterpret
import libgtk3.GtkMenuBar
import libgtk3.GtkPackDirection
import libgtk3.GtkWidget
import libgtk3.gtk_menu_bar_get_child_pack_direction
import libgtk3.gtk_menu_bar_get_pack_direction
import libgtk3.gtk_menu_bar_new
import libgtk3.gtk_menu_bar_set_child_pack_direction
import libgtk3.gtk_menu_bar_set_pack_direction

inline fun Container.menuBar(init: MenuBar.() -> Unit = {}): MenuBar = MenuBar().apply { init();
        this@menuBar.add(this) }

/**
 * The #GtkMenuBar is a subclass of #GtkMenuShell which contains one or
 * more #GtkMenuItems. The result is a standard menu bar which can hold
 * many menu items.
 *
 * # CSS nodes
 *
 * GtkMenuBar has a single CSS node with name menubar.
 */
@GtkDsl
open class MenuBar internal constructor(override val widgetPtr: CPointer<GtkWidget>? = null) :
        MenuShell() {
    private val self: CPointer<GtkMenuBar>?
        get() = widgetPtr!!.reinterpret()

    val menuBar: CPointer<GtkMenuBar>?
        get() = widgetPtr!!.reinterpret()

    /**
     * Retrieves the current child pack direction of the menubar.
     * See gtk_menu_bar_set_child_pack_direction().
     *
     * Sets how widgets should be packed inside the children of a menubar. */
    var childPackDirection: GtkPackDirection
        get() = gtk_menu_bar_get_child_pack_direction(self)
        set(value) {
            gtk_menu_bar_set_child_pack_direction(self, value)
        }

    /**
     * Retrieves the current pack direction of the menubar.
     * See gtk_menu_bar_set_pack_direction().
     *
     * Sets how items should be packed inside a menubar. */
    var packDirection: GtkPackDirection
        get() = gtk_menu_bar_get_pack_direction(self)
        set(value) {
            gtk_menu_bar_set_pack_direction(self, value)
        }

    /**
     * Creates a new #GtkMenuBar */
    constructor() : this(gtk_menu_bar_new()?.reinterpret())
}

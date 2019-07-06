package gtk3

import kotlin.Unit
import kotlinx.cinterop.CPointer
import kotlinx.cinterop.reinterpret
import libgtk3.GtkSeparatorMenuItem
import libgtk3.GtkWidget
import libgtk3.gtk_separator_menu_item_new

inline fun Container.separatorMenuItem(init: SeparatorMenuItem.() -> Unit = {}): SeparatorMenuItem =
        SeparatorMenuItem().apply { init(); this@separatorMenuItem.add(this) }

/**
 * The #GtkSeparatorMenuItem is a separator used to group
 * items within a menu. It displays a horizontal line with a shadow to
 * make it appear sunken into the interface.
 *
 * # CSS nodes
 *
 * GtkSeparatorMenuItem has a single CSS node with name separator.
 */
@GtkDsl
open class SeparatorMenuItem internal constructor(override val widgetPtr: CPointer<GtkWidget>? =
        null) : MenuItem() {
    private val self: CPointer<GtkSeparatorMenuItem>?
        get() = widgetPtr!!.reinterpret()

    val separatorMenuItem: CPointer<GtkSeparatorMenuItem>?
        get() = widgetPtr!!.reinterpret()

    /**
     * Creates a new #GtkSeparatorMenuItem. */
    constructor() : this(gtk_separator_menu_item_new()?.reinterpret())
}

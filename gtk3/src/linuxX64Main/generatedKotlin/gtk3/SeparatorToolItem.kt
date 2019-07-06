package gtk3

import kotlin.Boolean
import kotlin.Unit
import kotlinx.cinterop.CPointer
import kotlinx.cinterop.reinterpret
import libgtk3.GtkSeparatorToolItem
import libgtk3.GtkWidget
import libgtk3.gtk_false
import libgtk3.gtk_separator_tool_item_get_draw
import libgtk3.gtk_separator_tool_item_new
import libgtk3.gtk_separator_tool_item_set_draw
import libgtk3.gtk_true

inline fun Container.separatorToolItem(init: SeparatorToolItem.() -> Unit = {}): SeparatorToolItem =
        SeparatorToolItem().apply { init(); this@separatorToolItem.add(this) }

/**
 * A #GtkSeparatorToolItem is a #GtkToolItem that separates groups of other
 * #GtkToolItems. Depending on the theme, a #GtkSeparatorToolItem will
 * often look like a vertical line on horizontally docked toolbars.
 *
 * If the #GtkToolbar child property “expand” is %TRUE and the property
 * #GtkSeparatorToolItem:draw is %FALSE, a #GtkSeparatorToolItem will act as
 * a “spring” that forces other items to the ends of the toolbar.
 *
 * Use gtk_separator_tool_item_new() to create a new #GtkSeparatorToolItem.
 *
 * # CSS nodes
 *
 * GtkSeparatorToolItem has a single CSS node with name separator.
 */
@GtkDsl
open class SeparatorToolItem internal constructor(override val widgetPtr: CPointer<GtkWidget>? =
        null) : ToolItem() {
    private val self: CPointer<GtkSeparatorToolItem>?
        get() = widgetPtr!!.reinterpret()

    val separatorToolItem: CPointer<GtkSeparatorToolItem>?
        get() = widgetPtr!!.reinterpret()

    /**
     * Returns whether @item is drawn as a line, or just blank.
     * See gtk_separator_tool_item_set_draw().
     *
     * Whether @item is drawn as a vertical line, or just blank.
     * Setting this to %FALSE along with gtk_tool_item_set_expand() is useful
     * to create an item that forces following items to the end of the toolbar. */
    var draw: Boolean
        get() = gtk_separator_tool_item_get_draw(self) != 0
        set(value) {
            gtk_separator_tool_item_set_draw(self, if (value) gtk_true() else gtk_false())
        }

    /**
     * Create a new #GtkSeparatorToolItem */
    constructor() : this(gtk_separator_tool_item_new()?.reinterpret())
}

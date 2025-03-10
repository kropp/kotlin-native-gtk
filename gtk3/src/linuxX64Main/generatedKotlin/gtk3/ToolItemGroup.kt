package gtk3

import kotlin.Boolean
import kotlin.Int
import kotlin.String
import kotlin.UInt
import kotlin.Unit
import kotlinx.cinterop.CPointer
import kotlinx.cinterop.reinterpret
import kotlinx.cinterop.toKString
import libgtk3.GtkReliefStyle
import libgtk3.GtkToolItem
import libgtk3.GtkToolItemGroup
import libgtk3.GtkWidget
import libgtk3.gtk_false
import libgtk3.gtk_tool_item_group_get_collapsed
import libgtk3.gtk_tool_item_group_get_drop_item
import libgtk3.gtk_tool_item_group_get_header_relief
import libgtk3.gtk_tool_item_group_get_item_position
import libgtk3.gtk_tool_item_group_get_label
import libgtk3.gtk_tool_item_group_get_label_widget
import libgtk3.gtk_tool_item_group_get_n_items
import libgtk3.gtk_tool_item_group_get_nth_item
import libgtk3.gtk_tool_item_group_insert
import libgtk3.gtk_tool_item_group_new
import libgtk3.gtk_tool_item_group_set_collapsed
import libgtk3.gtk_tool_item_group_set_header_relief
import libgtk3.gtk_tool_item_group_set_item_position
import libgtk3.gtk_tool_item_group_set_label
import libgtk3.gtk_tool_item_group_set_label_widget
import libgtk3.gtk_true

inline fun Container.toolItemGroup(label: String, init: ToolItemGroup.() -> Unit = {}):
        ToolItemGroup = ToolItemGroup(label).apply { init(); this@toolItemGroup.add(this) }

/**
 * A #GtkToolItemGroup is used together with #GtkToolPalette to add
 * #GtkToolItems to a palette like container with different
 * categories and drag and drop support.
 *
 * # CSS nodes
 *
 * GtkToolItemGroup has a single CSS node named toolitemgroup.Gets the number of tool items in
        @group.
 */
@GtkDsl
open class ToolItemGroup internal constructor(override val widgetPtr: CPointer<GtkWidget>? = null) :
        Container() {
    private val self: CPointer<GtkToolItemGroup>?
        get() = widgetPtr!!.reinterpret()

    val toolItemGroup: CPointer<GtkToolItemGroup>?
        get() = widgetPtr!!.reinterpret()

    /**
     * Gets whether @group is collapsed or expanded.
     *
     * Sets whether the @group should be collapsed or expanded. */
    var collapsed: Boolean
        get() = gtk_tool_item_group_get_collapsed(self) != 0
        set(value) {
            gtk_tool_item_group_set_collapsed(self, if (value) gtk_true() else gtk_false())
        }

    /**
     * Gets the relief mode of the header button of @group.
     *
     * Set the button relief of the group header.
     * See gtk_button_set_relief() for details. */
    var headerRelief: GtkReliefStyle
        get() = gtk_tool_item_group_get_header_relief(self)
        set(value) {
            gtk_tool_item_group_set_header_relief(self, value)
        }

    /**
     * Gets the label of @group.
     *
     * Sets the label of the tool item group. The label is displayed in the header
     * of the group. */
    var label: String
        get() = gtk_tool_item_group_get_label(self)?.toKString() ?: ""
        set(value) {
            gtk_tool_item_group_set_label(self, value)
        }

    /**
     * Gets the label widget of @group.
     * See gtk_tool_item_group_set_label_widget().
     *
     * Sets the label of the tool item group.
     * The label widget is displayed in the header of the group, in place
     * of the usual label. */
    var labelWidget: CPointer<GtkWidget>
        get() = gtk_tool_item_group_get_label_widget(self)!!.reinterpret()
        set(value) {
            gtk_tool_item_group_set_label_widget(self, value?.reinterpret())
        }

    val nItems: UInt
        get() = gtk_tool_item_group_get_n_items(self)

    /**
     * Creates a new tool item group with label @label. */
    constructor(label: String) : this(gtk_tool_item_group_new(label)?.reinterpret())

    /**
     * Gets the tool item at position (x, y).
     */
    fun getDropItem(x: Int, y: Int): CPointer<GtkToolItem> = gtk_tool_item_group_get_drop_item(self,
            x, y)!!.reinterpret()

    /**
     * Gets the position of @item in @group as index.
     */
    fun getItemPosition(item: CPointer<GtkToolItem>): Int =
            gtk_tool_item_group_get_item_position(self, item)

    /**
     * Gets the position of @item in @group as index.
     */
    fun getItemPosition(item: ToolItem): Int = gtk_tool_item_group_get_item_position(self,
            item.widgetPtr?.reinterpret())

    /**
     * Gets the tool item at @index in group.
     */
    fun getNthItem(index: UInt): CPointer<GtkToolItem> = gtk_tool_item_group_get_nth_item(self,
            index)!!.reinterpret()

    /**
     * Inserts @item at @position in the list of children of @group.
     */
    fun insert(item: CPointer<GtkToolItem>, position: Int): Unit = gtk_tool_item_group_insert(self,
            item, position)

    /**
     * Inserts @item at @position in the list of children of @group.
     */
    fun insert(item: ToolItem, position: Int): Unit = gtk_tool_item_group_insert(self,
            item.widgetPtr?.reinterpret(), position)

    /**
     * Sets the position of @item in the list of children of @group.
     */
    fun setItemPosition(item: CPointer<GtkToolItem>, position: Int): Unit =
            gtk_tool_item_group_set_item_position(self, item, position)

    /**
     * Sets the position of @item in the list of children of @group.
     */
    fun setItemPosition(item: ToolItem, position: Int): Unit =
            gtk_tool_item_group_set_item_position(self, item.widgetPtr?.reinterpret(), position)
}

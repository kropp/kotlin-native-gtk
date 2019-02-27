package gtk3

import kotlin.Unit
import kotlinx.cinterop.CFunction
import kotlinx.cinterop.COpaquePointer
import kotlinx.cinterop.CPointed
import kotlinx.cinterop.CPointer
import kotlinx.cinterop.asStableRef
import kotlinx.cinterop.reinterpret
import kotlinx.cinterop.staticCFunction
import libgtk3.GSList
import libgtk3.GtkRadioMenuItem
import libgtk3.GtkWidget
import libgtk3.gtk_radio_menu_item_get_group
import libgtk3.gtk_radio_menu_item_join_group
import libgtk3.gtk_radio_menu_item_new
import libgtk3.gtk_radio_menu_item_set_group

inline fun Container.radioMenuItem(group: CPointer<GSList>, init: RadioMenuItem.() -> Unit = {}):
        RadioMenuItem = RadioMenuItem(group).apply { init(); this@radioMenuItem.add(this) }

private fun RadioMenuItem_onGroupChanged_Handler(sender: CPointer<in CPointed>?, _data:
        COpaquePointer?) {
    _data?.asStableRef<RadioMenuItem>()?.get()?.onGroupChanged?.emit()
}

/**
 * A radio menu item is a check menu item that belongs to a group. At each
 * instant exactly one of the radio menu items from a group is selected.
 *
 * The group list does not need to be freed, as each #GtkRadioMenuItem will
 * remove itself and its list item when it is destroyed.
 *
 * The correct way to create a group of radio menu items is approximatively
 * this:
 *
 * ## How to create a group of radio menu items.
 *
 * |[<!-- language="C" -->
 * GSList *group = NULL;
 * GtkWidget *item;
 * gint i;
 *
 * for (i = 0; i < 5; i++)
 * {
 *   item = gtk_radio_menu_item_new_with_label (group, "This is an example");
 *   group = gtk_radio_menu_item_get_group (GTK_RADIO_MENU_ITEM (item));
 *   if (i == 1)
 *     gtk_check_menu_item_set_active (GTK_CHECK_MENU_ITEM (item), TRUE);
 * }
 * ]|
 *
 * # CSS nodes
 *
 * |[<!-- language="plain" -->
 * menuitem
 * ├── radio.left
 * ╰── <child>
 * ]|
 *
 * GtkRadioMenuItem has a main CSS node with name menuitem, and a subnode
 * with name radio, which gets the .left or .right style class.
 */
@GtkDsl
open class RadioMenuItem internal constructor(override val widgetPtr: CPointer<GtkWidget>? = null) :
        CheckMenuItem() {
    private val self: CPointer<GtkRadioMenuItem>?
        get() = widgetPtr!!.reinterpret()

    val radioMenuItem: CPointer<GtkRadioMenuItem>?
        get() = widgetPtr!!.reinterpret()

    val onGroupChanged: Signal<RadioMenuItem, CFunction<(CPointer<in CPointed>?, COpaquePointer?) ->
            Unit>> by lazy { Signal<RadioMenuItem, CFunction<(CPointer<in CPointed>?,
            COpaquePointer?) -> Unit>>(widgetPtr!!, this, "group-changed",
            staticCFunction(::RadioMenuItem_onGroupChanged_Handler)) }

    /**
     * Returns the group to which the radio menu item belongs, as a #GList of
     * #GtkRadioMenuItem. The list belongs to GTK+ and should not be freed.
     *
     * Sets the group of a radio menu item, or changes it. */
    var group: CPointer<GSList>
        get() = gtk_radio_menu_item_get_group(self)!!.reinterpret()
        set(value) {
            gtk_radio_menu_item_set_group(self, value?.reinterpret())
        }

    /**
     * Creates a new #GtkRadioMenuItem. */
    constructor(group: CPointer<GSList>) :
            this(gtk_radio_menu_item_new(group?.reinterpret())?.reinterpret())

    /**
     * Joins a #GtkRadioMenuItem object to the group of another #GtkRadioMenuItem
     * object.
     *
     * This function should be used by language bindings to avoid the memory
     * manangement of the opaque #GSList of gtk_radio_menu_item_get_group()
     * and gtk_radio_menu_item_set_group().
     *
     * A common way to set up a group of #GtkRadioMenuItem instances is:
     *
     * |[
     *   GtkRadioMenuItem *last_item = NULL;
     *
     *   while ( ...more items to add... )
     *     {
     *       GtkRadioMenuItem *radio_item;
     *
     *       radio_item = gtk_radio_menu_item_new (...);
     *
     *       gtk_radio_menu_item_join_group (radio_item, last_item);
     *       last_item = radio_item;
     *     }
     * ]|
     */
    fun joinGroup(group_source: CPointer<GtkRadioMenuItem>): Unit =
            gtk_radio_menu_item_join_group(self, group_source)

    /**
     * Joins a #GtkRadioMenuItem object to the group of another #GtkRadioMenuItem
     * object.
     *
     * This function should be used by language bindings to avoid the memory
     * manangement of the opaque #GSList of gtk_radio_menu_item_get_group()
     * and gtk_radio_menu_item_set_group().
     *
     * A common way to set up a group of #GtkRadioMenuItem instances is:
     *
     * |[
     *   GtkRadioMenuItem *last_item = NULL;
     *
     *   while ( ...more items to add... )
     *     {
     *       GtkRadioMenuItem *radio_item;
     *
     *       radio_item = gtk_radio_menu_item_new (...);
     *
     *       gtk_radio_menu_item_join_group (radio_item, last_item);
     *       last_item = radio_item;
     *     }
     * ]|
     */
    fun joinGroup(group_source: RadioMenuItem): Unit = gtk_radio_menu_item_join_group(self,
            group_source.widgetPtr?.reinterpret())
}

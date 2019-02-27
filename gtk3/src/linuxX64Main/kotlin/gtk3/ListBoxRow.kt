package gtk3

import kotlin.Boolean
import kotlin.Int
import kotlin.Unit
import kotlinx.cinterop.CFunction
import kotlinx.cinterop.COpaquePointer
import kotlinx.cinterop.CPointed
import kotlinx.cinterop.CPointer
import kotlinx.cinterop.asStableRef
import kotlinx.cinterop.reinterpret
import kotlinx.cinterop.staticCFunction
import libgtk3.GtkListBoxRow
import libgtk3.GtkWidget
import libgtk3.gtk_false
import libgtk3.gtk_list_box_row_changed
import libgtk3.gtk_list_box_row_get_activatable
import libgtk3.gtk_list_box_row_get_header
import libgtk3.gtk_list_box_row_get_index
import libgtk3.gtk_list_box_row_get_selectable
import libgtk3.gtk_list_box_row_is_selected
import libgtk3.gtk_list_box_row_new
import libgtk3.gtk_list_box_row_set_activatable
import libgtk3.gtk_list_box_row_set_header
import libgtk3.gtk_list_box_row_set_selectable
import libgtk3.gtk_true

inline fun Container.listBoxRow(init: ListBoxRow.() -> Unit = {}): ListBoxRow =
        ListBoxRow().apply { init(); this@listBoxRow.add(this) }

private fun ListBoxRow_onActivate_Handler(sender: CPointer<in CPointed>?, _data: COpaquePointer?) {
    _data?.asStableRef<ListBoxRow>()?.get()?.onActivate?.emit()
}

/**
 * Gets the current index of the @row in its #GtkListBox container.
 */
@GtkDsl
open class ListBoxRow internal constructor(override val widgetPtr: CPointer<GtkWidget>? = null) :
        Bin() {
    private val self: CPointer<GtkListBoxRow>?
        get() = widgetPtr!!.reinterpret()

    val listBoxRow: CPointer<GtkListBoxRow>?
        get() = widgetPtr!!.reinterpret()

    val onActivate: Signal<ListBoxRow, CFunction<(CPointer<in CPointed>?, COpaquePointer?) -> Unit>>
            by lazy { Signal<ListBoxRow, CFunction<(CPointer<in CPointed>?, COpaquePointer?) ->
            Unit>>(widgetPtr!!, this, "activate", staticCFunction(::ListBoxRow_onActivate_Handler))
            }

    /**
     * Gets the value of the #GtkListBoxRow:activatable property
     * for this row.
     *
     * Set the #GtkListBoxRow:activatable property for this row. */
    var activatable: Boolean
        get() = gtk_list_box_row_get_activatable(self) != 0
        set(value) {
            gtk_list_box_row_set_activatable(self, if (value) gtk_true() else gtk_false())
        }

    /**
     * Returns the current header of the @row. This can be used
     * in a #GtkListBoxUpdateHeaderFunc to see if there is a header
     * set already, and if so to update the state of it.
     *
     * Sets the current header of the @row. This is only allowed to be called
     * from a #GtkListBoxUpdateHeaderFunc. It will replace any existing
     * header in the row, and be shown in front of the row in the listbox. */
    var header: CPointer<GtkWidget>
        get() = gtk_list_box_row_get_header(self)!!.reinterpret()
        set(value) {
            gtk_list_box_row_set_header(self, value?.reinterpret())
        }

    val index: Int
        get() = gtk_list_box_row_get_index(self)

    /**
     * Gets the value of the #GtkListBoxRow:selectable property
     * for this row.
     *
     * Set the #GtkListBoxRow:selectable property for this row. */
    var selectable: Boolean
        get() = gtk_list_box_row_get_selectable(self) != 0
        set(value) {
            gtk_list_box_row_set_selectable(self, if (value) gtk_true() else gtk_false())
        }

    /**
     * Creates a new #GtkListBoxRow, to be used as a child of a #GtkListBox. */
    constructor() : this(gtk_list_box_row_new()?.reinterpret())

    /**
     * Marks @row as changed, causing any state that depends on this
     * to be updated. This affects sorting, filtering and headers.
     *
     * Note that calls to this method must be in sync with the data
     * used for the row functions. For instance, if the list is
     * mirroring some external data set, and *two* rows changed in the
     * external data set then when you call gtk_list_box_row_changed()
     * on the first row the sort function must only read the new data
     * for the first of the two changed rows, otherwise the resorting
     * of the rows will be wrong.
     *
     * This generally means that if you don’t fully control the data
     * model you have to duplicate the data that affects the listbox
     * row functions into the row widgets themselves. Another alternative
     * is to call gtk_list_box_invalidate_sort() on any model change,
     * but that is more expensive.
     */
    fun changed(): Unit = gtk_list_box_row_changed(self)

    /**
     * Returns whether the child is currently selected in its
     * #GtkListBox container.
     */
    fun isSelected(): Boolean = gtk_list_box_row_is_selected(self) != 0
}

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
import libgtk3.GList
import libgtk3.GtkAdjustment
import libgtk3.GtkListBox
import libgtk3.GtkListBoxRow
import libgtk3.GtkSelectionMode
import libgtk3.GtkWidget
import libgtk3.gtk_false
import libgtk3.gtk_list_box_drag_highlight_row
import libgtk3.gtk_list_box_drag_unhighlight_row
import libgtk3.gtk_list_box_get_activate_on_single_click
import libgtk3.gtk_list_box_get_adjustment
import libgtk3.gtk_list_box_get_row_at_index
import libgtk3.gtk_list_box_get_row_at_y
import libgtk3.gtk_list_box_get_selected_row
import libgtk3.gtk_list_box_get_selected_rows
import libgtk3.gtk_list_box_get_selection_mode
import libgtk3.gtk_list_box_insert
import libgtk3.gtk_list_box_invalidate_filter
import libgtk3.gtk_list_box_invalidate_headers
import libgtk3.gtk_list_box_invalidate_sort
import libgtk3.gtk_list_box_new
import libgtk3.gtk_list_box_prepend
import libgtk3.gtk_list_box_select_all
import libgtk3.gtk_list_box_select_row
import libgtk3.gtk_list_box_set_activate_on_single_click
import libgtk3.gtk_list_box_set_adjustment
import libgtk3.gtk_list_box_set_placeholder
import libgtk3.gtk_list_box_set_selection_mode
import libgtk3.gtk_list_box_unselect_all
import libgtk3.gtk_list_box_unselect_row
import libgtk3.gtk_true

inline fun Container.listBox(init: ListBox.() -> Unit = {}): ListBox = ListBox().apply { init();
        this@listBox.add(this) }

private fun ListBox_onActivateCursorRow_Handler(sender: CPointer<in CPointed>?, _data:
        COpaquePointer?) {
    _data?.asStableRef<ListBox>()?.get()?.onActivateCursorRow?.emit()
}

private fun ListBox_onRowActivated_Handler(
    sender: CPointer<in CPointed>?,
    row: CPointer<GtkListBoxRow>,
    _data: COpaquePointer?
) {
    _data?.asStableRef<ListBox>()?.get()?.onRowActivated?.emit(row?.reinterpret())
}

private fun ListBox_onRowSelected_Handler(
    sender: CPointer<in CPointed>?,
    row: CPointer<GtkListBoxRow>,
    _data: COpaquePointer?
) {
    _data?.asStableRef<ListBox>()?.get()?.onRowSelected?.emit(row?.reinterpret())
}

private fun ListBox_onSelectAll_Handler(sender: CPointer<in CPointed>?, _data: COpaquePointer?) {
    _data?.asStableRef<ListBox>()?.get()?.onSelectAll?.emit()
}

private fun ListBox_onSelectedRowsChanged_Handler(sender: CPointer<in CPointed>?, _data:
        COpaquePointer?) {
    _data?.asStableRef<ListBox>()?.get()?.onSelectedRowsChanged?.emit()
}

private fun ListBox_onToggleCursorRow_Handler(sender: CPointer<in CPointed>?, _data:
        COpaquePointer?) {
    _data?.asStableRef<ListBox>()?.get()?.onToggleCursorRow?.emit()
}

private fun ListBox_onUnselectAll_Handler(sender: CPointer<in CPointed>?, _data: COpaquePointer?) {
    _data?.asStableRef<ListBox>()?.get()?.onUnselectAll?.emit()
}

/**
 * A GtkListBox is a vertical container that contains GtkListBoxRow
 * children. These rows can by dynamically sorted and filtered, and
 * headers can be added dynamically depending on the row content.
 * It also allows keyboard and mouse navigation and selection like
 * a typical list.
 *
 * Using GtkListBox is often an alternative to #GtkTreeView, especially
 * when the list contents has a more complicated layout than what is allowed
 * by a #GtkCellRenderer, or when the contents is interactive (i.e. has a
 * button in it).
 *
 * Although a #GtkListBox must have only #GtkListBoxRow children you can
 * add any kind of widget to it via gtk_container_add(), and a #GtkListBoxRow
 * widget will automatically be inserted between the list and the widget.
 *
 * #GtkListBoxRows can be marked as activatable or selectable. If a row
 * is activatable, #GtkListBox::row-activated will be emitted for it when
 * the user tries to activate it. If it is selectable, the row will be marked
 * as selected when the user tries to select it.
 *
 * The GtkListBox widget was added in GTK+ 3.10.
 *
 * # CSS nodes
 *
 * |[<!-- language="plain" -->
 * list
 * ╰── row[.activatable]
 * ]|
 *
 * GtkListBox uses a single CSS node named list. Each GtkListBoxRow uses
 * a single CSS node named row. The row nodes get the .activatable
 * style class added when appropriate.Gets the selected row.
 *
 * Note that the box may allow multiple selection, in which
 * case you should use gtk_list_box_selected_foreach() to
 * find all selected rows.Creates a list of all selected children.
 */
@GtkDsl
open class ListBox internal constructor(override val widgetPtr: CPointer<GtkWidget>? = null) :
        Container() {
    private val self: CPointer<GtkListBox>?
        get() = widgetPtr!!.reinterpret()

    val listBox: CPointer<GtkListBox>?
        get() = widgetPtr!!.reinterpret()

    val onActivateCursorRow: Signal<ListBox, CFunction<(CPointer<in CPointed>?, COpaquePointer?) ->
            Unit>> by lazy { Signal<ListBox, CFunction<(CPointer<in CPointed>?, COpaquePointer?) ->
            Unit>>(widgetPtr!!, this, "activate-cursor-row",
            staticCFunction(::ListBox_onActivateCursorRow_Handler)) }

    val onRowActivated: Signal1<ListBox, CPointer<GtkListBoxRow>, CFunction<(
        CPointer<in CPointed>?,
        CPointer<GtkListBoxRow>,
        COpaquePointer?
    ) -> Unit>> by lazy { Signal1<ListBox, CPointer<GtkListBoxRow>, CFunction<(
                CPointer<in CPointed>?,
                CPointer<GtkListBoxRow>,
                COpaquePointer?
            ) -> Unit>>(widgetPtr!!, this, "row-activated",
                    staticCFunction(::ListBox_onRowActivated_Handler)) }

    val onRowSelected: Signal1<ListBox, CPointer<GtkListBoxRow>, CFunction<(
        CPointer<in CPointed>?,
        CPointer<GtkListBoxRow>,
        COpaquePointer?
    ) -> Unit>> by lazy { Signal1<ListBox, CPointer<GtkListBoxRow>, CFunction<(
                CPointer<in CPointed>?,
                CPointer<GtkListBoxRow>,
                COpaquePointer?
            ) -> Unit>>(widgetPtr!!, this, "row-selected",
                    staticCFunction(::ListBox_onRowSelected_Handler)) }

    val onSelectAll: Signal<ListBox, CFunction<(CPointer<in CPointed>?, COpaquePointer?) -> Unit>>
            by lazy { Signal<ListBox, CFunction<(CPointer<in CPointed>?, COpaquePointer?) ->
            Unit>>(widgetPtr!!, this, "select-all", staticCFunction(::ListBox_onSelectAll_Handler))
            }

    val onSelectedRowsChanged: Signal<ListBox, CFunction<(CPointer<in CPointed>?,
            COpaquePointer?) -> Unit>> by lazy { Signal<ListBox, CFunction<(CPointer<in CPointed>?,
            COpaquePointer?) -> Unit>>(widgetPtr!!, this, "selected-rows-changed",
            staticCFunction(::ListBox_onSelectedRowsChanged_Handler)) }

    val onToggleCursorRow: Signal<ListBox, CFunction<(CPointer<in CPointed>?, COpaquePointer?) ->
            Unit>> by lazy { Signal<ListBox, CFunction<(CPointer<in CPointed>?, COpaquePointer?) ->
            Unit>>(widgetPtr!!, this, "toggle-cursor-row",
            staticCFunction(::ListBox_onToggleCursorRow_Handler)) }

    val onUnselectAll: Signal<ListBox, CFunction<(CPointer<in CPointed>?, COpaquePointer?) -> Unit>>
            by lazy { Signal<ListBox, CFunction<(CPointer<in CPointed>?, COpaquePointer?) ->
            Unit>>(widgetPtr!!, this, "unselect-all",
            staticCFunction(::ListBox_onUnselectAll_Handler)) }

    /**
     * Returns whether rows activate on single clicks.
     *
     * If @single is %TRUE, rows will be activated when you click on them,
     * otherwise you need to double-click. */
    var activateOnSingleClick: Boolean
        get() = gtk_list_box_get_activate_on_single_click(self) != 0
        set(value) {
            gtk_list_box_set_activate_on_single_click(self, if (value) gtk_true() else gtk_false())
        }

    /**
     * Gets the adjustment (if any) that the widget uses to
     * for vertical scrolling.
     *
     * Sets the adjustment (if any) that the widget uses to
     * for vertical scrolling. For instance, this is used
     * to get the page size for PageUp/Down key handling.
     *
     * In the normal case when the @box is packed inside
     * a #GtkScrolledWindow the adjustment from that will
     * be picked up automatically, so there is no need
     * to manually do that. */
    var adjustment: CPointer<GtkAdjustment>
        get() = gtk_list_box_get_adjustment(self)!!.reinterpret()
        set(value) {
            gtk_list_box_set_adjustment(self, value?.reinterpret())
        }

    val selectedRow: CPointer<GtkListBoxRow>
        get() = gtk_list_box_get_selected_row(self)!!.reinterpret()

    val selectedRows: CPointer<GList>
        get() = gtk_list_box_get_selected_rows(self)!!.reinterpret()

    /**
     * Gets the selection mode of the listbox.
     *
     * Sets how selection works in the listbox.
     * See #GtkSelectionMode for details. */
    var selectionMode: GtkSelectionMode
        get() = gtk_list_box_get_selection_mode(self)
        set(value) {
            gtk_list_box_set_selection_mode(self, value)
        }

    /**
     * Creates a new #GtkListBox container. */
    constructor() : this(gtk_list_box_new()?.reinterpret())

    /**
     * This is a helper function for implementing DnD onto a #GtkListBox.
     * The passed in @row will be highlighted via gtk_drag_highlight(),
     * and any previously highlighted row will be unhighlighted.
     *
     * The row will also be unhighlighted when the widget gets
     * a drag leave event.
     */
    fun dragHighlightRow(row: CPointer<GtkListBoxRow>): Unit = gtk_list_box_drag_highlight_row(self,
            row)

    /**
     * This is a helper function for implementing DnD onto a #GtkListBox.
     * The passed in @row will be highlighted via gtk_drag_highlight(),
     * and any previously highlighted row will be unhighlighted.
     *
     * The row will also be unhighlighted when the widget gets
     * a drag leave event.
     */
    fun dragHighlightRow(row: ListBoxRow): Unit = gtk_list_box_drag_highlight_row(self,
            row.widgetPtr?.reinterpret())

    /**
     * If a row has previously been highlighted via gtk_list_box_drag_highlight_row()
     * it will have the highlight removed.
     */
    fun dragUnhighlightRow(): Unit = gtk_list_box_drag_unhighlight_row(self)

    /**
     * Gets the n-th child in the list (not counting headers).
     * If @_index is negative or larger than the number of items in the
     * list, %NULL is returned.
     */
    fun getRowAtIndex(index_: Int): CPointer<GtkListBoxRow> = gtk_list_box_get_row_at_index(self,
            index_)!!.reinterpret()

    /**
     * Gets the row at the @y position.
     */
    fun getRowAtY(y: Int): CPointer<GtkListBoxRow> = gtk_list_box_get_row_at_y(self,
            y)!!.reinterpret()

    /**
     * Insert the @child into the @box at @position. If a sort function is
     * set, the widget will actually be inserted at the calculated position and
     * this function has the same effect of gtk_container_add().
     *
     * If @position is -1, or larger than the total number of items in the
     * @box, then the @child will be appended to the end.
     */
    fun insert(child: CPointer<GtkWidget>, position: Int): Unit = gtk_list_box_insert(self, child,
            position)

    /**
     * Insert the @child into the @box at @position. If a sort function is
     * set, the widget will actually be inserted at the calculated position and
     * this function has the same effect of gtk_container_add().
     *
     * If @position is -1, or larger than the total number of items in the
     * @box, then the @child will be appended to the end.
     */
    fun insert(child: Widget, position: Int): Unit = gtk_list_box_insert(self,
            child.widgetPtr?.reinterpret(), position)

    /**
     * Update the filtering for all rows. Call this when result
     * of the filter function on the @box is changed due
     * to an external factor. For instance, this would be used
     * if the filter function just looked for a specific search
     * string and the entry with the search string has changed.
     */
    fun invalidateFilter(): Unit = gtk_list_box_invalidate_filter(self)

    /**
     * Update the separators for all rows. Call this when result
     * of the header function on the @box is changed due
     * to an external factor.
     */
    fun invalidateHeaders(): Unit = gtk_list_box_invalidate_headers(self)

    /**
     * Update the sorting for all rows. Call this when result
     * of the sort function on the @box is changed due
     * to an external factor.
     */
    fun invalidateSort(): Unit = gtk_list_box_invalidate_sort(self)

    /**
     * Prepend a widget to the list. If a sort function is set, the widget will
     * actually be inserted at the calculated position and this function has the
     * same effect of gtk_container_add().
     */
    fun prepend(child: CPointer<GtkWidget>): Unit = gtk_list_box_prepend(self, child)

    /**
     * Prepend a widget to the list. If a sort function is set, the widget will
     * actually be inserted at the calculated position and this function has the
     * same effect of gtk_container_add().
     */
    fun prepend(child: Widget): Unit = gtk_list_box_prepend(self, child.widgetPtr?.reinterpret())

    /**
     * Select all children of @box, if the selection mode allows it.
     */
    fun selectAll(): Unit = gtk_list_box_select_all(self)

    /**
     * Make @row the currently selected row.
     */
    fun selectRow(row: CPointer<GtkListBoxRow>): Unit = gtk_list_box_select_row(self, row)

    /**
     * Make @row the currently selected row.
     */
    fun selectRow(row: ListBoxRow): Unit = gtk_list_box_select_row(self,
            row.widgetPtr?.reinterpret())

    /**
     * Unselect all children of @box, if the selection mode allows it.
     */
    fun unselectAll(): Unit = gtk_list_box_unselect_all(self)

    /**
     * Unselects a single row of @box, if the selection mode allows it.
     */
    fun unselectRow(row: CPointer<GtkListBoxRow>): Unit = gtk_list_box_unselect_row(self, row)

    /**
     * Unselects a single row of @box, if the selection mode allows it.
     */
    fun unselectRow(row: ListBoxRow): Unit = gtk_list_box_unselect_row(self,
            row.widgetPtr?.reinterpret())

    /**
     * Sets the placeholder widget that is shown in the list when
     * it doesn't display any visible children.
     */
    fun setPlaceholder(placeholder: CPointer<GtkWidget>): Unit = gtk_list_box_set_placeholder(self,
            placeholder)
}

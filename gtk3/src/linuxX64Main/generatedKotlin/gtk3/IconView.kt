package gtk3

import kotlin.Boolean
import kotlin.Float
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
import libgtk3.GtkCellRenderer
import libgtk3.GtkIconView
import libgtk3.GtkIconViewDropPosition
import libgtk3.GtkOrientation
import libgtk3.GtkSelectionMode
import libgtk3.GtkTooltip
import libgtk3.GtkTreeModel
import libgtk3.GtkTreePath
import libgtk3.GtkWidget
import libgtk3.gtk_false
import libgtk3.gtk_icon_view_get_activate_on_single_click
import libgtk3.gtk_icon_view_get_column_spacing
import libgtk3.gtk_icon_view_get_columns
import libgtk3.gtk_icon_view_get_item_column
import libgtk3.gtk_icon_view_get_item_orientation
import libgtk3.gtk_icon_view_get_item_padding
import libgtk3.gtk_icon_view_get_item_row
import libgtk3.gtk_icon_view_get_item_width
import libgtk3.gtk_icon_view_get_margin
import libgtk3.gtk_icon_view_get_markup_column
import libgtk3.gtk_icon_view_get_model
import libgtk3.gtk_icon_view_get_path_at_pos
import libgtk3.gtk_icon_view_get_pixbuf_column
import libgtk3.gtk_icon_view_get_reorderable
import libgtk3.gtk_icon_view_get_row_spacing
import libgtk3.gtk_icon_view_get_selected_items
import libgtk3.gtk_icon_view_get_selection_mode
import libgtk3.gtk_icon_view_get_spacing
import libgtk3.gtk_icon_view_get_text_column
import libgtk3.gtk_icon_view_get_tooltip_column
import libgtk3.gtk_icon_view_item_activated
import libgtk3.gtk_icon_view_new
import libgtk3.gtk_icon_view_path_is_selected
import libgtk3.gtk_icon_view_scroll_to_path
import libgtk3.gtk_icon_view_select_all
import libgtk3.gtk_icon_view_select_path
import libgtk3.gtk_icon_view_set_activate_on_single_click
import libgtk3.gtk_icon_view_set_column_spacing
import libgtk3.gtk_icon_view_set_columns
import libgtk3.gtk_icon_view_set_cursor
import libgtk3.gtk_icon_view_set_drag_dest_item
import libgtk3.gtk_icon_view_set_item_orientation
import libgtk3.gtk_icon_view_set_item_padding
import libgtk3.gtk_icon_view_set_item_width
import libgtk3.gtk_icon_view_set_margin
import libgtk3.gtk_icon_view_set_markup_column
import libgtk3.gtk_icon_view_set_model
import libgtk3.gtk_icon_view_set_pixbuf_column
import libgtk3.gtk_icon_view_set_reorderable
import libgtk3.gtk_icon_view_set_row_spacing
import libgtk3.gtk_icon_view_set_selection_mode
import libgtk3.gtk_icon_view_set_spacing
import libgtk3.gtk_icon_view_set_text_column
import libgtk3.gtk_icon_view_set_tooltip_cell
import libgtk3.gtk_icon_view_set_tooltip_column
import libgtk3.gtk_icon_view_set_tooltip_item
import libgtk3.gtk_icon_view_unselect_all
import libgtk3.gtk_icon_view_unselect_path
import libgtk3.gtk_icon_view_unset_model_drag_dest
import libgtk3.gtk_icon_view_unset_model_drag_source
import libgtk3.gtk_true

inline fun Container.iconView(init: IconView.() -> Unit = {}): IconView = IconView().apply { init();
        this@iconView.add(this) }

private fun IconView_onActivateCursorItem_Handler(sender: CPointer<in CPointed>?, _data:
        COpaquePointer?) {
    _data?.asStableRef<IconView>()?.get()?.onActivateCursorItem?.emit()
}

private fun IconView_onItemActivated_Handler(
    sender: CPointer<in CPointed>?,
    path: CPointer<GtkTreePath>,
    _data: COpaquePointer?
) {
    _data?.asStableRef<IconView>()?.get()?.onItemActivated?.emit(path?.reinterpret())
}

private fun IconView_onSelectAll_Handler(sender: CPointer<in CPointed>?, _data: COpaquePointer?) {
    _data?.asStableRef<IconView>()?.get()?.onSelectAll?.emit()
}

private fun IconView_onSelectCursorItem_Handler(sender: CPointer<in CPointed>?, _data:
        COpaquePointer?) {
    _data?.asStableRef<IconView>()?.get()?.onSelectCursorItem?.emit()
}

private fun IconView_onSelectionChanged_Handler(sender: CPointer<in CPointed>?, _data:
        COpaquePointer?) {
    _data?.asStableRef<IconView>()?.get()?.onSelectionChanged?.emit()
}

private fun IconView_onToggleCursorItem_Handler(sender: CPointer<in CPointed>?, _data:
        COpaquePointer?) {
    _data?.asStableRef<IconView>()?.get()?.onToggleCursorItem?.emit()
}

private fun IconView_onUnselectAll_Handler(sender: CPointer<in CPointed>?, _data: COpaquePointer?) {
    _data?.asStableRef<IconView>()?.get()?.onUnselectAll?.emit()
}

/**
 * #GtkIconView provides an alternative view on a #GtkTreeModel.
 * It displays the model as a grid of icons with labels. Like
 * #GtkTreeView, it allows to select one or multiple items
 * (depending on the selection mode, see gtk_icon_view_set_selection_mode()).
 * In addition to selection with the arrow keys, #GtkIconView supports
 * rubberband selection, which is controlled by dragging the pointer.
 *
 * Note that if the tree model is backed by an actual tree store (as
 * opposed to a flat list where the mapping to icons is obvious),
 * #GtkIconView will only display the first level of the tree and
 * ignore the tree’s branches.
 *
 * # CSS nodes
 *
 * |[<!-- language="plain" -->
 * iconview.view
 * ╰── [rubberband]
 * ]|
 *
 * GtkIconView has a single CSS node with name iconview and style class .view.
 * For rubberband selection, a subnode with name rubberband is used.Creates a list of paths of all
        selected items. Additionally, if you are
 * planning on modifying the model after calling this function, you may
 * want to convert the returned list into a list of #GtkTreeRowReferences.
 * To do this, you can use gtk_tree_row_reference_new().
 *
 * To free the return value, use:
 * |[<!-- language="C" -->
 * g_list_free_full (list, (GDestroyNotify) gtk_tree_path_free);
 * ]|
 */
@GtkDsl
open class IconView internal constructor(override val widgetPtr: CPointer<GtkWidget>? = null) :
        Container() {
    private val self: CPointer<GtkIconView>?
        get() = widgetPtr!!.reinterpret()

    val iconView: CPointer<GtkIconView>?
        get() = widgetPtr!!.reinterpret()

    val onActivateCursorItem: Signal<IconView, CFunction<(CPointer<in CPointed>?,
            COpaquePointer?) -> Unit>> by lazy { Signal<IconView, CFunction<(CPointer<in CPointed>?,
            COpaquePointer?) -> Unit>>(widgetPtr!!, this, "activate-cursor-item",
            staticCFunction(::IconView_onActivateCursorItem_Handler)) }

    val onItemActivated: Signal1<IconView, CPointer<GtkTreePath>, CFunction<(
        CPointer<in CPointed>?,
        CPointer<GtkTreePath>,
        COpaquePointer?
    ) -> Unit>> by lazy { Signal1<IconView, CPointer<GtkTreePath>, CFunction<(
                CPointer<in CPointed>?,
                CPointer<GtkTreePath>,
                COpaquePointer?
            ) -> Unit>>(widgetPtr!!, this, "item-activated",
                    staticCFunction(::IconView_onItemActivated_Handler)) }

    val onSelectAll: Signal<IconView, CFunction<(CPointer<in CPointed>?, COpaquePointer?) -> Unit>>
            by lazy { Signal<IconView, CFunction<(CPointer<in CPointed>?, COpaquePointer?) ->
            Unit>>(widgetPtr!!, this, "select-all", staticCFunction(::IconView_onSelectAll_Handler))
            }

    val onSelectCursorItem: Signal<IconView, CFunction<(CPointer<in CPointed>?, COpaquePointer?) ->
            Unit>> by lazy { Signal<IconView, CFunction<(CPointer<in CPointed>?, COpaquePointer?) ->
            Unit>>(widgetPtr!!, this, "select-cursor-item",
            staticCFunction(::IconView_onSelectCursorItem_Handler)) }

    val onSelectionChanged: Signal<IconView, CFunction<(CPointer<in CPointed>?, COpaquePointer?) ->
            Unit>> by lazy { Signal<IconView, CFunction<(CPointer<in CPointed>?, COpaquePointer?) ->
            Unit>>(widgetPtr!!, this, "selection-changed",
            staticCFunction(::IconView_onSelectionChanged_Handler)) }

    val onToggleCursorItem: Signal<IconView, CFunction<(CPointer<in CPointed>?, COpaquePointer?) ->
            Unit>> by lazy { Signal<IconView, CFunction<(CPointer<in CPointed>?, COpaquePointer?) ->
            Unit>>(widgetPtr!!, this, "toggle-cursor-item",
            staticCFunction(::IconView_onToggleCursorItem_Handler)) }

    val onUnselectAll: Signal<IconView, CFunction<(CPointer<in CPointed>?, COpaquePointer?) ->
            Unit>> by lazy { Signal<IconView, CFunction<(CPointer<in CPointed>?, COpaquePointer?) ->
            Unit>>(widgetPtr!!, this, "unselect-all",
            staticCFunction(::IconView_onUnselectAll_Handler)) }

    /**
     * Gets the setting set by gtk_icon_view_set_activate_on_single_click().
     *
     * Causes the #GtkIconView::item-activated signal to be emitted on
     * a single click instead of a double click. */
    var activateOnSingleClick: Boolean
        get() = gtk_icon_view_get_activate_on_single_click(self) != 0
        set(value) {
            gtk_icon_view_set_activate_on_single_click(self, if (value) gtk_true() else gtk_false())
        }

    /**
     * Returns the value of the ::column-spacing property.
     *
     * Sets the ::column-spacing property which specifies the space
     * which is inserted between the columns of the icon view. */
    var columnSpacing: Int
        get() = gtk_icon_view_get_column_spacing(self)
        set(value) {
            gtk_icon_view_set_column_spacing(self, value)
        }

    /**
     * Returns the value of the ::columns property.
     *
     * Sets the ::columns property which determines in how
     * many columns the icons are arranged. If @columns is
     * -1, the number of columns will be chosen automatically
     * to fill the available area. */
    var columns: Int
        get() = gtk_icon_view_get_columns(self)
        set(value) {
            gtk_icon_view_set_columns(self, value)
        }

    /**
     * Returns the value of the ::item-orientation property which determines
     * whether the labels are drawn beside the icons instead of below.
     *
     * Sets the ::item-orientation property which determines whether the labels
     * are drawn beside the icons instead of below. */
    var itemOrientation: GtkOrientation
        get() = gtk_icon_view_get_item_orientation(self)
        set(value) {
            gtk_icon_view_set_item_orientation(self, value)
        }

    /**
     * Returns the value of the ::item-padding property.
     *
     * Sets the #GtkIconView:item-padding property which specifies the padding
     * around each of the icon view’s items. */
    var itemPadding: Int
        get() = gtk_icon_view_get_item_padding(self)
        set(value) {
            gtk_icon_view_set_item_padding(self, value)
        }

    /**
     * Returns the value of the ::item-width property.
     *
     * Sets the ::item-width property which specifies the width
     * to use for each item. If it is set to -1, the icon view will
     * automatically determine a suitable item size. */
    var itemWidth: Int
        get() = gtk_icon_view_get_item_width(self)
        set(value) {
            gtk_icon_view_set_item_width(self, value)
        }

    /**
     * Returns the value of the ::margin property.
     *
     * Sets the ::margin property which specifies the space
     * which is inserted at the top, bottom, left and right
     * of the icon view. */
    var margin: Int
        get() = gtk_icon_view_get_margin(self)
        set(value) {
            gtk_icon_view_set_margin(self, value)
        }

    /**
     * Returns the column with markup text for @icon_view.
     *
     * Sets the column with markup information for @icon_view to be
     * @column. The markup column must be of type #G_TYPE_STRING.
     * If the markup column is set to something, it overrides
     * the text column set by gtk_icon_view_set_text_column(). */
    var markupColumn: Int
        get() = gtk_icon_view_get_markup_column(self)
        set(value) {
            gtk_icon_view_set_markup_column(self, value)
        }

    /**
     * Returns the model the #GtkIconView is based on.  Returns %NULL if the
     * model is unset.
     *
     * Sets the model for a #GtkIconView.
     * If the @icon_view already has a model set, it will remove
     * it before setting the new model.  If @model is %NULL, then
     * it will unset the old model. */
    var model: CPointer<GtkTreeModel>
        get() = gtk_icon_view_get_model(self)!!.reinterpret()
        set(value) {
            gtk_icon_view_set_model(self, value?.reinterpret())
        }

    /**
     * Returns the column with pixbufs for @icon_view.
     *
     * Sets the column with pixbufs for @icon_view to be @column. The pixbuf
     * column must be of type #GDK_TYPE_PIXBUF */
    var pixbufColumn: Int
        get() = gtk_icon_view_get_pixbuf_column(self)
        set(value) {
            gtk_icon_view_set_pixbuf_column(self, value)
        }

    /**
     * Retrieves whether the user can reorder the list via drag-and-drop.
     * See gtk_icon_view_set_reorderable().
     *
     * This function is a convenience function to allow you to reorder models that
     * support the #GtkTreeDragSourceIface and the #GtkTreeDragDestIface.  Both
     * #GtkTreeStore and #GtkListStore support these.  If @reorderable is %TRUE, then
     * the user can reorder the model by dragging and dropping rows.  The
     * developer can listen to these changes by connecting to the model's
     * row_inserted and row_deleted signals. The reordering is implemented by setting up
     * the icon view as a drag source and destination. Therefore, drag and
     * drop can not be used in a reorderable view for any other purpose.
     *
     * This function does not give you any degree of control over the order -- any
     * reordering is allowed.  If more control is needed, you should probably
     * handle drag and drop manually. */
    var reorderable: Boolean
        get() = gtk_icon_view_get_reorderable(self) != 0
        set(value) {
            gtk_icon_view_set_reorderable(self, if (value) gtk_true() else gtk_false())
        }

    /**
     * Returns the value of the ::row-spacing property.
     *
     * Sets the ::row-spacing property which specifies the space
     * which is inserted between the rows of the icon view. */
    var rowSpacing: Int
        get() = gtk_icon_view_get_row_spacing(self)
        set(value) {
            gtk_icon_view_set_row_spacing(self, value)
        }

    val selectedItems: CPointer<GList>
        get() = gtk_icon_view_get_selected_items(self)!!.reinterpret()

    /**
     * Gets the selection mode of the @icon_view.
     *
     * Sets the selection mode of the @icon_view. */
    var selectionMode: GtkSelectionMode
        get() = gtk_icon_view_get_selection_mode(self)
        set(value) {
            gtk_icon_view_set_selection_mode(self, value)
        }

    /**
     * Returns the value of the ::spacing property.
     *
     * Sets the ::spacing property which specifies the space
     * which is inserted between the cells (i.e. the icon and
     * the text) of an item. */
    var spacing: Int
        get() = gtk_icon_view_get_spacing(self)
        set(value) {
            gtk_icon_view_set_spacing(self, value)
        }

    /**
     * Returns the column with text for @icon_view.
     *
     * Sets the column with text for @icon_view to be @column. The text
     * column must be of type #G_TYPE_STRING. */
    var textColumn: Int
        get() = gtk_icon_view_get_text_column(self)
        set(value) {
            gtk_icon_view_set_text_column(self, value)
        }

    /**
     * Returns the column of @icon_view’s model which is being used for
     * displaying tooltips on @icon_view’s rows.
     *
     * If you only plan to have simple (text-only) tooltips on full items, you
     * can use this function to have #GtkIconView handle these automatically
     * for you. @column should be set to the column in @icon_view’s model
     * containing the tooltip texts, or -1 to disable this feature.
     *
     * When enabled, #GtkWidget:has-tooltip will be set to %TRUE and
     * @icon_view will connect a #GtkWidget::query-tooltip signal handler.
     *
     * Note that the signal handler sets the text with gtk_tooltip_set_markup(),
     * so &, <, etc have to be escaped in the text. */
    var tooltipColumn: Int
        get() = gtk_icon_view_get_tooltip_column(self)
        set(value) {
            gtk_icon_view_set_tooltip_column(self, value)
        }

    /**
     * Creates a new #GtkIconView widget */
    constructor() : this(gtk_icon_view_new()?.reinterpret())

    /**
     * Gets the column in which the item @path is currently
     * displayed. Column numbers start at 0.
     */
    fun getItemColumn(path: CPointer<GtkTreePath>): Int = gtk_icon_view_get_item_column(self, path)

    /**
     * Gets the row in which the item @path is currently
     * displayed. Row numbers start at 0.
     */
    fun getItemRow(path: CPointer<GtkTreePath>): Int = gtk_icon_view_get_item_row(self, path)

    /**
     * Finds the path at the point (@x, @y), relative to bin_window coordinates.
     * See gtk_icon_view_get_item_at_pos(), if you are also interested in
     * the cell at the specified position.
     * See gtk_icon_view_convert_widget_to_bin_window_coords() for converting
     * widget coordinates to bin_window coordinates.
     */
    fun getPathAtPos(x: Int, y: Int): CPointer<GtkTreePath> = gtk_icon_view_get_path_at_pos(self, x,
            y)!!.reinterpret()

    /**
     * Activates the item determined by @path.
     */
    fun itemActivated(path: CPointer<GtkTreePath>): Unit = gtk_icon_view_item_activated(self, path)

    /**
     * Returns %TRUE if the icon pointed to by @path is currently
     * selected. If @path does not point to a valid location, %FALSE is returned.
     */
    fun pathIsSelected(path: CPointer<GtkTreePath>): Boolean = gtk_icon_view_path_is_selected(self,
            path) != 0

    /**
     * Moves the alignments of @icon_view to the position specified by @path.
     * @row_align determines where the row is placed, and @col_align determines
     * where @column is placed.  Both are expected to be between 0.0 and 1.0.
     * 0.0 means left/top alignment, 1.0 means right/bottom alignment, 0.5 means
     * center.
     *
     * If @use_align is %FALSE, then the alignment arguments are ignored, and the
     * tree does the minimum amount of work to scroll the item onto the screen.
     * This means that the item will be scrolled to the edge closest to its current
     * position.  If the item is currently visible on the screen, nothing is done.
     *
     * This function only works if the model is set, and @path is a valid row on
     * the model. If the model changes before the @icon_view is realized, the
     * centered path will be modified to reflect this change.
     */
    fun scrollToPath(
        path: CPointer<GtkTreePath>,
        use_align: Boolean,
        row_align: Float,
        col_align: Float
    ): Unit = gtk_icon_view_scroll_to_path(self, path, if (use_align) gtk_true() else gtk_false(),
            row_align, col_align)

    /**
     * Selects all the icons. @icon_view must has its selection mode set
     * to #GTK_SELECTION_MULTIPLE.
     */
    fun selectAll(): Unit = gtk_icon_view_select_all(self)

    /**
     * Selects the row at @path.
     */
    fun selectPath(path: CPointer<GtkTreePath>): Unit = gtk_icon_view_select_path(self, path)

    /**
     * Sets the current keyboard focus to be at @path, and selects it.  This is
     * useful when you want to focus the user’s attention on a particular item.
     * If @cell is not %NULL, then focus is given to the cell specified by
     * it. Additionally, if @start_editing is %TRUE, then editing should be
     * started in the specified cell.
     *
     * This function is often followed by `gtk_widget_grab_focus
     * (icon_view)` in order to give keyboard focus to the widget.
     * Please note that editing can only happen when the widget is realized.
     */
    fun setCursor(
        path: CPointer<GtkTreePath>,
        cell: CPointer<GtkCellRenderer>,
        start_editing: Boolean
    ): Unit = gtk_icon_view_set_cursor(self, path, cell,
            if (start_editing) gtk_true() else gtk_false())

    /**
     * Sets the item that is highlighted for feedback.
     */
    fun setDragDestItem(path: CPointer<GtkTreePath>, pos: GtkIconViewDropPosition): Unit =
            gtk_icon_view_set_drag_dest_item(self, path, pos)

    /**
     * Sets the tip area of @tooltip to the area which @cell occupies in
     * the item pointed to by @path. See also gtk_tooltip_set_tip_area().
     *
     * See also gtk_icon_view_set_tooltip_column() for a simpler alternative.
     */
    fun setTooltipCell(
        tooltip: CPointer<GtkTooltip>,
        path: CPointer<GtkTreePath>,
        cell: CPointer<GtkCellRenderer>
    ): Unit = gtk_icon_view_set_tooltip_cell(self, tooltip, path, cell)

    /**
     * Sets the tip area of @tooltip to be the area covered by the item at @path.
     * See also gtk_icon_view_set_tooltip_column() for a simpler alternative.
     * See also gtk_tooltip_set_tip_area().
     */
    fun setTooltipItem(tooltip: CPointer<GtkTooltip>, path: CPointer<GtkTreePath>): Unit =
            gtk_icon_view_set_tooltip_item(self, tooltip, path)

    /**
     * Unselects all the icons.
     */
    fun unselectAll(): Unit = gtk_icon_view_unselect_all(self)

    /**
     * Unselects the row at @path.
     */
    fun unselectPath(path: CPointer<GtkTreePath>): Unit = gtk_icon_view_unselect_path(self, path)

    /**
     * Undoes the effect of gtk_icon_view_enable_model_drag_dest(). Calling this
     * method sets #GtkIconView:reorderable to %FALSE.
     */
    fun unsetModelDragDest(): Unit = gtk_icon_view_unset_model_drag_dest(self)

    /**
     * Undoes the effect of gtk_icon_view_enable_model_drag_source(). Calling this
     * method sets #GtkIconView:reorderable to %FALSE.
     */
    fun unsetModelDragSource(): Unit = gtk_icon_view_unset_model_drag_source(self)
}

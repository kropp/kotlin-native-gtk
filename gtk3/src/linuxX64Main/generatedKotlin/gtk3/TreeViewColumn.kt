package gtk3

import kotlin.Boolean
import kotlin.Float
import kotlin.Int
import kotlin.String
import kotlin.Unit
import kotlinx.cinterop.CFunction
import kotlinx.cinterop.COpaquePointer
import kotlinx.cinterop.CPointed
import kotlinx.cinterop.CPointer
import kotlinx.cinterop.asStableRef
import kotlinx.cinterop.reinterpret
import kotlinx.cinterop.staticCFunction
import kotlinx.cinterop.toKString
import libgtk3.GtkCellRenderer
import libgtk3.GtkSortType
import libgtk3.GtkTreeIter
import libgtk3.GtkTreeModel
import libgtk3.GtkTreeViewColumn
import libgtk3.GtkTreeViewColumnSizing
import libgtk3.GtkWidget
import libgtk3.gtk_false
import libgtk3.gtk_tree_view_column_add_attribute
import libgtk3.gtk_tree_view_column_cell_is_visible
import libgtk3.gtk_tree_view_column_cell_set_cell_data
import libgtk3.gtk_tree_view_column_clear
import libgtk3.gtk_tree_view_column_clear_attributes
import libgtk3.gtk_tree_view_column_clicked
import libgtk3.gtk_tree_view_column_focus_cell
import libgtk3.gtk_tree_view_column_get_alignment
import libgtk3.gtk_tree_view_column_get_button
import libgtk3.gtk_tree_view_column_get_clickable
import libgtk3.gtk_tree_view_column_get_expand
import libgtk3.gtk_tree_view_column_get_fixed_width
import libgtk3.gtk_tree_view_column_get_max_width
import libgtk3.gtk_tree_view_column_get_min_width
import libgtk3.gtk_tree_view_column_get_reorderable
import libgtk3.gtk_tree_view_column_get_resizable
import libgtk3.gtk_tree_view_column_get_sizing
import libgtk3.gtk_tree_view_column_get_sort_column_id
import libgtk3.gtk_tree_view_column_get_sort_indicator
import libgtk3.gtk_tree_view_column_get_sort_order
import libgtk3.gtk_tree_view_column_get_spacing
import libgtk3.gtk_tree_view_column_get_title
import libgtk3.gtk_tree_view_column_get_tree_view
import libgtk3.gtk_tree_view_column_get_visible
import libgtk3.gtk_tree_view_column_get_widget
import libgtk3.gtk_tree_view_column_get_width
import libgtk3.gtk_tree_view_column_get_x_offset
import libgtk3.gtk_tree_view_column_new
import libgtk3.gtk_tree_view_column_pack_end
import libgtk3.gtk_tree_view_column_pack_start
import libgtk3.gtk_tree_view_column_queue_resize
import libgtk3.gtk_tree_view_column_set_alignment
import libgtk3.gtk_tree_view_column_set_attributes
import libgtk3.gtk_tree_view_column_set_clickable
import libgtk3.gtk_tree_view_column_set_expand
import libgtk3.gtk_tree_view_column_set_fixed_width
import libgtk3.gtk_tree_view_column_set_max_width
import libgtk3.gtk_tree_view_column_set_min_width
import libgtk3.gtk_tree_view_column_set_reorderable
import libgtk3.gtk_tree_view_column_set_resizable
import libgtk3.gtk_tree_view_column_set_sizing
import libgtk3.gtk_tree_view_column_set_sort_column_id
import libgtk3.gtk_tree_view_column_set_sort_indicator
import libgtk3.gtk_tree_view_column_set_sort_order
import libgtk3.gtk_tree_view_column_set_spacing
import libgtk3.gtk_tree_view_column_set_title
import libgtk3.gtk_tree_view_column_set_visible
import libgtk3.gtk_tree_view_column_set_widget
import libgtk3.gtk_true

private fun TreeViewColumn_onClicked_Handler(sender: CPointer<in CPointed>?, _data: COpaquePointer?)
        {
    _data?.asStableRef<TreeViewColumn>()?.get()?.onClicked?.emit()
}

/**
 * The GtkTreeViewColumn object represents a visible column in a #GtkTreeView widget.
 * It allows to set properties of the column header, and functions as a holding pen for
 * the cell renderers which determine how the data in the column is displayed.
 *
 * Please refer to the [tree widget conceptual overview][TreeWidget]
 * for an overview of all the objects and data types related to the tree widget and how
 * they work together.Returns the button used in the treeview column headerReturns the #GtkTreeView
        wherein @tree_column has been inserted.
 * If @column is currently not inserted in any tree view, %NULL is
 * returned.Returns the current size of @tree_column in pixels.Returns the current X offset of
        @tree_column in pixels. */
@GtkDsl
open class TreeViewColumn() {
    val widgetPtr: CPointer<GtkTreeViewColumn> = gtk_tree_view_column_new()!!

    private val self: CPointer<GtkTreeViewColumn>
        get() = widgetPtr

    val onClicked: Signal<TreeViewColumn, CFunction<(CPointer<in CPointed>?, COpaquePointer?) ->
            Unit>> by lazy { Signal<TreeViewColumn, CFunction<(CPointer<in CPointed>?,
            COpaquePointer?) -> Unit>>(widgetPtr!!, this, "clicked",
            staticCFunction(::TreeViewColumn_onClicked_Handler)) }

    /**
     * Returns the current x alignment of @tree_column.  This value can range
     * between 0.0 and 1.0.
     *
     * Sets the alignment of the title or custom widget inside the column header.
     * The alignment determines its location inside the button -- 0.0 for left, 0.5
     * for center, 1.0 for right. */
    var alignment: Float
        get() = gtk_tree_view_column_get_alignment(self)
        set(value) {
            gtk_tree_view_column_set_alignment(self, value)
        }

    val button: CPointer<GtkWidget>
        get() = gtk_tree_view_column_get_button(self)!!.reinterpret()

    /**
     * Returns %TRUE if the user can click on the header for the column.
     *
     * Sets the header to be active if @clickable is %TRUE.  When the header is
     * active, then it can take keyboard focus, and can be clicked. */
    var clickable: Boolean
        get() = gtk_tree_view_column_get_clickable(self) != 0
        set(value) {
            gtk_tree_view_column_set_clickable(self, if (value) gtk_true() else gtk_false())
        }

    /**
     * Returns %TRUE if the column expands to fill available space.
     *
     * Sets the column to take available extra space.  This space is shared equally
     * amongst all columns that have the expand set to %TRUE.  If no column has this
     * option set, then the last column gets all extra space.  By default, every
     * column is created with this %FALSE.
     *
     * Along with “fixed-width”, the “expand” property changes when the column is
     * resized by the user. */
    var expand: Boolean
        get() = gtk_tree_view_column_get_expand(self) != 0
        set(value) {
            gtk_tree_view_column_set_expand(self, if (value) gtk_true() else gtk_false())
        }

    /**
     * Gets the fixed width of the column.  This may not be the actual displayed
     * width of the column; for that, use gtk_tree_view_column_get_width().
     *
     * If @fixed_width is not -1, sets the fixed width of @tree_column; otherwise
     * unsets it.  The effective value of @fixed_width is clamped between the
     * minimum and maximum width of the column; however, the value stored in the
     * “fixed-width” property is not clamped.  If the column sizing is
     * #GTK_TREE_VIEW_COLUMN_GROW_ONLY or #GTK_TREE_VIEW_COLUMN_AUTOSIZE, setting
     * a fixed width overrides the automatically calculated width.  Note that
     * @fixed_width is only a hint to GTK+; the width actually allocated to the
     * column may be greater or less than requested.
     *
     * Along with “expand”, the “fixed-width” property changes when the column is
     * resized by the user. */
    var fixedWidth: Int
        get() = gtk_tree_view_column_get_fixed_width(self)
        set(value) {
            gtk_tree_view_column_set_fixed_width(self, value)
        }

    /**
     * Returns the maximum width in pixels of the @tree_column, or -1 if no maximum
     * width is set.
     *
     * Sets the maximum width of the @tree_column.  If @max_width is -1, then the
     * maximum width is unset.  Note, the column can actually be wider than max
     * width if it’s the last column in a view.  In this case, the column expands to
     * fill any extra space. */
    var maxWidth: Int
        get() = gtk_tree_view_column_get_max_width(self)
        set(value) {
            gtk_tree_view_column_set_max_width(self, value)
        }

    /**
     * Returns the minimum width in pixels of the @tree_column, or -1 if no minimum
     * width is set.
     *
     * Sets the minimum width of the @tree_column.  If @min_width is -1, then the
     * minimum width is unset. */
    var minWidth: Int
        get() = gtk_tree_view_column_get_min_width(self)
        set(value) {
            gtk_tree_view_column_set_min_width(self, value)
        }

    /**
     * Returns %TRUE if the @tree_column can be reordered by the user.
     *
     * If @reorderable is %TRUE, then the column can be reordered by the end user
     * dragging the header. */
    var reorderable: Boolean
        get() = gtk_tree_view_column_get_reorderable(self) != 0
        set(value) {
            gtk_tree_view_column_set_reorderable(self, if (value) gtk_true() else gtk_false())
        }

    /**
     * Returns %TRUE if the @tree_column can be resized by the end user.
     *
     * If @resizable is %TRUE, then the user can explicitly resize the column by
     * grabbing the outer edge of the column button.  If resizable is %TRUE and
     * sizing mode of the column is #GTK_TREE_VIEW_COLUMN_AUTOSIZE, then the sizing
     * mode is changed to #GTK_TREE_VIEW_COLUMN_GROW_ONLY. */
    var resizable: Boolean
        get() = gtk_tree_view_column_get_resizable(self) != 0
        set(value) {
            gtk_tree_view_column_set_resizable(self, if (value) gtk_true() else gtk_false())
        }

    /**
     * Returns the current type of @tree_column.
     *
     * Sets the growth behavior of @tree_column to @type. */
    var sizing: GtkTreeViewColumnSizing
        get() = gtk_tree_view_column_get_sizing(self)
        set(value) {
            gtk_tree_view_column_set_sizing(self, value)
        }

    /**
     * Gets the logical @sort_column_id that the model sorts on when this
     * column is selected for sorting.
     * See gtk_tree_view_column_set_sort_column_id().
     *
     * Sets the logical @sort_column_id that this column sorts on when this column
     * is selected for sorting.  Doing so makes the column header clickable. */
    var sortColumnId: Int
        get() = gtk_tree_view_column_get_sort_column_id(self)
        set(value) {
            gtk_tree_view_column_set_sort_column_id(self, value)
        }

    /**
     * Gets the value set by gtk_tree_view_column_set_sort_indicator().
     *
     * Call this function with a @setting of %TRUE to display an arrow in
     * the header button indicating the column is sorted. Call
     * gtk_tree_view_column_set_sort_order() to change the direction of
     * the arrow. */
    var sortIndicator: Boolean
        get() = gtk_tree_view_column_get_sort_indicator(self) != 0
        set(value) {
            gtk_tree_view_column_set_sort_indicator(self, if (value) gtk_true() else gtk_false())
        }

    /**
     * Gets the value set by gtk_tree_view_column_set_sort_order().
     *
     * Changes the appearance of the sort indicator.
     *
     * This does not actually sort the model.  Use
     * gtk_tree_view_column_set_sort_column_id() if you want automatic sorting
     * support.  This function is primarily for custom sorting behavior, and should
     * be used in conjunction with gtk_tree_sortable_set_sort_column_id() to do
     * that. For custom models, the mechanism will vary.
     *
     * The sort indicator changes direction to indicate normal sort or reverse sort.
     * Note that you must have the sort indicator enabled to see anything when
     * calling this function; see gtk_tree_view_column_set_sort_indicator(). */
    var sortOrder: GtkSortType
        get() = gtk_tree_view_column_get_sort_order(self)
        set(value) {
            gtk_tree_view_column_set_sort_order(self, value)
        }

    /**
     * Returns the spacing of @tree_column.
     *
     * Sets the spacing field of @tree_column, which is the number of pixels to
     * place between cell renderers packed into it. */
    var spacing: Int
        get() = gtk_tree_view_column_get_spacing(self)
        set(value) {
            gtk_tree_view_column_set_spacing(self, value)
        }

    /**
     * Returns the title of the widget.
     *
     * Sets the title of the @tree_column.  If a custom widget has been set, then
     * this value is ignored. */
    var title: String
        get() = gtk_tree_view_column_get_title(self)?.toKString() ?: ""
        set(value) {
            gtk_tree_view_column_set_title(self, value)
        }

    val treeView: CPointer<GtkWidget>
        get() = gtk_tree_view_column_get_tree_view(self)!!.reinterpret()

    /**
     * Returns %TRUE if @tree_column is visible.
     *
     * Sets the visibility of @tree_column. */
    var visible: Boolean
        get() = gtk_tree_view_column_get_visible(self) != 0
        set(value) {
            gtk_tree_view_column_set_visible(self, if (value) gtk_true() else gtk_false())
        }

    /**
     * Returns the #GtkWidget in the button on the column header.
     * If a custom widget has not been set then %NULL is returned.
     *
     * Sets the widget in the header to be @widget.  If widget is %NULL, then the
     * header button is set with a #GtkLabel set to the title of @tree_column. */
    var widget: CPointer<GtkWidget>
        get() = gtk_tree_view_column_get_widget(self)!!.reinterpret()
        set(value) {
            gtk_tree_view_column_set_widget(self, value?.reinterpret())
        }

    val width: Int
        get() = gtk_tree_view_column_get_width(self)

    val xOffset: Int
        get() = gtk_tree_view_column_get_x_offset(self)

    /**
     * Adds an attribute mapping to the list in @tree_column.  The @column is the
     * column of the model to get a value from, and the @attribute is the
     * parameter on @cell_renderer to be set from the value. So for example
     * if column 2 of the model contains strings, you could have the
     * “text” attribute of a #GtkCellRendererText get its values from
     * column 2.
     */
    fun addAttribute(
        cell_renderer: CPointer<GtkCellRenderer>,
        attribute: String,
        column: Int
    ): Unit = gtk_tree_view_column_add_attribute(self, cell_renderer, attribute, column)

    /**
     * Returns %TRUE if any of the cells packed into the @tree_column are visible.
     * For this to be meaningful, you must first initialize the cells with
     * gtk_tree_view_column_cell_set_cell_data()
     */
    fun cellIsVisible(): Boolean = gtk_tree_view_column_cell_is_visible(self) != 0

    /**
     * Sets the cell renderer based on the @tree_model and @iter.  That is, for
     * every attribute mapping in @tree_column, it will get a value from the set
     * column on the @iter, and use that value to set the attribute on the cell
     * renderer.  This is used primarily by the #GtkTreeView.
     */
    fun cellSetCellData(
        tree_model: CPointer<GtkTreeModel>,
        iter: CPointer<GtkTreeIter>,
        is_expander: Boolean,
        is_expanded: Boolean
    ): Unit = gtk_tree_view_column_cell_set_cell_data(self, tree_model, iter,
            if (is_expander) gtk_true() else gtk_false(),
            if (is_expanded) gtk_true() else gtk_false())

    /**
     * Unsets all the mappings on all renderers on the @tree_column.
     */
    fun clear(): Unit = gtk_tree_view_column_clear(self)

    /**
     * Clears all existing attributes previously set with
     * gtk_tree_view_column_set_attributes().
     */
    fun clearAttributes(cell_renderer: CPointer<GtkCellRenderer>): Unit =
            gtk_tree_view_column_clear_attributes(self, cell_renderer)

    /**
     * Emits the “clicked” signal on the column.  This function will only work if
     * @tree_column is clickable.
     */
    fun clicked(): Unit = gtk_tree_view_column_clicked(self)

    /**
     * Sets the current keyboard focus to be at @cell, if the column contains
     * 2 or more editable and activatable cells.
     */
    fun focusCell(cell: CPointer<GtkCellRenderer>): Unit = gtk_tree_view_column_focus_cell(self,
            cell)

    /**
     * Adds the @cell to end of the column. If @expand is %FALSE, then the @cell
     * is allocated no more space than it needs. Any unused space is divided
     * evenly between cells for which @expand is %TRUE.
     */
    fun packEnd(cell: CPointer<GtkCellRenderer>, expand: Boolean): Unit =
            gtk_tree_view_column_pack_end(self, cell, if (expand) gtk_true() else gtk_false())

    /**
     * Packs the @cell into the beginning of the column. If @expand is %FALSE, then
     * the @cell is allocated no more space than it needs. Any unused space is divided
     * evenly between cells for which @expand is %TRUE.
     */
    fun packStart(cell: CPointer<GtkCellRenderer>, expand: Boolean): Unit =
            gtk_tree_view_column_pack_start(self, cell, if (expand) gtk_true() else gtk_false())

    /**
     * Flags the column, and the cell renderers added to this column, to have
     * their sizes renegotiated.
     */
    fun queueResize(): Unit = gtk_tree_view_column_queue_resize(self)

    /**
     * Sets the attributes in the list as the attributes of @tree_column.
     * The attributes should be in attribute/column order, as in
     * gtk_tree_view_column_add_attribute(). All existing attributes
     * are removed, and replaced with the new attributes.
     */
    fun setAttributes(cell_renderer: CPointer<GtkCellRenderer>): Unit =
            gtk_tree_view_column_set_attributes(self, cell_renderer)
}

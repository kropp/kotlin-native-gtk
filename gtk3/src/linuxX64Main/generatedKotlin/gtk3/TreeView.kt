package gtk3

import kotlin.Boolean
import kotlin.Float
import kotlin.Int
import kotlin.String
import kotlin.UInt
import kotlin.Unit
import kotlinx.cinterop.CFunction
import kotlinx.cinterop.COpaquePointer
import kotlinx.cinterop.CPointed
import kotlinx.cinterop.CPointer
import kotlinx.cinterop.asStableRef
import kotlinx.cinterop.reinterpret
import kotlinx.cinterop.staticCFunction
import libgtk3.GList
import libgtk3.GdkWindow
import libgtk3.GtkCellRenderer
import libgtk3.GtkEntry
import libgtk3.GtkTooltip
import libgtk3.GtkTreeIter
import libgtk3.GtkTreeModel
import libgtk3.GtkTreePath
import libgtk3.GtkTreeSelection
import libgtk3.GtkTreeView
import libgtk3.GtkTreeViewColumn
import libgtk3.GtkTreeViewDropPosition
import libgtk3.GtkTreeViewGridLines
import libgtk3.GtkWidget
import libgtk3.gtk_false
import libgtk3.gtk_tree_view_append_column
import libgtk3.gtk_tree_view_collapse_all
import libgtk3.gtk_tree_view_collapse_row
import libgtk3.gtk_tree_view_columns_autosize
import libgtk3.gtk_tree_view_expand_all
import libgtk3.gtk_tree_view_expand_row
import libgtk3.gtk_tree_view_expand_to_path
import libgtk3.gtk_tree_view_get_activate_on_single_click
import libgtk3.gtk_tree_view_get_bin_window
import libgtk3.gtk_tree_view_get_column
import libgtk3.gtk_tree_view_get_columns
import libgtk3.gtk_tree_view_get_enable_search
import libgtk3.gtk_tree_view_get_enable_tree_lines
import libgtk3.gtk_tree_view_get_expander_column
import libgtk3.gtk_tree_view_get_fixed_height_mode
import libgtk3.gtk_tree_view_get_grid_lines
import libgtk3.gtk_tree_view_get_headers_clickable
import libgtk3.gtk_tree_view_get_headers_visible
import libgtk3.gtk_tree_view_get_hover_expand
import libgtk3.gtk_tree_view_get_hover_selection
import libgtk3.gtk_tree_view_get_level_indentation
import libgtk3.gtk_tree_view_get_model
import libgtk3.gtk_tree_view_get_n_columns
import libgtk3.gtk_tree_view_get_reorderable
import libgtk3.gtk_tree_view_get_rubber_banding
import libgtk3.gtk_tree_view_get_search_column
import libgtk3.gtk_tree_view_get_search_entry
import libgtk3.gtk_tree_view_get_selection
import libgtk3.gtk_tree_view_get_show_expanders
import libgtk3.gtk_tree_view_get_tooltip_column
import libgtk3.gtk_tree_view_insert_column
import libgtk3.gtk_tree_view_insert_column_with_attributes
import libgtk3.gtk_tree_view_is_rubber_banding_active
import libgtk3.gtk_tree_view_move_column_after
import libgtk3.gtk_tree_view_new
import libgtk3.gtk_tree_view_remove_column
import libgtk3.gtk_tree_view_row_activated
import libgtk3.gtk_tree_view_row_expanded
import libgtk3.gtk_tree_view_scroll_to_cell
import libgtk3.gtk_tree_view_scroll_to_point
import libgtk3.gtk_tree_view_set_activate_on_single_click
import libgtk3.gtk_tree_view_set_cursor
import libgtk3.gtk_tree_view_set_cursor_on_cell
import libgtk3.gtk_tree_view_set_drag_dest_row
import libgtk3.gtk_tree_view_set_enable_search
import libgtk3.gtk_tree_view_set_enable_tree_lines
import libgtk3.gtk_tree_view_set_expander_column
import libgtk3.gtk_tree_view_set_fixed_height_mode
import libgtk3.gtk_tree_view_set_grid_lines
import libgtk3.gtk_tree_view_set_headers_clickable
import libgtk3.gtk_tree_view_set_headers_visible
import libgtk3.gtk_tree_view_set_hover_expand
import libgtk3.gtk_tree_view_set_hover_selection
import libgtk3.gtk_tree_view_set_level_indentation
import libgtk3.gtk_tree_view_set_model
import libgtk3.gtk_tree_view_set_reorderable
import libgtk3.gtk_tree_view_set_rubber_banding
import libgtk3.gtk_tree_view_set_search_column
import libgtk3.gtk_tree_view_set_search_entry
import libgtk3.gtk_tree_view_set_show_expanders
import libgtk3.gtk_tree_view_set_tooltip_cell
import libgtk3.gtk_tree_view_set_tooltip_column
import libgtk3.gtk_tree_view_set_tooltip_row
import libgtk3.gtk_tree_view_unset_rows_drag_dest
import libgtk3.gtk_tree_view_unset_rows_drag_source
import libgtk3.gtk_true

inline fun Container.treeView(init: TreeView.() -> Unit = {}): TreeView = TreeView().apply { init();
        this@treeView.add(this) }

private fun TreeView_onColumnsChanged_Handler(sender: CPointer<in CPointed>?, _data:
        COpaquePointer?) {
    _data?.asStableRef<TreeView>()?.get()?.onColumnsChanged?.emit()
}

private fun TreeView_onCursorChanged_Handler(sender: CPointer<in CPointed>?, _data: COpaquePointer?)
        {
    _data?.asStableRef<TreeView>()?.get()?.onCursorChanged?.emit()
}

private fun TreeView_onExpandCollapseCursorRow_Handler(
    sender: CPointer<in CPointed>?,
    `object`: Boolean,
    p0: Boolean,
    p1: Boolean,
    _data: COpaquePointer?
) {
    _data?.asStableRef<TreeView>()?.get()?.onExpandCollapseCursorRow?.emit(`object`, p0, p1)
}

private fun TreeView_onRowActivated_Handler(
    sender: CPointer<in CPointed>?,
    path: CPointer<GtkTreePath>,
    column: CPointer<GtkTreeViewColumn>,
    _data: COpaquePointer?
) {
    _data?.asStableRef<TreeView>()?.get()?.onRowActivated?.emit(path?.reinterpret(),
            column?.reinterpret())
}

private fun TreeView_onRowCollapsed_Handler(
    sender: CPointer<in CPointed>?,
    iter: CPointer<GtkTreeIter>,
    path: CPointer<GtkTreePath>,
    _data: COpaquePointer?
) {
    _data?.asStableRef<TreeView>()?.get()?.onRowCollapsed?.emit(iter?.reinterpret(),
            path?.reinterpret())
}

private fun TreeView_onRowExpanded_Handler(
    sender: CPointer<in CPointed>?,
    iter: CPointer<GtkTreeIter>,
    path: CPointer<GtkTreePath>,
    _data: COpaquePointer?
) {
    _data?.asStableRef<TreeView>()?.get()?.onRowExpanded?.emit(iter?.reinterpret(),
            path?.reinterpret())
}

private fun TreeView_onSelectAll_Handler(sender: CPointer<in CPointed>?, _data: COpaquePointer?) {
    _data?.asStableRef<TreeView>()?.get()?.onSelectAll?.emit()
}

private fun TreeView_onSelectCursorParent_Handler(sender: CPointer<in CPointed>?, _data:
        COpaquePointer?) {
    _data?.asStableRef<TreeView>()?.get()?.onSelectCursorParent?.emit()
}

private fun TreeView_onSelectCursorRow_Handler(
    sender: CPointer<in CPointed>?,
    `object`: Boolean,
    _data: COpaquePointer?
) {
    _data?.asStableRef<TreeView>()?.get()?.onSelectCursorRow?.emit(`object`)
}

private fun TreeView_onStartInteractiveSearch_Handler(sender: CPointer<in CPointed>?, _data:
        COpaquePointer?) {
    _data?.asStableRef<TreeView>()?.get()?.onStartInteractiveSearch?.emit()
}

private fun TreeView_onTestCollapseRow_Handler(
    sender: CPointer<in CPointed>?,
    iter: CPointer<GtkTreeIter>,
    path: CPointer<GtkTreePath>,
    _data: COpaquePointer?
) {
    _data?.asStableRef<TreeView>()?.get()?.onTestCollapseRow?.emit(iter?.reinterpret(),
            path?.reinterpret())
}

private fun TreeView_onTestExpandRow_Handler(
    sender: CPointer<in CPointed>?,
    iter: CPointer<GtkTreeIter>,
    path: CPointer<GtkTreePath>,
    _data: COpaquePointer?
) {
    _data?.asStableRef<TreeView>()?.get()?.onTestExpandRow?.emit(iter?.reinterpret(),
            path?.reinterpret())
}

private fun TreeView_onToggleCursorRow_Handler(sender: CPointer<in CPointed>?, _data:
        COpaquePointer?) {
    _data?.asStableRef<TreeView>()?.get()?.onToggleCursorRow?.emit()
}

private fun TreeView_onUnselectAll_Handler(sender: CPointer<in CPointed>?, _data: COpaquePointer?) {
    _data?.asStableRef<TreeView>()?.get()?.onUnselectAll?.emit()
}

/**
 * Widget that displays any object that implements the #GtkTreeModel interface.
 *
 * Please refer to the
 * [tree widget conceptual overview][TreeWidget]
 * for an overview of all the objects and data types related
 * to the tree widget and how they work together.
 *
 * Several different coordinate systems are exposed in the GtkTreeView API.
 * These are:
 *
 * ![](tree-view-coordinates.png)
 *
 * Coordinate systems in GtkTreeView API:
 *
 * - Widget coordinates: Coordinates relative to the widget (usually `widget->window`).
 *
 * - Bin window coordinates: Coordinates relative to the window that GtkTreeView renders to.
 *
 * - Tree coordinates: Coordinates relative to the entire scrollable area of GtkTreeView. These
 *   coordinates start at (0, 0) for row 0 of the tree.
 *
 * Several functions are available for converting between the different
 * coordinate systems.  The most common translations are between widget and bin
 * window coordinates and between bin window and tree coordinates. For the
 * former you can use gtk_tree_view_convert_widget_to_bin_window_coords()
 * (and vice versa), for the latter gtk_tree_view_convert_bin_window_to_tree_coords()
 * (and vice versa).
 *
 * # GtkTreeView as GtkBuildable
 *
 * The GtkTreeView implementation of the GtkBuildable interface accepts
 * #GtkTreeViewColumn objects as <child> elements and exposes the internal
 * #GtkTreeSelection in UI definitions.
 *
 * An example of a UI definition fragment with GtkTreeView:
 * |[
 * <object class="GtkTreeView" id="treeview">
 *   <property name="model">liststore1</property>
 *   <child>
 *     <object class="GtkTreeViewColumn" id="test-column">
 *       <property name="title">Test</property>
 *       <child>
 *         <object class="GtkCellRendererText" id="test-renderer"/>
 *         <attributes>
 *           <attribute name="text">1</attribute>
 *         </attributes>
 *       </child>
 *     </object>
 *   </child>
 *   <child internal-child="selection">
 *     <object class="GtkTreeSelection" id="selection">
 *       <signal name="changed" handler="on_treeview_selection_changed"/>
 *     </object>
 *   </child>
 * </object>
 * ]|
 *
 * # CSS nodes
 *
 * |[<!-- language="plain" -->
 * treeview.view
 * ├── header
 * │   ├── <column header>
 * ┊   ┊
 * │   ╰── <column header>
 * │
 * ╰── [rubberband]
 * ]|
 *
 * GtkTreeView has a main CSS node with name treeview and style class .view.
 * It has a subnode with name header, which is the parent for all the column
 * header widgets' CSS nodes.
 * For rubberband selection, a subnode with name rubberband is used.Returns the window that
        @tree_view renders to.
 * This is used primarily to compare to `event->window`
 * to confirm that the event on @tree_view is on the right window.Returns a #GList of all the
        #GtkTreeViewColumn s currently in @tree_view.
 * The returned list must be freed with g_list_free ().Queries the number of columns in the given
        @tree_view.Gets the #GtkTreeSelection associated with @tree_view.
 */
@GtkDsl
open class TreeView internal constructor(override val widgetPtr: CPointer<GtkWidget>? = null) :
        Container() {
    private val self: CPointer<GtkTreeView>?
        get() = widgetPtr!!.reinterpret()

    val treeView: CPointer<GtkTreeView>?
        get() = widgetPtr!!.reinterpret()

    val onColumnsChanged: Signal<TreeView, CFunction<(CPointer<in CPointed>?, COpaquePointer?) ->
            Unit>> by lazy { Signal<TreeView, CFunction<(CPointer<in CPointed>?, COpaquePointer?) ->
            Unit>>(widgetPtr!!, this, "columns-changed",
            staticCFunction(::TreeView_onColumnsChanged_Handler)) }

    val onCursorChanged: Signal<TreeView, CFunction<(CPointer<in CPointed>?, COpaquePointer?) ->
            Unit>> by lazy { Signal<TreeView, CFunction<(CPointer<in CPointed>?, COpaquePointer?) ->
            Unit>>(widgetPtr!!, this, "cursor-changed",
            staticCFunction(::TreeView_onCursorChanged_Handler)) }

    val onExpandCollapseCursorRow: Signal3<TreeView, Boolean, Boolean, Boolean, CFunction<(
        CPointer<in CPointed>?,
        Boolean,
        Boolean,
        Boolean,
        COpaquePointer?
    ) -> Unit>> by lazy { Signal3<TreeView, Boolean, Boolean, Boolean, CFunction<(
                CPointer<in CPointed>?,
                Boolean,
                Boolean,
                Boolean,
                COpaquePointer?
            ) -> Unit>>(widgetPtr!!, this, "expand-collapse-cursor-row",
                    staticCFunction(::TreeView_onExpandCollapseCursorRow_Handler)) }

    val onRowActivated: Signal2<TreeView, CPointer<GtkTreePath>, CPointer<GtkTreeViewColumn>,
            CFunction<(
        CPointer<in CPointed>?,
        CPointer<GtkTreePath>,
        CPointer<GtkTreeViewColumn>,
        COpaquePointer?
    ) -> Unit>> by lazy { Signal2<TreeView, CPointer<GtkTreePath>, CPointer<GtkTreeViewColumn>,
            CFunction<(
                CPointer<in CPointed>?,
                CPointer<GtkTreePath>,
                CPointer<GtkTreeViewColumn>,
                COpaquePointer?
            ) -> Unit>>(widgetPtr!!, this, "row-activated",
                    staticCFunction(::TreeView_onRowActivated_Handler)) }

    val onRowCollapsed: Signal2<TreeView, CPointer<GtkTreeIter>, CPointer<GtkTreePath>, CFunction<(
        CPointer<in CPointed>?,
        CPointer<GtkTreeIter>,
        CPointer<GtkTreePath>,
        COpaquePointer?
    ) -> Unit>> by lazy { Signal2<TreeView, CPointer<GtkTreeIter>, CPointer<GtkTreePath>,
            CFunction<(
                CPointer<in CPointed>?,
                CPointer<GtkTreeIter>,
                CPointer<GtkTreePath>,
                COpaquePointer?
            ) -> Unit>>(widgetPtr!!, this, "row-collapsed",
                    staticCFunction(::TreeView_onRowCollapsed_Handler)) }

    val onRowExpanded: Signal2<TreeView, CPointer<GtkTreeIter>, CPointer<GtkTreePath>, CFunction<(
        CPointer<in CPointed>?,
        CPointer<GtkTreeIter>,
        CPointer<GtkTreePath>,
        COpaquePointer?
    ) -> Unit>> by lazy { Signal2<TreeView, CPointer<GtkTreeIter>, CPointer<GtkTreePath>,
            CFunction<(
                CPointer<in CPointed>?,
                CPointer<GtkTreeIter>,
                CPointer<GtkTreePath>,
                COpaquePointer?
            ) -> Unit>>(widgetPtr!!, this, "row-expanded",
                    staticCFunction(::TreeView_onRowExpanded_Handler)) }

    val onSelectAll: Signal<TreeView, CFunction<(CPointer<in CPointed>?, COpaquePointer?) -> Unit>>
            by lazy { Signal<TreeView, CFunction<(CPointer<in CPointed>?, COpaquePointer?) ->
            Unit>>(widgetPtr!!, this, "select-all", staticCFunction(::TreeView_onSelectAll_Handler))
            }

    val onSelectCursorParent: Signal<TreeView, CFunction<(CPointer<in CPointed>?,
            COpaquePointer?) -> Unit>> by lazy { Signal<TreeView, CFunction<(CPointer<in CPointed>?,
            COpaquePointer?) -> Unit>>(widgetPtr!!, this, "select-cursor-parent",
            staticCFunction(::TreeView_onSelectCursorParent_Handler)) }

    val onSelectCursorRow: Signal1<TreeView, Boolean, CFunction<(
        CPointer<in CPointed>?,
        Boolean,
        COpaquePointer?
    ) -> Unit>> by lazy { Signal1<TreeView, Boolean, CFunction<(
                CPointer<in CPointed>?,
                Boolean,
                COpaquePointer?
            ) -> Unit>>(widgetPtr!!, this, "select-cursor-row",
                    staticCFunction(::TreeView_onSelectCursorRow_Handler)) }

    val onStartInteractiveSearch: Signal<TreeView, CFunction<(CPointer<in CPointed>?,
            COpaquePointer?) -> Unit>> by lazy { Signal<TreeView, CFunction<(CPointer<in CPointed>?,
            COpaquePointer?) -> Unit>>(widgetPtr!!, this, "start-interactive-search",
            staticCFunction(::TreeView_onStartInteractiveSearch_Handler)) }

    val onTestCollapseRow: Signal2<TreeView, CPointer<GtkTreeIter>, CPointer<GtkTreePath>,
            CFunction<(
        CPointer<in CPointed>?,
        CPointer<GtkTreeIter>,
        CPointer<GtkTreePath>,
        COpaquePointer?
    ) -> Unit>> by lazy { Signal2<TreeView, CPointer<GtkTreeIter>, CPointer<GtkTreePath>,
            CFunction<(
                CPointer<in CPointed>?,
                CPointer<GtkTreeIter>,
                CPointer<GtkTreePath>,
                COpaquePointer?
            ) -> Unit>>(widgetPtr!!, this, "test-collapse-row",
                    staticCFunction(::TreeView_onTestCollapseRow_Handler)) }

    val onTestExpandRow: Signal2<TreeView, CPointer<GtkTreeIter>, CPointer<GtkTreePath>, CFunction<(
        CPointer<in CPointed>?,
        CPointer<GtkTreeIter>,
        CPointer<GtkTreePath>,
        COpaquePointer?
    ) -> Unit>> by lazy { Signal2<TreeView, CPointer<GtkTreeIter>, CPointer<GtkTreePath>,
            CFunction<(
                CPointer<in CPointed>?,
                CPointer<GtkTreeIter>,
                CPointer<GtkTreePath>,
                COpaquePointer?
            ) -> Unit>>(widgetPtr!!, this, "test-expand-row",
                    staticCFunction(::TreeView_onTestExpandRow_Handler)) }

    val onToggleCursorRow: Signal<TreeView, CFunction<(CPointer<in CPointed>?, COpaquePointer?) ->
            Unit>> by lazy { Signal<TreeView, CFunction<(CPointer<in CPointed>?, COpaquePointer?) ->
            Unit>>(widgetPtr!!, this, "toggle-cursor-row",
            staticCFunction(::TreeView_onToggleCursorRow_Handler)) }

    val onUnselectAll: Signal<TreeView, CFunction<(CPointer<in CPointed>?, COpaquePointer?) ->
            Unit>> by lazy { Signal<TreeView, CFunction<(CPointer<in CPointed>?, COpaquePointer?) ->
            Unit>>(widgetPtr!!, this, "unselect-all",
            staticCFunction(::TreeView_onUnselectAll_Handler)) }

    /**
     * Gets the setting set by gtk_tree_view_set_activate_on_single_click().
     *
     * Cause the #GtkTreeView::row-activated signal to be emitted
     * on a single click instead of a double click. */
    var activateOnSingleClick: Boolean
        get() = gtk_tree_view_get_activate_on_single_click(self) != 0
        set(value) {
            gtk_tree_view_set_activate_on_single_click(self, if (value) gtk_true() else gtk_false())
        }

    val binWindow: CPointer<GdkWindow>
        get() = gtk_tree_view_get_bin_window(self)!!.reinterpret()

    val columns: CPointer<GList>
        get() = gtk_tree_view_get_columns(self)!!.reinterpret()

    /**
     * Returns whether or not the tree allows to start interactive searching
     * by typing in text.
     *
     * If @enable_search is set, then the user can type in text to search through
     * the tree interactively (this is sometimes called "typeahead find").
     *
     * Note that even if this is %FALSE, the user can still initiate a search
     * using the “start-interactive-search” key binding. */
    var enableSearch: Boolean
        get() = gtk_tree_view_get_enable_search(self) != 0
        set(value) {
            gtk_tree_view_set_enable_search(self, if (value) gtk_true() else gtk_false())
        }

    /**
     * Returns whether or not tree lines are drawn in @tree_view.
     *
     * Sets whether to draw lines interconnecting the expanders in @tree_view.
     * This does not have any visible effects for lists. */
    var enableTreeLines: Boolean
        get() = gtk_tree_view_get_enable_tree_lines(self) != 0
        set(value) {
            gtk_tree_view_set_enable_tree_lines(self, if (value) gtk_true() else gtk_false())
        }

    /**
     * Returns the column that is the current expander column.
     * This column has the expander arrow drawn next to it.
     *
     * Sets the column to draw the expander arrow at. It must be in @tree_view.
     * If @column is %NULL, then the expander arrow is always at the first
     * visible column.
     *
     * If you do not want expander arrow to appear in your tree, set the
     * expander column to a hidden column. */
    var expanderColumn: CPointer<GtkTreeViewColumn>
        get() = gtk_tree_view_get_expander_column(self)!!.reinterpret()
        set(value) {
            gtk_tree_view_set_expander_column(self, value?.reinterpret())
        }

    /**
     * Returns whether fixed height mode is turned on for @tree_view.
     *
     * Enables or disables the fixed height mode of @tree_view.
     * Fixed height mode speeds up #GtkTreeView by assuming that all
     * rows have the same height.
     * Only enable this option if all rows are the same height and all
     * columns are of type %GTK_TREE_VIEW_COLUMN_FIXED. */
    var fixedHeightMode: Boolean
        get() = gtk_tree_view_get_fixed_height_mode(self) != 0
        set(value) {
            gtk_tree_view_set_fixed_height_mode(self, if (value) gtk_true() else gtk_false())
        }

    /**
     * Returns which grid lines are enabled in @tree_view.
     *
     * Sets which grid lines to draw in @tree_view. */
    var gridLines: GtkTreeViewGridLines
        get() = gtk_tree_view_get_grid_lines(self)
        set(value) {
            gtk_tree_view_set_grid_lines(self, value)
        }

    /**
     * Returns whether all header columns are clickable.
     *
     * Allow the column title buttons to be clicked. */
    var headersClickable: Boolean
        get() = gtk_tree_view_get_headers_clickable(self) != 0
        set(value) {
            gtk_tree_view_set_headers_clickable(self, if (value) gtk_true() else gtk_false())
        }

    /**
     * Returns %TRUE if the headers on the @tree_view are visible.
     *
     * Sets the visibility state of the headers. */
    var headersVisible: Boolean
        get() = gtk_tree_view_get_headers_visible(self) != 0
        set(value) {
            gtk_tree_view_set_headers_visible(self, if (value) gtk_true() else gtk_false())
        }

    /**
     * Returns whether hover expansion mode is turned on for @tree_view.
     *
     * Enables or disables the hover expansion mode of @tree_view.
     * Hover expansion makes rows expand or collapse if the pointer
     * moves over them. */
    var hoverExpand: Boolean
        get() = gtk_tree_view_get_hover_expand(self) != 0
        set(value) {
            gtk_tree_view_set_hover_expand(self, if (value) gtk_true() else gtk_false())
        }

    /**
     * Returns whether hover selection mode is turned on for @tree_view.
     *
     * Enables or disables the hover selection mode of @tree_view.
     * Hover selection makes the selected row follow the pointer.
     * Currently, this works only for the selection modes
     * %GTK_SELECTION_SINGLE and %GTK_SELECTION_BROWSE. */
    var hoverSelection: Boolean
        get() = gtk_tree_view_get_hover_selection(self) != 0
        set(value) {
            gtk_tree_view_set_hover_selection(self, if (value) gtk_true() else gtk_false())
        }

    /**
     * Returns the amount, in pixels, of extra indentation for child levels
     * in @tree_view.
     *
     * Sets the amount of extra indentation for child levels to use in @tree_view
     * in addition to the default indentation.  The value should be specified in
     * pixels, a value of 0 disables this feature and in this case only the default
     * indentation will be used.
     * This does not have any visible effects for lists. */
    var levelIndentation: Int
        get() = gtk_tree_view_get_level_indentation(self)
        set(value) {
            gtk_tree_view_set_level_indentation(self, value)
        }

    /**
     * Returns the model the #GtkTreeView is based on.  Returns %NULL if the
     * model is unset.
     *
     * Sets the model for a #GtkTreeView.  If the @tree_view already has a model
     * set, it will remove it before setting the new model.  If @model is %NULL,
     * then it will unset the old model. */
    var model: CPointer<GtkTreeModel>
        get() = gtk_tree_view_get_model(self)!!.reinterpret()
        set(value) {
            gtk_tree_view_set_model(self, value?.reinterpret())
        }

    val nColumns: UInt
        get() = gtk_tree_view_get_n_columns(self)

    /**
     * Retrieves whether the user can reorder the tree via drag-and-drop. See
     * gtk_tree_view_set_reorderable().
     *
     * This function is a convenience function to allow you to reorder
     * models that support the #GtkTreeDragSourceIface and the
     * #GtkTreeDragDestIface.  Both #GtkTreeStore and #GtkListStore support
     * these.  If @reorderable is %TRUE, then the user can reorder the
     * model by dragging and dropping rows. The developer can listen to
     * these changes by connecting to the model’s #GtkTreeModel::row-inserted
     * and #GtkTreeModel::row-deleted signals. The reordering is implemented
     * by setting up the tree view as a drag source and destination.
     * Therefore, drag and drop can not be used in a reorderable view for any
     * other purpose.
     *
     * This function does not give you any degree of control over the order -- any
     * reordering is allowed.  If more control is needed, you should probably
     * handle drag and drop manually. */
    var reorderable: Boolean
        get() = gtk_tree_view_get_reorderable(self) != 0
        set(value) {
            gtk_tree_view_set_reorderable(self, if (value) gtk_true() else gtk_false())
        }

    /**
     * Returns whether rubber banding is turned on for @tree_view.  If the
     * selection mode is #GTK_SELECTION_MULTIPLE, rubber banding will allow the
     * user to select multiple rows by dragging the mouse.
     *
     * Enables or disables rubber banding in @tree_view.  If the selection mode
     * is #GTK_SELECTION_MULTIPLE, rubber banding will allow the user to select
     * multiple rows by dragging the mouse. */
    var rubberBanding: Boolean
        get() = gtk_tree_view_get_rubber_banding(self) != 0
        set(value) {
            gtk_tree_view_set_rubber_banding(self, if (value) gtk_true() else gtk_false())
        }

    /**
     * Gets the column searched on by the interactive search code.
     *
     * Sets @column as the column where the interactive search code should
     * search in for the current model.
     *
     * If the search column is set, users can use the “start-interactive-search”
     * key binding to bring up search popup. The enable-search property controls
     * whether simply typing text will also start an interactive search.
     *
     * Note that @column refers to a column of the current model. The search
     * column is reset to -1 when the model is changed. */
    var searchColumn: Int
        get() = gtk_tree_view_get_search_column(self)
        set(value) {
            gtk_tree_view_set_search_column(self, value)
        }

    /**
     * Returns the #GtkEntry which is currently in use as interactive search
     * entry for @tree_view.  In case the built-in entry is being used, %NULL
     * will be returned.
     *
     * Sets the entry which the interactive search code will use for this
     * @tree_view.  This is useful when you want to provide a search entry
     * in our interface at all time at a fixed position.  Passing %NULL for
     * @entry will make the interactive search code use the built-in popup
     * entry again. */
    var searchEntry: CPointer<GtkEntry>
        get() = gtk_tree_view_get_search_entry(self)!!.reinterpret()
        set(value) {
            gtk_tree_view_set_search_entry(self, value?.reinterpret())
        }

    val selection: CPointer<GtkTreeSelection>
        get() = gtk_tree_view_get_selection(self)!!.reinterpret()

    /**
     * Returns whether or not expanders are drawn in @tree_view.
     *
     * Sets whether to draw and enable expanders and indent child rows in
     * @tree_view.  When disabled there will be no expanders visible in trees
     * and there will be no way to expand and collapse rows by default.  Also
     * note that hiding the expanders will disable the default indentation.  You
     * can set a custom indentation in this case using
     * gtk_tree_view_set_level_indentation().
     * This does not have any visible effects for lists. */
    var showExpanders: Boolean
        get() = gtk_tree_view_get_show_expanders(self) != 0
        set(value) {
            gtk_tree_view_set_show_expanders(self, if (value) gtk_true() else gtk_false())
        }

    /**
     * Returns the column of @tree_view’s model which is being used for
     * displaying tooltips on @tree_view’s rows.
     *
     * If you only plan to have simple (text-only) tooltips on full rows, you
     * can use this function to have #GtkTreeView handle these automatically
     * for you. @column should be set to the column in @tree_view’s model
     * containing the tooltip texts, or -1 to disable this feature.
     *
     * When enabled, #GtkWidget:has-tooltip will be set to %TRUE and
     * @tree_view will connect a #GtkWidget::query-tooltip signal handler.
     *
     * Note that the signal handler sets the text with gtk_tooltip_set_markup(),
     * so &, <, etc have to be escaped in the text. */
    var tooltipColumn: Int
        get() = gtk_tree_view_get_tooltip_column(self)
        set(value) {
            gtk_tree_view_set_tooltip_column(self, value)
        }

    /**
     * Creates a new #GtkTreeView widget. */
    constructor() : this(gtk_tree_view_new()?.reinterpret())

    /**
     * Appends @column to the list of columns. If @tree_view has “fixed_height”
     * mode enabled, then @column must have its “sizing” property set to be
     * GTK_TREE_VIEW_COLUMN_FIXED.
     */
    fun appendColumn(column: CPointer<GtkTreeViewColumn>): Int = gtk_tree_view_append_column(self,
            column)

    /**
     * Appends @column to the list of columns. If @tree_view has “fixed_height”
     * mode enabled, then @column must have its “sizing” property set to be
     * GTK_TREE_VIEW_COLUMN_FIXED.
     */
    fun appendColumn(column: TreeViewColumn): Int = gtk_tree_view_append_column(self,
            column.widgetPtr?.reinterpret())

    /**
     * Recursively collapses all visible, expanded nodes in @tree_view.
     */
    fun collapseAll(): Unit = gtk_tree_view_collapse_all(self)

    /**
     * Collapses a row (hides its child rows, if they exist).
     */
    fun collapseRow(path: CPointer<GtkTreePath>): Boolean = gtk_tree_view_collapse_row(self,
            path) != 0

    /**
     * Resizes all columns to their optimal width. Only works after the
     * treeview has been realized.
     */
    fun columnsAutosize(): Unit = gtk_tree_view_columns_autosize(self)

    /**
     * Recursively expands all nodes in the @tree_view.
     */
    fun expandAll(): Unit = gtk_tree_view_expand_all(self)

    /**
     * Opens the row so its children are visible.
     */
    fun expandRow(path: CPointer<GtkTreePath>, open_all: Boolean): Boolean =
            gtk_tree_view_expand_row(self, path, if (open_all) gtk_true() else gtk_false()) != 0

    /**
     * Expands the row at @path. This will also expand all parent rows of
     * @path as necessary.
     */
    fun expandToPath(path: CPointer<GtkTreePath>): Unit = gtk_tree_view_expand_to_path(self, path)

    /**
     * Gets the #GtkTreeViewColumn at the given position in the #tree_view.
     */
    fun getColumn(n: Int): CPointer<GtkTreeViewColumn> = gtk_tree_view_get_column(self,
            n)!!.reinterpret()

    /**
     * This inserts the @column into the @tree_view at @position.  If @position is
     * -1, then the column is inserted at the end. If @tree_view has
     * “fixed_height” mode enabled, then @column must have its “sizing” property
     * set to be GTK_TREE_VIEW_COLUMN_FIXED.
     */
    fun insertColumn(column: CPointer<GtkTreeViewColumn>, position: Int): Int =
            gtk_tree_view_insert_column(self, column, position)

    /**
     * This inserts the @column into the @tree_view at @position.  If @position is
     * -1, then the column is inserted at the end. If @tree_view has
     * “fixed_height” mode enabled, then @column must have its “sizing” property
     * set to be GTK_TREE_VIEW_COLUMN_FIXED.
     */
    fun insertColumn(column: TreeViewColumn, position: Int): Int = gtk_tree_view_insert_column(self,
            column.widgetPtr?.reinterpret(), position)

    /**
     * Creates a new #GtkTreeViewColumn and inserts it into the @tree_view at
     * @position.  If @position is -1, then the newly created column is inserted at
     * the end.  The column is initialized with the attributes given. If @tree_view
     * has “fixed_height” mode enabled, then the new column will have its sizing
     * property set to be GTK_TREE_VIEW_COLUMN_FIXED.
     */
    fun insertColumnWithAttributes(
        position: Int,
        title: String,
        cell: CPointer<GtkCellRenderer>
    ): Int = gtk_tree_view_insert_column_with_attributes(self, position, title, cell)

    /**
     * Returns whether a rubber banding operation is currently being done
     * in @tree_view.
     */
    fun isRubberBandingActive(): Boolean = gtk_tree_view_is_rubber_banding_active(self) != 0

    /**
     * Moves @column to be after to @base_column.  If @base_column is %NULL, then
     * @column is placed in the first position.
     */
    fun moveColumnAfter(column: CPointer<GtkTreeViewColumn>, base_column:
            CPointer<GtkTreeViewColumn>): Unit = gtk_tree_view_move_column_after(self, column,
            base_column)

    /**
     * Moves @column to be after to @base_column.  If @base_column is %NULL, then
     * @column is placed in the first position.
     */
    fun moveColumnAfter(column: TreeViewColumn, base_column: TreeViewColumn): Unit =
            gtk_tree_view_move_column_after(self, column.widgetPtr?.reinterpret(),
            base_column.widgetPtr?.reinterpret())

    /**
     * Removes @column from @tree_view.
     */
    fun removeColumn(column: CPointer<GtkTreeViewColumn>): Int = gtk_tree_view_remove_column(self,
            column)

    /**
     * Removes @column from @tree_view.
     */
    fun removeColumn(column: TreeViewColumn): Int = gtk_tree_view_remove_column(self,
            column.widgetPtr?.reinterpret())

    /**
     * Activates the cell determined by @path and @column.
     */
    fun rowActivated(path: CPointer<GtkTreePath>, column: CPointer<GtkTreeViewColumn>): Unit =
            gtk_tree_view_row_activated(self, path, column)

    /**
     * Returns %TRUE if the node pointed to by @path is expanded in @tree_view.
     */
    fun rowExpanded(path: CPointer<GtkTreePath>): Boolean = gtk_tree_view_row_expanded(self,
            path) != 0

    /**
     * Moves the alignments of @tree_view to the position specified by @column and
     * @path.  If @column is %NULL, then no horizontal scrolling occurs.  Likewise,
     * if @path is %NULL no vertical scrolling occurs.  At a minimum, one of @column
     * or @path need to be non-%NULL.  @row_align determines where the row is
     * placed, and @col_align determines where @column is placed.  Both are expected
     * to be between 0.0 and 1.0. 0.0 means left/top alignment, 1.0 means
     * right/bottom alignment, 0.5 means center.
     *
     * If @use_align is %FALSE, then the alignment arguments are ignored, and the
     * tree does the minimum amount of work to scroll the cell onto the screen.
     * This means that the cell will be scrolled to the edge closest to its current
     * position.  If the cell is currently visible on the screen, nothing is done.
     *
     * This function only works if the model is set, and @path is a valid row on the
     * model.  If the model changes before the @tree_view is realized, the centered
     * path will be modified to reflect this change.
     */
    fun scrollToCell(
        path: CPointer<GtkTreePath>,
        column: CPointer<GtkTreeViewColumn>,
        use_align: Boolean,
        row_align: Float,
        col_align: Float
    ): Unit = gtk_tree_view_scroll_to_cell(self, path, column,
            if (use_align) gtk_true() else gtk_false(), row_align, col_align)

    /**
     * Scrolls the tree view such that the top-left corner of the visible
     * area is @tree_x, @tree_y, where @tree_x and @tree_y are specified
     * in tree coordinates.  The @tree_view must be realized before
     * this function is called.  If it isn't, you probably want to be
     * using gtk_tree_view_scroll_to_cell().
     *
     * If either @tree_x or @tree_y are -1, then that direction isn’t scrolled.
     */
    fun scrollToPoint(tree_x: Int, tree_y: Int): Unit = gtk_tree_view_scroll_to_point(self, tree_x,
            tree_y)

    /**
     * Sets the current keyboard focus to be at @path, and selects it.  This is
     * useful when you want to focus the user’s attention on a particular row.  If
     * @focus_column is not %NULL, then focus is given to the column specified by
     * it. Additionally, if @focus_column is specified, and @start_editing is
     * %TRUE, then editing should be started in the specified cell.
     * This function is often followed by @gtk_widget_grab_focus (@tree_view)
     * in order to give keyboard focus to the widget.  Please note that editing
     * can only happen when the widget is realized.
     *
     * If @path is invalid for @model, the current cursor (if any) will be unset
     * and the function will return without failing.
     */
    fun setCursor(
        path: CPointer<GtkTreePath>,
        focus_column: CPointer<GtkTreeViewColumn>,
        start_editing: Boolean
    ): Unit = gtk_tree_view_set_cursor(self, path, focus_column,
            if (start_editing) gtk_true() else gtk_false())

    /**
     * Sets the current keyboard focus to be at @path, and selects it.  This is
     * useful when you want to focus the user’s attention on a particular row.  If
     * @focus_column is not %NULL, then focus is given to the column specified by
     * it. If @focus_column and @focus_cell are not %NULL, and @focus_column
     * contains 2 or more editable or activatable cells, then focus is given to
     * the cell specified by @focus_cell. Additionally, if @focus_column is
     * specified, and @start_editing is %TRUE, then editing should be started in
     * the specified cell.  This function is often followed by
     * @gtk_widget_grab_focus (@tree_view) in order to give keyboard focus to the
     * widget.  Please note that editing can only happen when the widget is
     * realized.
     *
     * If @path is invalid for @model, the current cursor (if any) will be unset
     * and the function will return without failing.
     */
    fun setCursorOnCell(
        path: CPointer<GtkTreePath>,
        focus_column: CPointer<GtkTreeViewColumn>,
        focus_cell: CPointer<GtkCellRenderer>,
        start_editing: Boolean
    ): Unit = gtk_tree_view_set_cursor_on_cell(self, path, focus_column, focus_cell,
            if (start_editing) gtk_true() else gtk_false())

    /**
     * Sets the row that is highlighted for feedback.
     * If @path is %NULL, an existing highlight is removed.
     */
    fun setDragDestRow(path: CPointer<GtkTreePath>, pos: GtkTreeViewDropPosition): Unit =
            gtk_tree_view_set_drag_dest_row(self, path, pos)

    /**
     * Sets the tip area of @tooltip to the area @path, @column and @cell have
     * in common.  For example if @path is %NULL and @column is set, the tip
     * area will be set to the full area covered by @column.  See also
     * gtk_tooltip_set_tip_area().
     *
     * Note that if @path is not specified and @cell is set and part of a column
     * containing the expander, the tooltip might not show and hide at the correct
     * position.  In such cases @path must be set to the current node under the
     * mouse cursor for this function to operate correctly.
     *
     * See also gtk_tree_view_set_tooltip_column() for a simpler alternative.
     */
    fun setTooltipCell(
        tooltip: CPointer<GtkTooltip>,
        path: CPointer<GtkTreePath>,
        column: CPointer<GtkTreeViewColumn>,
        cell: CPointer<GtkCellRenderer>
    ): Unit = gtk_tree_view_set_tooltip_cell(self, tooltip, path, column, cell)

    /**
     * Sets the tip area of @tooltip to be the area covered by the row at @path.
     * See also gtk_tree_view_set_tooltip_column() for a simpler alternative.
     * See also gtk_tooltip_set_tip_area().
     */
    fun setTooltipRow(tooltip: CPointer<GtkTooltip>, path: CPointer<GtkTreePath>): Unit =
            gtk_tree_view_set_tooltip_row(self, tooltip, path)

    /**
     * Undoes the effect of
     * gtk_tree_view_enable_model_drag_dest(). Calling this method sets
     * #GtkTreeView:reorderable to %FALSE.
     */
    fun unsetRowsDragDest(): Unit = gtk_tree_view_unset_rows_drag_dest(self)

    /**
     * Undoes the effect of
     * gtk_tree_view_enable_model_drag_source(). Calling this method sets
     * #GtkTreeView:reorderable to %FALSE.
     */
    fun unsetRowsDragSource(): Unit = gtk_tree_view_unset_rows_drag_source(self)
}

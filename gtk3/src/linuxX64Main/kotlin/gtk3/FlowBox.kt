package gtk3

import kotlin.Boolean
import kotlin.Int
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
import libgtk3.GtkAdjustment
import libgtk3.GtkFlowBox
import libgtk3.GtkFlowBoxChild
import libgtk3.GtkSelectionMode
import libgtk3.GtkWidget
import libgtk3.gtk_false
import libgtk3.gtk_flow_box_get_activate_on_single_click
import libgtk3.gtk_flow_box_get_child_at_index
import libgtk3.gtk_flow_box_get_child_at_pos
import libgtk3.gtk_flow_box_get_column_spacing
import libgtk3.gtk_flow_box_get_homogeneous
import libgtk3.gtk_flow_box_get_max_children_per_line
import libgtk3.gtk_flow_box_get_min_children_per_line
import libgtk3.gtk_flow_box_get_row_spacing
import libgtk3.gtk_flow_box_get_selected_children
import libgtk3.gtk_flow_box_get_selection_mode
import libgtk3.gtk_flow_box_insert
import libgtk3.gtk_flow_box_invalidate_filter
import libgtk3.gtk_flow_box_invalidate_sort
import libgtk3.gtk_flow_box_new
import libgtk3.gtk_flow_box_select_all
import libgtk3.gtk_flow_box_select_child
import libgtk3.gtk_flow_box_set_activate_on_single_click
import libgtk3.gtk_flow_box_set_column_spacing
import libgtk3.gtk_flow_box_set_hadjustment
import libgtk3.gtk_flow_box_set_homogeneous
import libgtk3.gtk_flow_box_set_max_children_per_line
import libgtk3.gtk_flow_box_set_min_children_per_line
import libgtk3.gtk_flow_box_set_row_spacing
import libgtk3.gtk_flow_box_set_selection_mode
import libgtk3.gtk_flow_box_set_vadjustment
import libgtk3.gtk_flow_box_unselect_all
import libgtk3.gtk_flow_box_unselect_child
import libgtk3.gtk_true

inline fun Container.flowBox(init: FlowBox.() -> Unit = {}): FlowBox = FlowBox().apply { init();
        this@flowBox.add(this) }

private fun FlowBox_onActivateCursorChild_Handler(sender: CPointer<in CPointed>?, _data:
        COpaquePointer?) {
    _data?.asStableRef<FlowBox>()?.get()?.onActivateCursorChild?.emit()
}

private fun FlowBox_onChildActivated_Handler(
    sender: CPointer<in CPointed>?,
    child: CPointer<GtkFlowBoxChild>,
    _data: COpaquePointer?
) {
    _data?.asStableRef<FlowBox>()?.get()?.onChildActivated?.emit(child?.reinterpret())
}

private fun FlowBox_onSelectAll_Handler(sender: CPointer<in CPointed>?, _data: COpaquePointer?) {
    _data?.asStableRef<FlowBox>()?.get()?.onSelectAll?.emit()
}

private fun FlowBox_onSelectedChildrenChanged_Handler(sender: CPointer<in CPointed>?, _data:
        COpaquePointer?) {
    _data?.asStableRef<FlowBox>()?.get()?.onSelectedChildrenChanged?.emit()
}

private fun FlowBox_onToggleCursorChild_Handler(sender: CPointer<in CPointed>?, _data:
        COpaquePointer?) {
    _data?.asStableRef<FlowBox>()?.get()?.onToggleCursorChild?.emit()
}

private fun FlowBox_onUnselectAll_Handler(sender: CPointer<in CPointed>?, _data: COpaquePointer?) {
    _data?.asStableRef<FlowBox>()?.get()?.onUnselectAll?.emit()
}

/**
 * A GtkFlowBox positions child widgets in sequence according to its
 * orientation.
 *
 * For instance, with the horizontal orientation, the widgets will be
 * arranged from left to right, starting a new row under the previous
 * row when necessary. Reducing the width in this case will require more
 * rows, so a larger height will be requested.
 *
 * Likewise, with the vertical orientation, the widgets will be arranged
 * from top to bottom, starting a new column to the right when necessary.
 * Reducing the height will require more columns, so a larger width will
 * be requested.
 *
 * The size request of a GtkFlowBox alone may not be what you expect; if you
 * need to be able to shrink it along both axes and dynamically reflow its
 * children, you may have to wrap it in a #GtkScrolledWindow to enable that.
 *
 * The children of a GtkFlowBox can be dynamically sorted and filtered.
 *
 * Although a GtkFlowBox must have only #GtkFlowBoxChild children,
 * you can add any kind of widget to it via gtk_container_add(), and
 * a GtkFlowBoxChild widget will automatically be inserted between
 * the box and the widget.
 *
 * Also see #GtkListBox.
 *
 * GtkFlowBox was added in GTK+ 3.12.
 *
 * # CSS nodes
 *
 * |[<!-- language="plain" -->
 * flowbox
 * ├── flowboxchild
 * │   ╰── <child>
 * ├── flowboxchild
 * │   ╰── <child>
 * ┊
 * ╰── [rubberband]
 * ]|
 *
 * GtkFlowBox uses a single CSS node with name flowbox. GtkFlowBoxChild
 * uses a single CSS node with name flowboxchild.
 * For rubberband selection, a subnode with name rubberband is used.Creates a list of all selected
        children.
 */
@GtkDsl
open class FlowBox internal constructor(override val widgetPtr: CPointer<GtkWidget>? = null) :
        Container() {
    private val self: CPointer<GtkFlowBox>?
        get() = widgetPtr!!.reinterpret()

    val flowBox: CPointer<GtkFlowBox>?
        get() = widgetPtr!!.reinterpret()

    val onActivateCursorChild: Signal<FlowBox, CFunction<(CPointer<in CPointed>?,
            COpaquePointer?) -> Unit>> by lazy { Signal<FlowBox, CFunction<(CPointer<in CPointed>?,
            COpaquePointer?) -> Unit>>(widgetPtr!!, this, "activate-cursor-child",
            staticCFunction(::FlowBox_onActivateCursorChild_Handler)) }

    val onChildActivated: Signal1<FlowBox, CPointer<GtkFlowBoxChild>, CFunction<(
        CPointer<in CPointed>?,
        CPointer<GtkFlowBoxChild>,
        COpaquePointer?
    ) -> Unit>> by lazy { Signal1<FlowBox, CPointer<GtkFlowBoxChild>, CFunction<(
                CPointer<in CPointed>?,
                CPointer<GtkFlowBoxChild>,
                COpaquePointer?
            ) -> Unit>>(widgetPtr!!, this, "child-activated",
                    staticCFunction(::FlowBox_onChildActivated_Handler)) }

    val onSelectAll: Signal<FlowBox, CFunction<(CPointer<in CPointed>?, COpaquePointer?) -> Unit>>
            by lazy { Signal<FlowBox, CFunction<(CPointer<in CPointed>?, COpaquePointer?) ->
            Unit>>(widgetPtr!!, this, "select-all", staticCFunction(::FlowBox_onSelectAll_Handler))
            }

    val onSelectedChildrenChanged: Signal<FlowBox, CFunction<(CPointer<in CPointed>?,
            COpaquePointer?) -> Unit>> by lazy { Signal<FlowBox, CFunction<(CPointer<in CPointed>?,
            COpaquePointer?) -> Unit>>(widgetPtr!!, this, "selected-children-changed",
            staticCFunction(::FlowBox_onSelectedChildrenChanged_Handler)) }

    val onToggleCursorChild: Signal<FlowBox, CFunction<(CPointer<in CPointed>?, COpaquePointer?) ->
            Unit>> by lazy { Signal<FlowBox, CFunction<(CPointer<in CPointed>?, COpaquePointer?) ->
            Unit>>(widgetPtr!!, this, "toggle-cursor-child",
            staticCFunction(::FlowBox_onToggleCursorChild_Handler)) }

    val onUnselectAll: Signal<FlowBox, CFunction<(CPointer<in CPointed>?, COpaquePointer?) -> Unit>>
            by lazy { Signal<FlowBox, CFunction<(CPointer<in CPointed>?, COpaquePointer?) ->
            Unit>>(widgetPtr!!, this, "unselect-all",
            staticCFunction(::FlowBox_onUnselectAll_Handler)) }

    /**
     * Returns whether children activate on single clicks.
     *
     * If @single is %TRUE, children will be activated when you click
     * on them, otherwise you need to double-click. */
    var activateOnSingleClick: Boolean
        get() = gtk_flow_box_get_activate_on_single_click(self) != 0
        set(value) {
            gtk_flow_box_set_activate_on_single_click(self, if (value) gtk_true() else gtk_false())
        }

    /**
     * Gets the horizontal spacing.
     *
     * Sets the horizontal space to add between children.
     * See the #GtkFlowBox:column-spacing property. */
    var columnSpacing: UInt
        get() = gtk_flow_box_get_column_spacing(self)
        set(value) {
            gtk_flow_box_set_column_spacing(self, value)
        }

    /**
     * Returns whether the box is homogeneous (all children are the
     * same size). See gtk_box_set_homogeneous().
     *
     * Sets the #GtkFlowBox:homogeneous property of @box, controlling
     * whether or not all children of @box are given equal space
     * in the box. */
    var homogeneous: Boolean
        get() = gtk_flow_box_get_homogeneous(self) != 0
        set(value) {
            gtk_flow_box_set_homogeneous(self, if (value) gtk_true() else gtk_false())
        }

    /**
     * Gets the maximum number of children per line.
     *
     * Sets the maximum number of children to request and
     * allocate space for in @box’s orientation.
     *
     * Setting the maximum number of children per line
     * limits the overall natural size request to be no more
     * than @n_children children long in the given orientation. */
    var maxChildrenPerLine: UInt
        get() = gtk_flow_box_get_max_children_per_line(self)
        set(value) {
            gtk_flow_box_set_max_children_per_line(self, value)
        }

    /**
     * Gets the minimum number of children per line.
     *
     * Sets the minimum number of children to line up
     * in @box’s orientation before flowing. */
    var minChildrenPerLine: UInt
        get() = gtk_flow_box_get_min_children_per_line(self)
        set(value) {
            gtk_flow_box_set_min_children_per_line(self, value)
        }

    /**
     * Gets the vertical spacing.
     *
     * Sets the vertical space to add between children.
     * See the #GtkFlowBox:row-spacing property. */
    var rowSpacing: UInt
        get() = gtk_flow_box_get_row_spacing(self)
        set(value) {
            gtk_flow_box_set_row_spacing(self, value)
        }

    val selectedChildren: CPointer<GList>
        get() = gtk_flow_box_get_selected_children(self)!!.reinterpret()

    /**
     * Gets the selection mode of @box.
     *
     * Sets how selection works in @box.
     * See #GtkSelectionMode for details. */
    var selectionMode: GtkSelectionMode
        get() = gtk_flow_box_get_selection_mode(self)
        set(value) {
            gtk_flow_box_set_selection_mode(self, value)
        }

    /**
     * Creates a GtkFlowBox. */
    constructor() : this(gtk_flow_box_new()?.reinterpret())

    /**
     * Gets the nth child in the @box.
     */
    fun getChildAtIndex(idx: Int): CPointer<GtkFlowBoxChild> = gtk_flow_box_get_child_at_index(self,
            idx)!!.reinterpret()

    /**
     * Gets the child in the (@x, @y) position.
     */
    fun getChildAtPos(x: Int, y: Int): CPointer<GtkFlowBoxChild> =
            gtk_flow_box_get_child_at_pos(self, x, y)!!.reinterpret()

    /**
     * Inserts the @widget into @box at @position.
     *
     * If a sort function is set, the widget will actually be inserted
     * at the calculated position and this function has the same effect
     * as gtk_container_add().
     *
     * If @position is -1, or larger than the total number of children
     * in the @box, then the @widget will be appended to the end.
     */
    fun insert(widget: CPointer<GtkWidget>, position: Int): Unit = gtk_flow_box_insert(self, widget,
            position)

    /**
     * Inserts the @widget into @box at @position.
     *
     * If a sort function is set, the widget will actually be inserted
     * at the calculated position and this function has the same effect
     * as gtk_container_add().
     *
     * If @position is -1, or larger than the total number of children
     * in the @box, then the @widget will be appended to the end.
     */
    fun insert(widget: Widget, position: Int): Unit = gtk_flow_box_insert(self,
            widget.widgetPtr?.reinterpret(), position)

    /**
     * Updates the filtering for all children.
     *
     * Call this function when the result of the filter
     * function on the @box is changed due ot an external
     * factor. For instance, this would be used if the
     * filter function just looked for a specific search
     * term, and the entry with the string has changed.
     */
    fun invalidateFilter(): Unit = gtk_flow_box_invalidate_filter(self)

    /**
     * Updates the sorting for all children.
     *
     * Call this when the result of the sort function on
     * @box is changed due to an external factor.
     */
    fun invalidateSort(): Unit = gtk_flow_box_invalidate_sort(self)

    /**
     * Select all children of @box, if the selection
     * mode allows it.
     */
    fun selectAll(): Unit = gtk_flow_box_select_all(self)

    /**
     * Selects a single child of @box, if the selection
     * mode allows it.
     */
    fun selectChild(child: CPointer<GtkFlowBoxChild>): Unit = gtk_flow_box_select_child(self, child)

    /**
     * Selects a single child of @box, if the selection
     * mode allows it.
     */
    fun selectChild(child: FlowBoxChild): Unit = gtk_flow_box_select_child(self,
            child.widgetPtr?.reinterpret())

    /**
     * Unselect all children of @box, if the selection
     * mode allows it.
     */
    fun unselectAll(): Unit = gtk_flow_box_unselect_all(self)

    /**
     * Unselects a single child of @box, if the selection
     * mode allows it.
     */
    fun unselectChild(child: CPointer<GtkFlowBoxChild>): Unit = gtk_flow_box_unselect_child(self,
            child)

    /**
     * Unselects a single child of @box, if the selection
     * mode allows it.
     */
    fun unselectChild(child: FlowBoxChild): Unit = gtk_flow_box_unselect_child(self,
            child.widgetPtr?.reinterpret())

    /**
     * Hooks up an adjustment to focus handling in @box.
     * The adjustment is also used for autoscrolling during
     * rubberband selection. See gtk_scrolled_window_get_hadjustment()
     * for a typical way of obtaining the adjustment, and
     * gtk_flow_box_set_vadjustment()for setting the vertical
     * adjustment.
     *
     * The adjustments have to be in pixel units and in the same
     * coordinate system as the allocation for immediate children
     * of the box.
     */
    fun setHadjustment(adjustment: CPointer<GtkAdjustment>): Unit =
            gtk_flow_box_set_hadjustment(self, adjustment)

    /**
     * Hooks up an adjustment to focus handling in @box.
     * The adjustment is also used for autoscrolling during
     * rubberband selection. See gtk_scrolled_window_get_vadjustment()
     * for a typical way of obtaining the adjustment, and
     * gtk_flow_box_set_hadjustment()for setting the horizontal
     * adjustment.
     *
     * The adjustments have to be in pixel units and in the same
     * coordinate system as the allocation for immediate children
     * of the box.
     */
    fun setVadjustment(adjustment: CPointer<GtkAdjustment>): Unit =
            gtk_flow_box_set_vadjustment(self, adjustment)
}

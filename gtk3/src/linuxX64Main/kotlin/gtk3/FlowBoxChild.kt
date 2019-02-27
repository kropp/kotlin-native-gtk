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
import libgtk3.GtkFlowBoxChild
import libgtk3.GtkWidget
import libgtk3.gtk_flow_box_child_changed
import libgtk3.gtk_flow_box_child_get_index
import libgtk3.gtk_flow_box_child_is_selected
import libgtk3.gtk_flow_box_child_new

inline fun Container.flowBoxChild(init: FlowBoxChild.() -> Unit = {}): FlowBoxChild =
        FlowBoxChild().apply { init(); this@flowBoxChild.add(this) }

private fun FlowBoxChild_onActivate_Handler(sender: CPointer<in CPointed>?, _data: COpaquePointer?)
        {
    _data?.asStableRef<FlowBoxChild>()?.get()?.onActivate?.emit()
}

/**
 * Gets the current index of the @child in its #GtkFlowBox container.
 */
@GtkDsl
open class FlowBoxChild internal constructor(override val widgetPtr: CPointer<GtkWidget>? = null) :
        Bin() {
    private val self: CPointer<GtkFlowBoxChild>?
        get() = widgetPtr!!.reinterpret()

    val flowBoxChild: CPointer<GtkFlowBoxChild>?
        get() = widgetPtr!!.reinterpret()

    val onActivate: Signal<FlowBoxChild, CFunction<(CPointer<in CPointed>?, COpaquePointer?) ->
            Unit>> by lazy { Signal<FlowBoxChild, CFunction<(CPointer<in CPointed>?,
            COpaquePointer?) -> Unit>>(widgetPtr!!, this, "activate",
            staticCFunction(::FlowBoxChild_onActivate_Handler)) }

    val index: Int
        get() = gtk_flow_box_child_get_index(self)

    /**
     * Creates a new #GtkFlowBoxChild, to be used as a child
     * of a #GtkFlowBox. */
    constructor() : this(gtk_flow_box_child_new()?.reinterpret())

    /**
     * Marks @child as changed, causing any state that depends on this
     * to be updated. This affects sorting and filtering.
     *
     * Note that calls to this method must be in sync with the data
     * used for the sorting and filtering functions. For instance, if
     * the list is mirroring some external data set, and *two* children
     * changed in the external data set when you call
     * gtk_flow_box_child_changed() on the first child, the sort function
     * must only read the new data for the first of the two changed
     * children, otherwise the resorting of the children will be wrong.
     *
     * This generally means that if you don’t fully control the data
     * model, you have to duplicate the data that affects the sorting
     * and filtering functions into the widgets themselves. Another
     * alternative is to call gtk_flow_box_invalidate_sort() on any
     * model change, but that is more expensive.
     */
    fun changed(): Unit = gtk_flow_box_child_changed(self)

    /**
     * Returns whether the @child is currently selected in its
     * #GtkFlowBox container.
     */
    fun isSelected(): Boolean = gtk_flow_box_child_is_selected(self) != 0
}

package gtk3

import kotlin.Boolean
import kotlin.Int
import kotlin.UInt
import kotlin.Unit
import kotlinx.cinterop.CPointer
import kotlinx.cinterop.reinterpret
import libgtk3.GtkBaselinePosition
import libgtk3.GtkBox
import libgtk3.GtkOrientation
import libgtk3.GtkPackType
import libgtk3.GtkWidget
import libgtk3.gtk_box_get_baseline_position
import libgtk3.gtk_box_get_center_widget
import libgtk3.gtk_box_get_homogeneous
import libgtk3.gtk_box_get_spacing
import libgtk3.gtk_box_new
import libgtk3.gtk_box_pack_end
import libgtk3.gtk_box_pack_start
import libgtk3.gtk_box_reorder_child
import libgtk3.gtk_box_set_baseline_position
import libgtk3.gtk_box_set_center_widget
import libgtk3.gtk_box_set_child_packing
import libgtk3.gtk_box_set_homogeneous
import libgtk3.gtk_box_set_spacing
import libgtk3.gtk_false
import libgtk3.gtk_true

inline fun Container.box(
    orientation: GtkOrientation,
    spacing: Int,
    init: Box.() -> Unit = {}
): Box = Box(orientation, spacing).apply { init(); this@box.add(this) }

/**
 * The GtkBox widget organizes child widgets into a rectangular area.
 *
 * The rectangular area of a GtkBox is organized into either a single row
 * or a single column of child widgets depending upon the orientation.
 * Thus, all children of a GtkBox are allocated one dimension in common,
 * which is the height of a row, or the width of a column.
 *
 * GtkBox uses a notion of packing. Packing refers
 * to adding widgets with reference to a particular position in a
 * #GtkContainer. For a GtkBox, there are two reference positions: the
 * start and the end of the box.
 * For a vertical #GtkBox, the start is defined as the top of the box and
 * the end is defined as the bottom. For a horizontal #GtkBox the start
 * is defined as the left side and the end is defined as the right side.
 *
 * Use repeated calls to gtk_box_pack_start() to pack widgets into a
 * GtkBox from start to end. Use gtk_box_pack_end() to add widgets from
 * end to start. You may intersperse these calls and add widgets from
 * both ends of the same GtkBox.
 *
 * Because GtkBox is a #GtkContainer, you may also use gtk_container_add()
 * to insert widgets into the box, and they will be packed with the default
 * values for expand and fill child properties. Use gtk_container_remove()
 * to remove widgets from the GtkBox.
 *
 * Use gtk_box_set_homogeneous() to specify whether or not all children
 * of the GtkBox are forced to get the same amount of space.
 *
 * Use gtk_box_set_spacing() to determine how much space will be
 * minimally placed between all children in the GtkBox. Note that
 * spacing is added between the children, while
 * padding added by gtk_box_pack_start() or gtk_box_pack_end() is added
 * on either side of the widget it belongs to.
 *
 * Use gtk_box_reorder_child() to move a GtkBox child to a different
 * place in the box.
 *
 * Use gtk_box_set_child_packing() to reset the expand,
 * fill and padding child properties.
 * Use gtk_box_query_child_packing() to query these fields.
 *
 * Note that a single-row or single-column #GtkGrid provides exactly
 * the same functionality as #GtkBox.
 *
 * # CSS nodes
 *
 * GtkBox uses a single CSS node with name box.
 *
 * In horizontal orientation, the nodes of the children are always arranged
 * from left to right. So :first-child will always select the leftmost child,
 * regardless of text direction.
 */
@GtkDsl
open class Box internal constructor(override val widgetPtr: CPointer<GtkWidget>? = null) :
        Container() {
    private val self: CPointer<GtkBox>?
        get() = widgetPtr!!.reinterpret()

    val box: CPointer<GtkBox>?
        get() = widgetPtr!!.reinterpret()

    /**
     * Gets the value set by gtk_box_set_baseline_position().
     *
     * Sets the baseline position of a box. This affects
     * only horizontal boxes with at least one baseline aligned
     * child. If there is more vertical space available than requested,
     * and the baseline is not allocated by the parent then
     * @position is used to allocate the baseline wrt the
     * extra space available. */
    var baselinePosition: GtkBaselinePosition
        get() = gtk_box_get_baseline_position(self)
        set(value) {
            gtk_box_set_baseline_position(self, value)
        }

    /**
     * Retrieves the center widget of the box.
     *
     * Sets a center widget; that is a child widget that will be
     * centered with respect to the full width of the box, even
     * if the children at either side take up different amounts
     * of space. */
    var centerWidget: CPointer<GtkWidget>
        get() = gtk_box_get_center_widget(self)!!.reinterpret()
        set(value) {
            gtk_box_set_center_widget(self, value?.reinterpret())
        }

    /**
     * Returns whether the box is homogeneous (all children are the
     * same size). See gtk_box_set_homogeneous().
     *
     * Sets the #GtkBox:homogeneous property of @box, controlling
     * whether or not all children of @box are given equal space
     * in the box. */
    var homogeneous: Boolean
        get() = gtk_box_get_homogeneous(self) != 0
        set(value) {
            gtk_box_set_homogeneous(self, if (value) gtk_true() else gtk_false())
        }

    /**
     * Gets the value set by gtk_box_set_spacing().
     *
     * Sets the #GtkBox:spacing property of @box, which is the
     * number of pixels to place between children of @box. */
    var spacing: Int
        get() = gtk_box_get_spacing(self)
        set(value) {
            gtk_box_set_spacing(self, value)
        }

    /**
     * Creates a new #GtkBox. */
    constructor(orientation: GtkOrientation, spacing: Int) : this(gtk_box_new(orientation,
            spacing)?.reinterpret())

    /**
     * Adds @child to @box, packed with reference to the end of @box.
     * The @child is packed after (away from end of) any other child
     * packed with reference to the end of @box.
     */
    fun packEnd(
        child: CPointer<GtkWidget>,
        expand: Boolean,
        fill: Boolean,
        padding: UInt
    ): Unit = gtk_box_pack_end(self, child, if (expand) gtk_true() else gtk_false(),
            if (fill) gtk_true() else gtk_false(), padding)

    /**
     * Adds @child to @box, packed with reference to the end of @box.
     * The @child is packed after (away from end of) any other child
     * packed with reference to the end of @box.
     */
    fun packEnd(
        child: Widget,
        expand: Boolean,
        fill: Boolean,
        padding: UInt
    ): Unit = gtk_box_pack_end(self, child.widgetPtr?.reinterpret(),
            if (expand) gtk_true() else gtk_false(), if (fill) gtk_true() else gtk_false(), padding)

    /**
     * Adds @child to @box, packed with reference to the start of @box.
     * The @child is packed after any other child packed with reference
     * to the start of @box.
     */
    fun packStart(
        child: CPointer<GtkWidget>,
        expand: Boolean,
        fill: Boolean,
        padding: UInt
    ): Unit = gtk_box_pack_start(self, child, if (expand) gtk_true() else gtk_false(),
            if (fill) gtk_true() else gtk_false(), padding)

    /**
     * Adds @child to @box, packed with reference to the start of @box.
     * The @child is packed after any other child packed with reference
     * to the start of @box.
     */
    fun packStart(
        child: Widget,
        expand: Boolean,
        fill: Boolean,
        padding: UInt
    ): Unit = gtk_box_pack_start(self, child.widgetPtr?.reinterpret(),
            if (expand) gtk_true() else gtk_false(), if (fill) gtk_true() else gtk_false(), padding)

    /**
     * Moves @child to a new @position in the list of @box children.
     * The list contains widgets packed #GTK_PACK_START
     * as well as widgets packed #GTK_PACK_END, in the order that these
     * widgets were added to @box.
     *
     * A widget’s position in the @box children list determines where
     * the widget is packed into @box.  A child widget at some position
     * in the list will be packed just after all other widgets of the
     * same packing type that appear earlier in the list.
     */
    fun reorderChild(child: CPointer<GtkWidget>, position: Int): Unit = gtk_box_reorder_child(self,
            child, position)

    /**
     * Moves @child to a new @position in the list of @box children.
     * The list contains widgets packed #GTK_PACK_START
     * as well as widgets packed #GTK_PACK_END, in the order that these
     * widgets were added to @box.
     *
     * A widget’s position in the @box children list determines where
     * the widget is packed into @box.  A child widget at some position
     * in the list will be packed just after all other widgets of the
     * same packing type that appear earlier in the list.
     */
    fun reorderChild(child: Widget, position: Int): Unit = gtk_box_reorder_child(self,
            child.widgetPtr?.reinterpret(), position)

    /**
     * Sets the way @child is packed into @box.
     */
    fun setChildPacking(
        child: CPointer<GtkWidget>,
        expand: Boolean,
        fill: Boolean,
        padding: UInt,
        pack_type: GtkPackType
    ): Unit = gtk_box_set_child_packing(self, child, if (expand) gtk_true() else gtk_false(),
            if (fill) gtk_true() else gtk_false(), padding, pack_type)

    /**
     * Sets the way @child is packed into @box.
     */
    fun setChildPacking(
        child: Widget,
        expand: Boolean,
        fill: Boolean,
        padding: UInt,
        pack_type: GtkPackType
    ): Unit = gtk_box_set_child_packing(self, child.widgetPtr?.reinterpret(),
            if (expand) gtk_true() else gtk_false(), if (fill) gtk_true() else gtk_false(), padding,
            pack_type)
}

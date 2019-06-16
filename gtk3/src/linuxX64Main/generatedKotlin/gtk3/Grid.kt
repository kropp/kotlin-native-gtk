package gtk3

import kotlin.Boolean
import kotlin.Int
import kotlin.UInt
import kotlin.Unit
import kotlinx.cinterop.CPointer
import kotlinx.cinterop.reinterpret
import libgtk3.GtkBaselinePosition
import libgtk3.GtkGrid
import libgtk3.GtkPositionType
import libgtk3.GtkWidget
import libgtk3.gtk_false
import libgtk3.gtk_grid_attach
import libgtk3.gtk_grid_attach_next_to
import libgtk3.gtk_grid_get_baseline_row
import libgtk3.gtk_grid_get_child_at
import libgtk3.gtk_grid_get_column_homogeneous
import libgtk3.gtk_grid_get_column_spacing
import libgtk3.gtk_grid_get_row_baseline_position
import libgtk3.gtk_grid_get_row_homogeneous
import libgtk3.gtk_grid_get_row_spacing
import libgtk3.gtk_grid_insert_column
import libgtk3.gtk_grid_insert_next_to
import libgtk3.gtk_grid_insert_row
import libgtk3.gtk_grid_new
import libgtk3.gtk_grid_remove_column
import libgtk3.gtk_grid_remove_row
import libgtk3.gtk_grid_set_baseline_row
import libgtk3.gtk_grid_set_column_homogeneous
import libgtk3.gtk_grid_set_column_spacing
import libgtk3.gtk_grid_set_row_baseline_position
import libgtk3.gtk_grid_set_row_homogeneous
import libgtk3.gtk_grid_set_row_spacing
import libgtk3.gtk_true

inline fun Container.grid(init: Grid.() -> Unit = {}): Grid = Grid().apply { init();
        this@grid.add(this) }

/**
 * GtkGrid is a container which arranges its child widgets in
 * rows and columns. It is a very similar to #GtkTable and #GtkBox,
 * but it consistently uses #GtkWidget’s #GtkWidget:margin and #GtkWidget:expand
 * properties instead of custom child properties, and it fully supports
 * [height-for-width geometry management][geometry-management].
 *
 * Children are added using gtk_grid_attach(). They can span multiple
 * rows or columns. It is also possible to add a child next to an
 * existing child, using gtk_grid_attach_next_to(). The behaviour of
 * GtkGrid when several children occupy the same grid cell is undefined.
 *
 * GtkGrid can be used like a #GtkBox by just using gtk_container_add(),
 * which will place children next to each other in the direction determined
 * by the #GtkOrientable:orientation property.
 *
 * # CSS nodes
 *
 * GtkGrid uses a single CSS node with name grid.
 */
@GtkDsl
open class Grid internal constructor(override val widgetPtr: CPointer<GtkWidget>? = null) :
        Container() {
    private val self: CPointer<GtkGrid>?
        get() = widgetPtr!!.reinterpret()

    val grid: CPointer<GtkGrid>?
        get() = widgetPtr!!.reinterpret()

    /**
     * Returns which row defines the global baseline of @grid.
     *
     * Sets which row defines the global baseline for the entire grid.
     * Each row in the grid can have its own local baseline, but only
     * one of those is global, meaning it will be the baseline in the
     * parent of the @grid. */
    var baselineRow: Int
        get() = gtk_grid_get_baseline_row(self)
        set(value) {
            gtk_grid_set_baseline_row(self, value)
        }

    /**
     * Returns whether all columns of @grid have the same width.
     *
     * Sets whether all columns of @grid will have the same width. */
    var columnHomogeneous: Boolean
        get() = gtk_grid_get_column_homogeneous(self) != 0
        set(value) {
            gtk_grid_set_column_homogeneous(self, if (value) gtk_true() else gtk_false())
        }

    /**
     * Returns the amount of space between the columns of @grid.
     *
     * Sets the amount of space between columns of @grid. */
    var columnSpacing: UInt
        get() = gtk_grid_get_column_spacing(self)
        set(value) {
            gtk_grid_set_column_spacing(self, value)
        }

    /**
     * Returns whether all rows of @grid have the same height.
     *
     * Sets whether all rows of @grid will have the same height. */
    var rowHomogeneous: Boolean
        get() = gtk_grid_get_row_homogeneous(self) != 0
        set(value) {
            gtk_grid_set_row_homogeneous(self, if (value) gtk_true() else gtk_false())
        }

    /**
     * Returns the amount of space between the rows of @grid.
     *
     * Sets the amount of space between rows of @grid. */
    var rowSpacing: UInt
        get() = gtk_grid_get_row_spacing(self)
        set(value) {
            gtk_grid_set_row_spacing(self, value)
        }

    /**
     * Creates a new grid widget. */
    constructor() : this(gtk_grid_new()?.reinterpret())

    /**
     * Adds a widget to the grid.
     *
     * The position of @child is determined by @left and @top. The
     * number of “cells” that @child will occupy is determined by
     * @width and @height.
     */
    fun attach(
        child: CPointer<GtkWidget>,
        left: Int,
        top: Int,
        width: Int,
        height: Int
    ): Unit = gtk_grid_attach(self, child, left, top, width, height)

    /**
     * Adds a widget to the grid.
     *
     * The position of @child is determined by @left and @top. The
     * number of “cells” that @child will occupy is determined by
     * @width and @height.
     */
    fun attach(
        child: Widget,
        left: Int,
        top: Int,
        width: Int,
        height: Int
    ): Unit = gtk_grid_attach(self, child.widgetPtr?.reinterpret(), left, top, width, height)

    /**
     * Adds a widget to the grid.
     *
     * The widget is placed next to @sibling, on the side determined by
     * @side. When @sibling is %NULL, the widget is placed in row (for
     * left or right placement) or column 0 (for top or bottom placement),
     * at the end indicated by @side.
     *
     * Attaching widgets labeled [1], [2], [3] with @sibling == %NULL and
     * @side == %GTK_POS_LEFT yields a layout of [3][2][1].
     */
    fun attachNextTo(
        child: CPointer<GtkWidget>,
        sibling: CPointer<GtkWidget>,
        side: GtkPositionType,
        width: Int,
        height: Int
    ): Unit = gtk_grid_attach_next_to(self, child, sibling, side, width, height)

    /**
     * Adds a widget to the grid.
     *
     * The widget is placed next to @sibling, on the side determined by
     * @side. When @sibling is %NULL, the widget is placed in row (for
     * left or right placement) or column 0 (for top or bottom placement),
     * at the end indicated by @side.
     *
     * Attaching widgets labeled [1], [2], [3] with @sibling == %NULL and
     * @side == %GTK_POS_LEFT yields a layout of [3][2][1].
     */
    fun attachNextTo(
        child: Widget,
        sibling: Widget,
        side: GtkPositionType,
        width: Int,
        height: Int
    ): Unit = gtk_grid_attach_next_to(self, child.widgetPtr?.reinterpret(),
            sibling.widgetPtr?.reinterpret(), side, width, height)

    /**
     * Gets the child of @grid whose area covers the grid
     * cell whose upper left corner is at @left, @top.
     */
    fun getChildAt(left: Int, top: Int): CPointer<GtkWidget> = gtk_grid_get_child_at(self, left,
            top)!!.reinterpret()

    /**
     * Returns the baseline position of @row as set
     * by gtk_grid_set_row_baseline_position() or the default value
     * %GTK_BASELINE_POSITION_CENTER.
     */
    fun getRowBaselinePosition(row: Int): GtkBaselinePosition =
            gtk_grid_get_row_baseline_position(self, row)

    /**
     * Inserts a column at the specified position.
     *
     * Children which are attached at or to the right of this position
     * are moved one column to the right. Children which span across this
     * position are grown to span the new column.
     */
    fun insertColumn(position: Int): Unit = gtk_grid_insert_column(self, position)

    /**
     * Inserts a row or column at the specified position.
     *
     * The new row or column is placed next to @sibling, on the side
     * determined by @side. If @side is %GTK_POS_TOP or %GTK_POS_BOTTOM,
     * a row is inserted. If @side is %GTK_POS_LEFT of %GTK_POS_RIGHT,
     * a column is inserted.
     */
    fun insertNextTo(sibling: CPointer<GtkWidget>, side: GtkPositionType): Unit =
            gtk_grid_insert_next_to(self, sibling, side)

    /**
     * Inserts a row or column at the specified position.
     *
     * The new row or column is placed next to @sibling, on the side
     * determined by @side. If @side is %GTK_POS_TOP or %GTK_POS_BOTTOM,
     * a row is inserted. If @side is %GTK_POS_LEFT of %GTK_POS_RIGHT,
     * a column is inserted.
     */
    fun insertNextTo(sibling: Widget, side: GtkPositionType): Unit = gtk_grid_insert_next_to(self,
            sibling.widgetPtr?.reinterpret(), side)

    /**
     * Inserts a row at the specified position.
     *
     * Children which are attached at or below this position
     * are moved one row down. Children which span across this
     * position are grown to span the new row.
     */
    fun insertRow(position: Int): Unit = gtk_grid_insert_row(self, position)

    /**
     * Removes a column from the grid.
     *
     * Children that are placed in this column are removed,
     * spanning children that overlap this column have their
     * width reduced by one, and children after the column
     * are moved to the left.
     */
    fun removeColumn(position: Int): Unit = gtk_grid_remove_column(self, position)

    /**
     * Removes a row from the grid.
     *
     * Children that are placed in this row are removed,
     * spanning children that overlap this row have their
     * height reduced by one, and children below the row
     * are moved up.
     */
    fun removeRow(position: Int): Unit = gtk_grid_remove_row(self, position)

    /**
     * Sets how the baseline should be positioned on @row of the
     * grid, in case that row is assigned more space than is requested.
     */
    fun setRowBaselinePosition(row: Int, pos: GtkBaselinePosition): Unit =
            gtk_grid_set_row_baseline_position(self, row, pos)
}

package gtk3

import kotlin.Boolean
import kotlin.Unit
import kotlinx.cinterop.CPointer
import kotlinx.cinterop.reinterpret
import libgtk3.GdkRGBA
import libgtk3.GtkCellView
import libgtk3.GtkTreeModel
import libgtk3.GtkTreePath
import libgtk3.GtkWidget
import libgtk3.gtk_cell_view_get_displayed_row
import libgtk3.gtk_cell_view_get_draw_sensitive
import libgtk3.gtk_cell_view_get_fit_model
import libgtk3.gtk_cell_view_get_model
import libgtk3.gtk_cell_view_new
import libgtk3.gtk_cell_view_set_background_rgba
import libgtk3.gtk_cell_view_set_displayed_row
import libgtk3.gtk_cell_view_set_draw_sensitive
import libgtk3.gtk_cell_view_set_fit_model
import libgtk3.gtk_cell_view_set_model
import libgtk3.gtk_false
import libgtk3.gtk_true

inline fun Container.cellView(init: CellView.() -> Unit = {}): CellView = CellView().apply { init();
        this@cellView.add(this) }

/**
 * A #GtkCellView displays a single row of a #GtkTreeModel using a #GtkCellArea
 * and #GtkCellAreaContext. A #GtkCellAreaContext can be provided to the
 * #GtkCellView at construction time in order to keep the cellview in context
 * of a group of cell views, this ensures that the renderers displayed will
 * be properly aligned with eachother (like the aligned cells in the menus
 * of #GtkComboBox).
 *
 * #GtkCellView is #GtkOrientable in order to decide in which orientation
 * the underlying #GtkCellAreaContext should be allocated. Taking the #GtkComboBox
 * menu as an example, cellviews should be oriented horizontally if the menus are
 * listed top-to-bottom and thus all share the same width but may have separate
 * individual heights (left-to-right menus should be allocated vertically since
 * they all share the same height but may have variable widths).
 *
 * # CSS nodes
 *
 * GtkCellView has a single CSS node with name cellview.
 */
@GtkDsl
open class CellView internal constructor(override val widgetPtr: CPointer<GtkWidget>? = null) :
        Widget() {
    private val self: CPointer<GtkCellView>?
        get() = widgetPtr!!.reinterpret()

    val cellView: CPointer<GtkCellView>?
        get() = widgetPtr!!.reinterpret()

    /**
     * Returns a #GtkTreePath referring to the currently
     * displayed row. If no row is currently displayed,
     * %NULL is returned.
     *
     * Sets the row of the model that is currently displayed
     * by the #GtkCellView. If the path is unset, then the
     * contents of the cellview “stick” at their last value;
     * this is not normally a desired result, but may be
     * a needed intermediate state if say, the model for
     * the #GtkCellView becomes temporarily empty. */
    var displayedRow: CPointer<GtkTreePath>
        get() = gtk_cell_view_get_displayed_row(self)!!.reinterpret()
        set(value) {
            gtk_cell_view_set_displayed_row(self, value?.reinterpret())
        }

    /**
     * Gets whether @cell_view is configured to draw all of its
     * cells in a sensitive state.
     *
     * Sets whether @cell_view should draw all of its
     * cells in a sensitive state, this is used by #GtkComboBox menus
     * to ensure that rows with insensitive cells that contain
     * children appear sensitive in the parent menu item. */
    var drawSensitive: Boolean
        get() = gtk_cell_view_get_draw_sensitive(self) != 0
        set(value) {
            gtk_cell_view_set_draw_sensitive(self, if (value) gtk_true() else gtk_false())
        }

    /**
     * Gets whether @cell_view is configured to request space
     * to fit the entire #GtkTreeModel.
     *
     * Sets whether @cell_view should request space to fit the entire #GtkTreeModel.
     *
     * This is used by #GtkComboBox to ensure that the cell view displayed on
     * the combo box’s button always gets enough space and does not resize
     * when selection changes. */
    var fitModel: Boolean
        get() = gtk_cell_view_get_fit_model(self) != 0
        set(value) {
            gtk_cell_view_set_fit_model(self, if (value) gtk_true() else gtk_false())
        }

    /**
     * Returns the model for @cell_view. If no model is used %NULL is
     * returned.
     *
     * Sets the model for @cell_view.  If @cell_view already has a model
     * set, it will remove it before setting the new model.  If @model is
     * %NULL, then it will unset the old model. */
    var model: CPointer<GtkTreeModel>
        get() = gtk_cell_view_get_model(self)!!.reinterpret()
        set(value) {
            gtk_cell_view_set_model(self, value?.reinterpret())
        }

    /**
     * Creates a new #GtkCellView widget. */
    constructor() : this(gtk_cell_view_new()?.reinterpret())

    /**
     * Sets the background color of @cell_view.
     */
    fun setBackgroundRgba(rgba: CPointer<GdkRGBA>): Unit = gtk_cell_view_set_background_rgba(self,
            rgba)
}

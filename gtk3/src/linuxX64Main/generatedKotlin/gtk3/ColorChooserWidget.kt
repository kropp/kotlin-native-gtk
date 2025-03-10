package gtk3

import kotlin.Unit
import kotlinx.cinterop.CPointer
import kotlinx.cinterop.reinterpret
import libgtk3.GtkColorChooserWidget
import libgtk3.GtkWidget
import libgtk3.gtk_color_chooser_widget_new

inline fun Container.colorChooserWidget(init: ColorChooserWidget.() -> Unit = {}):
        ColorChooserWidget = ColorChooserWidget().apply { init(); this@colorChooserWidget.add(this)
        }

/**
 * The #GtkColorChooserWidget widget lets the user select a
 * color. By default, the chooser presents a predefined palette
 * of colors, plus a small number of settable custom colors.
 * It is also possible to select a different color with the
 * single-color editor. To enter the single-color editing mode,
 * use the context menu of any color of the palette, or use the
 * '+' button to add a new custom color.
 *
 * The chooser automatically remembers the last selection, as well
 * as custom colors.
 *
 * To change the initially selected color, use gtk_color_chooser_set_rgba().
 * To get the selected color use gtk_color_chooser_get_rgba().
 *
 * The #GtkColorChooserWidget is used in the #GtkColorChooserDialog
 * to provide a dialog for selecting colors.
 *
 * # CSS names
 *
 * GtkColorChooserWidget has a single CSS node with name colorchooser.
 */
@GtkDsl
open class ColorChooserWidget internal constructor(override val widgetPtr: CPointer<GtkWidget>? =
        null) : Box() {
    private val self: CPointer<GtkColorChooserWidget>?
        get() = widgetPtr!!.reinterpret()

    val colorChooserWidget: CPointer<GtkColorChooserWidget>?
        get() = widgetPtr!!.reinterpret()

    /**
     * Creates a new #GtkColorChooserWidget. */
    constructor() : this(gtk_color_chooser_widget_new()?.reinterpret())
}

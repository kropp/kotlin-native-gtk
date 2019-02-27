package gtk3

import kotlin.Unit
import kotlinx.cinterop.CPointer
import kotlinx.cinterop.reinterpret
import libgtk3.GtkFontChooserWidget
import libgtk3.GtkWidget
import libgtk3.gtk_font_chooser_widget_new

inline fun Container.fontChooserWidget(init: FontChooserWidget.() -> Unit = {}): FontChooserWidget =
        FontChooserWidget().apply { init(); this@fontChooserWidget.add(this) }

/**
 * The #GtkFontChooserWidget widget lists the available fonts,
 * styles and sizes, allowing the user to select a font. It is
 * used in the #GtkFontChooserDialog widget to provide a
 * dialog box for selecting fonts.
 *
 * To set the font which is initially selected, use
 * gtk_font_chooser_set_font() or gtk_font_chooser_set_font_desc().
 *
 * To get the selected font use gtk_font_chooser_get_font() or
 * gtk_font_chooser_get_font_desc().
 *
 * To change the text which is shown in the preview area, use
 * gtk_font_chooser_set_preview_text().
 *
 * # CSS nodes
 *
 * GtkFontChooserWidget has a single CSS node with name fontchooser.
 */
@GtkDsl
open class FontChooserWidget internal constructor(override val widgetPtr: CPointer<GtkWidget>? =
        null) : Box() {
    private val self: CPointer<GtkFontChooserWidget>?
        get() = widgetPtr!!.reinterpret()

    val fontChooserWidget: CPointer<GtkFontChooserWidget>?
        get() = widgetPtr!!.reinterpret()

    /**
     * Creates a new #GtkFontChooserWidget. */
    constructor() : this(gtk_font_chooser_widget_new()?.reinterpret())
}

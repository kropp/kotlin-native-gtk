package gtk3

import kotlin.String
import kotlin.Unit
import kotlinx.cinterop.CPointer
import kotlinx.cinterop.reinterpret
import libgtk3.GtkFontChooserDialog
import libgtk3.GtkWidget
import libgtk3.GtkWindow
import libgtk3.gtk_font_chooser_dialog_new

inline fun Container.fontChooserDialog(
    title: String,
    parent: CPointer<GtkWindow>,
    init: FontChooserDialog.() -> Unit = {}
): FontChooserDialog = FontChooserDialog(title, parent).apply { init();
        this@fontChooserDialog.add(this) }

/**
 * The #GtkFontChooserDialog widget is a dialog for selecting a font.
 * It implements the #GtkFontChooser interface.
 *
 * # GtkFontChooserDialog as GtkBuildable
 *
 * The GtkFontChooserDialog implementation of the #GtkBuildable
 * interface exposes the buttons with the names “select_button”
 * and “cancel_button”.
 */
@GtkDsl
open class FontChooserDialog internal constructor(override val widgetPtr: CPointer<GtkWidget>? =
        null) : Dialog() {
    private val self: CPointer<GtkFontChooserDialog>?
        get() = widgetPtr!!.reinterpret()

    val fontChooserDialog: CPointer<GtkFontChooserDialog>?
        get() = widgetPtr!!.reinterpret()

    /**
     * Creates a new #GtkFontChooserDialog. */
    constructor(title: String, parent: CPointer<GtkWindow>) :
            this(gtk_font_chooser_dialog_new(title, parent?.reinterpret())?.reinterpret())
}

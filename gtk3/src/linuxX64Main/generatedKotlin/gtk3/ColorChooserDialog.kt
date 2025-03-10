package gtk3

import kotlin.String
import kotlin.Unit
import kotlinx.cinterop.CPointer
import kotlinx.cinterop.reinterpret
import libgtk3.GtkColorChooserDialog
import libgtk3.GtkWidget
import libgtk3.GtkWindow
import libgtk3.gtk_color_chooser_dialog_new

inline fun Container.colorChooserDialog(
    title: String,
    parent: CPointer<GtkWindow>,
    init: ColorChooserDialog.() -> Unit = {}
): ColorChooserDialog = ColorChooserDialog(title, parent).apply { init();
        this@colorChooserDialog.add(this) }

/**
 * The #GtkColorChooserDialog widget is a dialog for choosing
 * a color. It implements the #GtkColorChooser interface.
 */
@GtkDsl
open class ColorChooserDialog internal constructor(override val widgetPtr: CPointer<GtkWidget>? =
        null) : Dialog() {
    private val self: CPointer<GtkColorChooserDialog>?
        get() = widgetPtr!!.reinterpret()

    val colorChooserDialog: CPointer<GtkColorChooserDialog>?
        get() = widgetPtr!!.reinterpret()

    /**
     * Creates a new #GtkColorChooserDialog. */
    constructor(title: String, parent: CPointer<GtkWindow>) :
            this(gtk_color_chooser_dialog_new(title, parent?.reinterpret())?.reinterpret())
}

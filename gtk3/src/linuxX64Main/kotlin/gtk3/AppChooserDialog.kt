package gtk3

import kotlin.String
import kotlin.Unit
import kotlinx.cinterop.CPointer
import kotlinx.cinterop.reinterpret
import kotlinx.cinterop.toKString
import libgtk3.GFile
import libgtk3.GtkAppChooserDialog
import libgtk3.GtkDialogFlags
import libgtk3.GtkWidget
import libgtk3.GtkWindow
import libgtk3.gtk_app_chooser_dialog_get_heading
import libgtk3.gtk_app_chooser_dialog_get_widget
import libgtk3.gtk_app_chooser_dialog_new
import libgtk3.gtk_app_chooser_dialog_set_heading

inline fun Container.appChooserDialog(
    parent: CPointer<GtkWindow>,
    flags: GtkDialogFlags,
    file: CPointer<GFile>,
    init: AppChooserDialog.() -> Unit = {}
): AppChooserDialog = AppChooserDialog(parent, flags, file).apply { init();
        this@appChooserDialog.add(this) }

/**
 * #GtkAppChooserDialog shows a #GtkAppChooserWidget inside a #GtkDialog.
 *
 * Note that #GtkAppChooserDialog does not have any interesting methods
 * of its own. Instead, you should get the embedded #GtkAppChooserWidget
 * using gtk_app_chooser_dialog_get_widget() and call its methods if
 * the generic #GtkAppChooser interface is not sufficient for your needs.
 *
 * To set the heading that is shown above the #GtkAppChooserWidget,
 * use gtk_app_chooser_dialog_set_heading().Returns the #GtkAppChooserWidget of this dialog.
 */
@GtkDsl
open class AppChooserDialog internal constructor(override val widgetPtr: CPointer<GtkWidget>? =
        null) : Dialog() {
    private val self: CPointer<GtkAppChooserDialog>?
        get() = widgetPtr!!.reinterpret()

    val appChooserDialog: CPointer<GtkAppChooserDialog>?
        get() = widgetPtr!!.reinterpret()

    /**
     * Returns the text to display at the top of the dialog.
     *
     * Sets the text to display at the top of the dialog.
     * If the heading is not set, the dialog displays a default text. */
    var heading: String
        get() = gtk_app_chooser_dialog_get_heading(self)?.toKString() ?: ""
        set(value) {
            gtk_app_chooser_dialog_set_heading(self, value)
        }

    val widget: CPointer<GtkWidget>
        get() = gtk_app_chooser_dialog_get_widget(self)!!.reinterpret()

    /**
     * Creates a new #GtkAppChooserDialog for the provided #GFile,
     * to allow the user to select an application for it. */
    constructor(
        parent: CPointer<GtkWindow>,
        flags: GtkDialogFlags,
        file: CPointer<GFile>
    ) : this(gtk_app_chooser_dialog_new(parent?.reinterpret(), flags,
            file?.reinterpret())?.reinterpret())
}

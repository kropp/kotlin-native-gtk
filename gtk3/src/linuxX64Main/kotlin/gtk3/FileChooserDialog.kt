package gtk3

import kotlin.String
import kotlin.Unit
import kotlinx.cinterop.CPointer
import kotlinx.cinterop.reinterpret
import libgtk3.GtkFileChooserAction
import libgtk3.GtkFileChooserDialog
import libgtk3.GtkWidget
import libgtk3.GtkWindow
import libgtk3.gtk_file_chooser_dialog_new

inline fun Container.fileChooserDialog(
    title: String,
    parent: CPointer<GtkWindow>,
    action: GtkFileChooserAction,
    first_button_text: String,
    init: FileChooserDialog.() -> Unit = {}
): FileChooserDialog = FileChooserDialog(title, parent, action, first_button_text).apply { init();
        this@fileChooserDialog.add(this) }

/**
 * #GtkFileChooserDialog is a dialog box suitable for use with
 * “File/Open” or “File/Save as” commands.  This widget works by
 * putting a #GtkFileChooserWidget inside a #GtkDialog.  It exposes
 * the #GtkFileChooser interface, so you can use all of the
 * #GtkFileChooser functions on the file chooser dialog as well as
 * those for #GtkDialog.
 *
 * Note that #GtkFileChooserDialog does not have any methods of its
 * own.  Instead, you should use the functions that work on a
 * #GtkFileChooser.
 *
 * If you want to integrate well with the platform you should use the
 * #GtkFileChooserNative API, which will use a platform-specific
 * dialog if available and fall back to GtkFileChooserDialog
 * otherwise.
 *
 * ## Typical usage ## {#gtkfilechooser-typical-usage}
 *
 * In the simplest of cases, you can the following code to use
 * #GtkFileChooserDialog to select a file for opening:
 *
 * |[
 * GtkWidget *dialog;
 * GtkFileChooserAction action = GTK_FILE_CHOOSER_ACTION_OPEN;
 * gint res;
 *
 * dialog = gtk_file_chooser_dialog_new ("Open File",
 *                                       parent_window,
 *                                       action,
 *                                       _("_Cancel"),
 *                                       GTK_RESPONSE_CANCEL,
 *                                       _("_Open"),
 *                                       GTK_RESPONSE_ACCEPT,
 *                                       NULL);
 *
 * res = gtk_dialog_run (GTK_DIALOG (dialog));
 * if (res == GTK_RESPONSE_ACCEPT)
 *   {
 *     char *filename;
 *     GtkFileChooser *chooser = GTK_FILE_CHOOSER (dialog);
 *     filename = gtk_file_chooser_get_filename (chooser);
 *     open_file (filename);
 *     g_free (filename);
 *   }
 *
 * gtk_widget_destroy (dialog);
 * ]|
 *
 * To use a dialog for saving, you can use this:
 *
 * |[
 * GtkWidget *dialog;
 * GtkFileChooser *chooser;
 * GtkFileChooserAction action = GTK_FILE_CHOOSER_ACTION_SAVE;
 * gint res;
 *
 * dialog = gtk_file_chooser_dialog_new ("Save File",
 *                                       parent_window,
 *                                       action,
 *                                       _("_Cancel"),
 *                                       GTK_RESPONSE_CANCEL,
 *                                       _("_Save"),
 *                                       GTK_RESPONSE_ACCEPT,
 *                                       NULL);
 * chooser = GTK_FILE_CHOOSER (dialog);
 *
 * gtk_file_chooser_set_do_overwrite_confirmation (chooser, TRUE);
 *
 * if (user_edited_a_new_document)
 *   gtk_file_chooser_set_current_name (chooser,
 *                                      _("Untitled document"));
 * else
 *   gtk_file_chooser_set_filename (chooser,
 *                                  existing_filename);
 *
 * res = gtk_dialog_run (GTK_DIALOG (dialog));
 * if (res == GTK_RESPONSE_ACCEPT)
 *   {
 *     char *filename;
 *
 *     filename = gtk_file_chooser_get_filename (chooser);
 *     save_to_file (filename);
 *     g_free (filename);
 *   }
 *
 * gtk_widget_destroy (dialog);
 * ]|
 *
 * ## Setting up a file chooser dialog ## {#gtkfilechooserdialog-setting-up}
 *
 * There are various cases in which you may need to use a #GtkFileChooserDialog:
 *
 * - To select a file for opening. Use #GTK_FILE_CHOOSER_ACTION_OPEN.
 *
 * - To save a file for the first time. Use #GTK_FILE_CHOOSER_ACTION_SAVE,
 *   and suggest a name such as “Untitled” with gtk_file_chooser_set_current_name().
 *
 * - To save a file under a different name. Use #GTK_FILE_CHOOSER_ACTION_SAVE,
 *   and set the existing filename with gtk_file_chooser_set_filename().
 *
 * - To choose a folder instead of a file. Use #GTK_FILE_CHOOSER_ACTION_SELECT_FOLDER.
 *
 * Note that old versions of the file chooser’s documentation suggested
 * using gtk_file_chooser_set_current_folder() in various
 * situations, with the intention of letting the application
 * suggest a reasonable default folder.  This is no longer
 * considered to be a good policy, as now the file chooser is
 * able to make good suggestions on its own.  In general, you
 * should only cause the file chooser to show a specific folder
 * when it is appropriate to use gtk_file_chooser_set_filename(),
 * i.e. when you are doing a Save As command and you already
 * have a file saved somewhere.
 *
 * ## Response Codes ## {#gtkfilechooserdialog-responses}
 *
 * #GtkFileChooserDialog inherits from #GtkDialog, so buttons that
 * go in its action area have response codes such as
 * #GTK_RESPONSE_ACCEPT and #GTK_RESPONSE_CANCEL.  For example, you
 * could call gtk_file_chooser_dialog_new() as follows:
 *
 * |[
 * GtkWidget *dialog;
 * GtkFileChooserAction action = GTK_FILE_CHOOSER_ACTION_OPEN;
 *
 * dialog = gtk_file_chooser_dialog_new ("Open File",
 *                                       parent_window,
 *                                       action,
 *                                       _("_Cancel"),
 *                                       GTK_RESPONSE_CANCEL,
 *                                       _("_Open"),
 *                                       GTK_RESPONSE_ACCEPT,
 *                                       NULL);
 * ]|
 *
 * This will create buttons for “Cancel” and “Open” that use stock
 * response identifiers from #GtkResponseType.  For most dialog
 * boxes you can use your own custom response codes rather than the
 * ones in #GtkResponseType, but #GtkFileChooserDialog assumes that
 * its “accept”-type action, e.g. an “Open” or “Save” button,
 * will have one of the following response codes:
 *
 * - #GTK_RESPONSE_ACCEPT
 * - #GTK_RESPONSE_OK
 * - #GTK_RESPONSE_YES
 * - #GTK_RESPONSE_APPLY
 *
 * This is because #GtkFileChooserDialog must intercept responses
 * and switch to folders if appropriate, rather than letting the
 * dialog terminate — the implementation uses these known
 * response codes to know which responses can be blocked if
 * appropriate.
 *
 * To summarize, make sure you use a
 * [stock response code][gtkfilechooserdialog-responses]
 * when you use #GtkFileChooserDialog to ensure proper operation.
 */
@GtkDsl
open class FileChooserDialog internal constructor(override val widgetPtr: CPointer<GtkWidget>? =
        null) : Dialog() {
    private val self: CPointer<GtkFileChooserDialog>?
        get() = widgetPtr!!.reinterpret()

    val fileChooserDialog: CPointer<GtkFileChooserDialog>?
        get() = widgetPtr!!.reinterpret()

    /**
     * Creates a new #GtkFileChooserDialog.  This function is analogous to
     * gtk_dialog_new_with_buttons(). */
    constructor(
        title: String,
        parent: CPointer<GtkWindow>,
        action: GtkFileChooserAction,
        first_button_text: String
    ) : this(gtk_file_chooser_dialog_new(title, parent?.reinterpret(), action,
            first_button_text)?.reinterpret())
}

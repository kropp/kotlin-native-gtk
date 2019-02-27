package gtk3

import kotlin.String
import kotlin.Unit
import kotlinx.cinterop.CPointer
import kotlinx.cinterop.reinterpret
import libgtk3.GtkRecentChooserDialog
import libgtk3.GtkWidget
import libgtk3.GtkWindow
import libgtk3.gtk_recent_chooser_dialog_new

inline fun Container.recentChooserDialog(
    title: String,
    parent: CPointer<GtkWindow>,
    first_button_text: String,
    init: RecentChooserDialog.() -> Unit = {}
): RecentChooserDialog = RecentChooserDialog(title, parent, first_button_text).apply { init();
        this@recentChooserDialog.add(this) }

/**
 * #GtkRecentChooserDialog is a dialog box suitable for displaying the recently
 * used documents.  This widgets works by putting a #GtkRecentChooserWidget inside
 * a #GtkDialog.  It exposes the #GtkRecentChooserIface interface, so you can use
 * all the #GtkRecentChooser functions on the recent chooser dialog as well as
 * those for #GtkDialog.
 *
 * Note that #GtkRecentChooserDialog does not have any methods of its own.
 * Instead, you should use the functions that work on a #GtkRecentChooser.
 *
 * ## Typical usage ## {#gtkrecentchooser-typical-usage}
 *
 * In the simplest of cases, you can use the following code to use
 * a #GtkRecentChooserDialog to select a recently used file:
 *
 * |[<!-- language="C" -->
 * GtkWidget *dialog;
 * gint res;
 *
 * dialog = gtk_recent_chooser_dialog_new ("Recent Documents",
 *                                         parent_window,
 *                                         _("_Cancel"),
 *                                         GTK_RESPONSE_CANCEL,
 *                                         _("_Open"),
 *                                         GTK_RESPONSE_ACCEPT,
 *                                         NULL);
 *
 * res = gtk_dialog_run (GTK_DIALOG (dialog));
 * if (res == GTK_RESPONSE_ACCEPT)
 *   {
 *     GtkRecentInfo *info;
 *     GtkRecentChooser *chooser = GTK_RECENT_CHOOSER (dialog);
 *
 *     info = gtk_recent_chooser_get_current_item (chooser);
 *     open_file (gtk_recent_info_get_uri (info));
 *     gtk_recent_info_unref (info);
 *   }
 *
 * gtk_widget_destroy (dialog);
 * ]|
 *
 * Recently used files are supported since GTK+ 2.10.
 */
@GtkDsl
open class RecentChooserDialog internal constructor(override val widgetPtr: CPointer<GtkWidget>? =
        null) : Dialog() {
    private val self: CPointer<GtkRecentChooserDialog>?
        get() = widgetPtr!!.reinterpret()

    val recentChooserDialog: CPointer<GtkRecentChooserDialog>?
        get() = widgetPtr!!.reinterpret()

    /**
     * Creates a new #GtkRecentChooserDialog.  This function is analogous to
     * gtk_dialog_new_with_buttons(). */
    constructor(
        title: String,
        parent: CPointer<GtkWindow>,
        first_button_text: String
    ) : this(gtk_recent_chooser_dialog_new(title, parent?.reinterpret(),
            first_button_text)?.reinterpret())
}

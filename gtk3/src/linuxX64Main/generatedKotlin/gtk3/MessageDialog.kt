package gtk3

import kotlin.String
import kotlin.Unit
import kotlinx.cinterop.CPointer
import kotlinx.cinterop.reinterpret
import libgtk3.GtkButtonsType
import libgtk3.GtkDialogFlags
import libgtk3.GtkMessageDialog
import libgtk3.GtkMessageType
import libgtk3.GtkWidget
import libgtk3.GtkWindow
import libgtk3.gtk_message_dialog_format_secondary_markup
import libgtk3.gtk_message_dialog_format_secondary_text
import libgtk3.gtk_message_dialog_get_message_area
import libgtk3.gtk_message_dialog_new
import libgtk3.gtk_message_dialog_set_markup

inline fun Container.messageDialog(
    parent: CPointer<GtkWindow>,
    flags: GtkDialogFlags,
    type: GtkMessageType,
    buttons: GtkButtonsType,
    message_format: String,
    init: MessageDialog.() -> Unit = {}
): MessageDialog = MessageDialog(parent, flags, type, buttons, message_format).apply { init();
        this@messageDialog.add(this) }

/**
 * #GtkMessageDialog presents a dialog with some message text. It’s simply a
 * convenience widget; you could construct the equivalent of #GtkMessageDialog
 * from #GtkDialog without too much effort, but #GtkMessageDialog saves typing.
 *
 * One difference from #GtkDialog is that #GtkMessageDialog sets the
 * #GtkWindow:skip-taskbar-hint property to %TRUE, so that the dialog is hidden
 * from the taskbar by default.
 *
 * The easiest way to do a modal message dialog is to use gtk_dialog_run(), though
 * you can also pass in the %GTK_DIALOG_MODAL flag, gtk_dialog_run() automatically
 * makes the dialog modal and waits for the user to respond to it. gtk_dialog_run()
 * returns when any dialog button is clicked.
 *
 * An example for using a modal dialog:
 * |[<!-- language="C" -->
 *  GtkDialogFlags flags = GTK_DIALOG_DESTROY_WITH_PARENT;
 *  dialog = gtk_message_dialog_new (parent_window,
 *                                   flags,
 *                                   GTK_MESSAGE_ERROR,
 *                                   GTK_BUTTONS_CLOSE,
 *                                   "Error reading “%s”: %s",
 *                                   filename,
 *                                   g_strerror (errno));
 *  gtk_dialog_run (GTK_DIALOG (dialog));
 *  gtk_widget_destroy (dialog);
 * ]|
 *
 * You might do a non-modal #GtkMessageDialog as follows:
 *
 * An example for a non-modal dialog:
 * |[<!-- language="C" -->
 *  GtkDialogFlags flags = GTK_DIALOG_DESTROY_WITH_PARENT;
 *  dialog = gtk_message_dialog_new (parent_window,
 *                                   flags,
 *                                   GTK_MESSAGE_ERROR,
 *                                   GTK_BUTTONS_CLOSE,
 *                                   "Error reading “%s”: %s",
 *                                   filename,
 *                                   g_strerror (errno));
 *
 *  // Destroy the dialog when the user responds to it
 *  // (e.g. clicks a button)
 *
 *  g_signal_connect_swapped (dialog, "response",
 *                            G_CALLBACK (gtk_widget_destroy),
 *                            dialog);
 * ]|
 *
 * # GtkMessageDialog as GtkBuildable
 *
 * The GtkMessageDialog implementation of the GtkBuildable interface exposes
 * the message area as an internal child with the name “message_area”.Returns the message area of
        the dialog. This is the box where the
 * dialog’s primary and secondary labels are packed. You can add your
 * own extra content to that box and it will appear below those labels.
 * See gtk_dialog_get_content_area() for the corresponding
 * function in the parent #GtkDialog.
 */
@GtkDsl
open class MessageDialog internal constructor(override val widgetPtr: CPointer<GtkWidget>? = null) :
        Dialog() {
    private val self: CPointer<GtkMessageDialog>?
        get() = widgetPtr!!.reinterpret()

    val messageDialog: CPointer<GtkMessageDialog>?
        get() = widgetPtr!!.reinterpret()

    val messageArea: CPointer<GtkWidget>
        get() = gtk_message_dialog_get_message_area(self)!!.reinterpret()

    /**
     * Creates a new message dialog, which is a simple dialog with some text
     * the user may want to see. When the user clicks a button a “response”
     * signal is emitted with response IDs from #GtkResponseType. See
     * #GtkDialog for more details. */
    constructor(
        parent: CPointer<GtkWindow>,
        flags: GtkDialogFlags,
        type: GtkMessageType,
        buttons: GtkButtonsType,
        message_format: String
    ) : this(gtk_message_dialog_new(parent?.reinterpret(), flags, type, buttons,
            message_format)?.reinterpret())

    /**
     * Sets the secondary text of the message dialog to be @message_format (with
     * printf()-style), which is marked up with the
     * [Pango text markup language][PangoMarkupFormat].
     *
     * Due to an oversight, this function does not escape special XML characters
     * like gtk_message_dialog_new_with_markup() does. Thus, if the arguments
     * may contain special XML characters, you should use g_markup_printf_escaped()
     * to escape it.
     *
     * |[<!-- language="C" -->
     * gchar *msg;
     *
     * msg = g_markup_printf_escaped (message_format, ...);
     * gtk_message_dialog_format_secondary_markup (message_dialog,
     *                                             "%s", msg);
     * g_free (msg);
     * ]|
     */
    fun formatSecondaryMarkup(message_format: String): Unit =
            gtk_message_dialog_format_secondary_markup(self, message_format)

    /**
     * Sets the secondary text of the message dialog to be @message_format
     * (with printf()-style).
     */
    fun formatSecondaryText(message_format: String): Unit =
            gtk_message_dialog_format_secondary_text(self, message_format)

    /**
     * Sets the text of the message dialog to be @str, which is marked
     * up with the [Pango text markup language][PangoMarkupFormat].
     */
    fun setMarkup(str: String): Unit = gtk_message_dialog_set_markup(self, str)
}

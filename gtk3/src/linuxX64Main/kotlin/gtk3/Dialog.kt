package gtk3

import kotlin.Boolean
import kotlin.Int
import kotlin.String
import kotlin.Unit
import kotlinx.cinterop.CFunction
import kotlinx.cinterop.COpaquePointer
import kotlinx.cinterop.CPointed
import kotlinx.cinterop.CPointer
import kotlinx.cinterop.asStableRef
import kotlinx.cinterop.reinterpret
import kotlinx.cinterop.staticCFunction
import libgtk3.GtkBox
import libgtk3.GtkDialog
import libgtk3.GtkWidget
import libgtk3.gtk_dialog_add_action_widget
import libgtk3.gtk_dialog_add_button
import libgtk3.gtk_dialog_add_buttons
import libgtk3.gtk_dialog_get_content_area
import libgtk3.gtk_dialog_get_header_bar
import libgtk3.gtk_dialog_get_response_for_widget
import libgtk3.gtk_dialog_get_widget_for_response
import libgtk3.gtk_dialog_new
import libgtk3.gtk_dialog_response
import libgtk3.gtk_dialog_run
import libgtk3.gtk_dialog_set_default_response
import libgtk3.gtk_dialog_set_response_sensitive
import libgtk3.gtk_false
import libgtk3.gtk_true

inline fun Container.dialog(init: Dialog.() -> Unit = {}): Dialog = Dialog().apply { init();
        this@dialog.add(this) }

private fun Dialog_onClose_Handler(sender: CPointer<in CPointed>?, _data: COpaquePointer?) {
    _data?.asStableRef<Dialog>()?.get()?.onClose?.emit()
}

private fun Dialog_onResponse_Handler(
    sender: CPointer<in CPointed>?,
    response_id: Int,
    _data: COpaquePointer?
) {
    _data?.asStableRef<Dialog>()?.get()?.onResponse?.emit(response_id)
}

/**
 * Dialog boxes are a convenient way to prompt the user for a small amount
 * of input, e.g. to display a message, ask a question, or anything else
 * that does not require extensive effort on the user’s part.
 *
 * GTK+ treats a dialog as a window split vertically. The top section is a
 * #GtkVBox, and is where widgets such as a #GtkLabel or a #GtkEntry should
 * be packed. The bottom area is known as the
 * “action area”. This is generally used for
 * packing buttons into the dialog which may perform functions such as
 * cancel, ok, or apply.
 *
 * #GtkDialog boxes are created with a call to gtk_dialog_new() or
 * gtk_dialog_new_with_buttons(). gtk_dialog_new_with_buttons() is
 * recommended; it allows you to set the dialog title, some convenient
 * flags, and add simple buttons.
 *
 * If “dialog” is a newly created dialog, the two primary areas of the
 * window can be accessed through gtk_dialog_get_content_area() and
 * gtk_dialog_get_action_area(), as can be seen from the example below.
 *
 * A “modal” dialog (that is, one which freezes the rest of the application
 * from user input), can be created by calling gtk_window_set_modal() on the
 * dialog. Use the GTK_WINDOW() macro to cast the widget returned from
 * gtk_dialog_new() into a #GtkWindow. When using gtk_dialog_new_with_buttons()
 * you can also pass the #GTK_DIALOG_MODAL flag to make a dialog modal.
 *
 * If you add buttons to #GtkDialog using gtk_dialog_new_with_buttons(),
 * gtk_dialog_add_button(), gtk_dialog_add_buttons(), or
 * gtk_dialog_add_action_widget(), clicking the button will emit a signal
 * called #GtkDialog::response with a response ID that you specified. GTK+
 * will never assign a meaning to positive response IDs; these are entirely
 * user-defined. But for convenience, you can use the response IDs in the
 * #GtkResponseType enumeration (these all have values less than zero). If
 * a dialog receives a delete event, the #GtkDialog::response signal will
 * be emitted with a response ID of #GTK_RESPONSE_DELETE_EVENT.
 *
 * If you want to block waiting for a dialog to return before returning
 * control flow to your code, you can call gtk_dialog_run(). This function
 * enters a recursive main loop and waits for the user to respond to the
 * dialog, returning the response ID corresponding to the button the user
 * clicked.
 *
 * For the simple dialog in the following example, in reality you’d probably
 * use #GtkMessageDialog to save yourself some effort. But you’d need to
 * create the dialog contents manually if you had more than a simple message
 * in the dialog.
 *
 * An example for simple GtkDialog usage:
 * |[<!-- language="C" -->
 * // Function to open a dialog box with a message
 * void
 * quick_message (GtkWindow *parent, gchar *message)
 * {
 *  GtkWidget *dialog, *label, *content_area;
 *  GtkDialogFlags flags;
 *
 *  // Create the widgets
 *  flags = GTK_DIALOG_DESTROY_WITH_PARENT;
 *  dialog = gtk_dialog_new_with_buttons ("Message",
 *                                        parent,
 *                                        flags,
 *                                        _("_OK"),
 *                                        GTK_RESPONSE_NONE,
 *                                        NULL);
 *  content_area = gtk_dialog_get_content_area (GTK_DIALOG (dialog));
 *  label = gtk_label_new (message);
 *
 *  // Ensure that the dialog box is destroyed when the user responds
 *
 *  g_signal_connect_swapped (dialog,
 *                            "response",
 *                            G_CALLBACK (gtk_widget_destroy),
 *                            dialog);
 *
 *  // Add the label, and show everything we’ve added
 *
 *  gtk_container_add (GTK_CONTAINER (content_area), label);
 *  gtk_widget_show_all (dialog);
 * }
 * ]|
 *
 * # GtkDialog as GtkBuildable
 *
 * The GtkDialog implementation of the #GtkBuildable interface exposes the
 * @vbox and @action_area as internal children with the names “vbox” and
 * “action_area”.
 *
 * GtkDialog supports a custom <action-widgets> element, which can contain
 * multiple <action-widget> elements. The “response” attribute specifies a
 * numeric response, and the content of the element is the id of widget
 * (which should be a child of the dialogs @action_area). To mark a response
 * as default, set the “default“ attribute of the <action-widget> element
 * to true.
 *
 * GtkDialog supports adding action widgets by specifying “action“ as
 * the “type“ attribute of a <child> element. The widget will be added
 * either to the action area or the headerbar of the dialog, depending
 * on the “use-header-bar“ property. The response id has to be associated
 * with the action widget using the <action-widgets> element.
 *
 * An example of a #GtkDialog UI definition fragment:
 * |[
 * <object class="GtkDialog" id="dialog1">
 *   <child type="action">
 *     <object class="GtkButton" id="button_cancel"/>
 *   </child>
 *   <child type="action">
 *     <object class="GtkButton" id="button_ok">
 *       <property name="can-default">True</property>
 *     </object>
 *   </child>
 *   <action-widgets>
 *     <action-widget response="cancel">button_cancel</action-widget>
 *     <action-widget response="ok" default="true">button_ok</action-widget>
 *   </action-widgets>
 * </object>
 * ]|Returns the content area of @dialog.Returns the header bar of @dialog. Note that the
 * headerbar is only used by the dialog if the
 * #GtkDialog:use-header-bar property is %TRUE.
 */
@GtkDsl
open class Dialog internal constructor(override val widgetPtr: CPointer<GtkWidget>? = null) :
        Window() {
    private val self: CPointer<GtkDialog>?
        get() = widgetPtr!!.reinterpret()

    val dialog: CPointer<GtkDialog>?
        get() = widgetPtr!!.reinterpret()

    val onClose: Signal<Dialog, CFunction<(CPointer<in CPointed>?, COpaquePointer?) -> Unit>> by
            lazy { Signal<Dialog, CFunction<(CPointer<in CPointed>?, COpaquePointer?) ->
            Unit>>(widgetPtr!!, this, "close", staticCFunction(::Dialog_onClose_Handler)) }

    val onResponse: Signal1<Dialog, Int, CFunction<(
        CPointer<in CPointed>?,
        Int,
        COpaquePointer?
    ) -> Unit>> by lazy { Signal1<Dialog, Int, CFunction<(
                CPointer<in CPointed>?,
                Int,
                COpaquePointer?
            ) -> Unit>>(widgetPtr!!, this, "response", staticCFunction(::Dialog_onResponse_Handler))
                    }

    val contentArea: CPointer<GtkBox>
        get() = gtk_dialog_get_content_area(self)!!.reinterpret()

    val headerBar: CPointer<GtkWidget>
        get() = gtk_dialog_get_header_bar(self)!!.reinterpret()

    /**
     * Creates a new dialog box.
     *
     * Widgets should not be packed into this #GtkWindow
     * directly, but into the @vbox and @action_area, as described above. */
    constructor() : this(gtk_dialog_new()?.reinterpret())

    /**
     * Adds an activatable widget to the action area of a #GtkDialog,
     * connecting a signal handler that will emit the #GtkDialog::response
     * signal on the dialog when the widget is activated. The widget is
     * appended to the end of the dialog’s action area. If you want to add a
     * non-activatable widget, simply pack it into the @action_area field
     * of the #GtkDialog struct.
     */
    fun addActionWidget(child: CPointer<GtkWidget>, response_id: Int): Unit =
            gtk_dialog_add_action_widget(self, child, response_id)

    /**
     * Adds an activatable widget to the action area of a #GtkDialog,
     * connecting a signal handler that will emit the #GtkDialog::response
     * signal on the dialog when the widget is activated. The widget is
     * appended to the end of the dialog’s action area. If you want to add a
     * non-activatable widget, simply pack it into the @action_area field
     * of the #GtkDialog struct.
     */
    fun addActionWidget(child: Widget, response_id: Int): Unit = gtk_dialog_add_action_widget(self,
            child.widgetPtr?.reinterpret(), response_id)

    /**
     * Adds a button with the given text and sets things up so that
     * clicking the button will emit the #GtkDialog::response signal with
     * the given @response_id. The button is appended to the end of the
     * dialog’s action area. The button widget is returned, but usually
     * you don’t need it.
     */
    fun addButton(button_text: String, response_id: Int): CPointer<GtkWidget> =
            gtk_dialog_add_button(self, button_text, response_id)!!.reinterpret()

    /**
     * Adds more buttons, same as calling gtk_dialog_add_button()
     * repeatedly.  The variable argument list should be %NULL-terminated
     * as with gtk_dialog_new_with_buttons(). Each button must have both
     * text and response ID.
     */
    fun addButtons(first_button_text: String): Unit = gtk_dialog_add_buttons(self,
            first_button_text)

    /**
     * Gets the response id of a widget in the action area
     * of a dialog.
     */
    fun getResponseForWidget(widget: CPointer<GtkWidget>): Int =
            gtk_dialog_get_response_for_widget(self, widget)

    /**
     * Gets the response id of a widget in the action area
     * of a dialog.
     */
    fun getResponseForWidget(widget: Widget): Int = gtk_dialog_get_response_for_widget(self,
            widget.widgetPtr?.reinterpret())

    /**
     * Gets the widget button that uses the given response ID in the action area
     * of a dialog.
     */
    fun getWidgetForResponse(response_id: Int): CPointer<GtkWidget> =
            gtk_dialog_get_widget_for_response(self, response_id)!!.reinterpret()

    /**
     * Emits the #GtkDialog::response signal with the given response ID.
     * Used to indicate that the user has responded to the dialog in some way;
     * typically either you or gtk_dialog_run() will be monitoring the
     * ::response signal and take appropriate action.
     */
    fun response(response_id: Int): Unit = gtk_dialog_response(self, response_id)

    /**
     * Blocks in a recursive main loop until the @dialog either emits the
     * #GtkDialog::response signal, or is destroyed. If the dialog is
     * destroyed during the call to gtk_dialog_run(), gtk_dialog_run() returns
     * #GTK_RESPONSE_NONE. Otherwise, it returns the response ID from the
     * ::response signal emission.
     *
     * Before entering the recursive main loop, gtk_dialog_run() calls
     * gtk_widget_show() on the dialog for you. Note that you still
     * need to show any children of the dialog yourself.
     *
     * During gtk_dialog_run(), the default behavior of #GtkWidget::delete-event
     * is disabled; if the dialog receives ::delete_event, it will not be
     * destroyed as windows usually are, and gtk_dialog_run() will return
     * #GTK_RESPONSE_DELETE_EVENT. Also, during gtk_dialog_run() the dialog
     * will be modal. You can force gtk_dialog_run() to return at any time by
     * calling gtk_dialog_response() to emit the ::response signal. Destroying
     * the dialog during gtk_dialog_run() is a very bad idea, because your
     * post-run code won’t know whether the dialog was destroyed or not.
     *
     * After gtk_dialog_run() returns, you are responsible for hiding or
     * destroying the dialog if you wish to do so.
     *
     * Typical usage of this function might be:
     * |[<!-- language="C" -->
     *   GtkWidget *dialog = gtk_dialog_new ();
     *   // Set up dialog...
     *
     *   int result = gtk_dialog_run (GTK_DIALOG (dialog));
     *   switch (result)
     *     {
     *       case GTK_RESPONSE_ACCEPT:
     *          // do_application_specific_something ();
     *          break;
     *       default:
     *          // do_nothing_since_dialog_was_cancelled ();
     *          break;
     *     }
     *   gtk_widget_destroy (dialog);
     * ]|
     *
     * Note that even though the recursive main loop gives the effect of a
     * modal dialog (it prevents the user from interacting with other
     * windows in the same window group while the dialog is run), callbacks
     * such as timeouts, IO channel watches, DND drops, etc, will
     * be triggered during a gtk_dialog_run() call.
     */
    fun run(): Int = gtk_dialog_run(self)

    /**
     * Calls `gtk_widget_set_sensitive (widget, @setting)`
     * for each widget in the dialog’s action area with the given @response_id.
     * A convenient way to sensitize/desensitize dialog buttons.
     */
    fun setResponseSensitive(response_id: Int, setting: Boolean): Unit =
            gtk_dialog_set_response_sensitive(self, response_id,
            if (setting) gtk_true() else gtk_false())

    /**
     * Sets the last widget in the dialog’s action area with the given @response_id
     * as the default widget for the dialog. Pressing “Enter” normally activates
     * the default widget.
     */
    fun setDefaultResponse(response_id: Int): Unit = gtk_dialog_set_default_response(self,
            response_id)
}

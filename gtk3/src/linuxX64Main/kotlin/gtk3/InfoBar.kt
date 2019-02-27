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
import libgtk3.GtkButton
import libgtk3.GtkInfoBar
import libgtk3.GtkMessageType
import libgtk3.GtkWidget
import libgtk3.gtk_false
import libgtk3.gtk_info_bar_add_action_widget
import libgtk3.gtk_info_bar_add_button
import libgtk3.gtk_info_bar_add_buttons
import libgtk3.gtk_info_bar_get_action_area
import libgtk3.gtk_info_bar_get_content_area
import libgtk3.gtk_info_bar_get_message_type
import libgtk3.gtk_info_bar_get_revealed
import libgtk3.gtk_info_bar_get_show_close_button
import libgtk3.gtk_info_bar_new
import libgtk3.gtk_info_bar_response
import libgtk3.gtk_info_bar_set_default_response
import libgtk3.gtk_info_bar_set_message_type
import libgtk3.gtk_info_bar_set_response_sensitive
import libgtk3.gtk_info_bar_set_revealed
import libgtk3.gtk_info_bar_set_show_close_button
import libgtk3.gtk_true

inline fun Container.infoBar(init: InfoBar.() -> Unit = {}): InfoBar = InfoBar().apply { init();
        this@infoBar.add(this) }

private fun InfoBar_onClose_Handler(sender: CPointer<in CPointed>?, _data: COpaquePointer?) {
    _data?.asStableRef<InfoBar>()?.get()?.onClose?.emit()
}

private fun InfoBar_onResponse_Handler(
    sender: CPointer<in CPointed>?,
    response_id: Int,
    _data: COpaquePointer?
) {
    _data?.asStableRef<InfoBar>()?.get()?.onResponse?.emit(response_id)
}

/**
 * #GtkInfoBar is a widget that can be used to show messages to
 * the user without showing a dialog. It is often temporarily shown
 * at the top or bottom of a document. In contrast to #GtkDialog, which
 * has a action area at the bottom, #GtkInfoBar has an action area
 * at the side.
 *
 * The API of #GtkInfoBar is very similar to #GtkDialog, allowing you
 * to add buttons to the action area with gtk_info_bar_add_button() or
 * gtk_info_bar_new_with_buttons(). The sensitivity of action widgets
 * can be controlled with gtk_info_bar_set_response_sensitive().
 * To add widgets to the main content area of a #GtkInfoBar, use
 * gtk_info_bar_get_content_area() and add your widgets to the container.
 *
 * Similar to #GtkMessageDialog, the contents of a #GtkInfoBar can by
 * classified as error message, warning, informational message, etc,
 * by using gtk_info_bar_set_message_type(). GTK+ may use the message type
 * to determine how the message is displayed.
 *
 * A simple example for using a #GtkInfoBar:
 * |[<!-- language="C" -->
 * GtkWidget *widget, *message_label, *content_area;
 * GtkWidget *grid;
 * GtkInfoBar *bar;
 *
 * // set up info bar
 * widget = gtk_info_bar_new ();
 * bar = GTK_INFO_BAR (widget);
 * grid = gtk_grid_new ();
 *
 * gtk_widget_set_no_show_all (widget, TRUE);
 * message_label = gtk_label_new ("");
 * content_area = gtk_info_bar_get_content_area (bar);
 * gtk_container_add (GTK_CONTAINER (content_area),
 *                    message_label);
 * gtk_info_bar_add_button (bar,
 *                          _("_OK"),
 *                          GTK_RESPONSE_OK);
 * g_signal_connect (bar,
 *                   "response",
 *                   G_CALLBACK (gtk_widget_hide),
 *                   NULL);
 * gtk_grid_attach (GTK_GRID (grid),
 *                  widget,
 *                  0, 2, 1, 1);
 *
 * // ...
 *
 * // show an error message
 * gtk_label_set_text (GTK_LABEL (message_label), "An error occurred!");
 * gtk_info_bar_set_message_type (bar,
 *                                GTK_MESSAGE_ERROR);
 * gtk_widget_show (bar);
 * ]|
 *
 * # GtkInfoBar as GtkBuildable
 *
 * The GtkInfoBar implementation of the GtkBuildable interface exposes
 * the content area and action area as internal children with the names
 * “content_area” and “action_area”.
 *
 * GtkInfoBar supports a custom <action-widgets> element, which can contain
 * multiple <action-widget> elements. The “response” attribute specifies a
 * numeric response, and the content of the element is the id of widget
 * (which should be a child of the dialogs @action_area).
 *
 * # CSS nodes
 *
 * GtkInfoBar has a single CSS node with name infobar. The node may get
 * one of the style classes .info, .warning, .error or .question, depending
 * on the message type.Returns the action area of @info_bar.Returns the content area of @info_bar.
 */
@GtkDsl
open class InfoBar internal constructor(override val widgetPtr: CPointer<GtkWidget>? = null) : Box()
        {
    private val self: CPointer<GtkInfoBar>?
        get() = widgetPtr!!.reinterpret()

    val infoBar: CPointer<GtkInfoBar>?
        get() = widgetPtr!!.reinterpret()

    val onClose: Signal<InfoBar, CFunction<(CPointer<in CPointed>?, COpaquePointer?) -> Unit>> by
            lazy { Signal<InfoBar, CFunction<(CPointer<in CPointed>?, COpaquePointer?) ->
            Unit>>(widgetPtr!!, this, "close", staticCFunction(::InfoBar_onClose_Handler)) }

    val onResponse: Signal1<InfoBar, Int, CFunction<(
        CPointer<in CPointed>?,
        Int,
        COpaquePointer?
    ) -> Unit>> by lazy { Signal1<InfoBar, Int, CFunction<(
                CPointer<in CPointed>?,
                Int,
                COpaquePointer?
            ) -> Unit>>(widgetPtr!!, this, "response",
                    staticCFunction(::InfoBar_onResponse_Handler)) }

    val actionArea: CPointer<GtkWidget>
        get() = gtk_info_bar_get_action_area(self)!!.reinterpret()

    val contentArea: CPointer<GtkWidget>
        get() = gtk_info_bar_get_content_area(self)!!.reinterpret()

    /**
     * Returns the message type of the message area.
     *
     * Sets the message type of the message area.
     *
     * GTK+ uses this type to determine how the message is displayed. */
    var messageType: GtkMessageType
        get() = gtk_info_bar_get_message_type(self)
        set(value) {
            gtk_info_bar_set_message_type(self, value)
        }

    /**
     * Sets the GtkInfoBar:revealed property to @revealed. This will cause
     * @info_bar to show up with a slide-in transition.
     *
     * Note that this property does not automatically show @info_bar and thus won’t
     * have any effect if it is invisible. */
    var revealed: Boolean
        get() = gtk_info_bar_get_revealed(self) != 0
        set(value) {
            gtk_info_bar_set_revealed(self, if (value) gtk_true() else gtk_false())
        }

    /**
     * Returns whether the widget will display a standard close button.
     *
     * If true, a standard close button is shown. When clicked it emits
     * the response %GTK_RESPONSE_CLOSE. */
    var showCloseButton: Boolean
        get() = gtk_info_bar_get_show_close_button(self) != 0
        set(value) {
            gtk_info_bar_set_show_close_button(self, if (value) gtk_true() else gtk_false())
        }

    /**
     * Creates a new #GtkInfoBar object. */
    constructor() : this(gtk_info_bar_new()?.reinterpret())

    /**
     * Add an activatable widget to the action area of a #GtkInfoBar,
     * connecting a signal handler that will emit the #GtkInfoBar::response
     * signal on the message area when the widget is activated. The widget
     * is appended to the end of the message areas action area.
     */
    fun addActionWidget(child: CPointer<GtkWidget>, response_id: Int): Unit =
            gtk_info_bar_add_action_widget(self, child, response_id)

    /**
     * Add an activatable widget to the action area of a #GtkInfoBar,
     * connecting a signal handler that will emit the #GtkInfoBar::response
     * signal on the message area when the widget is activated. The widget
     * is appended to the end of the message areas action area.
     */
    fun addActionWidget(child: Widget, response_id: Int): Unit =
            gtk_info_bar_add_action_widget(self, child.widgetPtr?.reinterpret(), response_id)

    /**
     * Adds a button with the given text and sets things up so that
     * clicking the button will emit the “response” signal with the given
     * response_id. The button is appended to the end of the info bars's
     * action area. The button widget is returned, but usually you don't
     * need it.
     */
    fun addButton(button_text: String, response_id: Int): CPointer<GtkButton> =
            gtk_info_bar_add_button(self, button_text, response_id)!!.reinterpret()

    /**
     * Adds more buttons, same as calling gtk_info_bar_add_button()
     * repeatedly. The variable argument list should be %NULL-terminated
     * as with gtk_info_bar_new_with_buttons(). Each button must have both
     * text and response ID.
     */
    fun addButtons(first_button_text: String): Unit = gtk_info_bar_add_buttons(self,
            first_button_text)

    /**
     * Emits the “response” signal with the given @response_id.
     */
    fun response(response_id: Int): Unit = gtk_info_bar_response(self, response_id)

    /**
     * Calls gtk_widget_set_sensitive (widget, setting) for each
     * widget in the info bars’s action area with the given response_id.
     * A convenient way to sensitize/desensitize dialog buttons.
     */
    fun setResponseSensitive(response_id: Int, setting: Boolean): Unit =
            gtk_info_bar_set_response_sensitive(self, response_id,
            if (setting) gtk_true() else gtk_false())

    /**
     * Sets the last widget in the info bar’s action area with
     * the given response_id as the default widget for the dialog.
     * Pressing “Enter” normally activates the default widget.
     *
     * Note that this function currently requires @info_bar to
     * be added to a widget hierarchy.
     */
    fun setDefaultResponse(response_id: Int): Unit = gtk_info_bar_set_default_response(self,
            response_id)
}

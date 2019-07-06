package gtk3

import kotlin.Boolean
import kotlin.String
import kotlin.Unit
import kotlinx.cinterop.CFunction
import kotlinx.cinterop.COpaquePointer
import kotlinx.cinterop.CPointed
import kotlinx.cinterop.CPointer
import kotlinx.cinterop.asStableRef
import kotlinx.cinterop.reinterpret
import kotlinx.cinterop.staticCFunction
import kotlinx.cinterop.toKString
import libgtk3.GtkLinkButton
import libgtk3.GtkWidget
import libgtk3.gtk_false
import libgtk3.gtk_link_button_get_uri
import libgtk3.gtk_link_button_get_visited
import libgtk3.gtk_link_button_new
import libgtk3.gtk_link_button_set_uri
import libgtk3.gtk_link_button_set_visited
import libgtk3.gtk_true

inline fun Container.linkButton(uri: String, init: LinkButton.() -> Unit = {}): LinkButton =
        LinkButton(uri).apply { init(); this@linkButton.add(this) }

private fun LinkButton_onActivateLink_Handler(sender: CPointer<in CPointed>?, _data:
        COpaquePointer?) {
    _data?.asStableRef<LinkButton>()?.get()?.onActivateLink?.emit()
}

/**
 * A GtkLinkButton is a #GtkButton with a hyperlink, similar to the one
 * used by web browsers, which triggers an action when clicked. It is useful
 * to show quick links to resources.
 *
 * A link button is created by calling either gtk_link_button_new() or
 * gtk_link_button_new_with_label(). If using the former, the URI you pass
 * to the constructor is used as a label for the widget.
 *
 * The URI bound to a GtkLinkButton can be set specifically using
 * gtk_link_button_set_uri(), and retrieved using gtk_link_button_get_uri().
 *
 * By default, GtkLinkButton calls gtk_show_uri_on_window() when the button is
 * clicked. This behaviour can be overridden by connecting to the
 * #GtkLinkButton::activate-link signal and returning %TRUE from the
 * signal handler.
 *
 * # CSS nodes
 *
 * GtkLinkButton has a single CSS node with name button. To differentiate
 * it from a plain #GtkButton, it gets the .link style class.
 */
@GtkDsl
open class LinkButton internal constructor(override val widgetPtr: CPointer<GtkWidget>? = null) :
        Button() {
    private val self: CPointer<GtkLinkButton>?
        get() = widgetPtr!!.reinterpret()

    val linkButton: CPointer<GtkLinkButton>?
        get() = widgetPtr!!.reinterpret()

    val onActivateLink: Signal<LinkButton, CFunction<(CPointer<in CPointed>?, COpaquePointer?) ->
            Unit>> by lazy { Signal<LinkButton, CFunction<(CPointer<in CPointed>?,
            COpaquePointer?) -> Unit>>(widgetPtr!!, this, "activate-link",
            staticCFunction(::LinkButton_onActivateLink_Handler)) }

    /**
     * Retrieves the URI set using gtk_link_button_set_uri().
     *
     * Sets @uri as the URI where the #GtkLinkButton points. As a side-effect
     * this unsets the “visited” state of the button. */
    var uri: String
        get() = gtk_link_button_get_uri(self)?.toKString() ?: ""
        set(value) {
            gtk_link_button_set_uri(self, value)
        }

    /**
     * Retrieves the “visited” state of the URI where the #GtkLinkButton
     * points. The button becomes visited when it is clicked. If the URI
     * is changed on the button, the “visited” state is unset again.
     *
     * The state may also be changed using gtk_link_button_set_visited().
     *
     * Sets the “visited” state of the URI where the #GtkLinkButton
     * points.  See gtk_link_button_get_visited() for more details. */
    var visited: Boolean
        get() = gtk_link_button_get_visited(self) != 0
        set(value) {
            gtk_link_button_set_visited(self, if (value) gtk_true() else gtk_false())
        }

    /**
     * Creates a new #GtkLinkButton with the URI as its text. */
    constructor(uri: String) : this(gtk_link_button_new(uri)?.reinterpret())
}

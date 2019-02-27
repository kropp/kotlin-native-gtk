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
import libgtk3.GtkExpander
import libgtk3.GtkWidget
import libgtk3.gtk_expander_get_expanded
import libgtk3.gtk_expander_get_label
import libgtk3.gtk_expander_get_label_fill
import libgtk3.gtk_expander_get_label_widget
import libgtk3.gtk_expander_get_resize_toplevel
import libgtk3.gtk_expander_get_use_markup
import libgtk3.gtk_expander_get_use_underline
import libgtk3.gtk_expander_new
import libgtk3.gtk_expander_set_expanded
import libgtk3.gtk_expander_set_label
import libgtk3.gtk_expander_set_label_fill
import libgtk3.gtk_expander_set_label_widget
import libgtk3.gtk_expander_set_resize_toplevel
import libgtk3.gtk_expander_set_use_markup
import libgtk3.gtk_expander_set_use_underline
import libgtk3.gtk_false
import libgtk3.gtk_true

inline fun Container.expander(label: String, init: Expander.() -> Unit = {}): Expander =
        Expander(label).apply { init(); this@expander.add(this) }

private fun Expander_onActivate_Handler(sender: CPointer<in CPointed>?, _data: COpaquePointer?) {
    _data?.asStableRef<Expander>()?.get()?.onActivate?.emit()
}

/**
 * A #GtkExpander allows the user to hide or show its child by clicking
 * on an expander triangle similar to the triangles used in a #GtkTreeView.
 *
 * Normally you use an expander as you would use any other descendant
 * of #GtkBin; you create the child widget and use gtk_container_add()
 * to add it to the expander. When the expander is toggled, it will take
 * care of showing and hiding the child automatically.
 *
 * # Special Usage
 *
 * There are situations in which you may prefer to show and hide the
 * expanded widget yourself, such as when you want to actually create
 * the widget at expansion time. In this case, create a #GtkExpander
 * but do not add a child to it. The expander widget has an
 * #GtkExpander:expanded property which can be used to monitor
 * its expansion state. You should watch this property with a signal
 * connection as follows:
 *
 * |[<!-- language="C" -->
 * static void
 * expander_callback (GObject    *object,
 *                    GParamSpec *param_spec,
 *                    gpointer    user_data)
 * {
 *   GtkExpander *expander;
 *
 *   expander = GTK_EXPANDER (object);
 *
 *   if (gtk_expander_get_expanded (expander))
 *     {
 *       // Show or create widgets
 *     }
 *   else
 *     {
 *       // Hide or destroy widgets
 *     }
 * }
 *
 * static void
 * create_expander (void)
 * {
 *   GtkWidget *expander = gtk_expander_new_with_mnemonic ("_More Options");
 *   g_signal_connect (expander, "notify::expanded",
 *                     G_CALLBACK (expander_callback), NULL);
 *
 *   // ...
 * }
 * ]|
 *
 * # GtkExpander as GtkBuildable
 *
 * The GtkExpander implementation of the GtkBuildable interface supports
 * placing a child in the label position by specifying “label” as the
 * “type” attribute of a <child> element. A normal content child can be
 * specified without specifying a <child> type attribute.
 *
 * An example of a UI definition fragment with GtkExpander:
 * |[
 * <object class="GtkExpander">
 *   <child type="label">
 *     <object class="GtkLabel" id="expander-label"/>
 *   </child>
 *   <child>
 *     <object class="GtkEntry" id="expander-content"/>
 *   </child>
 * </object>
 * ]|
 *
 * # CSS nodes
 *
 * |[<!-- language="plain" -->
 * expander
 * ├── title
 * │   ├── arrow
 * │   ╰── <label widget>
 * ╰── <child>
 * ]|
 *
 * GtkExpander has three CSS nodes, the main node with the name expander,
 * a subnode with name title and node below it with name arrow. The arrow of an
 * expander that is showing its child gets the :checked pseudoclass added to it.
 */
@GtkDsl
open class Expander internal constructor(override val widgetPtr: CPointer<GtkWidget>? = null) :
        Bin() {
    private val self: CPointer<GtkExpander>?
        get() = widgetPtr!!.reinterpret()

    val expander: CPointer<GtkExpander>?
        get() = widgetPtr!!.reinterpret()

    val onActivate: Signal<Expander, CFunction<(CPointer<in CPointed>?, COpaquePointer?) -> Unit>>
            by lazy { Signal<Expander, CFunction<(CPointer<in CPointed>?, COpaquePointer?) ->
            Unit>>(widgetPtr!!, this, "activate", staticCFunction(::Expander_onActivate_Handler)) }

    /**
     * Queries a #GtkExpander and returns its current state. Returns %TRUE
     * if the child widget is revealed.
     *
     * See gtk_expander_set_expanded().
     *
     * Sets the state of the expander. Set to %TRUE, if you want
     * the child widget to be revealed, and %FALSE if you want the
     * child widget to be hidden. */
    var expanded: Boolean
        get() = gtk_expander_get_expanded(self) != 0
        set(value) {
            gtk_expander_set_expanded(self, if (value) gtk_true() else gtk_false())
        }

    /**
     * Fetches the text from a label widget including any embedded
     * underlines indicating mnemonics and Pango markup, as set by
     * gtk_expander_set_label(). If the label text has not been set the
     * return value will be %NULL. This will be the case if you create an
     * empty button with gtk_button_new() to use as a container.
     *
     * Note that this function behaved differently in versions prior to
     * 2.14 and used to return the label text stripped of embedded
     * underlines indicating mnemonics and Pango markup. This problem can
     * be avoided by fetching the label text directly from the label
     * widget.
     *
     * Sets the text of the label of the expander to @label.
     *
     * This will also clear any previously set labels. */
    var label: String
        get() = gtk_expander_get_label(self)?.toKString() ?: ""
        set(value) {
            gtk_expander_set_label(self, value)
        }

    /**
     * Returns whether the label widget will fill all available
     * horizontal space allocated to @expander.
     *
     * Sets whether the label widget should fill all available
     * horizontal space allocated to @expander. */
    var labelFill: Boolean
        get() = gtk_expander_get_label_fill(self) != 0
        set(value) {
            gtk_expander_set_label_fill(self, if (value) gtk_true() else gtk_false())
        }

    /**
     * Retrieves the label widget for the frame. See
     * gtk_expander_set_label_widget().
     *
     * Set the label widget for the expander. This is the widget
     * that will appear embedded alongside the expander arrow. */
    var labelWidget: CPointer<GtkWidget>
        get() = gtk_expander_get_label_widget(self)!!.reinterpret()
        set(value) {
            gtk_expander_set_label_widget(self, value?.reinterpret())
        }

    /**
     * Returns whether the expander will resize the toplevel widget
     * containing the expander upon resizing and collpasing.
     *
     * Sets whether the expander will resize the toplevel widget
     * containing the expander upon resizing and collpasing. */
    var resizeToplevel: Boolean
        get() = gtk_expander_get_resize_toplevel(self) != 0
        set(value) {
            gtk_expander_set_resize_toplevel(self, if (value) gtk_true() else gtk_false())
        }

    /**
     * Returns whether the label’s text is interpreted as marked up with
     * the [Pango text markup language][PangoMarkupFormat].
     * See gtk_expander_set_use_markup().
     *
     * Sets whether the text of the label contains markup in
     * [Pango’s text markup language][PangoMarkupFormat].
     * See gtk_label_set_markup(). */
    var useMarkup: Boolean
        get() = gtk_expander_get_use_markup(self) != 0
        set(value) {
            gtk_expander_set_use_markup(self, if (value) gtk_true() else gtk_false())
        }

    /**
     * Returns whether an embedded underline in the expander label
     * indicates a mnemonic. See gtk_expander_set_use_underline().
     *
     * If true, an underline in the text of the expander label indicates
     * the next character should be used for the mnemonic accelerator key. */
    var useUnderline: Boolean
        get() = gtk_expander_get_use_underline(self) != 0
        set(value) {
            gtk_expander_set_use_underline(self, if (value) gtk_true() else gtk_false())
        }

    /**
     * Creates a new expander using @label as the text of the label. */
    constructor(label: String) : this(gtk_expander_new(label)?.reinterpret())
}

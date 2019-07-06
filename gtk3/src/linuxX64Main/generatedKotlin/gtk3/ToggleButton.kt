package gtk3

import kotlin.Boolean
import kotlin.Unit
import kotlinx.cinterop.CFunction
import kotlinx.cinterop.COpaquePointer
import kotlinx.cinterop.CPointed
import kotlinx.cinterop.CPointer
import kotlinx.cinterop.asStableRef
import kotlinx.cinterop.reinterpret
import kotlinx.cinterop.staticCFunction
import libgtk3.GtkToggleButton
import libgtk3.GtkWidget
import libgtk3.gtk_false
import libgtk3.gtk_toggle_button_get_active
import libgtk3.gtk_toggle_button_get_inconsistent
import libgtk3.gtk_toggle_button_get_mode
import libgtk3.gtk_toggle_button_new
import libgtk3.gtk_toggle_button_set_active
import libgtk3.gtk_toggle_button_set_inconsistent
import libgtk3.gtk_toggle_button_set_mode
import libgtk3.gtk_toggle_button_toggled
import libgtk3.gtk_true

inline fun Container.toggleButton(init: ToggleButton.() -> Unit = {}): ToggleButton =
        ToggleButton().apply { init(); this@toggleButton.add(this) }

private fun ToggleButton_onToggled_Handler(sender: CPointer<in CPointed>?, _data: COpaquePointer?) {
    _data?.asStableRef<ToggleButton>()?.get()?.onToggled?.emit()
}

/**
 * A #GtkToggleButton is a #GtkButton which will remain “pressed-in” when
 * clicked. Clicking again will cause the toggle button to return to its
 * normal state.
 *
 * A toggle button is created by calling either gtk_toggle_button_new() or
 * gtk_toggle_button_new_with_label(). If using the former, it is advisable to
 * pack a widget, (such as a #GtkLabel and/or a #GtkImage), into the toggle
 * button’s container. (See #GtkButton for more information).
 *
 * The state of a #GtkToggleButton can be set specifically using
 * gtk_toggle_button_set_active(), and retrieved using
 * gtk_toggle_button_get_active().
 *
 * To simply switch the state of a toggle button, use gtk_toggle_button_toggled().
 *
 * # CSS nodes
 *
 * GtkToggleButton has a single CSS node with name button. To differentiate
 * it from a plain #GtkButton, it gets the .toggle style class.
 *
 * ## Creating two #GtkToggleButton widgets.
 *
 * |[<!-- language="C" -->
 * static void output_state (GtkToggleButton *source, gpointer user_data) {
 *   printf ("Active: %d\n", gtk_toggle_button_get_active (source));
 * }
 *
 * void make_toggles (void) {
 *   GtkWidget *window, *toggle1, *toggle2;
 *   GtkWidget *box;
 *   const char *text;
 *
 *   window = gtk_window_new (GTK_WINDOW_TOPLEVEL);
 *   box = gtk_box_new (GTK_ORIENTATION_VERTICAL, 12);
 *
 *   text = "Hi, I’m a toggle button.";
 *   toggle1 = gtk_toggle_button_new_with_label (text);
 *
 *   // Makes this toggle button invisible
 *   gtk_toggle_button_set_mode (GTK_TOGGLE_BUTTON (toggle1),
 *                               TRUE);
 *
 *   g_signal_connect (toggle1, "toggled",
 *                     G_CALLBACK (output_state),
 *                     NULL);
 *   gtk_container_add (GTK_CONTAINER (box), toggle1);
 *
 *   text = "Hi, I’m a toggle button.";
 *   toggle2 = gtk_toggle_button_new_with_label (text);
 *   gtk_toggle_button_set_mode (GTK_TOGGLE_BUTTON (toggle2),
 *                               FALSE);
 *   g_signal_connect (toggle2, "toggled",
 *                     G_CALLBACK (output_state),
 *                     NULL);
 *   gtk_container_add (GTK_CONTAINER (box), toggle2);
 *
 *   gtk_container_add (GTK_CONTAINER (window), box);
 *   gtk_widget_show_all (window);
 * }
 * ]|
 */
@GtkDsl
open class ToggleButton internal constructor(override val widgetPtr: CPointer<GtkWidget>? = null) :
        Button() {
    private val self: CPointer<GtkToggleButton>?
        get() = widgetPtr!!.reinterpret()

    val toggleButton: CPointer<GtkToggleButton>?
        get() = widgetPtr!!.reinterpret()

    val onToggled: Signal<ToggleButton, CFunction<(CPointer<in CPointed>?, COpaquePointer?) ->
            Unit>> by lazy { Signal<ToggleButton, CFunction<(CPointer<in CPointed>?,
            COpaquePointer?) -> Unit>>(widgetPtr!!, this, "toggled",
            staticCFunction(::ToggleButton_onToggled_Handler)) }

    /**
     * Queries a #GtkToggleButton and returns its current state. Returns %TRUE if
     * the toggle button is pressed in and %FALSE if it is raised.
     *
     * Sets the status of the toggle button. Set to %TRUE if you want the
     * GtkToggleButton to be “pressed in”, and %FALSE to raise it.
     * This action causes the #GtkToggleButton::toggled signal and the
     * #GtkButton::clicked signal to be emitted. */
    var active: Boolean
        get() = gtk_toggle_button_get_active(self) != 0
        set(value) {
            gtk_toggle_button_set_active(self, if (value) gtk_true() else gtk_false())
        }

    /**
     * Gets the value set by gtk_toggle_button_set_inconsistent().
     *
     * If the user has selected a range of elements (such as some text or
     * spreadsheet cells) that are affected by a toggle button, and the
     * current values in that range are inconsistent, you may want to
     * display the toggle in an “in between” state. This function turns on
     * “in between” display.  Normally you would turn off the inconsistent
     * state again if the user toggles the toggle button. This has to be
     * done manually, gtk_toggle_button_set_inconsistent() only affects
     * visual appearance, it doesn’t affect the semantics of the button. */
    var inconsistent: Boolean
        get() = gtk_toggle_button_get_inconsistent(self) != 0
        set(value) {
            gtk_toggle_button_set_inconsistent(self, if (value) gtk_true() else gtk_false())
        }

    /**
     * Retrieves whether the button is displayed as a separate indicator
     * and label. See gtk_toggle_button_set_mode().
     *
     * Sets whether the button is displayed as a separate indicator and label.
     * You can call this function on a checkbutton or a radiobutton with
     * @draw_indicator = %FALSE to make the button look like a normal button.
     *
     * This can be used to create linked strip of buttons that work like
     * a #GtkStackSwitcher.
     *
     * This function only affects instances of classes like #GtkCheckButton
     * and #GtkRadioButton that derive from #GtkToggleButton,
     * not instances of #GtkToggleButton itself. */
    var mode: Boolean
        get() = gtk_toggle_button_get_mode(self) != 0
        set(value) {
            gtk_toggle_button_set_mode(self, if (value) gtk_true() else gtk_false())
        }

    /**
     * Creates a new toggle button. A widget should be packed into the button, as in
            gtk_button_new(). */
    constructor() : this(gtk_toggle_button_new()?.reinterpret())

    /**
     * Emits the #GtkToggleButton::toggled signal on the
     * #GtkToggleButton. There is no good reason for an
     * application ever to call this function.
     */
    fun toggled(): Unit = gtk_toggle_button_toggled(self)
}

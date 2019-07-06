package gtk3

import kotlin.Unit
import kotlinx.cinterop.CFunction
import kotlinx.cinterop.COpaquePointer
import kotlinx.cinterop.CPointed
import kotlinx.cinterop.CPointer
import kotlinx.cinterop.asStableRef
import kotlinx.cinterop.reinterpret
import kotlinx.cinterop.staticCFunction
import libgtk3.GSList
import libgtk3.GtkRadioButton
import libgtk3.GtkWidget
import libgtk3.gtk_radio_button_get_group
import libgtk3.gtk_radio_button_join_group
import libgtk3.gtk_radio_button_new
import libgtk3.gtk_radio_button_set_group

inline fun Container.radioButton(group: CPointer<GSList>?, init: RadioButton.() -> Unit = {}):
        RadioButton = RadioButton(group).apply { init(); this@radioButton.add(this) }

private fun RadioButton_onGroupChanged_Handler(sender: CPointer<in CPointed>?, _data:
        COpaquePointer?) {
    _data?.asStableRef<RadioButton>()?.get()?.onGroupChanged?.emit()
}

private fun CPointer<GSList>?.gtk_radio_button_new(): CPointer<GtkWidget>? {
    return gtk_radio_button_new(this?.reinterpret())?.reinterpret()
}

/**
 * A single radio button performs the same basic function as a #GtkCheckButton,
 * as its position in the object hierarchy reflects. It is only when multiple
 * radio buttons are grouped together that they become a different user
 * interface component in their own right.
 *
 * Every radio button is a member of some group of radio buttons. When one is
 * selected, all other radio buttons in the same group are deselected. A
 * #GtkRadioButton is one way of giving the user a choice from many options.
 *
 * Radio button widgets are created with gtk_radio_button_new(), passing %NULL
 * as the argument if this is the first radio button in a group. In subsequent
 * calls, the group you wish to add this button to should be passed as an
 * argument. Optionally, gtk_radio_button_new_with_label() can be used if you
 * want a text label on the radio button.
 *
 * Alternatively, when adding widgets to an existing group of radio buttons,
 * use gtk_radio_button_new_from_widget() with a #GtkRadioButton that already
 * has a group assigned to it. The convenience function
 * gtk_radio_button_new_with_label_from_widget() is also provided.
 *
 * To retrieve the group a #GtkRadioButton is assigned to, use
 * gtk_radio_button_get_group().
 *
 * To remove a #GtkRadioButton from one group and make it part of a new one,
 * use gtk_radio_button_set_group().
 *
 * The group list does not need to be freed, as each #GtkRadioButton will remove
 * itself and its list item when it is destroyed.
 *
 * # CSS nodes
 *
 * |[<!-- language="plain" -->
 * radiobutton
 * ├── radio
 * ╰── <child>
 * ]|
 *
 * A GtkRadioButton with indicator (see gtk_toggle_button_set_mode()) has a
 * main CSS node with name radiobutton and a subnode with name radio.
 *
 * |[<!-- language="plain" -->
 * button.radio
 * ├── radio
 * ╰── <child>
 * ]|
 *
 * A GtkRadioButton without indicator changes the name of its main node
 * to button and adds a .radio style class to it. The subnode is invisible
 * in this case.
 *
 * ## How to create a group of two radio buttons.
 *
 * |[<!-- language="C" -->
 * void create_radio_buttons (void) {
 *
 *    GtkWidget *window, *radio1, *radio2, *box, *entry;
 *    window = gtk_window_new (GTK_WINDOW_TOPLEVEL);
 *    box = gtk_box_new (GTK_ORIENTATION_VERTICAL, 2);
 *    gtk_box_set_homogeneous (GTK_BOX (box), TRUE);
 *
 *    // Create a radio button with a GtkEntry widget
 *    radio1 = gtk_radio_button_new (NULL);
 *    entry = gtk_entry_new ();
 *    gtk_container_add (GTK_CONTAINER (radio1), entry);
 *
 *
 *    // Create a radio button with a label
 *    radio2 = gtk_radio_button_new_with_label_from_widget (GTK_RADIO_BUTTON (radio1),
 *                                                          "I’m the second radio button.");
 *
 *    // Pack them into a box, then show all the widgets
 *    gtk_box_pack_start (GTK_BOX (box), radio1);
 *    gtk_box_pack_start (GTK_BOX (box), radio2);
 *    gtk_container_add (GTK_CONTAINER (window), box);
 *    gtk_widget_show_all (window);
 *    return;
 * }
 * ]|
 *
 * When an unselected button in the group is clicked the clicked button
 * receives the #GtkToggleButton::toggled signal, as does the previously
 * selected button.
 * Inside the #GtkToggleButton::toggled handler, gtk_toggle_button_get_active()
 * can be used to determine if the button has been selected or deselected.
 */
@GtkDsl
open class RadioButton internal constructor(override val widgetPtr: CPointer<GtkWidget>?) :
        CheckButton() {
    private val self: CPointer<GtkRadioButton>?
        get() = widgetPtr!!.reinterpret()

    val radioButton: CPointer<GtkRadioButton>?
        get() = widgetPtr!!.reinterpret()

    val onGroupChanged: Signal<RadioButton, CFunction<(CPointer<in CPointed>?, COpaquePointer?) ->
            Unit>> by lazy { Signal<RadioButton, CFunction<(CPointer<in CPointed>?,
            COpaquePointer?) -> Unit>>(widgetPtr!!, this, "group-changed",
            staticCFunction(::RadioButton_onGroupChanged_Handler)) }

    /**
     * Retrieves the group assigned to a radio button.
     *
     * Sets a #GtkRadioButton’s group. It should be noted that this does not change
     * the layout of your interface in any way, so if you are changing the group,
     * it is likely you will need to re-arrange the user interface to reflect these
     * changes. */
    var group: CPointer<GSList>
        get() = gtk_radio_button_get_group(self)!!.reinterpret()
        set(value) {
            gtk_radio_button_set_group(self, value?.reinterpret())
        }

    /**
     * Creates a new #GtkRadioButton. To be of any practical value, a widget should
     * then be packed into the radio button. */
    constructor(group: CPointer<GSList>?) :
            this(group.gtk_radio_button_new())

    /**
     * Joins a #GtkRadioButton object to the group of another #GtkRadioButton object
     *
     * Use this in language bindings instead of the gtk_radio_button_get_group()
     * and gtk_radio_button_set_group() methods
     *
     * A common way to set up a group of radio buttons is the following:
     * |[<!-- language="C" -->
     *   GtkRadioButton *radio_button;
     *   GtkRadioButton *last_button;
     *
     *   while (some_condition)
     *     {
     *        radio_button = gtk_radio_button_new (NULL);
     *
     *        gtk_radio_button_join_group (radio_button, last_button);
     *        last_button = radio_button;
     *     }
     * ]|
     */
    fun joinGroup(group_source: CPointer<GtkRadioButton>): Unit = gtk_radio_button_join_group(self,
            group_source)

    /**
     * Joins a #GtkRadioButton object to the group of another #GtkRadioButton object
     *
     * Use this in language bindings instead of the gtk_radio_button_get_group()
     * and gtk_radio_button_set_group() methods
     *
     * A common way to set up a group of radio buttons is the following:
     * |[<!-- language="C" -->
     *   GtkRadioButton *radio_button;
     *   GtkRadioButton *last_button;
     *
     *   while (some_condition)
     *     {
     *        radio_button = gtk_radio_button_new (NULL);
     *
     *        gtk_radio_button_join_group (radio_button, last_button);
     *        last_button = radio_button;
     *     }
     * ]|
     */
    fun joinGroup(group_source: RadioButton): Unit = gtk_radio_button_join_group(self,
            group_source.widgetPtr?.reinterpret())
}

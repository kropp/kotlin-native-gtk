package gtk3

import kotlin.Boolean
import kotlin.String
import kotlin.UInt
import kotlin.Unit
import kotlinx.cinterop.CPointer
import kotlinx.cinterop.reinterpret
import libgtk3.GdkModifierType
import libgtk3.GtkAccelLabel
import libgtk3.GtkWidget
import libgtk3.gtk_accel_label_get_accel_widget
import libgtk3.gtk_accel_label_get_accel_width
import libgtk3.gtk_accel_label_new
import libgtk3.gtk_accel_label_refetch
import libgtk3.gtk_accel_label_set_accel
import libgtk3.gtk_accel_label_set_accel_widget

inline fun Container.accelLabel(string: String, init: AccelLabel.() -> Unit = {}): AccelLabel =
        AccelLabel(string).apply { init(); this@accelLabel.add(this) }

/**
 * The #GtkAccelLabel widget is a subclass of #GtkLabel that also displays an
 * accelerator key on the right of the label text, e.g. “Ctrl+S”.
 * It is commonly used in menus to show the keyboard short-cuts for commands.
 *
 * The accelerator key to display is typically not set explicitly (although it
 * can be, with gtk_accel_label_set_accel()). Instead, the #GtkAccelLabel displays
 * the accelerators which have been added to a particular widget. This widget is
 * set by calling gtk_accel_label_set_accel_widget().
 *
 * For example, a #GtkMenuItem widget may have an accelerator added to emit
 * the “activate” signal when the “Ctrl+S” key combination is pressed.
 * A #GtkAccelLabel is created and added to the #GtkMenuItem, and
 * gtk_accel_label_set_accel_widget() is called with the #GtkMenuItem as the
 * second argument. The #GtkAccelLabel will now display “Ctrl+S” after its label.
 *
 * Note that creating a #GtkMenuItem with gtk_menu_item_new_with_label() (or
 * one of the similar functions for #GtkCheckMenuItem and #GtkRadioMenuItem)
 * automatically adds a #GtkAccelLabel to the #GtkMenuItem and calls
 * gtk_accel_label_set_accel_widget() to set it up for you.
 *
 * A #GtkAccelLabel will only display accelerators which have %GTK_ACCEL_VISIBLE
 * set (see #GtkAccelFlags).
 * A #GtkAccelLabel can display multiple accelerators and even signal names,
 * though it is almost always used to display just one accelerator key.
 *
 * ## Creating a simple menu item with an accelerator key.
 *
 * |[<!-- language="C" -->
 *   GtkWidget *window = gtk_window_new (GTK_WINDOW_TOPLEVEL);
 *   GtkWidget *menu = gtk_menu_new ();
 *   GtkWidget *save_item;
 *   GtkAccelGroup *accel_group;
 *
 *   // Create a GtkAccelGroup and add it to the window.
 *   accel_group = gtk_accel_group_new ();
 *   gtk_window_add_accel_group (GTK_WINDOW (window), accel_group);
 *
 *   // Create the menu item using the convenience function.
 *   save_item = gtk_menu_item_new_with_label ("Save");
 *   gtk_widget_show (save_item);
 *   gtk_container_add (GTK_CONTAINER (menu), save_item);
 *
 *   // Now add the accelerator to the GtkMenuItem. Note that since we
 *   // called gtk_menu_item_new_with_label() to create the GtkMenuItem
 *   // the GtkAccelLabel is automatically set up to display the
 *   // GtkMenuItem accelerators. We just need to make sure we use
 *   // GTK_ACCEL_VISIBLE here.
 *   gtk_widget_add_accelerator (save_item, "activate", accel_group,
 *                               GDK_KEY_s, GDK_CONTROL_MASK, GTK_ACCEL_VISIBLE);
 * ]|
 *
 * # CSS nodes
 *
 * |[<!-- language="plain" -->
 * label
 * ╰── accelerator
 * ]|
 *
 * Like #GtkLabel, GtkAccelLabel has a main CSS node with the name label.
 * It adds a subnode with name accelerator.Returns the width needed to display the accelerator
        key(s).
 * This is used by menus to align all of the #GtkMenuItem widgets, and shouldn't
 * be needed by applications.
 */
@GtkDsl
open class AccelLabel internal constructor(override val widgetPtr: CPointer<GtkWidget>? = null) :
        Label() {
    private val self: CPointer<GtkAccelLabel>?
        get() = widgetPtr!!.reinterpret()

    val accelLabel: CPointer<GtkAccelLabel>?
        get() = widgetPtr!!.reinterpret()

    /**
     * Fetches the widget monitored by this accelerator label. See
     * gtk_accel_label_set_accel_widget().
     *
     * Sets the widget to be monitored by this accelerator label. Passing %NULL for
     * @accel_widget will dissociate @accel_label from its current widget, if any. */
    var accelWidget: CPointer<GtkWidget>
        get() = gtk_accel_label_get_accel_widget(self)!!.reinterpret()
        set(value) {
            gtk_accel_label_set_accel_widget(self, value?.reinterpret())
        }

    val accelWidth: UInt
        get() = gtk_accel_label_get_accel_width(self)

    /**
     * Creates a new #GtkAccelLabel. */
    constructor(string: String) : this(gtk_accel_label_new(string)?.reinterpret())

    /**
     * Recreates the string representing the accelerator keys.
     * This should not be needed since the string is automatically updated whenever
     * accelerators are added or removed from the associated widget.
     */
    fun refetch(): Boolean = gtk_accel_label_refetch(self) != 0

    /**
     * Manually sets a keyval and modifier mask as the accelerator rendered
     * by @accel_label.
     *
     * If a keyval and modifier are explicitly set then these values are
     * used regardless of any associated accel closure or widget.
     *
     * Providing an @accelerator_key of 0 removes the manual setting.
     */
    fun setAccel(accelerator_key: UInt, accelerator_mods: GdkModifierType): Unit =
            gtk_accel_label_set_accel(self, accelerator_key, accelerator_mods)
}

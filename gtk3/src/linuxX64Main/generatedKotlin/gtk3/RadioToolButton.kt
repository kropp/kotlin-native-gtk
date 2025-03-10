package gtk3

import kotlin.Unit
import kotlinx.cinterop.CPointer
import kotlinx.cinterop.reinterpret
import libgtk3.GSList
import libgtk3.GtkRadioToolButton
import libgtk3.GtkWidget
import libgtk3.gtk_radio_tool_button_get_group
import libgtk3.gtk_radio_tool_button_new
import libgtk3.gtk_radio_tool_button_set_group

inline fun Container.radioToolButton(group: CPointer<GSList>, init: RadioToolButton.() -> Unit =
        {}): RadioToolButton = RadioToolButton(group).apply { init(); this@radioToolButton.add(this)
        }

/**
 * A #GtkRadioToolButton is a #GtkToolItem that contains a radio button,
 * that is, a button that is part of a group of toggle buttons where only
 * one button can be active at a time.
 *
 * Use gtk_radio_tool_button_new() to create a new GtkRadioToolButton. Use
 * gtk_radio_tool_button_new_from_widget() to create a new GtkRadioToolButton
 * that is part of the same group as an existing GtkRadioToolButton.
 *
 * # CSS nodes
 *
 * GtkRadioToolButton has a single CSS node with name toolbutton.
 */
@GtkDsl
open class RadioToolButton internal constructor(override val widgetPtr: CPointer<GtkWidget>? = null)
        : ToggleToolButton() {
    private val self: CPointer<GtkRadioToolButton>?
        get() = widgetPtr!!.reinterpret()

    val radioToolButton: CPointer<GtkRadioToolButton>?
        get() = widgetPtr!!.reinterpret()

    /**
     * Returns the radio button group @button belongs to.
     *
     * Adds @button to @group, removing it from the group it belonged to before. */
    var group: CPointer<GSList>
        get() = gtk_radio_tool_button_get_group(self)!!.reinterpret()
        set(value) {
            gtk_radio_tool_button_set_group(self, value?.reinterpret())
        }

    /**
     * Creates a new #GtkRadioToolButton, adding it to @group. */
    constructor(group: CPointer<GSList>) :
            this(gtk_radio_tool_button_new(group?.reinterpret())?.reinterpret())
}

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
import libgtk3.GtkToggleToolButton
import libgtk3.GtkWidget
import libgtk3.gtk_false
import libgtk3.gtk_toggle_tool_button_get_active
import libgtk3.gtk_toggle_tool_button_new
import libgtk3.gtk_toggle_tool_button_set_active
import libgtk3.gtk_true

inline fun Container.toggleToolButton(init: ToggleToolButton.() -> Unit = {}): ToggleToolButton =
        ToggleToolButton().apply { init(); this@toggleToolButton.add(this) }

private fun ToggleToolButton_onToggled_Handler(sender: CPointer<in CPointed>?, _data:
        COpaquePointer?) {
    _data?.asStableRef<ToggleToolButton>()?.get()?.onToggled?.emit()
}

/**
 * A #GtkToggleToolButton is a #GtkToolItem that contains a toggle
 * button.
 *
 * Use gtk_toggle_tool_button_new() to create a new GtkToggleToolButton.
 *
 * # CSS nodes
 *
 * GtkToggleToolButton has a single CSS node with name togglebutton.
 */
@GtkDsl
open class ToggleToolButton internal constructor(override val widgetPtr: CPointer<GtkWidget>? =
        null) : ToolButton() {
    private val self: CPointer<GtkToggleToolButton>?
        get() = widgetPtr!!.reinterpret()

    val toggleToolButton: CPointer<GtkToggleToolButton>?
        get() = widgetPtr!!.reinterpret()

    val onToggled: Signal<ToggleToolButton, CFunction<(CPointer<in CPointed>?, COpaquePointer?) ->
            Unit>> by lazy { Signal<ToggleToolButton, CFunction<(CPointer<in CPointed>?,
            COpaquePointer?) -> Unit>>(widgetPtr!!, this, "toggled",
            staticCFunction(::ToggleToolButton_onToggled_Handler)) }

    /**
     * Queries a #GtkToggleToolButton and returns its current state.
     * Returns %TRUE if the toggle button is pressed in and %FALSE if it is raised.
     *
     * Sets the status of the toggle tool button. Set to %TRUE if you
     * want the GtkToggleButton to be “pressed in”, and %FALSE to raise it.
     * This action causes the toggled signal to be emitted. */
    var active: Boolean
        get() = gtk_toggle_tool_button_get_active(self) != 0
        set(value) {
            gtk_toggle_tool_button_set_active(self, if (value) gtk_true() else gtk_false())
        }

    /**
     * Returns a new #GtkToggleToolButton */
    constructor() : this(gtk_toggle_tool_button_new()?.reinterpret())
}

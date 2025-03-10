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
import libgtk3.GtkSwitch
import libgtk3.GtkWidget
import libgtk3.gtk_false
import libgtk3.gtk_switch_get_active
import libgtk3.gtk_switch_get_state
import libgtk3.gtk_switch_new
import libgtk3.gtk_switch_set_active
import libgtk3.gtk_switch_set_state
import libgtk3.gtk_true

inline fun Container.switch(init: Switch.() -> Unit = {}): Switch = Switch().apply { init();
        this@switch.add(this) }

private fun Switch_onActivate_Handler(sender: CPointer<in CPointed>?, _data: COpaquePointer?) {
    _data?.asStableRef<Switch>()?.get()?.onActivate?.emit()
}

private fun Switch_onStateSet_Handler(
    sender: CPointer<in CPointed>?,
    state: Boolean,
    _data: COpaquePointer?
) {
    _data?.asStableRef<Switch>()?.get()?.onStateSet?.emit(state)
}

/**
 * #GtkSwitch is a widget that has two states: on or off. The user can control
 * which state should be active by clicking the empty area, or by dragging the
 * handle.
 *
 * GtkSwitch can also handle situations where the underlying state changes with
 * a delay. See #GtkSwitch::state-set for details.
 *
 * # CSS nodes
 *
 * |[<!-- language="plain" -->
 * switch
 * ╰── slider
 * ]|
 *
 * GtkSwitch has two css nodes, the main node with the name switch and a subnode
 * named slider. Neither of them is using any style classes.
 */
@GtkDsl
open class Switch internal constructor(override val widgetPtr: CPointer<GtkWidget>? = null) :
        Widget() {
    private val self: CPointer<GtkSwitch>?
        get() = widgetPtr!!.reinterpret()

    val switch: CPointer<GtkSwitch>?
        get() = widgetPtr!!.reinterpret()

    val onActivate: Signal<Switch, CFunction<(CPointer<in CPointed>?, COpaquePointer?) -> Unit>> by
            lazy { Signal<Switch, CFunction<(CPointer<in CPointed>?, COpaquePointer?) ->
            Unit>>(widgetPtr!!, this, "activate", staticCFunction(::Switch_onActivate_Handler)) }

    val onStateSet: Signal1<Switch, Boolean, CFunction<(
        CPointer<in CPointed>?,
        Boolean,
        COpaquePointer?
    ) -> Unit>> by lazy { Signal1<Switch, Boolean, CFunction<(
                CPointer<in CPointed>?,
                Boolean,
                COpaquePointer?
            ) -> Unit>>(widgetPtr!!, this, "state-set",
                    staticCFunction(::Switch_onStateSet_Handler)) }

    /**
     * Gets whether the #GtkSwitch is in its “on” or “off” state.
     *
     * Changes the state of @sw to the desired one. */
    var active: Boolean
        get() = gtk_switch_get_active(self) != 0
        set(value) {
            gtk_switch_set_active(self, if (value) gtk_true() else gtk_false())
        }

    /**
     * Gets the underlying state of the #GtkSwitch.
     *
     * Sets the underlying state of the #GtkSwitch.
     *
     * Normally, this is the same as #GtkSwitch:active, unless the switch
     * is set up for delayed state changes. This function is typically
     * called from a #GtkSwitch::state-set signal handler.
     *
     * See #GtkSwitch::state-set for details. */
    var state: Boolean
        get() = gtk_switch_get_state(self) != 0
        set(value) {
            gtk_switch_set_state(self, if (value) gtk_true() else gtk_false())
        }

    /**
     * Creates a new #GtkSwitch widget. */
    constructor() : this(gtk_switch_new()?.reinterpret())
}

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
import libgtk3.GtkCheckMenuItem
import libgtk3.GtkWidget
import libgtk3.gtk_check_menu_item_get_active
import libgtk3.gtk_check_menu_item_get_draw_as_radio
import libgtk3.gtk_check_menu_item_get_inconsistent
import libgtk3.gtk_check_menu_item_new
import libgtk3.gtk_check_menu_item_set_active
import libgtk3.gtk_check_menu_item_set_draw_as_radio
import libgtk3.gtk_check_menu_item_set_inconsistent
import libgtk3.gtk_check_menu_item_toggled
import libgtk3.gtk_false
import libgtk3.gtk_true

inline fun Container.checkMenuItem(init: CheckMenuItem.() -> Unit = {}): CheckMenuItem =
        CheckMenuItem().apply { init(); this@checkMenuItem.add(this) }

private fun CheckMenuItem_onToggled_Handler(sender: CPointer<in CPointed>?, _data: COpaquePointer?)
        {
    _data?.asStableRef<CheckMenuItem>()?.get()?.onToggled?.emit()
}

/**
 * A #GtkCheckMenuItem is a menu item that maintains the state of a boolean
 * value in addition to a #GtkMenuItem usual role in activating application
 * code.
 *
 * A check box indicating the state of the boolean value is displayed
 * at the left side of the #GtkMenuItem.  Activating the #GtkMenuItem
 * toggles the value.
 *
 * # CSS nodes
 *
 * |[<!-- language="plain" -->
 * menuitem
 * ├── check.left
 * ╰── <child>
 * ]|
 *
 * GtkCheckMenuItem has a main CSS node with name menuitem, and a subnode
 * with name check, which gets the .left or .right style class.
 */
@GtkDsl
open class CheckMenuItem internal constructor(override val widgetPtr: CPointer<GtkWidget>? = null) :
        MenuItem() {
    private val self: CPointer<GtkCheckMenuItem>?
        get() = widgetPtr!!.reinterpret()

    val checkMenuItem: CPointer<GtkCheckMenuItem>?
        get() = widgetPtr!!.reinterpret()

    val onToggled: Signal<CheckMenuItem, CFunction<(CPointer<in CPointed>?, COpaquePointer?) ->
            Unit>> by lazy { Signal<CheckMenuItem, CFunction<(CPointer<in CPointed>?,
            COpaquePointer?) -> Unit>>(widgetPtr!!, this, "toggled",
            staticCFunction(::CheckMenuItem_onToggled_Handler)) }

    /**
     * Returns whether the check menu item is active. See
     * gtk_check_menu_item_set_active ().
     *
     * Sets the active state of the menu item’s check box. */
    var active: Boolean
        get() = gtk_check_menu_item_get_active(self) != 0
        set(value) {
            gtk_check_menu_item_set_active(self, if (value) gtk_true() else gtk_false())
        }

    /**
     * Returns whether @check_menu_item looks like a #GtkRadioMenuItem
     *
     * Sets whether @check_menu_item is drawn like a #GtkRadioMenuItem */
    var drawAsRadio: Boolean
        get() = gtk_check_menu_item_get_draw_as_radio(self) != 0
        set(value) {
            gtk_check_menu_item_set_draw_as_radio(self, if (value) gtk_true() else gtk_false())
        }

    /**
     * Retrieves the value set by gtk_check_menu_item_set_inconsistent().
     *
     * If the user has selected a range of elements (such as some text or
     * spreadsheet cells) that are affected by a boolean setting, and the
     * current values in that range are inconsistent, you may want to
     * display the check in an “in between” state. This function turns on
     * “in between” display.  Normally you would turn off the inconsistent
     * state again if the user explicitly selects a setting. This has to be
     * done manually, gtk_check_menu_item_set_inconsistent() only affects
     * visual appearance, it doesn’t affect the semantics of the widget. */
    var inconsistent: Boolean
        get() = gtk_check_menu_item_get_inconsistent(self) != 0
        set(value) {
            gtk_check_menu_item_set_inconsistent(self, if (value) gtk_true() else gtk_false())
        }

    /**
     * Creates a new #GtkCheckMenuItem. */
    constructor() : this(gtk_check_menu_item_new()?.reinterpret())

    /**
     * Emits the #GtkCheckMenuItem::toggled signal.
     */
    fun toggled(): Unit = gtk_check_menu_item_toggled(self)
}

package gtk3

import kotlin.Unit
import kotlinx.cinterop.CPointer
import kotlinx.cinterop.reinterpret
import libgtk3.GtkCheckButton
import libgtk3.GtkWidget
import libgtk3.gtk_check_button_new

inline fun Container.checkButton(init: CheckButton.() -> Unit = {}): CheckButton =
        CheckButton().apply { init(); this@checkButton.add(this) }

/**
 * A #GtkCheckButton places a discrete #GtkToggleButton next to a widget,
 * (usually a #GtkLabel). See the section on #GtkToggleButton widgets for
 * more information about toggle/check buttons.
 *
 * The important signal ( #GtkToggleButton::toggled ) is also inherited from
 * #GtkToggleButton.
 *
 * # CSS nodes
 *
 * |[<!-- language="plain" -->
 * checkbutton
 * ├── check
 * ╰── <child>
 * ]|
 *
 * A GtkCheckButton with indicator (see gtk_toggle_button_set_mode()) has a
 * main CSS node with name checkbutton and a subnode with name check.
 *
 * |[<!-- language="plain" -->
 * button.check
 * ├── check
 * ╰── <child>
 * ]|
 *
 * A GtkCheckButton without indicator changes the name of its main node
 * to button and adds a .check style class to it. The subnode is invisible
 * in this case.
 */
@GtkDsl
open class CheckButton internal constructor(override val widgetPtr: CPointer<GtkWidget>? = null) :
        ToggleButton() {
    private val self: CPointer<GtkCheckButton>?
        get() = widgetPtr!!.reinterpret()

    val checkButton: CPointer<GtkCheckButton>?
        get() = widgetPtr!!.reinterpret()

    /**
     * Creates a new #GtkCheckButton. */
    constructor() : this(gtk_check_button_new()?.reinterpret())
}

package gtk3

import kotlin.Unit
import kotlinx.cinterop.CPointer
import kotlinx.cinterop.reinterpret
import libgtk3.GtkStack
import libgtk3.GtkStackSwitcher
import libgtk3.GtkWidget
import libgtk3.gtk_stack_switcher_get_stack
import libgtk3.gtk_stack_switcher_new
import libgtk3.gtk_stack_switcher_set_stack

inline fun Container.stackSwitcher(init: StackSwitcher.() -> Unit = {}): StackSwitcher =
        StackSwitcher().apply { init(); this@stackSwitcher.add(this) }

/**
 * The GtkStackSwitcher widget acts as a controller for a
 * #GtkStack; it shows a row of buttons to switch between
 * the various pages of the associated stack widget.
 *
 * All the content for the buttons comes from the child properties
 * of the #GtkStack; the button visibility in a #GtkStackSwitcher
 * widget is controlled by the visibility of the child in the
 * #GtkStack.
 *
 * It is possible to associate multiple #GtkStackSwitcher widgets
 * with the same #GtkStack widget.
 *
 * The GtkStackSwitcher widget was added in 3.10.
 *
 * # CSS nodes
 *
 * GtkStackSwitcher has a single CSS node named stackswitcher and
 * style class .stack-switcher.
 *
 * When circumstances require it, GtkStackSwitcher adds the
 * .needs-attention style class to the widgets representing the
 * stack pages.
 */
@GtkDsl
open class StackSwitcher internal constructor(override val widgetPtr: CPointer<GtkWidget>? = null) :
        Box() {
    private val self: CPointer<GtkStackSwitcher>?
        get() = widgetPtr!!.reinterpret()

    val stackSwitcher: CPointer<GtkStackSwitcher>?
        get() = widgetPtr!!.reinterpret()

    /**
     * Retrieves the stack.
     * See gtk_stack_switcher_set_stack().
     *
     * Sets the stack to control. */
    var stack: CPointer<GtkStack>
        get() = gtk_stack_switcher_get_stack(self)!!.reinterpret()
        set(value) {
            gtk_stack_switcher_set_stack(self, value?.reinterpret())
        }

    /**
     * Create a new #GtkStackSwitcher. */
    constructor() : this(gtk_stack_switcher_new()?.reinterpret())
}

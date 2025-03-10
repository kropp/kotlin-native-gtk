package gtk3

import kotlin.Unit
import kotlinx.cinterop.CPointer
import kotlinx.cinterop.reinterpret
import libgtk3.GtkStack
import libgtk3.GtkStackSidebar
import libgtk3.GtkWidget
import libgtk3.gtk_stack_sidebar_get_stack
import libgtk3.gtk_stack_sidebar_new
import libgtk3.gtk_stack_sidebar_set_stack

inline fun Container.stackSidebar(init: StackSidebar.() -> Unit = {}): StackSidebar =
        StackSidebar().apply { init(); this@stackSidebar.add(this) }

/**
 * A GtkStackSidebar enables you to quickly and easily provide a
 * consistent "sidebar" object for your user interface.
 *
 * In order to use a GtkStackSidebar, you simply use a GtkStack to
 * organize your UI flow, and add the sidebar to your sidebar area. You
 * can use gtk_stack_sidebar_set_stack() to connect the #GtkStackSidebar
 * to the #GtkStack.
 *
 * # CSS nodes
 *
 * GtkStackSidebar has a single CSS node with name stacksidebar and
 * style class .sidebar.
 *
 * When circumstances require it, GtkStackSidebar adds the
 * .needs-attention style class to the widgets representing the stack
 * pages.
 */
@GtkDsl
open class StackSidebar internal constructor(override val widgetPtr: CPointer<GtkWidget>? = null) :
        Bin() {
    private val self: CPointer<GtkStackSidebar>?
        get() = widgetPtr!!.reinterpret()

    val stackSidebar: CPointer<GtkStackSidebar>?
        get() = widgetPtr!!.reinterpret()

    /**
     * Retrieves the stack.
     * See gtk_stack_sidebar_set_stack().
     *
     * Set the #GtkStack associated with this #GtkStackSidebar.
     *
     * The sidebar widget will automatically update according to the order
     * (packing) and items within the given #GtkStack. */
    var stack: CPointer<GtkStack>
        get() = gtk_stack_sidebar_get_stack(self)!!.reinterpret()
        set(value) {
            gtk_stack_sidebar_set_stack(self, value?.reinterpret())
        }

    /**
     * Creates a new sidebar. */
    constructor() : this(gtk_stack_sidebar_new()?.reinterpret())
}

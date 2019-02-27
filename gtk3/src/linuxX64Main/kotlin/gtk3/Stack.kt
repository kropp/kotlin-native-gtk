package gtk3

import kotlin.Boolean
import kotlin.String
import kotlin.UInt
import kotlin.Unit
import kotlinx.cinterop.CPointer
import kotlinx.cinterop.reinterpret
import kotlinx.cinterop.toKString
import libgtk3.GtkStack
import libgtk3.GtkStackTransitionType
import libgtk3.GtkWidget
import libgtk3.gtk_false
import libgtk3.gtk_stack_add_named
import libgtk3.gtk_stack_add_titled
import libgtk3.gtk_stack_get_child_by_name
import libgtk3.gtk_stack_get_hhomogeneous
import libgtk3.gtk_stack_get_homogeneous
import libgtk3.gtk_stack_get_interpolate_size
import libgtk3.gtk_stack_get_transition_duration
import libgtk3.gtk_stack_get_transition_running
import libgtk3.gtk_stack_get_transition_type
import libgtk3.gtk_stack_get_vhomogeneous
import libgtk3.gtk_stack_get_visible_child
import libgtk3.gtk_stack_get_visible_child_name
import libgtk3.gtk_stack_new
import libgtk3.gtk_stack_set_hhomogeneous
import libgtk3.gtk_stack_set_homogeneous
import libgtk3.gtk_stack_set_interpolate_size
import libgtk3.gtk_stack_set_transition_duration
import libgtk3.gtk_stack_set_transition_type
import libgtk3.gtk_stack_set_vhomogeneous
import libgtk3.gtk_stack_set_visible_child
import libgtk3.gtk_stack_set_visible_child_full
import libgtk3.gtk_stack_set_visible_child_name
import libgtk3.gtk_true

inline fun Container.stack(init: Stack.() -> Unit = {}): Stack = Stack().apply { init();
        this@stack.add(this) }

/**
 * The GtkStack widget is a container which only shows
 * one of its children at a time. In contrast to GtkNotebook,
 * GtkStack does not provide a means for users to change the
 * visible child. Instead, the #GtkStackSwitcher widget can be
 * used with GtkStack to provide this functionality.
 *
 * Transitions between pages can be animated as slides or
 * fades. This can be controlled with gtk_stack_set_transition_type().
 * These animations respect the #GtkSettings:gtk-enable-animations
 * setting.
 *
 * The GtkStack widget was added in GTK+ 3.10.
 *
 * # CSS nodes
 *
 * GtkStack has a single CSS node named stack.Returns whether the @stack is currently in a
        transition from one page to
 * another.
 */
@GtkDsl
open class Stack internal constructor(override val widgetPtr: CPointer<GtkWidget>? = null) :
        Container() {
    private val self: CPointer<GtkStack>?
        get() = widgetPtr!!.reinterpret()

    val stack: CPointer<GtkStack>?
        get() = widgetPtr!!.reinterpret()

    /**
     * Gets whether @stack is horizontally homogeneous.
     * See gtk_stack_set_hhomogeneous().
     *
     * Sets the #GtkStack to be horizontally homogeneous or not.
     * If it is homogeneous, the #GtkStack will request the same
     * width for all its children. If it isn't, the stack
     * may change width when a different child becomes visible. */
    var hhomogeneous: Boolean
        get() = gtk_stack_get_hhomogeneous(self) != 0
        set(value) {
            gtk_stack_set_hhomogeneous(self, if (value) gtk_true() else gtk_false())
        }

    /**
     * Gets whether @stack is homogeneous.
     * See gtk_stack_set_homogeneous().
     *
     * Sets the #GtkStack to be homogeneous or not. If it
     * is homogeneous, the #GtkStack will request the same
     * size for all its children. If it isn't, the stack
     * may change size when a different child becomes visible.
     *
     * Since 3.16, homogeneity can be controlled separately
     * for horizontal and vertical size, with the
     * #GtkStack:hhomogeneous and #GtkStack:vhomogeneous. */
    var homogeneous: Boolean
        get() = gtk_stack_get_homogeneous(self) != 0
        set(value) {
            gtk_stack_set_homogeneous(self, if (value) gtk_true() else gtk_false())
        }

    /**
     * Returns wether the #GtkStack is set up to interpolate between
     * the sizes of children on page switch.
     *
     * Sets whether or not @stack will interpolate its size when
     * changing the visible child. If the #GtkStack:interpolate-size
     * property is set to %TRUE, @stack will interpolate its size between
     * the current one and the one it'll take after changing the
     * visible child, according to the set transition duration. */
    var interpolateSize: Boolean
        get() = gtk_stack_get_interpolate_size(self) != 0
        set(value) {
            gtk_stack_set_interpolate_size(self, if (value) gtk_true() else gtk_false())
        }

    /**
     * Returns the amount of time (in milliseconds) that
     * transitions between pages in @stack will take.
     *
     * Sets the duration that transitions between pages in @stack
     * will take. */
    var transitionDuration: UInt
        get() = gtk_stack_get_transition_duration(self)
        set(value) {
            gtk_stack_set_transition_duration(self, value)
        }

    val transitionRunning: Boolean
        get() = gtk_stack_get_transition_running(self) != 0

    /**
     * Gets the type of animation that will be used
     * for transitions between pages in @stack.
     *
     * Sets the type of animation that will be used for
     * transitions between pages in @stack. Available
     * types include various kinds of fades and slides.
     *
     * The transition type can be changed without problems
     * at runtime, so it is possible to change the animation
     * based on the page that is about to become current. */
    var transitionType: GtkStackTransitionType
        get() = gtk_stack_get_transition_type(self)
        set(value) {
            gtk_stack_set_transition_type(self, value)
        }

    /**
     * Gets whether @stack is vertically homogeneous.
     * See gtk_stack_set_vhomogeneous().
     *
     * Sets the #GtkStack to be vertically homogeneous or not.
     * If it is homogeneous, the #GtkStack will request the same
     * height for all its children. If it isn't, the stack
     * may change height when a different child becomes visible. */
    var vhomogeneous: Boolean
        get() = gtk_stack_get_vhomogeneous(self) != 0
        set(value) {
            gtk_stack_set_vhomogeneous(self, if (value) gtk_true() else gtk_false())
        }

    /**
     * Gets the currently visible child of @stack, or %NULL if
     * there are no visible children.
     *
     * Makes @child the visible child of @stack.
     *
     * If @child is different from the currently
     * visible child, the transition between the
     * two will be animated with the current
     * transition type of @stack.
     *
     * Note that the @child widget has to be visible itself
     * (see gtk_widget_show()) in order to become the visible
     * child of @stack. */
    var visibleChild: CPointer<GtkWidget>
        get() = gtk_stack_get_visible_child(self)!!.reinterpret()
        set(value) {
            gtk_stack_set_visible_child(self, value?.reinterpret())
        }

    /**
     * Returns the name of the currently visible child of @stack, or
     * %NULL if there is no visible child.
     *
     * Makes the child with the given name visible.
     *
     * If @child is different from the currently
     * visible child, the transition between the
     * two will be animated with the current
     * transition type of @stack.
     *
     * Note that the child widget has to be visible itself
     * (see gtk_widget_show()) in order to become the visible
     * child of @stack. */
    var visibleChildName: String
        get() = gtk_stack_get_visible_child_name(self)?.toKString() ?: ""
        set(value) {
            gtk_stack_set_visible_child_name(self, value)
        }

    /**
     * Creates a new #GtkStack container. */
    constructor() : this(gtk_stack_new()?.reinterpret())

    /**
     * Adds a child to @stack.
     * The child is identified by the @name.
     */
    fun addNamed(child: CPointer<GtkWidget>, name: String): Unit = gtk_stack_add_named(self, child,
            name)

    /**
     * Adds a child to @stack.
     * The child is identified by the @name.
     */
    fun addNamed(child: Widget, name: String): Unit = gtk_stack_add_named(self,
            child.widgetPtr?.reinterpret(), name)

    /**
     * Adds a child to @stack.
     * The child is identified by the @name. The @title
     * will be used by #GtkStackSwitcher to represent
     * @child in a tab bar, so it should be short.
     */
    fun addTitled(
        child: CPointer<GtkWidget>,
        name: String,
        title: String
    ): Unit = gtk_stack_add_titled(self, child, name, title)

    /**
     * Adds a child to @stack.
     * The child is identified by the @name. The @title
     * will be used by #GtkStackSwitcher to represent
     * @child in a tab bar, so it should be short.
     */
    fun addTitled(
        child: Widget,
        name: String,
        title: String
    ): Unit = gtk_stack_add_titled(self, child.widgetPtr?.reinterpret(), name, title)

    /**
     * Finds the child of the #GtkStack with the name given as
     * the argument. Returns %NULL if there is no child with this
     * name.
     */
    fun getChildByName(name: String): CPointer<GtkWidget> = gtk_stack_get_child_by_name(self,
            name)!!.reinterpret()

    /**
     * Makes the child with the given name visible.
     *
     * Note that the child widget has to be visible itself
     * (see gtk_widget_show()) in order to become the visible
     * child of @stack.
     */
    fun setVisibleChildFull(name: String, transition: GtkStackTransitionType): Unit =
            gtk_stack_set_visible_child_full(self, name, transition)
}

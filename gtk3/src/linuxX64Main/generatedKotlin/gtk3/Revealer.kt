package gtk3

import kotlin.Boolean
import kotlin.UInt
import kotlin.Unit
import kotlinx.cinterop.CPointer
import kotlinx.cinterop.reinterpret
import libgtk3.GtkRevealer
import libgtk3.GtkRevealerTransitionType
import libgtk3.GtkWidget
import libgtk3.gtk_false
import libgtk3.gtk_revealer_get_child_revealed
import libgtk3.gtk_revealer_get_reveal_child
import libgtk3.gtk_revealer_get_transition_duration
import libgtk3.gtk_revealer_get_transition_type
import libgtk3.gtk_revealer_new
import libgtk3.gtk_revealer_set_reveal_child
import libgtk3.gtk_revealer_set_transition_duration
import libgtk3.gtk_revealer_set_transition_type
import libgtk3.gtk_true

inline fun Container.revealer(init: Revealer.() -> Unit = {}): Revealer = Revealer().apply { init();
        this@revealer.add(this) }

/**
 * The GtkRevealer widget is a container which animates
 * the transition of its child from invisible to visible.
 *
 * The style of transition can be controlled with
 * gtk_revealer_set_transition_type().
 *
 * These animations respect the #GtkSettings:gtk-enable-animations
 * setting.
 *
 * # CSS nodes
 *
 * GtkRevealer has a single CSS node with name revealer.
 *
 * The GtkRevealer widget was added in GTK+ 3.10.Returns whether the child is fully revealed, in
        other words whether
 * the transition to the revealed state is completed.
 */
@GtkDsl
open class Revealer internal constructor(override val widgetPtr: CPointer<GtkWidget>? = null) :
        Bin() {
    private val self: CPointer<GtkRevealer>?
        get() = widgetPtr!!.reinterpret()

    val revealer: CPointer<GtkRevealer>?
        get() = widgetPtr!!.reinterpret()

    val childRevealed: Boolean
        get() = gtk_revealer_get_child_revealed(self) != 0

    /**
     * Returns whether the child is currently
     * revealed. See gtk_revealer_set_reveal_child().
     *
     * This function returns %TRUE as soon as the transition
     * is to the revealed state is started. To learn whether
     * the child is fully revealed (ie the transition is completed),
     * use gtk_revealer_get_child_revealed().
     *
     * Tells the #GtkRevealer to reveal or conceal its child.
     *
     * The transition will be animated with the current
     * transition type of @revealer. */
    var revealChild: Boolean
        get() = gtk_revealer_get_reveal_child(self) != 0
        set(value) {
            gtk_revealer_set_reveal_child(self, if (value) gtk_true() else gtk_false())
        }

    /**
     * Returns the amount of time (in milliseconds) that
     * transitions will take.
     *
     * Sets the duration that transitions will take. */
    var transitionDuration: UInt
        get() = gtk_revealer_get_transition_duration(self)
        set(value) {
            gtk_revealer_set_transition_duration(self, value)
        }

    /**
     * Gets the type of animation that will be used
     * for transitions in @revealer.
     *
     * Sets the type of animation that will be used for
     * transitions in @revealer. Available types include
     * various kinds of fades and slides. */
    var transitionType: GtkRevealerTransitionType
        get() = gtk_revealer_get_transition_type(self)
        set(value) {
            gtk_revealer_set_transition_type(self, value)
        }

    /**
     * Creates a new #GtkRevealer. */
    constructor() : this(gtk_revealer_new()?.reinterpret())
}

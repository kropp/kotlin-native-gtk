package gtk3

import kotlin.Boolean
import kotlin.Int
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

inline fun Container.revealer(init: Revealer.() -> Unit = {}): Revealer = Revealer().apply { init(); this@revealer.add(this) }

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
 * The GtkRevealer widget was added in GTK+ 3.10. */
@GtkDsl
open class Revealer internal constructor(override val widgetPtr: CPointer<GtkWidget>? = null) : Bin() {
    private val self: CPointer<GtkRevealer>?
        get() = widgetPtr!!.reinterpret()

    val revealer: CPointer<GtkRevealer>?
        get() = widgetPtr!!.reinterpret()

    val childRevealed: Boolean
        /**
         * Returns whether the child is fully revealed, in other words whether
         * the transition to the revealed state is completed. */
        get() = gtk_revealer_get_child_revealed(self) != 0

    var revealChild: Boolean
        /**
         * Returns whether the child is currently
         * revealed. See gtk_revealer_set_reveal_child().
         *
         * This function returns %TRUE as soon as the transition
         * is to the revealed state is started. To learn whether
         * the child is fully revealed (ie the transition is completed),
         * use gtk_revealer_get_child_revealed(). */
        get() = gtk_revealer_get_reveal_child(self) != 0
        /**
         * Tells the #GtkRevealer to reveal or conceal its child.
         *
         * The transition will be animated with the current
         * transition type of @revealer. */
        set(value) {
            gtk_revealer_set_reveal_child(self, if (value) gtk_true() else gtk_false())
        }

    var transitionDuration: Int
        /**
         * Returns the amount of time (in milliseconds) that
         * transitions will take. */
        get() = gtk_revealer_get_transition_duration(self)
        /**
         * Sets the duration that transitions will take. */
        set(value) {
            gtk_revealer_set_transition_duration(self, value)
        }

    var transitionType: GtkRevealerTransitionType
        /**
         * Gets the type of animation that will be used
         * for transitions in @revealer. */
        get() = gtk_revealer_get_transition_type(self)
        /**
         * Sets the type of animation that will be used for
         * transitions in @revealer. Available types include
         * various kinds of fades and slides. */
        set(value) {
            gtk_revealer_set_transition_type(self, value)
        }

    /**
     * Creates a new #GtkRevealer. */
    constructor() : this(gtk_revealer_new()?.reinterpret())
}

package gtk3

import kotlin.Boolean
import kotlin.Unit
import kotlinx.cinterop.CPointer
import kotlinx.cinterop.reinterpret
import libgtk3.GtkEventBox
import libgtk3.GtkWidget
import libgtk3.gtk_event_box_get_above_child
import libgtk3.gtk_event_box_get_visible_window
import libgtk3.gtk_event_box_new
import libgtk3.gtk_event_box_set_above_child
import libgtk3.gtk_event_box_set_visible_window
import libgtk3.gtk_false
import libgtk3.gtk_true

inline fun Container.eventBox(init: EventBox.() -> Unit = {}): EventBox = EventBox().apply { init();
        this@eventBox.add(this) }

/**
 * The #GtkEventBox widget is a subclass of #GtkBin which also has its
 * own window. It is useful since it allows you to catch events for widgets
 * which do not have their own window.
 */
@GtkDsl
open class EventBox internal constructor(override val widgetPtr: CPointer<GtkWidget>? = null) :
        Bin() {
    private val self: CPointer<GtkEventBox>?
        get() = widgetPtr!!.reinterpret()

    val eventBox: CPointer<GtkEventBox>?
        get() = widgetPtr!!.reinterpret()

    /**
     * Returns whether the event box window is above or below the
     * windows of its child. See gtk_event_box_set_above_child()
     * for details.
     *
     * Set whether the event box window is positioned above the windows
     * of its child, as opposed to below it. If the window is above, all
     * events inside the event box will go to the event box. If the window
     * is below, events in windows of child widgets will first got to that
     * widget, and then to its parents.
     *
     * The default is to keep the window below the child. */
    var aboveChild: Boolean
        get() = gtk_event_box_get_above_child(self) != 0
        set(value) {
            gtk_event_box_set_above_child(self, if (value) gtk_true() else gtk_false())
        }

    /**
     * Returns whether the event box has a visible window.
     * See gtk_event_box_set_visible_window() for details.
     *
     * Set whether the event box uses a visible or invisible child
     * window. The default is to use visible windows.
     *
     * In an invisible window event box, the window that the
     * event box creates is a %GDK_INPUT_ONLY window, which
     * means that it is invisible and only serves to receive
     * events.
     *
     * A visible window event box creates a visible (%GDK_INPUT_OUTPUT)
     * window that acts as the parent window for all the widgets
     * contained in the event box.
     *
     * You should generally make your event box invisible if
     * you just want to trap events. Creating a visible window
     * may cause artifacts that are visible to the user, especially
     * if the user is using a theme with gradients or pixmaps.
     *
     * The main reason to create a non input-only event box is if
     * you want to set the background to a different color or
     * draw on it.
     *
     * There is one unexpected issue for an invisible event box that has its
     * window below the child. (See gtk_event_box_set_above_child().)
     * Since the input-only window is not an ancestor window of any windows
     * that descendent widgets of the event box create, events on these
     * windows aren’t propagated up by the windowing system, but only by GTK+.
     * The practical effect of this is if an event isn’t in the event
     * mask for the descendant window (see gtk_widget_add_events()),
     * it won’t be received by the event box.
     *
     * This problem doesn’t occur for visible event boxes, because in
     * that case, the event box window is actually the ancestor of the
     * descendant windows, not just at the same place on the screen. */
    var visibleWindow: Boolean
        get() = gtk_event_box_get_visible_window(self) != 0
        set(value) {
            gtk_event_box_set_visible_window(self, if (value) gtk_true() else gtk_false())
        }

    /**
     * Creates a new #GtkEventBox. */
    constructor() : this(gtk_event_box_new()?.reinterpret())
}

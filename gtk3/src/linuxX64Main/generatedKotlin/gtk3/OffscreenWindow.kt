package gtk3

import kotlin.Unit
import kotlinx.cinterop.CPointer
import kotlinx.cinterop.reinterpret
import libgtk3.GdkPixbuf
import libgtk3.GtkOffscreenWindow
import libgtk3.GtkWidget
import libgtk3.gtk_offscreen_window_get_pixbuf
import libgtk3.gtk_offscreen_window_new

inline fun Container.offscreenWindow(init: OffscreenWindow.() -> Unit = {}): OffscreenWindow =
        OffscreenWindow().apply { init(); this@offscreenWindow.add(this) }

/**
 * GtkOffscreenWindow is strictly intended to be used for obtaining
 * snapshots of widgets that are not part of a normal widget hierarchy.
 * Since #GtkOffscreenWindow is a toplevel widget you cannot obtain
 * snapshots of a full window with it since you cannot pack a toplevel
 * widget in another toplevel.
 *
 * The idea is to take a widget and manually set the state of it,
 * add it to a GtkOffscreenWindow and then retrieve the snapshot
 * as a #cairo_surface_t or #GdkPixbuf.
 *
 * GtkOffscreenWindow derives from #GtkWindow only as an implementation
 * detail.  Applications should not use any API specific to #GtkWindow
 * to operate on this object.  It should be treated as a #GtkBin that
 * has no parent widget.
 *
 * When contained offscreen widgets are redrawn, GtkOffscreenWindow
 * will emit a #GtkWidget::damage-event signal.Retrieves a snapshot of the contained widget in the
        form of
 * a #GdkPixbuf.  This is a new pixbuf with a reference count of 1,
 * and the application should unreference it once it is no longer
 * needed.
 */
@GtkDsl
open class OffscreenWindow internal constructor(override val widgetPtr: CPointer<GtkWidget>? = null)
        : Window() {
    private val self: CPointer<GtkOffscreenWindow>?
        get() = widgetPtr!!.reinterpret()

    val offscreenWindow: CPointer<GtkOffscreenWindow>?
        get() = widgetPtr!!.reinterpret()

    val pixbuf: CPointer<GdkPixbuf>
        get() = gtk_offscreen_window_get_pixbuf(self)!!.reinterpret()

    /**
     * Creates a toplevel container widget that is used to retrieve
     * snapshots of widgets without showing them on the screen. */
    constructor() : this(gtk_offscreen_window_new()?.reinterpret())
}

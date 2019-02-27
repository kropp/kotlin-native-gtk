package gtk3

import kotlin.Unit
import kotlinx.cinterop.CPointer
import kotlinx.cinterop.reinterpret
import libgtk3.GtkSpinner
import libgtk3.GtkWidget
import libgtk3.gtk_spinner_new
import libgtk3.gtk_spinner_start
import libgtk3.gtk_spinner_stop

inline fun Container.spinner(init: Spinner.() -> Unit = {}): Spinner = Spinner().apply { init();
        this@spinner.add(this) }

/**
 * A GtkSpinner widget displays an icon-size spinning animation.
 * It is often used as an alternative to a #GtkProgressBar for
 * displaying indefinite activity, instead of actual progress.
 *
 * To start the animation, use gtk_spinner_start(), to stop it
 * use gtk_spinner_stop().
 *
 * # CSS nodes
 *
 * GtkSpinner has a single CSS node with the name spinner. When the animation is
 * active, the :checked pseudoclass is added to this node.
 */
@GtkDsl
open class Spinner internal constructor(override val widgetPtr: CPointer<GtkWidget>? = null) :
        Widget() {
    private val self: CPointer<GtkSpinner>?
        get() = widgetPtr!!.reinterpret()

    val spinner: CPointer<GtkSpinner>?
        get() = widgetPtr!!.reinterpret()

    /**
     * Returns a new spinner widget. Not yet started. */
    constructor() : this(gtk_spinner_new()?.reinterpret())

    /**
     * Starts the animation of the spinner.
     */
    fun start(): Unit = gtk_spinner_start(self)

    /**
     * Stops the animation of the spinner.
     */
    fun stop(): Unit = gtk_spinner_stop(self)
}

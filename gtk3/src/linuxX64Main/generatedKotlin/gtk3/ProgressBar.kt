package gtk3

import kotlin.Boolean
import kotlin.Double
import kotlin.String
import kotlin.Unit
import kotlinx.cinterop.CPointer
import kotlinx.cinterop.reinterpret
import kotlinx.cinterop.toKString
import libgtk3.GtkProgressBar
import libgtk3.GtkWidget
import libgtk3.gtk_false
import libgtk3.gtk_progress_bar_get_fraction
import libgtk3.gtk_progress_bar_get_inverted
import libgtk3.gtk_progress_bar_get_pulse_step
import libgtk3.gtk_progress_bar_get_show_text
import libgtk3.gtk_progress_bar_get_text
import libgtk3.gtk_progress_bar_new
import libgtk3.gtk_progress_bar_pulse
import libgtk3.gtk_progress_bar_set_fraction
import libgtk3.gtk_progress_bar_set_inverted
import libgtk3.gtk_progress_bar_set_pulse_step
import libgtk3.gtk_progress_bar_set_show_text
import libgtk3.gtk_progress_bar_set_text
import libgtk3.gtk_true

inline fun Container.progressBar(init: ProgressBar.() -> Unit = {}): ProgressBar =
        ProgressBar().apply { init(); this@progressBar.add(this) }

/**
 * The #GtkProgressBar is typically used to display the progress of a long
 * running operation. It provides a visual clue that processing is underway.
 * The GtkProgressBar can be used in two different modes: percentage mode
 * and activity mode.
 *
 * When an application can determine how much work needs to take place
 * (e.g. read a fixed number of bytes from a file) and can monitor its
 * progress, it can use the GtkProgressBar in percentage mode and the
 * user sees a growing bar indicating the percentage of the work that
 * has been completed. In this mode, the application is required to call
 * gtk_progress_bar_set_fraction() periodically to update the progress bar.
 *
 * When an application has no accurate way of knowing the amount of work
 * to do, it can use the #GtkProgressBar in activity mode, which shows
 * activity by a block moving back and forth within the progress area. In
 * this mode, the application is required to call gtk_progress_bar_pulse()
 * periodically to update the progress bar.
 *
 * There is quite a bit of flexibility provided to control the appearance
 * of the #GtkProgressBar. Functions are provided to control the orientation
 * of the bar, optional text can be displayed along with the bar, and the
 * step size used in activity mode can be set.
 *
 * # CSS nodes
 *
 * |[<!-- language="plain" -->
 * progressbar[.osd]
 * ├── [text]
 * ╰── trough[.empty][.full]
 *     ╰── progress[.pulse]
 * ]|
 *
 * GtkProgressBar has a main CSS node with name progressbar and subnodes with
 * names text and trough, of which the latter has a subnode named progress. The
 * text subnode is only present if text is shown. The progress subnode has the
 * style class .pulse when in activity mode. It gets the style classes .left,
 * .right, .top or .bottom added when the progress 'touches' the corresponding
 * end of the GtkProgressBar. The .osd class on the progressbar node is for use
 * in overlays like the one Epiphany has for page loading progress.
 */
@GtkDsl
open class ProgressBar internal constructor(override val widgetPtr: CPointer<GtkWidget>? = null) :
        Widget() {
    private val self: CPointer<GtkProgressBar>?
        get() = widgetPtr!!.reinterpret()

    val progressBar: CPointer<GtkProgressBar>?
        get() = widgetPtr!!.reinterpret()

    /**
     * Returns the current fraction of the task that’s been completed.
     *
     * Causes the progress bar to “fill in” the given fraction
     * of the bar. The fraction should be between 0.0 and 1.0,
     * inclusive. */
    var fraction: Double
        get() = gtk_progress_bar_get_fraction(self)
        set(value) {
            gtk_progress_bar_set_fraction(self, value)
        }

    /**
     * Gets the value set by gtk_progress_bar_set_inverted().
     *
     * Progress bars normally grow from top to bottom or left to right.
     * Inverted progress bars grow in the opposite direction. */
    var inverted: Boolean
        get() = gtk_progress_bar_get_inverted(self) != 0
        set(value) {
            gtk_progress_bar_set_inverted(self, if (value) gtk_true() else gtk_false())
        }

    /**
     * Retrieves the pulse step set with gtk_progress_bar_set_pulse_step().
     *
     * Sets the fraction of total progress bar length to move the
     * bouncing block for each call to gtk_progress_bar_pulse(). */
    var pulseStep: Double
        get() = gtk_progress_bar_get_pulse_step(self)
        set(value) {
            gtk_progress_bar_set_pulse_step(self, value)
        }

    /**
     * Gets the value of the #GtkProgressBar:show-text property.
     * See gtk_progress_bar_set_show_text().
     *
     * Sets whether the progress bar will show text next to the bar.
     * The shown text is either the value of the #GtkProgressBar:text
     * property or, if that is %NULL, the #GtkProgressBar:fraction value,
     * as a percentage.
     *
     * To make a progress bar that is styled and sized suitably for containing
     * text (even if the actual text is blank), set #GtkProgressBar:show-text to
     * %TRUE and #GtkProgressBar:text to the empty string (not %NULL). */
    var showText: Boolean
        get() = gtk_progress_bar_get_show_text(self) != 0
        set(value) {
            gtk_progress_bar_set_show_text(self, if (value) gtk_true() else gtk_false())
        }

    /**
     * Retrieves the text that is displayed with the progress bar,
     * if any, otherwise %NULL. The return value is a reference
     * to the text, not a copy of it, so will become invalid
     * if you change the text in the progress bar.
     *
     * Causes the given @text to appear next to the progress bar.
     *
     * If @text is %NULL and #GtkProgressBar:show-text is %TRUE, the current
     * value of #GtkProgressBar:fraction will be displayed as a percentage.
     *
     * If @text is non-%NULL and #GtkProgressBar:show-text is %TRUE, the text
     * will be displayed. In this case, it will not display the progress
     * percentage. If @text is the empty string, the progress bar will still
     * be styled and sized suitably for containing text, as long as
     * #GtkProgressBar:show-text is %TRUE. */
    var text: String
        get() = gtk_progress_bar_get_text(self)?.toKString() ?: ""
        set(value) {
            gtk_progress_bar_set_text(self, value)
        }

    /**
     * Creates a new #GtkProgressBar. */
    constructor() : this(gtk_progress_bar_new()?.reinterpret())

    /**
     * Indicates that some progress has been made, but you don’t know how much.
     * Causes the progress bar to enter “activity mode,” where a block
     * bounces back and forth. Each call to gtk_progress_bar_pulse()
     * causes the block to move by a little bit (the amount of movement
     * per pulse is determined by gtk_progress_bar_set_pulse_step()).
     */
    fun pulse(): Unit = gtk_progress_bar_pulse(self)
}

package gtk3

import kotlin.Boolean
import kotlin.Float
import kotlin.String
import kotlin.Unit
import kotlinx.cinterop.CPointer
import kotlinx.cinterop.reinterpret
import libgtk3.GtkAspectFrame
import libgtk3.GtkWidget
import libgtk3.gtk_aspect_frame_new
import libgtk3.gtk_aspect_frame_set
import libgtk3.gtk_false
import libgtk3.gtk_true

inline fun Container.aspectFrame(
    label: String,
    xalign: Float,
    yalign: Float,
    ratio: Float,
    obey_child: Boolean,
    init: AspectFrame.() -> Unit = {}
): AspectFrame = AspectFrame(label, xalign, yalign, ratio, obey_child).apply { init();
        this@aspectFrame.add(this) }

/**
 * The #GtkAspectFrame is useful when you want
 * pack a widget so that it can resize but always retains
 * the same aspect ratio. For instance, one might be
 * drawing a small preview of a larger image. #GtkAspectFrame
 * derives from #GtkFrame, so it can draw a label and
 * a frame around the child. The frame will be
 * “shrink-wrapped” to the size of the child.
 *
 * # CSS nodes
 *
 * GtkAspectFrame uses a CSS node with name frame.
 */
@GtkDsl
open class AspectFrame internal constructor(override val widgetPtr: CPointer<GtkWidget>? = null) :
        Frame() {
    private val self: CPointer<GtkAspectFrame>?
        get() = widgetPtr!!.reinterpret()

    val aspectFrame: CPointer<GtkAspectFrame>?
        get() = widgetPtr!!.reinterpret()

    /**
     * Create a new #GtkAspectFrame. */
    constructor(
        label: String,
        xalign: Float,
        yalign: Float,
        ratio: Float,
        obey_child: Boolean
    ) : this(gtk_aspect_frame_new(label, xalign, yalign, ratio,
            if (obey_child) gtk_true() else gtk_false())?.reinterpret())

    /**
     * Set parameters for an existing #GtkAspectFrame.
     */
    fun set(
        xalign: Float,
        yalign: Float,
        ratio: Float,
        obey_child: Boolean
    ): Unit = gtk_aspect_frame_set(self, xalign, yalign, ratio,
            if (obey_child) gtk_true() else gtk_false())
}

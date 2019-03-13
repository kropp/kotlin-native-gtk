@file:Suppress("unused")

package gtk3

import kotlin.ExperimentalUnsignedTypes
import kotlin.Suppress
import kotlin.Unit
import kotlinx.cinterop.CPointer
import kotlinx.cinterop.reinterpret
import libgtk3.GtkAdjustment
import libgtk3.GtkOrientation
import libgtk3.GtkScrollbar
import libgtk3.GtkWidget
import libgtk3.gtk_scrollbar_new

@ExperimentalUnsignedTypes
inline fun Container.scrollbar(
    orientation: GtkOrientation,
    adjustment: CPointer<GtkAdjustment>,
    init: Scrollbar.() -> Unit = {}
): Scrollbar = Scrollbar(orientation, adjustment).apply { init(); this@scrollbar.add(this) }

@GtkDsl
@ExperimentalUnsignedTypes
open class Scrollbar internal constructor(override val widgetPtr: CPointer<GtkWidget>? = null) :
        Range() {
    private val self: CPointer<GtkScrollbar>?
        get() = widgetPtr!!.reinterpret()

    val scrollbar: CPointer<GtkScrollbar>?
        get() = widgetPtr!!.reinterpret()

    /**
     * Creates a new scrollbar with the given orientation. */
    constructor(orientation: GtkOrientation, adjustment: CPointer<GtkAdjustment>) :
            this(gtk_scrollbar_new(orientation, adjustment?.reinterpret())?.reinterpret())
}

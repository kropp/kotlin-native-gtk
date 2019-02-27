package gtk3

import kotlin.Unit
import kotlinx.cinterop.CPointer
import kotlinx.cinterop.reinterpret
import libgtk3.GtkRecentChooserWidget
import libgtk3.GtkWidget
import libgtk3.gtk_recent_chooser_widget_new

inline fun Container.recentChooserWidget(init: RecentChooserWidget.() -> Unit = {}):
        RecentChooserWidget = RecentChooserWidget().apply { init();
        this@recentChooserWidget.add(this) }

/**
 * #GtkRecentChooserWidget is a widget suitable for selecting recently used
 * files.  It is the main building block of a #GtkRecentChooserDialog.  Most
 * applications will only need to use the latter; you can use
 * #GtkRecentChooserWidget as part of a larger window if you have special needs.
 *
 * Note that #GtkRecentChooserWidget does not have any methods of its own.
 * Instead, you should use the functions that work on a #GtkRecentChooser.
 *
 * Recently used files are supported since GTK+ 2.10.
 */
@GtkDsl
open class RecentChooserWidget internal constructor(override val widgetPtr: CPointer<GtkWidget>? =
        null) : Box() {
    private val self: CPointer<GtkRecentChooserWidget>?
        get() = widgetPtr!!.reinterpret()

    val recentChooserWidget: CPointer<GtkRecentChooserWidget>?
        get() = widgetPtr!!.reinterpret()

    /**
     * Creates a new #GtkRecentChooserWidget object.  This is an embeddable widget
     * used to access the recently used resources list. */
    constructor() : this(gtk_recent_chooser_widget_new()?.reinterpret())
}

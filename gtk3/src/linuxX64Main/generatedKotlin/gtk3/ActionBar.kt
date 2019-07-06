package gtk3

import kotlin.Unit
import kotlinx.cinterop.CPointer
import kotlinx.cinterop.reinterpret
import libgtk3.GtkActionBar
import libgtk3.GtkWidget
import libgtk3.gtk_action_bar_get_center_widget
import libgtk3.gtk_action_bar_new
import libgtk3.gtk_action_bar_pack_end
import libgtk3.gtk_action_bar_pack_start
import libgtk3.gtk_action_bar_set_center_widget

inline fun Container.actionBar(init: ActionBar.() -> Unit = {}): ActionBar =
        ActionBar().apply { init(); this@actionBar.add(this) }

/**
 * GtkActionBar is designed to present contextual actions. It is
 * expected to be displayed below the content and expand horizontally
 * to fill the area.
 *
 * It allows placing children at the start or the end. In addition, it
 * contains an internal centered box which is centered with respect to
 * the full width of the box, even if the children at either side take
 * up different amounts of space.
 *
 * # CSS nodes
 *
 * GtkActionBar has a single CSS node with name actionbar.
 */
@GtkDsl
open class ActionBar internal constructor(override val widgetPtr: CPointer<GtkWidget>? = null) :
        Bin() {
    private val self: CPointer<GtkActionBar>?
        get() = widgetPtr!!.reinterpret()

    val actionBar: CPointer<GtkActionBar>?
        get() = widgetPtr!!.reinterpret()

    /**
     * Retrieves the center bar widget of the bar.
     *
     * Sets the center widget for the #GtkActionBar. */
    var centerWidget: CPointer<GtkWidget>
        get() = gtk_action_bar_get_center_widget(self)!!.reinterpret()
        set(value) {
            gtk_action_bar_set_center_widget(self, value?.reinterpret())
        }

    /**
     * Creates a new #GtkActionBar widget. */
    constructor() : this(gtk_action_bar_new()?.reinterpret())

    /**
     * Adds @child to @action_bar, packed with reference to the
     * end of the @action_bar.
     */
    fun packEnd(child: CPointer<GtkWidget>): Unit = gtk_action_bar_pack_end(self, child)

    /**
     * Adds @child to @action_bar, packed with reference to the
     * end of the @action_bar.
     */
    fun packEnd(child: Widget): Unit = gtk_action_bar_pack_end(self, child.widgetPtr?.reinterpret())

    /**
     * Adds @child to @action_bar, packed with reference to the
     * start of the @action_bar.
     */
    fun packStart(child: CPointer<GtkWidget>): Unit = gtk_action_bar_pack_start(self, child)

    /**
     * Adds @child to @action_bar, packed with reference to the
     * start of the @action_bar.
     */
    fun packStart(child: Widget): Unit = gtk_action_bar_pack_start(self,
            child.widgetPtr?.reinterpret())
}

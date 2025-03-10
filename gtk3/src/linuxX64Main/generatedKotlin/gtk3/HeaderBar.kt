package gtk3

import kotlin.Boolean
import kotlin.String
import kotlin.Unit
import kotlinx.cinterop.CPointer
import kotlinx.cinterop.reinterpret
import kotlinx.cinterop.toKString
import libgtk3.GtkHeaderBar
import libgtk3.GtkWidget
import libgtk3.gtk_false
import libgtk3.gtk_header_bar_get_custom_title
import libgtk3.gtk_header_bar_get_decoration_layout
import libgtk3.gtk_header_bar_get_has_subtitle
import libgtk3.gtk_header_bar_get_show_close_button
import libgtk3.gtk_header_bar_get_subtitle
import libgtk3.gtk_header_bar_get_title
import libgtk3.gtk_header_bar_new
import libgtk3.gtk_header_bar_pack_end
import libgtk3.gtk_header_bar_pack_start
import libgtk3.gtk_header_bar_set_custom_title
import libgtk3.gtk_header_bar_set_decoration_layout
import libgtk3.gtk_header_bar_set_has_subtitle
import libgtk3.gtk_header_bar_set_show_close_button
import libgtk3.gtk_header_bar_set_subtitle
import libgtk3.gtk_header_bar_set_title
import libgtk3.gtk_true

inline fun Container.headerBar(init: HeaderBar.() -> Unit = {}): HeaderBar =
        HeaderBar().apply { init(); this@headerBar.add(this) }

/**
 * GtkHeaderBar is similar to a horizontal #GtkBox. It allows children to
 * be placed at the start or the end. In addition, it allows a title and
 * subtitle to be displayed. The title will be centered with respect to
 * the width of the box, even if the children at either side take up
 * different amounts of space. The height of the titlebar will be
 * set to provide sufficient space for the subtitle, even if none is
 * currently set. If a subtitle is not needed, the space reservation
 * can be turned off with gtk_header_bar_set_has_subtitle().
 *
 * GtkHeaderBar can add typical window frame controls, such as minimize,
 * maximize and close buttons, or the window icon.
 *
 * For these reasons, GtkHeaderBar is the natural choice for use as the custom
 * titlebar widget of a #GtkWindow (see gtk_window_set_titlebar()), as it gives
 * features typical of titlebars while allowing the addition of child widgets.
 */
@GtkDsl
open class HeaderBar internal constructor(override val widgetPtr: CPointer<GtkWidget>? = null) :
        Container() {
    private val self: CPointer<GtkHeaderBar>?
        get() = widgetPtr!!.reinterpret()

    val headerBar: CPointer<GtkHeaderBar>?
        get() = widgetPtr!!.reinterpret()

    /**
     * Retrieves the custom title widget of the header. See
     * gtk_header_bar_set_custom_title().
     *
     * Sets a custom title for the #GtkHeaderBar.
     *
     * The title should help a user identify the current view. This
     * supersedes any title set by gtk_header_bar_set_title() or
     * gtk_header_bar_set_subtitle(). To achieve the same style as
     * the builtin title and subtitle, use the “title” and “subtitle”
     * style classes.
     *
     * You should set the custom title to %NULL, for the header title
     * label to be visible again. */
    var customTitle: CPointer<GtkWidget>
        get() = gtk_header_bar_get_custom_title(self)!!.reinterpret()
        set(value) {
            gtk_header_bar_set_custom_title(self, value?.reinterpret())
        }

    /**
     * Gets the decoration layout set with
     * gtk_header_bar_set_decoration_layout().
     *
     * Sets the decoration layout for this header bar, overriding
     * the #GtkSettings:gtk-decoration-layout setting.
     *
     * There can be valid reasons for overriding the setting, such
     * as a header bar design that does not allow for buttons to take
     * room on the right, or only offers room for a single close button.
     * Split header bars are another example for overriding the
     * setting.
     *
     * The format of the string is button names, separated by commas.
     * A colon separates the buttons that should appear on the left
     * from those on the right. Recognized button names are minimize,
     * maximize, close, icon (the window icon) and menu (a menu button
     * for the fallback app menu).
     *
     * For example, “menu:minimize,maximize,close” specifies a menu
     * on the left, and minimize, maximize and close buttons on the right. */
    var decorationLayout: String
        get() = gtk_header_bar_get_decoration_layout(self)?.toKString() ?: ""
        set(value) {
            gtk_header_bar_set_decoration_layout(self, value)
        }

    /**
     * Retrieves whether the header bar reserves space for
     * a subtitle, regardless if one is currently set or not.
     *
     * Sets whether the header bar should reserve space
     * for a subtitle, even if none is currently set. */
    var hasSubtitle: Boolean
        get() = gtk_header_bar_get_has_subtitle(self) != 0
        set(value) {
            gtk_header_bar_set_has_subtitle(self, if (value) gtk_true() else gtk_false())
        }

    /**
     * Returns whether this header bar shows the standard window
     * decorations.
     *
     * Sets whether this header bar shows the standard window decorations,
     * including close, maximize, and minimize. */
    var showCloseButton: Boolean
        get() = gtk_header_bar_get_show_close_button(self) != 0
        set(value) {
            gtk_header_bar_set_show_close_button(self, if (value) gtk_true() else gtk_false())
        }

    /**
     * Retrieves the subtitle of the header. See gtk_header_bar_set_subtitle().
     *
     * Sets the subtitle of the #GtkHeaderBar. The title should give a user
     * an additional detail to help him identify the current view.
     *
     * Note that GtkHeaderBar by default reserves room for the subtitle,
     * even if none is currently set. If this is not desired, set the
     * #GtkHeaderBar:has-subtitle property to %FALSE. */
    var subtitle: String
        get() = gtk_header_bar_get_subtitle(self)?.toKString() ?: ""
        set(value) {
            gtk_header_bar_set_subtitle(self, value)
        }

    /**
     * Retrieves the title of the header. See gtk_header_bar_set_title().
     *
     * Sets the title of the #GtkHeaderBar. The title should help a user
     * identify the current view. A good title should not include the
     * application name. */
    var title: String
        get() = gtk_header_bar_get_title(self)?.toKString() ?: ""
        set(value) {
            gtk_header_bar_set_title(self, value)
        }

    /**
     * Creates a new #GtkHeaderBar widget. */
    constructor() : this(gtk_header_bar_new()?.reinterpret())

    /**
     * Adds @child to @bar, packed with reference to the
     * end of the @bar.
     */
    fun packEnd(child: CPointer<GtkWidget>): Unit = gtk_header_bar_pack_end(self, child)

    /**
     * Adds @child to @bar, packed with reference to the
     * end of the @bar.
     */
    fun packEnd(child: Widget): Unit = gtk_header_bar_pack_end(self, child.widgetPtr?.reinterpret())

    /**
     * Adds @child to @bar, packed with reference to the
     * start of the @bar.
     */
    fun packStart(child: CPointer<GtkWidget>): Unit = gtk_header_bar_pack_start(self, child)

    /**
     * Adds @child to @bar, packed with reference to the
     * start of the @bar.
     */
    fun packStart(child: Widget): Unit = gtk_header_bar_pack_start(self,
            child.widgetPtr?.reinterpret())
}

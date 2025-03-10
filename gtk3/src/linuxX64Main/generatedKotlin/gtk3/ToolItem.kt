package gtk3

import kotlin.Boolean
import kotlin.Float
import kotlin.String
import kotlin.Unit
import kotlinx.cinterop.CFunction
import kotlinx.cinterop.COpaquePointer
import kotlinx.cinterop.CPointed
import kotlinx.cinterop.CPointer
import kotlinx.cinterop.asStableRef
import kotlinx.cinterop.reinterpret
import kotlinx.cinterop.staticCFunction
import libgtk3.GtkIconSize
import libgtk3.GtkOrientation
import libgtk3.GtkReliefStyle
import libgtk3.GtkSizeGroup
import libgtk3.GtkToolItem
import libgtk3.GtkToolbarStyle
import libgtk3.GtkWidget
import libgtk3.gtk_false
import libgtk3.gtk_tool_item_get_expand
import libgtk3.gtk_tool_item_get_homogeneous
import libgtk3.gtk_tool_item_get_icon_size
import libgtk3.gtk_tool_item_get_is_important
import libgtk3.gtk_tool_item_get_orientation
import libgtk3.gtk_tool_item_get_proxy_menu_item
import libgtk3.gtk_tool_item_get_relief_style
import libgtk3.gtk_tool_item_get_text_alignment
import libgtk3.gtk_tool_item_get_text_orientation
import libgtk3.gtk_tool_item_get_text_size_group
import libgtk3.gtk_tool_item_get_toolbar_style
import libgtk3.gtk_tool_item_get_use_drag_window
import libgtk3.gtk_tool_item_get_visible_horizontal
import libgtk3.gtk_tool_item_get_visible_vertical
import libgtk3.gtk_tool_item_new
import libgtk3.gtk_tool_item_rebuild_menu
import libgtk3.gtk_tool_item_retrieve_proxy_menu_item
import libgtk3.gtk_tool_item_set_expand
import libgtk3.gtk_tool_item_set_homogeneous
import libgtk3.gtk_tool_item_set_is_important
import libgtk3.gtk_tool_item_set_proxy_menu_item
import libgtk3.gtk_tool_item_set_tooltip_markup
import libgtk3.gtk_tool_item_set_tooltip_text
import libgtk3.gtk_tool_item_set_use_drag_window
import libgtk3.gtk_tool_item_set_visible_horizontal
import libgtk3.gtk_tool_item_set_visible_vertical
import libgtk3.gtk_tool_item_toolbar_reconfigured
import libgtk3.gtk_true

inline fun Container.toolItem(init: ToolItem.() -> Unit = {}): ToolItem = ToolItem().apply { init();
        this@toolItem.add(this) }

private fun ToolItem_onCreateMenuProxy_Handler(sender: CPointer<in CPointed>?, _data:
        COpaquePointer?) {
    _data?.asStableRef<ToolItem>()?.get()?.onCreateMenuProxy?.emit()
}

private fun ToolItem_onToolbarReconfigured_Handler(sender: CPointer<in CPointed>?, _data:
        COpaquePointer?) {
    _data?.asStableRef<ToolItem>()?.get()?.onToolbarReconfigured?.emit()
}

/**
 * #GtkToolItems are widgets that can appear on a toolbar. To
 * create a toolbar item that contain something else than a button, use
 * gtk_tool_item_new(). Use gtk_container_add() to add a child
 * widget to the tool item.
 *
 * For toolbar items that contain buttons, see the #GtkToolButton,
 * #GtkToggleToolButton and #GtkRadioToolButton classes.
 *
 * See the #GtkToolbar class for a description of the toolbar widget, and
 * #GtkToolShell for a description of the tool shell interface.Returns the icon size used for
        @tool_item. Custom subclasses of
 * #GtkToolItem should call this function to find out what size icons
 * they should use.Returns the orientation used for @tool_item. Custom subclasses of
 * #GtkToolItem should call this function to find out what size icons
 * they should use.Returns the relief style of @tool_item. See gtk_button_set_relief().
 * Custom subclasses of #GtkToolItem should call this function in the handler
 * of the #GtkToolItem::toolbar_reconfigured signal to find out the
 * relief style of buttons.Returns the text alignment used for @tool_item. Custom subclasses of
 * #GtkToolItem should call this function to find out how text should
 * be aligned.Returns the text orientation used for @tool_item. Custom subclasses of
 * #GtkToolItem should call this function to find out how text should
 * be orientated.Returns the size group used for labels in @tool_item.
 * Custom subclasses of #GtkToolItem should call this function
 * and use the size group for labels.Returns the toolbar style used for @tool_item. Custom
        subclasses of
 * #GtkToolItem should call this function in the handler of the
 * GtkToolItem::toolbar_reconfigured signal to find out in what style
 * the toolbar is displayed and change themselves accordingly
 *
 * Possibilities are:
 * - %GTK_TOOLBAR_BOTH, meaning the tool item should show
 *   both an icon and a label, stacked vertically
 * - %GTK_TOOLBAR_ICONS, meaning the toolbar shows only icons
 * - %GTK_TOOLBAR_TEXT, meaning the tool item should only show text
 * - %GTK_TOOLBAR_BOTH_HORIZ, meaning the tool item should show
 *   both an icon and a label, arranged horizontally
 */
@GtkDsl
open class ToolItem internal constructor(override val widgetPtr: CPointer<GtkWidget>? = null) :
        Bin() {
    private val self: CPointer<GtkToolItem>?
        get() = widgetPtr!!.reinterpret()

    val toolItem: CPointer<GtkToolItem>?
        get() = widgetPtr!!.reinterpret()

    val onCreateMenuProxy: Signal<ToolItem, CFunction<(CPointer<in CPointed>?, COpaquePointer?) ->
            Unit>> by lazy { Signal<ToolItem, CFunction<(CPointer<in CPointed>?, COpaquePointer?) ->
            Unit>>(widgetPtr!!, this, "create-menu-proxy",
            staticCFunction(::ToolItem_onCreateMenuProxy_Handler)) }

    val onToolbarReconfigured: Signal<ToolItem, CFunction<(CPointer<in CPointed>?,
            COpaquePointer?) -> Unit>> by lazy { Signal<ToolItem, CFunction<(CPointer<in CPointed>?,
            COpaquePointer?) -> Unit>>(widgetPtr!!, this, "toolbar-reconfigured",
            staticCFunction(::ToolItem_onToolbarReconfigured_Handler)) }

    /**
     * Returns whether @tool_item is allocated extra space.
     * See gtk_tool_item_set_expand().
     *
     * Sets whether @tool_item is allocated extra space when there
     * is more room on the toolbar then needed for the items. The
     * effect is that the item gets bigger when the toolbar gets bigger
     * and smaller when the toolbar gets smaller. */
    var expand: Boolean
        get() = gtk_tool_item_get_expand(self) != 0
        set(value) {
            gtk_tool_item_set_expand(self, if (value) gtk_true() else gtk_false())
        }

    /**
     * Returns whether @tool_item is the same size as other homogeneous
     * items. See gtk_tool_item_set_homogeneous().
     *
     * Sets whether @tool_item is to be allocated the same size as other
     * homogeneous items. The effect is that all homogeneous items will have
     * the same width as the widest of the items. */
    var homogeneous: Boolean
        get() = gtk_tool_item_get_homogeneous(self) != 0
        set(value) {
            gtk_tool_item_set_homogeneous(self, if (value) gtk_true() else gtk_false())
        }

    val iconSize: GtkIconSize
        get() = gtk_tool_item_get_icon_size(self)

    /**
     * Returns whether @tool_item is considered important. See
     * gtk_tool_item_set_is_important()
     *
     * Sets whether @tool_item should be considered important. The #GtkToolButton
     * class uses this property to determine whether to show or hide its label
     * when the toolbar style is %GTK_TOOLBAR_BOTH_HORIZ. The result is that
     * only tool buttons with the “is_important” property set have labels, an
     * effect known as “priority text” */
    var isImportant: Boolean
        get() = gtk_tool_item_get_is_important(self) != 0
        set(value) {
            gtk_tool_item_set_is_important(self, if (value) gtk_true() else gtk_false())
        }

    val orientation: GtkOrientation
        get() = gtk_tool_item_get_orientation(self)

    val reliefStyle: GtkReliefStyle
        get() = gtk_tool_item_get_relief_style(self)

    val textAlignment: Float
        get() = gtk_tool_item_get_text_alignment(self)

    val textOrientation: GtkOrientation
        get() = gtk_tool_item_get_text_orientation(self)

    val textSizeGroup: CPointer<GtkSizeGroup>
        get() = gtk_tool_item_get_text_size_group(self)!!.reinterpret()

    val toolbarStyle: GtkToolbarStyle
        get() = gtk_tool_item_get_toolbar_style(self)

    /**
     * Returns whether @tool_item has a drag window. See
     * gtk_tool_item_set_use_drag_window().
     *
     * Sets whether @tool_item has a drag window. When %TRUE the
     * toolitem can be used as a drag source through gtk_drag_source_set().
     * When @tool_item has a drag window it will intercept all events,
     * even those that would otherwise be sent to a child of @tool_item. */
    var useDragWindow: Boolean
        get() = gtk_tool_item_get_use_drag_window(self) != 0
        set(value) {
            gtk_tool_item_set_use_drag_window(self, if (value) gtk_true() else gtk_false())
        }

    /**
     * Returns whether the @tool_item is visible on toolbars that are
     * docked horizontally.
     *
     * Sets whether @tool_item is visible when the toolbar is docked horizontally. */
    var visibleHorizontal: Boolean
        get() = gtk_tool_item_get_visible_horizontal(self) != 0
        set(value) {
            gtk_tool_item_set_visible_horizontal(self, if (value) gtk_true() else gtk_false())
        }

    /**
     * Returns whether @tool_item is visible when the toolbar is docked vertically.
     * See gtk_tool_item_set_visible_vertical().
     *
     * Sets whether @tool_item is visible when the toolbar is docked
     * vertically. Some tool items, such as text entries, are too wide to be
     * useful on a vertically docked toolbar. If @visible_vertical is %FALSE
     * @tool_item will not appear on toolbars that are docked vertically. */
    var visibleVertical: Boolean
        get() = gtk_tool_item_get_visible_vertical(self) != 0
        set(value) {
            gtk_tool_item_set_visible_vertical(self, if (value) gtk_true() else gtk_false())
        }

    /**
     * Creates a new #GtkToolItem */
    constructor() : this(gtk_tool_item_new()?.reinterpret())

    /**
     * If @menu_item_id matches the string passed to
     * gtk_tool_item_set_proxy_menu_item() return the corresponding #GtkMenuItem.
     *
     * Custom subclasses of #GtkToolItem should use this function to
     * update their menu item when the #GtkToolItem changes. That the
     * @menu_item_ids must match ensures that a #GtkToolItem
     * will not inadvertently change a menu item that they did not create.
     */
    fun getProxyMenuItem(menu_item_id: String): CPointer<GtkWidget> =
            gtk_tool_item_get_proxy_menu_item(self, menu_item_id)!!.reinterpret()

    /**
     * Calling this function signals to the toolbar that the
     * overflow menu item for @tool_item has changed. If the
     * overflow menu is visible when this function it called,
     * the menu will be rebuilt.
     *
     * The function must be called when the tool item changes what it
     * will do in response to the #GtkToolItem::create-menu-proxy signal.
     */
    fun rebuildMenu(): Unit = gtk_tool_item_rebuild_menu(self)

    /**
     * Returns the #GtkMenuItem that was last set by
     * gtk_tool_item_set_proxy_menu_item(), ie. the #GtkMenuItem
     * that is going to appear in the overflow menu.
     */
    fun retrieveProxyMenuItem(): CPointer<GtkWidget> =
            gtk_tool_item_retrieve_proxy_menu_item(self)!!.reinterpret()

    /**
     * Sets the #GtkMenuItem used in the toolbar overflow menu. The
     * @menu_item_id is used to identify the caller of this function and
     * should also be used with gtk_tool_item_get_proxy_menu_item().
     *
     * See also #GtkToolItem::create-menu-proxy.
     */
    fun setProxyMenuItem(menu_item_id: String, menu_item: CPointer<GtkWidget>): Unit =
            gtk_tool_item_set_proxy_menu_item(self, menu_item_id, menu_item)

    /**
     * Sets the #GtkMenuItem used in the toolbar overflow menu. The
     * @menu_item_id is used to identify the caller of this function and
     * should also be used with gtk_tool_item_get_proxy_menu_item().
     *
     * See also #GtkToolItem::create-menu-proxy.
     */
    fun setProxyMenuItem(menu_item_id: String, menu_item: Widget): Unit =
            gtk_tool_item_set_proxy_menu_item(self, menu_item_id,
            menu_item.widgetPtr?.reinterpret())

    /**
     * Emits the signal #GtkToolItem::toolbar_reconfigured on @tool_item.
     * #GtkToolbar and other #GtkToolShell implementations use this function
     * to notify children, when some aspect of their configuration changes.
     */
    fun toolbarReconfigured(): Unit = gtk_tool_item_toolbar_reconfigured(self)

    /**
     * Sets the markup text to be displayed as tooltip on the item.
     * See gtk_widget_set_tooltip_markup().
     */
    fun setTooltipMarkup(markup: String): Unit = gtk_tool_item_set_tooltip_markup(self, markup)

    /**
     * Sets the text to be displayed as tooltip on the item.
     * See gtk_widget_set_tooltip_text().
     */
    fun setTooltipText(text: String): Unit = gtk_tool_item_set_tooltip_text(self, text)
}

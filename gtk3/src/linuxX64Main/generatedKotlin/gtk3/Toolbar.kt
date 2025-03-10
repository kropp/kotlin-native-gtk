package gtk3

import kotlin.Boolean
import kotlin.Int
import kotlin.Unit
import kotlinx.cinterop.CFunction
import kotlinx.cinterop.COpaquePointer
import kotlinx.cinterop.CPointed
import kotlinx.cinterop.CPointer
import kotlinx.cinterop.asStableRef
import kotlinx.cinterop.reinterpret
import kotlinx.cinterop.staticCFunction
import libgtk3.GtkIconSize
import libgtk3.GtkReliefStyle
import libgtk3.GtkToolItem
import libgtk3.GtkToolbar
import libgtk3.GtkToolbarStyle
import libgtk3.GtkWidget
import libgtk3.gtk_false
import libgtk3.gtk_toolbar_get_drop_index
import libgtk3.gtk_toolbar_get_icon_size
import libgtk3.gtk_toolbar_get_item_index
import libgtk3.gtk_toolbar_get_n_items
import libgtk3.gtk_toolbar_get_nth_item
import libgtk3.gtk_toolbar_get_relief_style
import libgtk3.gtk_toolbar_get_show_arrow
import libgtk3.gtk_toolbar_get_style
import libgtk3.gtk_toolbar_insert
import libgtk3.gtk_toolbar_new
import libgtk3.gtk_toolbar_set_drop_highlight_item
import libgtk3.gtk_toolbar_set_icon_size
import libgtk3.gtk_toolbar_set_show_arrow
import libgtk3.gtk_toolbar_set_style
import libgtk3.gtk_toolbar_unset_icon_size
import libgtk3.gtk_toolbar_unset_style
import libgtk3.gtk_true

inline fun Container.toolbar(init: Toolbar.() -> Unit = {}): Toolbar = Toolbar().apply { init();
        this@toolbar.add(this) }

private fun Toolbar_onFocusHomeOrEnd_Handler(
    sender: CPointer<in CPointed>?,
    focus_home: Boolean,
    _data: COpaquePointer?
) {
    _data?.asStableRef<Toolbar>()?.get()?.onFocusHomeOrEnd?.emit(focus_home)
}

private fun Toolbar_onPopupContextMenu_Handler(
    sender: CPointer<in CPointed>?,
    x: Int,
    y: Int,
    button: Int,
    _data: COpaquePointer?
) {
    _data?.asStableRef<Toolbar>()?.get()?.onPopupContextMenu?.emit(x, y, button)
}

/**
 * A toolbar is created with a call to gtk_toolbar_new().
 *
 * A toolbar can contain instances of a subclass of #GtkToolItem. To add
 * a #GtkToolItem to the a toolbar, use gtk_toolbar_insert(). To remove
 * an item from the toolbar use gtk_container_remove(). To add a button
 * to the toolbar, add an instance of #GtkToolButton.
 *
 * Toolbar items can be visually grouped by adding instances of
 * #GtkSeparatorToolItem to the toolbar. If the GtkToolbar child property
 * “expand” is #TRUE and the property #GtkSeparatorToolItem:draw is set to
 * #FALSE, the effect is to force all following items to the end of the toolbar.
 *
 * By default, a toolbar can be shrunk, upon which it will add an arrow button
 * to show an overflow menu offering access to any #GtkToolItem child that has
 * a proxy menu item. To disable this and request enough size for all children,
 * call gtk_toolbar_set_show_arrow() to set #GtkToolbar:show-arrow to %FALSE.
 *
 * Creating a context menu for the toolbar can be done by connecting to
 * the #GtkToolbar::popup-context-menu signal.
 *
 * # CSS nodes
 *
 * GtkToolbar has a single CSS node with name toolbar.Returns the number of items on the
        toolbar.Returns the relief style of buttons on @toolbar. See
 * gtk_button_set_relief().
 */
@GtkDsl
open class Toolbar internal constructor(override val widgetPtr: CPointer<GtkWidget>? = null) :
        Container() {
    private val self: CPointer<GtkToolbar>?
        get() = widgetPtr!!.reinterpret()

    val toolbar: CPointer<GtkToolbar>?
        get() = widgetPtr!!.reinterpret()

    val onFocusHomeOrEnd: Signal1<Toolbar, Boolean, CFunction<(
        CPointer<in CPointed>?,
        Boolean,
        COpaquePointer?
    ) -> Unit>> by lazy { Signal1<Toolbar, Boolean, CFunction<(
                CPointer<in CPointed>?,
                Boolean,
                COpaquePointer?
            ) -> Unit>>(widgetPtr!!, this, "focus-home-or-end",
                    staticCFunction(::Toolbar_onFocusHomeOrEnd_Handler)) }

    val onPopupContextMenu: Signal3<Toolbar, Int, Int, Int, CFunction<(
        CPointer<in CPointed>?,
        Int,
        Int,
        Int,
        COpaquePointer?
    ) -> Unit>> by lazy { Signal3<Toolbar, Int, Int, Int, CFunction<(
                CPointer<in CPointed>?,
                Int,
                Int,
                Int,
                COpaquePointer?
            ) -> Unit>>(widgetPtr!!, this, "popup-context-menu",
                    staticCFunction(::Toolbar_onPopupContextMenu_Handler)) }

    /**
     * Retrieves the icon size for the toolbar. See gtk_toolbar_set_icon_size().
     *
     * This function sets the size of stock icons in the toolbar. You
     * can call it both before you add the icons and after they’ve been
     * added. The size you set will override user preferences for the default
     * icon size.
     *
     * This should only be used for special-purpose toolbars, normal
     * application toolbars should respect the user preferences for the
     * size of icons. */
    var iconSize: GtkIconSize
        get() = gtk_toolbar_get_icon_size(self)
        set(value) {
            gtk_toolbar_set_icon_size(self, value)
        }

    val nItems: Int
        get() = gtk_toolbar_get_n_items(self)

    val reliefStyle: GtkReliefStyle
        get() = gtk_toolbar_get_relief_style(self)

    /**
     * Returns whether the toolbar has an overflow menu.
     * See gtk_toolbar_set_show_arrow().
     *
     * Sets whether to show an overflow menu when @toolbar isn’t allocated enough
     * size to show all of its items. If %TRUE, items which can’t fit in @toolbar,
     * and which have a proxy menu item set by gtk_tool_item_set_proxy_menu_item()
     * or #GtkToolItem::create-menu-proxy, will be available in an overflow menu,
     * which can be opened by an added arrow button. If %FALSE, @toolbar will
     * request enough size to fit all of its child items without any overflow. */
    var showArrow: Boolean
        get() = gtk_toolbar_get_show_arrow(self) != 0
        set(value) {
            gtk_toolbar_set_show_arrow(self, if (value) gtk_true() else gtk_false())
        }

    /**
     * Retrieves whether the toolbar has text, icons, or both . See
     * gtk_toolbar_set_style().
     *
     * Alters the view of @toolbar to display either icons only, text only, or both. */
    var style: GtkToolbarStyle
        get() = gtk_toolbar_get_style(self)
        set(value) {
            gtk_toolbar_set_style(self, value)
        }

    /**
     * Creates a new toolbar. */
    constructor() : this(gtk_toolbar_new()?.reinterpret())

    /**
     * Returns the position corresponding to the indicated point on
     * @toolbar. This is useful when dragging items to the toolbar:
     * this function returns the position a new item should be
     * inserted.
     *
     * @x and @y are in @toolbar coordinates.
     */
    fun getDropIndex(x: Int, y: Int): Int = gtk_toolbar_get_drop_index(self, x, y)

    /**
     * Returns the position of @item on the toolbar, starting from 0.
     * It is an error if @item is not a child of the toolbar.
     */
    fun getItemIndex(item: CPointer<GtkToolItem>): Int = gtk_toolbar_get_item_index(self, item)

    /**
     * Returns the position of @item on the toolbar, starting from 0.
     * It is an error if @item is not a child of the toolbar.
     */
    fun getItemIndex(item: ToolItem): Int = gtk_toolbar_get_item_index(self,
            item.widgetPtr?.reinterpret())

    /**
     * Returns the @n'th item on @toolbar, or %NULL if the
     * toolbar does not contain an @n'th item.
     */
    fun getNthItem(n: Int): CPointer<GtkToolItem> = gtk_toolbar_get_nth_item(self,
            n)!!.reinterpret()

    /**
     * Insert a #GtkToolItem into the toolbar at position @pos. If @pos is
     * 0 the item is prepended to the start of the toolbar. If @pos is
     * negative, the item is appended to the end of the toolbar.
     */
    fun insert(item: CPointer<GtkToolItem>, pos: Int): Unit = gtk_toolbar_insert(self, item, pos)

    /**
     * Insert a #GtkToolItem into the toolbar at position @pos. If @pos is
     * 0 the item is prepended to the start of the toolbar. If @pos is
     * negative, the item is appended to the end of the toolbar.
     */
    fun insert(item: ToolItem, pos: Int): Unit = gtk_toolbar_insert(self,
            item.widgetPtr?.reinterpret(), pos)

    /**
     * Highlights @toolbar to give an idea of what it would look like
     * if @item was added to @toolbar at the position indicated by @index_.
     * If @item is %NULL, highlighting is turned off. In that case @index_
     * is ignored.
     *
     * The @tool_item passed to this function must not be part of any widget
     * hierarchy. When an item is set as drop highlight item it can not
     * added to any widget hierarchy or used as highlight item for another
     * toolbar.
     */
    fun setDropHighlightItem(tool_item: CPointer<GtkToolItem>, index_: Int): Unit =
            gtk_toolbar_set_drop_highlight_item(self, tool_item, index_)

    /**
     * Highlights @toolbar to give an idea of what it would look like
     * if @item was added to @toolbar at the position indicated by @index_.
     * If @item is %NULL, highlighting is turned off. In that case @index_
     * is ignored.
     *
     * The @tool_item passed to this function must not be part of any widget
     * hierarchy. When an item is set as drop highlight item it can not
     * added to any widget hierarchy or used as highlight item for another
     * toolbar.
     */
    fun setDropHighlightItem(tool_item: ToolItem, index_: Int): Unit =
            gtk_toolbar_set_drop_highlight_item(self, tool_item.widgetPtr?.reinterpret(), index_)

    /**
     * Unsets toolbar icon size set with gtk_toolbar_set_icon_size(), so that
     * user preferences will be used to determine the icon size.
     */
    fun unsetIconSize(): Unit = gtk_toolbar_unset_icon_size(self)

    /**
     * Unsets a toolbar style set with gtk_toolbar_set_style(), so that
     * user preferences will be used to determine the toolbar style.
     */
    fun unsetStyle(): Unit = gtk_toolbar_unset_style(self)
}

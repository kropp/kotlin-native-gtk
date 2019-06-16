package gtk3

import kotlin.Boolean
import kotlin.Int
import kotlin.String
import kotlin.UInt
import kotlin.Unit
import kotlinx.cinterop.CFunction
import kotlinx.cinterop.COpaquePointer
import kotlinx.cinterop.CPointed
import kotlinx.cinterop.CPointer
import kotlinx.cinterop.asStableRef
import kotlinx.cinterop.reinterpret
import kotlinx.cinterop.staticCFunction
import kotlinx.cinterop.toKString
import libgtk3.GtkNotebook
import libgtk3.GtkPackType
import libgtk3.GtkPositionType
import libgtk3.GtkWidget
import libgtk3.gtk_false
import libgtk3.gtk_notebook_append_page
import libgtk3.gtk_notebook_append_page_menu
import libgtk3.gtk_notebook_detach_tab
import libgtk3.gtk_notebook_get_action_widget
import libgtk3.gtk_notebook_get_current_page
import libgtk3.gtk_notebook_get_group_name
import libgtk3.gtk_notebook_get_menu_label
import libgtk3.gtk_notebook_get_menu_label_text
import libgtk3.gtk_notebook_get_n_pages
import libgtk3.gtk_notebook_get_nth_page
import libgtk3.gtk_notebook_get_scrollable
import libgtk3.gtk_notebook_get_show_border
import libgtk3.gtk_notebook_get_show_tabs
import libgtk3.gtk_notebook_get_tab_detachable
import libgtk3.gtk_notebook_get_tab_label
import libgtk3.gtk_notebook_get_tab_label_text
import libgtk3.gtk_notebook_get_tab_pos
import libgtk3.gtk_notebook_get_tab_reorderable
import libgtk3.gtk_notebook_insert_page
import libgtk3.gtk_notebook_insert_page_menu
import libgtk3.gtk_notebook_new
import libgtk3.gtk_notebook_next_page
import libgtk3.gtk_notebook_page_num
import libgtk3.gtk_notebook_popup_disable
import libgtk3.gtk_notebook_popup_enable
import libgtk3.gtk_notebook_prepend_page
import libgtk3.gtk_notebook_prepend_page_menu
import libgtk3.gtk_notebook_prev_page
import libgtk3.gtk_notebook_remove_page
import libgtk3.gtk_notebook_reorder_child
import libgtk3.gtk_notebook_set_action_widget
import libgtk3.gtk_notebook_set_current_page
import libgtk3.gtk_notebook_set_group_name
import libgtk3.gtk_notebook_set_menu_label
import libgtk3.gtk_notebook_set_menu_label_text
import libgtk3.gtk_notebook_set_scrollable
import libgtk3.gtk_notebook_set_show_border
import libgtk3.gtk_notebook_set_show_tabs
import libgtk3.gtk_notebook_set_tab_detachable
import libgtk3.gtk_notebook_set_tab_label
import libgtk3.gtk_notebook_set_tab_label_text
import libgtk3.gtk_notebook_set_tab_pos
import libgtk3.gtk_notebook_set_tab_reorderable
import libgtk3.gtk_true

inline fun Container.notebook(init: Notebook.() -> Unit = {}): Notebook = Notebook().apply { init();
        this@notebook.add(this) }

private fun Notebook_onChangeCurrentPage_Handler(
    sender: CPointer<in CPointed>?,
    `object`: Int,
    _data: COpaquePointer?
) {
    _data?.asStableRef<Notebook>()?.get()?.onChangeCurrentPage?.emit(`object`)
}

private fun Notebook_onCreateWindow_Handler(
    sender: CPointer<in CPointed>?,
    page: CPointer<GtkWidget>,
    x: Int,
    y: Int,
    _data: COpaquePointer?
) {
    _data?.asStableRef<Notebook>()?.get()?.onCreateWindow?.emit(page?.reinterpret(), x, y)
}

private fun Notebook_onPageAdded_Handler(
    sender: CPointer<in CPointed>?,
    child: CPointer<GtkWidget>,
    page_num: UInt,
    _data: COpaquePointer?
) {
    _data?.asStableRef<Notebook>()?.get()?.onPageAdded?.emit(child?.reinterpret(), page_num)
}

private fun Notebook_onPageRemoved_Handler(
    sender: CPointer<in CPointed>?,
    child: CPointer<GtkWidget>,
    page_num: UInt,
    _data: COpaquePointer?
) {
    _data?.asStableRef<Notebook>()?.get()?.onPageRemoved?.emit(child?.reinterpret(), page_num)
}

private fun Notebook_onPageReordered_Handler(
    sender: CPointer<in CPointed>?,
    child: CPointer<GtkWidget>,
    page_num: UInt,
    _data: COpaquePointer?
) {
    _data?.asStableRef<Notebook>()?.get()?.onPageReordered?.emit(child?.reinterpret(), page_num)
}

private fun Notebook_onSelectPage_Handler(
    sender: CPointer<in CPointed>?,
    `object`: Boolean,
    _data: COpaquePointer?
) {
    _data?.asStableRef<Notebook>()?.get()?.onSelectPage?.emit(`object`)
}

private fun Notebook_onSwitchPage_Handler(
    sender: CPointer<in CPointed>?,
    page: CPointer<GtkWidget>,
    page_num: UInt,
    _data: COpaquePointer?
) {
    _data?.asStableRef<Notebook>()?.get()?.onSwitchPage?.emit(page?.reinterpret(), page_num)
}

/**
 * The #GtkNotebook widget is a #GtkContainer whose children are pages that
 * can be switched between using tab labels along one edge.
 *
 * There are many configuration options for GtkNotebook. Among other
 * things, you can choose on which edge the tabs appear
 * (see gtk_notebook_set_tab_pos()), whether, if there are too many
 * tabs to fit the notebook should be made bigger or scrolling
 * arrows added (see gtk_notebook_set_scrollable()), and whether there
 * will be a popup menu allowing the users to switch pages.
 * (see gtk_notebook_popup_enable(), gtk_notebook_popup_disable())
 *
 * # GtkNotebook as GtkBuildable
 *
 * The GtkNotebook implementation of the #GtkBuildable interface
 * supports placing children into tabs by specifying “tab” as the
 * “type” attribute of a <child> element. Note that the content
 * of the tab must be created before the tab can be filled.
 * A tab child can be specified without specifying a <child>
 * type attribute.
 *
 * To add a child widget in the notebooks action area, specify
 * "action-start" or “action-end” as the “type” attribute of the
 * <child> element.
 *
 * An example of a UI definition fragment with GtkNotebook:
 * |[
 * <object class="GtkNotebook">
 *   <child>
 *     <object class="GtkLabel" id="notebook-content">
 *       <property name="label">Content</property>
 *     </object>
 *   </child>
 *   <child type="tab">
 *     <object class="GtkLabel" id="notebook-tab">
 *       <property name="label">Tab</property>
 *     </object>
 *   </child>
 * </object>
 * ]|
 *
 * # CSS nodes
 *
 * |[<!-- language="plain" -->
 * notebook
 * ├── header.top
 * │   ├── [<action widget>]
 * │   ├── tabs
 * │   │   ├── [arrow]
 * │   │   ├── tab
 * │   │   │   ╰── <tab label>
 * ┊   ┊   ┊
 * │   │   ├── tab[.reorderable-page]
 * │   │   │   ╰── <tab label>
 * │   │   ╰── [arrow]
 * │   ╰── [<action widget>]
 * │
 * ╰── stack
 *     ├── <child>
 *     ┊
 *     ╰── <child>
 * ]|
 *
 * GtkNotebook has a main CSS node with name notebook, a subnode
 * with name header and below that a subnode with name tabs which
 * contains one subnode per tab with name tab.
 *
 * If action widgets are present, their CSS nodes are placed next
 * to the tabs node. If the notebook is scrollable, CSS nodes with
 * name arrow are placed as first and last child of the tabs node.
 *
 * The main node gets the .frame style class when the notebook
 * has a border (see gtk_notebook_set_show_border()).
 *
 * The header node gets one of the style class .top, .bottom,
 * .left or .right, depending on where the tabs are placed. For
 * reorderable pages, the tab node gets the .reorderable-page class.
 *
 * A tab node gets the .dnd style class while it is moved with drag-and-drop.
 *
 * The nodes are always arranged from left-to-right, regarldess of text direction.Gets the number of
        pages in a notebook.
 */
@GtkDsl
open class Notebook internal constructor(override val widgetPtr: CPointer<GtkWidget>? = null) :
        Container() {
    private val self: CPointer<GtkNotebook>?
        get() = widgetPtr!!.reinterpret()

    val notebook: CPointer<GtkNotebook>?
        get() = widgetPtr!!.reinterpret()

    val onChangeCurrentPage: Signal1<Notebook, Int, CFunction<(
        CPointer<in CPointed>?,
        Int,
        COpaquePointer?
    ) -> Unit>> by lazy { Signal1<Notebook, Int, CFunction<(
                CPointer<in CPointed>?,
                Int,
                COpaquePointer?
            ) -> Unit>>(widgetPtr!!, this, "change-current-page",
                    staticCFunction(::Notebook_onChangeCurrentPage_Handler)) }

    val onCreateWindow: Signal3<Notebook, CPointer<GtkWidget>, Int, Int, CFunction<(
        CPointer<in CPointed>?,
        CPointer<GtkWidget>,
        Int,
        Int,
        COpaquePointer?
    ) -> Unit>> by lazy { Signal3<Notebook, CPointer<GtkWidget>, Int, Int, CFunction<(
                CPointer<in CPointed>?,
                CPointer<GtkWidget>,
                Int,
                Int,
                COpaquePointer?
            ) -> Unit>>(widgetPtr!!, this, "create-window",
                    staticCFunction(::Notebook_onCreateWindow_Handler)) }

    val onPageAdded: Signal2<Notebook, CPointer<GtkWidget>, UInt, CFunction<(
        CPointer<in CPointed>?,
        CPointer<GtkWidget>,
        UInt,
        COpaquePointer?
    ) -> Unit>> by lazy { Signal2<Notebook, CPointer<GtkWidget>, UInt, CFunction<(
                CPointer<in CPointed>?,
                CPointer<GtkWidget>,
                UInt,
                COpaquePointer?
            ) -> Unit>>(widgetPtr!!, this, "page-added",
                    staticCFunction(::Notebook_onPageAdded_Handler)) }

    val onPageRemoved: Signal2<Notebook, CPointer<GtkWidget>, UInt, CFunction<(
        CPointer<in CPointed>?,
        CPointer<GtkWidget>,
        UInt,
        COpaquePointer?
    ) -> Unit>> by lazy { Signal2<Notebook, CPointer<GtkWidget>, UInt, CFunction<(
                CPointer<in CPointed>?,
                CPointer<GtkWidget>,
                UInt,
                COpaquePointer?
            ) -> Unit>>(widgetPtr!!, this, "page-removed",
                    staticCFunction(::Notebook_onPageRemoved_Handler)) }

    val onPageReordered: Signal2<Notebook, CPointer<GtkWidget>, UInt, CFunction<(
        CPointer<in CPointed>?,
        CPointer<GtkWidget>,
        UInt,
        COpaquePointer?
    ) -> Unit>> by lazy { Signal2<Notebook, CPointer<GtkWidget>, UInt, CFunction<(
                CPointer<in CPointed>?,
                CPointer<GtkWidget>,
                UInt,
                COpaquePointer?
            ) -> Unit>>(widgetPtr!!, this, "page-reordered",
                    staticCFunction(::Notebook_onPageReordered_Handler)) }

    val onSelectPage: Signal1<Notebook, Boolean, CFunction<(
        CPointer<in CPointed>?,
        Boolean,
        COpaquePointer?
    ) -> Unit>> by lazy { Signal1<Notebook, Boolean, CFunction<(
                CPointer<in CPointed>?,
                Boolean,
                COpaquePointer?
            ) -> Unit>>(widgetPtr!!, this, "select-page",
                    staticCFunction(::Notebook_onSelectPage_Handler)) }

    val onSwitchPage: Signal2<Notebook, CPointer<GtkWidget>, UInt, CFunction<(
        CPointer<in CPointed>?,
        CPointer<GtkWidget>,
        UInt,
        COpaquePointer?
    ) -> Unit>> by lazy { Signal2<Notebook, CPointer<GtkWidget>, UInt, CFunction<(
                CPointer<in CPointed>?,
                CPointer<GtkWidget>,
                UInt,
                COpaquePointer?
            ) -> Unit>>(widgetPtr!!, this, "switch-page",
                    staticCFunction(::Notebook_onSwitchPage_Handler)) }

    /**
     * Returns the page number of the current page.
     *
     * Switches to the page number @page_num.
     *
     * Note that due to historical reasons, GtkNotebook refuses
     * to switch to a page unless the child widget is visible.
     * Therefore, it is recommended to show child widgets before
     * adding them to a notebook. */
    var currentPage: Int
        get() = gtk_notebook_get_current_page(self)
        set(value) {
            gtk_notebook_set_current_page(self, value)
        }

    /**
     * Gets the current group name for @notebook.
     *
     * Sets a group name for @notebook.
     *
     * Notebooks with the same name will be able to exchange tabs
     * via drag and drop. A notebook with a %NULL group name will
     * not be able to exchange tabs with any other notebook. */
    var groupName: String
        get() = gtk_notebook_get_group_name(self)?.toKString() ?: ""
        set(value) {
            gtk_notebook_set_group_name(self, value)
        }

    val nPages: Int
        get() = gtk_notebook_get_n_pages(self)

    /**
     * Returns whether the tab label area has arrows for scrolling.
     * See gtk_notebook_set_scrollable().
     *
     * Sets whether the tab label area will have arrows for
     * scrolling if there are too many tabs to fit in the area. */
    var scrollable: Boolean
        get() = gtk_notebook_get_scrollable(self) != 0
        set(value) {
            gtk_notebook_set_scrollable(self, if (value) gtk_true() else gtk_false())
        }

    /**
     * Returns whether a bevel will be drawn around the notebook pages.
     * See gtk_notebook_set_show_border().
     *
     * Sets whether a bevel will be drawn around the notebook pages.
     * This only has a visual effect when the tabs are not shown.
     * See gtk_notebook_set_show_tabs(). */
    var showBorder: Boolean
        get() = gtk_notebook_get_show_border(self) != 0
        set(value) {
            gtk_notebook_set_show_border(self, if (value) gtk_true() else gtk_false())
        }

    /**
     * Returns whether the tabs of the notebook are shown.
     * See gtk_notebook_set_show_tabs().
     *
     * Sets whether to show the tabs for the notebook or not. */
    var showTabs: Boolean
        get() = gtk_notebook_get_show_tabs(self) != 0
        set(value) {
            gtk_notebook_set_show_tabs(self, if (value) gtk_true() else gtk_false())
        }

    /**
     * Gets the edge at which the tabs for switching pages in the
     * notebook are drawn.
     *
     * Sets the edge at which the tabs for switching pages in the
     * notebook are drawn. */
    var tabPos: GtkPositionType
        get() = gtk_notebook_get_tab_pos(self)
        set(value) {
            gtk_notebook_set_tab_pos(self, value)
        }

    /**
     * Creates a new #GtkNotebook widget with no pages. */
    constructor() : this(gtk_notebook_new()?.reinterpret())

    /**
     * Appends a page to @notebook.
     */
    fun appendPage(child: CPointer<GtkWidget>, tab_label: CPointer<GtkWidget>): Int =
            gtk_notebook_append_page(self, child, tab_label)

    /**
     * Appends a page to @notebook.
     */
    fun appendPage(child: Widget, tab_label: Widget): Int = gtk_notebook_append_page(self,
            child.widgetPtr?.reinterpret(), tab_label.widgetPtr?.reinterpret())

    /**
     * Appends a page to @notebook, specifying the widget to use as the
     * label in the popup menu.
     */
    fun appendPageMenu(
        child: CPointer<GtkWidget>,
        tab_label: CPointer<GtkWidget>,
        menu_label: CPointer<GtkWidget>
    ): Int = gtk_notebook_append_page_menu(self, child, tab_label, menu_label)

    /**
     * Appends a page to @notebook, specifying the widget to use as the
     * label in the popup menu.
     */
    fun appendPageMenu(
        child: Widget,
        tab_label: Widget,
        menu_label: Widget
    ): Int = gtk_notebook_append_page_menu(self, child.widgetPtr?.reinterpret(),
            tab_label.widgetPtr?.reinterpret(), menu_label.widgetPtr?.reinterpret())

    /**
     * Removes the child from the notebook.
     *
     * This function is very similar to gtk_container_remove(),
     * but additionally informs the notebook that the removal
     * is happening as part of a tab DND operation, which should
     * not be cancelled.
     */
    fun detachTab(child: CPointer<GtkWidget>): Unit = gtk_notebook_detach_tab(self, child)

    /**
     * Removes the child from the notebook.
     *
     * This function is very similar to gtk_container_remove(),
     * but additionally informs the notebook that the removal
     * is happening as part of a tab DND operation, which should
     * not be cancelled.
     */
    fun detachTab(child: Widget): Unit = gtk_notebook_detach_tab(self,
            child.widgetPtr?.reinterpret())

    /**
     * Gets one of the action widgets. See gtk_notebook_set_action_widget().
     */
    fun getActionWidget(pack_type: GtkPackType): CPointer<GtkWidget> =
            gtk_notebook_get_action_widget(self, pack_type)!!.reinterpret()

    /**
     * Retrieves the menu label widget of the page containing @child.
     */
    fun getMenuLabel(child: CPointer<GtkWidget>): CPointer<GtkWidget> =
            gtk_notebook_get_menu_label(self, child)!!.reinterpret()

    /**
     * Retrieves the menu label widget of the page containing @child.
     */
    fun getMenuLabel(child: Widget): CPointer<GtkWidget> = gtk_notebook_get_menu_label(self,
            child.widgetPtr?.reinterpret())!!.reinterpret()

    /**
     * Retrieves the text of the menu label for the page containing
     * @child.
     */
    fun getMenuLabelText(child: CPointer<GtkWidget>): String =
            gtk_notebook_get_menu_label_text(self, child)?.toKString() ?: ""

    /**
     * Retrieves the text of the menu label for the page containing
     * @child.
     */
    fun getMenuLabelText(child: Widget): String = gtk_notebook_get_menu_label_text(self,
            child.widgetPtr?.reinterpret())?.toKString() ?: ""

    /**
     * Returns the child widget contained in page number @page_num.
     */
    fun getNthPage(page_num: Int): CPointer<GtkWidget> = gtk_notebook_get_nth_page(self,
            page_num)!!.reinterpret()

    /**
     * Returns whether the tab contents can be detached from @notebook.
     */
    fun getTabDetachable(child: CPointer<GtkWidget>): Boolean =
            gtk_notebook_get_tab_detachable(self, child) != 0

    /**
     * Returns whether the tab contents can be detached from @notebook.
     */
    fun getTabDetachable(child: Widget): Boolean = gtk_notebook_get_tab_detachable(self,
            child.widgetPtr?.reinterpret()) != 0

    /**
     * Returns the tab label widget for the page @child.
     * %NULL is returned if @child is not in @notebook or
     * if no tab label has specifically been set for @child.
     */
    fun getTabLabel(child: CPointer<GtkWidget>): CPointer<GtkWidget> =
            gtk_notebook_get_tab_label(self, child)!!.reinterpret()

    /**
     * Returns the tab label widget for the page @child.
     * %NULL is returned if @child is not in @notebook or
     * if no tab label has specifically been set for @child.
     */
    fun getTabLabel(child: Widget): CPointer<GtkWidget> = gtk_notebook_get_tab_label(self,
            child.widgetPtr?.reinterpret())!!.reinterpret()

    /**
     * Retrieves the text of the tab label for the page containing
     * @child.
     */
    fun getTabLabelText(child: CPointer<GtkWidget>): String = gtk_notebook_get_tab_label_text(self,
            child)?.toKString() ?: ""

    /**
     * Retrieves the text of the tab label for the page containing
     * @child.
     */
    fun getTabLabelText(child: Widget): String = gtk_notebook_get_tab_label_text(self,
            child.widgetPtr?.reinterpret())?.toKString() ?: ""

    /**
     * Gets whether the tab can be reordered via drag and drop or not.
     */
    fun getTabReorderable(child: CPointer<GtkWidget>): Boolean =
            gtk_notebook_get_tab_reorderable(self, child) != 0

    /**
     * Gets whether the tab can be reordered via drag and drop or not.
     */
    fun getTabReorderable(child: Widget): Boolean = gtk_notebook_get_tab_reorderable(self,
            child.widgetPtr?.reinterpret()) != 0

    /**
     * Insert a page into @notebook at the given position.
     */
    fun insertPage(
        child: CPointer<GtkWidget>,
        tab_label: CPointer<GtkWidget>,
        position: Int
    ): Int = gtk_notebook_insert_page(self, child, tab_label, position)

    /**
     * Insert a page into @notebook at the given position.
     */
    fun insertPage(
        child: Widget,
        tab_label: Widget,
        position: Int
    ): Int = gtk_notebook_insert_page(self, child.widgetPtr?.reinterpret(),
            tab_label.widgetPtr?.reinterpret(), position)

    /**
     * Insert a page into @notebook at the given position, specifying
     * the widget to use as the label in the popup menu.
     */
    fun insertPageMenu(
        child: CPointer<GtkWidget>,
        tab_label: CPointer<GtkWidget>,
        menu_label: CPointer<GtkWidget>,
        position: Int
    ): Int = gtk_notebook_insert_page_menu(self, child, tab_label, menu_label, position)

    /**
     * Insert a page into @notebook at the given position, specifying
     * the widget to use as the label in the popup menu.
     */
    fun insertPageMenu(
        child: Widget,
        tab_label: Widget,
        menu_label: Widget,
        position: Int
    ): Int = gtk_notebook_insert_page_menu(self, child.widgetPtr?.reinterpret(),
            tab_label.widgetPtr?.reinterpret(), menu_label.widgetPtr?.reinterpret(), position)

    /**
     * Switches to the next page. Nothing happens if the current page is
     * the last page.
     */
    fun nextPage(): Unit = gtk_notebook_next_page(self)

    /**
     * Finds the index of the page which contains the given child
     * widget.
     */
    fun pageNum(child: CPointer<GtkWidget>): Int = gtk_notebook_page_num(self, child)

    /**
     * Finds the index of the page which contains the given child
     * widget.
     */
    fun pageNum(child: Widget): Int = gtk_notebook_page_num(self, child.widgetPtr?.reinterpret())

    /**
     * Disables the popup menu.
     */
    fun popupDisable(): Unit = gtk_notebook_popup_disable(self)

    /**
     * Enables the popup menu: if the user clicks with the right
     * mouse button on the tab labels, a menu with all the pages
     * will be popped up.
     */
    fun popupEnable(): Unit = gtk_notebook_popup_enable(self)

    /**
     * Prepends a page to @notebook.
     */
    fun prependPage(child: CPointer<GtkWidget>, tab_label: CPointer<GtkWidget>): Int =
            gtk_notebook_prepend_page(self, child, tab_label)

    /**
     * Prepends a page to @notebook.
     */
    fun prependPage(child: Widget, tab_label: Widget): Int = gtk_notebook_prepend_page(self,
            child.widgetPtr?.reinterpret(), tab_label.widgetPtr?.reinterpret())

    /**
     * Prepends a page to @notebook, specifying the widget to use as the
     * label in the popup menu.
     */
    fun prependPageMenu(
        child: CPointer<GtkWidget>,
        tab_label: CPointer<GtkWidget>,
        menu_label: CPointer<GtkWidget>
    ): Int = gtk_notebook_prepend_page_menu(self, child, tab_label, menu_label)

    /**
     * Prepends a page to @notebook, specifying the widget to use as the
     * label in the popup menu.
     */
    fun prependPageMenu(
        child: Widget,
        tab_label: Widget,
        menu_label: Widget
    ): Int = gtk_notebook_prepend_page_menu(self, child.widgetPtr?.reinterpret(),
            tab_label.widgetPtr?.reinterpret(), menu_label.widgetPtr?.reinterpret())

    /**
     * Switches to the previous page. Nothing happens if the current page
     * is the first page.
     */
    fun prevPage(): Unit = gtk_notebook_prev_page(self)

    /**
     * Removes a page from the notebook given its index
     * in the notebook.
     */
    fun removePage(page_num: Int): Unit = gtk_notebook_remove_page(self, page_num)

    /**
     * Reorders the page containing @child, so that it appears in position
     * @position. If @position is greater than or equal to the number of
     * children in the list or negative, @child will be moved to the end
     * of the list.
     */
    fun reorderChild(child: CPointer<GtkWidget>, position: Int): Unit =
            gtk_notebook_reorder_child(self, child, position)

    /**
     * Reorders the page containing @child, so that it appears in position
     * @position. If @position is greater than or equal to the number of
     * children in the list or negative, @child will be moved to the end
     * of the list.
     */
    fun reorderChild(child: Widget, position: Int): Unit = gtk_notebook_reorder_child(self,
            child.widgetPtr?.reinterpret(), position)

    /**
     * Sets @widget as one of the action widgets. Depending on the pack type
     * the widget will be placed before or after the tabs. You can use
     * a #GtkBox if you need to pack more than one widget on the same side.
     *
     * Note that action widgets are “internal” children of the notebook and thus
     * not included in the list returned from gtk_container_foreach().
     */
    fun setActionWidget(widget: CPointer<GtkWidget>, pack_type: GtkPackType): Unit =
            gtk_notebook_set_action_widget(self, widget, pack_type)

    /**
     * Sets @widget as one of the action widgets. Depending on the pack type
     * the widget will be placed before or after the tabs. You can use
     * a #GtkBox if you need to pack more than one widget on the same side.
     *
     * Note that action widgets are “internal” children of the notebook and thus
     * not included in the list returned from gtk_container_foreach().
     */
    fun setActionWidget(widget: Widget, pack_type: GtkPackType): Unit =
            gtk_notebook_set_action_widget(self, widget.widgetPtr?.reinterpret(), pack_type)

    /**
     * Changes the menu label for the page containing @child.
     */
    fun setMenuLabel(child: CPointer<GtkWidget>, menu_label: CPointer<GtkWidget>): Unit =
            gtk_notebook_set_menu_label(self, child, menu_label)

    /**
     * Changes the menu label for the page containing @child.
     */
    fun setMenuLabel(child: Widget, menu_label: Widget): Unit = gtk_notebook_set_menu_label(self,
            child.widgetPtr?.reinterpret(), menu_label.widgetPtr?.reinterpret())

    /**
     * Creates a new label and sets it as the menu label of @child.
     */
    fun setMenuLabelText(child: CPointer<GtkWidget>, menu_text: String): Unit =
            gtk_notebook_set_menu_label_text(self, child, menu_text)

    /**
     * Creates a new label and sets it as the menu label of @child.
     */
    fun setMenuLabelText(child: Widget, menu_text: String): Unit =
            gtk_notebook_set_menu_label_text(self, child.widgetPtr?.reinterpret(), menu_text)

    /**
     * Sets whether the tab can be detached from @notebook to another
     * notebook or widget.
     *
     * Note that 2 notebooks must share a common group identificator
     * (see gtk_notebook_set_group_name()) to allow automatic tabs
     * interchange between them.
     *
     * If you want a widget to interact with a notebook through DnD
     * (i.e.: accept dragged tabs from it) it must be set as a drop
     * destination and accept the target “GTK_NOTEBOOK_TAB”. The notebook
     * will fill the selection with a GtkWidget** pointing to the child
     * widget that corresponds to the dropped tab.
     *
     * Note that you should use gtk_notebook_detach_tab() instead
     * of gtk_container_remove() if you want to remove the tab from
     * the source notebook as part of accepting a drop. Otherwise,
     * the source notebook will think that the dragged tab was
     * removed from underneath the ongoing drag operation, and
     * will initiate a drag cancel animation.
     *
     * |[<!-- language="C" -->
     *  static void
     *  on_drag_data_received (GtkWidget        *widget,
     *                         GdkDragContext   *context,
     *                         gint              x,
     *                         gint              y,
     *                         GtkSelectionData *data,
     *                         guint             info,
     *                         guint             time,
     *                         gpointer          user_data)
     *  {
     *    GtkWidget *notebook;
     *    GtkWidget **child;
     *
     *    notebook = gtk_drag_get_source_widget (context);
     *    child = (void*) gtk_selection_data_get_data (data);
     *
     *    // process_widget (*child);
     *
     *    gtk_notebook_detach_tab (GTK_NOTEBOOK (notebook), *child);
     *  }
     * ]|
     *
     * If you want a notebook to accept drags from other widgets,
     * you will have to set your own DnD code to do it.
     */
    fun setTabDetachable(child: CPointer<GtkWidget>, detachable: Boolean): Unit =
            gtk_notebook_set_tab_detachable(self, child,
            if (detachable) gtk_true() else gtk_false())

    /**
     * Sets whether the tab can be detached from @notebook to another
     * notebook or widget.
     *
     * Note that 2 notebooks must share a common group identificator
     * (see gtk_notebook_set_group_name()) to allow automatic tabs
     * interchange between them.
     *
     * If you want a widget to interact with a notebook through DnD
     * (i.e.: accept dragged tabs from it) it must be set as a drop
     * destination and accept the target “GTK_NOTEBOOK_TAB”. The notebook
     * will fill the selection with a GtkWidget** pointing to the child
     * widget that corresponds to the dropped tab.
     *
     * Note that you should use gtk_notebook_detach_tab() instead
     * of gtk_container_remove() if you want to remove the tab from
     * the source notebook as part of accepting a drop. Otherwise,
     * the source notebook will think that the dragged tab was
     * removed from underneath the ongoing drag operation, and
     * will initiate a drag cancel animation.
     *
     * |[<!-- language="C" -->
     *  static void
     *  on_drag_data_received (GtkWidget        *widget,
     *                         GdkDragContext   *context,
     *                         gint              x,
     *                         gint              y,
     *                         GtkSelectionData *data,
     *                         guint             info,
     *                         guint             time,
     *                         gpointer          user_data)
     *  {
     *    GtkWidget *notebook;
     *    GtkWidget **child;
     *
     *    notebook = gtk_drag_get_source_widget (context);
     *    child = (void*) gtk_selection_data_get_data (data);
     *
     *    // process_widget (*child);
     *
     *    gtk_notebook_detach_tab (GTK_NOTEBOOK (notebook), *child);
     *  }
     * ]|
     *
     * If you want a notebook to accept drags from other widgets,
     * you will have to set your own DnD code to do it.
     */
    fun setTabDetachable(child: Widget, detachable: Boolean): Unit =
            gtk_notebook_set_tab_detachable(self, child.widgetPtr?.reinterpret(),
            if (detachable) gtk_true() else gtk_false())

    /**
     * Changes the tab label for @child.
     * If %NULL is specified for @tab_label, then the page will
     * have the label “page N”.
     */
    fun setTabLabel(child: CPointer<GtkWidget>, tab_label: CPointer<GtkWidget>): Unit =
            gtk_notebook_set_tab_label(self, child, tab_label)

    /**
     * Changes the tab label for @child.
     * If %NULL is specified for @tab_label, then the page will
     * have the label “page N”.
     */
    fun setTabLabel(child: Widget, tab_label: Widget): Unit = gtk_notebook_set_tab_label(self,
            child.widgetPtr?.reinterpret(), tab_label.widgetPtr?.reinterpret())

    /**
     * Creates a new label and sets it as the tab label for the page
     * containing @child.
     */
    fun setTabLabelText(child: CPointer<GtkWidget>, tab_text: String): Unit =
            gtk_notebook_set_tab_label_text(self, child, tab_text)

    /**
     * Creates a new label and sets it as the tab label for the page
     * containing @child.
     */
    fun setTabLabelText(child: Widget, tab_text: String): Unit =
            gtk_notebook_set_tab_label_text(self, child.widgetPtr?.reinterpret(), tab_text)

    /**
     * Sets whether the notebook tab can be reordered
     * via drag and drop or not.
     */
    fun setTabReorderable(child: CPointer<GtkWidget>, reorderable: Boolean): Unit =
            gtk_notebook_set_tab_reorderable(self, child,
            if (reorderable) gtk_true() else gtk_false())

    /**
     * Sets whether the notebook tab can be reordered
     * via drag and drop or not.
     */
    fun setTabReorderable(child: Widget, reorderable: Boolean): Unit =
            gtk_notebook_set_tab_reorderable(self, child.widgetPtr?.reinterpret(),
            if (reorderable) gtk_true() else gtk_false())
}

package gtk3

import kotlin.Boolean
import kotlin.Int
import kotlin.String
import kotlin.Unit
import kotlinx.cinterop.CFunction
import kotlinx.cinterop.COpaquePointer
import kotlinx.cinterop.CPointed
import kotlinx.cinterop.CPointer
import kotlinx.cinterop.asStableRef
import kotlinx.cinterop.reinterpret
import kotlinx.cinterop.staticCFunction
import kotlinx.cinterop.toKString
import libgtk3.GtkAssistant
import libgtk3.GtkAssistantPageType
import libgtk3.GtkWidget
import libgtk3.gtk_assistant_add_action_widget
import libgtk3.gtk_assistant_append_page
import libgtk3.gtk_assistant_commit
import libgtk3.gtk_assistant_get_current_page
import libgtk3.gtk_assistant_get_n_pages
import libgtk3.gtk_assistant_get_nth_page
import libgtk3.gtk_assistant_get_page_complete
import libgtk3.gtk_assistant_get_page_has_padding
import libgtk3.gtk_assistant_get_page_title
import libgtk3.gtk_assistant_get_page_type
import libgtk3.gtk_assistant_insert_page
import libgtk3.gtk_assistant_new
import libgtk3.gtk_assistant_next_page
import libgtk3.gtk_assistant_prepend_page
import libgtk3.gtk_assistant_previous_page
import libgtk3.gtk_assistant_remove_action_widget
import libgtk3.gtk_assistant_remove_page
import libgtk3.gtk_assistant_set_current_page
import libgtk3.gtk_assistant_set_page_complete
import libgtk3.gtk_assistant_set_page_has_padding
import libgtk3.gtk_assistant_set_page_title
import libgtk3.gtk_assistant_set_page_type
import libgtk3.gtk_assistant_update_buttons_state
import libgtk3.gtk_false
import libgtk3.gtk_true

inline fun Container.assistant(init: Assistant.() -> Unit = {}): Assistant =
        Assistant().apply { init(); this@assistant.add(this) }

private fun Assistant_onApply_Handler(sender: CPointer<in CPointed>?, _data: COpaquePointer?) {
    _data?.asStableRef<Assistant>()?.get()?.onApply?.emit()
}

private fun Assistant_onCancel_Handler(sender: CPointer<in CPointed>?, _data: COpaquePointer?) {
    _data?.asStableRef<Assistant>()?.get()?.onCancel?.emit()
}

private fun Assistant_onClose_Handler(sender: CPointer<in CPointed>?, _data: COpaquePointer?) {
    _data?.asStableRef<Assistant>()?.get()?.onClose?.emit()
}

private fun Assistant_onEscape_Handler(sender: CPointer<in CPointed>?, _data: COpaquePointer?) {
    _data?.asStableRef<Assistant>()?.get()?.onEscape?.emit()
}

private fun Assistant_onPrepare_Handler(
    sender: CPointer<in CPointed>?,
    page: CPointer<GtkWidget>,
    _data: COpaquePointer?
) {
    _data?.asStableRef<Assistant>()?.get()?.onPrepare?.emit(page?.reinterpret())
}

/**
 * A #GtkAssistant is a widget used to represent a generally complex
 * operation splitted in several steps, guiding the user through its
 * pages and controlling the page flow to collect the necessary data.
 *
 * The design of GtkAssistant is that it controls what buttons to show
 * and to make sensitive, based on what it knows about the page sequence
 * and the [type][GtkAssistantPageType] of each page,
 * in addition to state information like the page
 * [completion][gtk-assistant-set-page-complete]
 * and [committed][gtk-assistant-commit] status.
 *
 * If you have a case that doesn’t quite fit in #GtkAssistants way of
 * handling buttons, you can use the #GTK_ASSISTANT_PAGE_CUSTOM page
 * type and handle buttons yourself.
 *
 * # GtkAssistant as GtkBuildable
 *
 * The GtkAssistant implementation of the #GtkBuildable interface
 * exposes the @action_area as internal children with the name
 * “action_area”.
 *
 * To add pages to an assistant in #GtkBuilder, simply add it as a
 * child to the GtkAssistant object, and set its child properties
 * as necessary.
 *
 * # CSS nodes
 *
 * GtkAssistant has a single CSS node with the name assistant.Returns the number of pages in the
        @assistant
 */
@GtkDsl
open class Assistant internal constructor(override val widgetPtr: CPointer<GtkWidget>? = null) :
        Window() {
    private val self: CPointer<GtkAssistant>?
        get() = widgetPtr!!.reinterpret()

    val assistant: CPointer<GtkAssistant>?
        get() = widgetPtr!!.reinterpret()

    val onApply: Signal<Assistant, CFunction<(CPointer<in CPointed>?, COpaquePointer?) -> Unit>> by
            lazy { Signal<Assistant, CFunction<(CPointer<in CPointed>?, COpaquePointer?) ->
            Unit>>(widgetPtr!!, this, "apply", staticCFunction(::Assistant_onApply_Handler)) }

    val onCancel: Signal<Assistant, CFunction<(CPointer<in CPointed>?, COpaquePointer?) -> Unit>> by
            lazy { Signal<Assistant, CFunction<(CPointer<in CPointed>?, COpaquePointer?) ->
            Unit>>(widgetPtr!!, this, "cancel", staticCFunction(::Assistant_onCancel_Handler)) }

    val onClose: Signal<Assistant, CFunction<(CPointer<in CPointed>?, COpaquePointer?) -> Unit>> by
            lazy { Signal<Assistant, CFunction<(CPointer<in CPointed>?, COpaquePointer?) ->
            Unit>>(widgetPtr!!, this, "close", staticCFunction(::Assistant_onClose_Handler)) }

    val onEscape: Signal<Assistant, CFunction<(CPointer<in CPointed>?, COpaquePointer?) -> Unit>> by
            lazy { Signal<Assistant, CFunction<(CPointer<in CPointed>?, COpaquePointer?) ->
            Unit>>(widgetPtr!!, this, "escape", staticCFunction(::Assistant_onEscape_Handler)) }

    val onPrepare: Signal1<Assistant, CPointer<GtkWidget>, CFunction<(
        CPointer<in CPointed>?,
        CPointer<GtkWidget>,
        COpaquePointer?
    ) -> Unit>> by lazy { Signal1<Assistant, CPointer<GtkWidget>, CFunction<(
                CPointer<in CPointed>?,
                CPointer<GtkWidget>,
                COpaquePointer?
            ) -> Unit>>(widgetPtr!!, this, "prepare",
                    staticCFunction(::Assistant_onPrepare_Handler)) }

    /**
     * Returns the page number of the current page.
     *
     * Switches the page to @page_num.
     *
     * Note that this will only be necessary in custom buttons,
     * as the @assistant flow can be set with
     * gtk_assistant_set_forward_page_func(). */
    var currentPage: Int
        get() = gtk_assistant_get_current_page(self)
        set(value) {
            gtk_assistant_set_current_page(self, value)
        }

    val nPages: Int
        get() = gtk_assistant_get_n_pages(self)

    /**
     * Creates a new #GtkAssistant. */
    constructor() : this(gtk_assistant_new()?.reinterpret())

    /**
     * Adds a widget to the action area of a #GtkAssistant.
     */
    fun addActionWidget(child: CPointer<GtkWidget>): Unit = gtk_assistant_add_action_widget(self,
            child)

    /**
     * Adds a widget to the action area of a #GtkAssistant.
     */
    fun addActionWidget(child: Widget): Unit = gtk_assistant_add_action_widget(self,
            child.widgetPtr?.reinterpret())

    /**
     * Appends a page to the @assistant.
     */
    fun appendPage(page: CPointer<GtkWidget>): Int = gtk_assistant_append_page(self, page)

    /**
     * Appends a page to the @assistant.
     */
    fun appendPage(page: Widget): Int = gtk_assistant_append_page(self,
            page.widgetPtr?.reinterpret())

    /**
     * Erases the visited page history so the back button is not
     * shown on the current page, and removes the cancel button
     * from subsequent pages.
     *
     * Use this when the information provided up to the current
     * page is hereafter deemed permanent and cannot be modified
     * or undone. For example, showing a progress page to track
     * a long-running, unreversible operation after the user has
     * clicked apply on a confirmation page.
     */
    fun commit(): Unit = gtk_assistant_commit(self)

    /**
     * Returns the child widget contained in page number @page_num.
     */
    fun getNthPage(page_num: Int): CPointer<GtkWidget> = gtk_assistant_get_nth_page(self,
            page_num)!!.reinterpret()

    /**
     * Gets whether @page is complete.
     */
    fun getPageComplete(page: CPointer<GtkWidget>): Boolean = gtk_assistant_get_page_complete(self,
            page) != 0

    /**
     * Gets whether @page is complete.
     */
    fun getPageComplete(page: Widget): Boolean = gtk_assistant_get_page_complete(self,
            page.widgetPtr?.reinterpret()) != 0

    /**
     * Gets whether page has padding.
     */
    fun getPageHasPadding(page: CPointer<GtkWidget>): Boolean =
            gtk_assistant_get_page_has_padding(self, page) != 0

    /**
     * Gets whether page has padding.
     */
    fun getPageHasPadding(page: Widget): Boolean = gtk_assistant_get_page_has_padding(self,
            page.widgetPtr?.reinterpret()) != 0

    /**
     * Gets the title for @page.
     */
    fun getPageTitle(page: CPointer<GtkWidget>): String = gtk_assistant_get_page_title(self,
            page)?.toKString() ?: ""

    /**
     * Gets the title for @page.
     */
    fun getPageTitle(page: Widget): String = gtk_assistant_get_page_title(self,
            page.widgetPtr?.reinterpret())?.toKString() ?: ""

    /**
     * Gets the page type of @page.
     */
    fun getPageType(page: CPointer<GtkWidget>): GtkAssistantPageType =
            gtk_assistant_get_page_type(self, page)

    /**
     * Gets the page type of @page.
     */
    fun getPageType(page: Widget): GtkAssistantPageType = gtk_assistant_get_page_type(self,
            page.widgetPtr?.reinterpret())

    /**
     * Inserts a page in the @assistant at a given position.
     */
    fun insertPage(page: CPointer<GtkWidget>, position: Int): Int = gtk_assistant_insert_page(self,
            page, position)

    /**
     * Inserts a page in the @assistant at a given position.
     */
    fun insertPage(page: Widget, position: Int): Int = gtk_assistant_insert_page(self,
            page.widgetPtr?.reinterpret(), position)

    /**
     * Navigate to the next page.
     *
     * It is a programming error to call this function when
     * there is no next page.
     *
     * This function is for use when creating pages of the
     * #GTK_ASSISTANT_PAGE_CUSTOM type.
     */
    fun nextPage(): Unit = gtk_assistant_next_page(self)

    /**
     * Prepends a page to the @assistant.
     */
    fun prependPage(page: CPointer<GtkWidget>): Int = gtk_assistant_prepend_page(self, page)

    /**
     * Prepends a page to the @assistant.
     */
    fun prependPage(page: Widget): Int = gtk_assistant_prepend_page(self,
            page.widgetPtr?.reinterpret())

    /**
     * Navigate to the previous visited page.
     *
     * It is a programming error to call this function when
     * no previous page is available.
     *
     * This function is for use when creating pages of the
     * #GTK_ASSISTANT_PAGE_CUSTOM type.
     */
    fun previousPage(): Unit = gtk_assistant_previous_page(self)

    /**
     * Removes a widget from the action area of a #GtkAssistant.
     */
    fun removeActionWidget(child: CPointer<GtkWidget>): Unit =
            gtk_assistant_remove_action_widget(self, child)

    /**
     * Removes a widget from the action area of a #GtkAssistant.
     */
    fun removeActionWidget(child: Widget): Unit = gtk_assistant_remove_action_widget(self,
            child.widgetPtr?.reinterpret())

    /**
     * Removes the @page_num’s page from @assistant.
     */
    fun removePage(page_num: Int): Unit = gtk_assistant_remove_page(self, page_num)

    /**
     * Sets whether @page contents are complete.
     *
     * This will make @assistant update the buttons state
     * to be able to continue the task.
     */
    fun setPageComplete(page: CPointer<GtkWidget>, complete: Boolean): Unit =
            gtk_assistant_set_page_complete(self, page, if (complete) gtk_true() else gtk_false())

    /**
     * Sets whether @page contents are complete.
     *
     * This will make @assistant update the buttons state
     * to be able to continue the task.
     */
    fun setPageComplete(page: Widget, complete: Boolean): Unit =
            gtk_assistant_set_page_complete(self, page.widgetPtr?.reinterpret(),
            if (complete) gtk_true() else gtk_false())

    /**
     * Sets whether the assistant is adding padding around
     * the page.
     */
    fun setPageHasPadding(page: CPointer<GtkWidget>, has_padding: Boolean): Unit =
            gtk_assistant_set_page_has_padding(self, page,
            if (has_padding) gtk_true() else gtk_false())

    /**
     * Sets whether the assistant is adding padding around
     * the page.
     */
    fun setPageHasPadding(page: Widget, has_padding: Boolean): Unit =
            gtk_assistant_set_page_has_padding(self, page.widgetPtr?.reinterpret(),
            if (has_padding) gtk_true() else gtk_false())

    /**
     * Sets a title for @page.
     *
     * The title is displayed in the header area of the assistant
     * when @page is the current page.
     */
    fun setPageTitle(page: CPointer<GtkWidget>, title: String): Unit =
            gtk_assistant_set_page_title(self, page, title)

    /**
     * Sets a title for @page.
     *
     * The title is displayed in the header area of the assistant
     * when @page is the current page.
     */
    fun setPageTitle(page: Widget, title: String): Unit = gtk_assistant_set_page_title(self,
            page.widgetPtr?.reinterpret(), title)

    /**
     * Sets the page type for @page.
     *
     * The page type determines the page behavior in the @assistant.
     */
    fun setPageType(page: CPointer<GtkWidget>, type: GtkAssistantPageType): Unit =
            gtk_assistant_set_page_type(self, page, type)

    /**
     * Sets the page type for @page.
     *
     * The page type determines the page behavior in the @assistant.
     */
    fun setPageType(page: Widget, type: GtkAssistantPageType): Unit =
            gtk_assistant_set_page_type(self, page.widgetPtr?.reinterpret(), type)

    /**
     * Forces @assistant to recompute the buttons state.
     *
     * GTK+ automatically takes care of this in most situations,
     * e.g. when the user goes to a different page, or when the
     * visibility or completeness of a page changes.
     *
     * One situation where it can be necessary to call this
     * function is when changing a value on the current page
     * affects the future page flow of the assistant.
     */
    fun updateButtonsState(): Unit = gtk_assistant_update_buttons_state(self)
}

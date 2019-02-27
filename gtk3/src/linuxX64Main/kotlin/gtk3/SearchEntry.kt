package gtk3

import kotlin.Boolean
import kotlin.Unit
import kotlinx.cinterop.CFunction
import kotlinx.cinterop.COpaquePointer
import kotlinx.cinterop.CPointed
import kotlinx.cinterop.CPointer
import kotlinx.cinterop.asStableRef
import kotlinx.cinterop.reinterpret
import kotlinx.cinterop.staticCFunction
import libgtk3.GdkEvent
import libgtk3.GtkSearchEntry
import libgtk3.GtkWidget
import libgtk3.gtk_search_entry_handle_event
import libgtk3.gtk_search_entry_new

inline fun Container.searchEntry(init: SearchEntry.() -> Unit = {}): SearchEntry =
        SearchEntry().apply { init(); this@searchEntry.add(this) }

private fun SearchEntry_onNextMatch_Handler(sender: CPointer<in CPointed>?, _data: COpaquePointer?)
        {
    _data?.asStableRef<SearchEntry>()?.get()?.onNextMatch?.emit()
}

private fun SearchEntry_onPreviousMatch_Handler(sender: CPointer<in CPointed>?, _data:
        COpaquePointer?) {
    _data?.asStableRef<SearchEntry>()?.get()?.onPreviousMatch?.emit()
}

private fun SearchEntry_onSearchChanged_Handler(sender: CPointer<in CPointed>?, _data:
        COpaquePointer?) {
    _data?.asStableRef<SearchEntry>()?.get()?.onSearchChanged?.emit()
}

private fun SearchEntry_onStopSearch_Handler(sender: CPointer<in CPointed>?, _data: COpaquePointer?)
        {
    _data?.asStableRef<SearchEntry>()?.get()?.onStopSearch?.emit()
}

/**
 * #GtkSearchEntry is a subclass of #GtkEntry that has been
 * tailored for use as a search entry.
 *
 * It will show an inactive symbolic “find” icon when the search
 * entry is empty, and a symbolic “clear” icon when there is text.
 * Clicking on the “clear” icon will empty the search entry.
 *
 * Note that the search/clear icon is shown using a secondary
 * icon, and thus does not work if you are using the secondary
 * icon position for some other purpose.
 *
 * To make filtering appear more reactive, it is a good idea to
 * not react to every change in the entry text immediately, but
 * only after a short delay. To support this, #GtkSearchEntry
 * emits the #GtkSearchEntry::search-changed signal which can
 * be used instead of the #GtkEditable::changed signal.
 *
 * The #GtkSearchEntry::previous-match, #GtkSearchEntry::next-match
 * and #GtkSearchEntry::stop-search signals can be used to implement
 * moving between search results and ending the search.
 *
 * Often, GtkSearchEntry will be fed events by means of being
 * placed inside a #GtkSearchBar. If that is not the case,
 * you can use gtk_search_entry_handle_event() to pass events.
 */
@GtkDsl
open class SearchEntry internal constructor(override val widgetPtr: CPointer<GtkWidget>? = null) :
        Entry() {
    private val self: CPointer<GtkSearchEntry>?
        get() = widgetPtr!!.reinterpret()

    val searchEntry: CPointer<GtkSearchEntry>?
        get() = widgetPtr!!.reinterpret()

    val onNextMatch: Signal<SearchEntry, CFunction<(CPointer<in CPointed>?, COpaquePointer?) ->
            Unit>> by lazy { Signal<SearchEntry, CFunction<(CPointer<in CPointed>?,
            COpaquePointer?) -> Unit>>(widgetPtr!!, this, "next-match",
            staticCFunction(::SearchEntry_onNextMatch_Handler)) }

    val onPreviousMatch: Signal<SearchEntry, CFunction<(CPointer<in CPointed>?, COpaquePointer?) ->
            Unit>> by lazy { Signal<SearchEntry, CFunction<(CPointer<in CPointed>?,
            COpaquePointer?) -> Unit>>(widgetPtr!!, this, "previous-match",
            staticCFunction(::SearchEntry_onPreviousMatch_Handler)) }

    val onSearchChanged: Signal<SearchEntry, CFunction<(CPointer<in CPointed>?, COpaquePointer?) ->
            Unit>> by lazy { Signal<SearchEntry, CFunction<(CPointer<in CPointed>?,
            COpaquePointer?) -> Unit>>(widgetPtr!!, this, "search-changed",
            staticCFunction(::SearchEntry_onSearchChanged_Handler)) }

    val onStopSearch: Signal<SearchEntry, CFunction<(CPointer<in CPointed>?, COpaquePointer?) ->
            Unit>> by lazy { Signal<SearchEntry, CFunction<(CPointer<in CPointed>?,
            COpaquePointer?) -> Unit>>(widgetPtr!!, this, "stop-search",
            staticCFunction(::SearchEntry_onStopSearch_Handler)) }

    /**
     * Creates a #GtkSearchEntry, with a find icon when the search field is
     * empty, and a clear icon when it isn't. */
    constructor() : this(gtk_search_entry_new()?.reinterpret())

    /**
     * This function should be called when the top-level window
     * which contains the search entry received a key event. If
     * the entry is part of a #GtkSearchBar, it is preferable
     * to call gtk_search_bar_handle_event() instead, which will
     * reveal the entry in addition to passing the event to this
     * function.
     *
     * If the key event is handled by the search entry and starts
     * or continues a search, %GDK_EVENT_STOP will be returned.
     * The caller should ensure that the entry is shown in this
     * case, and not propagate the event further.
     */
    fun handleEvent(event: CPointer<GdkEvent>): Boolean = gtk_search_entry_handle_event(self,
            event) != 0
}

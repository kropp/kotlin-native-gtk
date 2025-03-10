package gtk3

import kotlin.Boolean
import kotlin.Int
import kotlin.UInt
import kotlin.Unit
import kotlinx.cinterop.CFunction
import kotlinx.cinterop.COpaquePointer
import kotlinx.cinterop.CPointed
import kotlinx.cinterop.CPointer
import kotlinx.cinterop.asStableRef
import kotlinx.cinterop.reinterpret
import kotlinx.cinterop.staticCFunction
import libgtk3.GtkCalendar
import libgtk3.GtkCalendarDisplayOptions
import libgtk3.GtkWidget
import libgtk3.gtk_calendar_clear_marks
import libgtk3.gtk_calendar_get_day_is_marked
import libgtk3.gtk_calendar_get_detail_height_rows
import libgtk3.gtk_calendar_get_detail_width_chars
import libgtk3.gtk_calendar_get_display_options
import libgtk3.gtk_calendar_mark_day
import libgtk3.gtk_calendar_new
import libgtk3.gtk_calendar_select_day
import libgtk3.gtk_calendar_select_month
import libgtk3.gtk_calendar_set_detail_height_rows
import libgtk3.gtk_calendar_set_detail_width_chars
import libgtk3.gtk_calendar_set_display_options
import libgtk3.gtk_calendar_unmark_day

inline fun Container.calendar(init: Calendar.() -> Unit = {}): Calendar = Calendar().apply { init();
        this@calendar.add(this) }

private fun Calendar_onDaySelected_Handler(sender: CPointer<in CPointed>?, _data: COpaquePointer?) {
    _data?.asStableRef<Calendar>()?.get()?.onDaySelected?.emit()
}

private fun Calendar_onDaySelectedDoubleClick_Handler(sender: CPointer<in CPointed>?, _data:
        COpaquePointer?) {
    _data?.asStableRef<Calendar>()?.get()?.onDaySelectedDoubleClick?.emit()
}

private fun Calendar_onMonthChanged_Handler(sender: CPointer<in CPointed>?, _data: COpaquePointer?)
        {
    _data?.asStableRef<Calendar>()?.get()?.onMonthChanged?.emit()
}

private fun Calendar_onNextMonth_Handler(sender: CPointer<in CPointed>?, _data: COpaquePointer?) {
    _data?.asStableRef<Calendar>()?.get()?.onNextMonth?.emit()
}

private fun Calendar_onNextYear_Handler(sender: CPointer<in CPointed>?, _data: COpaquePointer?) {
    _data?.asStableRef<Calendar>()?.get()?.onNextYear?.emit()
}

private fun Calendar_onPrevMonth_Handler(sender: CPointer<in CPointed>?, _data: COpaquePointer?) {
    _data?.asStableRef<Calendar>()?.get()?.onPrevMonth?.emit()
}

private fun Calendar_onPrevYear_Handler(sender: CPointer<in CPointed>?, _data: COpaquePointer?) {
    _data?.asStableRef<Calendar>()?.get()?.onPrevYear?.emit()
}

/**
 * #GtkCalendar is a widget that displays a Gregorian calendar, one month
 * at a time. It can be created with gtk_calendar_new().
 *
 * The month and year currently displayed can be altered with
 * gtk_calendar_select_month(). The exact day can be selected from the
 * displayed month using gtk_calendar_select_day().
 *
 * To place a visual marker on a particular day, use gtk_calendar_mark_day()
 * and to remove the marker, gtk_calendar_unmark_day(). Alternative, all
 * marks can be cleared with gtk_calendar_clear_marks().
 *
 * The way in which the calendar itself is displayed can be altered using
 * gtk_calendar_set_display_options().
 *
 * The selected date can be retrieved from a #GtkCalendar using
 * gtk_calendar_get_date().
 *
 * Users should be aware that, although the Gregorian calendar is the
 * legal calendar in most countries, it was adopted progressively
 * between 1582 and 1929. Display before these dates is likely to be
 * historically incorrect.
 */
@GtkDsl
open class Calendar internal constructor(override val widgetPtr: CPointer<GtkWidget>? = null) :
        Widget() {
    private val self: CPointer<GtkCalendar>?
        get() = widgetPtr!!.reinterpret()

    val calendar: CPointer<GtkCalendar>?
        get() = widgetPtr!!.reinterpret()

    val onDaySelected: Signal<Calendar, CFunction<(CPointer<in CPointed>?, COpaquePointer?) ->
            Unit>> by lazy { Signal<Calendar, CFunction<(CPointer<in CPointed>?, COpaquePointer?) ->
            Unit>>(widgetPtr!!, this, "day-selected",
            staticCFunction(::Calendar_onDaySelected_Handler)) }

    val onDaySelectedDoubleClick: Signal<Calendar, CFunction<(CPointer<in CPointed>?,
            COpaquePointer?) -> Unit>> by lazy { Signal<Calendar, CFunction<(CPointer<in CPointed>?,
            COpaquePointer?) -> Unit>>(widgetPtr!!, this, "day-selected-double-click",
            staticCFunction(::Calendar_onDaySelectedDoubleClick_Handler)) }

    val onMonthChanged: Signal<Calendar, CFunction<(CPointer<in CPointed>?, COpaquePointer?) ->
            Unit>> by lazy { Signal<Calendar, CFunction<(CPointer<in CPointed>?, COpaquePointer?) ->
            Unit>>(widgetPtr!!, this, "month-changed",
            staticCFunction(::Calendar_onMonthChanged_Handler)) }

    val onNextMonth: Signal<Calendar, CFunction<(CPointer<in CPointed>?, COpaquePointer?) -> Unit>>
            by lazy { Signal<Calendar, CFunction<(CPointer<in CPointed>?, COpaquePointer?) ->
            Unit>>(widgetPtr!!, this, "next-month", staticCFunction(::Calendar_onNextMonth_Handler))
            }

    val onNextYear: Signal<Calendar, CFunction<(CPointer<in CPointed>?, COpaquePointer?) -> Unit>>
            by lazy { Signal<Calendar, CFunction<(CPointer<in CPointed>?, COpaquePointer?) ->
            Unit>>(widgetPtr!!, this, "next-year", staticCFunction(::Calendar_onNextYear_Handler)) }

    val onPrevMonth: Signal<Calendar, CFunction<(CPointer<in CPointed>?, COpaquePointer?) -> Unit>>
            by lazy { Signal<Calendar, CFunction<(CPointer<in CPointed>?, COpaquePointer?) ->
            Unit>>(widgetPtr!!, this, "prev-month", staticCFunction(::Calendar_onPrevMonth_Handler))
            }

    val onPrevYear: Signal<Calendar, CFunction<(CPointer<in CPointed>?, COpaquePointer?) -> Unit>>
            by lazy { Signal<Calendar, CFunction<(CPointer<in CPointed>?, COpaquePointer?) ->
            Unit>>(widgetPtr!!, this, "prev-year", staticCFunction(::Calendar_onPrevYear_Handler)) }

    /**
     * Queries the height of detail cells, in rows.
     * See #GtkCalendar:detail-width-chars.
     *
     * Updates the height of detail cells.
     * See #GtkCalendar:detail-height-rows. */
    var detailHeightRows: Int
        get() = gtk_calendar_get_detail_height_rows(self)
        set(value) {
            gtk_calendar_set_detail_height_rows(self, value)
        }

    /**
     * Queries the width of detail cells, in characters.
     * See #GtkCalendar:detail-width-chars.
     *
     * Updates the width of detail cells.
     * See #GtkCalendar:detail-width-chars. */
    var detailWidthChars: Int
        get() = gtk_calendar_get_detail_width_chars(self)
        set(value) {
            gtk_calendar_set_detail_width_chars(self, value)
        }

    /**
     * Returns the current display options of @calendar.
     *
     * Sets display options (whether to display the heading and the month
     * headings). */
    var displayOptions: GtkCalendarDisplayOptions
        get() = gtk_calendar_get_display_options(self)
        set(value) {
            gtk_calendar_set_display_options(self, value)
        }

    /**
     * Creates a new calendar, with the current date being selected. */
    constructor() : this(gtk_calendar_new()?.reinterpret())

    /**
     * Remove all visual markers.
     */
    fun clearMarks(): Unit = gtk_calendar_clear_marks(self)

    /**
     * Returns if the @day of the @calendar is already marked.
     */
    fun getDayIsMarked(day: UInt): Boolean = gtk_calendar_get_day_is_marked(self, day) != 0

    /**
     * Places a visual marker on a particular day.
     */
    fun markDay(day: UInt): Unit = gtk_calendar_mark_day(self, day)

    /**
     * Selects a day from the current month.
     */
    fun selectDay(day: UInt): Unit = gtk_calendar_select_day(self, day)

    /**
     * Shifts the calendar to a different month.
     */
    fun selectMonth(month: UInt, year: UInt): Unit = gtk_calendar_select_month(self, month, year)

    /**
     * Removes the visual marker from a particular day.
     */
    fun unmarkDay(day: UInt): Unit = gtk_calendar_unmark_day(self, day)
}

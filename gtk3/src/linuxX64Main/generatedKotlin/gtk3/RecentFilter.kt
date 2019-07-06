package gtk3

import kotlin.Boolean
import kotlin.Int
import kotlin.String
import kotlin.Unit
import kotlinx.cinterop.CPointer
import kotlinx.cinterop.toKString
import libgtk3.GtkRecentFilter
import libgtk3.GtkRecentFilterFlags
import libgtk3.GtkRecentFilterInfo
import libgtk3.gtk_recent_filter_add_age
import libgtk3.gtk_recent_filter_add_application
import libgtk3.gtk_recent_filter_add_group
import libgtk3.gtk_recent_filter_add_mime_type
import libgtk3.gtk_recent_filter_add_pattern
import libgtk3.gtk_recent_filter_add_pixbuf_formats
import libgtk3.gtk_recent_filter_filter
import libgtk3.gtk_recent_filter_get_name
import libgtk3.gtk_recent_filter_get_needed
import libgtk3.gtk_recent_filter_new
import libgtk3.gtk_recent_filter_set_name

/**
 * A #GtkRecentFilter can be used to restrict the files being shown
 * in a #GtkRecentChooser.  Files can be filtered based on their name
 * (with gtk_recent_filter_add_pattern()), on their mime type (with
 * gtk_file_filter_add_mime_type()), on the application that has
 * registered them (with gtk_recent_filter_add_application()), or by
 * a custom filter function (with gtk_recent_filter_add_custom()).
 *
 * Filtering by mime type handles aliasing and subclassing of mime
 * types; e.g. a filter for text/plain also matches a file with mime
 * type application/rtf, since application/rtf is a subclass of text/plain.
 * Note that #GtkRecentFilter allows wildcards for the subtype of a
 * mime type, so you can e.g. filter for image/\*.
 *
 * Normally, filters are used by adding them to a #GtkRecentChooser,
 * see gtk_recent_chooser_add_filter(), but it is also possible to
 * manually use a filter on a file with gtk_recent_filter_filter().
 *
 * Recently used files are supported since GTK+ 2.10.
 *
 * ## GtkRecentFilter as GtkBuildable
 *
 * The GtkRecentFilter implementation of the GtkBuildable interface
 * supports adding rules using the <mime-types>, <patterns> and
 * <applications> elements and listing the rules within. Specifying
 * a <mime-type>, <pattern> or <application> has the same effect as
 * calling gtk_recent_filter_add_mime_type(),
 * gtk_recent_filter_add_pattern() or gtk_recent_filter_add_application().
 *
 * An example of a UI definition fragment specifying GtkRecentFilter rules:
 * |[
 * <object class="GtkRecentFilter">
 *   <mime-types>
 *     <mime-type>text/plain</mime-type>
 *     <mime-type>image/png</mime-type>
 *   </mime-types>
 *   <patterns>
 *     <pattern>*.txt</pattern>
 *     <pattern>*.png</pattern>
 *   </patterns>
 *   <applications>
 *     <application>gimp</application>
 *     <application>gedit</application>
 *     <application>glade</application>
 *   </applications>
 * </object>
 * ]|Gets the fields that need to be filled in for the #GtkRecentFilterInfo
 * passed to gtk_recent_filter_filter()
 *
 * This function will not typically be used by applications; it
 * is intended principally for use in the implementation of
 * #GtkRecentChooser. */
@GtkDsl
open class RecentFilter() {
    val widgetPtr: CPointer<GtkRecentFilter> = gtk_recent_filter_new()!!

    private val self: CPointer<GtkRecentFilter>
        get() = widgetPtr

    /**
     * Gets the human-readable name for the filter.
     * See gtk_recent_filter_set_name().
     *
     * Sets the human-readable name of the filter; this is the string
     * that will be displayed in the recently used resources selector
     * user interface if there is a selectable list of filters. */
    var name: String
        get() = gtk_recent_filter_get_name(self)?.toKString() ?: ""
        set(value) {
            gtk_recent_filter_set_name(self, value)
        }

    val needed: GtkRecentFilterFlags
        get() = gtk_recent_filter_get_needed(self)

    /**
     * Adds a rule that allows resources based on their age - that is, the number
     * of days elapsed since they were last modified.
     */
    fun addAge(days: Int): Unit = gtk_recent_filter_add_age(self, days)

    /**
     * Adds a rule that allows resources based on the name of the application
     * that has registered them.
     */
    fun addApplication(application: String): Unit = gtk_recent_filter_add_application(self,
            application)

    /**
     * Adds a rule that allows resources based on the name of the group
     * to which they belong
     */
    fun addGroup(group: String): Unit = gtk_recent_filter_add_group(self, group)

    /**
     * Adds a rule that allows resources based on their registered MIME type.
     */
    fun addMimeType(mime_type: String): Unit = gtk_recent_filter_add_mime_type(self, mime_type)

    /**
     * Adds a rule that allows resources based on a pattern matching their
     * display name.
     */
    fun addPattern(pattern: String): Unit = gtk_recent_filter_add_pattern(self, pattern)

    /**
     * Adds a rule allowing image files in the formats supported
     * by GdkPixbuf.
     */
    fun addPixbufFormats(): Unit = gtk_recent_filter_add_pixbuf_formats(self)

    /**
     * Tests whether a file should be displayed according to @filter.
     * The #GtkRecentFilterInfo @filter_info should include
     * the fields returned from gtk_recent_filter_get_needed(), and
     * must set the #GtkRecentFilterInfo.contains field of @filter_info
     * to indicate which fields have been set.
     *
     * This function will not typically be used by applications; it
     * is intended principally for use in the implementation of
     * #GtkRecentChooser.
     */
    fun filter(filter_info: CPointer<GtkRecentFilterInfo>): Boolean = gtk_recent_filter_filter(self,
            filter_info) != 0
}

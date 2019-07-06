package gtk3

import kotlin.Boolean
import kotlin.String
import kotlin.Unit
import kotlinx.cinterop.CPointer
import kotlinx.cinterop.reinterpret
import kotlinx.cinterop.toKString
import libgtk3.GVariant
import libgtk3.GtkFileFilter
import libgtk3.GtkFileFilterFlags
import libgtk3.GtkFileFilterInfo
import libgtk3.gtk_file_filter_add_mime_type
import libgtk3.gtk_file_filter_add_pattern
import libgtk3.gtk_file_filter_add_pixbuf_formats
import libgtk3.gtk_file_filter_filter
import libgtk3.gtk_file_filter_get_name
import libgtk3.gtk_file_filter_get_needed
import libgtk3.gtk_file_filter_new
import libgtk3.gtk_file_filter_set_name
import libgtk3.gtk_file_filter_to_gvariant

/**
 * A GtkFileFilter can be used to restrict the files being shown in a
 * #GtkFileChooser. Files can be filtered based on their name (with
 * gtk_file_filter_add_pattern()), on their mime type (with
 * gtk_file_filter_add_mime_type()), or by a custom filter function
 * (with gtk_file_filter_add_custom()).
 *
 * Filtering by mime types handles aliasing and subclassing of mime
 * types; e.g. a filter for text/plain also matches a file with mime
 * type application/rtf, since application/rtf is a subclass of
 * text/plain. Note that #GtkFileFilter allows wildcards for the
 * subtype of a mime type, so you can e.g. filter for image/\*.
 *
 * Normally, filters are used by adding them to a #GtkFileChooser,
 * see gtk_file_chooser_add_filter(), but it is also possible
 * to manually use a filter on a file with gtk_file_filter_filter().
 *
 * # GtkFileFilter as GtkBuildable
 *
 * The GtkFileFilter implementation of the GtkBuildable interface
 * supports adding rules using the <mime-types>, <patterns> and
 * <applications> elements and listing the rules within. Specifying
 * a <mime-type> or <pattern> has the same effect as as calling
 * gtk_file_filter_add_mime_type() or gtk_file_filter_add_pattern().
 *
 * An example of a UI definition fragment specifying GtkFileFilter
 * rules:
 * |[
 * <object class="GtkFileFilter">
 *   <mime-types>
 *     <mime-type>text/plain</mime-type>
 *     <mime-type>image/ *</mime-type>
 *   </mime-types>
 *   <patterns>
 *     <pattern>*.txt</pattern>
 *     <pattern>*.png</pattern>
 *   </patterns>
 * </object>
 * ]|Gets the fields that need to be filled in for the #GtkFileFilterInfo
 * passed to gtk_file_filter_filter()
 *
 * This function will not typically be used by applications; it
 * is intended principally for use in the implementation of
 * #GtkFileChooser. */
@GtkDsl
open class FileFilter() {
    val widgetPtr: CPointer<GtkFileFilter> = gtk_file_filter_new()!!

    private val self: CPointer<GtkFileFilter>
        get() = widgetPtr

    /**
     * Gets the human-readable name for the filter. See gtk_file_filter_set_name().
     *
     * Sets the human-readable name of the filter; this is the string
     * that will be displayed in the file selector user interface if
     * there is a selectable list of filters. */
    var name: String
        get() = gtk_file_filter_get_name(self)?.toKString() ?: ""
        set(value) {
            gtk_file_filter_set_name(self, value)
        }

    val needed: GtkFileFilterFlags
        get() = gtk_file_filter_get_needed(self)

    /**
     * Adds a rule allowing a given mime type to @filter.
     */
    fun addMimeType(mime_type: String): Unit = gtk_file_filter_add_mime_type(self, mime_type)

    /**
     * Adds a rule allowing a shell style glob to a filter.
     */
    fun addPattern(pattern: String): Unit = gtk_file_filter_add_pattern(self, pattern)

    /**
     * Adds a rule allowing image files in the formats supported
     * by GdkPixbuf.
     */
    fun addPixbufFormats(): Unit = gtk_file_filter_add_pixbuf_formats(self)

    /**
     * Tests whether a file should be displayed according to @filter.
     * The #GtkFileFilterInfo @filter_info should include
     * the fields returned from gtk_file_filter_get_needed().
     *
     * This function will not typically be used by applications; it
     * is intended principally for use in the implementation of
     * #GtkFileChooser.
     */
    fun filter(filter_info: CPointer<GtkFileFilterInfo>): Boolean = gtk_file_filter_filter(self,
            filter_info) != 0

    /**
     * Serialize a file filter to an a{sv} variant.
     */
    fun toGvariant(): CPointer<GVariant> = gtk_file_filter_to_gvariant(self)!!.reinterpret()
}

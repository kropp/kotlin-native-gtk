@file:Suppress("unused")

package gtk3

import kotlin.ExperimentalUnsignedTypes
import kotlin.String
import kotlin.Suppress
import kotlin.collections.List
import kotlinx.cinterop.CPointer
import kotlinx.cinterop.cstr
import kotlinx.cinterop.memScoped
import kotlinx.cinterop.ptr
import kotlinx.cinterop.reinterpret
import kotlinx.cinterop.toCValues
import libgtk3.GtkAboutDialog
import libgtk3.gtk_about_dialog_get_authors
import libgtk3.gtk_about_dialog_set_authors

@GtkDsl
@ExperimentalUnsignedTypes
abstract class AboutDialog : Dialog() {
    private val self: CPointer<GtkAboutDialog>
        get() = widgetPtr!!.reinterpret()

    /**
     * Returns the string which are displayed in the authors tab
     * of the secondary credits dialog.
     *
     * Sets the strings which are displayed in the authors tab
     * of the secondary credits dialog. */
    var authors: List<String>
        get() = gtk_about_dialog_get_authors(self).toList()
        set(value) {
            gtk_about_dialog_set_authors(self, memScoped { (value.map { it.cstr.ptr } +
                    listOf(null)).toCValues() })
        }
}

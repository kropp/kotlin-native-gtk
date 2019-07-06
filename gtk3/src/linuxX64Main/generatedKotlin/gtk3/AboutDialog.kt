package gtk3

import kotlin.Boolean
import kotlin.String
import kotlin.Unit
import kotlin.collections.List
import kotlinx.cinterop.ByteVar
import kotlinx.cinterop.CFunction
import kotlinx.cinterop.COpaquePointer
import kotlinx.cinterop.CPointed
import kotlinx.cinterop.CPointer
import kotlinx.cinterop.asStableRef
import kotlinx.cinterop.cstr
import kotlinx.cinterop.memScoped
import kotlinx.cinterop.ptr
import kotlinx.cinterop.reinterpret
import kotlinx.cinterop.staticCFunction
import kotlinx.cinterop.toCValues
import kotlinx.cinterop.toKString
import libgtk3.GdkPixbuf
import libgtk3.GtkAboutDialog
import libgtk3.GtkLicense
import libgtk3.GtkWidget
import libgtk3.gtk_about_dialog_add_credit_section
import libgtk3.gtk_about_dialog_get_artists
import libgtk3.gtk_about_dialog_get_authors
import libgtk3.gtk_about_dialog_get_comments
import libgtk3.gtk_about_dialog_get_copyright
import libgtk3.gtk_about_dialog_get_documenters
import libgtk3.gtk_about_dialog_get_license
import libgtk3.gtk_about_dialog_get_license_type
import libgtk3.gtk_about_dialog_get_logo
import libgtk3.gtk_about_dialog_get_logo_icon_name
import libgtk3.gtk_about_dialog_get_program_name
import libgtk3.gtk_about_dialog_get_translator_credits
import libgtk3.gtk_about_dialog_get_version
import libgtk3.gtk_about_dialog_get_website
import libgtk3.gtk_about_dialog_get_website_label
import libgtk3.gtk_about_dialog_get_wrap_license
import libgtk3.gtk_about_dialog_new
import libgtk3.gtk_about_dialog_set_artists
import libgtk3.gtk_about_dialog_set_authors
import libgtk3.gtk_about_dialog_set_comments
import libgtk3.gtk_about_dialog_set_copyright
import libgtk3.gtk_about_dialog_set_documenters
import libgtk3.gtk_about_dialog_set_license
import libgtk3.gtk_about_dialog_set_license_type
import libgtk3.gtk_about_dialog_set_logo
import libgtk3.gtk_about_dialog_set_logo_icon_name
import libgtk3.gtk_about_dialog_set_program_name
import libgtk3.gtk_about_dialog_set_translator_credits
import libgtk3.gtk_about_dialog_set_version
import libgtk3.gtk_about_dialog_set_website
import libgtk3.gtk_about_dialog_set_website_label
import libgtk3.gtk_about_dialog_set_wrap_license
import libgtk3.gtk_false
import libgtk3.gtk_true

inline fun Container.aboutDialog(init: AboutDialog.() -> Unit = {}): AboutDialog =
        AboutDialog().apply { init(); this@aboutDialog.add(this) }

private fun AboutDialog_onActivateLink_Handler(
    sender: CPointer<in CPointed>?,
    uri: CPointer<ByteVar>,
    _data: COpaquePointer?
) {
    _data?.asStableRef<AboutDialog>()?.get()?.onActivateLink?.emit(uri.toKString())
}

/**
 * The GtkAboutDialog offers a simple way to display information about
 * a program like its logo, name, copyright, website and license. It is
 * also possible to give credits to the authors, documenters, translators
 * and artists who have worked on the program. An about dialog is typically
 * opened when the user selects the `About` option from the `Help` menu.
 * All parts of the dialog are optional.
 *
 * About dialogs often contain links and email addresses. GtkAboutDialog
 * displays these as clickable links. By default, it calls gtk_show_uri_on_window()
 * when a user clicks one. The behaviour can be overridden with the
 * #GtkAboutDialog::activate-link signal.
 *
 * To specify a person with an email address, use a string like
 * "Edgar Allan Poe <edgar\@poe.com>". To specify a website with a title,
 * use a string like "GTK+ team http://www.gtk.org".
 *
 * To make constructing a GtkAboutDialog as convenient as possible, you can
 * use the function gtk_show_about_dialog() which constructs and shows a dialog
 * and keeps it around so that it can be shown again.
 *
 * Note that GTK+ sets a default title of `_("About %s")` on the dialog
 * window (where \%s is replaced by the name of the application, but in
 * order to ensure proper translation of the title, applications should
 * set the title property explicitly when constructing a GtkAboutDialog,
 * as shown in the following example:
 * |[<!-- language="C" -->
 * GdkPixbuf *example_logo = gdk_pixbuf_new_from_file ("./logo.png", NULL);
 * gtk_show_about_dialog (NULL,
 *                        "program-name", "ExampleCode",
 *                        "logo", example_logo,
 *                        "title", _("About ExampleCode"),
 *                        NULL);
 * ]|
 *
 * It is also possible to show a #GtkAboutDialog like any other #GtkDialog,
 * e.g. using gtk_dialog_run(). In this case, you might need to know that
 * the “Close” button returns the #GTK_RESPONSE_CANCEL response id.
 */
@GtkDsl
open class AboutDialog internal constructor(override val widgetPtr: CPointer<GtkWidget>? = null) :
        Dialog() {
    private val self: CPointer<GtkAboutDialog>?
        get() = widgetPtr!!.reinterpret()

    val aboutDialog: CPointer<GtkAboutDialog>?
        get() = widgetPtr!!.reinterpret()

    val onActivateLink: Signal1<AboutDialog, String, CFunction<(
        CPointer<in CPointed>?,
        CPointer<ByteVar>,
        COpaquePointer?
    ) -> Unit>> by lazy { Signal1<AboutDialog, String, CFunction<(
                CPointer<in CPointed>?,
                CPointer<ByteVar>,
                COpaquePointer?
            ) -> Unit>>(widgetPtr!!, this, "activate-link",
                    staticCFunction(::AboutDialog_onActivateLink_Handler)) }

    /**
     * Returns the string which are displayed in the artists tab
     * of the secondary credits dialog.
     *
     * Sets the strings which are displayed in the artists tab
     * of the secondary credits dialog. */
    var artists: List<String>
        get() = gtk_about_dialog_get_artists(self).toList()
        set(value) {
            gtk_about_dialog_set_artists(self, memScoped { (value.map { it.cstr.ptr } +
                    listOf(null)).toCValues() })
        }

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

    /**
     * Returns the comments string.
     *
     * Sets the comments string to display in the about dialog.
     * This should be a short string of one or two lines. */
    var comments: String
        get() = gtk_about_dialog_get_comments(self)?.toKString() ?: ""
        set(value) {
            gtk_about_dialog_set_comments(self, value)
        }

    /**
     * Returns the copyright string.
     *
     * Sets the copyright string to display in the about dialog.
     * This should be a short string of one or two lines. */
    var copyright: String
        get() = gtk_about_dialog_get_copyright(self)?.toKString() ?: ""
        set(value) {
            gtk_about_dialog_set_copyright(self, value)
        }

    /**
     * Returns the string which are displayed in the documenters
     * tab of the secondary credits dialog.
     *
     * Sets the strings which are displayed in the documenters tab
     * of the secondary credits dialog. */
    var documenters: List<String>
        get() = gtk_about_dialog_get_documenters(self).toList()
        set(value) {
            gtk_about_dialog_set_documenters(self, memScoped { (value.map { it.cstr.ptr } +
                    listOf(null)).toCValues() })
        }

    /**
     * Returns the license information.
     *
     * Sets the license information to be displayed in the secondary
     * license dialog. If @license is %NULL, the license button is
     * hidden. */
    var license: String
        get() = gtk_about_dialog_get_license(self)?.toKString() ?: ""
        set(value) {
            gtk_about_dialog_set_license(self, value)
        }

    /**
     * Retrieves the license set using gtk_about_dialog_set_license_type()
     *
     * Sets the license of the application showing the @about dialog from a
     * list of known licenses.
     *
     * This function overrides the license set using
     * gtk_about_dialog_set_license(). */
    var licenseType: GtkLicense
        get() = gtk_about_dialog_get_license_type(self)
        set(value) {
            gtk_about_dialog_set_license_type(self, value)
        }

    /**
     * Returns the pixbuf displayed as logo in the about dialog.
     *
     * Sets the pixbuf to be displayed as logo in the about dialog.
     * If it is %NULL, the default window icon set with
     * gtk_window_set_default_icon() will be used. */
    var logo: CPointer<GdkPixbuf>
        get() = gtk_about_dialog_get_logo(self)!!.reinterpret()
        set(value) {
            gtk_about_dialog_set_logo(self, value?.reinterpret())
        }

    /**
     * Returns the icon name displayed as logo in the about dialog.
     *
     * Sets the pixbuf to be displayed as logo in the about dialog.
     * If it is %NULL, the default window icon set with
     * gtk_window_set_default_icon() will be used. */
    var logoIconName: String
        get() = gtk_about_dialog_get_logo_icon_name(self)?.toKString() ?: ""
        set(value) {
            gtk_about_dialog_set_logo_icon_name(self, value)
        }

    /**
     * Returns the program name displayed in the about dialog.
     *
     * Sets the name to display in the about dialog.
     * If this is not set, it defaults to g_get_application_name(). */
    var programName: String
        get() = gtk_about_dialog_get_program_name(self)?.toKString() ?: ""
        set(value) {
            gtk_about_dialog_set_program_name(self, value)
        }

    /**
     * Returns the translator credits string which is displayed
     * in the translators tab of the secondary credits dialog.
     *
     * Sets the translator credits string which is displayed in
     * the translators tab of the secondary credits dialog.
     *
     * The intended use for this string is to display the translator
     * of the language which is currently used in the user interface.
     * Using gettext(), a simple way to achieve that is to mark the
     * string for translation:
     * |[<!-- language="C" -->
     * GtkWidget *about = gtk_about_dialog_new ();
     * gtk_about_dialog_set_translator_credits (GTK_ABOUT_DIALOG (about),
     *                                          _("translator-credits"));
     * ]|
     * It is a good idea to use the customary msgid “translator-credits” for this
     * purpose, since translators will already know the purpose of that msgid, and
     * since #GtkAboutDialog will detect if “translator-credits” is untranslated
     * and hide the tab. */
    var translatorCredits: String
        get() = gtk_about_dialog_get_translator_credits(self)?.toKString() ?: ""
        set(value) {
            gtk_about_dialog_set_translator_credits(self, value)
        }

    /**
     * Returns the version string.
     *
     * Sets the version string to display in the about dialog. */
    var version: String
        get() = gtk_about_dialog_get_version(self)?.toKString() ?: ""
        set(value) {
            gtk_about_dialog_set_version(self, value)
        }

    /**
     * Returns the website URL.
     *
     * Sets the URL to use for the website link. */
    var website: String
        get() = gtk_about_dialog_get_website(self)?.toKString() ?: ""
        set(value) {
            gtk_about_dialog_set_website(self, value)
        }

    /**
     * Returns the label used for the website link.
     *
     * Sets the label to be used for the website link. */
    var websiteLabel: String
        get() = gtk_about_dialog_get_website_label(self)?.toKString() ?: ""
        set(value) {
            gtk_about_dialog_set_website_label(self, value)
        }

    /**
     * Returns whether the license text in @about is
     * automatically wrapped.
     *
     * Sets whether the license text in @about is
     * automatically wrapped. */
    var wrapLicense: Boolean
        get() = gtk_about_dialog_get_wrap_license(self) != 0
        set(value) {
            gtk_about_dialog_set_wrap_license(self, if (value) gtk_true() else gtk_false())
        }

    /**
     * Creates a new #GtkAboutDialog. */
    constructor() : this(gtk_about_dialog_new()?.reinterpret())

    /**
     * Creates a new section in the Credits page.
     */
    fun addCreditSection(section_name: String, people: List<String>): Unit =
            gtk_about_dialog_add_credit_section(self, section_name, memScoped { (people.map {
            it.cstr.ptr } + listOf(null)).toCValues() })
}

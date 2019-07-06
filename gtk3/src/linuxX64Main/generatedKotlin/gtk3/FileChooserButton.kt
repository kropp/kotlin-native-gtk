package gtk3

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
import libgtk3.GtkFileChooserAction
import libgtk3.GtkFileChooserButton
import libgtk3.GtkWidget
import libgtk3.gtk_file_chooser_button_get_title
import libgtk3.gtk_file_chooser_button_get_width_chars
import libgtk3.gtk_file_chooser_button_new
import libgtk3.gtk_file_chooser_button_set_title
import libgtk3.gtk_file_chooser_button_set_width_chars

inline fun Container.fileChooserButton(
    title: String,
    action: GtkFileChooserAction,
    init: FileChooserButton.() -> Unit = {}
): FileChooserButton = FileChooserButton(title, action).apply { init();
        this@fileChooserButton.add(this) }

private fun FileChooserButton_onFileSet_Handler(sender: CPointer<in CPointed>?, _data:
        COpaquePointer?) {
    _data?.asStableRef<FileChooserButton>()?.get()?.onFileSet?.emit()
}

/**
 * The #GtkFileChooserButton is a widget that lets the user select a
 * file.  It implements the #GtkFileChooser interface.  Visually, it is a
 * file name with a button to bring up a #GtkFileChooserDialog.
 * The user can then use that dialog to change the file associated with
 * that button.  This widget does not support setting the
 * #GtkFileChooser:select-multiple property to %TRUE.
 *
 * ## Create a button to let the user select a file in /etc
 *
 * |[<!-- language="C" -->
 * {
 *   GtkWidget *button;
 *
 *   button = gtk_file_chooser_button_new (_("Select a file"),
 *                                         GTK_FILE_CHOOSER_ACTION_OPEN);
 *   gtk_file_chooser_set_current_folder (GTK_FILE_CHOOSER (button),
 *                                        "/etc");
 * }
 * ]|
 *
 * The #GtkFileChooserButton supports the #GtkFileChooserActions
 * %GTK_FILE_CHOOSER_ACTION_OPEN and %GTK_FILE_CHOOSER_ACTION_SELECT_FOLDER.
 *
 * > The #GtkFileChooserButton will ellipsize the label, and will thus
 * > request little horizontal space.  To give the button more space,
 * > you should call gtk_widget_get_preferred_size(),
 * > gtk_file_chooser_button_set_width_chars(), or pack the button in
 * > such a way that other interface elements give space to the
 * > widget.
 */
@GtkDsl
open class FileChooserButton internal constructor(override val widgetPtr: CPointer<GtkWidget>? =
        null) : Box() {
    private val self: CPointer<GtkFileChooserButton>?
        get() = widgetPtr!!.reinterpret()

    val fileChooserButton: CPointer<GtkFileChooserButton>?
        get() = widgetPtr!!.reinterpret()

    val onFileSet: Signal<FileChooserButton, CFunction<(CPointer<in CPointed>?, COpaquePointer?) ->
            Unit>> by lazy { Signal<FileChooserButton, CFunction<(CPointer<in CPointed>?,
            COpaquePointer?) -> Unit>>(widgetPtr!!, this, "file-set",
            staticCFunction(::FileChooserButton_onFileSet_Handler)) }

    /**
     * Retrieves the title of the browse dialog used by @button. The returned value
     * should not be modified or freed.
     *
     * Modifies the @title of the browse dialog used by @button. */
    var title: String
        get() = gtk_file_chooser_button_get_title(self)?.toKString() ?: ""
        set(value) {
            gtk_file_chooser_button_set_title(self, value)
        }

    /**
     * Retrieves the width in characters of the @button widget’s entry and/or label.
     *
     * Sets the width (in characters) that @button will use to @n_chars. */
    var widthChars: Int
        get() = gtk_file_chooser_button_get_width_chars(self)
        set(value) {
            gtk_file_chooser_button_set_width_chars(self, value)
        }

    /**
     * Creates a new file-selecting button widget. */
    constructor(title: String, action: GtkFileChooserAction) :
            this(gtk_file_chooser_button_new(title, action)?.reinterpret())
}

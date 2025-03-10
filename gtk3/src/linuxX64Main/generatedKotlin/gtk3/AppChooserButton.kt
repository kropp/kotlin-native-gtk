package gtk3

import kotlin.Boolean
import kotlin.String
import kotlin.Unit
import kotlinx.cinterop.ByteVar
import kotlinx.cinterop.CFunction
import kotlinx.cinterop.COpaquePointer
import kotlinx.cinterop.CPointed
import kotlinx.cinterop.CPointer
import kotlinx.cinterop.asStableRef
import kotlinx.cinterop.reinterpret
import kotlinx.cinterop.staticCFunction
import kotlinx.cinterop.toKString
import libgtk3.GIcon
import libgtk3.GtkAppChooserButton
import libgtk3.GtkWidget
import libgtk3.gtk_app_chooser_button_append_custom_item
import libgtk3.gtk_app_chooser_button_append_separator
import libgtk3.gtk_app_chooser_button_get_heading
import libgtk3.gtk_app_chooser_button_get_show_default_item
import libgtk3.gtk_app_chooser_button_get_show_dialog_item
import libgtk3.gtk_app_chooser_button_new
import libgtk3.gtk_app_chooser_button_set_active_custom_item
import libgtk3.gtk_app_chooser_button_set_heading
import libgtk3.gtk_app_chooser_button_set_show_default_item
import libgtk3.gtk_app_chooser_button_set_show_dialog_item
import libgtk3.gtk_false
import libgtk3.gtk_true

inline fun Container.appChooserButton(content_type: String, init: AppChooserButton.() -> Unit = {}):
        AppChooserButton = AppChooserButton(content_type).apply { init();
        this@appChooserButton.add(this) }

private fun AppChooserButton_onCustomItemActivated_Handler(
    sender: CPointer<in CPointed>?,
    item_name: CPointer<ByteVar>,
    _data: COpaquePointer?
) {
    _data?.asStableRef<AppChooserButton>()?.get()?.onCustomItemActivated?.emit(item_name.toKString())
}

/**
 * The #GtkAppChooserButton is a widget that lets the user select
 * an application. It implements the #GtkAppChooser interface.
 *
 * Initially, a #GtkAppChooserButton selects the first application
 * in its list, which will either be the most-recently used application
 * or, if #GtkAppChooserButton:show-default-item is %TRUE, the
 * default application.
 *
 * The list of applications shown in a #GtkAppChooserButton includes
 * the recommended applications for the given content type. When
 * #GtkAppChooserButton:show-default-item is set, the default application
 * is also included. To let the user chooser other applications,
 * you can set the #GtkAppChooserButton:show-dialog-item property,
 * which allows to open a full #GtkAppChooserDialog.
 *
 * It is possible to add custom items to the list, using
 * gtk_app_chooser_button_append_custom_item(). These items cause
 * the #GtkAppChooserButton::custom-item-activated signal to be
 * emitted when they are selected.
 *
 * To track changes in the selected application, use the
 * #GtkComboBox::changed signal.
 */
@GtkDsl
open class AppChooserButton internal constructor(override val widgetPtr: CPointer<GtkWidget>? =
        null) : ComboBox() {
    private val self: CPointer<GtkAppChooserButton>?
        get() = widgetPtr!!.reinterpret()

    val appChooserButton: CPointer<GtkAppChooserButton>?
        get() = widgetPtr!!.reinterpret()

    val onCustomItemActivated: Signal1<AppChooserButton, String, CFunction<(
        CPointer<in CPointed>?,
        CPointer<ByteVar>,
        COpaquePointer?
    ) -> Unit>> by lazy { Signal1<AppChooserButton, String, CFunction<(
                CPointer<in CPointed>?,
                CPointer<ByteVar>,
                COpaquePointer?
            ) -> Unit>>(widgetPtr!!, this, "custom-item-activated",
                    staticCFunction(::AppChooserButton_onCustomItemActivated_Handler)) }

    /**
     * Returns the text to display at the top of the dialog.
     *
     * Sets the text to display at the top of the dialog.
     * If the heading is not set, the dialog displays a default text. */
    var heading: String
        get() = gtk_app_chooser_button_get_heading(self)?.toKString() ?: ""
        set(value) {
            gtk_app_chooser_button_set_heading(self, value)
        }

    /**
     * Returns the current value of the #GtkAppChooserButton:show-default-item
     * property.
     *
     * Sets whether the dropdown menu of this button should show the
     * default application for the given content type at top. */
    var showDefaultItem: Boolean
        get() = gtk_app_chooser_button_get_show_default_item(self) != 0
        set(value) {
            gtk_app_chooser_button_set_show_default_item(self,
                    if (value) gtk_true() else gtk_false())
        }

    /**
     * Returns the current value of the #GtkAppChooserButton:show-dialog-item
     * property.
     *
     * Sets whether the dropdown menu of this button should show an
     * entry to trigger a #GtkAppChooserDialog. */
    var showDialogItem: Boolean
        get() = gtk_app_chooser_button_get_show_dialog_item(self) != 0
        set(value) {
            gtk_app_chooser_button_set_show_dialog_item(self,
                    if (value) gtk_true() else gtk_false())
        }

    /**
     * Creates a new #GtkAppChooserButton for applications
     * that can handle content of the given type. */
    constructor(content_type: String) :
            this(gtk_app_chooser_button_new(content_type)?.reinterpret())

    /**
     * Appends a custom item to the list of applications that is shown
     * in the popup; the item name must be unique per-widget.
     * Clients can use the provided name as a detail for the
     * #GtkAppChooserButton::custom-item-activated signal, to add a
     * callback for the activation of a particular custom item in the list.
     * See also gtk_app_chooser_button_append_separator().
     */
    fun appendCustomItem(
        name: String,
        label: String,
        icon: CPointer<GIcon>
    ): Unit = gtk_app_chooser_button_append_custom_item(self, name, label, icon)

    /**
     * Appends a separator to the list of applications that is shown
     * in the popup.
     */
    fun appendSeparator(): Unit = gtk_app_chooser_button_append_separator(self)

    /**
     * Selects a custom item previously added with
     * gtk_app_chooser_button_append_custom_item().
     *
     * Use gtk_app_chooser_refresh() to bring the selection
     * to its initial state.
     */
    fun setActiveCustomItem(name: String): Unit =
            gtk_app_chooser_button_set_active_custom_item(self, name)
}

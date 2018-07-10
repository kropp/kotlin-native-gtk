package gtk3

import kotlin.Boolean
import kotlin.String
import kotlin.Unit
import kotlinx.cinterop.CFunction
import kotlinx.cinterop.COpaquePointer
import kotlinx.cinterop.CPointer
import kotlinx.cinterop.asStableRef
import kotlinx.cinterop.reinterpret
import kotlinx.cinterop.staticCFunction
import kotlinx.cinterop.toKString
import libgtk3.GAppInfo
import libgtk3.GtkAppChooserWidget
import libgtk3.GtkMenu
import libgtk3.GtkWidget
import libgtk3.gtk_app_chooser_widget_get_default_text
import libgtk3.gtk_app_chooser_widget_get_show_all
import libgtk3.gtk_app_chooser_widget_get_show_default
import libgtk3.gtk_app_chooser_widget_get_show_fallback
import libgtk3.gtk_app_chooser_widget_get_show_other
import libgtk3.gtk_app_chooser_widget_get_show_recommended
import libgtk3.gtk_app_chooser_widget_new
import libgtk3.gtk_app_chooser_widget_set_default_text
import libgtk3.gtk_app_chooser_widget_set_show_all
import libgtk3.gtk_app_chooser_widget_set_show_default
import libgtk3.gtk_app_chooser_widget_set_show_fallback
import libgtk3.gtk_app_chooser_widget_set_show_other
import libgtk3.gtk_app_chooser_widget_set_show_recommended
import libgtk3.gtk_false
import libgtk3.gtk_true

inline fun Container.appChooserWidget(content_type: String, init: AppChooserWidget.() -> Unit = {}): AppChooserWidget = AppChooserWidget(content_type).apply { init(); this@appChooserWidget.add(this) }

private fun AppChooserWidget_onApplicationActivated_Handler(
        sender: CPointer<*>?,
        application: CPointer<GAppInfo>?,
        data: COpaquePointer?
) {
    data?.asStableRef<AppChooserWidget>()?.get()?.onApplicationActivated?.invoke(application)
}

private fun AppChooserWidget_onApplicationSelected_Handler(
        sender: CPointer<*>?,
        application: CPointer<GAppInfo>?,
        data: COpaquePointer?
) {
    data?.asStableRef<AppChooserWidget>()?.get()?.onApplicationSelected?.invoke(application)
}

private fun AppChooserWidget_onPopulatePopup_Handler(
        sender: CPointer<*>?,
        menu: CPointer<GtkMenu>?,
        application: CPointer<GAppInfo>?,
        data: COpaquePointer?
) {
    data?.asStableRef<AppChooserWidget>()?.get()?.onPopulatePopup?.invoke(menu, application)
}

/**
 * #GtkAppChooserWidget is a widget for selecting applications.
 * It is the main building block for #GtkAppChooserDialog. Most
 * applications only need to use the latter; but you can use
 * this widget as part of a larger widget if you have special needs.
 *
 * #GtkAppChooserWidget offers detailed control over what applications
 * are shown, using the
 * #GtkAppChooserWidget:show-default,
 * #GtkAppChooserWidget:show-recommended,
 * #GtkAppChooserWidget:show-fallback,
 * #GtkAppChooserWidget:show-other and
 * #GtkAppChooserWidget:show-all
 * properties. See the #GtkAppChooser documentation for more information
 * about these groups of applications.
 *
 * To keep track of the selected application, use the
 * #GtkAppChooserWidget::application-selected and #GtkAppChooserWidget::application-activated signals.
 *
 * # CSS nodes
 *
 * GtkAppChooserWidget has a single CSS node with name appchooser. */
@GtkDsl
open class AppChooserWidget internal constructor(override val widgetPtr: CPointer<GtkWidget>? = null) : Box() {
    private val self: CPointer<GtkAppChooserWidget>?
        get() = widgetPtr!!.reinterpret()

    val appChooserWidget: CPointer<GtkAppChooserWidget>?
        get() = widgetPtr!!.reinterpret()

    val onApplicationActivated: Signal1<AppChooserWidget, CPointer<GAppInfo>?, CFunction<(
            CPointer<*>?,
            CPointer<GAppInfo>?,
            COpaquePointer?
    ) -> Unit>> by lazy { Signal1<AppChooserWidget, CPointer<GAppInfo>?, CFunction<(
                    CPointer<*>?,
                    CPointer<GAppInfo>?,
                    COpaquePointer?
            ) -> Unit>>(widgetPtr!!, this, "application-activated", staticCFunction(::AppChooserWidget_onApplicationActivated_Handler)) }

    val onApplicationSelected: Signal1<AppChooserWidget, CPointer<GAppInfo>?, CFunction<(
            CPointer<*>?,
            CPointer<GAppInfo>?,
            COpaquePointer?
    ) -> Unit>> by lazy { Signal1<AppChooserWidget, CPointer<GAppInfo>?, CFunction<(
                    CPointer<*>?,
                    CPointer<GAppInfo>?,
                    COpaquePointer?
            ) -> Unit>>(widgetPtr!!, this, "application-selected", staticCFunction(::AppChooserWidget_onApplicationSelected_Handler)) }

    val onPopulatePopup: Signal2<AppChooserWidget, CPointer<GtkMenu>?, CPointer<GAppInfo>?, CFunction<(
            CPointer<*>?,
            CPointer<GtkMenu>?,
            CPointer<GAppInfo>?,
            COpaquePointer?
    ) -> Unit>> by lazy { Signal2<AppChooserWidget, CPointer<GtkMenu>?, CPointer<GAppInfo>?, CFunction<(
                    CPointer<*>?,
                    CPointer<GtkMenu>?,
                    CPointer<GAppInfo>?,
                    COpaquePointer?
            ) -> Unit>>(widgetPtr!!, this, "populate-popup", staticCFunction(::AppChooserWidget_onPopulatePopup_Handler)) }

    var defaultText: String
        /**
         * Returns the text that is shown if there are not applications
         * that can handle the content type. */
        get() = gtk_app_chooser_widget_get_default_text(self)?.toKString() ?: ""
        /**
         * Sets the text that is shown if there are not applications
         * that can handle the content type. */
        set(value) {
            gtk_app_chooser_widget_set_default_text(self, value)
        }

    var showAll: Boolean
        /**
         * Returns the current value of the #GtkAppChooserWidget:show-all
         * property. */
        get() = gtk_app_chooser_widget_get_show_all(self) != 0
        /**
         * Sets whether the app chooser should show all applications
         * in a flat list. */
        set(value) {
            gtk_app_chooser_widget_set_show_all(self, if (value) gtk_true() else gtk_false())
        }

    var showDefault: Boolean
        /**
         * Returns the current value of the #GtkAppChooserWidget:show-default
         * property. */
        get() = gtk_app_chooser_widget_get_show_default(self) != 0
        /**
         * Sets whether the app chooser should show the default handler
         * for the content type in a separate section. */
        set(value) {
            gtk_app_chooser_widget_set_show_default(self, if (value) gtk_true() else gtk_false())
        }

    var showFallback: Boolean
        /**
         * Returns the current value of the #GtkAppChooserWidget:show-fallback
         * property. */
        get() = gtk_app_chooser_widget_get_show_fallback(self) != 0
        /**
         * Sets whether the app chooser should show related applications
         * for the content type in a separate section. */
        set(value) {
            gtk_app_chooser_widget_set_show_fallback(self, if (value) gtk_true() else gtk_false())
        }

    var showOther: Boolean
        /**
         * Returns the current value of the #GtkAppChooserWidget:show-other
         * property. */
        get() = gtk_app_chooser_widget_get_show_other(self) != 0
        /**
         * Sets whether the app chooser should show applications
         * which are unrelated to the content type. */
        set(value) {
            gtk_app_chooser_widget_set_show_other(self, if (value) gtk_true() else gtk_false())
        }

    var showRecommended: Boolean
        /**
         * Returns the current value of the #GtkAppChooserWidget:show-recommended
         * property. */
        get() = gtk_app_chooser_widget_get_show_recommended(self) != 0
        /**
         * Sets whether the app chooser should show recommended applications
         * for the content type in a separate section. */
        set(value) {
            gtk_app_chooser_widget_set_show_recommended(self, if (value) gtk_true() else gtk_false())
        }

    /**
     * Creates a new #GtkAppChooserWidget for applications
     * that can handle content of the given type. */
    constructor(content_type: String) : this(gtk_app_chooser_widget_new(content_type)?.reinterpret())
}

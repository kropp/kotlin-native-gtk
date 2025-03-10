package gtk3

import kotlin.Int
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
import libgtk3.GtkFileChooserAction
import libgtk3.GtkFileChooserWidget
import libgtk3.GtkWidget
import libgtk3.gtk_file_chooser_widget_new

inline fun Container.fileChooserWidget(action: GtkFileChooserAction, init: FileChooserWidget.() ->
        Unit = {}): FileChooserWidget = FileChooserWidget(action).apply { init();
        this@fileChooserWidget.add(this) }

private fun FileChooserWidget_onDesktopFolder_Handler(sender: CPointer<in CPointed>?, _data:
        COpaquePointer?) {
    _data?.asStableRef<FileChooserWidget>()?.get()?.onDesktopFolder?.emit()
}

private fun FileChooserWidget_onDownFolder_Handler(sender: CPointer<in CPointed>?, _data:
        COpaquePointer?) {
    _data?.asStableRef<FileChooserWidget>()?.get()?.onDownFolder?.emit()
}

private fun FileChooserWidget_onHomeFolder_Handler(sender: CPointer<in CPointed>?, _data:
        COpaquePointer?) {
    _data?.asStableRef<FileChooserWidget>()?.get()?.onHomeFolder?.emit()
}

private fun FileChooserWidget_onLocationPopup_Handler(
    sender: CPointer<in CPointed>?,
    path: CPointer<ByteVar>,
    _data: COpaquePointer?
) {
    _data?.asStableRef<FileChooserWidget>()?.get()?.onLocationPopup?.emit(path.toKString())
}

private fun FileChooserWidget_onLocationPopupOnPaste_Handler(sender: CPointer<in CPointed>?, _data:
        COpaquePointer?) {
    _data?.asStableRef<FileChooserWidget>()?.get()?.onLocationPopupOnPaste?.emit()
}

private fun FileChooserWidget_onLocationTogglePopup_Handler(sender: CPointer<in CPointed>?, _data:
        COpaquePointer?) {
    _data?.asStableRef<FileChooserWidget>()?.get()?.onLocationTogglePopup?.emit()
}

private fun FileChooserWidget_onPlacesShortcut_Handler(sender: CPointer<in CPointed>?, _data:
        COpaquePointer?) {
    _data?.asStableRef<FileChooserWidget>()?.get()?.onPlacesShortcut?.emit()
}

private fun FileChooserWidget_onQuickBookmark_Handler(
    sender: CPointer<in CPointed>?,
    bookmark_index: Int,
    _data: COpaquePointer?
) {
    _data?.asStableRef<FileChooserWidget>()?.get()?.onQuickBookmark?.emit(bookmark_index)
}

private fun FileChooserWidget_onRecentShortcut_Handler(sender: CPointer<in CPointed>?, _data:
        COpaquePointer?) {
    _data?.asStableRef<FileChooserWidget>()?.get()?.onRecentShortcut?.emit()
}

private fun FileChooserWidget_onSearchShortcut_Handler(sender: CPointer<in CPointed>?, _data:
        COpaquePointer?) {
    _data?.asStableRef<FileChooserWidget>()?.get()?.onSearchShortcut?.emit()
}

private fun FileChooserWidget_onShowHidden_Handler(sender: CPointer<in CPointed>?, _data:
        COpaquePointer?) {
    _data?.asStableRef<FileChooserWidget>()?.get()?.onShowHidden?.emit()
}

private fun FileChooserWidget_onUpFolder_Handler(sender: CPointer<in CPointed>?, _data:
        COpaquePointer?) {
    _data?.asStableRef<FileChooserWidget>()?.get()?.onUpFolder?.emit()
}

/**
 * #GtkFileChooserWidget is a widget for choosing files.
 * It exposes the #GtkFileChooser interface, and you should
 * use the methods of this interface to interact with the
 * widget.
 *
 * # CSS nodes
 *
 * GtkFileChooserWidget has a single CSS node with name filechooser.
 */
@GtkDsl
open class FileChooserWidget internal constructor(override val widgetPtr: CPointer<GtkWidget>? =
        null) : Box() {
    private val self: CPointer<GtkFileChooserWidget>?
        get() = widgetPtr!!.reinterpret()

    val fileChooserWidget: CPointer<GtkFileChooserWidget>?
        get() = widgetPtr!!.reinterpret()

    val onDesktopFolder: Signal<FileChooserWidget, CFunction<(CPointer<in CPointed>?,
            COpaquePointer?) -> Unit>> by lazy { Signal<FileChooserWidget, CFunction<(CPointer<in
            CPointed>?, COpaquePointer?) -> Unit>>(widgetPtr!!, this, "desktop-folder",
            staticCFunction(::FileChooserWidget_onDesktopFolder_Handler)) }

    val onDownFolder: Signal<FileChooserWidget, CFunction<(CPointer<in CPointed>?,
            COpaquePointer?) -> Unit>> by lazy { Signal<FileChooserWidget, CFunction<(CPointer<in
            CPointed>?, COpaquePointer?) -> Unit>>(widgetPtr!!, this, "down-folder",
            staticCFunction(::FileChooserWidget_onDownFolder_Handler)) }

    val onHomeFolder: Signal<FileChooserWidget, CFunction<(CPointer<in CPointed>?,
            COpaquePointer?) -> Unit>> by lazy { Signal<FileChooserWidget, CFunction<(CPointer<in
            CPointed>?, COpaquePointer?) -> Unit>>(widgetPtr!!, this, "home-folder",
            staticCFunction(::FileChooserWidget_onHomeFolder_Handler)) }

    val onLocationPopup: Signal1<FileChooserWidget, String, CFunction<(
        CPointer<in CPointed>?,
        CPointer<ByteVar>,
        COpaquePointer?
    ) -> Unit>> by lazy { Signal1<FileChooserWidget, String, CFunction<(
                CPointer<in CPointed>?,
                CPointer<ByteVar>,
                COpaquePointer?
            ) -> Unit>>(widgetPtr!!, this, "location-popup",
                    staticCFunction(::FileChooserWidget_onLocationPopup_Handler)) }

    val onLocationPopupOnPaste: Signal<FileChooserWidget, CFunction<(CPointer<in CPointed>?,
            COpaquePointer?) -> Unit>> by lazy { Signal<FileChooserWidget, CFunction<(CPointer<in
            CPointed>?, COpaquePointer?) -> Unit>>(widgetPtr!!, this, "location-popup-on-paste",
            staticCFunction(::FileChooserWidget_onLocationPopupOnPaste_Handler)) }

    val onLocationTogglePopup: Signal<FileChooserWidget, CFunction<(CPointer<in CPointed>?,
            COpaquePointer?) -> Unit>> by lazy { Signal<FileChooserWidget, CFunction<(CPointer<in
            CPointed>?, COpaquePointer?) -> Unit>>(widgetPtr!!, this, "location-toggle-popup",
            staticCFunction(::FileChooserWidget_onLocationTogglePopup_Handler)) }

    val onPlacesShortcut: Signal<FileChooserWidget, CFunction<(CPointer<in CPointed>?,
            COpaquePointer?) -> Unit>> by lazy { Signal<FileChooserWidget, CFunction<(CPointer<in
            CPointed>?, COpaquePointer?) -> Unit>>(widgetPtr!!, this, "places-shortcut",
            staticCFunction(::FileChooserWidget_onPlacesShortcut_Handler)) }

    val onQuickBookmark: Signal1<FileChooserWidget, Int, CFunction<(
        CPointer<in CPointed>?,
        Int,
        COpaquePointer?
    ) -> Unit>> by lazy { Signal1<FileChooserWidget, Int, CFunction<(
                CPointer<in CPointed>?,
                Int,
                COpaquePointer?
            ) -> Unit>>(widgetPtr!!, this, "quick-bookmark",
                    staticCFunction(::FileChooserWidget_onQuickBookmark_Handler)) }

    val onRecentShortcut: Signal<FileChooserWidget, CFunction<(CPointer<in CPointed>?,
            COpaquePointer?) -> Unit>> by lazy { Signal<FileChooserWidget, CFunction<(CPointer<in
            CPointed>?, COpaquePointer?) -> Unit>>(widgetPtr!!, this, "recent-shortcut",
            staticCFunction(::FileChooserWidget_onRecentShortcut_Handler)) }

    val onSearchShortcut: Signal<FileChooserWidget, CFunction<(CPointer<in CPointed>?,
            COpaquePointer?) -> Unit>> by lazy { Signal<FileChooserWidget, CFunction<(CPointer<in
            CPointed>?, COpaquePointer?) -> Unit>>(widgetPtr!!, this, "search-shortcut",
            staticCFunction(::FileChooserWidget_onSearchShortcut_Handler)) }

    val onShowHidden: Signal<FileChooserWidget, CFunction<(CPointer<in CPointed>?,
            COpaquePointer?) -> Unit>> by lazy { Signal<FileChooserWidget, CFunction<(CPointer<in
            CPointed>?, COpaquePointer?) -> Unit>>(widgetPtr!!, this, "show-hidden",
            staticCFunction(::FileChooserWidget_onShowHidden_Handler)) }

    val onUpFolder: Signal<FileChooserWidget, CFunction<(CPointer<in CPointed>?, COpaquePointer?) ->
            Unit>> by lazy { Signal<FileChooserWidget, CFunction<(CPointer<in CPointed>?,
            COpaquePointer?) -> Unit>>(widgetPtr!!, this, "up-folder",
            staticCFunction(::FileChooserWidget_onUpFolder_Handler)) }

    /**
     * Creates a new #GtkFileChooserWidget. This is a file chooser widget that can
     * be embedded in custom windows, and it is the same widget that is used by
     * #GtkFileChooserDialog. */
    constructor(action: GtkFileChooserAction) :
            this(gtk_file_chooser_widget_new(action)?.reinterpret())
}

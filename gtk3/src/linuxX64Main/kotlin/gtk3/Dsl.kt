package gtk3

import libgtk3.*

inline fun Container.vbox(init: Box.() -> Unit) = box(GtkOrientation.GTK_ORIENTATION_VERTICAL, 0, init)
inline fun Container.hbox(init: Box.() -> Unit) = box(GtkOrientation.GTK_ORIENTATION_HORIZONTAL, 0, init)

inline fun Container.vbbox(init: ButtonBox.() -> Unit) = buttonBox(GtkOrientation.GTK_ORIENTATION_VERTICAL, init)
inline fun Container.hbbox(init: ButtonBox.() -> Unit) = buttonBox(GtkOrientation.GTK_ORIENTATION_HORIZONTAL, init)

inline fun window(init: Window.() -> Unit) = Window(GtkWindowType.GTK_WINDOW_TOPLEVEL).apply(init)

inline fun Window.headerBar(init: HeaderBar.() -> Unit) =
        HeaderBar().apply {
            init()
            this@headerBar.titlebar = widgetPtr!!
        }

inline fun Container.imageButton(id: String, init: Button.() -> Unit = {}) = button {
    image = gtk_image_new_from_icon_name(id, GtkIconSize.GTK_ICON_SIZE_SMALL_TOOLBAR)!!
    val context = gtk_widget_get_style_context(widgetPtr)
    gtk_style_context_add_class(context, "image-button")
    apply(init)
}
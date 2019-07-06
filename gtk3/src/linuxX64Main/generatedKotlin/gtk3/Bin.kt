package gtk3

import kotlinx.cinterop.CPointer
import kotlinx.cinterop.reinterpret
import libgtk3.GtkBin
import libgtk3.GtkWidget
import libgtk3.gtk_bin_get_child

/**
 * The #GtkBin widget is a container with just one child.
 * It is not very useful itself, but it is useful for deriving subclasses,
 * since it provides common code needed for handling a single child widget.
 *
 * Many GTK+ widgets are subclasses of #GtkBin, including #GtkWindow,
 * #GtkButton, #GtkFrame, #GtkHandleBox or #GtkScrolledWindow.Gets the child of the #GtkBin, or
        %NULL if the bin contains
 * no child widget. The returned widget does not have a reference
 * added, so you do not need to unref it. */
@GtkDsl
abstract class Bin : Container() {
    private val self: CPointer<GtkBin>
        get() = widgetPtr!!.reinterpret()

    val child: CPointer<GtkWidget>
        get() = gtk_bin_get_child(self)!!.reinterpret()
}

package gtk3

import kotlinx.cinterop.CPointer
import kotlinx.cinterop.reinterpret
import libgtk3.GtkMisc

/**
 * The #GtkMisc widget is an abstract widget which is not useful itself, but
 * is used to derive subclasses which have alignment and padding attributes.
 *
 * The horizontal and vertical padding attributes allows extra space to be
 * added around the widget.
 *
 * The horizontal and vertical alignment attributes enable the widget to be
 * positioned within its allocated area. Note that if the widget is added to
 * a container in such a way that it expands automatically to fill its
 * allocated area, the alignment settings will not alter the widget's position.
 *
 * Note that the desired effect can in most cases be achieved by using the
 * #GtkWidget:halign, #GtkWidget:valign and #GtkWidget:margin properties
 * on the child widget, so GtkMisc should not be used in new code. To reflect
 * this fact, all #GtkMisc API has been deprecated. */
@GtkDsl
abstract class Misc : Widget() {
    private val self: CPointer<GtkMisc>
        get() = widgetPtr!!.reinterpret()
}

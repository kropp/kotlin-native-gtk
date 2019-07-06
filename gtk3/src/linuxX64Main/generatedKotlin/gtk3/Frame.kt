package gtk3

import kotlin.Float
import kotlin.String
import kotlin.Unit
import kotlinx.cinterop.CPointer
import kotlinx.cinterop.reinterpret
import kotlinx.cinterop.toKString
import libgtk3.GtkFrame
import libgtk3.GtkShadowType
import libgtk3.GtkWidget
import libgtk3.gtk_frame_get_label
import libgtk3.gtk_frame_get_label_widget
import libgtk3.gtk_frame_get_shadow_type
import libgtk3.gtk_frame_new
import libgtk3.gtk_frame_set_label
import libgtk3.gtk_frame_set_label_align
import libgtk3.gtk_frame_set_label_widget
import libgtk3.gtk_frame_set_shadow_type

inline fun Container.frame(label: String, init: Frame.() -> Unit = {}): Frame =
        Frame(label).apply { init(); this@frame.add(this) }

/**
 * The frame widget is a bin that surrounds its child with a decorative
 * frame and an optional label. If present, the label is drawn in a gap
 * in the top side of the frame. The position of the label can be
 * controlled with gtk_frame_set_label_align().
 *
 * # GtkFrame as GtkBuildable
 *
 * The GtkFrame implementation of the GtkBuildable interface supports
 * placing a child in the label position by specifying “label” as the
 * “type” attribute of a <child> element. A normal content child can
 * be specified without specifying a <child> type attribute.
 *
 * An example of a UI definition fragment with GtkFrame:
 * |[
 * <object class="GtkFrame">
 *   <child type="label">
 *     <object class="GtkLabel" id="frame-label"/>
 *   </child>
 *   <child>
 *     <object class="GtkEntry" id="frame-content"/>
 *   </child>
 * </object>
 * ]|
 *
 * # CSS nodes
 *
 * |[<!-- language="plain" -->
 * frame
 * ├── border[.flat]
 * ├── <label widget>
 * ╰── <child>
 * ]|
 *
 * GtkFrame has a main CSS node named “frame” and a subnode named “border”. The
 * “border” node is used to draw the visible border. You can set the appearance
 * of the border using CSS properties like “border-style” on the “border” node.
 *
 * The border node can be given the style class “.flat”, which is used by themes
 * to disable drawing of the border. To do this from code, call
 * gtk_frame_set_shadow_type() with %GTK_SHADOW_NONE to add the “.flat” class or
 * any other shadow type to remove it.
 */
@GtkDsl
open class Frame internal constructor(override val widgetPtr: CPointer<GtkWidget>? = null) : Bin() {
    private val self: CPointer<GtkFrame>?
        get() = widgetPtr!!.reinterpret()

    val frame: CPointer<GtkFrame>?
        get() = widgetPtr!!.reinterpret()

    /**
     * If the frame’s label widget is a #GtkLabel, returns the
     * text in the label widget. (The frame will have a #GtkLabel
     * for the label widget if a non-%NULL argument was passed
     * to gtk_frame_new().)
     *
     * Removes the current #GtkFrame:label-widget. If @label is not %NULL, creates a
     * new #GtkLabel with that text and adds it as the #GtkFrame:label-widget. */
    var label: String
        get() = gtk_frame_get_label(self)?.toKString() ?: ""
        set(value) {
            gtk_frame_set_label(self, value)
        }

    /**
     * Retrieves the label widget for the frame. See
     * gtk_frame_set_label_widget().
     *
     * Sets the #GtkFrame:label-widget for the frame. This is the widget that
     * will appear embedded in the top edge of the frame as a title. */
    var labelWidget: CPointer<GtkWidget>
        get() = gtk_frame_get_label_widget(self)!!.reinterpret()
        set(value) {
            gtk_frame_set_label_widget(self, value?.reinterpret())
        }

    /**
     * Retrieves the shadow type of the frame. See
     * gtk_frame_set_shadow_type().
     *
     * Sets the #GtkFrame:shadow-type for @frame, i.e. whether it is drawn without
     * (%GTK_SHADOW_NONE) or with (other values) a visible border. Values other than
     * %GTK_SHADOW_NONE are treated identically by GtkFrame. The chosen type is
     * applied by removing or adding the .flat class to the CSS node named border. */
    var shadowType: GtkShadowType
        get() = gtk_frame_get_shadow_type(self)
        set(value) {
            gtk_frame_set_shadow_type(self, value)
        }

    /**
     * Creates a new #GtkFrame, with optional label @label.
     * If @label is %NULL, the label is omitted. */
    constructor(label: String) : this(gtk_frame_new(label)?.reinterpret())

    /**
     * Sets the alignment of the frame widget’s label. The
     * default values for a newly created frame are 0.0 and 0.5.
     */
    fun setLabelAlign(xalign: Float, yalign: Float): Unit = gtk_frame_set_label_align(self, xalign,
            yalign)
}

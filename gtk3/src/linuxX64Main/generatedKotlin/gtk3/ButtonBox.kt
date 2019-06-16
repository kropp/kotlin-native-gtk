package gtk3

import kotlin.Boolean
import kotlin.Unit
import kotlinx.cinterop.CPointer
import kotlinx.cinterop.reinterpret
import libgtk3.GtkButtonBox
import libgtk3.GtkButtonBoxStyle
import libgtk3.GtkOrientation
import libgtk3.GtkWidget
import libgtk3.gtk_button_box_get_child_non_homogeneous
import libgtk3.gtk_button_box_get_child_secondary
import libgtk3.gtk_button_box_get_layout
import libgtk3.gtk_button_box_new
import libgtk3.gtk_button_box_set_child_non_homogeneous
import libgtk3.gtk_button_box_set_child_secondary
import libgtk3.gtk_button_box_set_layout
import libgtk3.gtk_false
import libgtk3.gtk_true

inline fun Container.buttonBox(orientation: GtkOrientation, init: ButtonBox.() -> Unit = {}):
        ButtonBox = ButtonBox(orientation).apply { init(); this@buttonBox.add(this) }

@GtkDsl
open class ButtonBox internal constructor(override val widgetPtr: CPointer<GtkWidget>? = null) :
        Box() {
    private val self: CPointer<GtkButtonBox>?
        get() = widgetPtr!!.reinterpret()

    val buttonBox: CPointer<GtkButtonBox>?
        get() = widgetPtr!!.reinterpret()

    /**
     * Retrieves the method being used to arrange the buttons in a button box.
     *
     * Changes the way buttons are arranged in their container. */
    var layout: GtkButtonBoxStyle
        get() = gtk_button_box_get_layout(self)
        set(value) {
            gtk_button_box_set_layout(self, value)
        }

    /**
     * Creates a new #GtkButtonBox. */
    constructor(orientation: GtkOrientation) : this(gtk_button_box_new(orientation)?.reinterpret())

    /**
     * Returns whether the child is exempted from homogenous
     * sizing.
     */
    fun getChildNonHomogeneous(child: CPointer<GtkWidget>): Boolean =
            gtk_button_box_get_child_non_homogeneous(self, child) != 0

    /**
     * Returns whether the child is exempted from homogenous
     * sizing.
     */
    fun getChildNonHomogeneous(child: Widget): Boolean =
            gtk_button_box_get_child_non_homogeneous(self, child.widgetPtr?.reinterpret()) != 0

    /**
     * Returns whether @child should appear in a secondary group of children.
     */
    fun getChildSecondary(child: CPointer<GtkWidget>): Boolean =
            gtk_button_box_get_child_secondary(self, child) != 0

    /**
     * Returns whether @child should appear in a secondary group of children.
     */
    fun getChildSecondary(child: Widget): Boolean = gtk_button_box_get_child_secondary(self,
            child.widgetPtr?.reinterpret()) != 0

    /**
     * Sets whether the child is exempted from homogeous sizing.
     */
    fun setChildNonHomogeneous(child: CPointer<GtkWidget>, non_homogeneous: Boolean): Unit =
            gtk_button_box_set_child_non_homogeneous(self, child,
            if (non_homogeneous) gtk_true() else gtk_false())

    /**
     * Sets whether the child is exempted from homogeous sizing.
     */
    fun setChildNonHomogeneous(child: Widget, non_homogeneous: Boolean): Unit =
            gtk_button_box_set_child_non_homogeneous(self, child.widgetPtr?.reinterpret(),
            if (non_homogeneous) gtk_true() else gtk_false())

    /**
     * Sets whether @child should appear in a secondary group of children.
     * A typical use of a secondary child is the help button in a dialog.
     *
     * This group appears after the other children if the style
     * is %GTK_BUTTONBOX_START, %GTK_BUTTONBOX_SPREAD or
     * %GTK_BUTTONBOX_EDGE, and before the other children if the style
     * is %GTK_BUTTONBOX_END. For horizontal button boxes, the definition
     * of before/after depends on direction of the widget (see
     * gtk_widget_set_direction()). If the style is %GTK_BUTTONBOX_START
     * or %GTK_BUTTONBOX_END, then the secondary children are aligned at
     * the other end of the button box from the main children. For the
     * other styles, they appear immediately next to the main children.
     */
    fun setChildSecondary(child: CPointer<GtkWidget>, is_secondary: Boolean): Unit =
            gtk_button_box_set_child_secondary(self, child,
            if (is_secondary) gtk_true() else gtk_false())

    /**
     * Sets whether @child should appear in a secondary group of children.
     * A typical use of a secondary child is the help button in a dialog.
     *
     * This group appears after the other children if the style
     * is %GTK_BUTTONBOX_START, %GTK_BUTTONBOX_SPREAD or
     * %GTK_BUTTONBOX_EDGE, and before the other children if the style
     * is %GTK_BUTTONBOX_END. For horizontal button boxes, the definition
     * of before/after depends on direction of the widget (see
     * gtk_widget_set_direction()). If the style is %GTK_BUTTONBOX_START
     * or %GTK_BUTTONBOX_END, then the secondary children are aligned at
     * the other end of the button box from the main children. For the
     * other styles, they appear immediately next to the main children.
     */
    fun setChildSecondary(child: Widget, is_secondary: Boolean): Unit =
            gtk_button_box_set_child_secondary(self, child.widgetPtr?.reinterpret(),
            if (is_secondary) gtk_true() else gtk_false())
}

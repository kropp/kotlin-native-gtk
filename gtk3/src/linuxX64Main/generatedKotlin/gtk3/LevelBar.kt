package gtk3

import kotlin.Boolean
import kotlin.Double
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
import libgtk3.GtkLevelBar
import libgtk3.GtkLevelBarMode
import libgtk3.GtkWidget
import libgtk3.gtk_false
import libgtk3.gtk_level_bar_add_offset_value
import libgtk3.gtk_level_bar_get_inverted
import libgtk3.gtk_level_bar_get_max_value
import libgtk3.gtk_level_bar_get_min_value
import libgtk3.gtk_level_bar_get_mode
import libgtk3.gtk_level_bar_get_value
import libgtk3.gtk_level_bar_new
import libgtk3.gtk_level_bar_remove_offset_value
import libgtk3.gtk_level_bar_set_inverted
import libgtk3.gtk_level_bar_set_max_value
import libgtk3.gtk_level_bar_set_min_value
import libgtk3.gtk_level_bar_set_mode
import libgtk3.gtk_level_bar_set_value
import libgtk3.gtk_true

inline fun Container.levelBar(init: LevelBar.() -> Unit = {}): LevelBar = LevelBar().apply { init();
        this@levelBar.add(this) }

private fun LevelBar_onOffsetChanged_Handler(
    sender: CPointer<in CPointed>?,
    name: CPointer<ByteVar>,
    _data: COpaquePointer?
) {
    _data?.asStableRef<LevelBar>()?.get()?.onOffsetChanged?.emit(name.toKString())
}

/**
 * The #GtkLevelBar is a bar widget that can be used
 * as a level indicator. Typical use cases are displaying the strength
 * of a password, or showing the charge level of a battery.
 *
 * Use gtk_level_bar_set_value() to set the current value, and
 * gtk_level_bar_add_offset_value() to set the value offsets at which
 * the bar will be considered in a different state. GTK will add a few
 * offsets by default on the level bar: #GTK_LEVEL_BAR_OFFSET_LOW,
 * #GTK_LEVEL_BAR_OFFSET_HIGH and #GTK_LEVEL_BAR_OFFSET_FULL, with
 * values 0.25, 0.75 and 1.0 respectively.
 *
 * Note that it is your responsibility to update preexisting offsets
 * when changing the minimum or maximum value. GTK+ will simply clamp
 * them to the new range.
 *
 * ## Adding a custom offset on the bar
 *
 * |[<!-- language="C" -->
 *
 * static GtkWidget *
 * create_level_bar (void)
 * {
 *   GtkWidget *widget;
 *   GtkLevelBar *bar;
 *
 *   widget = gtk_level_bar_new ();
 *   bar = GTK_LEVEL_BAR (widget);
 *
 *   // This changes the value of the default low offset
 *
 *   gtk_level_bar_add_offset_value (bar,
 *                                   GTK_LEVEL_BAR_OFFSET_LOW,
 *                                   0.10);
 *
 *   // This adds a new offset to the bar; the application will
 *   // be able to change its color CSS like this:
 *   //
 *   // levelbar block.my-offset {
 *   //   background-color: magenta;
 *   //   border-style: solid;
 *   //   border-color: black;
 *   //   border-style: 1px;
 *   // }
 *
 *   gtk_level_bar_add_offset_value (bar, "my-offset", 0.60);
 *
 *   return widget;
 * }
 * ]|
 *
 * The default interval of values is between zero and one, but it’s possible to
 * modify the interval using gtk_level_bar_set_min_value() and
 * gtk_level_bar_set_max_value(). The value will be always drawn in proportion to
 * the admissible interval, i.e. a value of 15 with a specified interval between
 * 10 and 20 is equivalent to a value of 0.5 with an interval between 0 and 1.
 * When #GTK_LEVEL_BAR_MODE_DISCRETE is used, the bar level is rendered
 * as a finite number of separated blocks instead of a single one. The number
 * of blocks that will be rendered is equal to the number of units specified by
 * the admissible interval.
 *
 * For instance, to build a bar rendered with five blocks, it’s sufficient to
 * set the minimum value to 0 and the maximum value to 5 after changing the indicator
 * mode to discrete.
 *
 * GtkLevelBar was introduced in GTK+ 3.6.
 *
 * # GtkLevelBar as GtkBuildable
 *
 * The GtkLevelBar implementation of the GtkBuildable interface supports a
 * custom <offsets> element, which can contain any number of <offset> elements,
 * each of which must have name and value attributes.
 *
 * # CSS nodes
 *
 * |[<!-- language="plain" -->
 * levelbar[.discrete]
 * ╰── trough
 *     ├── block.filled.level-name
 *     ┊
 *     ├── block.empty
 *     ┊
 * ]|
 *
 * GtkLevelBar has a main CSS node with name levelbar and one of the style
 * classes .discrete or .continuous and a subnode with name trough. Below the
 * trough node are a number of nodes with name block and style class .filled
 * or .empty. In continuous mode, there is exactly one node of each, in discrete
 * mode, the number of filled and unfilled nodes corresponds to blocks that are
 * drawn. The block.filled nodes also get a style class .level-name corresponding
 * to the level for the current value.
 *
 * In horizontal orientation, the nodes are always arranged from left to right,
 * regardless of text direction.
 */
@GtkDsl
open class LevelBar internal constructor(override val widgetPtr: CPointer<GtkWidget>? = null) :
        Widget() {
    private val self: CPointer<GtkLevelBar>?
        get() = widgetPtr!!.reinterpret()

    val levelBar: CPointer<GtkLevelBar>?
        get() = widgetPtr!!.reinterpret()

    val onOffsetChanged: Signal1<LevelBar, String, CFunction<(
        CPointer<in CPointed>?,
        CPointer<ByteVar>,
        COpaquePointer?
    ) -> Unit>> by lazy { Signal1<LevelBar, String, CFunction<(
                CPointer<in CPointed>?,
                CPointer<ByteVar>,
                COpaquePointer?
            ) -> Unit>>(widgetPtr!!, this, "offset-changed",
                    staticCFunction(::LevelBar_onOffsetChanged_Handler)) }

    /**
     * Return the value of the #GtkLevelBar:inverted property.
     *
     * Sets the value of the #GtkLevelBar:inverted property. */
    var inverted: Boolean
        get() = gtk_level_bar_get_inverted(self) != 0
        set(value) {
            gtk_level_bar_set_inverted(self, if (value) gtk_true() else gtk_false())
        }

    /**
     * Returns the value of the #GtkLevelBar:max-value property.
     *
     * Sets the value of the #GtkLevelBar:max-value property.
     *
     * You probably want to update preexisting level offsets after calling
     * this function. */
    var maxValue: Double
        get() = gtk_level_bar_get_max_value(self)
        set(value) {
            gtk_level_bar_set_max_value(self, value)
        }

    /**
     * Returns the value of the #GtkLevelBar:min-value property.
     *
     * Sets the value of the #GtkLevelBar:min-value property.
     *
     * You probably want to update preexisting level offsets after calling
     * this function. */
    var minValue: Double
        get() = gtk_level_bar_get_min_value(self)
        set(value) {
            gtk_level_bar_set_min_value(self, value)
        }

    /**
     * Returns the value of the #GtkLevelBar:mode property.
     *
     * Sets the value of the #GtkLevelBar:mode property. */
    var mode: GtkLevelBarMode
        get() = gtk_level_bar_get_mode(self)
        set(value) {
            gtk_level_bar_set_mode(self, value)
        }

    /**
     * Returns the value of the #GtkLevelBar:value property.
     *
     * Sets the value of the #GtkLevelBar:value property. */
    var value: Double
        get() = gtk_level_bar_get_value(self)
        set(value) {
            gtk_level_bar_set_value(self, value)
        }

    /**
     * Creates a new #GtkLevelBar. */
    constructor() : this(gtk_level_bar_new()?.reinterpret())

    /**
     * Adds a new offset marker on @self at the position specified by @value.
     * When the bar value is in the interval topped by @value (or between @value
     * and #GtkLevelBar:max-value in case the offset is the last one on the bar)
     * a style class named `level-`@name will be applied
     * when rendering the level bar fill.
     * If another offset marker named @name exists, its value will be
     * replaced by @value.
     */
    fun addOffsetValue(name: String, value: Double): Unit = gtk_level_bar_add_offset_value(self,
            name, value)

    /**
     * Removes an offset marker previously added with
     * gtk_level_bar_add_offset_value().
     */
    fun removeOffsetValue(name: String): Unit = gtk_level_bar_remove_offset_value(self, name)
}

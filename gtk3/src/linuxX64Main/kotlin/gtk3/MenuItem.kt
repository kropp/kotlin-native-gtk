package gtk3

import kotlin.Boolean
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
import libgtk3.GtkMenuItem
import libgtk3.GtkWidget
import libgtk3.gtk_false
import libgtk3.gtk_menu_item_deselect
import libgtk3.gtk_menu_item_get_accel_path
import libgtk3.gtk_menu_item_get_label
import libgtk3.gtk_menu_item_get_reserve_indicator
import libgtk3.gtk_menu_item_get_submenu
import libgtk3.gtk_menu_item_get_use_underline
import libgtk3.gtk_menu_item_new
import libgtk3.gtk_menu_item_select
import libgtk3.gtk_menu_item_set_accel_path
import libgtk3.gtk_menu_item_set_label
import libgtk3.gtk_menu_item_set_reserve_indicator
import libgtk3.gtk_menu_item_set_submenu
import libgtk3.gtk_menu_item_set_use_underline
import libgtk3.gtk_menu_item_toggle_size_allocate
import libgtk3.gtk_true

inline fun Container.menuItem(init: MenuItem.() -> Unit = {}): MenuItem = MenuItem().apply { init();
        this@menuItem.add(this) }

private fun MenuItem_onActivate_Handler(sender: CPointer<in CPointed>?, _data: COpaquePointer?) {
    _data?.asStableRef<MenuItem>()?.get()?.onActivate?.emit()
}

private fun MenuItem_onActivateItem_Handler(sender: CPointer<in CPointed>?, _data: COpaquePointer?)
        {
    _data?.asStableRef<MenuItem>()?.get()?.onActivateItem?.emit()
}

private fun MenuItem_onDeselect_Handler(sender: CPointer<in CPointed>?, _data: COpaquePointer?) {
    _data?.asStableRef<MenuItem>()?.get()?.onDeselect?.emit()
}

private fun MenuItem_onSelect_Handler(sender: CPointer<in CPointed>?, _data: COpaquePointer?) {
    _data?.asStableRef<MenuItem>()?.get()?.onSelect?.emit()
}

private fun MenuItem_onToggleSizeAllocate_Handler(
    sender: CPointer<in CPointed>?,
    `object`: Int,
    _data: COpaquePointer?
) {
    _data?.asStableRef<MenuItem>()?.get()?.onToggleSizeAllocate?.emit(`object`)
}

/**
 * The #GtkMenuItem widget and the derived widgets are the only valid
 * children for menus. Their function is to correctly handle highlighting,
 * alignment, events and submenus.
 *
 * As a GtkMenuItem derives from #GtkBin it can hold any valid child widget,
 * although only a few are really useful.
 *
 * By default, a GtkMenuItem sets a #GtkAccelLabel as its child.
 * GtkMenuItem has direct functions to set the label and its mnemonic.
 * For more advanced label settings, you can fetch the child widget from the GtkBin.
 *
 * An example for setting markup and accelerator on a MenuItem:
 * |[<!-- language="C" -->
 * GtkWidget *menu_item = gtk_menu_item_new_with_label ("Example Menu Item");
 *
 * GtkWidget *child = gtk_bin_get_child (GTK_BIN (menu_item));
 * gtk_label_set_markup (GTK_LABEL (child), "<i>new label</i> with <b>markup</b>");
 * gtk_accel_label_set_accel (GTK_ACCEL_LABEL (child), GDK_KEY_1, 0);
 * ]|
 *
 * # GtkMenuItem as GtkBuildable
 *
 * The GtkMenuItem implementation of the #GtkBuildable interface supports
 * adding a submenu by specifying “submenu” as the “type” attribute of
 * a <child> element.
 *
 * An example of UI definition fragment with submenus:
 * |[
 * <object class="GtkMenuItem">
 *   <child type="submenu">
 *     <object class="GtkMenu"/>
 *   </child>
 * </object>
 * ]|
 *
 * # CSS nodes
 *
 * |[<!-- language="plain" -->
 * menuitem
 * ├── <child>
 * ╰── [arrow.right]
 * ]|
 *
 * GtkMenuItem has a single CSS node with name menuitem. If the menuitem
 * has a submenu, it gets another CSS node with name arrow, which has
 * the .left or .right style class.
 */
@GtkDsl
open class MenuItem internal constructor(override val widgetPtr: CPointer<GtkWidget>? = null) :
        Bin() {
    private val self: CPointer<GtkMenuItem>?
        get() = widgetPtr!!.reinterpret()

    val menuItem: CPointer<GtkMenuItem>?
        get() = widgetPtr!!.reinterpret()

    val onActivate: Signal<MenuItem, CFunction<(CPointer<in CPointed>?, COpaquePointer?) -> Unit>>
            by lazy { Signal<MenuItem, CFunction<(CPointer<in CPointed>?, COpaquePointer?) ->
            Unit>>(widgetPtr!!, this, "activate", staticCFunction(::MenuItem_onActivate_Handler)) }

    val onActivateItem: Signal<MenuItem, CFunction<(CPointer<in CPointed>?, COpaquePointer?) ->
            Unit>> by lazy { Signal<MenuItem, CFunction<(CPointer<in CPointed>?, COpaquePointer?) ->
            Unit>>(widgetPtr!!, this, "activate-item",
            staticCFunction(::MenuItem_onActivateItem_Handler)) }

    val onDeselect: Signal<MenuItem, CFunction<(CPointer<in CPointed>?, COpaquePointer?) -> Unit>>
            by lazy { Signal<MenuItem, CFunction<(CPointer<in CPointed>?, COpaquePointer?) ->
            Unit>>(widgetPtr!!, this, "deselect", staticCFunction(::MenuItem_onDeselect_Handler)) }

    val onSelect: Signal<MenuItem, CFunction<(CPointer<in CPointed>?, COpaquePointer?) -> Unit>> by
            lazy { Signal<MenuItem, CFunction<(CPointer<in CPointed>?, COpaquePointer?) ->
            Unit>>(widgetPtr!!, this, "select", staticCFunction(::MenuItem_onSelect_Handler)) }

    val onToggleSizeAllocate: Signal1<MenuItem, Int, CFunction<(
        CPointer<in CPointed>?,
        Int,
        COpaquePointer?
    ) -> Unit>> by lazy { Signal1<MenuItem, Int, CFunction<(
                CPointer<in CPointed>?,
                Int,
                COpaquePointer?
            ) -> Unit>>(widgetPtr!!, this, "toggle-size-allocate",
                    staticCFunction(::MenuItem_onToggleSizeAllocate_Handler)) }

    /**
     * Retrieve the accelerator path that was previously set on @menu_item.
     *
     * See gtk_menu_item_set_accel_path() for details.
     *
     * Set the accelerator path on @menu_item, through which runtime
     * changes of the menu item’s accelerator caused by the user can be
     * identified and saved to persistent storage (see gtk_accel_map_save()
     * on this). To set up a default accelerator for this menu item, call
     * gtk_accel_map_add_entry() with the same @accel_path. See also
     * gtk_accel_map_add_entry() on the specifics of accelerator paths,
     * and gtk_menu_set_accel_path() for a more convenient variant of
     * this function.
     *
     * This function is basically a convenience wrapper that handles
     * calling gtk_widget_set_accel_path() with the appropriate accelerator
     * group for the menu item.
     *
     * Note that you do need to set an accelerator on the parent menu with
     * gtk_menu_set_accel_group() for this to work.
     *
     * Note that @accel_path string will be stored in a #GQuark.
     * Therefore, if you pass a static string, you can save some memory
     * by interning it first with g_intern_static_string(). */
    var accelPath: String
        get() = gtk_menu_item_get_accel_path(self)?.toKString() ?: ""
        set(value) {
            gtk_menu_item_set_accel_path(self, value)
        }

    /**
     * Sets @text on the @menu_item label
     *
     * Sets @text on the @menu_item label */
    var label: String
        get() = gtk_menu_item_get_label(self)?.toKString() ?: ""
        set(value) {
            gtk_menu_item_set_label(self, value)
        }

    /**
     * Returns whether the @menu_item reserves space for
     * the submenu indicator, regardless if it has a submenu
     * or not.
     *
     * Sets whether the @menu_item should reserve space for
     * the submenu indicator, regardless if it actually has
     * a submenu or not.
     *
     * There should be little need for applications to call
     * this functions. */
    var reserveIndicator: Boolean
        get() = gtk_menu_item_get_reserve_indicator(self) != 0
        set(value) {
            gtk_menu_item_set_reserve_indicator(self, if (value) gtk_true() else gtk_false())
        }

    /**
     * Gets the submenu underneath this menu item, if any.
     * See gtk_menu_item_set_submenu().
     *
     * Sets or replaces the menu item’s submenu, or removes it when a %NULL
     * submenu is passed. */
    var submenu: CPointer<GtkWidget>
        get() = gtk_menu_item_get_submenu(self)!!.reinterpret()
        set(value) {
            gtk_menu_item_set_submenu(self, value?.reinterpret())
        }

    /**
     * Checks if an underline in the text indicates the next character
     * should be used for the mnemonic accelerator key.
     *
     * If true, an underline in the text indicates the next character
     * should be used for the mnemonic accelerator key. */
    var useUnderline: Boolean
        get() = gtk_menu_item_get_use_underline(self) != 0
        set(value) {
            gtk_menu_item_set_use_underline(self, if (value) gtk_true() else gtk_false())
        }

    /**
     * Creates a new #GtkMenuItem. */
    constructor() : this(gtk_menu_item_new()?.reinterpret())

    /**
     * Emits the #GtkMenuItem::deselect signal on the given item.
     */
    fun deselect(): Unit = gtk_menu_item_deselect(self)

    /**
     * Emits the #GtkMenuItem::select signal on the given item.
     */
    fun select(): Unit = gtk_menu_item_select(self)

    /**
     * Emits the #GtkMenuItem::toggle-size-allocate signal on the given item.
     */
    fun toggleSizeAllocate(allocation: Int): Unit = gtk_menu_item_toggle_size_allocate(self,
            allocation)
}

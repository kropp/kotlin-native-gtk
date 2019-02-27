package gtk3

import kotlin.Boolean
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
import libgtk3.GdkDevice
import libgtk3.GtkComboBox
import libgtk3.GtkSensitivityType
import libgtk3.GtkTreeIter
import libgtk3.GtkTreeModel
import libgtk3.GtkWidget
import libgtk3.gtk_combo_box_get_active
import libgtk3.gtk_combo_box_get_active_id
import libgtk3.gtk_combo_box_get_button_sensitivity
import libgtk3.gtk_combo_box_get_column_span_column
import libgtk3.gtk_combo_box_get_entry_text_column
import libgtk3.gtk_combo_box_get_has_entry
import libgtk3.gtk_combo_box_get_id_column
import libgtk3.gtk_combo_box_get_model
import libgtk3.gtk_combo_box_get_popup_fixed_width
import libgtk3.gtk_combo_box_get_row_span_column
import libgtk3.gtk_combo_box_get_wrap_width
import libgtk3.gtk_combo_box_new
import libgtk3.gtk_combo_box_popdown
import libgtk3.gtk_combo_box_popup
import libgtk3.gtk_combo_box_popup_for_device
import libgtk3.gtk_combo_box_set_active
import libgtk3.gtk_combo_box_set_active_id
import libgtk3.gtk_combo_box_set_active_iter
import libgtk3.gtk_combo_box_set_button_sensitivity
import libgtk3.gtk_combo_box_set_column_span_column
import libgtk3.gtk_combo_box_set_entry_text_column
import libgtk3.gtk_combo_box_set_id_column
import libgtk3.gtk_combo_box_set_model
import libgtk3.gtk_combo_box_set_popup_fixed_width
import libgtk3.gtk_combo_box_set_row_span_column
import libgtk3.gtk_combo_box_set_wrap_width
import libgtk3.gtk_false
import libgtk3.gtk_true

inline fun Container.comboBox(init: ComboBox.() -> Unit = {}): ComboBox = ComboBox().apply { init();
        this@comboBox.add(this) }

private fun ComboBox_onChanged_Handler(sender: CPointer<in CPointed>?, _data: COpaquePointer?) {
    _data?.asStableRef<ComboBox>()?.get()?.onChanged?.emit()
}

private fun ComboBox_onFormatEntryText_Handler(
    sender: CPointer<in CPointed>?,
    path: CPointer<ByteVar>,
    _data: COpaquePointer?
) {
    _data?.asStableRef<ComboBox>()?.get()?.onFormatEntryText?.emit(path.toKString())
}

private fun ComboBox_onPopdown_Handler(sender: CPointer<in CPointed>?, _data: COpaquePointer?) {
    _data?.asStableRef<ComboBox>()?.get()?.onPopdown?.emit()
}

private fun ComboBox_onPopup_Handler(sender: CPointer<in CPointed>?, _data: COpaquePointer?) {
    _data?.asStableRef<ComboBox>()?.get()?.onPopup?.emit()
}

/**
 * A GtkComboBox is a widget that allows the user to choose from a list of
 * valid choices. The GtkComboBox displays the selected choice. When
 * activated, the GtkComboBox displays a popup which allows the user to
 * make a new choice. The style in which the selected value is displayed,
 * and the style of the popup is determined by the current theme. It may
 * be similar to a Windows-style combo box.
 *
 * The GtkComboBox uses the model-view pattern; the list of valid choices
 * is specified in the form of a tree model, and the display of the choices
 * can be adapted to the data in the model by using cell renderers, as you
 * would in a tree view. This is possible since GtkComboBox implements the
 * #GtkCellLayout interface. The tree model holding the valid choices is
 * not restricted to a flat list, it can be a real tree, and the popup will
 * reflect the tree structure.
 *
 * To allow the user to enter values not in the model, the “has-entry”
 * property allows the GtkComboBox to contain a #GtkEntry. This entry
 * can be accessed by calling gtk_bin_get_child() on the combo box.
 *
 * For a simple list of textual choices, the model-view API of GtkComboBox
 * can be a bit overwhelming. In this case, #GtkComboBoxText offers a
 * simple alternative. Both GtkComboBox and #GtkComboBoxText can contain
 * an entry.
 *
 * # CSS nodes
 *
 * |[<!-- language="plain" -->
 * combobox
 * ├── box.linked
 * │   ╰── button.combo
 * │       ╰── box
 * │           ├── cellview
 * │           ╰── arrow
 * ╰── window.popup
 * ]|
 *
 * A normal combobox contains a box with the .linked class, a button
 * with the .combo class and inside those buttons, there are a cellview and
 * an arrow.
 *
 * |[<!-- language="plain" -->
 * combobox
 * ├── box.linked
 * │   ├── entry.combo
 * │   ╰── button.combo
 * │       ╰── box
 * │           ╰── arrow
 * ╰── window.popup
 * ]|
 *
 * A GtkComboBox with an entry has a single CSS node with name combobox. It
 * contains a box with the .linked class. That box contains an entry and a
 * button, both with the .combo class added.
 * The button also contains another node with name arrow.Returns whether the combo box has an entry.
 */
@GtkDsl
open class ComboBox internal constructor(override val widgetPtr: CPointer<GtkWidget>? = null) :
        Bin() {
    private val self: CPointer<GtkComboBox>?
        get() = widgetPtr!!.reinterpret()

    val comboBox: CPointer<GtkComboBox>?
        get() = widgetPtr!!.reinterpret()

    val onChanged: Signal<ComboBox, CFunction<(CPointer<in CPointed>?, COpaquePointer?) -> Unit>> by
            lazy { Signal<ComboBox, CFunction<(CPointer<in CPointed>?, COpaquePointer?) ->
            Unit>>(widgetPtr!!, this, "changed", staticCFunction(::ComboBox_onChanged_Handler)) }

    val onFormatEntryText: Signal1<ComboBox, String, CFunction<(
        CPointer<in CPointed>?,
        CPointer<ByteVar>,
        COpaquePointer?
    ) -> Unit>> by lazy { Signal1<ComboBox, String, CFunction<(
                CPointer<in CPointed>?,
                CPointer<ByteVar>,
                COpaquePointer?
            ) -> Unit>>(widgetPtr!!, this, "format-entry-text",
                    staticCFunction(::ComboBox_onFormatEntryText_Handler)) }

    val onPopdown: Signal<ComboBox, CFunction<(CPointer<in CPointed>?, COpaquePointer?) -> Unit>> by
            lazy { Signal<ComboBox, CFunction<(CPointer<in CPointed>?, COpaquePointer?) ->
            Unit>>(widgetPtr!!, this, "popdown", staticCFunction(::ComboBox_onPopdown_Handler)) }

    val onPopup: Signal<ComboBox, CFunction<(CPointer<in CPointed>?, COpaquePointer?) -> Unit>> by
            lazy { Signal<ComboBox, CFunction<(CPointer<in CPointed>?, COpaquePointer?) ->
            Unit>>(widgetPtr!!, this, "popup", staticCFunction(::ComboBox_onPopup_Handler)) }

    /**
     * Returns the index of the currently active item, or -1 if there’s no
     * active item. If the model is a non-flat treemodel, and the active item
     * is not an immediate child of the root of the tree, this function returns
     * `gtk_tree_path_get_indices (path)[0]`, where
     * `path` is the #GtkTreePath of the active item.
     *
     * Sets the active item of @combo_box to be the item at @index. */
    var active: Int
        get() = gtk_combo_box_get_active(self)
        set(value) {
            gtk_combo_box_set_active(self, value)
        }

    /**
     * Returns the ID of the active row of @combo_box.  This value is taken
     * from the active row and the column specified by the #GtkComboBox:id-column
     * property of @combo_box (see gtk_combo_box_set_id_column()).
     *
     * The returned value is an interned string which means that you can
     * compare the pointer by value to other interned strings and that you
     * must not free it.
     *
     * If the #GtkComboBox:id-column property of @combo_box is not set, or if
     * no row is active, or if the active row has a %NULL ID value, then %NULL
     * is returned.
     *
     * Changes the active row of @combo_box to the one that has an ID equal to
     * @active_id, or unsets the active row if @active_id is %NULL.  Rows having
     * a %NULL ID string cannot be made active by this function.
     *
     * If the #GtkComboBox:id-column property of @combo_box is unset or if no
     * row has the given ID then the function does nothing and returns %FALSE. */
    var activeId: String
        get() = gtk_combo_box_get_active_id(self)?.toKString() ?: ""
        set(value) {
            gtk_combo_box_set_active_id(self, value)
        }

    /**
     * Returns whether the combo box sets the dropdown button
     * sensitive or not when there are no items in the model.
     *
     * Sets whether the dropdown button of the combo box should be
     * always sensitive (%GTK_SENSITIVITY_ON), never sensitive (%GTK_SENSITIVITY_OFF)
     * or only if there is at least one item to display (%GTK_SENSITIVITY_AUTO). */
    var buttonSensitivity: GtkSensitivityType
        get() = gtk_combo_box_get_button_sensitivity(self)
        set(value) {
            gtk_combo_box_set_button_sensitivity(self, value)
        }

    /**
     * Returns the column with column span information for @combo_box.
     *
     * Sets the column with column span information for @combo_box to be
     * @column_span. The column span column contains integers which indicate
     * how many columns an item should span. */
    var columnSpanColumn: Int
        get() = gtk_combo_box_get_column_span_column(self)
        set(value) {
            gtk_combo_box_set_column_span_column(self, value)
        }

    /**
     * Returns the column which @combo_box is using to get the strings
     * from to display in the internal entry.
     *
     * Sets the model column which @combo_box should use to get strings from
     * to be @text_column. The column @text_column in the model of @combo_box
     * must be of type %G_TYPE_STRING.
     *
     * This is only relevant if @combo_box has been created with
     * #GtkComboBox:has-entry as %TRUE. */
    var entryTextColumn: Int
        get() = gtk_combo_box_get_entry_text_column(self)
        set(value) {
            gtk_combo_box_set_entry_text_column(self, value)
        }

    val hasEntry: Boolean
        get() = gtk_combo_box_get_has_entry(self) != 0

    /**
     * Returns the column which @combo_box is using to get string IDs
     * for values from.
     *
     * Sets the model column which @combo_box should use to get string IDs
     * for values from. The column @id_column in the model of @combo_box
     * must be of type %G_TYPE_STRING. */
    var idColumn: Int
        get() = gtk_combo_box_get_id_column(self)
        set(value) {
            gtk_combo_box_set_id_column(self, value)
        }

    /**
     * Returns the #GtkTreeModel which is acting as data source for @combo_box.
     *
     * Sets the model used by @combo_box to be @model. Will unset a previously set
     * model (if applicable). If model is %NULL, then it will unset the model.
     *
     * Note that this function does not clear the cell renderers, you have to
     * call gtk_cell_layout_clear() yourself if you need to set up different
     * cell renderers for the new model. */
    var model: CPointer<GtkTreeModel>
        get() = gtk_combo_box_get_model(self)!!.reinterpret()
        set(value) {
            gtk_combo_box_set_model(self, value?.reinterpret())
        }

    /**
     * Gets whether the popup uses a fixed width matching
     * the allocated width of the combo box.
     *
     * Specifies whether the popup’s width should be a fixed width
     * matching the allocated width of the combo box. */
    var popupFixedWidth: Boolean
        get() = gtk_combo_box_get_popup_fixed_width(self) != 0
        set(value) {
            gtk_combo_box_set_popup_fixed_width(self, if (value) gtk_true() else gtk_false())
        }

    /**
     * Returns the column with row span information for @combo_box.
     *
     * Sets the column with row span information for @combo_box to be @row_span.
     * The row span column contains integers which indicate how many rows
     * an item should span. */
    var rowSpanColumn: Int
        get() = gtk_combo_box_get_row_span_column(self)
        set(value) {
            gtk_combo_box_set_row_span_column(self, value)
        }

    /**
     * Returns the wrap width which is used to determine the number of columns
     * for the popup menu. If the wrap width is larger than 1, the combo box
     * is in table mode.
     *
     * Sets the wrap width of @combo_box to be @width. The wrap width is basically
     * the preferred number of columns when you want the popup to be layed out
     * in a table. */
    var wrapWidth: Int
        get() = gtk_combo_box_get_wrap_width(self)
        set(value) {
            gtk_combo_box_set_wrap_width(self, value)
        }

    /**
     * Creates a new empty #GtkComboBox. */
    constructor() : this(gtk_combo_box_new()?.reinterpret())

    /**
     * Hides the menu or dropdown list of @combo_box.
     *
     * This function is mostly intended for use by accessibility technologies;
     * applications should have little use for it.
     */
    fun popdown(): Unit = gtk_combo_box_popdown(self)

    /**
     * Pops up the menu or dropdown list of @combo_box.
     *
     * This function is mostly intended for use by accessibility technologies;
     * applications should have little use for it.
     *
     * Before calling this, @combo_box must be mapped, or nothing will happen.
     */
    fun popup(): Unit = gtk_combo_box_popup(self)

    /**
     * Pops up the menu or dropdown list of @combo_box, the popup window
     * will be grabbed so only @device and its associated pointer/keyboard
     * are the only #GdkDevices able to send events to it.
     */
    fun popupForDevice(device: CPointer<GdkDevice>): Unit = gtk_combo_box_popup_for_device(self,
            device)

    /**
     * Sets the current active item to be the one referenced by @iter, or
     * unsets the active item if @iter is %NULL.
     */
    fun setActiveIter(iter: CPointer<GtkTreeIter>): Unit = gtk_combo_box_set_active_iter(self, iter)
}

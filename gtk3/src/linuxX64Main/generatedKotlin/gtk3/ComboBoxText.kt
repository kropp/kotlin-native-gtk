package gtk3

import kotlin.Int
import kotlin.String
import kotlin.Unit
import kotlinx.cinterop.CPointer
import kotlinx.cinterop.reinterpret
import kotlinx.cinterop.toKString
import libgtk3.GtkComboBoxText
import libgtk3.GtkWidget
import libgtk3.gtk_combo_box_text_append
import libgtk3.gtk_combo_box_text_append_text
import libgtk3.gtk_combo_box_text_get_active_text
import libgtk3.gtk_combo_box_text_insert
import libgtk3.gtk_combo_box_text_insert_text
import libgtk3.gtk_combo_box_text_new
import libgtk3.gtk_combo_box_text_prepend
import libgtk3.gtk_combo_box_text_prepend_text
import libgtk3.gtk_combo_box_text_remove
import libgtk3.gtk_combo_box_text_remove_all

inline fun Container.comboBoxText(init: ComboBoxText.() -> Unit = {}): ComboBoxText =
        ComboBoxText().apply { init(); this@comboBoxText.add(this) }

/**
 * A GtkComboBoxText is a simple variant of #GtkComboBox that hides
 * the model-view complexity for simple text-only use cases.
 *
 * To create a GtkComboBoxText, use gtk_combo_box_text_new() or
 * gtk_combo_box_text_new_with_entry().
 *
 * You can add items to a GtkComboBoxText with
 * gtk_combo_box_text_append_text(), gtk_combo_box_text_insert_text()
 * or gtk_combo_box_text_prepend_text() and remove options with
 * gtk_combo_box_text_remove().
 *
 * If the GtkComboBoxText contains an entry (via the “has-entry” property),
 * its contents can be retrieved using gtk_combo_box_text_get_active_text().
 * The entry itself can be accessed by calling gtk_bin_get_child() on the
 * combo box.
 *
 * You should not call gtk_combo_box_set_model() or attempt to pack more cells
 * into this combo box via its GtkCellLayout interface.
 *
 * # GtkComboBoxText as GtkBuildable
 *
 * The GtkComboBoxText implementation of the GtkBuildable interface supports
 * adding items directly using the <items> element and specifying <item>
 * elements for each item. Each <item> element can specify the “id”
 * corresponding to the appended text and also supports the regular
 * translation attributes “translatable”, “context” and “comments”.
 *
 * Here is a UI definition fragment specifying GtkComboBoxText items:
 * |[
 * <object class="GtkComboBoxText">
 *   <items>
 *     <item translatable="yes" id="factory">Factory</item>
 *     <item translatable="yes" id="home">Home</item>
 *     <item translatable="yes" id="subway">Subway</item>
 *   </items>
 * </object>
 * ]|
 *
 * # CSS nodes
 *
 * |[<!-- language="plain" -->
 * combobox
 * ╰── box.linked
 *     ├── entry.combo
 *     ├── button.combo
 *     ╰── window.popup
 * ]|
 *
 * GtkComboBoxText has a single CSS node with name combobox. It adds
 * the style class .combo to the main CSS nodes of its entry and button
 * children, and the .linked class to the node of its internal box.Returns the currently active
        string in @combo_box, or %NULL
 * if none is selected. If @combo_box contains an entry, this
 * function will return its contents (which will not necessarily
 * be an item from the list).
 */
@GtkDsl
open class ComboBoxText internal constructor(override val widgetPtr: CPointer<GtkWidget>? = null) :
        ComboBox() {
    private val self: CPointer<GtkComboBoxText>?
        get() = widgetPtr!!.reinterpret()

    val comboBoxText: CPointer<GtkComboBoxText>?
        get() = widgetPtr!!.reinterpret()

    val activeText: String
        get() = gtk_combo_box_text_get_active_text(self)?.toKString() ?: ""

    /**
     * Creates a new #GtkComboBoxText, which is a #GtkComboBox just displaying
     * strings. */
    constructor() : this(gtk_combo_box_text_new()?.reinterpret())

    /**
     * Appends @text to the list of strings stored in @combo_box.
     * If @id is non-%NULL then it is used as the ID of the row.
     *
     * This is the same as calling gtk_combo_box_text_insert() with a
     * position of -1.
     */
    fun append(id: String, text: String): Unit = gtk_combo_box_text_append(self, id, text)

    /**
     * Appends @text to the list of strings stored in @combo_box.
     *
     * This is the same as calling gtk_combo_box_text_insert_text() with a
     * position of -1.
     */
    fun appendText(text: String): Unit = gtk_combo_box_text_append_text(self, text)

    /**
     * Inserts @text at @position in the list of strings stored in @combo_box.
     * If @id is non-%NULL then it is used as the ID of the row.  See
     * #GtkComboBox:id-column.
     *
     * If @position is negative then @text is appended.
     */
    fun insert(
        position: Int,
        id: String,
        text: String
    ): Unit = gtk_combo_box_text_insert(self, position, id, text)

    /**
     * Inserts @text at @position in the list of strings stored in @combo_box.
     *
     * If @position is negative then @text is appended.
     *
     * This is the same as calling gtk_combo_box_text_insert() with a %NULL
     * ID string.
     */
    fun insertText(position: Int, text: String): Unit = gtk_combo_box_text_insert_text(self,
            position, text)

    /**
     * Prepends @text to the list of strings stored in @combo_box.
     * If @id is non-%NULL then it is used as the ID of the row.
     *
     * This is the same as calling gtk_combo_box_text_insert() with a
     * position of 0.
     */
    fun prepend(id: String, text: String): Unit = gtk_combo_box_text_prepend(self, id, text)

    /**
     * Prepends @text to the list of strings stored in @combo_box.
     *
     * This is the same as calling gtk_combo_box_text_insert_text() with a
     * position of 0.
     */
    fun prependText(text: String): Unit = gtk_combo_box_text_prepend_text(self, text)

    /**
     * Removes the string at @position from @combo_box.
     */
    fun remove(position: Int): Unit = gtk_combo_box_text_remove(self, position)

    /**
     * Removes all the text entries from the combo box.
     */
    fun removeAll(): Unit = gtk_combo_box_text_remove_all(self)
}

package gtk3

import kotlin.Boolean
import kotlin.Double
import kotlin.Float
import kotlin.Int
import kotlin.Short
import kotlin.String
import kotlin.Unit
import kotlinx.cinterop.CFunction
import kotlinx.cinterop.COpaquePointer
import kotlinx.cinterop.CPointer
import kotlinx.cinterop.asStableRef
import kotlinx.cinterop.reinterpret
import kotlinx.cinterop.staticCFunction
import kotlinx.cinterop.toKString
import libgtk3.GIcon
import libgtk3.GdkDragAction
import libgtk3.GdkEventButton
import libgtk3.GdkEventKey
import libgtk3.GdkPixbuf
import libgtk3.GtkAdjustment
import libgtk3.GtkDeleteType
import libgtk3.GtkEntry
import libgtk3.GtkEntryBuffer
import libgtk3.GtkEntryCompletion
import libgtk3.GtkEntryIconPosition
import libgtk3.GtkImageType
import libgtk3.GtkInputHints
import libgtk3.GtkInputPurpose
import libgtk3.GtkMovementStep
import libgtk3.GtkTargetList
import libgtk3.GtkWidget
import libgtk3.gtk_entry_get_activates_default
import libgtk3.gtk_entry_get_alignment
import libgtk3.gtk_entry_get_buffer
import libgtk3.gtk_entry_get_completion
import libgtk3.gtk_entry_get_current_icon_drag_source
import libgtk3.gtk_entry_get_cursor_hadjustment
import libgtk3.gtk_entry_get_has_frame
import libgtk3.gtk_entry_get_icon_activatable
import libgtk3.gtk_entry_get_icon_at_pos
import libgtk3.gtk_entry_get_icon_gicon
import libgtk3.gtk_entry_get_icon_name
import libgtk3.gtk_entry_get_icon_pixbuf
import libgtk3.gtk_entry_get_icon_sensitive
import libgtk3.gtk_entry_get_icon_storage_type
import libgtk3.gtk_entry_get_icon_tooltip_markup
import libgtk3.gtk_entry_get_icon_tooltip_text
import libgtk3.gtk_entry_get_input_hints
import libgtk3.gtk_entry_get_input_purpose
import libgtk3.gtk_entry_get_max_length
import libgtk3.gtk_entry_get_max_width_chars
import libgtk3.gtk_entry_get_overwrite_mode
import libgtk3.gtk_entry_get_placeholder_text
import libgtk3.gtk_entry_get_progress_fraction
import libgtk3.gtk_entry_get_progress_pulse_step
import libgtk3.gtk_entry_get_text
import libgtk3.gtk_entry_get_text_length
import libgtk3.gtk_entry_get_visibility
import libgtk3.gtk_entry_get_width_chars
import libgtk3.gtk_entry_grab_focus_without_selecting
import libgtk3.gtk_entry_im_context_filter_keypress
import libgtk3.gtk_entry_layout_index_to_text_index
import libgtk3.gtk_entry_new
import libgtk3.gtk_entry_progress_pulse
import libgtk3.gtk_entry_reset_im_context
import libgtk3.gtk_entry_set_activates_default
import libgtk3.gtk_entry_set_alignment
import libgtk3.gtk_entry_set_buffer
import libgtk3.gtk_entry_set_completion
import libgtk3.gtk_entry_set_cursor_hadjustment
import libgtk3.gtk_entry_set_has_frame
import libgtk3.gtk_entry_set_icon_activatable
import libgtk3.gtk_entry_set_icon_drag_source
import libgtk3.gtk_entry_set_icon_from_gicon
import libgtk3.gtk_entry_set_icon_from_icon_name
import libgtk3.gtk_entry_set_icon_from_pixbuf
import libgtk3.gtk_entry_set_icon_sensitive
import libgtk3.gtk_entry_set_icon_tooltip_markup
import libgtk3.gtk_entry_set_icon_tooltip_text
import libgtk3.gtk_entry_set_input_hints
import libgtk3.gtk_entry_set_input_purpose
import libgtk3.gtk_entry_set_max_length
import libgtk3.gtk_entry_set_max_width_chars
import libgtk3.gtk_entry_set_overwrite_mode
import libgtk3.gtk_entry_set_placeholder_text
import libgtk3.gtk_entry_set_progress_fraction
import libgtk3.gtk_entry_set_progress_pulse_step
import libgtk3.gtk_entry_set_text
import libgtk3.gtk_entry_set_visibility
import libgtk3.gtk_entry_set_width_chars
import libgtk3.gtk_entry_text_index_to_layout_index
import libgtk3.gtk_entry_unset_invisible_char
import libgtk3.gtk_false
import libgtk3.gtk_true

inline fun Container.entry(init: Entry.() -> Unit = {}): Entry = Entry().apply { init(); this@entry.add(this) }

private fun Entry_onActivate_Handler(sender: CPointer<*>?, data: COpaquePointer?) {
    data?.asStableRef<Entry>()?.get()?.onActivate?.invoke()
}

private fun Entry_onBackspace_Handler(sender: CPointer<*>?, data: COpaquePointer?) {
    data?.asStableRef<Entry>()?.get()?.onBackspace?.invoke()
}

private fun Entry_onCopyClipboard_Handler(sender: CPointer<*>?, data: COpaquePointer?) {
    data?.asStableRef<Entry>()?.get()?.onCopyClipboard?.invoke()
}

private fun Entry_onCutClipboard_Handler(sender: CPointer<*>?, data: COpaquePointer?) {
    data?.asStableRef<Entry>()?.get()?.onCutClipboard?.invoke()
}

private fun Entry_onInsertEmoji_Handler(sender: CPointer<*>?, data: COpaquePointer?) {
    data?.asStableRef<Entry>()?.get()?.onInsertEmoji?.invoke()
}

private fun Entry_onPasteClipboard_Handler(sender: CPointer<*>?, data: COpaquePointer?) {
    data?.asStableRef<Entry>()?.get()?.onPasteClipboard?.invoke()
}

private fun Entry_onPopulatePopup_Handler(
        sender: CPointer<*>?,
        widget: CPointer<GtkWidget>?,
        data: COpaquePointer?
) {
    data?.asStableRef<Entry>()?.get()?.onPopulatePopup?.invoke(widget)
}

private fun Entry_onToggleOverwrite_Handler(sender: CPointer<*>?, data: COpaquePointer?) {
    data?.asStableRef<Entry>()?.get()?.onToggleOverwrite?.invoke()
}

/**
 * The #GtkEntry widget is a single line text entry
 * widget. A fairly large set of key bindings are supported
 * by default. If the entered text is longer than the allocation
 * of the widget, the widget will scroll so that the cursor
 * position is visible.
 *
 * When using an entry for passwords and other sensitive information,
 * it can be put into “password mode” using gtk_entry_set_visibility().
 * In this mode, entered text is displayed using a “invisible” character.
 * By default, GTK+ picks the best invisible character that is available
 * in the current font, but it can be changed with
 * gtk_entry_set_invisible_char(). Since 2.16, GTK+ displays a warning
 * when Caps Lock or input methods might interfere with entering text in
 * a password entry. The warning can be turned off with the
 * #GtkEntry:caps-lock-warning property.
 *
 * Since 2.16, GtkEntry has the ability to display progress or activity
 * information behind the text. To make an entry display such information,
 * use gtk_entry_set_progress_fraction() or gtk_entry_set_progress_pulse_step().
 *
 * Additionally, GtkEntry can show icons at either side of the entry. These
 * icons can be activatable by clicking, can be set up as drag source and
 * can have tooltips. To add an icon, use gtk_entry_set_icon_from_gicon() or
 * one of the various other functions that set an icon from a stock id, an
 * icon name or a pixbuf. To trigger an action when the user clicks an icon,
 * connect to the #GtkEntry::icon-press signal. To allow DND operations
 * from an icon, use gtk_entry_set_icon_drag_source(). To set a tooltip on
 * an icon, use gtk_entry_set_icon_tooltip_text() or the corresponding function
 * for markup.
 *
 * Note that functionality or information that is only available by clicking
 * on an icon in an entry may not be accessible at all to users which are not
 * able to use a mouse or other pointing device. It is therefore recommended
 * that any such functionality should also be available by other means, e.g.
 * via the context menu of the entry.
 *
 * # CSS nodes
 *
 * |[<!-- language="plain" -->
 * entry
 * ├── image.left
 * ├── image.right
 * ├── undershoot.left
 * ├── undershoot.right
 * ├── [selection]
 * ├── [progress[.pulse]]
 * ╰── [window.popup]
 * ]|
 *
 * GtkEntry has a main node with the name entry. Depending on the properties
 * of the entry, the style classes .read-only and .flat may appear. The style
 * classes .warning and .error may also be used with entries.
 *
 * When the entry shows icons, it adds subnodes with the name image and the
 * style class .left or .right, depending on where the icon appears.
 *
 * When the entry has a selection, it adds a subnode with the name selection.
 *
 * When the entry shows progress, it adds a subnode with the name progress.
 * The node has the style class .pulse when the shown progress is pulsing.
 *
 * The CSS node for a context menu is added as a subnode below entry as well.
 *
 * The undershoot nodes are used to draw the underflow indication when content
 * is scrolled out of view. These nodes get the .left and .right style classes
 * added depending on where the indication is drawn.
 *
 * When touch is used and touch selection handles are shown, they are using
 * CSS nodes with name cursor-handle. They get the .top or .bottom style class
 * depending on where they are shown in relation to the selection. If there is
 * just a single handle for the text cursor, it gets the style class
 * .insertion-cursor. */
@GtkDsl
open class Entry internal constructor(override val widgetPtr: CPointer<GtkWidget>? = null) : Widget() {
    private val self: CPointer<GtkEntry>?
        get() = widgetPtr!!.reinterpret()

    val entry: CPointer<GtkEntry>?
        get() = widgetPtr!!.reinterpret()

    val onActivate: Signal<Entry, CFunction<(CPointer<*>?, COpaquePointer?) -> Unit>> by lazy { Signal<Entry, CFunction<(CPointer<*>?, COpaquePointer?) -> Unit>>(widgetPtr!!, this, "activate", staticCFunction(::Entry_onActivate_Handler)) }

    val onBackspace: Signal<Entry, CFunction<(CPointer<*>?, COpaquePointer?) -> Unit>> by lazy { Signal<Entry, CFunction<(CPointer<*>?, COpaquePointer?) -> Unit>>(widgetPtr!!, this, "backspace", staticCFunction(::Entry_onBackspace_Handler)) }

    val onCopyClipboard: Signal<Entry, CFunction<(CPointer<*>?, COpaquePointer?) -> Unit>> by lazy { Signal<Entry, CFunction<(CPointer<*>?, COpaquePointer?) -> Unit>>(widgetPtr!!, this, "copy-clipboard", staticCFunction(::Entry_onCopyClipboard_Handler)) }

    val onCutClipboard: Signal<Entry, CFunction<(CPointer<*>?, COpaquePointer?) -> Unit>> by lazy { Signal<Entry, CFunction<(CPointer<*>?, COpaquePointer?) -> Unit>>(widgetPtr!!, this, "cut-clipboard", staticCFunction(::Entry_onCutClipboard_Handler)) }

    val onInsertEmoji: Signal<Entry, CFunction<(CPointer<*>?, COpaquePointer?) -> Unit>> by lazy { Signal<Entry, CFunction<(CPointer<*>?, COpaquePointer?) -> Unit>>(widgetPtr!!, this, "insert-emoji", staticCFunction(::Entry_onInsertEmoji_Handler)) }

    val onPasteClipboard: Signal<Entry, CFunction<(CPointer<*>?, COpaquePointer?) -> Unit>> by lazy { Signal<Entry, CFunction<(CPointer<*>?, COpaquePointer?) -> Unit>>(widgetPtr!!, this, "paste-clipboard", staticCFunction(::Entry_onPasteClipboard_Handler)) }

    val onPopulatePopup: Signal1<Entry, CPointer<GtkWidget>?, CFunction<(
            CPointer<*>?,
            CPointer<GtkWidget>?,
            COpaquePointer?
    ) -> Unit>> by lazy { Signal1<Entry, CPointer<GtkWidget>?, CFunction<(
                    CPointer<*>?,
                    CPointer<GtkWidget>?,
                    COpaquePointer?
            ) -> Unit>>(widgetPtr!!, this, "populate-popup", staticCFunction(::Entry_onPopulatePopup_Handler)) }

    val onToggleOverwrite: Signal<Entry, CFunction<(CPointer<*>?, COpaquePointer?) -> Unit>> by lazy { Signal<Entry, CFunction<(CPointer<*>?, COpaquePointer?) -> Unit>>(widgetPtr!!, this, "toggle-overwrite", staticCFunction(::Entry_onToggleOverwrite_Handler)) }

    var activatesDefault: Boolean
        /**
         * Retrieves the value set by gtk_entry_set_activates_default(). */
        get() = gtk_entry_get_activates_default(self) != 0
        /**
         * If @setting is %TRUE, pressing Enter in the @entry will activate the default
         * widget for the window containing the entry. This usually means that
         * the dialog box containing the entry will be closed, since the default
         * widget is usually one of the dialog buttons.
         *
         * (For experts: if @setting is %TRUE, the entry calls
         * gtk_window_activate_default() on the window containing the entry, in
         * the default handler for the #GtkEntry::activate signal.) */
        set(value) {
            gtk_entry_set_activates_default(self, if (value) gtk_true() else gtk_false())
        }

    var alignment: Float
        /**
         * Gets the value set by gtk_entry_set_alignment(). */
        get() = gtk_entry_get_alignment(self)
        /**
         * Sets the alignment for the contents of the entry. This controls
         * the horizontal positioning of the contents when the displayed
         * text is shorter than the width of the entry. */
        set(value) {
            gtk_entry_set_alignment(self, value)
        }

    var buffer: CPointer<GtkEntryBuffer>?
        /**
         * Get the #GtkEntryBuffer object which holds the text for
         * this widget. */
        get() = gtk_entry_get_buffer(self)!!.reinterpret()
        /**
         * Set the #GtkEntryBuffer object which holds the text for
         * this widget. */
        set(value) {
            gtk_entry_set_buffer(self, value?.reinterpret())
        }

    var completion: CPointer<GtkEntryCompletion>?
        /**
         * Returns the auxiliary completion object currently in use by @entry. */
        get() = gtk_entry_get_completion(self)!!.reinterpret()
        /**
         * Sets @completion to be the auxiliary completion object to use with @entry.
         * All further configuration of the completion mechanism is done on
         * @completion using the #GtkEntryCompletion API. Completion is disabled if
         * @completion is set to %NULL. */
        set(value) {
            gtk_entry_set_completion(self, value?.reinterpret())
        }

    val currentIconDragSource: Int
        /**
         * Returns the index of the icon which is the source of the current
         * DND operation, or -1.
         *
         * This function is meant to be used in a #GtkWidget::drag-data-get
         * callback. */
        get() = gtk_entry_get_current_icon_drag_source(self)

    var cursorHadjustment: CPointer<GtkAdjustment>?
        /**
         * Retrieves the horizontal cursor adjustment for the entry.
         * See gtk_entry_set_cursor_hadjustment(). */
        get() = gtk_entry_get_cursor_hadjustment(self)!!.reinterpret()
        /**
         * Hooks up an adjustment to the cursor position in an entry, so that when
         * the cursor is moved, the adjustment is scrolled to show that position.
         * See gtk_scrolled_window_get_hadjustment() for a typical way of obtaining
         * the adjustment.
         *
         * The adjustment has to be in pixel units and in the same coordinate system
         * as the entry. */
        set(value) {
            gtk_entry_set_cursor_hadjustment(self, value?.reinterpret())
        }

    var hasFrame: Boolean
        /**
         * Gets the value set by gtk_entry_set_has_frame(). */
        get() = gtk_entry_get_has_frame(self) != 0
        /**
         * Sets whether the entry has a beveled frame around it. */
        set(value) {
            gtk_entry_set_has_frame(self, if (value) gtk_true() else gtk_false())
        }

    var inputHints: GtkInputHints
        /**
         * Gets the value of the #GtkEntry:input-hints property. */
        get() = gtk_entry_get_input_hints(self)
        /**
         * Sets the #GtkEntry:input-hints property, which
         * allows input methods to fine-tune their behaviour. */
        set(value) {
            gtk_entry_set_input_hints(self, value)
        }

    var inputPurpose: GtkInputPurpose
        /**
         * Gets the value of the #GtkEntry:input-purpose property. */
        get() = gtk_entry_get_input_purpose(self)
        /**
         * Sets the #GtkEntry:input-purpose property which
         * can be used by on-screen keyboards and other input
         * methods to adjust their behaviour. */
        set(value) {
            gtk_entry_set_input_purpose(self, value)
        }

    var maxLength: Int
        /**
         * Retrieves the maximum allowed length of the text in
         * @entry. See gtk_entry_set_max_length().
         *
         * This is equivalent to getting @entry's #GtkEntryBuffer and
         * calling gtk_entry_buffer_get_max_length() on it. */
        get() = gtk_entry_get_max_length(self)
        /**
         * Sets the maximum allowed length of the contents of the widget. If
         * the current contents are longer than the given length, then they
         * will be truncated to fit.
         *
         * This is equivalent to getting @entry's #GtkEntryBuffer and
         * calling gtk_entry_buffer_set_max_length() on it.
         * ]| */
        set(value) {
            gtk_entry_set_max_length(self, value)
        }

    var maxWidthChars: Int
        /**
         * Retrieves the desired maximum width of @entry, in characters.
         * See gtk_entry_set_max_width_chars(). */
        get() = gtk_entry_get_max_width_chars(self)
        /**
         * Sets the desired maximum width in characters of @entry. */
        set(value) {
            gtk_entry_set_max_width_chars(self, value)
        }

    var overwriteMode: Boolean
        /**
         * Gets the value set by gtk_entry_set_overwrite_mode(). */
        get() = gtk_entry_get_overwrite_mode(self) != 0
        /**
         * Sets whether the text is overwritten when typing in the #GtkEntry. */
        set(value) {
            gtk_entry_set_overwrite_mode(self, if (value) gtk_true() else gtk_false())
        }

    var placeholderText: String
        /**
         * Retrieves the text that will be displayed when @entry is empty and unfocused */
        get() = gtk_entry_get_placeholder_text(self)?.toKString() ?: ""
        /**
         * Sets text to be displayed in @entry when it is empty and unfocused.
         * This can be used to give a visual hint of the expected contents of
         * the #GtkEntry.
         *
         * Note that since the placeholder text gets removed when the entry
         * received focus, using this feature is a bit problematic if the entry
         * is given the initial focus in a window. Sometimes this can be
         * worked around by delaying the initial focus setting until the
         * first key event arrives. */
        set(value) {
            gtk_entry_set_placeholder_text(self, value)
        }

    var progressFraction: Double
        /**
         * Returns the current fraction of the task that’s been completed.
         * See gtk_entry_set_progress_fraction(). */
        get() = gtk_entry_get_progress_fraction(self)
        /**
         * Causes the entry’s progress indicator to “fill in” the given
         * fraction of the bar. The fraction should be between 0.0 and 1.0,
         * inclusive. */
        set(value) {
            gtk_entry_set_progress_fraction(self, value)
        }

    var progressPulseStep: Double
        /**
         * Retrieves the pulse step set with gtk_entry_set_progress_pulse_step(). */
        get() = gtk_entry_get_progress_pulse_step(self)
        /**
         * Sets the fraction of total entry width to move the progress
         * bouncing block for each call to gtk_entry_progress_pulse(). */
        set(value) {
            gtk_entry_set_progress_pulse_step(self, value)
        }

    var text: String
        /**
         * Retrieves the contents of the entry widget.
         * See also gtk_editable_get_chars().
         *
         * This is equivalent to getting @entry's #GtkEntryBuffer and calling
         * gtk_entry_buffer_get_text() on it. */
        get() = gtk_entry_get_text(self)?.toKString() ?: ""
        /**
         * Sets the text in the widget to the given
         * value, replacing the current contents.
         *
         * See gtk_entry_buffer_set_text(). */
        set(value) {
            gtk_entry_set_text(self, value)
        }

    val textLength: Short
        /**
         * Retrieves the current length of the text in
         * @entry.
         *
         * This is equivalent to getting @entry's #GtkEntryBuffer and
         * calling gtk_entry_buffer_get_length() on it. */
        get() = gtk_entry_get_text_length(self)

    var visibility: Boolean
        /**
         * Retrieves whether the text in @entry is visible. See
         * gtk_entry_set_visibility(). */
        get() = gtk_entry_get_visibility(self) != 0
        /**
         * Sets whether the contents of the entry are visible or not.
         * When visibility is set to %FALSE, characters are displayed
         * as the invisible char, and will also appear that way when
         * the text in the entry widget is copied elsewhere.
         *
         * By default, GTK+ picks the best invisible character available
         * in the current font, but it can be changed with
         * gtk_entry_set_invisible_char().
         *
         * Note that you probably want to set #GtkEntry:input-purpose
         * to %GTK_INPUT_PURPOSE_PASSWORD or %GTK_INPUT_PURPOSE_PIN to
         * inform input methods about the purpose of this entry,
         * in addition to setting visibility to %FALSE. */
        set(value) {
            gtk_entry_set_visibility(self, if (value) gtk_true() else gtk_false())
        }

    var widthChars: Int
        /**
         * Gets the value set by gtk_entry_set_width_chars(). */
        get() = gtk_entry_get_width_chars(self)
        /**
         * Changes the size request of the entry to be about the right size
         * for @n_chars characters. Note that it changes the size
         * request, the size can still be affected by
         * how you pack the widget into containers. If @n_chars is -1, the
         * size reverts to the default entry size. */
        set(value) {
            gtk_entry_set_width_chars(self, value)
        }

    /**
     * Creates a new entry. */
    constructor() : this(gtk_entry_new()?.reinterpret())

    /**
     * Returns whether the icon is activatable. */
    fun getIconActivatable(icon_pos: GtkEntryIconPosition): Boolean = gtk_entry_get_icon_activatable(self, icon_pos) != 0

    /**
     * Finds the icon at the given position and return its index. The
     * position’s coordinates are relative to the @entry’s top left corner.
     * If @x, @y doesn’t lie inside an icon, -1 is returned.
     * This function is intended for use in a #GtkWidget::query-tooltip
     * signal handler. */
    fun getIconAtPos(x: Int, y: Int): Int = gtk_entry_get_icon_at_pos(self, x, y)

    /**
     * Retrieves the #GIcon used for the icon, or %NULL if there is
     * no icon or if the icon was set by some other method (e.g., by
     * stock, pixbuf, or icon name). */
    fun getIconGicon(icon_pos: GtkEntryIconPosition): CPointer<GIcon>? = gtk_entry_get_icon_gicon(self, icon_pos)!!.reinterpret()

    /**
     * Retrieves the icon name used for the icon, or %NULL if there is
     * no icon or if the icon was set by some other method (e.g., by
     * pixbuf, stock or gicon). */
    fun getIconName(icon_pos: GtkEntryIconPosition): String = gtk_entry_get_icon_name(self, icon_pos)?.toKString() ?: ""

    /**
     * Retrieves the image used for the icon.
     *
     * Unlike the other methods of setting and getting icon data, this
     * method will work regardless of whether the icon was set using a
     * #GdkPixbuf, a #GIcon, a stock item, or an icon name. */
    fun getIconPixbuf(icon_pos: GtkEntryIconPosition): CPointer<GdkPixbuf>? = gtk_entry_get_icon_pixbuf(self, icon_pos)!!.reinterpret()

    /**
     * Returns whether the icon appears sensitive or insensitive. */
    fun getIconSensitive(icon_pos: GtkEntryIconPosition): Boolean = gtk_entry_get_icon_sensitive(self, icon_pos) != 0

    /**
     * Gets the type of representation being used by the icon
     * to store image data. If the icon has no image data,
     * the return value will be %GTK_IMAGE_EMPTY. */
    fun getIconStorageType(icon_pos: GtkEntryIconPosition): GtkImageType = gtk_entry_get_icon_storage_type(self, icon_pos)

    /**
     * Gets the contents of the tooltip on the icon at the specified
     * position in @entry. */
    fun getIconTooltipMarkup(icon_pos: GtkEntryIconPosition): String = gtk_entry_get_icon_tooltip_markup(self, icon_pos)?.toKString() ?: ""

    /**
     * Gets the contents of the tooltip on the icon at the specified
     * position in @entry. */
    fun getIconTooltipText(icon_pos: GtkEntryIconPosition): String = gtk_entry_get_icon_tooltip_text(self, icon_pos)?.toKString() ?: ""

    /**
     * Causes @entry to have keyboard focus.
     *
     * It behaves like gtk_widget_grab_focus(),
     * except that it doesn't select the contents of the entry.
     * You only want to call this on some special entries
     * which the user usually doesn't want to replace all text in,
     * such as search-as-you-type entries. */
    fun grabFocusWithoutSelecting(): Unit = gtk_entry_grab_focus_without_selecting(self)

    /**
     * Allow the #GtkEntry input method to internally handle key press
     * and release events. If this function returns %TRUE, then no further
     * processing should be done for this key event. See
     * gtk_im_context_filter_keypress().
     *
     * Note that you are expected to call this function from your handler
     * when overriding key event handling. This is needed in the case when
     * you need to insert your own key handling between the input method
     * and the default key event handling of the #GtkEntry.
     * See gtk_text_view_reset_im_context() for an example of use. */
    fun imContextFilterKeypress(event: CPointer<GdkEventKey>?): Boolean = gtk_entry_im_context_filter_keypress(self, event) != 0

    /**
     * Converts from a position in the entry’s #PangoLayout (returned by
     * gtk_entry_get_layout()) to a position in the entry contents
     * (returned by gtk_entry_get_text()). */
    fun layoutIndexToTextIndex(layout_index: Int): Int = gtk_entry_layout_index_to_text_index(self, layout_index)

    /**
     * Indicates that some progress is made, but you don’t know how much.
     * Causes the entry’s progress indicator to enter “activity mode,”
     * where a block bounces back and forth. Each call to
     * gtk_entry_progress_pulse() causes the block to move by a little bit
     * (the amount of movement per pulse is determined by
     * gtk_entry_set_progress_pulse_step()). */
    fun progressPulse(): Unit = gtk_entry_progress_pulse(self)

    /**
     * Reset the input method context of the entry if needed.
     *
     * This can be necessary in the case where modifying the buffer
     * would confuse on-going input method behavior. */
    fun resetImContext(): Unit = gtk_entry_reset_im_context(self)

    /**
     * Sets whether the icon is activatable. */
    fun setIconActivatable(icon_pos: GtkEntryIconPosition, activatable: Boolean): Unit = gtk_entry_set_icon_activatable(self, icon_pos, if (activatable) gtk_true() else gtk_false())

    /**
     * Sets up the icon at the given position so that GTK+ will start a drag
     * operation when the user clicks and drags the icon.
     *
     * To handle the drag operation, you need to connect to the usual
     * #GtkWidget::drag-data-get (or possibly #GtkWidget::drag-data-delete)
     * signal, and use gtk_entry_get_current_icon_drag_source() in
     * your signal handler to find out if the drag was started from
     * an icon.
     *
     * By default, GTK+ uses the icon as the drag icon. You can use the
     * #GtkWidget::drag-begin signal to set a different icon. Note that you
     * have to use g_signal_connect_after() to ensure that your signal handler
     * gets executed after the default handler. */
    fun setIconDragSource(
            icon_pos: GtkEntryIconPosition,
            target_list: CPointer<GtkTargetList>?,
            actions: GdkDragAction
    ): Unit = gtk_entry_set_icon_drag_source(self, icon_pos, target_list, actions)

    /**
     * Sets the icon shown in the entry at the specified position
     * from the current icon theme.
     * If the icon isn’t known, a “broken image” icon will be displayed
     * instead.
     *
     * If @icon is %NULL, no icon will be shown in the specified position. */
    fun setIconFromGicon(icon_pos: GtkEntryIconPosition, icon: CPointer<GIcon>?): Unit = gtk_entry_set_icon_from_gicon(self, icon_pos, icon)

    /**
     * Sets the icon shown in the entry at the specified position
     * from the current icon theme.
     *
     * If the icon name isn’t known, a “broken image” icon will be displayed
     * instead.
     *
     * If @icon_name is %NULL, no icon will be shown in the specified position. */
    fun setIconFromIconName(icon_pos: GtkEntryIconPosition, icon_name: String): Unit = gtk_entry_set_icon_from_icon_name(self, icon_pos, icon_name)

    /**
     * Sets the icon shown in the specified position using a pixbuf.
     *
     * If @pixbuf is %NULL, no icon will be shown in the specified position. */
    fun setIconFromPixbuf(icon_pos: GtkEntryIconPosition, pixbuf: CPointer<GdkPixbuf>?): Unit = gtk_entry_set_icon_from_pixbuf(self, icon_pos, pixbuf)

    /**
     * Sets the sensitivity for the specified icon. */
    fun setIconSensitive(icon_pos: GtkEntryIconPosition, sensitive: Boolean): Unit = gtk_entry_set_icon_sensitive(self, icon_pos, if (sensitive) gtk_true() else gtk_false())

    /**
     * Sets @tooltip as the contents of the tooltip for the icon at
     * the specified position. @tooltip is assumed to be marked up with
     * the [Pango text markup language][PangoMarkupFormat].
     *
     * Use %NULL for @tooltip to remove an existing tooltip.
     *
     * See also gtk_widget_set_tooltip_markup() and
     * gtk_entry_set_icon_tooltip_text(). */
    fun setIconTooltipMarkup(icon_pos: GtkEntryIconPosition, tooltip: String): Unit = gtk_entry_set_icon_tooltip_markup(self, icon_pos, tooltip)

    /**
     * Sets @tooltip as the contents of the tooltip for the icon
     * at the specified position.
     *
     * Use %NULL for @tooltip to remove an existing tooltip.
     *
     * See also gtk_widget_set_tooltip_text() and
     * gtk_entry_set_icon_tooltip_markup().
     *
     * If you unset the widget tooltip via gtk_widget_set_tooltip_text() or
     * gtk_widget_set_tooltip_markup(), this sets GtkWidget:has-tooltip to %FALSE,
     * which suppresses icon tooltips too. You can resolve this by then calling
     * gtk_widget_set_has_tooltip() to set GtkWidget:has-tooltip back to %TRUE, or
     * setting at least one non-empty tooltip on any icon achieves the same result. */
    fun setIconTooltipText(icon_pos: GtkEntryIconPosition, tooltip: String): Unit = gtk_entry_set_icon_tooltip_text(self, icon_pos, tooltip)

    /**
     * Converts from a position in the entry contents (returned
     * by gtk_entry_get_text()) to a position in the
     * entry’s #PangoLayout (returned by gtk_entry_get_layout(),
     * with text retrieved via pango_layout_get_text()). */
    fun textIndexToLayoutIndex(text_index: Int): Int = gtk_entry_text_index_to_layout_index(self, text_index)

    /**
     * Unsets the invisible char previously set with
     * gtk_entry_set_invisible_char(). So that the
     * default invisible char is used again. */
    fun unsetInvisibleChar(): Unit = gtk_entry_unset_invisible_char(self)
}

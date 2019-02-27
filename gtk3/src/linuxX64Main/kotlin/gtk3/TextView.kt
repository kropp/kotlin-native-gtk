package gtk3

import kotlin.Boolean
import kotlin.Double
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
import libgtk3.GdkEventKey
import libgtk3.GdkWindow
import libgtk3.GtkInputHints
import libgtk3.GtkInputPurpose
import libgtk3.GtkJustification
import libgtk3.GtkTextAttributes
import libgtk3.GtkTextBuffer
import libgtk3.GtkTextChildAnchor
import libgtk3.GtkTextIter
import libgtk3.GtkTextMark
import libgtk3.GtkTextView
import libgtk3.GtkTextWindowType
import libgtk3.GtkWidget
import libgtk3.GtkWrapMode
import libgtk3.gtk_false
import libgtk3.gtk_text_view_add_child_at_anchor
import libgtk3.gtk_text_view_add_child_in_window
import libgtk3.gtk_text_view_backward_display_line
import libgtk3.gtk_text_view_backward_display_line_start
import libgtk3.gtk_text_view_forward_display_line
import libgtk3.gtk_text_view_forward_display_line_end
import libgtk3.gtk_text_view_get_accepts_tab
import libgtk3.gtk_text_view_get_border_window_size
import libgtk3.gtk_text_view_get_bottom_margin
import libgtk3.gtk_text_view_get_buffer
import libgtk3.gtk_text_view_get_cursor_visible
import libgtk3.gtk_text_view_get_default_attributes
import libgtk3.gtk_text_view_get_editable
import libgtk3.gtk_text_view_get_indent
import libgtk3.gtk_text_view_get_input_hints
import libgtk3.gtk_text_view_get_input_purpose
import libgtk3.gtk_text_view_get_justification
import libgtk3.gtk_text_view_get_left_margin
import libgtk3.gtk_text_view_get_monospace
import libgtk3.gtk_text_view_get_overwrite
import libgtk3.gtk_text_view_get_pixels_above_lines
import libgtk3.gtk_text_view_get_pixels_below_lines
import libgtk3.gtk_text_view_get_pixels_inside_wrap
import libgtk3.gtk_text_view_get_right_margin
import libgtk3.gtk_text_view_get_top_margin
import libgtk3.gtk_text_view_get_window
import libgtk3.gtk_text_view_get_window_type
import libgtk3.gtk_text_view_get_wrap_mode
import libgtk3.gtk_text_view_im_context_filter_keypress
import libgtk3.gtk_text_view_move_child
import libgtk3.gtk_text_view_move_mark_onscreen
import libgtk3.gtk_text_view_move_visually
import libgtk3.gtk_text_view_new
import libgtk3.gtk_text_view_place_cursor_onscreen
import libgtk3.gtk_text_view_reset_cursor_blink
import libgtk3.gtk_text_view_reset_im_context
import libgtk3.gtk_text_view_scroll_mark_onscreen
import libgtk3.gtk_text_view_scroll_to_iter
import libgtk3.gtk_text_view_scroll_to_mark
import libgtk3.gtk_text_view_set_accepts_tab
import libgtk3.gtk_text_view_set_border_window_size
import libgtk3.gtk_text_view_set_bottom_margin
import libgtk3.gtk_text_view_set_buffer
import libgtk3.gtk_text_view_set_cursor_visible
import libgtk3.gtk_text_view_set_editable
import libgtk3.gtk_text_view_set_indent
import libgtk3.gtk_text_view_set_input_hints
import libgtk3.gtk_text_view_set_input_purpose
import libgtk3.gtk_text_view_set_justification
import libgtk3.gtk_text_view_set_left_margin
import libgtk3.gtk_text_view_set_monospace
import libgtk3.gtk_text_view_set_overwrite
import libgtk3.gtk_text_view_set_pixels_above_lines
import libgtk3.gtk_text_view_set_pixels_below_lines
import libgtk3.gtk_text_view_set_pixels_inside_wrap
import libgtk3.gtk_text_view_set_right_margin
import libgtk3.gtk_text_view_set_top_margin
import libgtk3.gtk_text_view_set_wrap_mode
import libgtk3.gtk_text_view_starts_display_line
import libgtk3.gtk_true

inline fun Container.textView(init: TextView.() -> Unit = {}): TextView = TextView().apply { init();
        this@textView.add(this) }

private fun TextView_onBackspace_Handler(sender: CPointer<in CPointed>?, _data: COpaquePointer?) {
    _data?.asStableRef<TextView>()?.get()?.onBackspace?.emit()
}

private fun TextView_onCopyClipboard_Handler(sender: CPointer<in CPointed>?, _data: COpaquePointer?)
        {
    _data?.asStableRef<TextView>()?.get()?.onCopyClipboard?.emit()
}

private fun TextView_onCutClipboard_Handler(sender: CPointer<in CPointed>?, _data: COpaquePointer?)
        {
    _data?.asStableRef<TextView>()?.get()?.onCutClipboard?.emit()
}

private fun TextView_onInsertAtCursor_Handler(
    sender: CPointer<in CPointed>?,
    string: CPointer<ByteVar>,
    _data: COpaquePointer?
) {
    _data?.asStableRef<TextView>()?.get()?.onInsertAtCursor?.emit(string.toKString())
}

private fun TextView_onInsertEmoji_Handler(sender: CPointer<in CPointed>?, _data: COpaquePointer?) {
    _data?.asStableRef<TextView>()?.get()?.onInsertEmoji?.emit()
}

private fun TextView_onPasteClipboard_Handler(sender: CPointer<in CPointed>?, _data:
        COpaquePointer?) {
    _data?.asStableRef<TextView>()?.get()?.onPasteClipboard?.emit()
}

private fun TextView_onPopulatePopup_Handler(
    sender: CPointer<in CPointed>?,
    popup: CPointer<GtkWidget>,
    _data: COpaquePointer?
) {
    _data?.asStableRef<TextView>()?.get()?.onPopulatePopup?.emit(popup?.reinterpret())
}

private fun TextView_onPreeditChanged_Handler(
    sender: CPointer<in CPointed>?,
    preedit: CPointer<ByteVar>,
    _data: COpaquePointer?
) {
    _data?.asStableRef<TextView>()?.get()?.onPreeditChanged?.emit(preedit.toKString())
}

private fun TextView_onSelectAll_Handler(
    sender: CPointer<in CPointed>?,
    select: Boolean,
    _data: COpaquePointer?
) {
    _data?.asStableRef<TextView>()?.get()?.onSelectAll?.emit(select)
}

private fun TextView_onSetAnchor_Handler(sender: CPointer<in CPointed>?, _data: COpaquePointer?) {
    _data?.asStableRef<TextView>()?.get()?.onSetAnchor?.emit()
}

private fun TextView_onToggleCursorVisible_Handler(sender: CPointer<in CPointed>?, _data:
        COpaquePointer?) {
    _data?.asStableRef<TextView>()?.get()?.onToggleCursorVisible?.emit()
}

private fun TextView_onToggleOverwrite_Handler(sender: CPointer<in CPointed>?, _data:
        COpaquePointer?) {
    _data?.asStableRef<TextView>()?.get()?.onToggleOverwrite?.emit()
}

/**
 * You may wish to begin by reading the
 * [text widget conceptual overview][TextWidget]
 * which gives an overview of all the objects and data
 * types related to the text widget and how they work together.
 *
 * # CSS nodes
 *
 * |[<!-- language="plain" -->
 * textview.view
 * ├── border.top
 * ├── border.left
 * ├── text
 * │   ╰── [selection]
 * ├── border.right
 * ├── border.bottom
 * ╰── [window.popup]
 * ]|
 *
 * GtkTextView has a main css node with name textview and style class .view,
 * and subnodes for each of the border windows, and the main text area,
 * with names border and text, respectively. The border nodes each get
 * one of the style classes .left, .right, .top or .bottom.
 *
 * A node representing the selection will appear below the text node.
 *
 * If a context menu is opened, the window node will appear as a subnode
 * of the main node.Obtains a copy of the default text attributes. These are the
 * attributes used for text unless a tag overrides them.
 * You’d typically pass the default attributes in to
 * gtk_text_iter_get_attributes() in order to get the
 * attributes in effect at a given text position.
 *
 * The return value is a copy owned by the caller of this function,
 * and should be freed with gtk_text_attributes_unref().
 */
@GtkDsl
open class TextView internal constructor(override val widgetPtr: CPointer<GtkWidget>? = null) :
        Container() {
    private val self: CPointer<GtkTextView>?
        get() = widgetPtr!!.reinterpret()

    val textView: CPointer<GtkTextView>?
        get() = widgetPtr!!.reinterpret()

    val onBackspace: Signal<TextView, CFunction<(CPointer<in CPointed>?, COpaquePointer?) -> Unit>>
            by lazy { Signal<TextView, CFunction<(CPointer<in CPointed>?, COpaquePointer?) ->
            Unit>>(widgetPtr!!, this, "backspace", staticCFunction(::TextView_onBackspace_Handler))
            }

    val onCopyClipboard: Signal<TextView, CFunction<(CPointer<in CPointed>?, COpaquePointer?) ->
            Unit>> by lazy { Signal<TextView, CFunction<(CPointer<in CPointed>?, COpaquePointer?) ->
            Unit>>(widgetPtr!!, this, "copy-clipboard",
            staticCFunction(::TextView_onCopyClipboard_Handler)) }

    val onCutClipboard: Signal<TextView, CFunction<(CPointer<in CPointed>?, COpaquePointer?) ->
            Unit>> by lazy { Signal<TextView, CFunction<(CPointer<in CPointed>?, COpaquePointer?) ->
            Unit>>(widgetPtr!!, this, "cut-clipboard",
            staticCFunction(::TextView_onCutClipboard_Handler)) }

    val onInsertAtCursor: Signal1<TextView, String, CFunction<(
        CPointer<in CPointed>?,
        CPointer<ByteVar>,
        COpaquePointer?
    ) -> Unit>> by lazy { Signal1<TextView, String, CFunction<(
                CPointer<in CPointed>?,
                CPointer<ByteVar>,
                COpaquePointer?
            ) -> Unit>>(widgetPtr!!, this, "insert-at-cursor",
                    staticCFunction(::TextView_onInsertAtCursor_Handler)) }

    val onInsertEmoji: Signal<TextView, CFunction<(CPointer<in CPointed>?, COpaquePointer?) ->
            Unit>> by lazy { Signal<TextView, CFunction<(CPointer<in CPointed>?, COpaquePointer?) ->
            Unit>>(widgetPtr!!, this, "insert-emoji",
            staticCFunction(::TextView_onInsertEmoji_Handler)) }

    val onPasteClipboard: Signal<TextView, CFunction<(CPointer<in CPointed>?, COpaquePointer?) ->
            Unit>> by lazy { Signal<TextView, CFunction<(CPointer<in CPointed>?, COpaquePointer?) ->
            Unit>>(widgetPtr!!, this, "paste-clipboard",
            staticCFunction(::TextView_onPasteClipboard_Handler)) }

    val onPopulatePopup: Signal1<TextView, CPointer<GtkWidget>, CFunction<(
        CPointer<in CPointed>?,
        CPointer<GtkWidget>,
        COpaquePointer?
    ) -> Unit>> by lazy { Signal1<TextView, CPointer<GtkWidget>, CFunction<(
                CPointer<in CPointed>?,
                CPointer<GtkWidget>,
                COpaquePointer?
            ) -> Unit>>(widgetPtr!!, this, "populate-popup",
                    staticCFunction(::TextView_onPopulatePopup_Handler)) }

    val onPreeditChanged: Signal1<TextView, String, CFunction<(
        CPointer<in CPointed>?,
        CPointer<ByteVar>,
        COpaquePointer?
    ) -> Unit>> by lazy { Signal1<TextView, String, CFunction<(
                CPointer<in CPointed>?,
                CPointer<ByteVar>,
                COpaquePointer?
            ) -> Unit>>(widgetPtr!!, this, "preedit-changed",
                    staticCFunction(::TextView_onPreeditChanged_Handler)) }

    val onSelectAll: Signal1<TextView, Boolean, CFunction<(
        CPointer<in CPointed>?,
        Boolean,
        COpaquePointer?
    ) -> Unit>> by lazy { Signal1<TextView, Boolean, CFunction<(
                CPointer<in CPointed>?,
                Boolean,
                COpaquePointer?
            ) -> Unit>>(widgetPtr!!, this, "select-all",
                    staticCFunction(::TextView_onSelectAll_Handler)) }

    val onSetAnchor: Signal<TextView, CFunction<(CPointer<in CPointed>?, COpaquePointer?) -> Unit>>
            by lazy { Signal<TextView, CFunction<(CPointer<in CPointed>?, COpaquePointer?) ->
            Unit>>(widgetPtr!!, this, "set-anchor", staticCFunction(::TextView_onSetAnchor_Handler))
            }

    val onToggleCursorVisible: Signal<TextView, CFunction<(CPointer<in CPointed>?,
            COpaquePointer?) -> Unit>> by lazy { Signal<TextView, CFunction<(CPointer<in CPointed>?,
            COpaquePointer?) -> Unit>>(widgetPtr!!, this, "toggle-cursor-visible",
            staticCFunction(::TextView_onToggleCursorVisible_Handler)) }

    val onToggleOverwrite: Signal<TextView, CFunction<(CPointer<in CPointed>?, COpaquePointer?) ->
            Unit>> by lazy { Signal<TextView, CFunction<(CPointer<in CPointed>?, COpaquePointer?) ->
            Unit>>(widgetPtr!!, this, "toggle-overwrite",
            staticCFunction(::TextView_onToggleOverwrite_Handler)) }

    /**
     * Returns whether pressing the Tab key inserts a tab characters.
     * gtk_text_view_set_accepts_tab().
     *
     * Sets the behavior of the text widget when the Tab key is pressed.
     * If @accepts_tab is %TRUE, a tab character is inserted. If @accepts_tab
     * is %FALSE the keyboard focus is moved to the next widget in the focus
     * chain. */
    var acceptsTab: Boolean
        get() = gtk_text_view_get_accepts_tab(self) != 0
        set(value) {
            gtk_text_view_set_accepts_tab(self, if (value) gtk_true() else gtk_false())
        }

    /**
     * Gets the bottom margin for text in the @text_view.
     *
     * Sets the bottom margin for text in @text_view.
     *
     * Note that this function is confusingly named.
     * In CSS terms, the value set here is padding. */
    var bottomMargin: Int
        get() = gtk_text_view_get_bottom_margin(self)
        set(value) {
            gtk_text_view_set_bottom_margin(self, value)
        }

    /**
     * Returns the #GtkTextBuffer being displayed by this text view.
     * The reference count on the buffer is not incremented; the caller
     * of this function won’t own a new reference.
     *
     * Sets @buffer as the buffer being displayed by @text_view. The previous
     * buffer displayed by the text view is unreferenced, and a reference is
     * added to @buffer. If you owned a reference to @buffer before passing it
     * to this function, you must remove that reference yourself; #GtkTextView
     * will not “adopt” it. */
    var buffer: CPointer<GtkTextBuffer>
        get() = gtk_text_view_get_buffer(self)!!.reinterpret()
        set(value) {
            gtk_text_view_set_buffer(self, value?.reinterpret())
        }

    /**
     * Find out whether the cursor should be displayed.
     *
     * Toggles whether the insertion point should be displayed. A buffer with
     * no editable text probably shouldn’t have a visible cursor, so you may
     * want to turn the cursor off.
     *
     * Note that this property may be overridden by the
     * #GtkSettings:gtk-keynave-use-caret settings. */
    var cursorVisible: Boolean
        get() = gtk_text_view_get_cursor_visible(self) != 0
        set(value) {
            gtk_text_view_set_cursor_visible(self, if (value) gtk_true() else gtk_false())
        }

    val defaultAttributes: CPointer<GtkTextAttributes>
        get() = gtk_text_view_get_default_attributes(self)!!.reinterpret()

    /**
     * Returns the default editability of the #GtkTextView. Tags in the
     * buffer may override this setting for some ranges of text.
     *
     * Sets the default editability of the #GtkTextView. You can override
     * this default setting with tags in the buffer, using the “editable”
     * attribute of tags. */
    var editable: Boolean
        get() = gtk_text_view_get_editable(self) != 0
        set(value) {
            gtk_text_view_set_editable(self, if (value) gtk_true() else gtk_false())
        }

    /**
     * Gets the default indentation of paragraphs in @text_view.
     * Tags in the view’s buffer may override the default.
     * The indentation may be negative.
     *
     * Sets the default indentation for paragraphs in @text_view.
     * Tags in the buffer may override the default. */
    var indent: Int
        get() = gtk_text_view_get_indent(self)
        set(value) {
            gtk_text_view_set_indent(self, value)
        }

    /**
     * Gets the value of the #GtkTextView:input-hints property.
     *
     * Sets the #GtkTextView:input-hints property, which
     * allows input methods to fine-tune their behaviour. */
    var inputHints: GtkInputHints
        get() = gtk_text_view_get_input_hints(self)
        set(value) {
            gtk_text_view_set_input_hints(self, value)
        }

    /**
     * Gets the value of the #GtkTextView:input-purpose property.
     *
     * Sets the #GtkTextView:input-purpose property which
     * can be used by on-screen keyboards and other input
     * methods to adjust their behaviour. */
    var inputPurpose: GtkInputPurpose
        get() = gtk_text_view_get_input_purpose(self)
        set(value) {
            gtk_text_view_set_input_purpose(self, value)
        }

    /**
     * Gets the default justification of paragraphs in @text_view.
     * Tags in the buffer may override the default.
     *
     * Sets the default justification of text in @text_view.
     * Tags in the view’s buffer may override the default. */
    var justification: GtkJustification
        get() = gtk_text_view_get_justification(self)
        set(value) {
            gtk_text_view_set_justification(self, value)
        }

    /**
     * Gets the default left margin size of paragraphs in the @text_view.
     * Tags in the buffer may override the default.
     *
     * Sets the default left margin for text in @text_view.
     * Tags in the buffer may override the default.
     *
     * Note that this function is confusingly named.
     * In CSS terms, the value set here is padding. */
    var leftMargin: Int
        get() = gtk_text_view_get_left_margin(self)
        set(value) {
            gtk_text_view_set_left_margin(self, value)
        }

    /**
     * Gets the value of the #GtkTextView:monospace property.
     *
     * Sets the #GtkTextView:monospace property, which
     * indicates that the text view should use monospace
     * fonts. */
    var monospace: Boolean
        get() = gtk_text_view_get_monospace(self) != 0
        set(value) {
            gtk_text_view_set_monospace(self, if (value) gtk_true() else gtk_false())
        }

    /**
     * Returns whether the #GtkTextView is in overwrite mode or not.
     *
     * Changes the #GtkTextView overwrite mode. */
    var overwrite: Boolean
        get() = gtk_text_view_get_overwrite(self) != 0
        set(value) {
            gtk_text_view_set_overwrite(self, if (value) gtk_true() else gtk_false())
        }

    /**
     * Gets the default number of pixels to put above paragraphs.
     * Adding this function with gtk_text_view_get_pixels_below_lines()
     * is equal to the line space between each paragraph.
     *
     * Sets the default number of blank pixels above paragraphs in @text_view.
     * Tags in the buffer for @text_view may override the defaults. */
    var pixelsAboveLines: Int
        get() = gtk_text_view_get_pixels_above_lines(self)
        set(value) {
            gtk_text_view_set_pixels_above_lines(self, value)
        }

    /**
     * Gets the value set by gtk_text_view_set_pixels_below_lines().
     *
     * The line space is the sum of the value returned by this function and the
     * value returned by gtk_text_view_get_pixels_above_lines().
     *
     * Sets the default number of pixels of blank space
     * to put below paragraphs in @text_view. May be overridden
     * by tags applied to @text_view’s buffer. */
    var pixelsBelowLines: Int
        get() = gtk_text_view_get_pixels_below_lines(self)
        set(value) {
            gtk_text_view_set_pixels_below_lines(self, value)
        }

    /**
     * Gets the value set by gtk_text_view_set_pixels_inside_wrap().
     *
     * Sets the default number of pixels of blank space to leave between
     * display/wrapped lines within a paragraph. May be overridden by
     * tags in @text_view’s buffer. */
    var pixelsInsideWrap: Int
        get() = gtk_text_view_get_pixels_inside_wrap(self)
        set(value) {
            gtk_text_view_set_pixels_inside_wrap(self, value)
        }

    /**
     * Gets the default right margin for text in @text_view. Tags
     * in the buffer may override the default.
     *
     * Sets the default right margin for text in the text view.
     * Tags in the buffer may override the default.
     *
     * Note that this function is confusingly named.
     * In CSS terms, the value set here is padding. */
    var rightMargin: Int
        get() = gtk_text_view_get_right_margin(self)
        set(value) {
            gtk_text_view_set_right_margin(self, value)
        }

    /**
     * Gets the top margin for text in the @text_view.
     *
     * Sets the top margin for text in @text_view.
     *
     * Note that this function is confusingly named.
     * In CSS terms, the value set here is padding. */
    var topMargin: Int
        get() = gtk_text_view_get_top_margin(self)
        set(value) {
            gtk_text_view_set_top_margin(self, value)
        }

    /**
     * Gets the line wrapping for the view.
     *
     * Sets the line wrapping for the view. */
    var wrapMode: GtkWrapMode
        get() = gtk_text_view_get_wrap_mode(self)
        set(value) {
            gtk_text_view_set_wrap_mode(self, value)
        }

    /**
     * Creates a new #GtkTextView. If you don’t call gtk_text_view_set_buffer()
     * before using the text view, an empty default buffer will be created
     * for you. Get the buffer with gtk_text_view_get_buffer(). If you want
     * to specify your own buffer, consider gtk_text_view_new_with_buffer(). */
    constructor() : this(gtk_text_view_new()?.reinterpret())

    /**
     * Adds a child widget in the text buffer, at the given @anchor.
     */
    fun addChildAtAnchor(child: CPointer<GtkWidget>, anchor: CPointer<GtkTextChildAnchor>): Unit =
            gtk_text_view_add_child_at_anchor(self, child, anchor)

    /**
     * Adds a child at fixed coordinates in one of the text widget's
     * windows.
     *
     * The window must have nonzero size (see
     * gtk_text_view_set_border_window_size()). Note that the child
     * coordinates are given relative to scrolling. When
     * placing a child in #GTK_TEXT_WINDOW_WIDGET, scrolling is
     * irrelevant, the child floats above all scrollable areas. But when
     * placing a child in one of the scrollable windows (border windows or
     * text window) it will move with the scrolling as needed.
     */
    fun addChildInWindow(
        child: CPointer<GtkWidget>,
        which_window: GtkTextWindowType,
        xpos: Int,
        ypos: Int
    ): Unit = gtk_text_view_add_child_in_window(self, child, which_window, xpos, ypos)

    /**
     * Adds a child at fixed coordinates in one of the text widget's
     * windows.
     *
     * The window must have nonzero size (see
     * gtk_text_view_set_border_window_size()). Note that the child
     * coordinates are given relative to scrolling. When
     * placing a child in #GTK_TEXT_WINDOW_WIDGET, scrolling is
     * irrelevant, the child floats above all scrollable areas. But when
     * placing a child in one of the scrollable windows (border windows or
     * text window) it will move with the scrolling as needed.
     */
    fun addChildInWindow(
        child: Widget,
        which_window: GtkTextWindowType,
        xpos: Int,
        ypos: Int
    ): Unit = gtk_text_view_add_child_in_window(self, child.widgetPtr?.reinterpret(), which_window,
            xpos, ypos)

    /**
     * Moves the given @iter backward by one display (wrapped) line.
     * A display line is different from a paragraph. Paragraphs are
     * separated by newlines or other paragraph separator characters.
     * Display lines are created by line-wrapping a paragraph. If
     * wrapping is turned off, display lines and paragraphs will be the
     * same. Display lines are divided differently for each view, since
     * they depend on the view’s width; paragraphs are the same in all
     * views, since they depend on the contents of the #GtkTextBuffer.
     */
    fun backwardDisplayLine(iter: CPointer<GtkTextIter>): Boolean =
            gtk_text_view_backward_display_line(self, iter) != 0

    /**
     * Moves the given @iter backward to the next display line start.
     * A display line is different from a paragraph. Paragraphs are
     * separated by newlines or other paragraph separator characters.
     * Display lines are created by line-wrapping a paragraph. If
     * wrapping is turned off, display lines and paragraphs will be the
     * same. Display lines are divided differently for each view, since
     * they depend on the view’s width; paragraphs are the same in all
     * views, since they depend on the contents of the #GtkTextBuffer.
     */
    fun backwardDisplayLineStart(iter: CPointer<GtkTextIter>): Boolean =
            gtk_text_view_backward_display_line_start(self, iter) != 0

    /**
     * Moves the given @iter forward by one display (wrapped) line.
     * A display line is different from a paragraph. Paragraphs are
     * separated by newlines or other paragraph separator characters.
     * Display lines are created by line-wrapping a paragraph. If
     * wrapping is turned off, display lines and paragraphs will be the
     * same. Display lines are divided differently for each view, since
     * they depend on the view’s width; paragraphs are the same in all
     * views, since they depend on the contents of the #GtkTextBuffer.
     */
    fun forwardDisplayLine(iter: CPointer<GtkTextIter>): Boolean =
            gtk_text_view_forward_display_line(self, iter) != 0

    /**
     * Moves the given @iter forward to the next display line end.
     * A display line is different from a paragraph. Paragraphs are
     * separated by newlines or other paragraph separator characters.
     * Display lines are created by line-wrapping a paragraph. If
     * wrapping is turned off, display lines and paragraphs will be the
     * same. Display lines are divided differently for each view, since
     * they depend on the view’s width; paragraphs are the same in all
     * views, since they depend on the contents of the #GtkTextBuffer.
     */
    fun forwardDisplayLineEnd(iter: CPointer<GtkTextIter>): Boolean =
            gtk_text_view_forward_display_line_end(self, iter) != 0

    /**
     * Gets the width of the specified border window. See
     * gtk_text_view_set_border_window_size().
     */
    fun getBorderWindowSize(type: GtkTextWindowType): Int =
            gtk_text_view_get_border_window_size(self, type)

    /**
     * Retrieves the #GdkWindow corresponding to an area of the text view;
     * possible windows include the overall widget window, child windows
     * on the left, right, top, bottom, and the window that displays the
     * text buffer. Windows are %NULL and nonexistent if their width or
     * height is 0, and are nonexistent before the widget has been
     * realized.
     */
    fun getWindow(win: GtkTextWindowType): CPointer<GdkWindow> = gtk_text_view_get_window(self,
            win)!!.reinterpret()

    /**
     * Usually used to find out which window an event corresponds to.
     *
     * If you connect to an event signal on @text_view, this function
     * should be called on `event->window` to see which window it was.
     */
    fun getWindowType(window: CPointer<GdkWindow>): GtkTextWindowType =
            gtk_text_view_get_window_type(self, window)

    /**
     * Allow the #GtkTextView input method to internally handle key press
     * and release events. If this function returns %TRUE, then no further
     * processing should be done for this key event. See
     * gtk_im_context_filter_keypress().
     *
     * Note that you are expected to call this function from your handler
     * when overriding key event handling. This is needed in the case when
     * you need to insert your own key handling between the input method
     * and the default key event handling of the #GtkTextView.
     *
     * |[<!-- language="C" -->
     * static gboolean
     * gtk_foo_bar_key_press_event (GtkWidget   *widget,
     *                              GdkEventKey *event)
     * {
     *   guint keyval;
     *
     *   gdk_event_get_keyval ((GdkEvent*)event, &keyval);
     *
     *   if (keyval == GDK_KEY_Return || keyval == GDK_KEY_KP_Enter)
     *     {
     *       if (gtk_text_view_im_context_filter_keypress (GTK_TEXT_VIEW (widget), event))
     *         return TRUE;
     *     }
     *
     *   // Do some stuff
     *
     *   return GTK_WIDGET_CLASS (gtk_foo_bar_parent_class)->key_press_event (widget, event);
     * }
     * ]|
     */
    fun imContextFilterKeypress(event: CPointer<GdkEventKey>): Boolean =
            gtk_text_view_im_context_filter_keypress(self, event) != 0

    /**
     * Updates the position of a child, as for gtk_text_view_add_child_in_window().
     */
    fun moveChild(
        child: CPointer<GtkWidget>,
        xpos: Int,
        ypos: Int
    ): Unit = gtk_text_view_move_child(self, child, xpos, ypos)

    /**
     * Updates the position of a child, as for gtk_text_view_add_child_in_window().
     */
    fun moveChild(
        child: Widget,
        xpos: Int,
        ypos: Int
    ): Unit = gtk_text_view_move_child(self, child.widgetPtr?.reinterpret(), xpos, ypos)

    /**
     * Moves a mark within the buffer so that it's
     * located within the currently-visible text area.
     */
    fun moveMarkOnscreen(mark: CPointer<GtkTextMark>): Boolean =
            gtk_text_view_move_mark_onscreen(self, mark) != 0

    /**
     * Move the iterator a given number of characters visually, treating
     * it as the strong cursor position. If @count is positive, then the
     * new strong cursor position will be @count positions to the right of
     * the old cursor position. If @count is negative then the new strong
     * cursor position will be @count positions to the left of the old
     * cursor position.
     *
     * In the presence of bi-directional text, the correspondence
     * between logical and visual order will depend on the direction
     * of the current run, and there may be jumps when the cursor
     * is moved off of the end of a run.
     */
    fun moveVisually(iter: CPointer<GtkTextIter>, count: Int): Boolean =
            gtk_text_view_move_visually(self, iter, count) != 0

    /**
     * Moves the cursor to the currently visible region of the
     * buffer, it it isn’t there already.
     */
    fun placeCursorOnscreen(): Boolean = gtk_text_view_place_cursor_onscreen(self) != 0

    /**
     * Ensures that the cursor is shown (i.e. not in an 'off' blink
     * interval) and resets the time that it will stay blinking (or
     * visible, in case blinking is disabled).
     *
     * This function should be called in response to user input
     * (e.g. from derived classes that override the textview's
     * #GtkWidget::key-press-event handler).
     */
    fun resetCursorBlink(): Unit = gtk_text_view_reset_cursor_blink(self)

    /**
     * Reset the input method context of the text view if needed.
     *
     * This can be necessary in the case where modifying the buffer
     * would confuse on-going input method behavior.
     */
    fun resetImContext(): Unit = gtk_text_view_reset_im_context(self)

    /**
     * Scrolls @text_view the minimum distance such that @mark is contained
     * within the visible area of the widget.
     */
    fun scrollMarkOnscreen(mark: CPointer<GtkTextMark>): Unit =
            gtk_text_view_scroll_mark_onscreen(self, mark)

    /**
     * Scrolls @text_view so that @iter is on the screen in the position
     * indicated by @xalign and @yalign. An alignment of 0.0 indicates
     * left or top, 1.0 indicates right or bottom, 0.5 means center.
     * If @use_align is %FALSE, the text scrolls the minimal distance to
     * get the mark onscreen, possibly not scrolling at all. The effective
     * screen for purposes of this function is reduced by a margin of size
     * @within_margin.
     *
     * Note that this function uses the currently-computed height of the
     * lines in the text buffer. Line heights are computed in an idle
     * handler; so this function may not have the desired effect if it’s
     * called before the height computations. To avoid oddness, consider
     * using gtk_text_view_scroll_to_mark() which saves a point to be
     * scrolled to after line validation.
     */
    fun scrollToIter(
        iter: CPointer<GtkTextIter>,
        within_margin: Double,
        use_align: Boolean,
        xalign: Double,
        yalign: Double
    ): Boolean = gtk_text_view_scroll_to_iter(self, iter, within_margin,
            if (use_align) gtk_true() else gtk_false(), xalign, yalign) != 0

    /**
     * Scrolls @text_view so that @mark is on the screen in the position
     * indicated by @xalign and @yalign. An alignment of 0.0 indicates
     * left or top, 1.0 indicates right or bottom, 0.5 means center.
     * If @use_align is %FALSE, the text scrolls the minimal distance to
     * get the mark onscreen, possibly not scrolling at all. The effective
     * screen for purposes of this function is reduced by a margin of size
     * @within_margin.
     */
    fun scrollToMark(
        mark: CPointer<GtkTextMark>,
        within_margin: Double,
        use_align: Boolean,
        xalign: Double,
        yalign: Double
    ): Unit = gtk_text_view_scroll_to_mark(self, mark, within_margin,
            if (use_align) gtk_true() else gtk_false(), xalign, yalign)

    /**
     * Sets the width of %GTK_TEXT_WINDOW_LEFT or %GTK_TEXT_WINDOW_RIGHT,
     * or the height of %GTK_TEXT_WINDOW_TOP or %GTK_TEXT_WINDOW_BOTTOM.
     * Automatically destroys the corresponding window if the size is set
     * to 0, and creates the window if the size is set to non-zero.  This
     * function can only be used for the “border windows”, and it won’t
     * work with %GTK_TEXT_WINDOW_WIDGET, %GTK_TEXT_WINDOW_TEXT, or
     * %GTK_TEXT_WINDOW_PRIVATE.
     */
    fun setBorderWindowSize(type: GtkTextWindowType, size: Int): Unit =
            gtk_text_view_set_border_window_size(self, type, size)

    /**
     * Determines whether @iter is at the start of a display line.
     * See gtk_text_view_forward_display_line() for an explanation of
     * display lines vs. paragraphs.
     */
    fun startsDisplayLine(iter: CPointer<GtkTextIter>): Boolean =
            gtk_text_view_starts_display_line(self, iter) != 0
}

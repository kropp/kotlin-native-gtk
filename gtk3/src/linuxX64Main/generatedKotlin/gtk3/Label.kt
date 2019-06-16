package gtk3

import kotlin.Boolean
import kotlin.Double
import kotlin.Float
import kotlin.Int
import kotlin.String
import kotlin.UInt
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
import libgtk3.GtkJustification
import libgtk3.GtkLabel
import libgtk3.GtkMenu
import libgtk3.GtkWidget
import libgtk3.gtk_false
import libgtk3.gtk_label_get_angle
import libgtk3.gtk_label_get_current_uri
import libgtk3.gtk_label_get_justify
import libgtk3.gtk_label_get_label
import libgtk3.gtk_label_get_line_wrap
import libgtk3.gtk_label_get_lines
import libgtk3.gtk_label_get_max_width_chars
import libgtk3.gtk_label_get_mnemonic_keyval
import libgtk3.gtk_label_get_mnemonic_widget
import libgtk3.gtk_label_get_selectable
import libgtk3.gtk_label_get_single_line_mode
import libgtk3.gtk_label_get_text
import libgtk3.gtk_label_get_track_visited_links
import libgtk3.gtk_label_get_use_markup
import libgtk3.gtk_label_get_use_underline
import libgtk3.gtk_label_get_width_chars
import libgtk3.gtk_label_get_xalign
import libgtk3.gtk_label_get_yalign
import libgtk3.gtk_label_new
import libgtk3.gtk_label_select_region
import libgtk3.gtk_label_set_angle
import libgtk3.gtk_label_set_justify
import libgtk3.gtk_label_set_label
import libgtk3.gtk_label_set_line_wrap
import libgtk3.gtk_label_set_lines
import libgtk3.gtk_label_set_markup
import libgtk3.gtk_label_set_markup_with_mnemonic
import libgtk3.gtk_label_set_max_width_chars
import libgtk3.gtk_label_set_mnemonic_widget
import libgtk3.gtk_label_set_pattern
import libgtk3.gtk_label_set_selectable
import libgtk3.gtk_label_set_single_line_mode
import libgtk3.gtk_label_set_text
import libgtk3.gtk_label_set_text_with_mnemonic
import libgtk3.gtk_label_set_track_visited_links
import libgtk3.gtk_label_set_use_markup
import libgtk3.gtk_label_set_use_underline
import libgtk3.gtk_label_set_width_chars
import libgtk3.gtk_label_set_xalign
import libgtk3.gtk_label_set_yalign
import libgtk3.gtk_true

inline fun Container.label(str: String, init: Label.() -> Unit = {}): Label =
        Label(str).apply { init(); this@label.add(this) }

private fun Label_onActivateCurrentLink_Handler(sender: CPointer<in CPointed>?, _data:
        COpaquePointer?) {
    _data?.asStableRef<Label>()?.get()?.onActivateCurrentLink?.emit()
}

private fun Label_onActivateLink_Handler(
    sender: CPointer<in CPointed>?,
    uri: CPointer<ByteVar>,
    _data: COpaquePointer?
) {
    _data?.asStableRef<Label>()?.get()?.onActivateLink?.emit(uri.toKString())
}

private fun Label_onCopyClipboard_Handler(sender: CPointer<in CPointed>?, _data: COpaquePointer?) {
    _data?.asStableRef<Label>()?.get()?.onCopyClipboard?.emit()
}

private fun Label_onPopulatePopup_Handler(
    sender: CPointer<in CPointed>?,
    menu: CPointer<GtkMenu>,
    _data: COpaquePointer?
) {
    _data?.asStableRef<Label>()?.get()?.onPopulatePopup?.emit(menu?.reinterpret())
}

/**
 * The #GtkLabel widget displays a small amount of text. As the name
 * implies, most labels are used to label another widget such as a
 * #GtkButton, a #GtkMenuItem, or a #GtkComboBox.
 *
 * # CSS nodes
 *
 * |[<!-- language="plain" -->
 * label
 * ├── [selection]
 * ├── [link]
 * ┊
 * ╰── [link]
 * ]|
 *
 * GtkLabel has a single CSS node with the name label. A wide variety
 * of style classes may be applied to labels, such as .title, .subtitle,
 * .dim-label, etc. In the #GtkShortcutsWindow, labels are used wth the
 * .keycap style class.
 *
 * If the label has a selection, it gets a subnode with name selection.
 *
 * If the label has links, there is one subnode per link. These subnodes
 * carry the link or visited state depending on whether they have been
 * visited.
 *
 * # GtkLabel as GtkBuildable
 *
 * The GtkLabel implementation of the GtkBuildable interface supports a
 * custom <attributes> element, which supports any number of <attribute>
 * elements. The <attribute> element has attributes named “name“, “value“,
 * “start“ and “end“ and allows you to specify #PangoAttribute values for
 * this label.
 *
 * An example of a UI definition fragment specifying Pango attributes:
 * |[
 * <object class="GtkLabel">
 *   <attributes>
 *     <attribute name="weight" value="PANGO_WEIGHT_BOLD"/>
 *     <attribute name="background" value="red" start="5" end="10"/>
 *   </attributes>
 * </object>
 * ]|
 *
 * The start and end attributes specify the range of characters to which the
 * Pango attribute applies. If start and end are not specified, the attribute is
 * applied to the whole text. Note that specifying ranges does not make much
 * sense with translatable attributes. Use markup embedded in the translatable
 * content instead.
 *
 * # Mnemonics
 *
 * Labels may contain “mnemonics”. Mnemonics are
 * underlined characters in the label, used for keyboard navigation.
 * Mnemonics are created by providing a string with an underscore before
 * the mnemonic character, such as `"_File"`, to the
 * functions gtk_label_new_with_mnemonic() or
 * gtk_label_set_text_with_mnemonic().
 *
 * Mnemonics automatically activate any activatable widget the label is
 * inside, such as a #GtkButton; if the label is not inside the
 * mnemonic’s target widget, you have to tell the label about the target
 * using gtk_label_set_mnemonic_widget(). Here’s a simple example where
 * the label is inside a button:
 *
 * |[<!-- language="C" -->
 *   // Pressing Alt+H will activate this button
 *   GtkWidget *button = gtk_button_new ();
 *   GtkWidget *label = gtk_label_new_with_mnemonic ("_Hello");
 *   gtk_container_add (GTK_CONTAINER (button), label);
 * ]|
 *
 * There’s a convenience function to create buttons with a mnemonic label
 * already inside:
 *
 * |[<!-- language="C" -->
 *   // Pressing Alt+H will activate this button
 *   GtkWidget *button = gtk_button_new_with_mnemonic ("_Hello");
 * ]|
 *
 * To create a mnemonic for a widget alongside the label, such as a
 * #GtkEntry, you have to point the label at the entry with
 * gtk_label_set_mnemonic_widget():
 *
 * |[<!-- language="C" -->
 *   // Pressing Alt+H will focus the entry
 *   GtkWidget *entry = gtk_entry_new ();
 *   GtkWidget *label = gtk_label_new_with_mnemonic ("_Hello");
 *   gtk_label_set_mnemonic_widget (GTK_LABEL (label), entry);
 * ]|
 *
 * # Markup (styled text)
 *
 * To make it easy to format text in a label (changing colors,
 * fonts, etc.), label text can be provided in a simple
 * [markup format][PangoMarkupFormat].
 *
 * Here’s how to create a label with a small font:
 * |[<!-- language="C" -->
 *   GtkWidget *label = gtk_label_new (NULL);
 *   gtk_label_set_markup (GTK_LABEL (label), "<small>Small text</small>");
 * ]|
 *
 * (See [complete documentation][PangoMarkupFormat] of available
 * tags in the Pango manual.)
 *
 * The markup passed to gtk_label_set_markup() must be valid; for example,
 * literal <, > and & characters must be escaped as &lt;, &gt;, and &amp;.
 * If you pass text obtained from the user, file, or a network to
 * gtk_label_set_markup(), you’ll want to escape it with
 * g_markup_escape_text() or g_markup_printf_escaped().
 *
 * Markup strings are just a convenient way to set the #PangoAttrList on
 * a label; gtk_label_set_attributes() may be a simpler way to set
 * attributes in some cases. Be careful though; #PangoAttrList tends to
 * cause internationalization problems, unless you’re applying attributes
 * to the entire string (i.e. unless you set the range of each attribute
 * to [0, %G_MAXINT)). The reason is that specifying the start_index and
 * end_index for a #PangoAttribute requires knowledge of the exact string
 * being displayed, so translations will cause problems.
 *
 * # Selectable labels
 *
 * Labels can be made selectable with gtk_label_set_selectable().
 * Selectable labels allow the user to copy the label contents to
 * the clipboard. Only labels that contain useful-to-copy information
 * — such as error messages — should be made selectable.
 *
 * # Text layout # {#label-text-layout}
 *
 * A label can contain any number of paragraphs, but will have
 * performance problems if it contains more than a small number.
 * Paragraphs are separated by newlines or other paragraph separators
 * understood by Pango.
 *
 * Labels can automatically wrap text if you call
 * gtk_label_set_line_wrap().
 *
 * gtk_label_set_justify() sets how the lines in a label align
 * with one another. If you want to set how the label as a whole
 * aligns in its available space, see the #GtkWidget:halign and
 * #GtkWidget:valign properties.
 *
 * The #GtkLabel:width-chars and #GtkLabel:max-width-chars properties
 * can be used to control the size allocation of ellipsized or wrapped
 * labels. For ellipsizing labels, if either is specified (and less
 * than the actual text size), it is used as the minimum width, and the actual
 * text size is used as the natural width of the label. For wrapping labels,
 * width-chars is used as the minimum width, if specified, and max-width-chars
 * is used as the natural width. Even if max-width-chars specified, wrapping
 * labels will be rewrapped to use all of the available width.
 *
 * Note that the interpretation of #GtkLabel:width-chars and
 * #GtkLabel:max-width-chars has changed a bit with the introduction of
 * [width-for-height geometry management.][geometry-management]
 *
 * # Links
 *
 * Since 2.18, GTK+ supports markup for clickable hyperlinks in addition
 * to regular Pango markup. The markup for links is borrowed from HTML,
 * using the `<a>` with “href“ and “title“ attributes. GTK+ renders links
 * similar to the way they appear in web browsers, with colored, underlined
 * text. The “title“ attribute is displayed as a tooltip on the link.
 *
 * An example looks like this:
 *
 * |[<!-- language="C" -->
 * const gchar *text =
 * "Go to the"
 * "<a href=\"http://www.gtk.org title=\"&lt;i&gt;Our&lt;/i&gt; website\">"
 * "GTK+ website</a> for more...";
 * GtkWidget *label = gtk_label_new (NULL);
 * gtk_label_set_markup (GTK_LABEL (label), text);
 * ]|
 *
 * It is possible to implement custom handling for links and their tooltips with
 * the #GtkLabel::activate-link signal and the gtk_label_get_current_uri() function.Returns the URI
        for the currently active link in the label.
 * The active link is the one under the mouse pointer or, in a
 * selectable label, the link in which the text cursor is currently
 * positioned.
 *
 * This function is intended for use in a #GtkLabel::activate-link handler
 * or for use in a #GtkWidget::query-tooltip handler.If the label has been set so that it has an
        mnemonic key this function
 * returns the keyval used for the mnemonic accelerator. If there is no
 * mnemonic set up it returns #GDK_KEY_VoidSymbol.
 */
@GtkDsl
open class Label internal constructor(override val widgetPtr: CPointer<GtkWidget>? = null) : Misc()
        {
    private val self: CPointer<GtkLabel>?
        get() = widgetPtr!!.reinterpret()

    val onActivateCurrentLink: Signal<Label, CFunction<(CPointer<in CPointed>?, COpaquePointer?) ->
            Unit>> by lazy { Signal<Label, CFunction<(CPointer<in CPointed>?, COpaquePointer?) ->
            Unit>>(widgetPtr!!, this, "activate-current-link",
            staticCFunction(::Label_onActivateCurrentLink_Handler)) }

    val onActivateLink: Signal1<Label, String, CFunction<(
        CPointer<in CPointed>?,
        CPointer<ByteVar>,
        COpaquePointer?
    ) -> Unit>> by lazy { Signal1<Label, String, CFunction<(
                CPointer<in CPointed>?,
                CPointer<ByteVar>,
                COpaquePointer?
            ) -> Unit>>(widgetPtr!!, this, "activate-link",
                    staticCFunction(::Label_onActivateLink_Handler)) }

    val onCopyClipboard: Signal<Label, CFunction<(CPointer<in CPointed>?, COpaquePointer?) -> Unit>>
            by lazy { Signal<Label, CFunction<(CPointer<in CPointed>?, COpaquePointer?) ->
            Unit>>(widgetPtr!!, this, "copy-clipboard",
            staticCFunction(::Label_onCopyClipboard_Handler)) }

    val onPopulatePopup: Signal1<Label, CPointer<GtkMenu>, CFunction<(
        CPointer<in CPointed>?,
        CPointer<GtkMenu>,
        COpaquePointer?
    ) -> Unit>> by lazy { Signal1<Label, CPointer<GtkMenu>, CFunction<(
                CPointer<in CPointed>?,
                CPointer<GtkMenu>,
                COpaquePointer?
            ) -> Unit>>(widgetPtr!!, this, "populate-popup",
                    staticCFunction(::Label_onPopulatePopup_Handler)) }

    /**
     * Gets the angle of rotation for the label. See
     * gtk_label_set_angle().
     *
     * Sets the angle of rotation for the label. An angle of 90 reads from
     * from bottom to top, an angle of 270, from top to bottom. The angle
     * setting for the label is ignored if the label is selectable,
     * wrapped, or ellipsized. */
    var angle: Double
        get() = gtk_label_get_angle(self)
        set(value) {
            gtk_label_set_angle(self, value)
        }

    val currentUri: String
        get() = gtk_label_get_current_uri(self)?.toKString() ?: ""

    /**
     * Returns the justification of the label. See gtk_label_set_justify().
     *
     * Sets the alignment of the lines in the text of the label relative to
     * each other. %GTK_JUSTIFY_LEFT is the default value when the widget is
     * first created with gtk_label_new(). If you instead want to set the
     * alignment of the label as a whole, use gtk_widget_set_halign() instead.
     * gtk_label_set_justify() has no effect on labels containing only a
     * single line. */
    var justify: GtkJustification
        get() = gtk_label_get_justify(self)
        set(value) {
            gtk_label_set_justify(self, value)
        }

    /**
     * Fetches the text from a label widget including any embedded
     * underlines indicating mnemonics and Pango markup. (See
     * gtk_label_get_text()).
     *
     * Sets the text of the label. The label is interpreted as
     * including embedded underlines and/or Pango markup depending
     * on the values of the #GtkLabel:use-underline and
     * #GtkLabel:use-markup properties. */
    var label: String
        get() = gtk_label_get_label(self)?.toKString() ?: ""
        set(value) {
            gtk_label_set_label(self, value)
        }

    /**
     * Returns whether lines in the label are automatically wrapped.
     * See gtk_label_set_line_wrap().
     *
     * Toggles line wrapping within the #GtkLabel widget. %TRUE makes it break
     * lines if text exceeds the widget’s size. %FALSE lets the text get cut off
     * by the edge of the widget if it exceeds the widget size.
     *
     * Note that setting line wrapping to %TRUE does not make the label
     * wrap at its parent container’s width, because GTK+ widgets
     * conceptually can’t make their requisition depend on the parent
     * container’s size. For a label that wraps at a specific position,
     * set the label’s width using gtk_widget_set_size_request(). */
    var lineWrap: Boolean
        get() = gtk_label_get_line_wrap(self) != 0
        set(value) {
            gtk_label_set_line_wrap(self, if (value) gtk_true() else gtk_false())
        }

    /**
     * Gets the number of lines to which an ellipsized, wrapping
     * label should be limited. See gtk_label_set_lines().
     *
     * Sets the number of lines to which an ellipsized, wrapping label
     * should be limited. This has no effect if the label is not wrapping
     * or ellipsized. Set this to -1 if you don’t want to limit the
     * number of lines. */
    var lines: Int
        get() = gtk_label_get_lines(self)
        set(value) {
            gtk_label_set_lines(self, value)
        }

    /**
     * Retrieves the desired maximum width of @label, in characters. See
     * gtk_label_set_width_chars().
     *
     * Sets the desired maximum width in characters of @label to @n_chars. */
    var maxWidthChars: Int
        get() = gtk_label_get_max_width_chars(self)
        set(value) {
            gtk_label_set_max_width_chars(self, value)
        }

    val mnemonicKeyval: UInt
        get() = gtk_label_get_mnemonic_keyval(self)

    /**
     * Retrieves the target of the mnemonic (keyboard shortcut) of this
     * label. See gtk_label_set_mnemonic_widget().
     *
     * If the label has been set so that it has an mnemonic key (using
     * i.e. gtk_label_set_markup_with_mnemonic(),
     * gtk_label_set_text_with_mnemonic(), gtk_label_new_with_mnemonic()
     * or the “use_underline” property) the label can be associated with a
     * widget that is the target of the mnemonic. When the label is inside
     * a widget (like a #GtkButton or a #GtkNotebook tab) it is
     * automatically associated with the correct widget, but sometimes
     * (i.e. when the target is a #GtkEntry next to the label) you need to
     * set it explicitly using this function.
     *
     * The target widget will be accelerated by emitting the
     * GtkWidget::mnemonic-activate signal on it. The default handler for
     * this signal will activate the widget if there are no mnemonic collisions
     * and toggle focus between the colliding widgets otherwise. */
    var mnemonicWidget: CPointer<GtkWidget>
        get() = gtk_label_get_mnemonic_widget(self)!!.reinterpret()
        set(value) {
            gtk_label_set_mnemonic_widget(self, value?.reinterpret())
        }

    /**
     * Gets the value set by gtk_label_set_selectable().
     *
     * Selectable labels allow the user to select text from the label, for
     * copy-and-paste. */
    var selectable: Boolean
        get() = gtk_label_get_selectable(self) != 0
        set(value) {
            gtk_label_set_selectable(self, if (value) gtk_true() else gtk_false())
        }

    /**
     * Returns whether the label is in single line mode.
     *
     * Sets whether the label is in single line mode. */
    var singleLineMode: Boolean
        get() = gtk_label_get_single_line_mode(self) != 0
        set(value) {
            gtk_label_set_single_line_mode(self, if (value) gtk_true() else gtk_false())
        }

    /**
     * Fetches the text from a label widget, as displayed on the
     * screen. This does not include any embedded underlines
     * indicating mnemonics or Pango markup. (See gtk_label_get_label())
     *
     * Sets the text within the #GtkLabel widget. It overwrites any text that
     * was there before.
     *
     * This function will clear any previously set mnemonic accelerators, and
     * set the #GtkLabel:use-underline property to %FALSE as a side effect.
     *
     * This function will set the #GtkLabel:use-markup property to %FALSE
     * as a side effect.
     *
     * See also: gtk_label_set_markup() */
    var text: String
        get() = gtk_label_get_text(self)?.toKString() ?: ""
        set(value) {
            gtk_label_set_text(self, value)
        }

    /**
     * Returns whether the label is currently keeping track
     * of clicked links.
     *
     * Sets whether the label should keep track of clicked
     * links (and use a different color for them). */
    var trackVisitedLinks: Boolean
        get() = gtk_label_get_track_visited_links(self) != 0
        set(value) {
            gtk_label_set_track_visited_links(self, if (value) gtk_true() else gtk_false())
        }

    /**
     * Returns whether the label’s text is interpreted as marked up with
     * the [Pango text markup language][PangoMarkupFormat].
     * See gtk_label_set_use_markup ().
     *
     * Sets whether the text of the label contains markup in
     * [Pango’s text markup language][PangoMarkupFormat].
     * See gtk_label_set_markup(). */
    var useMarkup: Boolean
        get() = gtk_label_get_use_markup(self) != 0
        set(value) {
            gtk_label_set_use_markup(self, if (value) gtk_true() else gtk_false())
        }

    /**
     * Returns whether an embedded underline in the label indicates a
     * mnemonic. See gtk_label_set_use_underline().
     *
     * If true, an underline in the text indicates the next character should be
     * used for the mnemonic accelerator key. */
    var useUnderline: Boolean
        get() = gtk_label_get_use_underline(self) != 0
        set(value) {
            gtk_label_set_use_underline(self, if (value) gtk_true() else gtk_false())
        }

    /**
     * Retrieves the desired width of @label, in characters. See
     * gtk_label_set_width_chars().
     *
     * Sets the desired width in characters of @label to @n_chars. */
    var widthChars: Int
        get() = gtk_label_get_width_chars(self)
        set(value) {
            gtk_label_set_width_chars(self, value)
        }

    /**
     * Gets the #GtkLabel:xalign property for @label.
     *
     * Sets the #GtkLabel:xalign property for @label. */
    var xalign: Float
        get() = gtk_label_get_xalign(self)
        set(value) {
            gtk_label_set_xalign(self, value)
        }

    /**
     * Gets the #GtkLabel:yalign property for @label.
     *
     * Sets the #GtkLabel:yalign property for @label. */
    var yalign: Float
        get() = gtk_label_get_yalign(self)
        set(value) {
            gtk_label_set_yalign(self, value)
        }

    /**
     * Creates a new label with the given text inside it. You can
     * pass %NULL to get an empty label widget. */
    constructor(str: String) : this(gtk_label_new(str)?.reinterpret())

    /**
     * Selects a range of characters in the label, if the label is selectable.
     * See gtk_label_set_selectable(). If the label is not selectable,
     * this function has no effect. If @start_offset or
     * @end_offset are -1, then the end of the label will be substituted.
     */
    fun selectRegion(start_offset: Int, end_offset: Int): Unit = gtk_label_select_region(self,
            start_offset, end_offset)

    /**
     * Parses @str which is marked up with the
     * [Pango text markup language][PangoMarkupFormat], setting the
     * label’s text and attribute list based on the parse results.
     *
     * If the @str is external data, you may need to escape it with
     * g_markup_escape_text() or g_markup_printf_escaped():
     *
     * |[<!-- language="C" -->
     * GtkWidget *label = gtk_label_new (NULL);
     * const char *str = "some text";
     * const char *format = "<span style=\"italic\">\%s</span>";
     * char *markup;
     *
     * markup = g_markup_printf_escaped (format, str);
     * gtk_label_set_markup (GTK_LABEL (label), markup);
     * g_free (markup);
     * ]|
     *
     * This function will set the #GtkLabel:use-markup property to %TRUE as
     * a side effect.
     *
     * If you set the label contents using the #GtkLabel:label property you
     * should also ensure that you set the #GtkLabel:use-markup property
     * accordingly.
     *
     * See also: gtk_label_set_text()
     */
    fun setMarkup(str: String): Unit = gtk_label_set_markup(self, str)

    /**
     * Parses @str which is marked up with the
     * [Pango text markup language][PangoMarkupFormat],
     * setting the label’s text and attribute list based on the parse results.
     * If characters in @str are preceded by an underscore, they are underlined
     * indicating that they represent a keyboard accelerator called a mnemonic.
     *
     * The mnemonic key can be used to activate another widget, chosen
     * automatically, or explicitly using gtk_label_set_mnemonic_widget().
     */
    fun setMarkupWithMnemonic(str: String): Unit = gtk_label_set_markup_with_mnemonic(self, str)

    /**
     * The pattern of underlines you want under the existing text within the
     * #GtkLabel widget.  For example if the current text of the label says
     * “FooBarBaz” passing a pattern of “___   ___” will underline
     * “Foo” and “Baz” but not “Bar”.
     */
    fun setPattern(pattern: String): Unit = gtk_label_set_pattern(self, pattern)

    /**
     * Sets the label’s text from the string @str.
     * If characters in @str are preceded by an underscore, they are underlined
     * indicating that they represent a keyboard accelerator called a mnemonic.
     * The mnemonic key can be used to activate another widget, chosen
     * automatically, or explicitly using gtk_label_set_mnemonic_widget().
     */
    fun setTextWithMnemonic(str: String): Unit = gtk_label_set_text_with_mnemonic(self, str)
}

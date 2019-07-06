package gtk3

import kotlin.Boolean
import kotlin.Int
import kotlin.Unit
import kotlinx.cinterop.CPointer
import kotlinx.cinterop.reinterpret
import libgtk3.GdkDragAction
import libgtk3.GtkDestDefaults
import libgtk3.GtkIconSize
import libgtk3.GtkSelectionData
import libgtk3.GtkToolItem
import libgtk3.GtkToolItemGroup
import libgtk3.GtkToolPalette
import libgtk3.GtkToolPaletteDragTargets
import libgtk3.GtkToolbarStyle
import libgtk3.GtkWidget
import libgtk3.gtk_false
import libgtk3.gtk_tool_palette_add_drag_dest
import libgtk3.gtk_tool_palette_get_drag_item
import libgtk3.gtk_tool_palette_get_drop_group
import libgtk3.gtk_tool_palette_get_drop_item
import libgtk3.gtk_tool_palette_get_exclusive
import libgtk3.gtk_tool_palette_get_expand
import libgtk3.gtk_tool_palette_get_group_position
import libgtk3.gtk_tool_palette_get_icon_size
import libgtk3.gtk_tool_palette_get_style
import libgtk3.gtk_tool_palette_new
import libgtk3.gtk_tool_palette_set_drag_source
import libgtk3.gtk_tool_palette_set_exclusive
import libgtk3.gtk_tool_palette_set_expand
import libgtk3.gtk_tool_palette_set_group_position
import libgtk3.gtk_tool_palette_set_icon_size
import libgtk3.gtk_tool_palette_set_style
import libgtk3.gtk_tool_palette_unset_icon_size
import libgtk3.gtk_tool_palette_unset_style
import libgtk3.gtk_true

inline fun Container.toolPalette(init: ToolPalette.() -> Unit = {}): ToolPalette =
        ToolPalette().apply { init(); this@toolPalette.add(this) }

/**
 * A #GtkToolPalette allows you to add #GtkToolItems to a palette-like
 * container with different categories and drag and drop support.
 *
 * A #GtkToolPalette is created with a call to gtk_tool_palette_new().
 *
 * #GtkToolItems cannot be added directly to a #GtkToolPalette -
 * instead they are added to a #GtkToolItemGroup which can than be added
 * to a #GtkToolPalette. To add a #GtkToolItemGroup to a #GtkToolPalette,
 * use gtk_container_add().
 *
 * |[<!-- language="C" -->
 * GtkWidget *palette, *group;
 * GtkToolItem *item;
 *
 * palette = gtk_tool_palette_new ();
 * group = gtk_tool_item_group_new (_("Test Category"));
 * gtk_container_add (GTK_CONTAINER (palette), group);
 *
 * item = gtk_tool_button_new (NULL, _("_Open"));
 * gtk_tool_button_set_icon_name (GTK_TOOL_BUTTON (item), "document-open");
 * gtk_tool_item_group_insert (GTK_TOOL_ITEM_GROUP (group), item, -1);
 * ]|
 *
 * The easiest way to use drag and drop with #GtkToolPalette is to call
 * gtk_tool_palette_add_drag_dest() with the desired drag source @palette
 * and the desired drag target @widget. Then gtk_tool_palette_get_drag_item()
 * can be used to get the dragged item in the #GtkWidget::drag-data-received
 * signal handler of the drag target.
 *
 * |[<!-- language="C" -->
 * static void
 * passive_canvas_drag_data_received (GtkWidget        *widget,
 *                                    GdkDragContext   *context,
 *                                    gint              x,
 *                                    gint              y,
 *                                    GtkSelectionData *selection,
 *                                    guint             info,
 *                                    guint             time,
 *                                    gpointer          data)
 * {
 *   GtkWidget *palette;
 *   GtkWidget *item;
 *
 *   // Get the dragged item
 *   palette = gtk_widget_get_ancestor (gtk_drag_get_source_widget (context),
 *                                      GTK_TYPE_TOOL_PALETTE);
 *   if (palette != NULL)
 *     item = gtk_tool_palette_get_drag_item (GTK_TOOL_PALETTE (palette),
 *                                            selection);
 *
 *   // Do something with item
 * }
 *
 * GtkWidget *target, palette;
 *
 * palette = gtk_tool_palette_new ();
 * target = gtk_drawing_area_new ();
 *
 * g_signal_connect (G_OBJECT (target), "drag-data-received",
 *                   G_CALLBACK (passive_canvas_drag_data_received), NULL);
 * gtk_tool_palette_add_drag_dest (GTK_TOOL_PALETTE (palette), target,
 *                                 GTK_DEST_DEFAULT_ALL,
 *                                 GTK_TOOL_PALETTE_DRAG_ITEMS,
 *                                 GDK_ACTION_COPY);
 * ]|
 *
 * # CSS nodes
 *
 * GtkToolPalette has a single CSS node named toolpalette.
 */
@GtkDsl
open class ToolPalette internal constructor(override val widgetPtr: CPointer<GtkWidget>? = null) :
        Container() {
    private val self: CPointer<GtkToolPalette>?
        get() = widgetPtr!!.reinterpret()

    val toolPalette: CPointer<GtkToolPalette>?
        get() = widgetPtr!!.reinterpret()

    /**
     * Gets the size of icons in the tool palette.
     * See gtk_tool_palette_set_icon_size().
     *
     * Sets the size of icons in the tool palette. */
    var iconSize: GtkIconSize
        get() = gtk_tool_palette_get_icon_size(self)
        set(value) {
            gtk_tool_palette_set_icon_size(self, value)
        }

    /**
     * Gets the style (icons, text or both) of items in the tool palette.
     *
     * Sets the style (text, icons or both) of items in the tool palette. */
    var style: GtkToolbarStyle
        get() = gtk_tool_palette_get_style(self)
        set(value) {
            gtk_tool_palette_set_style(self, value)
        }

    /**
     * Creates a new tool palette. */
    constructor() : this(gtk_tool_palette_new()?.reinterpret())

    /**
     * Sets @palette as drag source (see gtk_tool_palette_set_drag_source())
     * and sets @widget as a drag destination for drags from @palette.
     * See gtk_drag_dest_set().
     */
    fun addDragDest(
        widget: CPointer<GtkWidget>,
        flags: GtkDestDefaults,
        targets: GtkToolPaletteDragTargets,
        actions: GdkDragAction
    ): Unit = gtk_tool_palette_add_drag_dest(self, widget, flags, targets, actions)

    /**
     * Get the dragged item from the selection.
     * This could be a #GtkToolItem or a #GtkToolItemGroup.
     */
    fun getDragItem(selection: CPointer<GtkSelectionData>): CPointer<GtkWidget> =
            gtk_tool_palette_get_drag_item(self, selection)!!.reinterpret()

    /**
     * Gets the group at position (x, y).
     */
    fun getDropGroup(x: Int, y: Int): CPointer<GtkToolItemGroup> =
            gtk_tool_palette_get_drop_group(self, x, y)!!.reinterpret()

    /**
     * Gets the item at position (x, y).
     * See gtk_tool_palette_get_drop_group().
     */
    fun getDropItem(x: Int, y: Int): CPointer<GtkToolItem> = gtk_tool_palette_get_drop_item(self, x,
            y)!!.reinterpret()

    /**
     * Gets whether @group is exclusive or not.
     * See gtk_tool_palette_set_exclusive().
     */
    fun getExclusive(group: CPointer<GtkToolItemGroup>): Boolean =
            gtk_tool_palette_get_exclusive(self, group) != 0

    /**
     * Gets whether @group is exclusive or not.
     * See gtk_tool_palette_set_exclusive().
     */
    fun getExclusive(group: ToolItemGroup): Boolean = gtk_tool_palette_get_exclusive(self,
            group.widgetPtr?.reinterpret()) != 0

    /**
     * Gets whether group should be given extra space.
     * See gtk_tool_palette_set_expand().
     */
    fun getExpand(group: CPointer<GtkToolItemGroup>): Boolean = gtk_tool_palette_get_expand(self,
            group) != 0

    /**
     * Gets whether group should be given extra space.
     * See gtk_tool_palette_set_expand().
     */
    fun getExpand(group: ToolItemGroup): Boolean = gtk_tool_palette_get_expand(self,
            group.widgetPtr?.reinterpret()) != 0

    /**
     * Gets the position of @group in @palette as index.
     * See gtk_tool_palette_set_group_position().
     */
    fun getGroupPosition(group: CPointer<GtkToolItemGroup>): Int =
            gtk_tool_palette_get_group_position(self, group)

    /**
     * Gets the position of @group in @palette as index.
     * See gtk_tool_palette_set_group_position().
     */
    fun getGroupPosition(group: ToolItemGroup): Int = gtk_tool_palette_get_group_position(self,
            group.widgetPtr?.reinterpret())

    /**
     * Sets whether the group should be exclusive or not.
     * If an exclusive group is expanded all other groups are collapsed.
     */
    fun setExclusive(group: CPointer<GtkToolItemGroup>, exclusive: Boolean): Unit =
            gtk_tool_palette_set_exclusive(self, group, if (exclusive) gtk_true() else gtk_false())

    /**
     * Sets whether the group should be exclusive or not.
     * If an exclusive group is expanded all other groups are collapsed.
     */
    fun setExclusive(group: ToolItemGroup, exclusive: Boolean): Unit =
            gtk_tool_palette_set_exclusive(self, group.widgetPtr?.reinterpret(),
            if (exclusive) gtk_true() else gtk_false())

    /**
     * Sets whether the group should be given extra space.
     */
    fun setExpand(group: CPointer<GtkToolItemGroup>, expand: Boolean): Unit =
            gtk_tool_palette_set_expand(self, group, if (expand) gtk_true() else gtk_false())

    /**
     * Sets whether the group should be given extra space.
     */
    fun setExpand(group: ToolItemGroup, expand: Boolean): Unit = gtk_tool_palette_set_expand(self,
            group.widgetPtr?.reinterpret(), if (expand) gtk_true() else gtk_false())

    /**
     * Sets the position of the group as an index of the tool palette.
     * If position is 0 the group will become the first child, if position is
     * -1 it will become the last child.
     */
    fun setGroupPosition(group: CPointer<GtkToolItemGroup>, position: Int): Unit =
            gtk_tool_palette_set_group_position(self, group, position)

    /**
     * Sets the position of the group as an index of the tool palette.
     * If position is 0 the group will become the first child, if position is
     * -1 it will become the last child.
     */
    fun setGroupPosition(group: ToolItemGroup, position: Int): Unit =
            gtk_tool_palette_set_group_position(self, group.widgetPtr?.reinterpret(), position)

    /**
     * Unsets the tool palette icon size set with gtk_tool_palette_set_icon_size(),
     * so that user preferences will be used to determine the icon size.
     */
    fun unsetIconSize(): Unit = gtk_tool_palette_unset_icon_size(self)

    /**
     * Unsets a toolbar style set with gtk_tool_palette_set_style(),
     * so that user preferences will be used to determine the toolbar style.
     */
    fun unsetStyle(): Unit = gtk_tool_palette_unset_style(self)

    /**
     * Sets the tool palette as a drag source.
     * Enables all groups and items in the tool palette as drag sources
     * on button 1 and button 3 press with copy and move actions.
     * See gtk_drag_source_set().
     */
    fun setDragSource(targets: GtkToolPaletteDragTargets): Unit =
            gtk_tool_palette_set_drag_source(self, targets)
}

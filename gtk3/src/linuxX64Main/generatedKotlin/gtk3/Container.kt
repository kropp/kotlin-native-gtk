package gtk3

import kotlin.String
import kotlin.UInt
import kotlin.Unit
import kotlinx.cinterop.CFunction
import kotlinx.cinterop.COpaquePointer
import kotlinx.cinterop.CPointed
import kotlinx.cinterop.CPointer
import kotlinx.cinterop.asStableRef
import kotlinx.cinterop.reinterpret
import kotlinx.cinterop.staticCFunction
import libgtk3.GList
import libgtk3.GtkAdjustment
import libgtk3.GtkContainer
import libgtk3.GtkWidget
import libgtk3.GtkWidgetPath
import libgtk3.gtk_container_add
import libgtk3.gtk_container_add_with_properties
import libgtk3.gtk_container_check_resize
import libgtk3.gtk_container_child_get
import libgtk3.gtk_container_child_notify
import libgtk3.gtk_container_child_set
import libgtk3.gtk_container_get_border_width
import libgtk3.gtk_container_get_children
import libgtk3.gtk_container_get_focus_child
import libgtk3.gtk_container_get_focus_hadjustment
import libgtk3.gtk_container_get_focus_vadjustment
import libgtk3.gtk_container_get_path_for_child
import libgtk3.gtk_container_remove
import libgtk3.gtk_container_set_border_width
import libgtk3.gtk_container_set_focus_child
import libgtk3.gtk_container_set_focus_hadjustment
import libgtk3.gtk_container_set_focus_vadjustment

private fun Container_onAdd_Handler(
    sender: CPointer<in CPointed>?,
    `object`: CPointer<GtkWidget>,
    _data: COpaquePointer?
) {
    _data?.asStableRef<Container>()?.get()?.onAdd?.emit(`object`?.reinterpret())
}

private fun Container_onCheckResize_Handler(sender: CPointer<in CPointed>?, _data: COpaquePointer?)
        {
    _data?.asStableRef<Container>()?.get()?.onCheckResize?.emit()
}

private fun Container_onRemove_Handler(
    sender: CPointer<in CPointed>?,
    `object`: CPointer<GtkWidget>,
    _data: COpaquePointer?
) {
    _data?.asStableRef<Container>()?.get()?.onRemove?.emit(`object`?.reinterpret())
}

private fun Container_onSetFocusChild_Handler(
    sender: CPointer<in CPointed>?,
    `object`: CPointer<GtkWidget>,
    _data: COpaquePointer?
) {
    _data?.asStableRef<Container>()?.get()?.onSetFocusChild?.emit(`object`?.reinterpret())
}

/**
 * A GTK+ user interface is constructed by nesting widgets inside widgets.
 * Container widgets are the inner nodes in the resulting tree of widgets:
 * they contain other widgets. So, for example, you might have a #GtkWindow
 * containing a #GtkFrame containing a #GtkLabel. If you wanted an image instead
 * of a textual label inside the frame, you might replace the #GtkLabel widget
 * with a #GtkImage widget.
 *
 * There are two major kinds of container widgets in GTK+. Both are subclasses
 * of the abstract GtkContainer base class.
 *
 * The first type of container widget has a single child widget and derives
 * from #GtkBin. These containers are decorators, which
 * add some kind of functionality to the child. For example, a #GtkButton makes
 * its child into a clickable button; a #GtkFrame draws a frame around its child
 * and a #GtkWindow places its child widget inside a top-level window.
 *
 * The second type of container can have more than one child; its purpose is to
 * manage layout. This means that these containers assign
 * sizes and positions to their children. For example, a #GtkHBox arranges its
 * children in a horizontal row, and a #GtkGrid arranges the widgets it contains
 * in a two-dimensional grid.
 *
 * For implementations of #GtkContainer the virtual method #GtkContainerClass.forall()
 * is always required, since it's used for drawing and other internal operations
 * on the children.
 * If the #GtkContainer implementation expect to have non internal children
 * it's needed to implement both #GtkContainerClass.add() and #GtkContainerClass.remove().
 * If the GtkContainer implementation has internal children, they should be added
 * with gtk_widget_set_parent() on init() and removed with gtk_widget_unparent()
 * in the #GtkWidgetClass.destroy() implementation.
 * See more about implementing custom widgets at https://wiki.gnome.org/HowDoI/CustomWidgets
 *
 * # Height for width geometry management
 *
 * GTK+ uses a height-for-width (and width-for-height) geometry management system.
 * Height-for-width means that a widget can change how much vertical space it needs,
 * depending on the amount of horizontal space that it is given (and similar for
 * width-for-height).
 *
 * There are some things to keep in mind when implementing container widgets
 * that make use of GTK+’s height for width geometry management system. First,
 * it’s important to note that a container must prioritize one of its
 * dimensions, that is to say that a widget or container can only have a
 * #GtkSizeRequestMode that is %GTK_SIZE_REQUEST_HEIGHT_FOR_WIDTH or
 * %GTK_SIZE_REQUEST_WIDTH_FOR_HEIGHT. However, every widget and container
 * must be able to respond to the APIs for both dimensions, i.e. even if a
 * widget has a request mode that is height-for-width, it is possible that
 * its parent will request its sizes using the width-for-height APIs.
 *
 * To ensure that everything works properly, here are some guidelines to follow
 * when implementing height-for-width (or width-for-height) containers.
 *
 * Each request mode involves 2 virtual methods. Height-for-width apis run
 * through gtk_widget_get_preferred_width() and then through
        gtk_widget_get_preferred_height_for_width().
 * When handling requests in the opposite #GtkSizeRequestMode it is important that
 * every widget request at least enough space to display all of its content at all times.
 *
 * When gtk_widget_get_preferred_height() is called on a container that is height-for-width,
 * the container must return the height for its minimum width. This is easily achieved by
 * simply calling the reverse apis implemented for itself as follows:
 *
 * |[<!-- language="C" -->
 * static void
 * foo_container_get_preferred_height (GtkWidget *widget,
 *                                     gint *min_height,
 *                                     gint *nat_height)
 * {
 *    if (i_am_in_height_for_width_mode)
 *      {
 *        gint min_width;
 *
 *        GTK_WIDGET_GET_CLASS (widget)->get_preferred_width (widget,
 *                                                            &min_width,
 *                                                            NULL);
 *        GTK_WIDGET_GET_CLASS (widget)->get_preferred_height_for_width
 *                                                           (widget,
 *                                                            min_width,
 *                                                            min_height,
 *                                                            nat_height);
 *      }
 *    else
 *      {
 *        ... many containers support both request modes, execute the
 *        real width-for-height request here by returning the
 *        collective heights of all widgets that are stacked
 *        vertically (or whatever is appropriate for this container)
 *        ...
 *      }
 * }
 * ]|
 *
 * Similarly, when gtk_widget_get_preferred_width_for_height() is called for a container or widget
 * that is height-for-width, it then only needs to return the base minimum width like so:
 *
 * |[<!-- language="C" -->
 * static void
 * foo_container_get_preferred_width_for_height (GtkWidget *widget,
 *                                               gint for_height,
 *                                               gint *min_width,
 *                                               gint *nat_width)
 * {
 *    if (i_am_in_height_for_width_mode)
 *      {
 *        GTK_WIDGET_GET_CLASS (widget)->get_preferred_width (widget,
 *                                                            min_width,
 *                                                            nat_width);
 *      }
 *    else
 *      {
 *        ... execute the real width-for-height request here based on
 *        the required width of the children collectively if the
 *        container were to be allocated the said height ...
 *      }
 * }
 * ]|
 *
 * Height for width requests are generally implemented in terms of a virtual allocation
 * of widgets in the input orientation. Assuming an height-for-width request mode, a container
 * would implement the get_preferred_height_for_width() virtual function by first calling
 * gtk_widget_get_preferred_width() for each of its children.
 *
 * For each potential group of children that are lined up horizontally, the values returned by
 * gtk_widget_get_preferred_width() should be collected in an array of #GtkRequestedSize structures.
 * Any child spacing should be removed from the input @for_width and then the collective size should
        be
 * allocated using the gtk_distribute_natural_allocation() convenience function.
 *
 * The container will then move on to request the preferred height for each child by using
 * gtk_widget_get_preferred_height_for_width() and using the sizes stored in the #GtkRequestedSize
        array.
 *
 * To allocate a height-for-width container, it’s again important
 * to consider that a container must prioritize one dimension over the other. So if
 * a container is a height-for-width container it must first allocate all widgets horizontally
 * using a #GtkRequestedSize array and gtk_distribute_natural_allocation() and then add any
 * extra space (if and where appropriate) for the widget to expand.
 *
 * After adding all the expand space, the container assumes it was allocated sufficient
 * height to fit all of its content. At this time, the container must use the total horizontal sizes
 * of each widget to request the height-for-width of each of its children and store the requests in
        a
 * #GtkRequestedSize array for any widgets that stack vertically (for tabular containers this can
 * be generalized into the heights and widths of rows and columns).
 * The vertical space must then again be distributed using gtk_distribute_natural_allocation()
 * while this time considering the allocated height of the widget minus any vertical spacing
 * that the container adds. Then vertical expand space should be added where appropriate and
        available
 * and the container should go on to actually allocating the child widgets.
 *
 * See [GtkWidget’s geometry management section][geometry-management]
 * to learn more about implementing height-for-width geometry management for widgets.
 *
 * # Child properties
 *
 * GtkContainer introduces child properties.
 * These are object properties that are not specific
 * to either the container or the contained widget, but rather to their relation.
 * Typical examples of child properties are the position or pack-type of a widget
 * which is contained in a #GtkBox.
 *
 * Use gtk_container_class_install_child_property() to install child properties
 * for a container class and gtk_container_class_find_child_property() or
 * gtk_container_class_list_child_properties() to get information about existing
 * child properties.
 *
 * To set the value of a child property, use gtk_container_child_set_property(),
 * gtk_container_child_set() or gtk_container_child_set_valist().
 * To obtain the value of a child property, use
 * gtk_container_child_get_property(), gtk_container_child_get() or
 * gtk_container_child_get_valist(). To emit notification about child property
 * changes, use gtk_widget_child_notify().
 *
 * # GtkContainer as GtkBuildable
 *
 * The GtkContainer implementation of the GtkBuildable interface supports
 * a <packing> element for children, which can contain multiple <property>
 * elements that specify child properties for the child.
 *
 * Since 2.16, child properties can also be marked as translatable using
 * the same “translatable”, “comments” and “context” attributes that are used
 * for regular properties.
 *
 * Since 3.16, containers can have a <focus-chain> element containing multiple
 * <widget> elements, one for each child that should be added to the focus
 * chain. The ”name” attribute gives the id of the widget.
 *
 * An example of these properties in UI definitions:
 * |[
 * <object class="GtkBox">
 *   <child>
 *     <object class="GtkEntry" id="entry1"/>
 *     <packing>
 *       <property name="pack-type">start</property>
 *     </packing>
 *   </child>
 *   <child>
 *     <object class="GtkEntry" id="entry2"/>
 *   </child>
 *   <focus-chain>
 *     <widget name="entry1"/>
 *     <widget name="entry2"/>
 *   </focus-chain>
 * </object>
 * ]|Returns the container’s non-internal children. See
 * gtk_container_forall() for details on what constitutes an "internal" child. */
@GtkDsl
abstract class Container : Widget() {
    private val self: CPointer<GtkContainer>
        get() = widgetPtr!!.reinterpret()

    val onAdd: Signal1<Container, CPointer<GtkWidget>, CFunction<(
        CPointer<in CPointed>?,
        CPointer<GtkWidget>,
        COpaquePointer?
    ) -> Unit>> by lazy { Signal1<Container, CPointer<GtkWidget>, CFunction<(
                CPointer<in CPointed>?,
                CPointer<GtkWidget>,
                COpaquePointer?
            ) -> Unit>>(widgetPtr!!, this, "add", staticCFunction(::Container_onAdd_Handler)) }

    val onCheckResize: Signal<Container, CFunction<(CPointer<in CPointed>?, COpaquePointer?) ->
            Unit>> by lazy { Signal<Container, CFunction<(CPointer<in CPointed>?,
            COpaquePointer?) -> Unit>>(widgetPtr!!, this, "check-resize",
            staticCFunction(::Container_onCheckResize_Handler)) }

    val onRemove: Signal1<Container, CPointer<GtkWidget>, CFunction<(
        CPointer<in CPointed>?,
        CPointer<GtkWidget>,
        COpaquePointer?
    ) -> Unit>> by lazy { Signal1<Container, CPointer<GtkWidget>, CFunction<(
                CPointer<in CPointed>?,
                CPointer<GtkWidget>,
                COpaquePointer?
            ) -> Unit>>(widgetPtr!!, this, "remove", staticCFunction(::Container_onRemove_Handler))
                    }

    val onSetFocusChild: Signal1<Container, CPointer<GtkWidget>, CFunction<(
        CPointer<in CPointed>?,
        CPointer<GtkWidget>,
        COpaquePointer?
    ) -> Unit>> by lazy { Signal1<Container, CPointer<GtkWidget>, CFunction<(
                CPointer<in CPointed>?,
                CPointer<GtkWidget>,
                COpaquePointer?
            ) -> Unit>>(widgetPtr!!, this, "set-focus-child",
                    staticCFunction(::Container_onSetFocusChild_Handler)) }

    /**
     * Retrieves the border width of the container. See
     * gtk_container_set_border_width().
     *
     * Sets the border width of the container.
     *
     * The border width of a container is the amount of space to leave
     * around the outside of the container. The only exception to this is
     * #GtkWindow; because toplevel windows can’t leave space outside,
     * they leave the space inside. The border is added on all sides of
     * the container. To add space to only one side, use a specific
     * #GtkWidget:margin property on the child widget, for example
     * #GtkWidget:margin-top. */
    var borderWidth: UInt
        get() = gtk_container_get_border_width(self)
        set(value) {
            gtk_container_set_border_width(self, value)
        }

    val children: CPointer<GList>
        get() = gtk_container_get_children(self)!!.reinterpret()

    /**
     * Returns the current focus child widget inside @container. This is not the
     * currently focused widget. That can be obtained by calling
     * gtk_window_get_focus().
     *
     * Sets, or unsets if @child is %NULL, the focused child of @container.
     *
     * This function emits the GtkContainer::set_focus_child signal of
     * @container. Implementations of #GtkContainer can override the
     * default behaviour by overriding the class closure of this signal.
     *
     * This is function is mostly meant to be used by widgets. Applications can use
     * gtk_widget_grab_focus() to manually set the focus to a specific widget. */
    var focusChild: CPointer<GtkWidget>
        get() = gtk_container_get_focus_child(self)!!.reinterpret()
        set(value) {
            gtk_container_set_focus_child(self, value?.reinterpret())
        }

    /**
     * Retrieves the horizontal focus adjustment for the container. See
     * gtk_container_set_focus_hadjustment ().
     *
     * Hooks up an adjustment to focus handling in a container, so when a child
     * of the container is focused, the adjustment is scrolled to show that
     * widget. This function sets the horizontal alignment.
     * See gtk_scrolled_window_get_hadjustment() for a typical way of obtaining
     * the adjustment and gtk_container_set_focus_vadjustment() for setting
     * the vertical adjustment.
     *
     * The adjustments have to be in pixel units and in the same coordinate
     * system as the allocation for immediate children of the container. */
    var focusHadjustment: CPointer<GtkAdjustment>
        get() = gtk_container_get_focus_hadjustment(self)!!.reinterpret()
        set(value) {
            gtk_container_set_focus_hadjustment(self, value?.reinterpret())
        }

    /**
     * Retrieves the vertical focus adjustment for the container. See
     * gtk_container_set_focus_vadjustment().
     *
     * Hooks up an adjustment to focus handling in a container, so when a
     * child of the container is focused, the adjustment is scrolled to
     * show that widget. This function sets the vertical alignment. See
     * gtk_scrolled_window_get_vadjustment() for a typical way of obtaining
     * the adjustment and gtk_container_set_focus_hadjustment() for setting
     * the horizontal adjustment.
     *
     * The adjustments have to be in pixel units and in the same coordinate
     * system as the allocation for immediate children of the container. */
    var focusVadjustment: CPointer<GtkAdjustment>
        get() = gtk_container_get_focus_vadjustment(self)!!.reinterpret()
        set(value) {
            gtk_container_set_focus_vadjustment(self, value?.reinterpret())
        }

    /**
     * Adds @widget to @container. Typically used for simple containers
     * such as #GtkWindow, #GtkFrame, or #GtkButton; for more complicated
     * layout containers such as #GtkBox or #GtkGrid, this function will
     * pick default packing parameters that may not be correct.  So
     * consider functions such as gtk_box_pack_start() and
     * gtk_grid_attach() as an alternative to gtk_container_add() in
     * those cases. A widget may be added to only one container at a time;
     * you can’t place the same widget inside two different containers.
     *
     * Note that some containers, such as #GtkScrolledWindow or #GtkListBox,
     * may add intermediate children between the added widget and the
     * container.
     */
    fun add(widget: CPointer<GtkWidget>): Unit = gtk_container_add(self, widget)

    /**
     * Adds @widget to @container. Typically used for simple containers
     * such as #GtkWindow, #GtkFrame, or #GtkButton; for more complicated
     * layout containers such as #GtkBox or #GtkGrid, this function will
     * pick default packing parameters that may not be correct.  So
     * consider functions such as gtk_box_pack_start() and
     * gtk_grid_attach() as an alternative to gtk_container_add() in
     * those cases. A widget may be added to only one container at a time;
     * you can’t place the same widget inside two different containers.
     *
     * Note that some containers, such as #GtkScrolledWindow or #GtkListBox,
     * may add intermediate children between the added widget and the
     * container.
     */
    fun add(widget: Widget): Unit = gtk_container_add(self, widget.widgetPtr?.reinterpret())

    /**
     * Adds @widget to @container, setting child properties at the same time.
     * See gtk_container_add() and gtk_container_child_set() for more details.
     */
    fun addWithProperties(widget: CPointer<GtkWidget>, first_prop_name: String): Unit =
            gtk_container_add_with_properties(self, widget, first_prop_name)

    /**
     * Adds @widget to @container, setting child properties at the same time.
     * See gtk_container_add() and gtk_container_child_set() for more details.
     */
    fun addWithProperties(widget: Widget, first_prop_name: String): Unit =
            gtk_container_add_with_properties(self, widget.widgetPtr?.reinterpret(),
            first_prop_name)

    fun checkResize(): Unit = gtk_container_check_resize(self)

    /**
     * Gets the values of one or more child properties for @child and @container.
     */
    fun childGet(child: CPointer<GtkWidget>, first_prop_name: String): Unit =
            gtk_container_child_get(self, child, first_prop_name)

    /**
     * Gets the values of one or more child properties for @child and @container.
     */
    fun childGet(child: Widget, first_prop_name: String): Unit = gtk_container_child_get(self,
            child.widgetPtr?.reinterpret(), first_prop_name)

    /**
     * Emits a #GtkWidget::child-notify signal for the
     * [child property][child-properties]
     * @child_property on the child.
     *
     * This is an analogue of g_object_notify() for child properties.
     *
     * Also see gtk_widget_child_notify().
     */
    fun childNotify(child: CPointer<GtkWidget>, child_property: String): Unit =
            gtk_container_child_notify(self, child, child_property)

    /**
     * Emits a #GtkWidget::child-notify signal for the
     * [child property][child-properties]
     * @child_property on the child.
     *
     * This is an analogue of g_object_notify() for child properties.
     *
     * Also see gtk_widget_child_notify().
     */
    fun childNotify(child: Widget, child_property: String): Unit = gtk_container_child_notify(self,
            child.widgetPtr?.reinterpret(), child_property)

    /**
     * Sets one or more child properties for @child and @container.
     */
    fun childSet(child: CPointer<GtkWidget>, first_prop_name: String): Unit =
            gtk_container_child_set(self, child, first_prop_name)

    /**
     * Sets one or more child properties for @child and @container.
     */
    fun childSet(child: Widget, first_prop_name: String): Unit = gtk_container_child_set(self,
            child.widgetPtr?.reinterpret(), first_prop_name)

    /**
     * Returns a newly created widget path representing all the widget hierarchy
     * from the toplevel down to and including @child.
     */
    fun getPathForChild(child: CPointer<GtkWidget>): CPointer<GtkWidgetPath> =
            gtk_container_get_path_for_child(self, child)!!.reinterpret()

    /**
     * Returns a newly created widget path representing all the widget hierarchy
     * from the toplevel down to and including @child.
     */
    fun getPathForChild(child: Widget): CPointer<GtkWidgetPath> =
            gtk_container_get_path_for_child(self, child.widgetPtr?.reinterpret())!!.reinterpret()

    /**
     * Removes @widget from @container. @widget must be inside @container.
     * Note that @container will own a reference to @widget, and that this
     * may be the last reference held; so removing a widget from its
     * container can destroy that widget. If you want to use @widget
     * again, you need to add a reference to it before removing it from
     * a container, using g_object_ref(). If you don’t want to use @widget
     * again it’s usually more efficient to simply destroy it directly
     * using gtk_widget_destroy() since this will remove it from the
     * container and help break any circular reference count cycles.
     */
    fun remove(widget: CPointer<GtkWidget>): Unit = gtk_container_remove(self, widget)

    /**
     * Removes @widget from @container. @widget must be inside @container.
     * Note that @container will own a reference to @widget, and that this
     * may be the last reference held; so removing a widget from its
     * container can destroy that widget. If you want to use @widget
     * again, you need to add a reference to it before removing it from
     * a container, using g_object_ref(). If you don’t want to use @widget
     * again it’s usually more efficient to simply destroy it directly
     * using gtk_widget_destroy() since this will remove it from the
     * container and help break any circular reference count cycles.
     */
    fun remove(widget: Widget): Unit = gtk_container_remove(self, widget.widgetPtr?.reinterpret())
}

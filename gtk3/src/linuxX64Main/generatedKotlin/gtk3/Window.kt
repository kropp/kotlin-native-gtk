package gtk3

import kotlin.Boolean
import kotlin.Int
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
import kotlinx.cinterop.toKString
import libgtk3.GList
import libgtk3.GdkEventKey
import libgtk3.GdkGeometry
import libgtk3.GdkGravity
import libgtk3.GdkModifierType
import libgtk3.GdkPixbuf
import libgtk3.GdkScreen
import libgtk3.GdkWindowEdge
import libgtk3.GdkWindowHints
import libgtk3.GdkWindowTypeHint
import libgtk3.GtkAccelGroup
import libgtk3.GtkApplication
import libgtk3.GtkWidget
import libgtk3.GtkWindow
import libgtk3.GtkWindowGroup
import libgtk3.GtkWindowPosition
import libgtk3.GtkWindowType
import libgtk3.gtk_false
import libgtk3.gtk_true
import libgtk3.gtk_window_activate_default
import libgtk3.gtk_window_activate_focus
import libgtk3.gtk_window_activate_key
import libgtk3.gtk_window_add_accel_group
import libgtk3.gtk_window_add_mnemonic
import libgtk3.gtk_window_begin_move_drag
import libgtk3.gtk_window_begin_resize_drag
import libgtk3.gtk_window_close
import libgtk3.gtk_window_deiconify
import libgtk3.gtk_window_fullscreen
import libgtk3.gtk_window_fullscreen_on_monitor
import libgtk3.gtk_window_get_accept_focus
import libgtk3.gtk_window_get_application
import libgtk3.gtk_window_get_attached_to
import libgtk3.gtk_window_get_decorated
import libgtk3.gtk_window_get_default_widget
import libgtk3.gtk_window_get_deletable
import libgtk3.gtk_window_get_destroy_with_parent
import libgtk3.gtk_window_get_focus
import libgtk3.gtk_window_get_focus_on_map
import libgtk3.gtk_window_get_focus_visible
import libgtk3.gtk_window_get_gravity
import libgtk3.gtk_window_get_group
import libgtk3.gtk_window_get_hide_titlebar_when_maximized
import libgtk3.gtk_window_get_icon
import libgtk3.gtk_window_get_icon_list
import libgtk3.gtk_window_get_icon_name
import libgtk3.gtk_window_get_mnemonic_modifier
import libgtk3.gtk_window_get_mnemonics_visible
import libgtk3.gtk_window_get_modal
import libgtk3.gtk_window_get_resizable
import libgtk3.gtk_window_get_role
import libgtk3.gtk_window_get_skip_pager_hint
import libgtk3.gtk_window_get_skip_taskbar_hint
import libgtk3.gtk_window_get_title
import libgtk3.gtk_window_get_titlebar
import libgtk3.gtk_window_get_transient_for
import libgtk3.gtk_window_get_type_hint
import libgtk3.gtk_window_get_urgency_hint
import libgtk3.gtk_window_get_window_type
import libgtk3.gtk_window_has_group
import libgtk3.gtk_window_has_toplevel_focus
import libgtk3.gtk_window_iconify
import libgtk3.gtk_window_is_active
import libgtk3.gtk_window_is_maximized
import libgtk3.gtk_window_maximize
import libgtk3.gtk_window_mnemonic_activate
import libgtk3.gtk_window_move
import libgtk3.gtk_window_new
import libgtk3.gtk_window_present
import libgtk3.gtk_window_present_with_time
import libgtk3.gtk_window_propagate_key_event
import libgtk3.gtk_window_remove_accel_group
import libgtk3.gtk_window_remove_mnemonic
import libgtk3.gtk_window_resize
import libgtk3.gtk_window_set_accept_focus
import libgtk3.gtk_window_set_application
import libgtk3.gtk_window_set_attached_to
import libgtk3.gtk_window_set_decorated
import libgtk3.gtk_window_set_default
import libgtk3.gtk_window_set_default_size
import libgtk3.gtk_window_set_deletable
import libgtk3.gtk_window_set_destroy_with_parent
import libgtk3.gtk_window_set_focus
import libgtk3.gtk_window_set_focus_on_map
import libgtk3.gtk_window_set_focus_visible
import libgtk3.gtk_window_set_geometry_hints
import libgtk3.gtk_window_set_gravity
import libgtk3.gtk_window_set_has_user_ref_count
import libgtk3.gtk_window_set_hide_titlebar_when_maximized
import libgtk3.gtk_window_set_icon
import libgtk3.gtk_window_set_icon_list
import libgtk3.gtk_window_set_icon_name
import libgtk3.gtk_window_set_keep_above
import libgtk3.gtk_window_set_keep_below
import libgtk3.gtk_window_set_mnemonic_modifier
import libgtk3.gtk_window_set_mnemonics_visible
import libgtk3.gtk_window_set_modal
import libgtk3.gtk_window_set_position
import libgtk3.gtk_window_set_resizable
import libgtk3.gtk_window_set_role
import libgtk3.gtk_window_set_skip_pager_hint
import libgtk3.gtk_window_set_skip_taskbar_hint
import libgtk3.gtk_window_set_startup_id
import libgtk3.gtk_window_set_title
import libgtk3.gtk_window_set_titlebar
import libgtk3.gtk_window_set_transient_for
import libgtk3.gtk_window_set_type_hint
import libgtk3.gtk_window_set_urgency_hint
import libgtk3.gtk_window_stick
import libgtk3.gtk_window_unfullscreen
import libgtk3.gtk_window_unmaximize
import libgtk3.gtk_window_unstick

inline fun Container.window(type: GtkWindowType, init: Window.() -> Unit = {}): Window =
        Window(type).apply { init(); this@window.add(this) }

private fun Window_onActivateDefault_Handler(sender: CPointer<in CPointed>?, _data: COpaquePointer?)
        {
    _data?.asStableRef<Window>()?.get()?.onActivateDefault?.emit()
}

private fun Window_onActivateFocus_Handler(sender: CPointer<in CPointed>?, _data: COpaquePointer?) {
    _data?.asStableRef<Window>()?.get()?.onActivateFocus?.emit()
}

private fun Window_onEnableDebugging_Handler(
    sender: CPointer<in CPointed>?,
    toggle: Boolean,
    _data: COpaquePointer?
) {
    _data?.asStableRef<Window>()?.get()?.onEnableDebugging?.emit(toggle)
}

private fun Window_onKeysChanged_Handler(sender: CPointer<in CPointed>?, _data: COpaquePointer?) {
    _data?.asStableRef<Window>()?.get()?.onKeysChanged?.emit()
}

private fun Window_onSetFocus_Handler(
    sender: CPointer<in CPointed>?,
    `object`: CPointer<GtkWidget>,
    _data: COpaquePointer?
) {
    _data?.asStableRef<Window>()?.get()?.onSetFocus?.emit(`object`?.reinterpret())
}

/**
 * A GtkWindow is a toplevel window which can contain other widgets.
 * Windows normally have decorations that are under the control
 * of the windowing system and allow the user to manipulate the window
 * (resize it, move it, close it,...).
 *
 * # GtkWindow as GtkBuildable
 *
 * The GtkWindow implementation of the GtkBuildable interface supports a
 * custom <accel-groups> element, which supports any number of <group>
 * elements representing the #GtkAccelGroup objects you want to add to
 * your window (synonymous with gtk_window_add_accel_group().
 *
 * It also supports the <initial-focus> element, whose name property names
 * the widget to receive the focus when the window is mapped.
 *
 * An example of a UI definition fragment with accel groups:
 * |[
 * <object class="GtkWindow">
 *   <accel-groups>
 *     <group name="accelgroup1"/>
 *   </accel-groups>
 *   <initial-focus name="thunderclap"/>
 * </object>
 *
 * ...
 *
 * <object class="GtkAccelGroup" id="accelgroup1"/>
 * ]|
 *
 * The GtkWindow implementation of the GtkBuildable interface supports
 * setting a child as the titlebar by specifying “titlebar” as the “type”
 * attribute of a <child> element.
 *
 * # CSS nodes
 *
 * |[<!-- language="plain" -->
 * window.background
 * ├── decoration
 * ├── <titlebar child>.titlebar [.default-decoration]
 * ╰── <child>
 * ]|
 *
 * GtkWindow has a main CSS node with name window and style class .background,
 * and a subnode with name decoration.
 *
 * Style classes that are typically used with the main CSS node are .csd (when
 * client-side decorations are in use), .solid-csd (for client-side decorations
 * without invisible borders), .ssd (used by mutter when rendering server-side
 * decorations). GtkWindow also represents window states with the following
 * style classes on the main node: .tiled, .maximized, .fullscreen. Specialized
 * types of window often add their own discriminating style classes, such as
 * .popup or .tooltip.
 *
 * GtkWindow adds the .titlebar and .default-decoration style classes to the
 * widget that is added as a titlebar child.Returns the default widget for @window. See
 * gtk_window_set_default() for more details.Returns the group for @window or the default group, if
 * @window is %NULL or if @window does not have an explicit
 * window group.Gets the type of the window. See #GtkWindowType.
 */
@GtkDsl
open class Window internal constructor(override val widgetPtr: CPointer<GtkWidget>? = null) : Bin()
        {
    private val self: CPointer<GtkWindow>?
        get() = widgetPtr!!.reinterpret()

    val window: CPointer<GtkWindow>?
        get() = widgetPtr!!.reinterpret()

    val onActivateDefault: Signal<Window, CFunction<(CPointer<in CPointed>?, COpaquePointer?) ->
            Unit>> by lazy { Signal<Window, CFunction<(CPointer<in CPointed>?, COpaquePointer?) ->
            Unit>>(widgetPtr!!, this, "activate-default",
            staticCFunction(::Window_onActivateDefault_Handler)) }

    val onActivateFocus: Signal<Window, CFunction<(CPointer<in CPointed>?, COpaquePointer?) ->
            Unit>> by lazy { Signal<Window, CFunction<(CPointer<in CPointed>?, COpaquePointer?) ->
            Unit>>(widgetPtr!!, this, "activate-focus",
            staticCFunction(::Window_onActivateFocus_Handler)) }

    val onEnableDebugging: Signal1<Window, Boolean, CFunction<(
        CPointer<in CPointed>?,
        Boolean,
        COpaquePointer?
    ) -> Unit>> by lazy { Signal1<Window, Boolean, CFunction<(
                CPointer<in CPointed>?,
                Boolean,
                COpaquePointer?
            ) -> Unit>>(widgetPtr!!, this, "enable-debugging",
                    staticCFunction(::Window_onEnableDebugging_Handler)) }

    val onKeysChanged: Signal<Window, CFunction<(CPointer<in CPointed>?, COpaquePointer?) -> Unit>>
            by lazy { Signal<Window, CFunction<(CPointer<in CPointed>?, COpaquePointer?) ->
            Unit>>(widgetPtr!!, this, "keys-changed",
            staticCFunction(::Window_onKeysChanged_Handler)) }

    val onSetFocus: Signal1<Window, CPointer<GtkWidget>, CFunction<(
        CPointer<in CPointed>?,
        CPointer<GtkWidget>,
        COpaquePointer?
    ) -> Unit>> by lazy { Signal1<Window, CPointer<GtkWidget>, CFunction<(
                CPointer<in CPointed>?,
                CPointer<GtkWidget>,
                COpaquePointer?
            ) -> Unit>>(widgetPtr!!, this, "set-focus",
                    staticCFunction(::Window_onSetFocus_Handler)) }

    /**
     * Gets the value set by gtk_window_set_accept_focus().
     *
     * Windows may set a hint asking the desktop environment not to receive
     * the input focus. This function sets this hint. */
    var acceptFocus: Boolean
        get() = gtk_window_get_accept_focus(self) != 0
        set(value) {
            gtk_window_set_accept_focus(self, if (value) gtk_true() else gtk_false())
        }

    /**
     * Gets the #GtkApplication associated with the window (if any).
     *
     * Sets or unsets the #GtkApplication associated with the window.
     *
     * The application will be kept alive for at least as long as it has any windows
     * associated with it (see g_application_hold() for a way to keep it alive
     * without windows).
     *
     * Normally, the connection between the application and the window will remain
     * until the window is destroyed, but you can explicitly remove it by setting
     * the @application to %NULL.
     *
     * This is equivalent to calling gtk_application_remove_window() and/or
     * gtk_application_add_window() on the old/new applications as relevant. */
    var application: CPointer<GtkApplication>
        get() = gtk_window_get_application(self)!!.reinterpret()
        set(value) {
            gtk_window_set_application(self, value?.reinterpret())
        }

    /**
     * Fetches the attach widget for this window. See
     * gtk_window_set_attached_to().
     *
     * Marks @window as attached to @attach_widget. This creates a logical binding
     * between the window and the widget it belongs to, which is used by GTK+ to
     * propagate information such as styling or accessibility to @window as if it
     * was a children of @attach_widget.
     *
     * Examples of places where specifying this relation is useful are for instance
     * a #GtkMenu created by a #GtkComboBox, a completion popup window
     * created by #GtkEntry or a typeahead search entry created by #GtkTreeView.
     *
     * Note that this function should not be confused with
     * gtk_window_set_transient_for(), which specifies a window manager relation
     * between two toplevels instead.
     *
     * Passing %NULL for @attach_widget detaches the window. */
    var attachedTo: CPointer<GtkWidget>
        get() = gtk_window_get_attached_to(self)!!.reinterpret()
        set(value) {
            gtk_window_set_attached_to(self, value?.reinterpret())
        }

    /**
     * Returns whether the window has been set to have decorations
     * such as a title bar via gtk_window_set_decorated().
     *
     * By default, windows are decorated with a title bar, resize
     * controls, etc.  Some [window managers][gtk-X11-arch]
     * allow GTK+ to disable these decorations, creating a
     * borderless window. If you set the decorated property to %FALSE
     * using this function, GTK+ will do its best to convince the window
     * manager not to decorate the window. Depending on the system, this
     * function may not have any effect when called on a window that is
     * already visible, so you should call it before calling gtk_widget_show().
     *
     * On Windows, this function always works, since there’s no window manager
     * policy involved. */
    var decorated: Boolean
        get() = gtk_window_get_decorated(self) != 0
        set(value) {
            gtk_window_set_decorated(self, if (value) gtk_true() else gtk_false())
        }

    val defaultWidget: CPointer<GtkWidget>
        get() = gtk_window_get_default_widget(self)!!.reinterpret()

    /**
     * Returns whether the window has been set to have a close button
     * via gtk_window_set_deletable().
     *
     * By default, windows have a close button in the window frame. Some
     * [window managers][gtk-X11-arch] allow GTK+ to
     * disable this button. If you set the deletable property to %FALSE
     * using this function, GTK+ will do its best to convince the window
     * manager not to show a close button. Depending on the system, this
     * function may not have any effect when called on a window that is
     * already visible, so you should call it before calling gtk_widget_show().
     *
     * On Windows, this function always works, since there’s no window manager
     * policy involved. */
    var deletable: Boolean
        get() = gtk_window_get_deletable(self) != 0
        set(value) {
            gtk_window_set_deletable(self, if (value) gtk_true() else gtk_false())
        }

    /**
     * Returns whether the window will be destroyed with its transient parent. See
     * gtk_window_set_destroy_with_parent ().
     *
     * If @setting is %TRUE, then destroying the transient parent of @window
     * will also destroy @window itself. This is useful for dialogs that
     * shouldn’t persist beyond the lifetime of the main window they're
     * associated with, for example. */
    var destroyWithParent: Boolean
        get() = gtk_window_get_destroy_with_parent(self) != 0
        set(value) {
            gtk_window_set_destroy_with_parent(self, if (value) gtk_true() else gtk_false())
        }

    /**
     * Retrieves the current focused widget within the window.
     * Note that this is the widget that would have the focus
     * if the toplevel window focused; if the toplevel window
     * is not focused then  `gtk_widget_has_focus (widget)` will
     * not be %TRUE for the widget.
     *
     * If @focus is not the current focus widget, and is focusable, sets
     * it as the focus widget for the window. If @focus is %NULL, unsets
     * the focus widget for this window. To set the focus to a particular
     * widget in the toplevel, it is usually more convenient to use
     * gtk_widget_grab_focus() instead of this function. */
    var focus: CPointer<GtkWidget>
        get() = gtk_window_get_focus(self)!!.reinterpret()
        set(value) {
            gtk_window_set_focus(self, value?.reinterpret())
        }

    /**
     * Gets the value set by gtk_window_set_focus_on_map().
     *
     * Windows may set a hint asking the desktop environment not to receive
     * the input focus when the window is mapped.  This function sets this
     * hint. */
    var focusOnMap: Boolean
        get() = gtk_window_get_focus_on_map(self) != 0
        set(value) {
            gtk_window_set_focus_on_map(self, if (value) gtk_true() else gtk_false())
        }

    /**
     * Gets the value of the #GtkWindow:focus-visible property.
     *
     * Sets the #GtkWindow:focus-visible property. */
    var focusVisible: Boolean
        get() = gtk_window_get_focus_visible(self) != 0
        set(value) {
            gtk_window_set_focus_visible(self, if (value) gtk_true() else gtk_false())
        }

    /**
     * Gets the value set by gtk_window_set_gravity().
     *
     * Window gravity defines the meaning of coordinates passed to
     * gtk_window_move(). See gtk_window_move() and #GdkGravity for
     * more details.
     *
     * The default window gravity is #GDK_GRAVITY_NORTH_WEST which will
     * typically “do what you mean.” */
    var gravity: GdkGravity
        get() = gtk_window_get_gravity(self)
        set(value) {
            gtk_window_set_gravity(self, value)
        }

    val group: CPointer<GtkWindowGroup>
        get() = gtk_window_get_group(self)!!.reinterpret()

    /**
     * Returns whether the window has requested to have its titlebar hidden
     * when maximized. See gtk_window_set_hide_titlebar_when_maximized ().
     *
     * If @setting is %TRUE, then @window will request that it’s titlebar
     * should be hidden when maximized.
     * This is useful for windows that don’t convey any information other
     * than the application name in the titlebar, to put the available
     * screen space to better use. If the underlying window system does not
     * support the request, the setting will not have any effect.
     *
     * Note that custom titlebars set with gtk_window_set_titlebar() are
     * not affected by this. The application is in full control of their
     * content and visibility anyway. */
    var hideTitlebarWhenMaximized: Boolean
        get() = gtk_window_get_hide_titlebar_when_maximized(self) != 0
        set(value) {
            gtk_window_set_hide_titlebar_when_maximized(self,
                    if (value) gtk_true() else gtk_false())
        }

    /**
     * Gets the value set by gtk_window_set_icon() (or if you've
     * called gtk_window_set_icon_list(), gets the first icon in
     * the icon list).
     *
     * Sets up the icon representing a #GtkWindow. This icon is used when
     * the window is minimized (also known as iconified).  Some window
     * managers or desktop environments may also place it in the window
     * frame, or display it in other contexts. On others, the icon is not
     * used at all, so your mileage may vary.
     *
     * The icon should be provided in whatever size it was naturally
     * drawn; that is, don’t scale the image before passing it to
     * GTK+. Scaling is postponed until the last minute, when the desired
     * final size is known, to allow best quality.
     *
     * If you have your icon hand-drawn in multiple sizes, use
     * gtk_window_set_icon_list(). Then the best size will be used.
     *
     * This function is equivalent to calling gtk_window_set_icon_list()
     * with a 1-element list.
     *
     * See also gtk_window_set_default_icon_list() to set the icon
     * for all windows in your application in one go. */
    var icon: CPointer<GdkPixbuf>
        get() = gtk_window_get_icon(self)!!.reinterpret()
        set(value) {
            gtk_window_set_icon(self, value?.reinterpret())
        }

    /**
     * Retrieves the list of icons set by gtk_window_set_icon_list().
     * The list is copied, but the reference count on each
     * member won’t be incremented.
     *
     * Sets up the icon representing a #GtkWindow. The icon is used when
     * the window is minimized (also known as iconified).  Some window
     * managers or desktop environments may also place it in the window
     * frame, or display it in other contexts. On others, the icon is not
     * used at all, so your mileage may vary.
     *
     * gtk_window_set_icon_list() allows you to pass in the same icon in
     * several hand-drawn sizes. The list should contain the natural sizes
     * your icon is available in; that is, don’t scale the image before
     * passing it to GTK+. Scaling is postponed until the last minute,
     * when the desired final size is known, to allow best quality.
     *
     * By passing several sizes, you may improve the final image quality
     * of the icon, by reducing or eliminating automatic image scaling.
     *
     * Recommended sizes to provide: 16x16, 32x32, 48x48 at minimum, and
     * larger images (64x64, 128x128) if you have them.
     *
     * See also gtk_window_set_default_icon_list() to set the icon
     * for all windows in your application in one go.
     *
     * Note that transient windows (those who have been set transient for another
     * window using gtk_window_set_transient_for()) will inherit their
     * icon from their transient parent. So there’s no need to explicitly
     * set the icon on transient windows. */
    var iconList: CPointer<GList>
        get() = gtk_window_get_icon_list(self)!!.reinterpret()
        set(value) {
            gtk_window_set_icon_list(self, value?.reinterpret())
        }

    /**
     * Returns the name of the themed icon for the window,
     * see gtk_window_set_icon_name().
     *
     * Sets the icon for the window from a named themed icon.
     * See the docs for #GtkIconTheme for more details.
     * On some platforms, the window icon is not used at all.
     *
     * Note that this has nothing to do with the WM_ICON_NAME
     * property which is mentioned in the ICCCM. */
    var iconName: String
        get() = gtk_window_get_icon_name(self)?.toKString() ?: ""
        set(value) {
            gtk_window_set_icon_name(self, value)
        }

    /**
     * Returns the mnemonic modifier for this window. See
     * gtk_window_set_mnemonic_modifier().
     *
     * Sets the mnemonic modifier for this window. */
    var mnemonicModifier: GdkModifierType
        get() = gtk_window_get_mnemonic_modifier(self)
        set(value) {
            gtk_window_set_mnemonic_modifier(self, value)
        }

    /**
     * Gets the value of the #GtkWindow:mnemonics-visible property.
     *
     * Sets the #GtkWindow:mnemonics-visible property. */
    var mnemonicsVisible: Boolean
        get() = gtk_window_get_mnemonics_visible(self) != 0
        set(value) {
            gtk_window_set_mnemonics_visible(self, if (value) gtk_true() else gtk_false())
        }

    /**
     * Returns whether the window is modal. See gtk_window_set_modal().
     *
     * Sets a window modal or non-modal. Modal windows prevent interaction
     * with other windows in the same application. To keep modal dialogs
     * on top of main application windows, use
     * gtk_window_set_transient_for() to make the dialog transient for the
     * parent; most [window managers][gtk-X11-arch]
     * will then disallow lowering the dialog below the parent. */
    var modal: Boolean
        get() = gtk_window_get_modal(self) != 0
        set(value) {
            gtk_window_set_modal(self, if (value) gtk_true() else gtk_false())
        }

    /**
     * Gets the value set by gtk_window_set_resizable().
     *
     * Sets whether the user can resize a window. Windows are user resizable
     * by default. */
    var resizable: Boolean
        get() = gtk_window_get_resizable(self) != 0
        set(value) {
            gtk_window_set_resizable(self, if (value) gtk_true() else gtk_false())
        }

    /**
     * Returns the role of the window. See gtk_window_set_role() for
     * further explanation.
     *
     * This function is only useful on X11, not with other GTK+ targets.
     *
     * In combination with the window title, the window role allows a
     * [window manager][gtk-X11-arch] to identify "the
     * same" window when an application is restarted. So for example you
     * might set the “toolbox” role on your app’s toolbox window, so that
     * when the user restarts their session, the window manager can put
     * the toolbox back in the same place.
     *
     * If a window already has a unique title, you don’t need to set the
     * role, since the WM can use the title to identify the window when
     * restoring the session. */
    var role: String
        get() = gtk_window_get_role(self)?.toKString() ?: ""
        set(value) {
            gtk_window_set_role(self, value)
        }

    /**
     * Gets the value set by gtk_window_set_skip_pager_hint().
     *
     * Windows may set a hint asking the desktop environment not to display
     * the window in the pager. This function sets this hint.
     * (A "pager" is any desktop navigation tool such as a workspace
     * switcher that displays a thumbnail representation of the windows
     * on the screen.) */
    var skipPagerHint: Boolean
        get() = gtk_window_get_skip_pager_hint(self) != 0
        set(value) {
            gtk_window_set_skip_pager_hint(self, if (value) gtk_true() else gtk_false())
        }

    /**
     * Gets the value set by gtk_window_set_skip_taskbar_hint()
     *
     * Windows may set a hint asking the desktop environment not to display
     * the window in the task bar. This function sets this hint. */
    var skipTaskbarHint: Boolean
        get() = gtk_window_get_skip_taskbar_hint(self) != 0
        set(value) {
            gtk_window_set_skip_taskbar_hint(self, if (value) gtk_true() else gtk_false())
        }

    /**
     * Retrieves the title of the window. See gtk_window_set_title().
     *
     * Sets the title of the #GtkWindow. The title of a window will be
     * displayed in its title bar; on the X Window System, the title bar
     * is rendered by the [window manager][gtk-X11-arch],
     * so exactly how the title appears to users may vary
     * according to a user’s exact configuration. The title should help a
     * user distinguish this window from other windows they may have
     * open. A good title might include the application name and current
     * document filename, for example. */
    var title: String
        get() = gtk_window_get_title(self)?.toKString() ?: ""
        set(value) {
            gtk_window_set_title(self, value)
        }

    /**
     * Returns the custom titlebar that has been set with
     * gtk_window_set_titlebar().
     *
     * Sets a custom titlebar for @window.
     *
     * A typical widget used here is #GtkHeaderBar, as it provides various features
     * expected of a titlebar while allowing the addition of child widgets to it.
     *
     * If you set a custom titlebar, GTK+ will do its best to convince
     * the window manager not to put its own titlebar on the window.
     * Depending on the system, this function may not work for a window
     * that is already visible, so you set the titlebar before calling
     * gtk_widget_show(). */
    var titlebar: CPointer<GtkWidget>
        get() = gtk_window_get_titlebar(self)!!.reinterpret()
        set(value) {
            gtk_window_set_titlebar(self, value?.reinterpret())
        }

    /**
     * Fetches the transient parent for this window. See
     * gtk_window_set_transient_for().
     *
     * Dialog windows should be set transient for the main application
     * window they were spawned from. This allows
     * [window managers][gtk-X11-arch] to e.g. keep the
     * dialog on top of the main window, or center the dialog over the
     * main window. gtk_dialog_new_with_buttons() and other convenience
     * functions in GTK+ will sometimes call
     * gtk_window_set_transient_for() on your behalf.
     *
     * Passing %NULL for @parent unsets the current transient window.
     *
     * On Wayland, this function can also be used to attach a new
     * #GTK_WINDOW_POPUP to a #GTK_WINDOW_TOPLEVEL parent already mapped
     * on screen so that the #GTK_WINDOW_POPUP will be created as a
     * subsurface-based window #GDK_WINDOW_SUBSURFACE which can be
     * positioned at will relatively to the #GTK_WINDOW_TOPLEVEL surface.
     *
     * On Windows, this function puts the child window on top of the parent,
     * much as the window manager would have done on X. */
    var transientFor: CPointer<GtkWindow>
        get() = gtk_window_get_transient_for(self)!!.reinterpret()
        set(value) {
            gtk_window_set_transient_for(self, value?.reinterpret())
        }

    /**
     * Gets the type hint for this window. See gtk_window_set_type_hint().
     *
     * By setting the type hint for the window, you allow the window
     * manager to decorate and handle the window in a way which is
     * suitable to the function of the window in your application.
     *
     * This function should be called before the window becomes visible.
     *
     * gtk_dialog_new_with_buttons() and other convenience functions in GTK+
     * will sometimes call gtk_window_set_type_hint() on your behalf. */
    var typeHint: GdkWindowTypeHint
        get() = gtk_window_get_type_hint(self)
        set(value) {
            gtk_window_set_type_hint(self, value)
        }

    /**
     * Gets the value set by gtk_window_set_urgency_hint()
     *
     * Windows may set a hint asking the desktop environment to draw
     * the users attention to the window. This function sets this hint. */
    var urgencyHint: Boolean
        get() = gtk_window_get_urgency_hint(self) != 0
        set(value) {
            gtk_window_set_urgency_hint(self, if (value) gtk_true() else gtk_false())
        }

    val windowType: GtkWindowType
        get() = gtk_window_get_window_type(self)

    /**
     * Creates a new #GtkWindow, which is a toplevel window that can
     * contain other widgets. Nearly always, the type of the window should
     * be #GTK_WINDOW_TOPLEVEL. If you’re implementing something like a
     * popup menu from scratch (which is a bad idea, just use #GtkMenu),
     * you might use #GTK_WINDOW_POPUP. #GTK_WINDOW_POPUP is not for
     * dialogs, though in some other toolkits dialogs are called “popups”.
     * In GTK+, #GTK_WINDOW_POPUP means a pop-up menu or pop-up tooltip.
     * On X11, popup windows are not controlled by the
     * [window manager][gtk-X11-arch].
     *
     * If you simply want an undecorated window (no window borders), use
     * gtk_window_set_decorated(), don’t use #GTK_WINDOW_POPUP.
     *
     * All top-level windows created by gtk_window_new() are stored in
     * an internal top-level window list.  This list can be obtained from
     * gtk_window_list_toplevels().  Due to Gtk+ keeping a reference to
     * the window internally, gtk_window_new() does not return a reference
     * to the caller.
     *
     * To delete a #GtkWindow, call gtk_widget_destroy(). */
    constructor(type: GtkWindowType) : this(gtk_window_new(type)?.reinterpret())

    /**
     * Activates the default widget for the window, unless the current
     * focused widget has been configured to receive the default action
     * (see gtk_widget_set_receives_default()), in which case the
     * focused widget is activated.
     */
    fun activateDefault(): Boolean = gtk_window_activate_default(self) != 0

    /**
     * Activates the current focused widget within the window.
     */
    fun activateFocus(): Boolean = gtk_window_activate_focus(self) != 0

    /**
     * Activates mnemonics and accelerators for this #GtkWindow. This is normally
     * called by the default ::key_press_event handler for toplevel windows,
     * however in some cases it may be useful to call this directly when
     * overriding the standard key handling for a toplevel window.
     */
    fun activateKey(event: CPointer<GdkEventKey>): Boolean = gtk_window_activate_key(self,
            event) != 0

    /**
     * Associate @accel_group with @window, such that calling
     * gtk_accel_groups_activate() on @window will activate accelerators
     * in @accel_group.
     */
    fun addAccelGroup(accel_group: CPointer<GtkAccelGroup>): Unit = gtk_window_add_accel_group(self,
            accel_group)

    /**
     * Adds a mnemonic to this window.
     */
    fun addMnemonic(keyval: UInt, target: CPointer<GtkWidget>): Unit = gtk_window_add_mnemonic(self,
            keyval, target)

    /**
     * Adds a mnemonic to this window.
     */
    fun addMnemonic(keyval: UInt, target: Widget): Unit = gtk_window_add_mnemonic(self, keyval,
            target.widgetPtr?.reinterpret())

    /**
     * Starts moving a window. This function is used if an application has
     * window movement grips. When GDK can support it, the window movement
     * will be done using the standard mechanism for the
     * [window manager][gtk-X11-arch] or windowing
     * system. Otherwise, GDK will try to emulate window movement,
     * potentially not all that well, depending on the windowing system.
     */
    fun beginMoveDrag(
        button: Int,
        root_x: Int,
        root_y: Int,
        timestamp: UInt
    ): Unit = gtk_window_begin_move_drag(self, button, root_x, root_y, timestamp)

    /**
     * Starts resizing a window. This function is used if an application
     * has window resizing controls. When GDK can support it, the resize
     * will be done using the standard mechanism for the
     * [window manager][gtk-X11-arch] or windowing
     * system. Otherwise, GDK will try to emulate window resizing,
     * potentially not all that well, depending on the windowing system.
     */
    fun beginResizeDrag(
        edge: GdkWindowEdge,
        button: Int,
        root_x: Int,
        root_y: Int,
        timestamp: UInt
    ): Unit = gtk_window_begin_resize_drag(self, edge, button, root_x, root_y, timestamp)

    /**
     * Requests that the window is closed, similar to what happens
     * when a window manager close button is clicked.
     *
     * This function can be used with close buttons in custom
     * titlebars.
     */
    fun close(): Unit = gtk_window_close(self)

    /**
     * Asks to deiconify (i.e. unminimize) the specified @window. Note
     * that you shouldn’t assume the window is definitely deiconified
     * afterward, because other entities (e.g. the user or
     * [window manager][gtk-X11-arch])) could iconify it
     * again before your code which assumes deiconification gets to run.
     *
     * You can track iconification via the “window-state-event” signal
     * on #GtkWidget.
     */
    fun deiconify(): Unit = gtk_window_deiconify(self)

    /**
     * Asks to place @window in the fullscreen state. Note that you
     * shouldn’t assume the window is definitely full screen afterward,
     * because other entities (e.g. the user or
     * [window manager][gtk-X11-arch]) could unfullscreen it
     * again, and not all window managers honor requests to fullscreen
     * windows. But normally the window will end up fullscreen. Just
     * don’t write code that crashes if not.
     *
     * You can track the fullscreen state via the “window-state-event” signal
     * on #GtkWidget.
     */
    fun fullscreen(): Unit = gtk_window_fullscreen(self)

    /**
     * Asks to place @window in the fullscreen state. Note that you shouldn't assume
     * the window is definitely full screen afterward.
     *
     * You can track the fullscreen state via the "window-state-event" signal
     * on #GtkWidget.
     */
    fun fullscreenOnMonitor(screen: CPointer<GdkScreen>, monitor: Int): Unit =
            gtk_window_fullscreen_on_monitor(self, screen, monitor)

    /**
     * Returns whether @window has an explicit window group.
     */
    fun hasGroup(): Boolean = gtk_window_has_group(self) != 0

    /**
     * Returns whether the input focus is within this GtkWindow.
     * For real toplevel windows, this is identical to gtk_window_is_active(),
     * but for embedded windows, like #GtkPlug, the results will differ.
     */
    fun hasToplevelFocus(): Boolean = gtk_window_has_toplevel_focus(self) != 0

    /**
     * Asks to iconify (i.e. minimize) the specified @window. Note that
     * you shouldn’t assume the window is definitely iconified afterward,
     * because other entities (e.g. the user or
     * [window manager][gtk-X11-arch]) could deiconify it
     * again, or there may not be a window manager in which case
     * iconification isn’t possible, etc. But normally the window will end
     * up iconified. Just don’t write code that crashes if not.
     *
     * It’s permitted to call this function before showing a window,
     * in which case the window will be iconified before it ever appears
     * onscreen.
     *
     * You can track iconification via the “window-state-event” signal
     * on #GtkWidget.
     */
    fun iconify(): Unit = gtk_window_iconify(self)

    /**
     * Returns whether the window is part of the current active toplevel.
     * (That is, the toplevel window receiving keystrokes.)
     * The return value is %TRUE if the window is active toplevel
     * itself, but also if it is, say, a #GtkPlug embedded in the active toplevel.
     * You might use this function if you wanted to draw a widget
     * differently in an active window from a widget in an inactive window.
     * See gtk_window_has_toplevel_focus()
     */
    fun isActive(): Boolean = gtk_window_is_active(self) != 0

    /**
     * Retrieves the current maximized state of @window.
     *
     * Note that since maximization is ultimately handled by the window
     * manager and happens asynchronously to an application request, you
     * shouldn’t assume the return value of this function changing
     * immediately (or at all), as an effect of calling
     * gtk_window_maximize() or gtk_window_unmaximize().
     */
    fun isMaximized(): Boolean = gtk_window_is_maximized(self) != 0

    /**
     * Asks to maximize @window, so that it becomes full-screen. Note that
     * you shouldn’t assume the window is definitely maximized afterward,
     * because other entities (e.g. the user or
     * [window manager][gtk-X11-arch]) could unmaximize it
     * again, and not all window managers support maximization. But
     * normally the window will end up maximized. Just don’t write code
     * that crashes if not.
     *
     * It’s permitted to call this function before showing a window,
     * in which case the window will be maximized when it appears onscreen
     * initially.
     *
     * You can track maximization via the “window-state-event” signal
     * on #GtkWidget, or by listening to notifications on the
     * #GtkWindow:is-maximized property.
     */
    fun maximize(): Unit = gtk_window_maximize(self)

    /**
     * Activates the targets associated with the mnemonic.
     */
    fun mnemonicActivate(keyval: UInt, modifier: GdkModifierType): Boolean =
            gtk_window_mnemonic_activate(self, keyval, modifier) != 0

    /**
     * Asks the [window manager][gtk-X11-arch] to move
     * @window to the given position.  Window managers are free to ignore
     * this; most window managers ignore requests for initial window
     * positions (instead using a user-defined placement algorithm) and
     * honor requests after the window has already been shown.
     *
     * Note: the position is the position of the gravity-determined
     * reference point for the window. The gravity determines two things:
     * first, the location of the reference point in root window
     * coordinates; and second, which point on the window is positioned at
     * the reference point.
     *
     * By default the gravity is #GDK_GRAVITY_NORTH_WEST, so the reference
     * point is simply the @x, @y supplied to gtk_window_move(). The
     * top-left corner of the window decorations (aka window frame or
     * border) will be placed at @x, @y.  Therefore, to position a window
     * at the top left of the screen, you want to use the default gravity
     * (which is #GDK_GRAVITY_NORTH_WEST) and move the window to 0,0.
     *
     * To position a window at the bottom right corner of the screen, you
     * would set #GDK_GRAVITY_SOUTH_EAST, which means that the reference
     * point is at @x + the window width and @y + the window height, and
     * the bottom-right corner of the window border will be placed at that
     * reference point. So, to place a window in the bottom right corner
     * you would first set gravity to south east, then write:
     * `gtk_window_move (window, gdk_screen_width () - window_width,
     * gdk_screen_height () - window_height)` (note that this
     * example does not take multi-head scenarios into account).
     *
     * The [Extended Window Manager Hints
            Specification](http://www.freedesktop.org/Standards/wm-spec)
     * has a nice table of gravities in the “implementation notes” section.
     *
     * The gtk_window_get_position() documentation may also be relevant.
     */
    fun move(x: Int, y: Int): Unit = gtk_window_move(self, x, y)

    /**
     * Presents a window to the user. This may mean raising the window
     * in the stacking order, deiconifying it, moving it to the current
     * desktop, and/or giving it the keyboard focus, possibly dependent
     * on the user’s platform, window manager, and preferences.
     *
     * If @window is hidden, this function calls gtk_widget_show()
     * as well.
     *
     * This function should be used when the user tries to open a window
     * that’s already open. Say for example the preferences dialog is
     * currently open, and the user chooses Preferences from the menu
     * a second time; use gtk_window_present() to move the already-open dialog
     * where the user can see it.
     *
     * If you are calling this function in response to a user interaction,
     * it is preferable to use gtk_window_present_with_time().
     */
    fun present(): Unit = gtk_window_present(self)

    /**
     * Presents a window to the user in response to a user interaction.
     * If you need to present a window without a timestamp, use
     * gtk_window_present(). See gtk_window_present() for details.
     */
    fun presentWithTime(timestamp: UInt): Unit = gtk_window_present_with_time(self, timestamp)

    /**
     * Propagate a key press or release event to the focus widget and
     * up the focus container chain until a widget handles @event.
     * This is normally called by the default ::key_press_event and
     * ::key_release_event handlers for toplevel windows,
     * however in some cases it may be useful to call this directly when
     * overriding the standard key handling for a toplevel window.
     */
    fun propagateKeyEvent(event: CPointer<GdkEventKey>): Boolean =
            gtk_window_propagate_key_event(self, event) != 0

    /**
     * Reverses the effects of gtk_window_add_accel_group().
     */
    fun removeAccelGroup(accel_group: CPointer<GtkAccelGroup>): Unit =
            gtk_window_remove_accel_group(self, accel_group)

    /**
     * Removes a mnemonic from this window.
     */
    fun removeMnemonic(keyval: UInt, target: CPointer<GtkWidget>): Unit =
            gtk_window_remove_mnemonic(self, keyval, target)

    /**
     * Removes a mnemonic from this window.
     */
    fun removeMnemonic(keyval: UInt, target: Widget): Unit = gtk_window_remove_mnemonic(self,
            keyval, target.widgetPtr?.reinterpret())

    /**
     * Resizes the window as if the user had done so, obeying geometry
     * constraints. The default geometry constraint is that windows may
     * not be smaller than their size request; to override this
     * constraint, call gtk_widget_set_size_request() to set the window's
     * request to a smaller value.
     *
     * If gtk_window_resize() is called before showing a window for the
     * first time, it overrides any default size set with
     * gtk_window_set_default_size().
     *
     * Windows may not be resized smaller than 1 by 1 pixels.
     *
     * When using client side decorations, GTK+ will do its best to adjust
     * the given size so that the resulting window size matches the
     * requested size without the title bar, borders and shadows added for
     * the client side decorations, but there is no guarantee that the
     * result will be totally accurate because these widgets added for
     * client side decorations depend on the theme and may not be realized
     * or visible at the time gtk_window_resize() is issued.
     *
     * If the GtkWindow has a titlebar widget (see gtk_window_set_titlebar()), then
     * typically, gtk_window_resize() will compensate for the height of the titlebar
     * widget only if the height is known when the resulting GtkWindow configuration
     * is issued.
     * For example, if new widgets are added after the GtkWindow configuration
     * and cause the titlebar widget to grow in height, this will result in a
     * window content smaller that specified by gtk_window_resize() and not
     * a larger window.
     */
    fun resize(width: Int, height: Int): Unit = gtk_window_resize(self, width, height)

    /**
     * Sets the default size of a window. If the window’s “natural” size
     * (its size request) is larger than the default, the default will be
     * ignored. More generally, if the default size does not obey the
     * geometry hints for the window (gtk_window_set_geometry_hints() can
     * be used to set these explicitly), the default size will be clamped
     * to the nearest permitted size.
     *
     * Unlike gtk_widget_set_size_request(), which sets a size request for
     * a widget and thus would keep users from shrinking the window, this
     * function only sets the initial size, just as if the user had
     * resized the window themselves. Users can still shrink the window
     * again as they normally would. Setting a default size of -1 means to
     * use the “natural” default size (the size request of the window).
     *
     * For more control over a window’s initial size and how resizing works,
     * investigate gtk_window_set_geometry_hints().
     *
     * For some uses, gtk_window_resize() is a more appropriate function.
     * gtk_window_resize() changes the current size of the window, rather
     * than the size to be used on initial display. gtk_window_resize() always
     * affects the window itself, not the geometry widget.
     *
     * The default size of a window only affects the first time a window is
     * shown; if a window is hidden and re-shown, it will remember the size
     * it had prior to hiding, rather than using the default size.
     *
     * Windows can’t actually be 0x0 in size, they must be at least 1x1, but
     * passing 0 for @width and @height is OK, resulting in a 1x1 default size.
     *
     * If you use this function to reestablish a previously saved window size,
     * note that the appropriate size to save is the one returned by
     * gtk_window_get_size(). Using the window allocation directly will not
     * work in all circumstances and can lead to growing or shrinking windows.
     */
    fun setDefaultSize(width: Int, height: Int): Unit = gtk_window_set_default_size(self, width,
            height)

    /**
     * This function sets up hints about how a window can be resized by
     * the user.  You can set a minimum and maximum size; allowed resize
     * increments (e.g. for xterm, you can only resize by the size of a
     * character); aspect ratios; and more. See the #GdkGeometry struct.
     */
    fun setGeometryHints(
        geometry_widget: CPointer<GtkWidget>,
        geometry: CPointer<GdkGeometry>,
        geom_mask: GdkWindowHints
    ): Unit = gtk_window_set_geometry_hints(self, geometry_widget, geometry, geom_mask)

    /**
     * Asks to stick @window, which means that it will appear on all user
     * desktops. Note that you shouldn’t assume the window is definitely
     * stuck afterward, because other entities (e.g. the user or
     * [window manager][gtk-X11-arch] could unstick it
     * again, and some window managers do not support sticking
     * windows. But normally the window will end up stuck. Just don't
     * write code that crashes if not.
     *
     * It’s permitted to call this function before showing a window.
     *
     * You can track stickiness via the “window-state-event” signal
     * on #GtkWidget.
     */
    fun stick(): Unit = gtk_window_stick(self)

    /**
     * Asks to toggle off the fullscreen state for @window. Note that you
     * shouldn’t assume the window is definitely not full screen
     * afterward, because other entities (e.g. the user or
     * [window manager][gtk-X11-arch]) could fullscreen it
     * again, and not all window managers honor requests to unfullscreen
     * windows. But normally the window will end up restored to its normal
     * state. Just don’t write code that crashes if not.
     *
     * You can track the fullscreen state via the “window-state-event” signal
     * on #GtkWidget.
     */
    fun unfullscreen(): Unit = gtk_window_unfullscreen(self)

    /**
     * Asks to unmaximize @window. Note that you shouldn’t assume the
     * window is definitely unmaximized afterward, because other entities
     * (e.g. the user or [window manager][gtk-X11-arch])
     * could maximize it again, and not all window
     * managers honor requests to unmaximize. But normally the window will
     * end up unmaximized. Just don’t write code that crashes if not.
     *
     * You can track maximization via the “window-state-event” signal
     * on #GtkWidget.
     */
    fun unmaximize(): Unit = gtk_window_unmaximize(self)

    /**
     * Asks to unstick @window, which means that it will appear on only
     * one of the user’s desktops. Note that you shouldn’t assume the
     * window is definitely unstuck afterward, because other entities
     * (e.g. the user or [window manager][gtk-X11-arch]) could
     * stick it again. But normally the window will
     * end up stuck. Just don’t write code that crashes if not.
     *
     * You can track stickiness via the “window-state-event” signal
     * on #GtkWidget.
     */
    fun unstick(): Unit = gtk_window_unstick(self)

    /**
     * The default widget is the widget that’s activated when the user
     * presses Enter in a dialog (for example). This function sets or
     * unsets the default widget for a #GtkWindow. When setting (rather
     * than unsetting) the default widget it’s generally easier to call
     * gtk_widget_grab_default() on the widget. Before making a widget
     * the default widget, you must call gtk_widget_set_can_default() on
     * the widget you’d like to make the default.
     */
    fun setDefault(default_widget: CPointer<GtkWidget>): Unit = gtk_window_set_default(self,
            default_widget)

    /**
     * Tells GTK+ whether to drop its extra reference to the window
     * when gtk_widget_destroy() is called.
     *
     * This function is only exported for the benefit of language
     * bindings which may need to keep the window alive until their
     * wrapper object is garbage collected. There is no justification
     * for ever calling this function in an application.
     */
    fun setHasUserRefCount(setting: Boolean): Unit = gtk_window_set_has_user_ref_count(self,
            if (setting) gtk_true() else gtk_false())

    /**
     * Asks to keep @window above, so that it stays on top. Note that
     * you shouldn’t assume the window is definitely above afterward,
     * because other entities (e.g. the user or
     * [window manager][gtk-X11-arch]) could not keep it above,
     * and not all window managers support keeping windows above. But
     * normally the window will end kept above. Just don’t write code
     * that crashes if not.
     *
     * It’s permitted to call this function before showing a window,
     * in which case the window will be kept above when it appears onscreen
     * initially.
     *
     * You can track the above state via the “window-state-event” signal
     * on #GtkWidget.
     *
     * Note that, according to the
     * [Extended Window Manager Hints Specification](http://www.freedesktop.org/Standards/wm-spec),
     * the above state is mainly meant for user preferences and should not
     * be used by applications e.g. for drawing attention to their
     * dialogs.
     */
    fun setKeepAbove(setting: Boolean): Unit = gtk_window_set_keep_above(self,
            if (setting) gtk_true() else gtk_false())

    /**
     * Asks to keep @window below, so that it stays in bottom. Note that
     * you shouldn’t assume the window is definitely below afterward,
     * because other entities (e.g. the user or
     * [window manager][gtk-X11-arch]) could not keep it below,
     * and not all window managers support putting windows below. But
     * normally the window will be kept below. Just don’t write code
     * that crashes if not.
     *
     * It’s permitted to call this function before showing a window,
     * in which case the window will be kept below when it appears onscreen
     * initially.
     *
     * You can track the below state via the “window-state-event” signal
     * on #GtkWidget.
     *
     * Note that, according to the
     * [Extended Window Manager Hints Specification](http://www.freedesktop.org/Standards/wm-spec),
     * the above state is mainly meant for user preferences and should not
     * be used by applications e.g. for drawing attention to their
     * dialogs.
     */
    fun setKeepBelow(setting: Boolean): Unit = gtk_window_set_keep_below(self,
            if (setting) gtk_true() else gtk_false())

    /**
     * Sets a position constraint for this window. If the old or new
     * constraint is %GTK_WIN_POS_CENTER_ALWAYS, this will also cause
     * the window to be repositioned to satisfy the new constraint.
     */
    fun setPosition(position: GtkWindowPosition): Unit = gtk_window_set_position(self, position)

    /**
     * Startup notification identifiers are used by desktop environment to
     * track application startup, to provide user feedback and other
     * features. This function changes the corresponding property on the
     * underlying GdkWindow. Normally, startup identifier is managed
     * automatically and you should only use this function in special cases
     * like transferring focus from other processes. You should use this
     * function before calling gtk_window_present() or any equivalent
     * function generating a window map event.
     *
     * This function is only useful on X11, not with other GTK+ targets.
     */
    fun setStartupId(startup_id: String): Unit = gtk_window_set_startup_id(self, startup_id)
}

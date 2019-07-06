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
import libgtk3.GMenuModel
import libgtk3.GtkMenuShell
import libgtk3.GtkWidget
import libgtk3.gtk_false
import libgtk3.gtk_menu_shell_activate_item
import libgtk3.gtk_menu_shell_bind_model
import libgtk3.gtk_menu_shell_cancel
import libgtk3.gtk_menu_shell_deactivate
import libgtk3.gtk_menu_shell_deselect
import libgtk3.gtk_menu_shell_get_parent_shell
import libgtk3.gtk_menu_shell_get_selected_item
import libgtk3.gtk_menu_shell_get_take_focus
import libgtk3.gtk_menu_shell_insert
import libgtk3.gtk_menu_shell_prepend
import libgtk3.gtk_menu_shell_select_first
import libgtk3.gtk_menu_shell_select_item
import libgtk3.gtk_menu_shell_set_take_focus
import libgtk3.gtk_true

private fun MenuShell_onActivateCurrent_Handler(
    sender: CPointer<in CPointed>?,
    force_hide: Boolean,
    _data: COpaquePointer?
) {
    _data?.asStableRef<MenuShell>()?.get()?.onActivateCurrent?.emit(force_hide)
}

private fun MenuShell_onCancel_Handler(sender: CPointer<in CPointed>?, _data: COpaquePointer?) {
    _data?.asStableRef<MenuShell>()?.get()?.onCancel?.emit()
}

private fun MenuShell_onDeactivate_Handler(sender: CPointer<in CPointed>?, _data: COpaquePointer?) {
    _data?.asStableRef<MenuShell>()?.get()?.onDeactivate?.emit()
}

private fun MenuShell_onInsert_Handler(
    sender: CPointer<in CPointed>?,
    child: CPointer<GtkWidget>,
    position: Int,
    _data: COpaquePointer?
) {
    _data?.asStableRef<MenuShell>()?.get()?.onInsert?.emit(child?.reinterpret(), position)
}

private fun MenuShell_onMoveSelected_Handler(
    sender: CPointer<in CPointed>?,
    distance: Int,
    _data: COpaquePointer?
) {
    _data?.asStableRef<MenuShell>()?.get()?.onMoveSelected?.emit(distance)
}

private fun MenuShell_onSelectionDone_Handler(sender: CPointer<in CPointed>?, _data:
        COpaquePointer?) {
    _data?.asStableRef<MenuShell>()?.get()?.onSelectionDone?.emit()
}

/**
 * A #GtkMenuShell is the abstract base class used to derive the
 * #GtkMenu and #GtkMenuBar subclasses.
 *
 * A #GtkMenuShell is a container of #GtkMenuItem objects arranged
 * in a list which can be navigated, selected, and activated by the
 * user to perform application functions. A #GtkMenuItem can have a
 * submenu associated with it, allowing for nested hierarchical menus.
 *
 * # Terminology
 *
 * A menu item can be “selected”, this means that it is displayed
 * in the prelight state, and if it has a submenu, that submenu
 * will be popped up.
 *
 * A menu is “active” when it is visible onscreen and the user
 * is selecting from it. A menubar is not active until the user
 * clicks on one of its menuitems. When a menu is active,
 * passing the mouse over a submenu will pop it up.
 *
 * There is also is a concept of the current menu and a current
 * menu item. The current menu item is the selected menu item
 * that is furthest down in the hierarchy. (Every active menu shell
 * does not necessarily contain a selected menu item, but if
 * it does, then the parent menu shell must also contain
 * a selected menu item.) The current menu is the menu that
 * contains the current menu item. It will always have a GTK
 * grab and receive all key presses.Gets the parent menu shell.
 *
 * The parent menu shell of a submenu is the #GtkMenu or #GtkMenuBar
 * from which it was opened up.Gets the currently selected item. */
@GtkDsl
abstract class MenuShell : Container() {
    private val self: CPointer<GtkMenuShell>
        get() = widgetPtr!!.reinterpret()

    val onActivateCurrent: Signal1<MenuShell, Boolean, CFunction<(
        CPointer<in CPointed>?,
        Boolean,
        COpaquePointer?
    ) -> Unit>> by lazy { Signal1<MenuShell, Boolean, CFunction<(
                CPointer<in CPointed>?,
                Boolean,
                COpaquePointer?
            ) -> Unit>>(widgetPtr!!, this, "activate-current",
                    staticCFunction(::MenuShell_onActivateCurrent_Handler)) }

    val onCancel: Signal<MenuShell, CFunction<(CPointer<in CPointed>?, COpaquePointer?) -> Unit>> by
            lazy { Signal<MenuShell, CFunction<(CPointer<in CPointed>?, COpaquePointer?) ->
            Unit>>(widgetPtr!!, this, "cancel", staticCFunction(::MenuShell_onCancel_Handler)) }

    val onDeactivate: Signal<MenuShell, CFunction<(CPointer<in CPointed>?, COpaquePointer?) ->
            Unit>> by lazy { Signal<MenuShell, CFunction<(CPointer<in CPointed>?,
            COpaquePointer?) -> Unit>>(widgetPtr!!, this, "deactivate",
            staticCFunction(::MenuShell_onDeactivate_Handler)) }

    val onInsert: Signal2<MenuShell, CPointer<GtkWidget>, Int, CFunction<(
        CPointer<in CPointed>?,
        CPointer<GtkWidget>,
        Int,
        COpaquePointer?
    ) -> Unit>> by lazy { Signal2<MenuShell, CPointer<GtkWidget>, Int, CFunction<(
                CPointer<in CPointed>?,
                CPointer<GtkWidget>,
                Int,
                COpaquePointer?
            ) -> Unit>>(widgetPtr!!, this, "insert", staticCFunction(::MenuShell_onInsert_Handler))
                    }

    val onMoveSelected: Signal1<MenuShell, Int, CFunction<(
        CPointer<in CPointed>?,
        Int,
        COpaquePointer?
    ) -> Unit>> by lazy { Signal1<MenuShell, Int, CFunction<(
                CPointer<in CPointed>?,
                Int,
                COpaquePointer?
            ) -> Unit>>(widgetPtr!!, this, "move-selected",
                    staticCFunction(::MenuShell_onMoveSelected_Handler)) }

    val onSelectionDone: Signal<MenuShell, CFunction<(CPointer<in CPointed>?, COpaquePointer?) ->
            Unit>> by lazy { Signal<MenuShell, CFunction<(CPointer<in CPointed>?,
            COpaquePointer?) -> Unit>>(widgetPtr!!, this, "selection-done",
            staticCFunction(::MenuShell_onSelectionDone_Handler)) }

    val parentShell: CPointer<GtkWidget>
        get() = gtk_menu_shell_get_parent_shell(self)!!.reinterpret()

    val selectedItem: CPointer<GtkWidget>
        get() = gtk_menu_shell_get_selected_item(self)!!.reinterpret()

    /**
     * Returns %TRUE if the menu shell will take the keyboard focus on popup.
     *
     * If @take_focus is %TRUE (the default) the menu shell will take
     * the keyboard focus so that it will receive all keyboard events
     * which is needed to enable keyboard navigation in menus.
     *
     * Setting @take_focus to %FALSE is useful only for special applications
     * like virtual keyboard implementations which should not take keyboard
     * focus.
     *
     * The @take_focus state of a menu or menu bar is automatically
     * propagated to submenus whenever a submenu is popped up, so you
     * don’t have to worry about recursively setting it for your entire
     * menu hierarchy. Only when programmatically picking a submenu and
     * popping it up manually, the @take_focus property of the submenu
     * needs to be set explicitly.
     *
     * Note that setting it to %FALSE has side-effects:
     *
     * If the focus is in some other app, it keeps the focus and keynav in
     * the menu doesn’t work. Consequently, keynav on the menu will only
     * work if the focus is on some toplevel owned by the onscreen keyboard.
     *
     * To avoid confusing the user, menus with @take_focus set to %FALSE
     * should not display mnemonics or accelerators, since it cannot be
     * guaranteed that they will work.
     *
     * See also gdk_keyboard_grab() */
    var takeFocus: Boolean
        get() = gtk_menu_shell_get_take_focus(self) != 0
        set(value) {
            gtk_menu_shell_set_take_focus(self, if (value) gtk_true() else gtk_false())
        }

    /**
     * Activates the menu item within the menu shell.
     */
    fun activateItem(menu_item: CPointer<GtkWidget>, force_deactivate: Boolean): Unit =
            gtk_menu_shell_activate_item(self, menu_item,
            if (force_deactivate) gtk_true() else gtk_false())

    /**
     * Activates the menu item within the menu shell.
     */
    fun activateItem(menu_item: Widget, force_deactivate: Boolean): Unit =
            gtk_menu_shell_activate_item(self, menu_item.widgetPtr?.reinterpret(),
            if (force_deactivate) gtk_true() else gtk_false())

    /**
     * Establishes a binding between a #GtkMenuShell and a #GMenuModel.
     *
     * The contents of @shell are removed and then refilled with menu items
     * according to @model.  When @model changes, @shell is updated.
     * Calling this function twice on @shell with different @model will
     * cause the first binding to be replaced with a binding to the new
     * model. If @model is %NULL then any previous binding is undone and
     * all children are removed.
     *
     * @with_separators determines if toplevel items (eg: sections) have
     * separators inserted between them.  This is typically desired for
     * menus but doesn’t make sense for menubars.
     *
     * If @action_namespace is non-%NULL then the effect is as if all
     * actions mentioned in the @model have their names prefixed with the
     * namespace, plus a dot.  For example, if the action “quit” is
     * mentioned and @action_namespace is “app” then the effective action
     * name is “app.quit”.
     *
     * This function uses #GtkActionable to define the action name and
     * target values on the created menu items.  If you want to use an
     * action group other than “app” and “win”, or if you want to use a
     * #GtkMenuShell outside of a #GtkApplicationWindow, then you will need
     * to attach your own action group to the widget hierarchy using
     * gtk_widget_insert_action_group().  As an example, if you created a
     * group with a “quit” action and inserted it with the name “mygroup”
     * then you would use the action name “mygroup.quit” in your
     * #GMenuModel.
     *
     * For most cases you are probably better off using
     * gtk_menu_new_from_model() or gtk_menu_bar_new_from_model() or just
     * directly passing the #GMenuModel to gtk_application_set_app_menu() or
     * gtk_application_set_menubar().
     */
    fun bindModel(
        model: CPointer<GMenuModel>,
        action_namespace: String,
        with_separators: Boolean
    ): Unit = gtk_menu_shell_bind_model(self, model, action_namespace,
            if (with_separators) gtk_true() else gtk_false())

    /**
     * Cancels the selection within the menu shell.
     */
    fun cancel(): Unit = gtk_menu_shell_cancel(self)

    /**
     * Deactivates the menu shell.
     *
     * Typically this results in the menu shell being erased
     * from the screen.
     */
    fun deactivate(): Unit = gtk_menu_shell_deactivate(self)

    /**
     * Deselects the currently selected item from the menu shell,
     * if any.
     */
    fun deselect(): Unit = gtk_menu_shell_deselect(self)

    /**
     * Adds a new #GtkMenuItem to the menu shell’s item list
     * at the position indicated by @position.
     */
    fun insert(child: CPointer<GtkWidget>, position: Int): Unit = gtk_menu_shell_insert(self, child,
            position)

    /**
     * Adds a new #GtkMenuItem to the menu shell’s item list
     * at the position indicated by @position.
     */
    fun insert(child: Widget, position: Int): Unit = gtk_menu_shell_insert(self,
            child.widgetPtr?.reinterpret(), position)

    /**
     * Adds a new #GtkMenuItem to the beginning of the menu shell's
     * item list.
     */
    fun prepend(child: CPointer<GtkWidget>): Unit = gtk_menu_shell_prepend(self, child)

    /**
     * Adds a new #GtkMenuItem to the beginning of the menu shell's
     * item list.
     */
    fun prepend(child: Widget): Unit = gtk_menu_shell_prepend(self, child.widgetPtr?.reinterpret())

    /**
     * Select the first visible or selectable child of the menu shell;
     * don’t select tearoff items unless the only item is a tearoff
     * item.
     */
    fun selectFirst(search_sensitive: Boolean): Unit = gtk_menu_shell_select_first(self,
            if (search_sensitive) gtk_true() else gtk_false())

    /**
     * Selects the menu item from the menu shell.
     */
    fun selectItem(menu_item: CPointer<GtkWidget>): Unit = gtk_menu_shell_select_item(self,
            menu_item)

    /**
     * Selects the menu item from the menu shell.
     */
    fun selectItem(menu_item: Widget): Unit = gtk_menu_shell_select_item(self,
            menu_item.widgetPtr?.reinterpret())
}

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
import libgtk3.GFile
import libgtk3.GList
import libgtk3.GMountOperation
import libgtk3.GSList
import libgtk3.GVolume
import libgtk3.GdkDragContext
import libgtk3.GtkPlacesOpenFlags
import libgtk3.GtkPlacesSidebar
import libgtk3.GtkWidget
import libgtk3.gtk_false
import libgtk3.gtk_places_sidebar_add_shortcut
import libgtk3.gtk_places_sidebar_get_local_only
import libgtk3.gtk_places_sidebar_get_location
import libgtk3.gtk_places_sidebar_get_nth_bookmark
import libgtk3.gtk_places_sidebar_get_open_flags
import libgtk3.gtk_places_sidebar_get_show_desktop
import libgtk3.gtk_places_sidebar_get_show_enter_location
import libgtk3.gtk_places_sidebar_get_show_other_locations
import libgtk3.gtk_places_sidebar_get_show_recent
import libgtk3.gtk_places_sidebar_get_show_starred_location
import libgtk3.gtk_places_sidebar_get_show_trash
import libgtk3.gtk_places_sidebar_list_shortcuts
import libgtk3.gtk_places_sidebar_new
import libgtk3.gtk_places_sidebar_remove_shortcut
import libgtk3.gtk_places_sidebar_set_drop_targets_visible
import libgtk3.gtk_places_sidebar_set_local_only
import libgtk3.gtk_places_sidebar_set_location
import libgtk3.gtk_places_sidebar_set_open_flags
import libgtk3.gtk_places_sidebar_set_show_desktop
import libgtk3.gtk_places_sidebar_set_show_enter_location
import libgtk3.gtk_places_sidebar_set_show_other_locations
import libgtk3.gtk_places_sidebar_set_show_recent
import libgtk3.gtk_places_sidebar_set_show_starred_location
import libgtk3.gtk_places_sidebar_set_show_trash
import libgtk3.gtk_true

inline fun Container.placesSidebar(init: PlacesSidebar.() -> Unit = {}): PlacesSidebar =
        PlacesSidebar().apply { init(); this@placesSidebar.add(this) }

private fun PlacesSidebar_onDragActionAsk_Handler(
    sender: CPointer<in CPointed>?,
    actions: Int,
    _data: COpaquePointer?
) {
    _data?.asStableRef<PlacesSidebar>()?.get()?.onDragActionAsk?.emit(actions)
}

private fun PlacesSidebar_onDragActionRequested_Handler(
    sender: CPointer<in CPointed>?,
    context: CPointer<GdkDragContext>,
    dest_file: CPointer<GFile>,
    source_file_list: CPointer<GList>,
    _data: COpaquePointer?
) {
    _data?.asStableRef<PlacesSidebar>()?.get()?.onDragActionRequested?.emit(context?.reinterpret(),
            dest_file?.reinterpret(), source_file_list?.reinterpret())
}

private fun PlacesSidebar_onDragPerformDrop_Handler(
    sender: CPointer<in CPointed>?,
    dest_file: CPointer<GFile>,
    source_file_list: CPointer<GList>,
    action: Int,
    _data: COpaquePointer?
) {
    _data?.asStableRef<PlacesSidebar>()?.get()?.onDragPerformDrop?.emit(dest_file?.reinterpret(),
            source_file_list?.reinterpret(), action)
}

private fun PlacesSidebar_onMount_Handler(
    sender: CPointer<in CPointed>?,
    mount_operation: CPointer<GMountOperation>,
    _data: COpaquePointer?
) {
    _data?.asStableRef<PlacesSidebar>()?.get()?.onMount?.emit(mount_operation?.reinterpret())
}

private fun PlacesSidebar_onPopulatePopup_Handler(
    sender: CPointer<in CPointed>?,
    container: CPointer<GtkWidget>,
    selected_item: CPointer<GFile>,
    selected_volume: CPointer<GVolume>,
    _data: COpaquePointer?
) {
    _data?.asStableRef<PlacesSidebar>()?.get()?.onPopulatePopup?.emit(container?.reinterpret(),
            selected_item?.reinterpret(), selected_volume?.reinterpret())
}

private fun PlacesSidebar_onShowConnectToServer_Handler(sender: CPointer<in CPointed>?, _data:
        COpaquePointer?) {
    _data?.asStableRef<PlacesSidebar>()?.get()?.onShowConnectToServer?.emit()
}

private fun PlacesSidebar_onShowEnterLocation_Handler(sender: CPointer<in CPointed>?, _data:
        COpaquePointer?) {
    _data?.asStableRef<PlacesSidebar>()?.get()?.onShowEnterLocation?.emit()
}

private fun PlacesSidebar_onShowErrorMessage_Handler(
    sender: CPointer<in CPointed>?,
    primary: CPointer<ByteVar>,
    secondary: CPointer<ByteVar>,
    _data: COpaquePointer?
) {
    _data?.asStableRef<PlacesSidebar>()?.get()?.onShowErrorMessage?.emit(primary.toKString(),
            secondary.toKString())
}

private fun PlacesSidebar_onShowOtherLocations_Handler(sender: CPointer<in CPointed>?, _data:
        COpaquePointer?) {
    _data?.asStableRef<PlacesSidebar>()?.get()?.onShowOtherLocations?.emit()
}

private fun PlacesSidebar_onUnmount_Handler(
    sender: CPointer<in CPointed>?,
    mount_operation: CPointer<GMountOperation>,
    _data: COpaquePointer?
) {
    _data?.asStableRef<PlacesSidebar>()?.get()?.onUnmount?.emit(mount_operation?.reinterpret())
}

/**
 * #GtkPlacesSidebar is a widget that displays a list of frequently-used places in the
 * file system:  the user’s home directory, the user’s bookmarks, and volumes and drives.
 * This widget is used as a sidebar in #GtkFileChooser and may be used by file managers
 * and similar programs.
 *
 * The places sidebar displays drives and volumes, and will automatically mount
 * or unmount them when the user selects them.
 *
 * Applications can hook to various signals in the places sidebar to customize
 * its behavior.  For example, they can add extra commands to the context menu
 * of the sidebar.
 *
 * While bookmarks are completely in control of the user, the places sidebar also
 * allows individual applications to provide extra shortcut folders that are unique
 * to each application.  For example, a Paint program may want to add a shortcut
 * for a Clipart folder.  You can do this with gtk_places_sidebar_add_shortcut().
 *
 * To make use of the places sidebar, an application at least needs to connect
 * to the #GtkPlacesSidebar::open-location signal.  This is emitted when the
 * user selects in the sidebar a location to open.  The application should also
 * call gtk_places_sidebar_set_location() when it changes the currently-viewed
 * location.
 *
 * # CSS nodes
 *
 * GtkPlacesSidebar uses a single CSS node with name placessidebar and style
 * class .sidebar.
 *
 * Among the children of the places sidebar, the following style classes can
 * be used:
 * - .sidebar-new-bookmark-row for the 'Add new bookmark' row
 * - .sidebar-placeholder-row for a row that is a placeholder
 * - .has-open-popup when a popup is open for a row
 */
@GtkDsl
open class PlacesSidebar internal constructor(override val widgetPtr: CPointer<GtkWidget>? = null) :
        ScrolledWindow() {
    private val self: CPointer<GtkPlacesSidebar>?
        get() = widgetPtr!!.reinterpret()

    val placesSidebar: CPointer<GtkPlacesSidebar>?
        get() = widgetPtr!!.reinterpret()

    val onDragActionAsk: Signal1<PlacesSidebar, Int, CFunction<(
        CPointer<in CPointed>?,
        Int,
        COpaquePointer?
    ) -> Unit>> by lazy { Signal1<PlacesSidebar, Int, CFunction<(
                CPointer<in CPointed>?,
                Int,
                COpaquePointer?
            ) -> Unit>>(widgetPtr!!, this, "drag-action-ask",
                    staticCFunction(::PlacesSidebar_onDragActionAsk_Handler)) }

    val onDragActionRequested: Signal3<PlacesSidebar, CPointer<GdkDragContext>, CPointer<GFile>,
            CPointer<GList>, CFunction<(
        CPointer<in CPointed>?,
        CPointer<GdkDragContext>,
        CPointer<GFile>,
        CPointer<GList>,
        COpaquePointer?
    ) -> Unit>> by lazy { Signal3<PlacesSidebar, CPointer<GdkDragContext>, CPointer<GFile>,
            CPointer<GList>, CFunction<(
                CPointer<in CPointed>?,
                CPointer<GdkDragContext>,
                CPointer<GFile>,
                CPointer<GList>,
                COpaquePointer?
            ) -> Unit>>(widgetPtr!!, this, "drag-action-requested",
                    staticCFunction(::PlacesSidebar_onDragActionRequested_Handler)) }

    val onDragPerformDrop: Signal3<PlacesSidebar, CPointer<GFile>, CPointer<GList>, Int, CFunction<(
        CPointer<in CPointed>?,
        CPointer<GFile>,
        CPointer<GList>,
        Int,
        COpaquePointer?
    ) -> Unit>> by lazy { Signal3<PlacesSidebar, CPointer<GFile>, CPointer<GList>, Int, CFunction<(
                CPointer<in CPointed>?,
                CPointer<GFile>,
                CPointer<GList>,
                Int,
                COpaquePointer?
            ) -> Unit>>(widgetPtr!!, this, "drag-perform-drop",
                    staticCFunction(::PlacesSidebar_onDragPerformDrop_Handler)) }

    val onMount: Signal1<PlacesSidebar, CPointer<GMountOperation>, CFunction<(
        CPointer<in CPointed>?,
        CPointer<GMountOperation>,
        COpaquePointer?
    ) -> Unit>> by lazy { Signal1<PlacesSidebar, CPointer<GMountOperation>, CFunction<(
                CPointer<in CPointed>?,
                CPointer<GMountOperation>,
                COpaquePointer?
            ) -> Unit>>(widgetPtr!!, this, "mount",
                    staticCFunction(::PlacesSidebar_onMount_Handler)) }

    val onPopulatePopup: Signal3<PlacesSidebar, CPointer<GtkWidget>, CPointer<GFile>,
            CPointer<GVolume>, CFunction<(
        CPointer<in CPointed>?,
        CPointer<GtkWidget>,
        CPointer<GFile>,
        CPointer<GVolume>,
        COpaquePointer?
    ) -> Unit>> by lazy { Signal3<PlacesSidebar, CPointer<GtkWidget>, CPointer<GFile>,
            CPointer<GVolume>, CFunction<(
                CPointer<in CPointed>?,
                CPointer<GtkWidget>,
                CPointer<GFile>,
                CPointer<GVolume>,
                COpaquePointer?
            ) -> Unit>>(widgetPtr!!, this, "populate-popup",
                    staticCFunction(::PlacesSidebar_onPopulatePopup_Handler)) }

    val onShowConnectToServer: Signal<PlacesSidebar, CFunction<(CPointer<in CPointed>?,
            COpaquePointer?) -> Unit>> by lazy { Signal<PlacesSidebar, CFunction<(CPointer<in
            CPointed>?, COpaquePointer?) -> Unit>>(widgetPtr!!, this, "show-connect-to-server",
            staticCFunction(::PlacesSidebar_onShowConnectToServer_Handler)) }

    val onShowEnterLocation: Signal<PlacesSidebar, CFunction<(CPointer<in CPointed>?,
            COpaquePointer?) -> Unit>> by lazy { Signal<PlacesSidebar, CFunction<(CPointer<in
            CPointed>?, COpaquePointer?) -> Unit>>(widgetPtr!!, this, "show-enter-location",
            staticCFunction(::PlacesSidebar_onShowEnterLocation_Handler)) }

    val onShowErrorMessage: Signal2<PlacesSidebar, String, String, CFunction<(
        CPointer<in CPointed>?,
        CPointer<ByteVar>,
        CPointer<ByteVar>,
        COpaquePointer?
    ) -> Unit>> by lazy { Signal2<PlacesSidebar, String, String, CFunction<(
                CPointer<in CPointed>?,
                CPointer<ByteVar>,
                CPointer<ByteVar>,
                COpaquePointer?
            ) -> Unit>>(widgetPtr!!, this, "show-error-message",
                    staticCFunction(::PlacesSidebar_onShowErrorMessage_Handler)) }

    val onShowOtherLocations: Signal<PlacesSidebar, CFunction<(CPointer<in CPointed>?,
            COpaquePointer?) -> Unit>> by lazy { Signal<PlacesSidebar, CFunction<(CPointer<in
            CPointed>?, COpaquePointer?) -> Unit>>(widgetPtr!!, this, "show-other-locations",
            staticCFunction(::PlacesSidebar_onShowOtherLocations_Handler)) }

    val onUnmount: Signal1<PlacesSidebar, CPointer<GMountOperation>, CFunction<(
        CPointer<in CPointed>?,
        CPointer<GMountOperation>,
        COpaquePointer?
    ) -> Unit>> by lazy { Signal1<PlacesSidebar, CPointer<GMountOperation>, CFunction<(
                CPointer<in CPointed>?,
                CPointer<GMountOperation>,
                COpaquePointer?
            ) -> Unit>>(widgetPtr!!, this, "unmount",
                    staticCFunction(::PlacesSidebar_onUnmount_Handler)) }

    /**
     * Returns the value previously set with gtk_places_sidebar_set_local_only().
     *
     * Sets whether the @sidebar should only show local files. */
    var localOnly: Boolean
        get() = gtk_places_sidebar_get_local_only(self) != 0
        set(value) {
            gtk_places_sidebar_set_local_only(self, if (value) gtk_true() else gtk_false())
        }

    /**
     * Gets the currently selected location in the @sidebar. This can be %NULL when
     * nothing is selected, for example, when gtk_places_sidebar_set_location() has
     * been called with a location that is not among the sidebar’s list of places to
     * show.
     *
     * You can use this function to get the selection in the @sidebar.  Also, if you
     * connect to the #GtkPlacesSidebar::populate-popup signal, you can use this
     * function to get the location that is being referred to during the callbacks
     * for your menu items.
     *
     * Sets the location that is being shown in the widgets surrounding the
     * @sidebar, for example, in a folder view in a file manager.  In turn, the
     * @sidebar will highlight that location if it is being shown in the list of
     * places, or it will unhighlight everything if the @location is not among the
     * places in the list. */
    var location: CPointer<GFile>
        get() = gtk_places_sidebar_get_location(self)!!.reinterpret()
        set(value) {
            gtk_places_sidebar_set_location(self, value?.reinterpret())
        }

    /**
     * Gets the open flags.
     *
     * Sets the way in which the calling application can open new locations from
     * the places sidebar.  For example, some applications only open locations
     * “directly” into their main view, while others may support opening locations
     * in a new notebook tab or a new window.
     *
     * This function is used to tell the places @sidebar about the ways in which the
     * application can open new locations, so that the sidebar can display (or not)
     * the “Open in new tab” and “Open in new window” menu items as appropriate.
     *
     * When the #GtkPlacesSidebar::open-location signal is emitted, its flags
     * argument will be set to one of the @flags that was passed in
     * gtk_places_sidebar_set_open_flags().
     *
     * Passing 0 for @flags will cause #GTK_PLACES_OPEN_NORMAL to always be sent
     * to callbacks for the “open-location” signal. */
    var openFlags: GtkPlacesOpenFlags
        get() = gtk_places_sidebar_get_open_flags(self)
        set(value) {
            gtk_places_sidebar_set_open_flags(self, value)
        }

    /**
     * Returns the value previously set with gtk_places_sidebar_set_show_desktop()
     *
     * Sets whether the @sidebar should show an item for the Desktop folder.
     * The default value for this option is determined by the desktop
     * environment and the user’s configuration, but this function can be
     * used to override it on a per-application basis. */
    var showDesktop: Boolean
        get() = gtk_places_sidebar_get_show_desktop(self) != 0
        set(value) {
            gtk_places_sidebar_set_show_desktop(self, if (value) gtk_true() else gtk_false())
        }

    /**
     * Returns the value previously set with gtk_places_sidebar_set_show_enter_location()
     *
     * Sets whether the @sidebar should show an item for entering a location;
     * this is off by default. An application may want to turn this on if manually
     * entering URLs is an expected user action.
     *
     * If you enable this, you should connect to the
     * #GtkPlacesSidebar::show-enter-location signal. */
    var showEnterLocation: Boolean
        get() = gtk_places_sidebar_get_show_enter_location(self) != 0
        set(value) {
            gtk_places_sidebar_set_show_enter_location(self, if (value) gtk_true() else gtk_false())
        }

    /**
     * Returns the value previously set with gtk_places_sidebar_set_show_other_locations()
     *
     * Sets whether the @sidebar should show an item for the application to show
     * an Other Locations view; this is off by default. When set to %TRUE, persistent
     * devices such as hard drives are hidden, otherwise they are shown in the sidebar.
     * An application may want to turn this on if it implements a way for the user to
     * see and interact with drives and network servers directly.
     *
     * If you enable this, you should connect to the
     * #GtkPlacesSidebar::show-other-locations signal. */
    var showOtherLocations: Boolean
        get() = gtk_places_sidebar_get_show_other_locations(self) != 0
        set(value) {
            gtk_places_sidebar_set_show_other_locations(self,
                    if (value) gtk_true() else gtk_false())
        }

    /**
     * Returns the value previously set with gtk_places_sidebar_set_show_recent()
     *
     * Sets whether the @sidebar should show an item for recent files.
     * The default value for this option is determined by the desktop
     * environment, but this function can be used to override it on a
     * per-application basis. */
    var showRecent: Boolean
        get() = gtk_places_sidebar_get_show_recent(self) != 0
        set(value) {
            gtk_places_sidebar_set_show_recent(self, if (value) gtk_true() else gtk_false())
        }

    /**
     * Returns the value previously set with gtk_places_sidebar_set_show_starred_location()
     *
     * If you enable this, you should connect to the
     * #GtkPlacesSidebar::show-starred-location signal. */
    var showStarredLocation: Boolean
        get() = gtk_places_sidebar_get_show_starred_location(self) != 0
        set(value) {
            gtk_places_sidebar_set_show_starred_location(self,
                    if (value) gtk_true() else gtk_false())
        }

    /**
     * Returns the value previously set with gtk_places_sidebar_set_show_trash()
     *
     * Sets whether the @sidebar should show an item for the Trash location. */
    var showTrash: Boolean
        get() = gtk_places_sidebar_get_show_trash(self) != 0
        set(value) {
            gtk_places_sidebar_set_show_trash(self, if (value) gtk_true() else gtk_false())
        }

    /**
     * Creates a new #GtkPlacesSidebar widget.
     *
     * The application should connect to at least the
     * #GtkPlacesSidebar::open-location signal to be notified
     * when the user makes a selection in the sidebar. */
    constructor() : this(gtk_places_sidebar_new()?.reinterpret())

    /**
     * Applications may want to present some folders in the places sidebar if
     * they could be immediately useful to users.  For example, a drawing
     * program could add a “/usr/share/clipart” location when the sidebar is
     * being used in an “Insert Clipart” dialog box.
     *
     * This function adds the specified @location to a special place for immutable
     * shortcuts.  The shortcuts are application-specific; they are not shared
     * across applications, and they are not persistent.  If this function
     * is called multiple times with different locations, then they are added
     * to the sidebar’s list in the same order as the function is called.
     */
    fun addShortcut(location: CPointer<GFile>): Unit = gtk_places_sidebar_add_shortcut(self,
            location)

    /**
     * This function queries the bookmarks added by the user to the places sidebar,
     * and returns one of them.  This function is used by #GtkFileChooser to implement
     * the “Alt-1”, “Alt-2”, etc. shortcuts, which activate the cooresponding bookmark.
     */
    fun getNthBookmark(n: Int): CPointer<GFile> = gtk_places_sidebar_get_nth_bookmark(self,
            n)!!.reinterpret()

    /**
     * Gets the list of shortcuts.
     */
    fun listShortcuts(): CPointer<GSList> = gtk_places_sidebar_list_shortcuts(self)!!.reinterpret()

    /**
     * Removes an application-specific shortcut that has been previously been
     * inserted with gtk_places_sidebar_add_shortcut().  If the @location is not a
     * shortcut in the sidebar, then nothing is done.
     */
    fun removeShortcut(location: CPointer<GFile>): Unit = gtk_places_sidebar_remove_shortcut(self,
            location)

    /**
     * Make the GtkPlacesSidebar show drop targets, so it can show the available
     * drop targets and a "new bookmark" row. This improves the Drag-and-Drop
     * experience of the user and allows applications to show all available
     * drop targets at once.
     *
     * This needs to be called when the application is aware of an ongoing drag
     * that might target the sidebar. The drop-targets-visible state will be unset
     * automatically if the drag finishes in the GtkPlacesSidebar. You only need
     * to unset the state when the drag ends on some other widget on your application.
     */
    fun setDropTargetsVisible(visible: Boolean, context: CPointer<GdkDragContext>): Unit =
            gtk_places_sidebar_set_drop_targets_visible(self,
            if (visible) gtk_true() else gtk_false(), context)
}

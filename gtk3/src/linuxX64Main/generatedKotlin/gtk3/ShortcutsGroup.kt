package gtk3

import kotlinx.cinterop.CPointer
import kotlinx.cinterop.reinterpret
import libgtk3.GtkShortcutsGroup

/**
 * A GtkShortcutsGroup represents a group of related keyboard shortcuts
 * or gestures. The group has a title. It may optionally be associated with
 * a view of the application, which can be used to show only relevant shortcuts
 * depending on the application context.
 *
 * This widget is only meant to be used with #GtkShortcutsWindow. */
@GtkDsl
abstract class ShortcutsGroup : Box() {
    private val self: CPointer<GtkShortcutsGroup>
        get() = widgetPtr!!.reinterpret()
}

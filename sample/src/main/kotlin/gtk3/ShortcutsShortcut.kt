package gtk3

import kotlinx.cinterop.CPointer
import kotlinx.cinterop.reinterpret
import libgtk3.GtkShortcutsShortcut

/**
 * A GtkShortcutsShortcut represents a single keyboard shortcut or gesture
 * with a short text. This widget is only meant to be used with #GtkShortcutsWindow. */
@GtkDsl
abstract class ShortcutsShortcut : Box() {
    private val self: CPointer<GtkShortcutsShortcut>
        get() = widgetPtr!!.reinterpret()
}

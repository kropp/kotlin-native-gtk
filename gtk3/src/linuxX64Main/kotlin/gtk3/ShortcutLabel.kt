package gtk3

import kotlin.String
import kotlin.Unit
import kotlinx.cinterop.CPointer
import kotlinx.cinterop.reinterpret
import kotlinx.cinterop.toKString
import libgtk3.GtkShortcutLabel
import libgtk3.GtkWidget
import libgtk3.gtk_shortcut_label_get_accelerator
import libgtk3.gtk_shortcut_label_get_disabled_text
import libgtk3.gtk_shortcut_label_new
import libgtk3.gtk_shortcut_label_set_accelerator
import libgtk3.gtk_shortcut_label_set_disabled_text

inline fun Container.shortcutLabel(accelerator: String, init: ShortcutLabel.() -> Unit = {}):
        ShortcutLabel = ShortcutLabel(accelerator).apply { init(); this@shortcutLabel.add(this) }

/**
 * #GtkShortcutLabel is a widget that represents a single keyboard shortcut or gesture
 * in the user interface.
 */
@GtkDsl
open class ShortcutLabel internal constructor(override val widgetPtr: CPointer<GtkWidget>? = null) :
        Box() {
    private val self: CPointer<GtkShortcutLabel>?
        get() = widgetPtr!!.reinterpret()

    val shortcutLabel: CPointer<GtkShortcutLabel>?
        get() = widgetPtr!!.reinterpret()

    /**
     * Retrieves the current accelerator of @self.
     *
     * Sets the accelerator to be displayed by @self. */
    var accelerator: String
        get() = gtk_shortcut_label_get_accelerator(self)?.toKString() ?: ""
        set(value) {
            gtk_shortcut_label_set_accelerator(self, value)
        }

    /**
     * Retrieves the text that is displayed when no accelerator is set.
     *
     * Sets the text to be displayed by @self when no accelerator is set. */
    var disabledText: String
        get() = gtk_shortcut_label_get_disabled_text(self)?.toKString() ?: ""
        set(value) {
            gtk_shortcut_label_set_disabled_text(self, value)
        }

    /**
     * Creates a new #GtkShortcutLabel with @accelerator set. */
    constructor(accelerator: String) : this(gtk_shortcut_label_new(accelerator)?.reinterpret())
}

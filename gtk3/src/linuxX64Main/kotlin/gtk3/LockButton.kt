package gtk3

import kotlin.Unit
import kotlinx.cinterop.CPointer
import kotlinx.cinterop.reinterpret
import libgtk3.GPermission
import libgtk3.GtkLockButton
import libgtk3.GtkWidget
import libgtk3.gtk_lock_button_get_permission
import libgtk3.gtk_lock_button_new
import libgtk3.gtk_lock_button_set_permission

inline fun Container.lockButton(permission: CPointer<GPermission>, init: LockButton.() -> Unit =
        {}): LockButton = LockButton(permission).apply { init(); this@lockButton.add(this) }

/**
 * GtkLockButton is a widget that can be used in control panels or
 * preference dialogs to allow users to obtain and revoke authorizations
 * needed to operate the controls. The required authorization is represented
 * by a #GPermission object. Concrete implementations of #GPermission may use
 * PolicyKit or some other authorization framework. To obtain a PolicyKit-based
 * #GPermission, use polkit_permission_new().
 *
 * If the user is not currently allowed to perform the action, but can obtain
 * the permission, the widget looks like this:
 *
 * ![](lockbutton-locked.png)
 *
 * and the user can click the button to request the permission. Depending
 * on the platform, this may pop up an authentication dialog or ask the user
 * to authenticate in some other way. Once the user has obtained the permission,
 * the widget changes to this:
 *
 * ![](lockbutton-unlocked.png)
 *
 * and the permission can be dropped again by clicking the button. If the user
 * is not able to obtain the permission at all, the widget looks like this:
 *
 * ![](lockbutton-sorry.png)
 *
 * If the user has the permission and cannot drop it, the button is hidden.
 *
 * The text (and tooltips) that are shown in the various cases can be adjusted
 * with the #GtkLockButton:text-lock, #GtkLockButton:text-unlock,
 * #GtkLockButton:tooltip-lock, #GtkLockButton:tooltip-unlock and
 * #GtkLockButton:tooltip-not-authorized properties.
 */
@GtkDsl
open class LockButton internal constructor(override val widgetPtr: CPointer<GtkWidget>? = null) :
        Button() {
    private val self: CPointer<GtkLockButton>?
        get() = widgetPtr!!.reinterpret()

    val lockButton: CPointer<GtkLockButton>?
        get() = widgetPtr!!.reinterpret()

    /**
     * Obtains the #GPermission object that controls @button.
     *
     * Sets the #GPermission object that controls @button. */
    var permission: CPointer<GPermission>
        get() = gtk_lock_button_get_permission(self)!!.reinterpret()
        set(value) {
            gtk_lock_button_set_permission(self, value?.reinterpret())
        }

    /**
     * Creates a new lock button which reflects the @permission. */
    constructor(permission: CPointer<GPermission>) :
            this(gtk_lock_button_new(permission?.reinterpret())?.reinterpret())
}

package gtk3

import kotlin.Int
import kotlin.Unit
import kotlinx.cinterop.CFunction
import kotlinx.cinterop.COpaquePointer
import kotlinx.cinterop.CPointed
import kotlinx.cinterop.CPointer
import kotlinx.cinterop.asStableRef
import kotlinx.cinterop.reinterpret
import kotlinx.cinterop.staticCFunction
import libgtk3.GtkShortcutsSection

private fun ShortcutsSection_onChangeCurrentPage_Handler(
    sender: CPointer<in CPointed>?,
    `object`: Int,
    _data: COpaquePointer?
) {
    _data?.asStableRef<ShortcutsSection>()?.get()?.onChangeCurrentPage?.emit(`object`)
}

/**
 * A GtkShortcutsSection collects all the keyboard shortcuts and gestures
 * for a major application mode. If your application needs multiple sections,
 * you should give each section a unique #GtkShortcutsSection:section-name and
 * a #GtkShortcutsSection:title that can be shown in the section selector of
 * the GtkShortcutsWindow.
 *
 * The #GtkShortcutsSection:max-height property can be used to influence how
 * the groups in the section are distributed over pages and columns.
 *
 * This widget is only meant to be used with #GtkShortcutsWindow. */
@GtkDsl
abstract class ShortcutsSection : Box() {
    private val self: CPointer<GtkShortcutsSection>
        get() = widgetPtr!!.reinterpret()

    val onChangeCurrentPage: Signal1<ShortcutsSection, Int, CFunction<(
        CPointer<in CPointed>?,
        Int,
        COpaquePointer?
    ) -> Unit>> by lazy { Signal1<ShortcutsSection, Int, CFunction<(
                CPointer<in CPointed>?,
                Int,
                COpaquePointer?
            ) -> Unit>>(widgetPtr!!, this, "change-current-page",
                    staticCFunction(::ShortcutsSection_onChangeCurrentPage_Handler)) }
}

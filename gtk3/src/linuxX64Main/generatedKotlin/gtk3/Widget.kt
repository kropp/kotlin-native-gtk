package gtk3

import kotlin.Boolean
import kotlin.Double
import kotlin.Int
import kotlin.String
import kotlin.UInt
import kotlin.Unit
import kotlin.collections.List
import kotlinx.cinterop.CFunction
import kotlinx.cinterop.COpaquePointer
import kotlinx.cinterop.CPointed
import kotlinx.cinterop.CPointer
import kotlinx.cinterop.asStableRef
import kotlinx.cinterop.reinterpret
import kotlinx.cinterop.staticCFunction
import kotlinx.cinterop.toKString
import libgtk3.GActionGroup
import libgtk3.GIcon
import libgtk3.GList
import libgtk3.GdkDevice
import libgtk3.GdkDisplay
import libgtk3.GdkDragAction
import libgtk3.GdkDragContext
import libgtk3.GdkEvent
import libgtk3.GdkEventAny
import libgtk3.GdkEventButton
import libgtk3.GdkEventConfigure
import libgtk3.GdkEventCrossing
import libgtk3.GdkEventExpose
import libgtk3.GdkEventFocus
import libgtk3.GdkEventGrabBroken
import libgtk3.GdkEventKey
import libgtk3.GdkEventMask
import libgtk3.GdkEventMotion
import libgtk3.GdkEventProperty
import libgtk3.GdkEventProximity
import libgtk3.GdkEventScroll
import libgtk3.GdkEventSelection
import libgtk3.GdkEventVisibility
import libgtk3.GdkEventWindowState
import libgtk3.GdkFrameClock
import libgtk3.GdkModifierIntent
import libgtk3.GdkModifierType
import libgtk3.GdkPixbuf
import libgtk3.GdkScreen
import libgtk3.GdkVisual
import libgtk3.GdkWindow
import libgtk3.GtkAccelFlags
import libgtk3.GtkAccelGroup
import libgtk3.GtkAlign
import libgtk3.GtkAllocation
import libgtk3.GtkDirectionType
import libgtk3.GtkOrientation
import libgtk3.GtkSelectionData
import libgtk3.GtkSettings
import libgtk3.GtkSizeRequestMode
import libgtk3.GtkStateFlags
import libgtk3.GtkStyle
import libgtk3.GtkStyleContext
import libgtk3.GtkTargetList
import libgtk3.GtkTooltip
import libgtk3.GtkWidget
import libgtk3.GtkWidgetPath
import libgtk3.GtkWindow
import libgtk3.gtk_drag_begin_with_coordinates
import libgtk3.gtk_drag_check_threshold
import libgtk3.gtk_drag_dest_add_image_targets
import libgtk3.gtk_drag_dest_add_text_targets
import libgtk3.gtk_drag_dest_add_uri_targets
import libgtk3.gtk_drag_dest_get_target_list
import libgtk3.gtk_drag_dest_get_track_motion
import libgtk3.gtk_drag_dest_set_target_list
import libgtk3.gtk_drag_dest_set_track_motion
import libgtk3.gtk_drag_dest_unset
import libgtk3.gtk_drag_highlight
import libgtk3.gtk_drag_source_add_image_targets
import libgtk3.gtk_drag_source_add_text_targets
import libgtk3.gtk_drag_source_add_uri_targets
import libgtk3.gtk_drag_source_get_target_list
import libgtk3.gtk_drag_source_set_icon_gicon
import libgtk3.gtk_drag_source_set_icon_name
import libgtk3.gtk_drag_source_set_icon_pixbuf
import libgtk3.gtk_drag_source_set_target_list
import libgtk3.gtk_drag_source_unset
import libgtk3.gtk_drag_unhighlight
import libgtk3.gtk_false
import libgtk3.gtk_grab_add
import libgtk3.gtk_grab_remove
import libgtk3.gtk_true
import libgtk3.gtk_widget_add_accelerator
import libgtk3.gtk_widget_add_device_events
import libgtk3.gtk_widget_add_events
import libgtk3.gtk_widget_add_mnemonic_label
import libgtk3.gtk_widget_can_activate_accel
import libgtk3.gtk_widget_child_focus
import libgtk3.gtk_widget_child_notify
import libgtk3.gtk_widget_compute_expand
import libgtk3.gtk_widget_destroy
import libgtk3.gtk_widget_device_is_shadowed
import libgtk3.gtk_widget_error_bell
import libgtk3.gtk_widget_event
import libgtk3.gtk_widget_freeze_child_notify
import libgtk3.gtk_widget_get_action_group
import libgtk3.gtk_widget_get_allocated_baseline
import libgtk3.gtk_widget_get_allocated_height
import libgtk3.gtk_widget_get_allocated_width
import libgtk3.gtk_widget_get_app_paintable
import libgtk3.gtk_widget_get_can_default
import libgtk3.gtk_widget_get_can_focus
import libgtk3.gtk_widget_get_child_visible
import libgtk3.gtk_widget_get_device_enabled
import libgtk3.gtk_widget_get_device_events
import libgtk3.gtk_widget_get_display
import libgtk3.gtk_widget_get_double_buffered
import libgtk3.gtk_widget_get_events
import libgtk3.gtk_widget_get_focus_on_click
import libgtk3.gtk_widget_get_frame_clock
import libgtk3.gtk_widget_get_halign
import libgtk3.gtk_widget_get_has_tooltip
import libgtk3.gtk_widget_get_has_window
import libgtk3.gtk_widget_get_hexpand
import libgtk3.gtk_widget_get_hexpand_set
import libgtk3.gtk_widget_get_mapped
import libgtk3.gtk_widget_get_margin_bottom
import libgtk3.gtk_widget_get_margin_end
import libgtk3.gtk_widget_get_margin_start
import libgtk3.gtk_widget_get_margin_top
import libgtk3.gtk_widget_get_modifier_mask
import libgtk3.gtk_widget_get_name
import libgtk3.gtk_widget_get_no_show_all
import libgtk3.gtk_widget_get_opacity
import libgtk3.gtk_widget_get_parent
import libgtk3.gtk_widget_get_parent_window
import libgtk3.gtk_widget_get_path
import libgtk3.gtk_widget_get_realized
import libgtk3.gtk_widget_get_receives_default
import libgtk3.gtk_widget_get_request_mode
import libgtk3.gtk_widget_get_scale_factor
import libgtk3.gtk_widget_get_sensitive
import libgtk3.gtk_widget_get_settings
import libgtk3.gtk_widget_get_state_flags
import libgtk3.gtk_widget_get_style_context
import libgtk3.gtk_widget_get_support_multidevice
import libgtk3.gtk_widget_get_tooltip_markup
import libgtk3.gtk_widget_get_tooltip_text
import libgtk3.gtk_widget_get_tooltip_window
import libgtk3.gtk_widget_get_toplevel
import libgtk3.gtk_widget_get_valign
import libgtk3.gtk_widget_get_valign_with_baseline
import libgtk3.gtk_widget_get_vexpand
import libgtk3.gtk_widget_get_vexpand_set
import libgtk3.gtk_widget_get_visible
import libgtk3.gtk_widget_get_visual
import libgtk3.gtk_widget_get_window
import libgtk3.gtk_widget_grab_default
import libgtk3.gtk_widget_grab_focus
import libgtk3.gtk_widget_has_default
import libgtk3.gtk_widget_has_focus
import libgtk3.gtk_widget_has_grab
import libgtk3.gtk_widget_has_screen
import libgtk3.gtk_widget_has_visible_focus
import libgtk3.gtk_widget_hide
import libgtk3.gtk_widget_hide_on_delete
import libgtk3.gtk_widget_in_destruction
import libgtk3.gtk_widget_init_template
import libgtk3.gtk_widget_insert_action_group
import libgtk3.gtk_widget_is_ancestor
import libgtk3.gtk_widget_is_drawable
import libgtk3.gtk_widget_is_focus
import libgtk3.gtk_widget_is_sensitive
import libgtk3.gtk_widget_is_toplevel
import libgtk3.gtk_widget_is_visible
import libgtk3.gtk_widget_keynav_failed
import libgtk3.gtk_widget_list_accel_closures
import libgtk3.gtk_widget_list_action_prefixes
import libgtk3.gtk_widget_list_mnemonic_labels
import libgtk3.gtk_widget_map
import libgtk3.gtk_widget_mnemonic_activate
import libgtk3.gtk_widget_queue_allocate
import libgtk3.gtk_widget_queue_compute_expand
import libgtk3.gtk_widget_queue_draw
import libgtk3.gtk_widget_queue_draw_area
import libgtk3.gtk_widget_queue_resize
import libgtk3.gtk_widget_queue_resize_no_redraw
import libgtk3.gtk_widget_realize
import libgtk3.gtk_widget_register_window
import libgtk3.gtk_widget_remove_accelerator
import libgtk3.gtk_widget_remove_mnemonic_label
import libgtk3.gtk_widget_remove_tick_callback
import libgtk3.gtk_widget_reset_style
import libgtk3.gtk_widget_send_focus_change
import libgtk3.gtk_widget_set_accel_path
import libgtk3.gtk_widget_set_allocation
import libgtk3.gtk_widget_set_app_paintable
import libgtk3.gtk_widget_set_can_default
import libgtk3.gtk_widget_set_can_focus
import libgtk3.gtk_widget_set_child_visible
import libgtk3.gtk_widget_set_clip
import libgtk3.gtk_widget_set_device_enabled
import libgtk3.gtk_widget_set_device_events
import libgtk3.gtk_widget_set_events
import libgtk3.gtk_widget_set_focus_on_click
import libgtk3.gtk_widget_set_halign
import libgtk3.gtk_widget_set_has_tooltip
import libgtk3.gtk_widget_set_has_window
import libgtk3.gtk_widget_set_hexpand
import libgtk3.gtk_widget_set_hexpand_set
import libgtk3.gtk_widget_set_mapped
import libgtk3.gtk_widget_set_margin_bottom
import libgtk3.gtk_widget_set_margin_end
import libgtk3.gtk_widget_set_margin_start
import libgtk3.gtk_widget_set_margin_top
import libgtk3.gtk_widget_set_name
import libgtk3.gtk_widget_set_no_show_all
import libgtk3.gtk_widget_set_opacity
import libgtk3.gtk_widget_set_parent
import libgtk3.gtk_widget_set_parent_window
import libgtk3.gtk_widget_set_realized
import libgtk3.gtk_widget_set_receives_default
import libgtk3.gtk_widget_set_redraw_on_allocate
import libgtk3.gtk_widget_set_sensitive
import libgtk3.gtk_widget_set_size_request
import libgtk3.gtk_widget_set_state_flags
import libgtk3.gtk_widget_set_support_multidevice
import libgtk3.gtk_widget_set_tooltip_markup
import libgtk3.gtk_widget_set_tooltip_text
import libgtk3.gtk_widget_set_tooltip_window
import libgtk3.gtk_widget_set_valign
import libgtk3.gtk_widget_set_vexpand
import libgtk3.gtk_widget_set_vexpand_set
import libgtk3.gtk_widget_set_visible
import libgtk3.gtk_widget_set_visual
import libgtk3.gtk_widget_set_window
import libgtk3.gtk_widget_show
import libgtk3.gtk_widget_show_all
import libgtk3.gtk_widget_show_now
import libgtk3.gtk_widget_size_allocate
import libgtk3.gtk_widget_size_allocate_with_baseline
import libgtk3.gtk_widget_style_get
import libgtk3.gtk_widget_thaw_child_notify
import libgtk3.gtk_widget_trigger_tooltip_query
import libgtk3.gtk_widget_unmap
import libgtk3.gtk_widget_unparent
import libgtk3.gtk_widget_unrealize
import libgtk3.gtk_widget_unregister_window
import libgtk3.gtk_widget_unset_state_flags

private fun Widget_onAccelClosuresChanged_Handler(sender: CPointer<in CPointed>?, _data:
        COpaquePointer?) {
    _data?.asStableRef<Widget>()?.get()?.onAccelClosuresChanged?.emit()
}

private fun Widget_onButtonPressEvent_Handler(
    sender: CPointer<in CPointed>?,
    event: CPointer<GdkEventButton>,
    _data: COpaquePointer?
) {
    _data?.asStableRef<Widget>()?.get()?.onButtonPressEvent?.emit(event?.reinterpret())
}

private fun Widget_onButtonReleaseEvent_Handler(
    sender: CPointer<in CPointed>?,
    event: CPointer<GdkEventButton>,
    _data: COpaquePointer?
) {
    _data?.asStableRef<Widget>()?.get()?.onButtonReleaseEvent?.emit(event?.reinterpret())
}

private fun Widget_onCanActivateAccel_Handler(
    sender: CPointer<in CPointed>?,
    signal_id: UInt,
    _data: COpaquePointer?
) {
    _data?.asStableRef<Widget>()?.get()?.onCanActivateAccel?.emit(signal_id)
}

private fun Widget_onCompositedChanged_Handler(sender: CPointer<in CPointed>?, _data:
        COpaquePointer?) {
    _data?.asStableRef<Widget>()?.get()?.onCompositedChanged?.emit()
}

private fun Widget_onConfigureEvent_Handler(
    sender: CPointer<in CPointed>?,
    event: CPointer<GdkEventConfigure>,
    _data: COpaquePointer?
) {
    _data?.asStableRef<Widget>()?.get()?.onConfigureEvent?.emit(event?.reinterpret())
}

private fun Widget_onDamageEvent_Handler(
    sender: CPointer<in CPointed>?,
    event: CPointer<GdkEventExpose>,
    _data: COpaquePointer?
) {
    _data?.asStableRef<Widget>()?.get()?.onDamageEvent?.emit(event?.reinterpret())
}

private fun Widget_onDeleteEvent_Handler(
    sender: CPointer<in CPointed>?,
    event: CPointer<GdkEvent>,
    _data: COpaquePointer?
) {
    _data?.asStableRef<Widget>()?.get()?.onDeleteEvent?.emit(event?.reinterpret())
}

private fun Widget_onDestroy_Handler(sender: CPointer<in CPointed>?, _data: COpaquePointer?) {
    _data?.asStableRef<Widget>()?.get()?.onDestroy?.emit()
}

private fun Widget_onDestroyEvent_Handler(
    sender: CPointer<in CPointed>?,
    event: CPointer<GdkEvent>,
    _data: COpaquePointer?
) {
    _data?.asStableRef<Widget>()?.get()?.onDestroyEvent?.emit(event?.reinterpret())
}

private fun Widget_onDragBegin_Handler(
    sender: CPointer<in CPointed>?,
    context: CPointer<GdkDragContext>,
    _data: COpaquePointer?
) {
    _data?.asStableRef<Widget>()?.get()?.onDragBegin?.emit(context?.reinterpret())
}

private fun Widget_onDragDataDelete_Handler(
    sender: CPointer<in CPointed>?,
    context: CPointer<GdkDragContext>,
    _data: COpaquePointer?
) {
    _data?.asStableRef<Widget>()?.get()?.onDragDataDelete?.emit(context?.reinterpret())
}

private fun Widget_onDragDataGet_Handler(
    sender: CPointer<in CPointed>?,
    context: CPointer<GdkDragContext>,
    data: CPointer<GtkSelectionData>,
    info: UInt,
    time: UInt,
    _data: COpaquePointer?
) {
    _data?.asStableRef<Widget>()?.get()?.onDragDataGet?.emit(context?.reinterpret(),
            data?.reinterpret(), info, time)
}

private fun Widget_onDragDataReceived_Handler(
    sender: CPointer<in CPointed>?,
    context: CPointer<GdkDragContext>,
    x: Int,
    y: Int,
    data: CPointer<GtkSelectionData>,
    info: UInt,
    time: UInt,
    _data: COpaquePointer?
) {
    _data?.asStableRef<Widget>()?.get()?.onDragDataReceived?.emit(context?.reinterpret(), x, y,
            data?.reinterpret(), info, time)
}

private fun Widget_onDragDrop_Handler(
    sender: CPointer<in CPointed>?,
    context: CPointer<GdkDragContext>,
    x: Int,
    y: Int,
    time: UInt,
    _data: COpaquePointer?
) {
    _data?.asStableRef<Widget>()?.get()?.onDragDrop?.emit(context?.reinterpret(), x, y, time)
}

private fun Widget_onDragEnd_Handler(
    sender: CPointer<in CPointed>?,
    context: CPointer<GdkDragContext>,
    _data: COpaquePointer?
) {
    _data?.asStableRef<Widget>()?.get()?.onDragEnd?.emit(context?.reinterpret())
}

private fun Widget_onDragLeave_Handler(
    sender: CPointer<in CPointed>?,
    context: CPointer<GdkDragContext>,
    time: UInt,
    _data: COpaquePointer?
) {
    _data?.asStableRef<Widget>()?.get()?.onDragLeave?.emit(context?.reinterpret(), time)
}

private fun Widget_onDragMotion_Handler(
    sender: CPointer<in CPointed>?,
    context: CPointer<GdkDragContext>,
    x: Int,
    y: Int,
    time: UInt,
    _data: COpaquePointer?
) {
    _data?.asStableRef<Widget>()?.get()?.onDragMotion?.emit(context?.reinterpret(), x, y, time)
}

private fun Widget_onEnterNotifyEvent_Handler(
    sender: CPointer<in CPointed>?,
    event: CPointer<GdkEventCrossing>,
    _data: COpaquePointer?
) {
    _data?.asStableRef<Widget>()?.get()?.onEnterNotifyEvent?.emit(event?.reinterpret())
}

private fun Widget_onEvent_Handler(
    sender: CPointer<in CPointed>?,
    event: CPointer<GdkEvent>,
    _data: COpaquePointer?
) {
    _data?.asStableRef<Widget>()?.get()?.onEvent?.emit(event?.reinterpret())
}

private fun Widget_onEventAfter_Handler(
    sender: CPointer<in CPointed>?,
    event: CPointer<GdkEvent>,
    _data: COpaquePointer?
) {
    _data?.asStableRef<Widget>()?.get()?.onEventAfter?.emit(event?.reinterpret())
}

private fun Widget_onFocusInEvent_Handler(
    sender: CPointer<in CPointed>?,
    event: CPointer<GdkEventFocus>,
    _data: COpaquePointer?
) {
    _data?.asStableRef<Widget>()?.get()?.onFocusInEvent?.emit(event?.reinterpret())
}

private fun Widget_onFocusOutEvent_Handler(
    sender: CPointer<in CPointed>?,
    event: CPointer<GdkEventFocus>,
    _data: COpaquePointer?
) {
    _data?.asStableRef<Widget>()?.get()?.onFocusOutEvent?.emit(event?.reinterpret())
}

private fun Widget_onGrabBrokenEvent_Handler(
    sender: CPointer<in CPointed>?,
    event: CPointer<GdkEventGrabBroken>,
    _data: COpaquePointer?
) {
    _data?.asStableRef<Widget>()?.get()?.onGrabBrokenEvent?.emit(event?.reinterpret())
}

private fun Widget_onGrabFocus_Handler(sender: CPointer<in CPointed>?, _data: COpaquePointer?) {
    _data?.asStableRef<Widget>()?.get()?.onGrabFocus?.emit()
}

private fun Widget_onGrabNotify_Handler(
    sender: CPointer<in CPointed>?,
    was_grabbed: Boolean,
    _data: COpaquePointer?
) {
    _data?.asStableRef<Widget>()?.get()?.onGrabNotify?.emit(was_grabbed)
}

private fun Widget_onHide_Handler(sender: CPointer<in CPointed>?, _data: COpaquePointer?) {
    _data?.asStableRef<Widget>()?.get()?.onHide?.emit()
}

private fun Widget_onHierarchyChanged_Handler(
    sender: CPointer<in CPointed>?,
    previous_toplevel: CPointer<GtkWidget>,
    _data: COpaquePointer?
) {
    _data?.asStableRef<Widget>()?.get()?.onHierarchyChanged?.emit(previous_toplevel?.reinterpret())
}

private fun Widget_onKeyPressEvent_Handler(
    sender: CPointer<in CPointed>?,
    event: CPointer<GdkEventKey>,
    _data: COpaquePointer?
) {
    _data?.asStableRef<Widget>()?.get()?.onKeyPressEvent?.emit(event?.reinterpret())
}

private fun Widget_onKeyReleaseEvent_Handler(
    sender: CPointer<in CPointed>?,
    event: CPointer<GdkEventKey>,
    _data: COpaquePointer?
) {
    _data?.asStableRef<Widget>()?.get()?.onKeyReleaseEvent?.emit(event?.reinterpret())
}

private fun Widget_onLeaveNotifyEvent_Handler(
    sender: CPointer<in CPointed>?,
    event: CPointer<GdkEventCrossing>,
    _data: COpaquePointer?
) {
    _data?.asStableRef<Widget>()?.get()?.onLeaveNotifyEvent?.emit(event?.reinterpret())
}

private fun Widget_onMap_Handler(sender: CPointer<in CPointed>?, _data: COpaquePointer?) {
    _data?.asStableRef<Widget>()?.get()?.onMap?.emit()
}

private fun Widget_onMapEvent_Handler(
    sender: CPointer<in CPointed>?,
    event: CPointer<GdkEventAny>,
    _data: COpaquePointer?
) {
    _data?.asStableRef<Widget>()?.get()?.onMapEvent?.emit(event?.reinterpret())
}

private fun Widget_onMnemonicActivate_Handler(
    sender: CPointer<in CPointed>?,
    group_cycling: Boolean,
    _data: COpaquePointer?
) {
    _data?.asStableRef<Widget>()?.get()?.onMnemonicActivate?.emit(group_cycling)
}

private fun Widget_onMotionNotifyEvent_Handler(
    sender: CPointer<in CPointed>?,
    event: CPointer<GdkEventMotion>,
    _data: COpaquePointer?
) {
    _data?.asStableRef<Widget>()?.get()?.onMotionNotifyEvent?.emit(event?.reinterpret())
}

private fun Widget_onParentSet_Handler(
    sender: CPointer<in CPointed>?,
    old_parent: CPointer<GtkWidget>,
    _data: COpaquePointer?
) {
    _data?.asStableRef<Widget>()?.get()?.onParentSet?.emit(old_parent?.reinterpret())
}

private fun Widget_onPopupMenu_Handler(sender: CPointer<in CPointed>?, _data: COpaquePointer?) {
    _data?.asStableRef<Widget>()?.get()?.onPopupMenu?.emit()
}

private fun Widget_onPropertyNotifyEvent_Handler(
    sender: CPointer<in CPointed>?,
    event: CPointer<GdkEventProperty>,
    _data: COpaquePointer?
) {
    _data?.asStableRef<Widget>()?.get()?.onPropertyNotifyEvent?.emit(event?.reinterpret())
}

private fun Widget_onProximityInEvent_Handler(
    sender: CPointer<in CPointed>?,
    event: CPointer<GdkEventProximity>,
    _data: COpaquePointer?
) {
    _data?.asStableRef<Widget>()?.get()?.onProximityInEvent?.emit(event?.reinterpret())
}

private fun Widget_onProximityOutEvent_Handler(
    sender: CPointer<in CPointed>?,
    event: CPointer<GdkEventProximity>,
    _data: COpaquePointer?
) {
    _data?.asStableRef<Widget>()?.get()?.onProximityOutEvent?.emit(event?.reinterpret())
}

private fun Widget_onQueryTooltip_Handler(
    sender: CPointer<in CPointed>?,
    x: Int,
    y: Int,
    keyboard_mode: Boolean,
    tooltip: CPointer<GtkTooltip>,
    _data: COpaquePointer?
) {
    _data?.asStableRef<Widget>()?.get()?.onQueryTooltip?.emit(x, y, keyboard_mode,
            tooltip?.reinterpret())
}

private fun Widget_onRealize_Handler(sender: CPointer<in CPointed>?, _data: COpaquePointer?) {
    _data?.asStableRef<Widget>()?.get()?.onRealize?.emit()
}

private fun Widget_onScreenChanged_Handler(
    sender: CPointer<in CPointed>?,
    previous_screen: CPointer<GdkScreen>,
    _data: COpaquePointer?
) {
    _data?.asStableRef<Widget>()?.get()?.onScreenChanged?.emit(previous_screen?.reinterpret())
}

private fun Widget_onScrollEvent_Handler(
    sender: CPointer<in CPointed>?,
    event: CPointer<GdkEventScroll>,
    _data: COpaquePointer?
) {
    _data?.asStableRef<Widget>()?.get()?.onScrollEvent?.emit(event?.reinterpret())
}

private fun Widget_onSelectionClearEvent_Handler(
    sender: CPointer<in CPointed>?,
    event: CPointer<GdkEventSelection>,
    _data: COpaquePointer?
) {
    _data?.asStableRef<Widget>()?.get()?.onSelectionClearEvent?.emit(event?.reinterpret())
}

private fun Widget_onSelectionGet_Handler(
    sender: CPointer<in CPointed>?,
    data: CPointer<GtkSelectionData>,
    info: UInt,
    time: UInt,
    _data: COpaquePointer?
) {
    _data?.asStableRef<Widget>()?.get()?.onSelectionGet?.emit(data?.reinterpret(), info, time)
}

private fun Widget_onSelectionNotifyEvent_Handler(
    sender: CPointer<in CPointed>?,
    event: CPointer<GdkEventSelection>,
    _data: COpaquePointer?
) {
    _data?.asStableRef<Widget>()?.get()?.onSelectionNotifyEvent?.emit(event?.reinterpret())
}

private fun Widget_onSelectionReceived_Handler(
    sender: CPointer<in CPointed>?,
    data: CPointer<GtkSelectionData>,
    time: UInt,
    _data: COpaquePointer?
) {
    _data?.asStableRef<Widget>()?.get()?.onSelectionReceived?.emit(data?.reinterpret(), time)
}

private fun Widget_onSelectionRequestEvent_Handler(
    sender: CPointer<in CPointed>?,
    event: CPointer<GdkEventSelection>,
    _data: COpaquePointer?
) {
    _data?.asStableRef<Widget>()?.get()?.onSelectionRequestEvent?.emit(event?.reinterpret())
}

private fun Widget_onShow_Handler(sender: CPointer<in CPointed>?, _data: COpaquePointer?) {
    _data?.asStableRef<Widget>()?.get()?.onShow?.emit()
}

private fun Widget_onSizeAllocate_Handler(
    sender: CPointer<in CPointed>?,
    allocation: CPointer<GtkAllocation>,
    _data: COpaquePointer?
) {
    _data?.asStableRef<Widget>()?.get()?.onSizeAllocate?.emit(allocation?.reinterpret())
}

private fun Widget_onStyleSet_Handler(
    sender: CPointer<in CPointed>?,
    previous_style: CPointer<GtkStyle>,
    _data: COpaquePointer?
) {
    _data?.asStableRef<Widget>()?.get()?.onStyleSet?.emit(previous_style?.reinterpret())
}

private fun Widget_onStyleUpdated_Handler(sender: CPointer<in CPointed>?, _data: COpaquePointer?) {
    _data?.asStableRef<Widget>()?.get()?.onStyleUpdated?.emit()
}

private fun Widget_onTouchEvent_Handler(
    sender: CPointer<in CPointed>?,
    `object`: CPointer<GdkEvent>,
    _data: COpaquePointer?
) {
    _data?.asStableRef<Widget>()?.get()?.onTouchEvent?.emit(`object`?.reinterpret())
}

private fun Widget_onUnmap_Handler(sender: CPointer<in CPointed>?, _data: COpaquePointer?) {
    _data?.asStableRef<Widget>()?.get()?.onUnmap?.emit()
}

private fun Widget_onUnmapEvent_Handler(
    sender: CPointer<in CPointed>?,
    event: CPointer<GdkEventAny>,
    _data: COpaquePointer?
) {
    _data?.asStableRef<Widget>()?.get()?.onUnmapEvent?.emit(event?.reinterpret())
}

private fun Widget_onUnrealize_Handler(sender: CPointer<in CPointed>?, _data: COpaquePointer?) {
    _data?.asStableRef<Widget>()?.get()?.onUnrealize?.emit()
}

private fun Widget_onVisibilityNotifyEvent_Handler(
    sender: CPointer<in CPointed>?,
    event: CPointer<GdkEventVisibility>,
    _data: COpaquePointer?
) {
    _data?.asStableRef<Widget>()?.get()?.onVisibilityNotifyEvent?.emit(event?.reinterpret())
}

private fun Widget_onWindowStateEvent_Handler(
    sender: CPointer<in CPointed>?,
    event: CPointer<GdkEventWindowState>,
    _data: COpaquePointer?
) {
    _data?.asStableRef<Widget>()?.get()?.onWindowStateEvent?.emit(event?.reinterpret())
}

/**
 * GtkWidget is the base class all widgets in GTK+ derive from. It manages the
 * widget lifecycle, states and style.
 *
 * # Height-for-width Geometry Management # {#geometry-management}
 *
 * GTK+ uses a height-for-width (and width-for-height) geometry management
 * system. Height-for-width means that a widget can change how much
 * vertical space it needs, depending on the amount of horizontal space
 * that it is given (and similar for width-for-height). The most common
 * example is a label that reflows to fill up the available width, wraps
 * to fewer lines, and therefore needs less height.
 *
 * Height-for-width geometry management is implemented in GTK+ by way
 * of five virtual methods:
 *
 * - #GtkWidgetClass.get_request_mode()
 * - #GtkWidgetClass.get_preferred_width()
 * - #GtkWidgetClass.get_preferred_height()
 * - #GtkWidgetClass.get_preferred_height_for_width()
 * - #GtkWidgetClass.get_preferred_width_for_height()
 * - #GtkWidgetClass.get_preferred_height_and_baseline_for_width()
 *
 * There are some important things to keep in mind when implementing
 * height-for-width and when using it in container implementations.
 *
 * The geometry management system will query a widget hierarchy in
 * only one orientation at a time. When widgets are initially queried
 * for their minimum sizes it is generally done in two initial passes
 * in the #GtkSizeRequestMode chosen by the toplevel.
 *
 * For example, when queried in the normal
 * %GTK_SIZE_REQUEST_HEIGHT_FOR_WIDTH mode:
 * First, the default minimum and natural width for each widget
 * in the interface will be computed using gtk_widget_get_preferred_width().
 * Because the preferred widths for each container depend on the preferred
 * widths of their children, this information propagates up the hierarchy,
 * and finally a minimum and natural width is determined for the entire
 * toplevel. Next, the toplevel will use the minimum width to query for the
 * minimum height contextual to that width using
 * gtk_widget_get_preferred_height_for_width(), which will also be a highly
 * recursive operation. The minimum height for the minimum width is normally
 * used to set the minimum size constraint on the toplevel
 * (unless gtk_window_set_geometry_hints() is explicitly used instead).
 *
 * After the toplevel window has initially requested its size in both
 * dimensions it can go on to allocate itself a reasonable size (or a size
 * previously specified with gtk_window_set_default_size()). During the
 * recursive allocation process it’s important to note that request cycles
 * will be recursively executed while container widgets allocate their children.
 * Each container widget, once allocated a size, will go on to first share the
 * space in one orientation among its children and then request each child's
 * height for its target allocated width or its width for allocated height,
 * depending. In this way a #GtkWidget will typically be requested its size
 * a number of times before actually being allocated a size. The size a
 * widget is finally allocated can of course differ from the size it has
 * requested. For this reason, #GtkWidget caches a  small number of results
 * to avoid re-querying for the same sizes in one allocation cycle.
 *
 * See
 * [GtkContainer’s geometry management section][container-geometry-management]
 * to learn more about how height-for-width allocations are performed
 * by container widgets.
 *
 * If a widget does move content around to intelligently use up the
 * allocated size then it must support the request in both
 * #GtkSizeRequestModes even if the widget in question only
 * trades sizes in a single orientation.
 *
 * For instance, a #GtkLabel that does height-for-width word wrapping
 * will not expect to have #GtkWidgetClass.get_preferred_height() called
 * because that call is specific to a width-for-height request. In this
 * case the label must return the height required for its own minimum
 * possible width. By following this rule any widget that handles
 * height-for-width or width-for-height requests will always be allocated
 * at least enough space to fit its own content.
 *
 * Here are some examples of how a %GTK_SIZE_REQUEST_HEIGHT_FOR_WIDTH widget
 * generally deals with width-for-height requests, for #GtkWidgetClass.get_preferred_height()
 * it will do:
 *
 * |[<!-- language="C" -->
 * static void
 * foo_widget_get_preferred_height (GtkWidget *widget,
 *                                  gint *min_height,
 *                                  gint *nat_height)
 * {
 *    if (i_am_in_height_for_width_mode)
 *      {
 *        gint min_width, nat_width;
 *
 *        GTK_WIDGET_GET_CLASS (widget)->get_preferred_width (widget,
 *                                                            &min_width,
 *                                                            &nat_width);
 *        GTK_WIDGET_GET_CLASS (widget)->get_preferred_height_for_width
 *                                                           (widget,
 *                                                            min_width,
 *                                                            min_height,
 *                                                            nat_height);
 *      }
 *    else
 *      {
 *         ... some widgets do both. For instance, if a GtkLabel is
 *         rotated to 90 degrees it will return the minimum and
 *         natural height for the rotated label here.
 *      }
 * }
 * ]|
 *
 * And in #GtkWidgetClass.get_preferred_width_for_height() it will simply return
 * the minimum and natural width:
 * |[<!-- language="C" -->
 * static void
 * foo_widget_get_preferred_width_for_height (GtkWidget *widget,
 *                                            gint for_height,
 *                                            gint *min_width,
 *                                            gint *nat_width)
 * {
 *    if (i_am_in_height_for_width_mode)
 *      {
 *        GTK_WIDGET_GET_CLASS (widget)->get_preferred_width (widget,
 *                                                            min_width,
 *                                                            nat_width);
 *      }
 *    else
 *      {
 *         ... again if a widget is sometimes operating in
 *         width-for-height mode (like a rotated GtkLabel) it can go
 *         ahead and do its real width for height calculation here.
 *      }
 * }
 * ]|
 *
 * Often a widget needs to get its own request during size request or
 * allocation. For example, when computing height it may need to also
 * compute width. Or when deciding how to use an allocation, the widget
 * may need to know its natural size. In these cases, the widget should
 * be careful to call its virtual methods directly, like this:
 *
 * |[<!-- language="C" -->
 * GTK_WIDGET_GET_CLASS(widget)->get_preferred_width (widget,
 *                                                    &min,
 *                                                    &natural);
 * ]|
 *
 * It will not work to use the wrapper functions, such as
 * gtk_widget_get_preferred_width() inside your own size request
 * implementation. These return a request adjusted by #GtkSizeGroup
 * and by the #GtkWidgetClass.adjust_size_request() virtual method. If a
 * widget used the wrappers inside its virtual method implementations,
 * then the adjustments (such as widget margins) would be applied
 * twice. GTK+ therefore does not allow this and will warn if you try
 * to do it.
 *
 * Of course if you are getting the size request for
 * another widget, such as a child of a
 * container, you must use the wrapper APIs.
 * Otherwise, you would not properly consider widget margins,
 * #GtkSizeGroup, and so forth.
 *
 * Since 3.10 GTK+ also supports baseline vertical alignment of widgets. This
 * means that widgets are positioned such that the typographical baseline of
 * widgets in the same row are aligned. This happens if a widget supports baselines,
 * has a vertical alignment of %GTK_ALIGN_BASELINE, and is inside a container
 * that supports baselines and has a natural “row” that it aligns to the baseline,
 * or a baseline assigned to it by the grandparent.
 *
 * Baseline alignment support for a widget is done by the
        #GtkWidgetClass.get_preferred_height_and_baseline_for_width()
 * virtual function. It allows you to report a baseline in combination with the
 * minimum and natural height. If there is no baseline you can return -1 to indicate
 * this. The default implementation of this virtual function calls into the
 * #GtkWidgetClass.get_preferred_height() and #GtkWidgetClass.get_preferred_height_for_width(),
 * so if baselines are not supported it doesn’t need to be implemented.
 *
 * If a widget ends up baseline aligned it will be allocated all the space in the parent
 * as if it was %GTK_ALIGN_FILL, but the selected baseline can be found via
        gtk_widget_get_allocated_baseline().
 * If this has a value other than -1 you need to align the widget such that the baseline
 * appears at the position.
 *
 * # Style Properties
 *
 * #GtkWidget introduces “style
 * properties” - these are basically object properties that are stored
 * not on the object, but in the style object associated to the widget. Style
 * properties are set in [resource files][gtk3-Resource-Files].
 * This mechanism is used for configuring such things as the location of the
 * scrollbar arrows through the theme, giving theme authors more control over the
 * look of applications without the need to write a theme engine in C.
 *
 * Use gtk_widget_class_install_style_property() to install style properties for
 * a widget class, gtk_widget_class_find_style_property() or
 * gtk_widget_class_list_style_properties() to get information about existing
 * style properties and gtk_widget_style_get_property(), gtk_widget_style_get() or
 * gtk_widget_style_get_valist() to obtain the value of a style property.
 *
 * # GtkWidget as GtkBuildable
 *
 * The GtkWidget implementation of the GtkBuildable interface supports a
 * custom <accelerator> element, which has attributes named ”key”, ”modifiers”
 * and ”signal” and allows to specify accelerators.
 *
 * An example of a UI definition fragment specifying an accelerator:
 * |[
 * <object class="GtkButton">
 *   <accelerator key="q" modifiers="GDK_CONTROL_MASK" signal="clicked"/>
 * </object>
 * ]|
 *
 * In addition to accelerators, GtkWidget also support a custom <accessible>
 * element, which supports actions and relations. Properties on the accessible
 * implementation of an object can be set by accessing the internal child
 * “accessible” of a #GtkWidget.
 *
 * An example of a UI definition fragment specifying an accessible:
 * |[
 * <object class="GtkLabel" id="label1"/>
 *   <property name="label">I am a Label for a Button</property>
 * </object>
 * <object class="GtkButton" id="button1">
 *   <accessibility>
 *     <action action_name="click" translatable="yes">Click the button.</action>
 *     <relation target="label1" type="labelled-by"/>
 *   </accessibility>
 *   <child internal-child="accessible">
 *     <object class="AtkObject" id="a11y-button1">
 *       <property name="accessible-name">Clickable Button</property>
 *     </object>
 *   </child>
 * </object>
 * ]|
 *
 * Finally, GtkWidget allows style information such as style classes to
 * be associated with widgets, using the custom <style> element:
 * |[
 * <object class="GtkButton" id="button1">
 *   <style>
 *     <class name="my-special-button-class"/>
 *     <class name="dark-button"/>
 *   </style>
 * </object>
 * ]|
 *
 * # Building composite widgets from template XML ## {#composite-templates}
 *
 * GtkWidget exposes some facilities to automate the procedure
 * of creating composite widgets using #GtkBuilder interface description
 * language.
 *
 * To create composite widgets with #GtkBuilder XML, one must associate
 * the interface description with the widget class at class initialization
 * time using gtk_widget_class_set_template().
 *
 * The interface description semantics expected in composite template descriptions
 * is slightly different from regular #GtkBuilder XML.
 *
 * Unlike regular interface descriptions, gtk_widget_class_set_template() will
 * expect a <template> tag as a direct child of the toplevel <interface>
 * tag. The <template> tag must specify the “class” attribute which must be
 * the type name of the widget. Optionally, the “parent” attribute may be
 * specified to specify the direct parent type of the widget type, this is
 * ignored by the GtkBuilder but required for Glade to introspect what kind
 * of properties and internal children exist for a given type when the actual
 * type does not exist.
 *
 * The XML which is contained inside the <template> tag behaves as if it were
 * added to the <object> tag defining @widget itself. You may set properties
 * on @widget by inserting <property> tags into the <template> tag, and also
 * add <child> tags to add children and extend @widget in the normal way you
 * would with <object> tags.
 *
 * Additionally, <object> tags can also be added before and after the initial
 * <template> tag in the normal way, allowing one to define auxiliary objects
 * which might be referenced by other widgets declared as children of the
 * <template> tag.
 *
 * An example of a GtkBuilder Template Definition:
 * |[
 * <interface>
 *   <template class="FooWidget" parent="GtkBox">
 *     <property name="orientation">GTK_ORIENTATION_HORIZONTAL</property>
 *     <property name="spacing">4</property>
 *     <child>
 *       <object class="GtkButton" id="hello_button">
 *         <property name="label">Hello World</property>
 *         <signal name="clicked" handler="hello_button_clicked" object="FooWidget" swapped="yes"/>
 *       </object>
 *     </child>
 *     <child>
 *       <object class="GtkButton" id="goodbye_button">
 *         <property name="label">Goodbye World</property>
 *       </object>
 *     </child>
 *   </template>
 * </interface>
 * ]|
 *
 * Typically, you'll place the template fragment into a file that is
 * bundled with your project, using #GResource. In order to load the
 * template, you need to call gtk_widget_class_set_template_from_resource()
 * from the class initialization of your #GtkWidget type:
 *
 * |[<!-- language="C" -->
 * static void
 * foo_widget_class_init (FooWidgetClass *klass)
 * {
 *   // ...
 *
 *   gtk_widget_class_set_template_from_resource (GTK_WIDGET_CLASS (klass),
 *                                                "/com/example/ui/foowidget.ui");
 * }
 * ]|
 *
 * You will also need to call gtk_widget_init_template() from the instance
 * initialization function:
 *
 * |[<!-- language="C" -->
 * static void
 * foo_widget_init (FooWidget *self)
 * {
 *   // ...
 *   gtk_widget_init_template (GTK_WIDGET (self));
 * }
 * ]|
 *
 * You can access widgets defined in the template using the
 * gtk_widget_get_template_child() function, but you will typically declare
 * a pointer in the instance private data structure of your type using the same
 * name as the widget in the template definition, and call
 * gtk_widget_class_bind_template_child_private() with that name, e.g.
 *
 * |[<!-- language="C" -->
 * typedef struct {
 *   GtkWidget *hello_button;
 *   GtkWidget *goodbye_button;
 * } FooWidgetPrivate;
 *
 * G_DEFINE_TYPE_WITH_PRIVATE (FooWidget, foo_widget, GTK_TYPE_BOX)
 *
 * static void
 * foo_widget_class_init (FooWidgetClass *klass)
 * {
 *   // ...
 *   gtk_widget_class_set_template_from_resource (GTK_WIDGET_CLASS (klass),
 *                                                "/com/example/ui/foowidget.ui");
 *   gtk_widget_class_bind_template_child_private (GTK_WIDGET_CLASS (klass),
 *                                                 FooWidget, hello_button);
 *   gtk_widget_class_bind_template_child_private (GTK_WIDGET_CLASS (klass),
 *                                                 FooWidget, goodbye_button);
 * }
 *
 * static void
 * foo_widget_init (FooWidget *widget)
 * {
 *
 * }
 * ]|
 *
 * You can also use gtk_widget_class_bind_template_callback() to connect a signal
 * callback defined in the template with a function visible in the scope of the
 * class, e.g.
 *
 * |[<!-- language="C" -->
 * // the signal handler has the instance and user data swapped
 * // because of the swapped="yes" attribute in the template XML
 * static void
 * hello_button_clicked (FooWidget *self,
 *                       GtkButton *button)
 * {
 *   g_print ("Hello, world!\n");
 * }
 *
 * static void
 * foo_widget_class_init (FooWidgetClass *klass)
 * {
 *   // ...
 *   gtk_widget_class_set_template_from_resource (GTK_WIDGET_CLASS (klass),
 *                                                "/com/example/ui/foowidget.ui");
 *   gtk_widget_class_bind_template_callback (GTK_WIDGET_CLASS (klass), hello_button_clicked);
 * }
 * ]|Returns the baseline that has currently been allocated to @widget.
 * This function is intended to be used when implementing handlers
 * for the #GtkWidget::draw function, and when allocating child
 * widgets in #GtkWidget::size_allocate.Returns the height that has currently been allocated to
        @widget.
 * This function is intended to be used when implementing handlers
 * for the #GtkWidget::draw function.Returns the width that has currently been allocated to @widget.
 * This function is intended to be used when implementing handlers
 * for the #GtkWidget::draw function.Get the #GdkDisplay for the toplevel window associated with
 * this widget. This function can only be called after the widget
 * has been added to a widget hierarchy with a #GtkWindow at the top.
 *
 * In general, you should only create display specific
 * resources when a widget has been realized, and you should
 * free those resources when the widget is unrealized.Determines whether the widget is double
        buffered.
 *
 * See gtk_widget_set_double_buffered()Obtains the frame clock for a widget. The frame clock is a
        global
 * “ticker” that can be used to drive animations and repaints.  The
 * most common reason to get the frame clock is to call
 * gdk_frame_clock_get_frame_time(), in order to get a time to use for
 * animating. For example you might record the start of the animation
 * with an initial value from gdk_frame_clock_get_frame_time(), and
 * then update the animation by calling
 * gdk_frame_clock_get_frame_time() again during each repaint.
 *
 * gdk_frame_clock_request_phase() will result in a new frame on the
 * clock, but won’t necessarily repaint any widgets. To repaint a
 * widget, you have to use gtk_widget_queue_draw() which invalidates
 * the widget (thus scheduling it to receive a draw on the next
 * frame). gtk_widget_queue_draw() will also end up requesting a frame
 * on the appropriate frame clock.
 *
 * A widget’s frame clock will not change while the widget is
 * mapped. Reparenting a widget (which implies a temporary unmap) can
 * change the widget’s frame clock.
 *
 * Unrealized widgets do not have a frame clock.Returns the #GtkWidgetPath representing @widget, if
        the widget
 * is not connected to a toplevel widget, a partial path will be
 * created.Gets whether the widget prefers a height-for-width layout
 * or a width-for-height layout.
 *
 * #GtkBin widgets generally propagate the preference of
 * their child, container widgets need to request something either in
 * context of their children or in context of their allocation
 * capabilities.Retrieves the internal scale factor that maps from window coordinates
 * to the actual device pixels. On traditional systems this is 1, on
 * high density outputs, it can be a higher value (typically 2).
 *
 * See gdk_window_get_scale_factor().Gets the settings object holding the settings used for this
        widget.
 *
 * Note that this function can only be called when the #GtkWidget
 * is attached to a toplevel, since the settings object is specific
 * to a particular #GdkScreen.Returns the widget state as a flag set. It is worth mentioning
 * that the effective %GTK_STATE_FLAG_INSENSITIVE state will be
 * returned, that is, also based on parent insensitivity, even if
 * @widget itself is sensitive.
 *
 * Also note that if you are looking for a way to obtain the
 * #GtkStateFlags to pass to a #GtkStyleContext method, you
 * should look at gtk_style_context_get_state().Returns the style context associated to @widget. The
        returned object is
 * guaranteed to be the same for the lifetime of @widget.This function returns the topmost widget in
        the container hierarchy
 * @widget is a part of. If @widget has no parent widgets, it will be
 * returned as the topmost widget. No reference will be added to the
 * returned widget; it should not be unreferenced.
 *
 * Note the difference in behavior vs. gtk_widget_get_ancestor();
 * `gtk_widget_get_ancestor (widget, GTK_TYPE_WINDOW)`
 * would return
 * %NULL if @widget wasn’t inside a toplevel window, and if the
 * window was inside a #GtkWindow-derived widget which was in turn
 * inside the toplevel #GtkWindow. While the second case may
 * seem unlikely, it actually happens when a #GtkPlug is embedded
 * inside a #GtkSocket within the same application.
 *
 * To reliably find the toplevel #GtkWindow, use
 * gtk_widget_get_toplevel() and call GTK_IS_WINDOW()
 * on the result. For instance, to get the title of a widget's toplevel
 * window, one might use:
 * |[<!-- language="C" -->
 * static const char *
 * get_widget_toplevel_title (GtkWidget *widget)
 * {
 *   GtkWidget *toplevel = gtk_widget_get_toplevel (widget);
 *   if (GTK_IS_WINDOW (toplevel))
 *     {
 *       return gtk_window_get_title (GTK_WINDOW (toplevel));
 *     }
 *
 *   return NULL;
 * }
 * ]|Gets the value of the #GtkWidget:valign property, including
 * %GTK_ALIGN_BASELINE. */
@GtkDsl
abstract class Widget {
    abstract val widgetPtr: CPointer<GtkWidget>?

    private val self: CPointer<GtkWidget>?
        get() = widgetPtr

    val onAccelClosuresChanged: Signal<Widget, CFunction<(CPointer<in CPointed>?,
            COpaquePointer?) -> Unit>> by lazy { Signal<Widget, CFunction<(CPointer<in CPointed>?,
            COpaquePointer?) -> Unit>>(widgetPtr!!, this, "accel-closures-changed",
            staticCFunction(::Widget_onAccelClosuresChanged_Handler)) }

    val onButtonPressEvent: Signal1<Widget, CPointer<GdkEventButton>, CFunction<(
        CPointer<in CPointed>?,
        CPointer<GdkEventButton>,
        COpaquePointer?
    ) -> Unit>> by lazy { Signal1<Widget, CPointer<GdkEventButton>, CFunction<(
                CPointer<in CPointed>?,
                CPointer<GdkEventButton>,
                COpaquePointer?
            ) -> Unit>>(widgetPtr!!, this, "button-press-event",
                    staticCFunction(::Widget_onButtonPressEvent_Handler)) }

    val onButtonReleaseEvent: Signal1<Widget, CPointer<GdkEventButton>, CFunction<(
        CPointer<in CPointed>?,
        CPointer<GdkEventButton>,
        COpaquePointer?
    ) -> Unit>> by lazy { Signal1<Widget, CPointer<GdkEventButton>, CFunction<(
                CPointer<in CPointed>?,
                CPointer<GdkEventButton>,
                COpaquePointer?
            ) -> Unit>>(widgetPtr!!, this, "button-release-event",
                    staticCFunction(::Widget_onButtonReleaseEvent_Handler)) }

    val onCanActivateAccel: Signal1<Widget, UInt, CFunction<(
        CPointer<in CPointed>?,
        UInt,
        COpaquePointer?
    ) -> Unit>> by lazy { Signal1<Widget, UInt, CFunction<(
                CPointer<in CPointed>?,
                UInt,
                COpaquePointer?
            ) -> Unit>>(widgetPtr!!, this, "can-activate-accel",
                    staticCFunction(::Widget_onCanActivateAccel_Handler)) }

    val onCompositedChanged: Signal<Widget, CFunction<(CPointer<in CPointed>?, COpaquePointer?) ->
            Unit>> by lazy { Signal<Widget, CFunction<(CPointer<in CPointed>?, COpaquePointer?) ->
            Unit>>(widgetPtr!!, this, "composited-changed",
            staticCFunction(::Widget_onCompositedChanged_Handler)) }

    val onConfigureEvent: Signal1<Widget, CPointer<GdkEventConfigure>, CFunction<(
        CPointer<in CPointed>?,
        CPointer<GdkEventConfigure>,
        COpaquePointer?
    ) -> Unit>> by lazy { Signal1<Widget, CPointer<GdkEventConfigure>, CFunction<(
                CPointer<in CPointed>?,
                CPointer<GdkEventConfigure>,
                COpaquePointer?
            ) -> Unit>>(widgetPtr!!, this, "configure-event",
                    staticCFunction(::Widget_onConfigureEvent_Handler)) }

    val onDamageEvent: Signal1<Widget, CPointer<GdkEventExpose>, CFunction<(
        CPointer<in CPointed>?,
        CPointer<GdkEventExpose>,
        COpaquePointer?
    ) -> Unit>> by lazy { Signal1<Widget, CPointer<GdkEventExpose>, CFunction<(
                CPointer<in CPointed>?,
                CPointer<GdkEventExpose>,
                COpaquePointer?
            ) -> Unit>>(widgetPtr!!, this, "damage-event",
                    staticCFunction(::Widget_onDamageEvent_Handler)) }

    val onDeleteEvent: Signal1<Widget, CPointer<GdkEvent>, CFunction<(
        CPointer<in CPointed>?,
        CPointer<GdkEvent>,
        COpaquePointer?
    ) -> Unit>> by lazy { Signal1<Widget, CPointer<GdkEvent>, CFunction<(
                CPointer<in CPointed>?,
                CPointer<GdkEvent>,
                COpaquePointer?
            ) -> Unit>>(widgetPtr!!, this, "delete-event",
                    staticCFunction(::Widget_onDeleteEvent_Handler)) }

    val onDestroy: Signal<Widget, CFunction<(CPointer<in CPointed>?, COpaquePointer?) -> Unit>> by
            lazy { Signal<Widget, CFunction<(CPointer<in CPointed>?, COpaquePointer?) ->
            Unit>>(widgetPtr!!, this, "destroy", staticCFunction(::Widget_onDestroy_Handler)) }

    val onDestroyEvent: Signal1<Widget, CPointer<GdkEvent>, CFunction<(
        CPointer<in CPointed>?,
        CPointer<GdkEvent>,
        COpaquePointer?
    ) -> Unit>> by lazy { Signal1<Widget, CPointer<GdkEvent>, CFunction<(
                CPointer<in CPointed>?,
                CPointer<GdkEvent>,
                COpaquePointer?
            ) -> Unit>>(widgetPtr!!, this, "destroy-event",
                    staticCFunction(::Widget_onDestroyEvent_Handler)) }

    val onDragBegin: Signal1<Widget, CPointer<GdkDragContext>, CFunction<(
        CPointer<in CPointed>?,
        CPointer<GdkDragContext>,
        COpaquePointer?
    ) -> Unit>> by lazy { Signal1<Widget, CPointer<GdkDragContext>, CFunction<(
                CPointer<in CPointed>?,
                CPointer<GdkDragContext>,
                COpaquePointer?
            ) -> Unit>>(widgetPtr!!, this, "drag-begin",
                    staticCFunction(::Widget_onDragBegin_Handler)) }

    val onDragDataDelete: Signal1<Widget, CPointer<GdkDragContext>, CFunction<(
        CPointer<in CPointed>?,
        CPointer<GdkDragContext>,
        COpaquePointer?
    ) -> Unit>> by lazy { Signal1<Widget, CPointer<GdkDragContext>, CFunction<(
                CPointer<in CPointed>?,
                CPointer<GdkDragContext>,
                COpaquePointer?
            ) -> Unit>>(widgetPtr!!, this, "drag-data-delete",
                    staticCFunction(::Widget_onDragDataDelete_Handler)) }

    val onDragDataGet: Signal4<Widget, CPointer<GdkDragContext>, CPointer<GtkSelectionData>, UInt,
            UInt, CFunction<(
        CPointer<in CPointed>?,
        CPointer<GdkDragContext>,
        CPointer<GtkSelectionData>,
        UInt,
        UInt,
        COpaquePointer?
    ) -> Unit>> by lazy { Signal4<Widget, CPointer<GdkDragContext>, CPointer<GtkSelectionData>,
            UInt, UInt, CFunction<(
                CPointer<in CPointed>?,
                CPointer<GdkDragContext>,
                CPointer<GtkSelectionData>,
                UInt,
                UInt,
                COpaquePointer?
            ) -> Unit>>(widgetPtr!!, this, "drag-data-get",
                    staticCFunction(::Widget_onDragDataGet_Handler)) }

    val onDragDataReceived: Signal6<Widget, CPointer<GdkDragContext>, Int, Int,
            CPointer<GtkSelectionData>, UInt, UInt, CFunction<(
        CPointer<in CPointed>?,
        CPointer<GdkDragContext>,
        Int,
        Int,
        CPointer<GtkSelectionData>,
        UInt,
        UInt,
        COpaquePointer?
    ) -> Unit>> by lazy { Signal6<Widget, CPointer<GdkDragContext>, Int, Int,
            CPointer<GtkSelectionData>, UInt, UInt, CFunction<(
                CPointer<in CPointed>?,
                CPointer<GdkDragContext>,
                Int,
                Int,
                CPointer<GtkSelectionData>,
                UInt,
                UInt,
                COpaquePointer?
            ) -> Unit>>(widgetPtr!!, this, "drag-data-received",
                    staticCFunction(::Widget_onDragDataReceived_Handler)) }

    val onDragDrop: Signal4<Widget, CPointer<GdkDragContext>, Int, Int, UInt, CFunction<(
        CPointer<in CPointed>?,
        CPointer<GdkDragContext>,
        Int,
        Int,
        UInt,
        COpaquePointer?
    ) -> Unit>> by lazy { Signal4<Widget, CPointer<GdkDragContext>, Int, Int, UInt, CFunction<(
                CPointer<in CPointed>?,
                CPointer<GdkDragContext>,
                Int,
                Int,
                UInt,
                COpaquePointer?
            ) -> Unit>>(widgetPtr!!, this, "drag-drop",
                    staticCFunction(::Widget_onDragDrop_Handler)) }

    val onDragEnd: Signal1<Widget, CPointer<GdkDragContext>, CFunction<(
        CPointer<in CPointed>?,
        CPointer<GdkDragContext>,
        COpaquePointer?
    ) -> Unit>> by lazy { Signal1<Widget, CPointer<GdkDragContext>, CFunction<(
                CPointer<in CPointed>?,
                CPointer<GdkDragContext>,
                COpaquePointer?
            ) -> Unit>>(widgetPtr!!, this, "drag-end", staticCFunction(::Widget_onDragEnd_Handler))
                    }

    val onDragLeave: Signal2<Widget, CPointer<GdkDragContext>, UInt, CFunction<(
        CPointer<in CPointed>?,
        CPointer<GdkDragContext>,
        UInt,
        COpaquePointer?
    ) -> Unit>> by lazy { Signal2<Widget, CPointer<GdkDragContext>, UInt, CFunction<(
                CPointer<in CPointed>?,
                CPointer<GdkDragContext>,
                UInt,
                COpaquePointer?
            ) -> Unit>>(widgetPtr!!, this, "drag-leave",
                    staticCFunction(::Widget_onDragLeave_Handler)) }

    val onDragMotion: Signal4<Widget, CPointer<GdkDragContext>, Int, Int, UInt, CFunction<(
        CPointer<in CPointed>?,
        CPointer<GdkDragContext>,
        Int,
        Int,
        UInt,
        COpaquePointer?
    ) -> Unit>> by lazy { Signal4<Widget, CPointer<GdkDragContext>, Int, Int, UInt, CFunction<(
                CPointer<in CPointed>?,
                CPointer<GdkDragContext>,
                Int,
                Int,
                UInt,
                COpaquePointer?
            ) -> Unit>>(widgetPtr!!, this, "drag-motion",
                    staticCFunction(::Widget_onDragMotion_Handler)) }

    val onEnterNotifyEvent: Signal1<Widget, CPointer<GdkEventCrossing>, CFunction<(
        CPointer<in CPointed>?,
        CPointer<GdkEventCrossing>,
        COpaquePointer?
    ) -> Unit>> by lazy { Signal1<Widget, CPointer<GdkEventCrossing>, CFunction<(
                CPointer<in CPointed>?,
                CPointer<GdkEventCrossing>,
                COpaquePointer?
            ) -> Unit>>(widgetPtr!!, this, "enter-notify-event",
                    staticCFunction(::Widget_onEnterNotifyEvent_Handler)) }

    val onEvent: Signal1<Widget, CPointer<GdkEvent>, CFunction<(
        CPointer<in CPointed>?,
        CPointer<GdkEvent>,
        COpaquePointer?
    ) -> Unit>> by lazy { Signal1<Widget, CPointer<GdkEvent>, CFunction<(
                CPointer<in CPointed>?,
                CPointer<GdkEvent>,
                COpaquePointer?
            ) -> Unit>>(widgetPtr!!, this, "event", staticCFunction(::Widget_onEvent_Handler)) }

    val onEventAfter: Signal1<Widget, CPointer<GdkEvent>, CFunction<(
        CPointer<in CPointed>?,
        CPointer<GdkEvent>,
        COpaquePointer?
    ) -> Unit>> by lazy { Signal1<Widget, CPointer<GdkEvent>, CFunction<(
                CPointer<in CPointed>?,
                CPointer<GdkEvent>,
                COpaquePointer?
            ) -> Unit>>(widgetPtr!!, this, "event-after",
                    staticCFunction(::Widget_onEventAfter_Handler)) }

    val onFocusInEvent: Signal1<Widget, CPointer<GdkEventFocus>, CFunction<(
        CPointer<in CPointed>?,
        CPointer<GdkEventFocus>,
        COpaquePointer?
    ) -> Unit>> by lazy { Signal1<Widget, CPointer<GdkEventFocus>, CFunction<(
                CPointer<in CPointed>?,
                CPointer<GdkEventFocus>,
                COpaquePointer?
            ) -> Unit>>(widgetPtr!!, this, "focus-in-event",
                    staticCFunction(::Widget_onFocusInEvent_Handler)) }

    val onFocusOutEvent: Signal1<Widget, CPointer<GdkEventFocus>, CFunction<(
        CPointer<in CPointed>?,
        CPointer<GdkEventFocus>,
        COpaquePointer?
    ) -> Unit>> by lazy { Signal1<Widget, CPointer<GdkEventFocus>, CFunction<(
                CPointer<in CPointed>?,
                CPointer<GdkEventFocus>,
                COpaquePointer?
            ) -> Unit>>(widgetPtr!!, this, "focus-out-event",
                    staticCFunction(::Widget_onFocusOutEvent_Handler)) }

    val onGrabBrokenEvent: Signal1<Widget, CPointer<GdkEventGrabBroken>, CFunction<(
        CPointer<in CPointed>?,
        CPointer<GdkEventGrabBroken>,
        COpaquePointer?
    ) -> Unit>> by lazy { Signal1<Widget, CPointer<GdkEventGrabBroken>, CFunction<(
                CPointer<in CPointed>?,
                CPointer<GdkEventGrabBroken>,
                COpaquePointer?
            ) -> Unit>>(widgetPtr!!, this, "grab-broken-event",
                    staticCFunction(::Widget_onGrabBrokenEvent_Handler)) }

    val onGrabFocus: Signal<Widget, CFunction<(CPointer<in CPointed>?, COpaquePointer?) -> Unit>> by
            lazy { Signal<Widget, CFunction<(CPointer<in CPointed>?, COpaquePointer?) ->
            Unit>>(widgetPtr!!, this, "grab-focus", staticCFunction(::Widget_onGrabFocus_Handler)) }

    val onGrabNotify: Signal1<Widget, Boolean, CFunction<(
        CPointer<in CPointed>?,
        Boolean,
        COpaquePointer?
    ) -> Unit>> by lazy { Signal1<Widget, Boolean, CFunction<(
                CPointer<in CPointed>?,
                Boolean,
                COpaquePointer?
            ) -> Unit>>(widgetPtr!!, this, "grab-notify",
                    staticCFunction(::Widget_onGrabNotify_Handler)) }

    val onHide: Signal<Widget, CFunction<(CPointer<in CPointed>?, COpaquePointer?) -> Unit>> by
            lazy { Signal<Widget, CFunction<(CPointer<in CPointed>?, COpaquePointer?) ->
            Unit>>(widgetPtr!!, this, "hide", staticCFunction(::Widget_onHide_Handler)) }

    val onHierarchyChanged: Signal1<Widget, CPointer<GtkWidget>, CFunction<(
        CPointer<in CPointed>?,
        CPointer<GtkWidget>,
        COpaquePointer?
    ) -> Unit>> by lazy { Signal1<Widget, CPointer<GtkWidget>, CFunction<(
                CPointer<in CPointed>?,
                CPointer<GtkWidget>,
                COpaquePointer?
            ) -> Unit>>(widgetPtr!!, this, "hierarchy-changed",
                    staticCFunction(::Widget_onHierarchyChanged_Handler)) }

    val onKeyPressEvent: Signal1<Widget, CPointer<GdkEventKey>, CFunction<(
        CPointer<in CPointed>?,
        CPointer<GdkEventKey>,
        COpaquePointer?
    ) -> Unit>> by lazy { Signal1<Widget, CPointer<GdkEventKey>, CFunction<(
                CPointer<in CPointed>?,
                CPointer<GdkEventKey>,
                COpaquePointer?
            ) -> Unit>>(widgetPtr!!, this, "key-press-event",
                    staticCFunction(::Widget_onKeyPressEvent_Handler)) }

    val onKeyReleaseEvent: Signal1<Widget, CPointer<GdkEventKey>, CFunction<(
        CPointer<in CPointed>?,
        CPointer<GdkEventKey>,
        COpaquePointer?
    ) -> Unit>> by lazy { Signal1<Widget, CPointer<GdkEventKey>, CFunction<(
                CPointer<in CPointed>?,
                CPointer<GdkEventKey>,
                COpaquePointer?
            ) -> Unit>>(widgetPtr!!, this, "key-release-event",
                    staticCFunction(::Widget_onKeyReleaseEvent_Handler)) }

    val onLeaveNotifyEvent: Signal1<Widget, CPointer<GdkEventCrossing>, CFunction<(
        CPointer<in CPointed>?,
        CPointer<GdkEventCrossing>,
        COpaquePointer?
    ) -> Unit>> by lazy { Signal1<Widget, CPointer<GdkEventCrossing>, CFunction<(
                CPointer<in CPointed>?,
                CPointer<GdkEventCrossing>,
                COpaquePointer?
            ) -> Unit>>(widgetPtr!!, this, "leave-notify-event",
                    staticCFunction(::Widget_onLeaveNotifyEvent_Handler)) }

    val onMap: Signal<Widget, CFunction<(CPointer<in CPointed>?, COpaquePointer?) -> Unit>> by
            lazy { Signal<Widget, CFunction<(CPointer<in CPointed>?, COpaquePointer?) ->
            Unit>>(widgetPtr!!, this, "map", staticCFunction(::Widget_onMap_Handler)) }

    val onMapEvent: Signal1<Widget, CPointer<GdkEventAny>, CFunction<(
        CPointer<in CPointed>?,
        CPointer<GdkEventAny>,
        COpaquePointer?
    ) -> Unit>> by lazy { Signal1<Widget, CPointer<GdkEventAny>, CFunction<(
                CPointer<in CPointed>?,
                CPointer<GdkEventAny>,
                COpaquePointer?
            ) -> Unit>>(widgetPtr!!, this, "map-event",
                    staticCFunction(::Widget_onMapEvent_Handler)) }

    val onMnemonicActivate: Signal1<Widget, Boolean, CFunction<(
        CPointer<in CPointed>?,
        Boolean,
        COpaquePointer?
    ) -> Unit>> by lazy { Signal1<Widget, Boolean, CFunction<(
                CPointer<in CPointed>?,
                Boolean,
                COpaquePointer?
            ) -> Unit>>(widgetPtr!!, this, "mnemonic-activate",
                    staticCFunction(::Widget_onMnemonicActivate_Handler)) }

    val onMotionNotifyEvent: Signal1<Widget, CPointer<GdkEventMotion>, CFunction<(
        CPointer<in CPointed>?,
        CPointer<GdkEventMotion>,
        COpaquePointer?
    ) -> Unit>> by lazy { Signal1<Widget, CPointer<GdkEventMotion>, CFunction<(
                CPointer<in CPointed>?,
                CPointer<GdkEventMotion>,
                COpaquePointer?
            ) -> Unit>>(widgetPtr!!, this, "motion-notify-event",
                    staticCFunction(::Widget_onMotionNotifyEvent_Handler)) }

    val onParentSet: Signal1<Widget, CPointer<GtkWidget>, CFunction<(
        CPointer<in CPointed>?,
        CPointer<GtkWidget>,
        COpaquePointer?
    ) -> Unit>> by lazy { Signal1<Widget, CPointer<GtkWidget>, CFunction<(
                CPointer<in CPointed>?,
                CPointer<GtkWidget>,
                COpaquePointer?
            ) -> Unit>>(widgetPtr!!, this, "parent-set",
                    staticCFunction(::Widget_onParentSet_Handler)) }

    val onPopupMenu: Signal<Widget, CFunction<(CPointer<in CPointed>?, COpaquePointer?) -> Unit>> by
            lazy { Signal<Widget, CFunction<(CPointer<in CPointed>?, COpaquePointer?) ->
            Unit>>(widgetPtr!!, this, "popup-menu", staticCFunction(::Widget_onPopupMenu_Handler)) }

    val onPropertyNotifyEvent: Signal1<Widget, CPointer<GdkEventProperty>, CFunction<(
        CPointer<in CPointed>?,
        CPointer<GdkEventProperty>,
        COpaquePointer?
    ) -> Unit>> by lazy { Signal1<Widget, CPointer<GdkEventProperty>, CFunction<(
                CPointer<in CPointed>?,
                CPointer<GdkEventProperty>,
                COpaquePointer?
            ) -> Unit>>(widgetPtr!!, this, "property-notify-event",
                    staticCFunction(::Widget_onPropertyNotifyEvent_Handler)) }

    val onProximityInEvent: Signal1<Widget, CPointer<GdkEventProximity>, CFunction<(
        CPointer<in CPointed>?,
        CPointer<GdkEventProximity>,
        COpaquePointer?
    ) -> Unit>> by lazy { Signal1<Widget, CPointer<GdkEventProximity>, CFunction<(
                CPointer<in CPointed>?,
                CPointer<GdkEventProximity>,
                COpaquePointer?
            ) -> Unit>>(widgetPtr!!, this, "proximity-in-event",
                    staticCFunction(::Widget_onProximityInEvent_Handler)) }

    val onProximityOutEvent: Signal1<Widget, CPointer<GdkEventProximity>, CFunction<(
        CPointer<in CPointed>?,
        CPointer<GdkEventProximity>,
        COpaquePointer?
    ) -> Unit>> by lazy { Signal1<Widget, CPointer<GdkEventProximity>, CFunction<(
                CPointer<in CPointed>?,
                CPointer<GdkEventProximity>,
                COpaquePointer?
            ) -> Unit>>(widgetPtr!!, this, "proximity-out-event",
                    staticCFunction(::Widget_onProximityOutEvent_Handler)) }

    val onQueryTooltip: Signal4<Widget, Int, Int, Boolean, CPointer<GtkTooltip>, CFunction<(
        CPointer<in CPointed>?,
        Int,
        Int,
        Boolean,
        CPointer<GtkTooltip>,
        COpaquePointer?
    ) -> Unit>> by lazy { Signal4<Widget, Int, Int, Boolean, CPointer<GtkTooltip>, CFunction<(
                CPointer<in CPointed>?,
                Int,
                Int,
                Boolean,
                CPointer<GtkTooltip>,
                COpaquePointer?
            ) -> Unit>>(widgetPtr!!, this, "query-tooltip",
                    staticCFunction(::Widget_onQueryTooltip_Handler)) }

    val onRealize: Signal<Widget, CFunction<(CPointer<in CPointed>?, COpaquePointer?) -> Unit>> by
            lazy { Signal<Widget, CFunction<(CPointer<in CPointed>?, COpaquePointer?) ->
            Unit>>(widgetPtr!!, this, "realize", staticCFunction(::Widget_onRealize_Handler)) }

    val onScreenChanged: Signal1<Widget, CPointer<GdkScreen>, CFunction<(
        CPointer<in CPointed>?,
        CPointer<GdkScreen>,
        COpaquePointer?
    ) -> Unit>> by lazy { Signal1<Widget, CPointer<GdkScreen>, CFunction<(
                CPointer<in CPointed>?,
                CPointer<GdkScreen>,
                COpaquePointer?
            ) -> Unit>>(widgetPtr!!, this, "screen-changed",
                    staticCFunction(::Widget_onScreenChanged_Handler)) }

    val onScrollEvent: Signal1<Widget, CPointer<GdkEventScroll>, CFunction<(
        CPointer<in CPointed>?,
        CPointer<GdkEventScroll>,
        COpaquePointer?
    ) -> Unit>> by lazy { Signal1<Widget, CPointer<GdkEventScroll>, CFunction<(
                CPointer<in CPointed>?,
                CPointer<GdkEventScroll>,
                COpaquePointer?
            ) -> Unit>>(widgetPtr!!, this, "scroll-event",
                    staticCFunction(::Widget_onScrollEvent_Handler)) }

    val onSelectionClearEvent: Signal1<Widget, CPointer<GdkEventSelection>, CFunction<(
        CPointer<in CPointed>?,
        CPointer<GdkEventSelection>,
        COpaquePointer?
    ) -> Unit>> by lazy { Signal1<Widget, CPointer<GdkEventSelection>, CFunction<(
                CPointer<in CPointed>?,
                CPointer<GdkEventSelection>,
                COpaquePointer?
            ) -> Unit>>(widgetPtr!!, this, "selection-clear-event",
                    staticCFunction(::Widget_onSelectionClearEvent_Handler)) }

    val onSelectionGet: Signal3<Widget, CPointer<GtkSelectionData>, UInt, UInt, CFunction<(
        CPointer<in CPointed>?,
        CPointer<GtkSelectionData>,
        UInt,
        UInt,
        COpaquePointer?
    ) -> Unit>> by lazy { Signal3<Widget, CPointer<GtkSelectionData>, UInt, UInt, CFunction<(
                CPointer<in CPointed>?,
                CPointer<GtkSelectionData>,
                UInt,
                UInt,
                COpaquePointer?
            ) -> Unit>>(widgetPtr!!, this, "selection-get",
                    staticCFunction(::Widget_onSelectionGet_Handler)) }

    val onSelectionNotifyEvent: Signal1<Widget, CPointer<GdkEventSelection>, CFunction<(
        CPointer<in CPointed>?,
        CPointer<GdkEventSelection>,
        COpaquePointer?
    ) -> Unit>> by lazy { Signal1<Widget, CPointer<GdkEventSelection>, CFunction<(
                CPointer<in CPointed>?,
                CPointer<GdkEventSelection>,
                COpaquePointer?
            ) -> Unit>>(widgetPtr!!, this, "selection-notify-event",
                    staticCFunction(::Widget_onSelectionNotifyEvent_Handler)) }

    val onSelectionReceived: Signal2<Widget, CPointer<GtkSelectionData>, UInt, CFunction<(
        CPointer<in CPointed>?,
        CPointer<GtkSelectionData>,
        UInt,
        COpaquePointer?
    ) -> Unit>> by lazy { Signal2<Widget, CPointer<GtkSelectionData>, UInt, CFunction<(
                CPointer<in CPointed>?,
                CPointer<GtkSelectionData>,
                UInt,
                COpaquePointer?
            ) -> Unit>>(widgetPtr!!, this, "selection-received",
                    staticCFunction(::Widget_onSelectionReceived_Handler)) }

    val onSelectionRequestEvent: Signal1<Widget, CPointer<GdkEventSelection>, CFunction<(
        CPointer<in CPointed>?,
        CPointer<GdkEventSelection>,
        COpaquePointer?
    ) -> Unit>> by lazy { Signal1<Widget, CPointer<GdkEventSelection>, CFunction<(
                CPointer<in CPointed>?,
                CPointer<GdkEventSelection>,
                COpaquePointer?
            ) -> Unit>>(widgetPtr!!, this, "selection-request-event",
                    staticCFunction(::Widget_onSelectionRequestEvent_Handler)) }

    val onShow: Signal<Widget, CFunction<(CPointer<in CPointed>?, COpaquePointer?) -> Unit>> by
            lazy { Signal<Widget, CFunction<(CPointer<in CPointed>?, COpaquePointer?) ->
            Unit>>(widgetPtr!!, this, "show", staticCFunction(::Widget_onShow_Handler)) }

    val onSizeAllocate: Signal1<Widget, CPointer<GtkAllocation>, CFunction<(
        CPointer<in CPointed>?,
        CPointer<GtkAllocation>,
        COpaquePointer?
    ) -> Unit>> by lazy { Signal1<Widget, CPointer<GtkAllocation>, CFunction<(
                CPointer<in CPointed>?,
                CPointer<GtkAllocation>,
                COpaquePointer?
            ) -> Unit>>(widgetPtr!!, this, "size-allocate",
                    staticCFunction(::Widget_onSizeAllocate_Handler)) }

    val onStyleSet: Signal1<Widget, CPointer<GtkStyle>, CFunction<(
        CPointer<in CPointed>?,
        CPointer<GtkStyle>,
        COpaquePointer?
    ) -> Unit>> by lazy { Signal1<Widget, CPointer<GtkStyle>, CFunction<(
                CPointer<in CPointed>?,
                CPointer<GtkStyle>,
                COpaquePointer?
            ) -> Unit>>(widgetPtr!!, this, "style-set",
                    staticCFunction(::Widget_onStyleSet_Handler)) }

    val onStyleUpdated: Signal<Widget, CFunction<(CPointer<in CPointed>?, COpaquePointer?) -> Unit>>
            by lazy { Signal<Widget, CFunction<(CPointer<in CPointed>?, COpaquePointer?) ->
            Unit>>(widgetPtr!!, this, "style-updated",
            staticCFunction(::Widget_onStyleUpdated_Handler)) }

    val onTouchEvent: Signal1<Widget, CPointer<GdkEvent>, CFunction<(
        CPointer<in CPointed>?,
        CPointer<GdkEvent>,
        COpaquePointer?
    ) -> Unit>> by lazy { Signal1<Widget, CPointer<GdkEvent>, CFunction<(
                CPointer<in CPointed>?,
                CPointer<GdkEvent>,
                COpaquePointer?
            ) -> Unit>>(widgetPtr!!, this, "touch-event",
                    staticCFunction(::Widget_onTouchEvent_Handler)) }

    val onUnmap: Signal<Widget, CFunction<(CPointer<in CPointed>?, COpaquePointer?) -> Unit>> by
            lazy { Signal<Widget, CFunction<(CPointer<in CPointed>?, COpaquePointer?) ->
            Unit>>(widgetPtr!!, this, "unmap", staticCFunction(::Widget_onUnmap_Handler)) }

    val onUnmapEvent: Signal1<Widget, CPointer<GdkEventAny>, CFunction<(
        CPointer<in CPointed>?,
        CPointer<GdkEventAny>,
        COpaquePointer?
    ) -> Unit>> by lazy { Signal1<Widget, CPointer<GdkEventAny>, CFunction<(
                CPointer<in CPointed>?,
                CPointer<GdkEventAny>,
                COpaquePointer?
            ) -> Unit>>(widgetPtr!!, this, "unmap-event",
                    staticCFunction(::Widget_onUnmapEvent_Handler)) }

    val onUnrealize: Signal<Widget, CFunction<(CPointer<in CPointed>?, COpaquePointer?) -> Unit>> by
            lazy { Signal<Widget, CFunction<(CPointer<in CPointed>?, COpaquePointer?) ->
            Unit>>(widgetPtr!!, this, "unrealize", staticCFunction(::Widget_onUnrealize_Handler)) }

    val onVisibilityNotifyEvent: Signal1<Widget, CPointer<GdkEventVisibility>, CFunction<(
        CPointer<in CPointed>?,
        CPointer<GdkEventVisibility>,
        COpaquePointer?
    ) -> Unit>> by lazy { Signal1<Widget, CPointer<GdkEventVisibility>, CFunction<(
                CPointer<in CPointed>?,
                CPointer<GdkEventVisibility>,
                COpaquePointer?
            ) -> Unit>>(widgetPtr!!, this, "visibility-notify-event",
                    staticCFunction(::Widget_onVisibilityNotifyEvent_Handler)) }

    val onWindowStateEvent: Signal1<Widget, CPointer<GdkEventWindowState>, CFunction<(
        CPointer<in CPointed>?,
        CPointer<GdkEventWindowState>,
        COpaquePointer?
    ) -> Unit>> by lazy { Signal1<Widget, CPointer<GdkEventWindowState>, CFunction<(
                CPointer<in CPointed>?,
                CPointer<GdkEventWindowState>,
                COpaquePointer?
            ) -> Unit>>(widgetPtr!!, this, "window-state-event",
                    staticCFunction(::Widget_onWindowStateEvent_Handler)) }

    val allocatedBaseline: Int
        get() = gtk_widget_get_allocated_baseline(self)

    val allocatedHeight: Int
        get() = gtk_widget_get_allocated_height(self)

    val allocatedWidth: Int
        get() = gtk_widget_get_allocated_width(self)

    /**
     * Determines whether the application intends to draw on the widget in
     * an #GtkWidget::draw handler.
     *
     * See gtk_widget_set_app_paintable()
     *
     * Sets whether the application intends to draw on the widget in
     * an #GtkWidget::draw handler.
     *
     * This is a hint to the widget and does not affect the behavior of
     * the GTK+ core; many widgets ignore this flag entirely. For widgets
     * that do pay attention to the flag, such as #GtkEventBox and #GtkWindow,
     * the effect is to suppress default themed drawing of the widget's
     * background. (Children of the widget will still be drawn.) The application
     * is then entirely responsible for drawing the widget background.
     *
     * Note that the background is still drawn when the widget is mapped. */
    var appPaintable: Boolean
        get() = gtk_widget_get_app_paintable(self) != 0
        set(value) {
            gtk_widget_set_app_paintable(self, if (value) gtk_true() else gtk_false())
        }

    /**
     * Determines whether @widget can be a default widget. See
     * gtk_widget_set_can_default().
     *
     * Specifies whether @widget can be a default widget. See
     * gtk_widget_grab_default() for details about the meaning of
     * “default”. */
    var canDefault: Boolean
        get() = gtk_widget_get_can_default(self) != 0
        set(value) {
            gtk_widget_set_can_default(self, if (value) gtk_true() else gtk_false())
        }

    /**
     * Determines whether @widget can own the input focus. See
     * gtk_widget_set_can_focus().
     *
     * Specifies whether @widget can own the input focus. See
     * gtk_widget_grab_focus() for actually setting the input focus on a
     * widget. */
    var canFocus: Boolean
        get() = gtk_widget_get_can_focus(self) != 0
        set(value) {
            gtk_widget_set_can_focus(self, if (value) gtk_true() else gtk_false())
        }

    /**
     * Gets the value set with gtk_widget_set_child_visible().
     * If you feel a need to use this function, your code probably
     * needs reorganization.
     *
     * This function is only useful for container implementations and
     * never should be called by an application.
     *
     * Sets whether @widget should be mapped along with its when its parent
     * is mapped and @widget has been shown with gtk_widget_show().
     *
     * The child visibility can be set for widget before it is added to
     * a container with gtk_widget_set_parent(), to avoid mapping
     * children unnecessary before immediately unmapping them. However
     * it will be reset to its default state of %TRUE when the widget
     * is removed from a container.
     *
     * Note that changing the child visibility of a widget does not
     * queue a resize on the widget. Most of the time, the size of
     * a widget is computed from all visible children, whether or
     * not they are mapped. If this is not the case, the container
     * can queue a resize itself.
     *
     * This function is only useful for container implementations and
     * never should be called by an application. */
    var childVisible: Boolean
        get() = gtk_widget_get_child_visible(self) != 0
        set(value) {
            gtk_widget_set_child_visible(self, if (value) gtk_true() else gtk_false())
        }

    val display: CPointer<GdkDisplay>
        get() = gtk_widget_get_display(self)!!.reinterpret()

    val doubleBuffered: Boolean
        get() = gtk_widget_get_double_buffered(self) != 0

    /**
     * Returns the event mask (see #GdkEventMask) for the widget. These are the
     * events that the widget will receive.
     *
     * Note: Internally, the widget event mask will be the logical OR of the event
     * mask set through gtk_widget_set_events() or gtk_widget_add_events(), and the
     * event mask necessary to cater for every #GtkEventController created for the
     * widget.
     *
     * Sets the event mask (see #GdkEventMask) for a widget. The event
     * mask determines which events a widget will receive. Keep in mind
     * that different widgets have different default event masks, and by
     * changing the event mask you may disrupt a widget’s functionality,
     * so be careful. This function must be called while a widget is
     * unrealized. Consider gtk_widget_add_events() for widgets that are
     * already realized, or if you want to preserve the existing event
     * mask. This function can’t be used with widgets that have no window.
     * (See gtk_widget_get_has_window()).  To get events on those widgets,
     * place them inside a #GtkEventBox and receive events on the event
     * box. */
    var events: Int
        get() = gtk_widget_get_events(self)
        set(value) {
            gtk_widget_set_events(self, value)
        }

    /**
     * Returns whether the widget should grab focus when it is clicked with the mouse.
     * See gtk_widget_set_focus_on_click().
     *
     * Sets whether the widget should grab focus when it is clicked with the mouse.
     * Making mouse clicks not grab focus is useful in places like toolbars where
     * you don’t want the keyboard focus removed from the main area of the
     * application. */
    var focusOnClick: Boolean
        get() = gtk_widget_get_focus_on_click(self) != 0
        set(value) {
            gtk_widget_set_focus_on_click(self, if (value) gtk_true() else gtk_false())
        }

    val frameClock: CPointer<GdkFrameClock>
        get() = gtk_widget_get_frame_clock(self)!!.reinterpret()

    /**
     * Gets the value of the #GtkWidget:halign property.
     *
     * For backwards compatibility reasons this method will never return
     * %GTK_ALIGN_BASELINE, but instead it will convert it to
     * %GTK_ALIGN_FILL. Baselines are not supported for horizontal
     * alignment.
     *
     * Sets the horizontal alignment of @widget.
     * See the #GtkWidget:halign property. */
    var halign: GtkAlign
        get() = gtk_widget_get_halign(self)
        set(value) {
            gtk_widget_set_halign(self, value)
        }

    /**
     * Returns the current value of the has-tooltip property.  See
     * #GtkWidget:has-tooltip for more information.
     *
     * Sets the has-tooltip property on @widget to @has_tooltip.  See
     * #GtkWidget:has-tooltip for more information. */
    var hasTooltip: Boolean
        get() = gtk_widget_get_has_tooltip(self) != 0
        set(value) {
            gtk_widget_set_has_tooltip(self, if (value) gtk_true() else gtk_false())
        }

    /**
     * Determines whether @widget has a #GdkWindow of its own. See
     * gtk_widget_set_has_window().
     *
     * Specifies whether @widget has a #GdkWindow of its own. Note that
     * all realized widgets have a non-%NULL “window” pointer
     * (gtk_widget_get_window() never returns a %NULL window when a widget
     * is realized), but for many of them it’s actually the #GdkWindow of
     * one of its parent widgets. Widgets that do not create a %window for
     * themselves in #GtkWidget::realize must announce this by
     * calling this function with @has_window = %FALSE.
     *
     * This function should only be called by widget implementations,
     * and they should call it in their init() function. */
    var hasWindow: Boolean
        get() = gtk_widget_get_has_window(self) != 0
        set(value) {
            gtk_widget_set_has_window(self, if (value) gtk_true() else gtk_false())
        }

    /**
     * Gets whether the widget would like any available extra horizontal
     * space. When a user resizes a #GtkWindow, widgets with expand=TRUE
     * generally receive the extra space. For example, a list or
     * scrollable area or document in your window would often be set to
     * expand.
     *
     * Containers should use gtk_widget_compute_expand() rather than
     * this function, to see whether a widget, or any of its children,
     * has the expand flag set. If any child of a widget wants to
     * expand, the parent may ask to expand also.
     *
     * This function only looks at the widget’s own hexpand flag, rather
     * than computing whether the entire widget tree rooted at this widget
     * wants to expand.
     *
     * Sets whether the widget would like any available extra horizontal
     * space. When a user resizes a #GtkWindow, widgets with expand=TRUE
     * generally receive the extra space. For example, a list or
     * scrollable area or document in your window would often be set to
     * expand.
     *
     * Call this function to set the expand flag if you would like your
     * widget to become larger horizontally when the window has extra
     * room.
     *
     * By default, widgets automatically expand if any of their children
     * want to expand. (To see if a widget will automatically expand given
     * its current children and state, call gtk_widget_compute_expand(). A
     * container can decide how the expandability of children affects the
     * expansion of the container by overriding the compute_expand virtual
     * method on #GtkWidget.).
     *
     * Setting hexpand explicitly with this function will override the
     * automatic expand behavior.
     *
     * This function forces the widget to expand or not to expand,
     * regardless of children.  The override occurs because
     * gtk_widget_set_hexpand() sets the hexpand-set property (see
     * gtk_widget_set_hexpand_set()) which causes the widget’s hexpand
     * value to be used, rather than looking at children and widget state. */
    var hexpand: Boolean
        get() = gtk_widget_get_hexpand(self) != 0
        set(value) {
            gtk_widget_set_hexpand(self, if (value) gtk_true() else gtk_false())
        }

    /**
     * Gets whether gtk_widget_set_hexpand() has been used to
     * explicitly set the expand flag on this widget.
     *
     * If hexpand is set, then it overrides any computed
     * expand value based on child widgets. If hexpand is not
     * set, then the expand value depends on whether any
     * children of the widget would like to expand.
     *
     * There are few reasons to use this function, but it’s here
     * for completeness and consistency.
     *
     * Sets whether the hexpand flag (see gtk_widget_get_hexpand()) will
     * be used.
     *
     * The hexpand-set property will be set automatically when you call
     * gtk_widget_set_hexpand() to set hexpand, so the most likely
     * reason to use this function would be to unset an explicit expand
     * flag.
     *
     * If hexpand is set, then it overrides any computed
     * expand value based on child widgets. If hexpand is not
     * set, then the expand value depends on whether any
     * children of the widget would like to expand.
     *
     * There are few reasons to use this function, but it’s here
     * for completeness and consistency. */
    var hexpandSet: Boolean
        get() = gtk_widget_get_hexpand_set(self) != 0
        set(value) {
            gtk_widget_set_hexpand_set(self, if (value) gtk_true() else gtk_false())
        }

    /**
     * Whether the widget is mapped.
     *
     * Marks the widget as being mapped.
     *
     * This function should only ever be called in a derived widget's
     * “map” or “unmap” implementation. */
    var mapped: Boolean
        get() = gtk_widget_get_mapped(self) != 0
        set(value) {
            gtk_widget_set_mapped(self, if (value) gtk_true() else gtk_false())
        }

    /**
     * Gets the value of the #GtkWidget:margin-bottom property.
     *
     * Sets the bottom margin of @widget.
     * See the #GtkWidget:margin-bottom property. */
    var marginBottom: Int
        get() = gtk_widget_get_margin_bottom(self)
        set(value) {
            gtk_widget_set_margin_bottom(self, value)
        }

    /**
     * Gets the value of the #GtkWidget:margin-end property.
     *
     * Sets the end margin of @widget.
     * See the #GtkWidget:margin-end property. */
    var marginEnd: Int
        get() = gtk_widget_get_margin_end(self)
        set(value) {
            gtk_widget_set_margin_end(self, value)
        }

    /**
     * Gets the value of the #GtkWidget:margin-start property.
     *
     * Sets the start margin of @widget.
     * See the #GtkWidget:margin-start property. */
    var marginStart: Int
        get() = gtk_widget_get_margin_start(self)
        set(value) {
            gtk_widget_set_margin_start(self, value)
        }

    /**
     * Gets the value of the #GtkWidget:margin-top property.
     *
     * Sets the top margin of @widget.
     * See the #GtkWidget:margin-top property. */
    var marginTop: Int
        get() = gtk_widget_get_margin_top(self)
        set(value) {
            gtk_widget_set_margin_top(self, value)
        }

    /**
     * Retrieves the name of a widget. See gtk_widget_set_name() for the
     * significance of widget names.
     *
     * Widgets can be named, which allows you to refer to them from a
     * CSS file. You can apply a style to widgets with a particular name
     * in the CSS file. See the documentation for the CSS syntax (on the
     * same page as the docs for #GtkStyleContext).
     *
     * Note that the CSS syntax has certain special characters to delimit
     * and represent elements in a selector (period, #, >, *...), so using
     * these will make your widget impossible to match by name. Any combination
     * of alphanumeric symbols, dashes and underscores will suffice. */
    var name: String
        get() = gtk_widget_get_name(self)?.toKString() ?: ""
        set(value) {
            gtk_widget_set_name(self, value)
        }

    /**
     * Returns the current value of the #GtkWidget:no-show-all property,
     * which determines whether calls to gtk_widget_show_all()
     * will affect this widget.
     *
     * Sets the #GtkWidget:no-show-all property, which determines whether
     * calls to gtk_widget_show_all() will affect this widget.
     *
     * This is mostly for use in constructing widget hierarchies with externally
     * controlled visibility, see #GtkUIManager. */
    var noShowAll: Boolean
        get() = gtk_widget_get_no_show_all(self) != 0
        set(value) {
            gtk_widget_set_no_show_all(self, if (value) gtk_true() else gtk_false())
        }

    /**
     * Fetches the requested opacity for this widget.
     * See gtk_widget_set_opacity().
     *
     * Request the @widget to be rendered partially transparent,
     * with opacity 0 being fully transparent and 1 fully opaque. (Opacity values
     * are clamped to the [0,1] range.).
     * This works on both toplevel widget, and child widgets, although there
     * are some limitations:
     *
     * For toplevel widgets this depends on the capabilities of the windowing
     * system. On X11 this has any effect only on X screens with a compositing manager
     * running. See gtk_widget_is_composited(). On Windows it should work
     * always, although setting a window’s opacity after the window has been
     * shown causes it to flicker once on Windows.
     *
     * For child widgets it doesn’t work if any affected widget has a native window, or
     * disables double buffering. */
    var opacity: Double
        get() = gtk_widget_get_opacity(self)
        set(value) {
            gtk_widget_set_opacity(self, value)
        }

    /**
     * Returns the parent container of @widget.
     *
     * This function is useful only when implementing subclasses of
     * #GtkContainer.
     * Sets the container as the parent of @widget, and takes care of
     * some details such as updating the state and style of the child
     * to reflect its new location. The opposite function is
     * gtk_widget_unparent(). */
    var parent: CPointer<GtkWidget>
        get() = gtk_widget_get_parent(self)!!.reinterpret()
        set(value) {
            gtk_widget_set_parent(self, value?.reinterpret())
        }

    /**
     * Gets @widget’s parent window, or %NULL if it does not have one.
     *
     * Sets a non default parent window for @widget.
     *
     * For #GtkWindow classes, setting a @parent_window effects whether
     * the window is a toplevel window or can be embedded into other
     * widgets.
     *
     * For #GtkWindow classes, this needs to be called before the
     * window is realized. */
    var parentWindow: CPointer<GdkWindow>
        get() = gtk_widget_get_parent_window(self)!!.reinterpret()
        set(value) {
            gtk_widget_set_parent_window(self, value?.reinterpret())
        }

    val path: CPointer<GtkWidgetPath>
        get() = gtk_widget_get_path(self)!!.reinterpret()

    /**
     * Determines whether @widget is realized.
     *
     * Marks the widget as being realized. This function must only be
     * called after all #GdkWindows for the @widget have been created
     * and registered.
     *
     * This function should only ever be called in a derived widget's
     * “realize” or “unrealize” implementation. */
    var realized: Boolean
        get() = gtk_widget_get_realized(self) != 0
        set(value) {
            gtk_widget_set_realized(self, if (value) gtk_true() else gtk_false())
        }

    /**
     * Determines whether @widget is always treated as the default widget
     * within its toplevel when it has the focus, even if another widget
     * is the default.
     *
     * See gtk_widget_set_receives_default().
     *
     * Specifies whether @widget will be treated as the default widget
     * within its toplevel when it has the focus, even if another widget
     * is the default.
     *
     * See gtk_widget_grab_default() for details about the meaning of
     * “default”. */
    var receivesDefault: Boolean
        get() = gtk_widget_get_receives_default(self) != 0
        set(value) {
            gtk_widget_set_receives_default(self, if (value) gtk_true() else gtk_false())
        }

    val requestMode: GtkSizeRequestMode
        get() = gtk_widget_get_request_mode(self)

    val scaleFactor: Int
        get() = gtk_widget_get_scale_factor(self)

    /**
     * Returns the widget’s sensitivity (in the sense of returning
     * the value that has been set using gtk_widget_set_sensitive()).
     *
     * The effective sensitivity of a widget is however determined by both its
     * own and its parent widget’s sensitivity. See gtk_widget_is_sensitive().
     *
     * Sets the sensitivity of a widget. A widget is sensitive if the user
     * can interact with it. Insensitive widgets are “grayed out” and the
     * user can’t interact with them. Insensitive widgets are known as
     * “inactive”, “disabled”, or “ghosted” in some other toolkits. */
    var sensitive: Boolean
        get() = gtk_widget_get_sensitive(self) != 0
        set(value) {
            gtk_widget_set_sensitive(self, if (value) gtk_true() else gtk_false())
        }

    val settings: CPointer<GtkSettings>
        get() = gtk_widget_get_settings(self)!!.reinterpret()

    val stateFlags: GtkStateFlags
        get() = gtk_widget_get_state_flags(self)

    val styleContext: CPointer<GtkStyleContext>
        get() = gtk_widget_get_style_context(self)!!.reinterpret()

    /**
     * Returns %TRUE if @widget is multiple pointer aware. See
     * gtk_widget_set_support_multidevice() for more information.
     *
     * Enables or disables multiple pointer awareness. If this setting is %TRUE,
     * @widget will start receiving multiple, per device enter/leave events. Note
     * that if custom #GdkWindows are created in #GtkWidget::realize,
     * gdk_window_set_support_multidevice() will have to be called manually on them. */
    var supportMultidevice: Boolean
        get() = gtk_widget_get_support_multidevice(self) != 0
        set(value) {
            gtk_widget_set_support_multidevice(self, if (value) gtk_true() else gtk_false())
        }

    /**
     * Gets the contents of the tooltip for @widget.
     *
     * Sets @markup as the contents of the tooltip, which is marked up with
     *  the [Pango text markup language][PangoMarkupFormat].
     *
     * This function will take care of setting #GtkWidget:has-tooltip to %TRUE
     * and of the default handler for the #GtkWidget::query-tooltip signal.
     *
     * See also the #GtkWidget:tooltip-markup property and
     * gtk_tooltip_set_markup(). */
    var tooltipMarkup: String
        get() = gtk_widget_get_tooltip_markup(self)?.toKString() ?: ""
        set(value) {
            gtk_widget_set_tooltip_markup(self, value)
        }

    /**
     * Gets the contents of the tooltip for @widget.
     *
     * Sets @text as the contents of the tooltip. This function will take
     * care of setting #GtkWidget:has-tooltip to %TRUE and of the default
     * handler for the #GtkWidget::query-tooltip signal.
     *
     * See also the #GtkWidget:tooltip-text property and gtk_tooltip_set_text(). */
    var tooltipText: String
        get() = gtk_widget_get_tooltip_text(self)?.toKString() ?: ""
        set(value) {
            gtk_widget_set_tooltip_text(self, value)
        }

    /**
     * Returns the #GtkWindow of the current tooltip. This can be the
     * GtkWindow created by default, or the custom tooltip window set
     * using gtk_widget_set_tooltip_window().
     *
     * Replaces the default window used for displaying
     * tooltips with @custom_window. GTK+ will take care of showing and
     * hiding @custom_window at the right moment, to behave likewise as
     * the default tooltip window. If @custom_window is %NULL, the default
     * tooltip window will be used. */
    var tooltipWindow: CPointer<GtkWindow>
        get() = gtk_widget_get_tooltip_window(self)!!.reinterpret()
        set(value) {
            gtk_widget_set_tooltip_window(self, value?.reinterpret())
        }

    val toplevel: CPointer<GtkWidget>
        get() = gtk_widget_get_toplevel(self)!!.reinterpret()

    /**
     * Gets the value of the #GtkWidget:valign property.
     *
     * For backwards compatibility reasons this method will never return
     * %GTK_ALIGN_BASELINE, but instead it will convert it to
     * %GTK_ALIGN_FILL. If your widget want to support baseline aligned
     * children it must use gtk_widget_get_valign_with_baseline(), or
     * `g_object_get (widget, "valign", &value, NULL)`, which will
     * also report the true value.
     *
     * Sets the vertical alignment of @widget.
     * See the #GtkWidget:valign property. */
    var valign: GtkAlign
        get() = gtk_widget_get_valign(self)
        set(value) {
            gtk_widget_set_valign(self, value)
        }

    val valignWithBaseline: GtkAlign
        get() = gtk_widget_get_valign_with_baseline(self)

    /**
     * Gets whether the widget would like any available extra vertical
     * space.
     *
     * See gtk_widget_get_hexpand() for more detail.
     *
     * Sets whether the widget would like any available extra vertical
     * space.
     *
     * See gtk_widget_set_hexpand() for more detail. */
    var vexpand: Boolean
        get() = gtk_widget_get_vexpand(self) != 0
        set(value) {
            gtk_widget_set_vexpand(self, if (value) gtk_true() else gtk_false())
        }

    /**
     * Gets whether gtk_widget_set_vexpand() has been used to
     * explicitly set the expand flag on this widget.
     *
     * See gtk_widget_get_hexpand_set() for more detail.
     *
     * Sets whether the vexpand flag (see gtk_widget_get_vexpand()) will
     * be used.
     *
     * See gtk_widget_set_hexpand_set() for more detail. */
    var vexpandSet: Boolean
        get() = gtk_widget_get_vexpand_set(self) != 0
        set(value) {
            gtk_widget_set_vexpand_set(self, if (value) gtk_true() else gtk_false())
        }

    /**
     * Determines whether the widget is visible. If you want to
     * take into account whether the widget’s parent is also marked as
     * visible, use gtk_widget_is_visible() instead.
     *
     * This function does not check if the widget is obscured in any way.
     *
     * See gtk_widget_set_visible().
     *
     * Sets the visibility state of @widget. Note that setting this to
     * %TRUE doesn’t mean the widget is actually viewable, see
     * gtk_widget_get_visible().
     *
     * This function simply calls gtk_widget_show() or gtk_widget_hide()
     * but is nicer to use when the visibility of the widget depends on
     * some condition. */
    var visible: Boolean
        get() = gtk_widget_get_visible(self) != 0
        set(value) {
            gtk_widget_set_visible(self, if (value) gtk_true() else gtk_false())
        }

    /**
     * Gets the visual that will be used to render @widget.
     *
     * Sets the visual that should be used for by widget and its children for
     * creating #GdkWindows. The visual must be on the same #GdkScreen as
     * returned by gtk_widget_get_screen(), so handling the
     * #GtkWidget::screen-changed signal is necessary.
     *
     * Setting a new @visual will not cause @widget to recreate its windows,
     * so you should call this function before @widget is realized. */
    var visual: CPointer<GdkVisual>
        get() = gtk_widget_get_visual(self)!!.reinterpret()
        set(value) {
            gtk_widget_set_visual(self, value?.reinterpret())
        }

    /**
     * Returns the widget’s window if it is realized, %NULL otherwise
     *
     * Sets a widget’s window. This function should only be used in a
     * widget’s #GtkWidget::realize implementation. The %window passed is
     * usually either new window created with gdk_window_new(), or the
     * window of its parent widget as returned by
     * gtk_widget_get_parent_window().
     *
     * Widgets must indicate whether they will create their own #GdkWindow
     * by calling gtk_widget_set_has_window(). This is usually done in the
     * widget’s init() function.
     *
     * Note that this function does not add any reference to @window. */
    var gdkWindow: CPointer<GdkWindow>
        get() = gtk_widget_get_window(self)!!.reinterpret()
        set(value) {
            gtk_widget_set_window(self, value?.reinterpret())
        }

    /**
     * Installs an accelerator for this @widget in @accel_group that causes
     * @accel_signal to be emitted if the accelerator is activated.
     * The @accel_group needs to be added to the widget’s toplevel via
     * gtk_window_add_accel_group(), and the signal must be of type %G_SIGNAL_ACTION.
     * Accelerators added through this function are not user changeable during
     * runtime. If you want to support accelerators that can be changed by the
     * user, use gtk_accel_map_add_entry() and gtk_widget_set_accel_path() or
     * gtk_menu_item_set_accel_path() instead.
     */
    fun addAccelerator(
        accel_signal: String,
        accel_group: CPointer<GtkAccelGroup>,
        accel_key: UInt,
        accel_mods: GdkModifierType,
        accel_flags: GtkAccelFlags
    ): Unit = gtk_widget_add_accelerator(self, accel_signal, accel_group, accel_key, accel_mods,
            accel_flags)

    /**
     * Adds the device events in the bitfield @events to the event mask for
     * @widget. See gtk_widget_set_device_events() for details.
     */
    fun addDeviceEvents(device: CPointer<GdkDevice>, events: GdkEventMask): Unit =
            gtk_widget_add_device_events(self, device, events)

    /**
     * Adds the events in the bitfield @events to the event mask for
     * @widget. See gtk_widget_set_events() and the
     * [input handling overview][event-masks] for details.
     */
    fun addEvents(events: Int): Unit = gtk_widget_add_events(self, events)

    /**
     * Adds a widget to the list of mnemonic labels for
     * this widget. (See gtk_widget_list_mnemonic_labels()). Note the
     * list of mnemonic labels for the widget is cleared when the
     * widget is destroyed, so the caller must make sure to update
     * its internal state at this point as well, by using a connection
     * to the #GtkWidget::destroy signal or a weak notifier.
     */
    fun addMnemonicLabel(label: CPointer<GtkWidget>): Unit = gtk_widget_add_mnemonic_label(self,
            label)

    /**
     * Adds a widget to the list of mnemonic labels for
     * this widget. (See gtk_widget_list_mnemonic_labels()). Note the
     * list of mnemonic labels for the widget is cleared when the
     * widget is destroyed, so the caller must make sure to update
     * its internal state at this point as well, by using a connection
     * to the #GtkWidget::destroy signal or a weak notifier.
     */
    fun addMnemonicLabel(label: Widget): Unit = gtk_widget_add_mnemonic_label(self,
            label.widgetPtr?.reinterpret())

    /**
     * Determines whether an accelerator that activates the signal
     * identified by @signal_id can currently be activated.
     * This is done by emitting the #GtkWidget::can-activate-accel
     * signal on @widget; if the signal isn’t overridden by a
     * handler or in a derived widget, then the default check is
     * that the widget must be sensitive, and the widget and all
     * its ancestors mapped.
     */
    fun canActivateAccel(signal_id: UInt): Boolean = gtk_widget_can_activate_accel(self,
            signal_id) != 0

    /**
     * This function is used by custom widget implementations; if you're
     * writing an app, you’d use gtk_widget_grab_focus() to move the focus
     * to a particular widget, and gtk_container_set_focus_chain() to
     * change the focus tab order. So you may want to investigate those
     * functions instead.
     *
     * gtk_widget_child_focus() is called by containers as the user moves
     * around the window using keyboard shortcuts. @direction indicates
     * what kind of motion is taking place (up, down, left, right, tab
     * forward, tab backward). gtk_widget_child_focus() emits the
     * #GtkWidget::focus signal; widgets override the default handler
     * for this signal in order to implement appropriate focus behavior.
     *
     * The default ::focus handler for a widget should return %TRUE if
     * moving in @direction left the focus on a focusable location inside
     * that widget, and %FALSE if moving in @direction moved the focus
     * outside the widget. If returning %TRUE, widgets normally
     * call gtk_widget_grab_focus() to place the focus accordingly;
     * if returning %FALSE, they don’t modify the current focus location.
     */
    fun childFocus(direction: GtkDirectionType): Boolean = gtk_widget_child_focus(self,
            direction) != 0

    /**
     * Emits a #GtkWidget::child-notify signal for the
     * [child property][child-properties] @child_property
     * on @widget.
     *
     * This is the analogue of g_object_notify() for child properties.
     *
     * Also see gtk_container_child_notify().
     */
    fun childNotify(child_property: String): Unit = gtk_widget_child_notify(self, child_property)

    /**
     * Computes whether a container should give this widget extra space
     * when possible. Containers should check this, rather than
     * looking at gtk_widget_get_hexpand() or gtk_widget_get_vexpand().
     *
     * This function already checks whether the widget is visible, so
     * visibility does not need to be checked separately. Non-visible
     * widgets are not expanded.
     *
     * The computed expand value uses either the expand setting explicitly
     * set on the widget itself, or, if none has been explicitly set,
     * the widget may expand if some of its children do.
     */
    fun computeExpand(orientation: GtkOrientation): Boolean = gtk_widget_compute_expand(self,
            orientation) != 0

    /**
     * Destroys a widget.
     *
     * When a widget is destroyed all references it holds on other objects
     * will be released:
     *
     *  - if the widget is inside a container, it will be removed from its
     *  parent
     *  - if the widget is a container, all its children will be destroyed,
     *  recursively
     *  - if the widget is a top level, it will be removed from the list
     *  of top level widgets that GTK+ maintains internally
     *
     * It's expected that all references held on the widget will also
     * be released; you should connect to the #GtkWidget::destroy signal
     * if you hold a reference to @widget and you wish to remove it when
     * this function is called. It is not necessary to do so if you are
     * implementing a #GtkContainer, as you'll be able to use the
     * #GtkContainerClass.remove() virtual function for that.
     *
     * It's important to notice that gtk_widget_destroy() will only cause
     * the @widget to be finalized if no additional references, acquired
     * using g_object_ref(), are held on it. In case additional references
     * are in place, the @widget will be in an "inert" state after calling
     * this function; @widget will still point to valid memory, allowing you
     * to release the references you hold, but you may not query the widget's
     * own state.
     *
     * You should typically call this function on top level widgets, and
     * rarely on child widgets.
     *
     * See also: gtk_container_remove()
     */
    fun destroy(): Unit = gtk_widget_destroy(self)

    /**
     * Returns %TRUE if @device has been shadowed by a GTK+
     * device grab on another widget, so it would stop sending
     * events to @widget. This may be used in the
     * #GtkWidget::grab-notify signal to check for specific
     * devices. See gtk_device_grab_add().
     */
    fun deviceIsShadowed(device: CPointer<GdkDevice>): Boolean = gtk_widget_device_is_shadowed(self,
            device) != 0

    /**
     * Initiates a drag on the source side. The function only needs to be used
     * when the application is starting drags itself, and is not needed when
     * gtk_drag_source_set() is used.
     *
     * The @event is used to retrieve the timestamp that will be used internally to
     * grab the pointer.  If @event is %NULL, then %GDK_CURRENT_TIME will be used.
     * However, you should try to pass a real event in all cases, since that can be
     * used to get information about the drag.
     *
     * Generally there are three cases when you want to start a drag by hand by
     * calling this function:
     *
     * 1. During a #GtkWidget::button-press-event handler, if you want to start a drag
     * immediately when the user presses the mouse button.  Pass the @event
     * that you have in your #GtkWidget::button-press-event handler.
     *
     * 2. During a #GtkWidget::motion-notify-event handler, if you want to start a drag
     * when the mouse moves past a certain threshold distance after a button-press.
     * Pass the @event that you have in your #GtkWidget::motion-notify-event handler.
     *
     * 3. During a timeout handler, if you want to start a drag after the mouse
     * button is held down for some time.  Try to save the last event that you got
     * from the mouse, using gdk_event_copy(), and pass it to this function
     * (remember to free the event with gdk_event_free() when you are done).
     * If you really cannot pass a real event, pass %NULL instead.
     */
    fun dragBeginWithCoordinates(
        targets: CPointer<GtkTargetList>,
        actions: GdkDragAction,
        button: Int,
        event: CPointer<GdkEvent>,
        x: Int,
        y: Int
    ): CPointer<GdkDragContext> = gtk_drag_begin_with_coordinates(self, targets, actions, button,
            event, x, y)!!.reinterpret()

    /**
     * Checks to see if a mouse drag starting at (@start_x, @start_y) and ending
     * at (@current_x, @current_y) has passed the GTK+ drag threshold, and thus
     * should trigger the beginning of a drag-and-drop operation.
     */
    fun dragCheckThreshold(
        start_x: Int,
        start_y: Int,
        current_x: Int,
        current_y: Int
    ): Boolean = gtk_drag_check_threshold(self, start_x, start_y, current_x, current_y) != 0

    /**
     * Add the image targets supported by #GtkSelectionData to
     * the target list of the drag destination. The targets
     * are added with @info = 0. If you need another value,
     * use gtk_target_list_add_image_targets() and
     * gtk_drag_dest_set_target_list().
     */
    fun dragDestAddImageTargets(): Unit = gtk_drag_dest_add_image_targets(self)

    /**
     * Add the text targets supported by #GtkSelectionData to
     * the target list of the drag destination. The targets
     * are added with @info = 0. If you need another value,
     * use gtk_target_list_add_text_targets() and
     * gtk_drag_dest_set_target_list().
     */
    fun dragDestAddTextTargets(): Unit = gtk_drag_dest_add_text_targets(self)

    /**
     * Add the URI targets supported by #GtkSelectionData to
     * the target list of the drag destination. The targets
     * are added with @info = 0. If you need another value,
     * use gtk_target_list_add_uri_targets() and
     * gtk_drag_dest_set_target_list().
     */
    fun dragDestAddUriTargets(): Unit = gtk_drag_dest_add_uri_targets(self)

    /**
     * Returns the list of targets this widget can accept from
     * drag-and-drop.
     */
    fun dragDestGetTargetList(): CPointer<GtkTargetList> =
            gtk_drag_dest_get_target_list(self)!!.reinterpret()

    /**
     * Returns whether the widget has been configured to always
     * emit #GtkWidget::drag-motion signals.
     */
    fun dragDestGetTrackMotion(): Boolean = gtk_drag_dest_get_track_motion(self) != 0

    /**
     * Sets the target types that this widget can accept from drag-and-drop.
     * The widget must first be made into a drag destination with
     * gtk_drag_dest_set().
     */
    fun dragDestSetTargetList(target_list: CPointer<GtkTargetList>): Unit =
            gtk_drag_dest_set_target_list(self, target_list)

    /**
     * Tells the widget to emit #GtkWidget::drag-motion and
     * #GtkWidget::drag-leave events regardless of the targets and the
     * %GTK_DEST_DEFAULT_MOTION flag.
     *
     * This may be used when a widget wants to do generic
     * actions regardless of the targets that the source offers.
     */
    fun dragDestSetTrackMotion(track_motion: Boolean): Unit = gtk_drag_dest_set_track_motion(self,
            if (track_motion) gtk_true() else gtk_false())

    /**
     * Clears information about a drop destination set with
     * gtk_drag_dest_set(). The widget will no longer receive
     * notification of drags.
     */
    fun dragDestUnset(): Unit = gtk_drag_dest_unset(self)

    /**
     * Highlights a widget as a currently hovered drop target.
     * To end the highlight, call gtk_drag_unhighlight().
     * GTK+ calls this automatically if %GTK_DEST_DEFAULT_HIGHLIGHT is set.
     */
    fun dragHighlight(): Unit = gtk_drag_highlight(self)

    /**
     * Add the writable image targets supported by #GtkSelectionData to
     * the target list of the drag source. The targets
     * are added with @info = 0. If you need another value,
     * use gtk_target_list_add_image_targets() and
     * gtk_drag_source_set_target_list().
     */
    fun dragSourceAddImageTargets(): Unit = gtk_drag_source_add_image_targets(self)

    /**
     * Add the text targets supported by #GtkSelectionData to
     * the target list of the drag source.  The targets
     * are added with @info = 0. If you need another value,
     * use gtk_target_list_add_text_targets() and
     * gtk_drag_source_set_target_list().
     */
    fun dragSourceAddTextTargets(): Unit = gtk_drag_source_add_text_targets(self)

    /**
     * Add the URI targets supported by #GtkSelectionData to
     * the target list of the drag source.  The targets
     * are added with @info = 0. If you need another value,
     * use gtk_target_list_add_uri_targets() and
     * gtk_drag_source_set_target_list().
     */
    fun dragSourceAddUriTargets(): Unit = gtk_drag_source_add_uri_targets(self)

    /**
     * Gets the list of targets this widget can provide for
     * drag-and-drop.
     */
    fun dragSourceGetTargetList(): CPointer<GtkTargetList> =
            gtk_drag_source_get_target_list(self)!!.reinterpret()

    /**
     * Sets the icon that will be used for drags from a particular source
     * to @icon. See the docs for #GtkIconTheme for more details.
     */
    fun dragSourceSetIconGicon(icon: CPointer<GIcon>): Unit = gtk_drag_source_set_icon_gicon(self,
            icon)

    /**
     * Sets the icon that will be used for drags from a particular source
     * to a themed icon. See the docs for #GtkIconTheme for more details.
     */
    fun dragSourceSetIconName(icon_name: String): Unit = gtk_drag_source_set_icon_name(self,
            icon_name)

    /**
     * Sets the icon that will be used for drags from a particular widget
     * from a #GdkPixbuf. GTK+ retains a reference for @pixbuf and will
     * release it when it is no longer needed.
     */
    fun dragSourceSetIconPixbuf(pixbuf: CPointer<GdkPixbuf>): Unit =
            gtk_drag_source_set_icon_pixbuf(self, pixbuf)

    /**
     * Changes the target types that this widget offers for drag-and-drop.
     * The widget must first be made into a drag source with
     * gtk_drag_source_set().
     */
    fun dragSourceSetTargetList(target_list: CPointer<GtkTargetList>): Unit =
            gtk_drag_source_set_target_list(self, target_list)

    /**
     * Undoes the effects of gtk_drag_source_set().
     */
    fun dragSourceUnset(): Unit = gtk_drag_source_unset(self)

    /**
     * Removes a highlight set by gtk_drag_highlight() from
     * a widget.
     */
    fun dragUnhighlight(): Unit = gtk_drag_unhighlight(self)

    /**
     * Notifies the user about an input-related error on this widget.
     * If the #GtkSettings:gtk-error-bell setting is %TRUE, it calls
     * gdk_window_beep(), otherwise it does nothing.
     *
     * Note that the effect of gdk_window_beep() can be configured in many
     * ways, depending on the windowing backend and the desktop environment
     * or window manager that is used.
     */
    fun errorBell(): Unit = gtk_widget_error_bell(self)

    /**
     * Rarely-used function. This function is used to emit
     * the event signals on a widget (those signals should never
     * be emitted without using this function to do so).
     * If you want to synthesize an event though, don’t use this function;
     * instead, use gtk_main_do_event() so the event will behave as if
     * it were in the event queue. Don’t synthesize expose events; instead,
     * use gdk_window_invalidate_rect() to invalidate a region of the
     * window.
     */
    fun event(event: CPointer<GdkEvent>): Boolean = gtk_widget_event(self, event) != 0

    /**
     * Stops emission of #GtkWidget::child-notify signals on @widget. The
     * signals are queued until gtk_widget_thaw_child_notify() is called
     * on @widget.
     *
     * This is the analogue of g_object_freeze_notify() for child properties.
     */
    fun freezeChildNotify(): Unit = gtk_widget_freeze_child_notify(self)

    /**
     * Retrieves the #GActionGroup that was registered using @prefix. The resulting
     * #GActionGroup may have been registered to @widget or any #GtkWidget in its
     * ancestry.
     *
     * If no action group was found matching @prefix, then %NULL is returned.
     */
    fun getActionGroup(prefix: String): CPointer<GActionGroup> = gtk_widget_get_action_group(self,
            prefix)!!.reinterpret()

    /**
     * Returns whether @device can interact with @widget and its
     * children. See gtk_widget_set_device_enabled().
     */
    fun getDeviceEnabled(device: CPointer<GdkDevice>): Boolean = gtk_widget_get_device_enabled(self,
            device) != 0

    /**
     * Returns the events mask for the widget corresponding to an specific device. These
     * are the events that the widget will receive when @device operates on it.
     */
    fun getDeviceEvents(device: CPointer<GdkDevice>): GdkEventMask =
            gtk_widget_get_device_events(self, device)

    /**
     * Returns the modifier mask the @widget’s windowing system backend
     * uses for a particular purpose.
     *
     * See gdk_keymap_get_modifier_mask().
     */
    fun getModifierMask(intent: GdkModifierIntent): GdkModifierType =
            gtk_widget_get_modifier_mask(self, intent)

    /**
     * Makes @widget the current grabbed widget.
     *
     * This means that interaction with other widgets in the same
     * application is blocked and mouse as well as keyboard events
     * are delivered to this widget.
     *
     * If @widget is not sensitive, it is not set as the current
     * grabbed widget and this function does nothing.
     */
    fun grabAdd(): Unit = gtk_grab_add(self)

    /**
     * Causes @widget to become the default widget. @widget must be able to be
     * a default widget; typically you would ensure this yourself
     * by calling gtk_widget_set_can_default() with a %TRUE value.
     * The default widget is activated when
     * the user presses Enter in a window. Default widgets must be
     * activatable, that is, gtk_widget_activate() should affect them. Note
     * that #GtkEntry widgets require the “activates-default” property
     * set to %TRUE before they activate the default widget when Enter
     * is pressed and the #GtkEntry is focused.
     */
    fun grabDefault(): Unit = gtk_widget_grab_default(self)

    /**
     * Causes @widget to have the keyboard focus for the #GtkWindow it's
     * inside. @widget must be a focusable widget, such as a #GtkEntry;
     * something like #GtkFrame won’t work.
     *
     * More precisely, it must have the %GTK_CAN_FOCUS flag set. Use
     * gtk_widget_set_can_focus() to modify that flag.
     *
     * The widget also needs to be realized and mapped. This is indicated by the
     * related signals. Grabbing the focus immediately after creating the widget
     * will likely fail and cause critical warnings.
     */
    fun grabFocus(): Unit = gtk_widget_grab_focus(self)

    /**
     * Removes the grab from the given widget.
     *
     * You have to pair calls to gtk_grab_add() and gtk_grab_remove().
     *
     * If @widget does not have the grab, this function does nothing.
     */
    fun grabRemove(): Unit = gtk_grab_remove(self)

    /**
     * Determines whether @widget is the current default widget within its
     * toplevel. See gtk_widget_set_can_default().
     */
    fun hasDefault(): Boolean = gtk_widget_has_default(self) != 0

    /**
     * Determines if the widget has the global input focus. See
     * gtk_widget_is_focus() for the difference between having the global
     * input focus, and only having the focus within a toplevel.
     */
    fun hasFocus(): Boolean = gtk_widget_has_focus(self) != 0

    /**
     * Determines whether the widget is currently grabbing events, so it
     * is the only widget receiving input events (keyboard and mouse).
     *
     * See also gtk_grab_add().
     */
    fun hasGrab(): Boolean = gtk_widget_has_grab(self) != 0

    /**
     * Checks whether there is a #GdkScreen is associated with
     * this widget. All toplevel widgets have an associated
     * screen, and all widgets added into a hierarchy with a toplevel
     * window at the top.
     */
    fun hasScreen(): Boolean = gtk_widget_has_screen(self) != 0

    /**
     * Determines if the widget should show a visible indication that
     * it has the global input focus. This is a convenience function for
     * use in ::draw handlers that takes into account whether focus
     * indication should currently be shown in the toplevel window of
     * @widget. See gtk_window_get_focus_visible() for more information
     * about focus indication.
     *
     * To find out if the widget has the global input focus, use
     * gtk_widget_has_focus().
     */
    fun hasVisibleFocus(): Boolean = gtk_widget_has_visible_focus(self) != 0

    /**
     * Reverses the effects of gtk_widget_show(), causing the widget to be
     * hidden (invisible to the user).
     */
    fun hide(): Unit = gtk_widget_hide(self)

    /**
     * Utility function; intended to be connected to the #GtkWidget::delete-event
     * signal on a #GtkWindow. The function calls gtk_widget_hide() on its
     * argument, then returns %TRUE. If connected to ::delete-event, the
     * result is that clicking the close button for a window (on the
     * window frame, top right corner usually) will hide but not destroy
     * the window. By default, GTK+ destroys windows when ::delete-event
     * is received.
     */
    fun hideOnDelete(): Boolean = gtk_widget_hide_on_delete(self) != 0

    /**
     * Returns whether the widget is currently being destroyed.
     * This information can sometimes be used to avoid doing
     * unnecessary work.
     */
    fun inDestruction(): Boolean = gtk_widget_in_destruction(self) != 0

    /**
     * Creates and initializes child widgets defined in templates. This
     * function must be called in the instance initializer for any
     * class which assigned itself a template using gtk_widget_class_set_template()
     *
     * It is important to call this function in the instance initializer
     * of a #GtkWidget subclass and not in #GObject.constructed() or
     * #GObject.constructor() for two reasons.
     *
     * One reason is that generally derived widgets will assume that parent
     * class composite widgets have been created in their instance
     * initializers.
     *
     * Another reason is that when calling g_object_new() on a widget with
     * composite templates, it’s important to build the composite widgets
     * before the construct properties are set. Properties passed to g_object_new()
     * should take precedence over properties set in the private template XML.
     */
    fun initTemplate(): Unit = gtk_widget_init_template(self)

    /**
     * Inserts @group into @widget. Children of @widget that implement
     * #GtkActionable can then be associated with actions in @group by
     * setting their “action-name” to
     * @prefix.`action-name`.
     *
     * If @group is %NULL, a previously inserted group for @name is removed
     * from @widget.
     */
    fun insertActionGroup(name: String, group: CPointer<GActionGroup>): Unit =
            gtk_widget_insert_action_group(self, name, group)

    /**
     * Determines whether @widget is somewhere inside @ancestor, possibly with
     * intermediate containers.
     */
    fun isAncestor(ancestor: CPointer<GtkWidget>): Boolean = gtk_widget_is_ancestor(self,
            ancestor) != 0

    /**
     * Determines whether @widget is somewhere inside @ancestor, possibly with
     * intermediate containers.
     */
    fun isAncestor(ancestor: Widget): Boolean = gtk_widget_is_ancestor(self,
            ancestor.widgetPtr?.reinterpret()) != 0

    /**
     * Determines whether @widget can be drawn to. A widget can be drawn
     * to if it is mapped and visible.
     */
    fun isDrawable(): Boolean = gtk_widget_is_drawable(self) != 0

    /**
     * Determines if the widget is the focus widget within its
     * toplevel. (This does not mean that the #GtkWidget:has-focus property is
     * necessarily set; #GtkWidget:has-focus will only be set if the
     * toplevel widget additionally has the global input focus.)
     */
    fun isFocus(): Boolean = gtk_widget_is_focus(self) != 0

    /**
     * Returns the widget’s effective sensitivity, which means
     * it is sensitive itself and also its parent widget is sensitive
     */
    fun isSensitive(): Boolean = gtk_widget_is_sensitive(self) != 0

    /**
     * Determines whether @widget is a toplevel widget.
     *
     * Currently only #GtkWindow and #GtkInvisible (and out-of-process
     * #GtkPlugs) are toplevel widgets. Toplevel widgets have no parent
     * widget.
     */
    fun isToplevel(): Boolean = gtk_widget_is_toplevel(self) != 0

    /**
     * Determines whether the widget and all its parents are marked as
     * visible.
     *
     * This function does not check if the widget is obscured in any way.
     *
     * See also gtk_widget_get_visible() and gtk_widget_set_visible()
     */
    fun isVisible(): Boolean = gtk_widget_is_visible(self) != 0

    /**
     * This function should be called whenever keyboard navigation within
     * a single widget hits a boundary. The function emits the
     * #GtkWidget::keynav-failed signal on the widget and its return
     * value should be interpreted in a way similar to the return value of
     * gtk_widget_child_focus():
     *
     * When %TRUE is returned, stay in the widget, the failed keyboard
     * navigation is OK and/or there is nowhere we can/should move the
     * focus to.
     *
     * When %FALSE is returned, the caller should continue with keyboard
     * navigation outside the widget, e.g. by calling
     * gtk_widget_child_focus() on the widget’s toplevel.
     *
     * The default ::keynav-failed handler returns %FALSE for
     * %GTK_DIR_TAB_FORWARD and %GTK_DIR_TAB_BACKWARD. For the other
     * values of #GtkDirectionType it returns %TRUE.
     *
     * Whenever the default handler returns %TRUE, it also calls
     * gtk_widget_error_bell() to notify the user of the failed keyboard
     * navigation.
     *
     * A use case for providing an own implementation of ::keynav-failed
     * (either by connecting to it or by overriding it) would be a row of
     * #GtkEntry widgets where the user should be able to navigate the
     * entire row with the cursor keys, as e.g. known from user interfaces
     * that require entering license keys.
     */
    fun keynavFailed(direction: GtkDirectionType): Boolean = gtk_widget_keynav_failed(self,
            direction) != 0

    /**
     * Lists the closures used by @widget for accelerator group connections
     * with gtk_accel_group_connect_by_path() or gtk_accel_group_connect().
     * The closures can be used to monitor accelerator changes on @widget,
     * by connecting to the @GtkAccelGroup::accel-changed signal of the
     * #GtkAccelGroup of a closure which can be found out with
     * gtk_accel_group_from_accel_closure().
     */
    fun listAccelClosures(): CPointer<GList> = gtk_widget_list_accel_closures(self)!!.reinterpret()

    /**
     * Retrieves a %NULL-terminated array of strings containing the prefixes of
     * #GActionGroup's available to @widget.
     */
    fun listActionPrefixes(): List<String> = gtk_widget_list_action_prefixes(self).toList()

    /**
     * Returns a newly allocated list of the widgets, normally labels, for
     * which this widget is the target of a mnemonic (see for example,
     * gtk_label_set_mnemonic_widget()).
     *
     * The widgets in the list are not individually referenced. If you
     * want to iterate through the list and perform actions involving
     * callbacks that might destroy the widgets, you
     * must call `g_list_foreach (result,
     * (GFunc)g_object_ref, NULL)` first, and then unref all the
     * widgets afterwards.
     */
    fun listMnemonicLabels(): CPointer<GList> =
            gtk_widget_list_mnemonic_labels(self)!!.reinterpret()

    /**
     * This function is only for use in widget implementations. Causes
     * a widget to be mapped if it isn’t already.
     */
    fun map(): Unit = gtk_widget_map(self)

    /**
     * Emits the #GtkWidget::mnemonic-activate signal.
     */
    fun mnemonicActivate(group_cycling: Boolean): Boolean = gtk_widget_mnemonic_activate(self,
            if (group_cycling) gtk_true() else gtk_false()) != 0

    /**
     * This function is only for use in widget implementations.
     *
     * Flags the widget for a rerun of the GtkWidgetClass::size_allocate
     * function. Use this function instead of gtk_widget_queue_resize()
     * when the @widget's size request didn't change but it wants to
     * reposition its contents.
     *
     * An example user of this function is gtk_widget_set_halign().
     */
    fun queueAllocate(): Unit = gtk_widget_queue_allocate(self)

    /**
     * Mark @widget as needing to recompute its expand flags. Call
     * this function when setting legacy expand child properties
     * on the child of a container.
     *
     * See gtk_widget_compute_expand().
     */
    fun queueComputeExpand(): Unit = gtk_widget_queue_compute_expand(self)

    /**
     * Equivalent to calling gtk_widget_queue_draw_area() for the
     * entire area of a widget.
     */
    fun queueDraw(): Unit = gtk_widget_queue_draw(self)

    /**
     * Convenience function that calls gtk_widget_queue_draw_region() on
     * the region created from the given coordinates.
     *
     * The region here is specified in widget coordinates.
     * Widget coordinates are a bit odd; for historical reasons, they are
     * defined as @widget->window coordinates for widgets that return %TRUE for
     * gtk_widget_get_has_window(), and are relative to @widget->allocation.x,
     * @widget->allocation.y otherwise.
     *
     * @width or @height may be 0, in this case this function does
     * nothing. Negative values for @width and @height are not allowed.
     */
    fun queueDrawArea(
        x: Int,
        y: Int,
        width: Int,
        height: Int
    ): Unit = gtk_widget_queue_draw_area(self, x, y, width, height)

    /**
     * This function is only for use in widget implementations.
     * Flags a widget to have its size renegotiated; should
     * be called when a widget for some reason has a new size request.
     * For example, when you change the text in a #GtkLabel, #GtkLabel
     * queues a resize to ensure there’s enough space for the new text.
     *
     * Note that you cannot call gtk_widget_queue_resize() on a widget
     * from inside its implementation of the GtkWidgetClass::size_allocate
     * virtual method. Calls to gtk_widget_queue_resize() from inside
     * GtkWidgetClass::size_allocate will be silently ignored.
     */
    fun queueResize(): Unit = gtk_widget_queue_resize(self)

    /**
     * This function works like gtk_widget_queue_resize(),
     * except that the widget is not invalidated.
     */
    fun queueResizeNoRedraw(): Unit = gtk_widget_queue_resize_no_redraw(self)

    /**
     * Creates the GDK (windowing system) resources associated with a
     * widget.  For example, @widget->window will be created when a widget
     * is realized.  Normally realization happens implicitly; if you show
     * a widget and all its parent containers, then the widget will be
     * realized and mapped automatically.
     *
     * Realizing a widget requires all
     * the widget’s parent widgets to be realized; calling
     * gtk_widget_realize() realizes the widget’s parents in addition to
     * @widget itself. If a widget is not yet inside a toplevel window
     * when you realize it, bad things will happen.
     *
     * This function is primarily used in widget implementations, and
     * isn’t very useful otherwise. Many times when you think you might
     * need it, a better approach is to connect to a signal that will be
     * called after the widget is realized automatically, such as
     * #GtkWidget::draw. Or simply g_signal_connect () to the
     * #GtkWidget::realize signal.
     */
    fun realize(): Unit = gtk_widget_realize(self)

    /**
     * Registers a #GdkWindow with the widget and sets it up so that
     * the widget receives events for it. Call gtk_widget_unregister_window()
     * when destroying the window.
     *
     * Before 3.8 you needed to call gdk_window_set_user_data() directly to set
     * this up. This is now deprecated and you should use gtk_widget_register_window()
     * instead. Old code will keep working as is, although some new features like
     * transparency might not work perfectly.
     */
    fun registerWindow(window: CPointer<GdkWindow>): Unit = gtk_widget_register_window(self, window)

    /**
     * Removes an accelerator from @widget, previously installed with
     * gtk_widget_add_accelerator().
     */
    fun removeAccelerator(
        accel_group: CPointer<GtkAccelGroup>,
        accel_key: UInt,
        accel_mods: GdkModifierType
    ): Boolean = gtk_widget_remove_accelerator(self, accel_group, accel_key, accel_mods) != 0

    /**
     * Removes a widget from the list of mnemonic labels for
     * this widget. (See gtk_widget_list_mnemonic_labels()). The widget
     * must have previously been added to the list with
     * gtk_widget_add_mnemonic_label().
     */
    fun removeMnemonicLabel(label: CPointer<GtkWidget>): Unit =
            gtk_widget_remove_mnemonic_label(self, label)

    /**
     * Removes a widget from the list of mnemonic labels for
     * this widget. (See gtk_widget_list_mnemonic_labels()). The widget
     * must have previously been added to the list with
     * gtk_widget_add_mnemonic_label().
     */
    fun removeMnemonicLabel(label: Widget): Unit = gtk_widget_remove_mnemonic_label(self,
            label.widgetPtr?.reinterpret())

    /**
     * Removes a tick callback previously registered with
     * gtk_widget_add_tick_callback().
     */
    fun removeTickCallback(id: UInt): Unit = gtk_widget_remove_tick_callback(self, id)

    /**
     * Updates the style context of @widget and all descendants
     * by updating its widget path. #GtkContainers may want
     * to use this on a child when reordering it in a way that a different
     * style might apply to it. See also gtk_container_get_path_for_child().
     */
    fun resetStyle(): Unit = gtk_widget_reset_style(self)

    /**
     * Sends the focus change @event to @widget
     *
     * This function is not meant to be used by applications. The only time it
     * should be used is when it is necessary for a #GtkWidget to assign focus
     * to a widget that is semantically owned by the first widget even though
     * it’s not a direct child - for instance, a search entry in a floating
     * window similar to the quick search in #GtkTreeView.
     *
     * An example of its usage is:
     *
     * |[<!-- language="C" -->
     *   GdkEvent *fevent = gdk_event_new (GDK_FOCUS_CHANGE);
     *
     *   fevent->focus_change.type = GDK_FOCUS_CHANGE;
     *   fevent->focus_change.in = TRUE;
     *   fevent->focus_change.window = _gtk_widget_get_window (widget);
     *   if (fevent->focus_change.window != NULL)
     *     g_object_ref (fevent->focus_change.window);
     *
     *   gtk_widget_send_focus_change (widget, fevent);
     *
     *   gdk_event_free (event);
     * ]|
     */
    fun sendFocusChange(event: CPointer<GdkEvent>): Boolean = gtk_widget_send_focus_change(self,
            event) != 0

    /**
     * Given an accelerator group, @accel_group, and an accelerator path,
     * @accel_path, sets up an accelerator in @accel_group so whenever the
     * key binding that is defined for @accel_path is pressed, @widget
     * will be activated.  This removes any accelerators (for any
     * accelerator group) installed by previous calls to
     * gtk_widget_set_accel_path(). Associating accelerators with
     * paths allows them to be modified by the user and the modifications
     * to be saved for future use. (See gtk_accel_map_save().)
     *
     * This function is a low level function that would most likely
     * be used by a menu creation system like #GtkUIManager. If you
     * use #GtkUIManager, setting up accelerator paths will be done
     * automatically.
     *
     * Even when you you aren’t using #GtkUIManager, if you only want to
     * set up accelerators on menu items gtk_menu_item_set_accel_path()
     * provides a somewhat more convenient interface.
     *
     * Note that @accel_path string will be stored in a #GQuark. Therefore, if you
     * pass a static string, you can save some memory by interning it first with
     * g_intern_static_string().
     */
    fun setAccelPath(accel_path: String, accel_group: CPointer<GtkAccelGroup>): Unit =
            gtk_widget_set_accel_path(self, accel_path, accel_group)

    /**
     * Enables or disables a #GdkDevice to interact with @widget
     * and all its children.
     *
     * It does so by descending through the #GdkWindow hierarchy
     * and enabling the same mask that is has for core events
     * (i.e. the one that gdk_window_get_events() returns).
     */
    fun setDeviceEnabled(device: CPointer<GdkDevice>, enabled: Boolean): Unit =
            gtk_widget_set_device_enabled(self, device, if (enabled) gtk_true() else gtk_false())

    /**
     * Sets the device event mask (see #GdkEventMask) for a widget. The event
     * mask determines which events a widget will receive from @device. Keep
     * in mind that different widgets have different default event masks, and by
     * changing the event mask you may disrupt a widget’s functionality,
     * so be careful. This function must be called while a widget is
     * unrealized. Consider gtk_widget_add_device_events() for widgets that are
     * already realized, or if you want to preserve the existing event
     * mask. This function can’t be used with windowless widgets (which return
     * %FALSE from gtk_widget_get_has_window());
     * to get events on those widgets, place them inside a #GtkEventBox
     * and receive events on the event box.
     */
    fun setDeviceEvents(device: CPointer<GdkDevice>, events: GdkEventMask): Unit =
            gtk_widget_set_device_events(self, device, events)

    /**
     * Sets the minimum size of a widget; that is, the widget’s size
     * request will be at least @width by @height. You can use this
     * function to force a widget to be larger than it normally would be.
     *
     * In most cases, gtk_window_set_default_size() is a better choice for
     * toplevel windows than this function; setting the default size will
     * still allow users to shrink the window. Setting the size request
     * will force them to leave the window at least as large as the size
     * request. When dealing with window sizes,
     * gtk_window_set_geometry_hints() can be a useful function as well.
     *
     * Note the inherent danger of setting any fixed size - themes,
     * translations into other languages, different fonts, and user action
     * can all change the appropriate size for a given widget. So, it's
     * basically impossible to hardcode a size that will always be
     * correct.
     *
     * The size request of a widget is the smallest size a widget can
     * accept while still functioning well and drawing itself correctly.
     * However in some strange cases a widget may be allocated less than
     * its requested size, and in many cases a widget may be allocated more
     * space than it requested.
     *
     * If the size request in a given direction is -1 (unset), then
     * the “natural” size request of the widget will be used instead.
     *
     * The size request set here does not include any margin from the
     * #GtkWidget properties margin-left, margin-right, margin-top, and
     * margin-bottom, but it does include pretty much all other padding
     * or border properties set by any subclass of #GtkWidget.
     */
    fun setSizeRequest(width: Int, height: Int): Unit = gtk_widget_set_size_request(self, width,
            height)

    /**
     * This function is for use in widget implementations. Turns on flag
     * values in the current widget state (insensitive, prelighted, etc.).
     *
     * This function accepts the values %GTK_STATE_FLAG_DIR_LTR and
     * %GTK_STATE_FLAG_DIR_RTL but ignores them. If you want to set the widget's
     * direction, use gtk_widget_set_direction().
     *
     * It is worth mentioning that any other state than %GTK_STATE_FLAG_INSENSITIVE,
     * will be propagated down to all non-internal children if @widget is a
     * #GtkContainer, while %GTK_STATE_FLAG_INSENSITIVE itself will be propagated
     * down to all #GtkContainer children by different means than turning on the
     * state flag down the hierarchy, both gtk_widget_get_state_flags() and
     * gtk_widget_is_sensitive() will make use of these.
     */
    fun setStateFlags(flags: GtkStateFlags, clear: Boolean): Unit = gtk_widget_set_state_flags(self,
            flags, if (clear) gtk_true() else gtk_false())

    /**
     * Flags a widget to be displayed. Any widget that isn’t shown will
     * not appear on the screen. If you want to show all the widgets in a
     * container, it’s easier to call gtk_widget_show_all() on the
     * container, instead of individually showing the widgets.
     *
     * Remember that you have to show the containers containing a widget,
     * in addition to the widget itself, before it will appear onscreen.
     *
     * When a toplevel container is shown, it is immediately realized and
     * mapped; other shown widgets are realized and mapped when their
     * toplevel container is realized and mapped.
     */
    fun show(): Unit = gtk_widget_show(self)

    /**
     * Recursively shows a widget, and any child widgets (if the widget is
     * a container).
     */
    fun showAll(): Unit = gtk_widget_show_all(self)

    /**
     * Shows a widget. If the widget is an unmapped toplevel widget
     * (i.e. a #GtkWindow that has not yet been shown), enter the main
     * loop and wait for the window to actually be mapped. Be careful;
     * because the main loop is running, anything can happen during
     * this function.
     */
    fun showNow(): Unit = gtk_widget_show_now(self)

    /**
     * This function is only used by #GtkContainer subclasses, to assign a size
     * and position to their child widgets.
     *
     * In this function, the allocation may be adjusted. It will be forced
     * to a 1x1 minimum size, and the adjust_size_allocation virtual
     * method on the child will be used to adjust the allocation. Standard
     * adjustments include removing the widget’s margins, and applying the
     * widget’s #GtkWidget:halign and #GtkWidget:valign properties.
     *
     * For baseline support in containers you need to use gtk_widget_size_allocate_with_baseline()
     * instead.
     */
    fun sizeAllocate(allocation: CPointer<GtkAllocation>): Unit = gtk_widget_size_allocate(self,
            allocation)

    /**
     * This function is only used by #GtkContainer subclasses, to assign a size,
     * position and (optionally) baseline to their child widgets.
     *
     * In this function, the allocation and baseline may be adjusted. It
     * will be forced to a 1x1 minimum size, and the
     * adjust_size_allocation virtual and adjust_baseline_allocation
     * methods on the child will be used to adjust the allocation and
     * baseline. Standard adjustments include removing the widget's
     * margins, and applying the widget’s #GtkWidget:halign and
     * #GtkWidget:valign properties.
     *
     * If the child widget does not have a valign of %GTK_ALIGN_BASELINE the
     * baseline argument is ignored and -1 is used instead.
     */
    fun sizeAllocateWithBaseline(allocation: CPointer<GtkAllocation>, baseline: Int): Unit =
            gtk_widget_size_allocate_with_baseline(self, allocation, baseline)

    /**
     * Gets the values of a multiple style properties of @widget.
     */
    fun styleGet(first_property_name: String): Unit = gtk_widget_style_get(self,
            first_property_name)

    /**
     * Reverts the effect of a previous call to gtk_widget_freeze_child_notify().
     * This causes all queued #GtkWidget::child-notify signals on @widget to be
     * emitted.
     */
    fun thawChildNotify(): Unit = gtk_widget_thaw_child_notify(self)

    /**
     * Triggers a tooltip query on the display where the toplevel of @widget
     * is located. See gtk_tooltip_trigger_tooltip_query() for more
     * information.
     */
    fun triggerTooltipQuery(): Unit = gtk_widget_trigger_tooltip_query(self)

    /**
     * This function is only for use in widget implementations. Causes
     * a widget to be unmapped if it’s currently mapped.
     */
    fun unmap(): Unit = gtk_widget_unmap(self)

    /**
     * This function is only for use in widget implementations.
     * Should be called by implementations of the remove method
     * on #GtkContainer, to dissociate a child from the container.
     */
    fun unparent(): Unit = gtk_widget_unparent(self)

    /**
     * This function is only useful in widget implementations.
     * Causes a widget to be unrealized (frees all GDK resources
     * associated with the widget, such as @widget->window).
     */
    fun unrealize(): Unit = gtk_widget_unrealize(self)

    /**
     * Unregisters a #GdkWindow from the widget that was previously set up with
     * gtk_widget_register_window(). You need to call this when the window is
     * no longer used by the widget, such as when you destroy it.
     */
    fun unregisterWindow(window: CPointer<GdkWindow>): Unit = gtk_widget_unregister_window(self,
            window)

    /**
     * This function is for use in widget implementations. Turns off flag
     * values for the current widget state (insensitive, prelighted, etc.).
     * See gtk_widget_set_state_flags().
     */
    fun unsetStateFlags(flags: GtkStateFlags): Unit = gtk_widget_unset_state_flags(self, flags)

    /**
     * Sets the widget’s allocation.  This should not be used
     * directly, but from within a widget’s size_allocate method.
     *
     * The allocation set should be the “adjusted” or actual
     * allocation. If you’re implementing a #GtkContainer, you want to use
     * gtk_widget_size_allocate() instead of gtk_widget_set_allocation().
     * The GtkWidgetClass::adjust_size_allocation virtual method adjusts the
     * allocation inside gtk_widget_size_allocate() to create an adjusted
     * allocation.
     */
    fun setAllocation(allocation: CPointer<GtkAllocation>): Unit = gtk_widget_set_allocation(self,
            allocation)

    /**
     * Sets the widget’s clip.  This must not be used directly,
     * but from within a widget’s size_allocate method.
     * It must be called after gtk_widget_set_allocation() (or after chaining up
     * to the parent class), because that function resets the clip.
     *
     * The clip set should be the area that @widget draws on. If @widget is a
     * #GtkContainer, the area must contain all children's clips.
     *
     * If this function is not called by @widget during a ::size-allocate handler,
     * the clip will be set to @widget's allocation.
     */
    fun setClip(clip: CPointer<GtkAllocation>): Unit = gtk_widget_set_clip(self, clip)

    /**
     * Sets whether the entire widget is queued for drawing when its size
     * allocation changes. By default, this setting is %TRUE and
     * the entire widget is redrawn on every size change. If your widget
     * leaves the upper left unchanged when made bigger, turning this
     * setting off will improve performance.
     *
     * Note that for widgets where gtk_widget_get_has_window() is %FALSE
     * setting this flag to %FALSE turns off all allocation on resizing:
     * the widget will not even redraw if its position changes; this is to
     * allow containers that don’t draw anything to avoid excess
     * invalidations. If you set this flag on a widget with no window that
     * does draw on @widget->window, you are
     * responsible for invalidating both the old and new allocation of the
     * widget when the widget is moved and responsible for invalidating
     * regions newly when the widget increases size.
     */
    fun setRedrawOnAllocate(redraw_on_allocate: Boolean): Unit =
            gtk_widget_set_redraw_on_allocate(self,
            if (redraw_on_allocate) gtk_true() else gtk_false())
}

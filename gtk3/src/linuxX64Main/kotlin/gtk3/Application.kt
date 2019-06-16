package gtk3

import kotlinx.cinterop.*
import libgtk3.G_APPLICATION_FLAGS_NONE
import libgtk3.g_application_run
import libgtk3.g_object_unref
import libgtk3.gtk_application_new

fun Application_onActivate_Handler(sender: CPointer<*>?, data: COpaquePointer?) {
    data?.asStableRef<Application>()?.get()?.onActivate?.emit()
}

class Application(val id: String) {
    private val app = gtk_application_new(id, G_APPLICATION_FLAGS_NONE)!!

    val onActivate = Signal(app, this, "activate", staticCFunction(::Application_onActivate_Handler))

    fun run(args: Array<String>): Int {
        val status = memScoped {
            g_application_run(app.reinterpret(), args.size, args.map { it.cstr.ptr }.toCValues())
        }
        g_object_unref(app)
        return status

    }

    fun createWindow(init: ApplicationWindow.() -> Unit = {}) = ApplicationWindow(app).apply(init)
}
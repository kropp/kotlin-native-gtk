package gtk3

import kotlinx.cinterop.*
import libgtk3.GConnectFlags
import libgtk3.g_signal_connect_data
import libgtk3.g_signal_handler_disconnect
import libgtk3.gulong

fun <F : CFunction<*>> g_signal_connect(obj: CPointer<*>, actionName: String, action: CPointer<F>, data: libgtk3.gpointer? = null, connect_flags: GConnectFlags = 0U): gulong {
    return g_signal_connect_data(obj.reinterpret(), actionName, action.reinterpret(), data = data, destroy_data = null, connect_flags = connect_flags)
}

typealias SignalHandler<T> = T.() -> Unit
class Signal<T : Any, F : CFunction<*>>(widgetPtr: CPointer<*>, private val obj: T, name: String, realHandler: CPointer<F>) {
    private var handlers = emptyList<SignalHandler<T>>()
    init {
        g_signal_connect(widgetPtr, name, realHandler, StableRef.create(obj).asCPointer())
    }

    operator fun invoke(handler: SignalHandler<T>) {
        handlers += handler
    }
    operator fun minusAssign(handler: SignalHandler<T>) {
        handlers -= handler
    }

    fun fire() {
        for (handler in handlers) {
            try {
                obj.handler()
            } catch(e: Throwable) {}
        }
    }
}

typealias SignalHandler1<T, T1> = T.(T1) -> Unit
class Signal1<T : Any, T1, F : CFunction<*>>(widgetPtr: CPointer<*>, private val obj: T, name: String, realHandler: CPointer<F>) {
    private var handlers = emptyList<SignalHandler1<T, T1>>()
    init {
        g_signal_connect(widgetPtr, name, realHandler, StableRef.create(obj).asCPointer())
    }

    operator fun plusAssign(handler: SignalHandler1<T, T1>) {
        handlers += handler
    }
    operator fun minusAssign(handler: SignalHandler1<T, T1>) {
        handlers -= handler
    }

    operator fun invoke(p1: T1) {
        for (handler in handlers) {
            try {
                obj.handler(p1)
            } catch(e: Throwable) {}
        }
    }
}

typealias SignalHandler2<T, T1, T2> = T.(T1, T2) -> Unit
class Signal2<T : Any, T1, T2, F : CFunction<*>>(widgetPtr: CPointer<*>, private val obj: T, name: String, realHandler: CPointer<F>) {
    private var handlers = emptyList<SignalHandler2<T, T1, T2>>()
    init {
        g_signal_connect(widgetPtr, name, realHandler, StableRef.create(obj).asCPointer())
    }

    operator fun plusAssign(handler: SignalHandler2<T, T1, T2>) {
        handlers += handler
    }
    operator fun minusAssign(handler: SignalHandler2<T, T1, T2>) {
        handlers -= handler
    }

    operator fun invoke(p1: T1, p2: T2) {
        for (handler in handlers) {
            try {
                obj.handler(p1, p2)
            } catch(e: Throwable) {}
        }
    }
}

typealias SignalHandler3<T, T1, T2, T3> = T.(T1, T2, T3) -> Unit
class Signal3<T : Any, T1, T2, T3, F : CFunction<*>>(widgetPtr: CPointer<*>, private val obj: T, name: String, realHandler: CPointer<F>) {
    private var handlers = emptyList<SignalHandler3<T, T1, T2, T3>>()
    init {
        g_signal_connect(widgetPtr, name, realHandler, StableRef.create(obj).asCPointer())
    }

    operator fun plusAssign(handler: SignalHandler3<T, T1, T2, T3>) {
        handlers += handler
    }
    operator fun minusAssign(handler: SignalHandler3<T, T1, T2, T3>) {
        handlers -= handler
    }

    operator fun invoke(p1: T1, p2: T2, p3: T3) {
        for (handler in handlers) {
            try {
                obj.handler(p1, p2, p3)
            } catch(e: Throwable) {}
        }
    }
}

typealias SignalHandler4<T, T1, T2, T3, T4> = T.(T1, T2, T3, T4) -> Unit
class Signal4<T : Any, T1, T2, T3, T4, F : CFunction<*>>(widgetPtr: CPointer<*>, private val obj: T, name: String, realHandler: CPointer<F>) {
    private var handlers = emptyList<SignalHandler4<T, T1, T2, T3, T4>>()
    init {
        g_signal_connect(widgetPtr, name, realHandler, StableRef.create(obj).asCPointer())
    }

    operator fun plusAssign(handler: SignalHandler4<T, T1, T2, T3, T4>) {
        handlers += handler
    }
    operator fun minusAssign(handler: SignalHandler4<T, T1, T2, T3, T4>) {
        handlers -= handler
    }

    operator fun invoke(p1: T1, p2: T2, p3: T3, p4: T4) {
        for (handler in handlers) {
            try {
                obj.handler(p1, p2, p3, p4)
            } catch(e: Throwable) {}
        }
    }
}

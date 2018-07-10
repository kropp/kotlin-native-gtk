package gtk3

import kotlinx.cinterop.*

fun CPointer<CPointerVar<ByteVar>>?.toList(): List<String> {
    if (this == null) return emptyList()
    val result = mutableListOf<String>()
    var i = 0
    while (true) {
        val it = this[i] ?: break
        result += it.toKString()
        i++
    }
    return result
}

package sample

import kotlinx.cinterop.*
import platform.posix.*

fun files(directory: String) = sequence {
    val dir = opendir(directory)
    while (true) {
        val entry = readdir(dir) ?: break
        val name = entry.pointed.d_name.toKString()
        if (name == "." || name == "..") continue
        yield(name)
    }
    closedir(dir)
}

fun isDirectory(filename: String) = memScoped {
    val s = alloc<stat>()
    if (stat(filename, s.ptr) == 0) {
        @Suppress("EXPERIMENTAL_API_USAGE")
        s.st_mode and S_IFMT.toUInt() == S_IFDIR.toUInt()
    } else false
}
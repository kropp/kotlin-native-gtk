package sample

import kotlinx.cinterop.*
import platform.posix.*
import kotlin.coroutines.experimental.buildSequence

fun files(directory: String) = buildSequence {
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
        s.st_mode and S_IFMT == S_IFDIR
    } else false
}
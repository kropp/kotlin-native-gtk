package sample

import gtk3.*
import kotlinx.cinterop.CPointer
import kotlinx.cinterop.reinterpret
import kotlinx.cinterop.toKString
import libgtk3.GFile
import platform.posix.system

private const val folder = "/usr/share/icons/Humanity/places/32/folder.svg"
private const val file = "/usr/share/icons/Humanity/mimes/32/office-document.svg"

var backButton: Button? = null
var fwdButton: Button? = null
var headerBar: HeaderBar? = null

val iconViewModel = IconViewModel()
val paths = mutableListOf<String>()
var current = -1

fun buildModel(directory: String) {
    iconViewModel.reset()
    files(directory).forEach {
        iconViewModel.append(it, if (isDirectory("$directory/$it")) folder else file)
    }
}

fun openFile(path: String) {
    system("xdg-open '$path'")
}

fun navigate(path: String) {
    current++
//    println("Navigating to $path")
//    println("Navigation stack ($current): ${paths.joinToString()}")
    while (paths.size > current) {
        paths.removeAt(current)
    }
    paths.add(path)
    update(path)
}

private fun update(path: String) {
    buildModel(path)
    headerBar?.title = path
    backButton?.sensitive = current > 0
    fwdButton?.sensitive = current < paths.size - 1
}

fun navigateBack() {
    if (current > 0) {
        current--
        update(paths[current])
    }
}

fun navigateForward() {
    if (current < paths.size - 1) {
        current++
        update(paths[current])
    }
}

fun Application.fileManager() = createWindow {
    setDefaultSize(800, 600)
    iconName = "user-home"

    headerBar = headerBar {
        showCloseButton = true

        backButton = imageButton("gtk-go-back") {
            onClicked { navigateBack() }
        }
        fwdButton = imageButton("gtk-go-forward") {
            onClicked { navigateForward() }
        }
    }

    hbox {
        placesSidebar {
            maxContentWidth = 200
            /*
            TODO
            onOpenLocation += { file: CPointer<GFile>?, _ ->
                libgtk3.g_file_get_path(file)?.toKString()?.let { navigate(it) }
            }
            */
        }
        scrolledWindow(null, null) {
            minContentWidth = 600
            iconView {
                model = iconViewModel.store?.reinterpret()!!
                textColumn = 0
                pixbufColumn = 1

                onItemActivated {
                    val name = iconViewModel.getByPath(it)
                    val path = "${paths[current]}/$name"
                    if (isDirectory(path)) {
                        navigate(path)
                    } else {
                        openFile(path)
                    }
                }
            }
        }
    }

    navigate("/home")
}
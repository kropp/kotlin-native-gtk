package sample

import kotlinx.cinterop.*
import libgtk3.*

class IconViewModel {
    val store = gtk_list_store_new(2, G_TYPE_STRING, libgtk3.gdk_pixbuf_get_type())
    private val paths = mutableListOf<String>()

    fun append(path: String, icon: String) {
        paths.add(path)
        memScoped {
            val iter = alloc<GtkTreeIter>()
            gtk_list_store_append(store, iter.ptr)
            val pixbuf = gdk_pixbuf_new_from_file(icon, null)
            gtk_list_store_set(store, iter.ptr, 0, path.cstr, 1, pixbuf, -1)
            g_object_unref(pixbuf)
        }
    }

    fun reset() {
        gtk_list_store_clear(store)
        paths.clear()
    }

    fun getByPath(path: CPointer<GtkTreePath>?): String? {
        val indices = gtk_tree_path_get_indices(path) ?: return null
        val i = indices[0]
        return paths[i]
    }
}
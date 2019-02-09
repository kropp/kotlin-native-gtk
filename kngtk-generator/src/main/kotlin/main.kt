import org.jdom2.input.SAXBuilder
import java.io.File

const val basePath = "/usr/share/gir-1.0/"

object Generator {
    @JvmStatic
    fun main(args: Array<String>) {
        val gdkGir = SAXBuilder().build(File(basePath + "Gdk-3.0.gir"))
        val gtkGir = SAXBuilder().build(File(basePath + "Gtk-3.0.gir"))

        gtkGir.rootElement.getChild("namespace", introspectionNs)?.let { ns ->
            ns.getChildren("class", introspectionNs)?.forEach {
                if (it.shouldGenerateBindingClass()) {
                    it.processClass()
                }
            }
        }
    }
}
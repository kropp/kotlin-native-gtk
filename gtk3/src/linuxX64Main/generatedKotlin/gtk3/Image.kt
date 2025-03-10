package gtk3

import kotlin.Int
import kotlin.String
import kotlin.Unit
import kotlinx.cinterop.CPointer
import kotlinx.cinterop.reinterpret
import libgtk3.GIcon
import libgtk3.GdkPixbuf
import libgtk3.GtkIconSize
import libgtk3.GtkImage
import libgtk3.GtkImageType
import libgtk3.GtkWidget
import libgtk3.gtk_image_clear
import libgtk3.gtk_image_get_pixbuf
import libgtk3.gtk_image_get_pixel_size
import libgtk3.gtk_image_get_storage_type
import libgtk3.gtk_image_new
import libgtk3.gtk_image_set_from_file
import libgtk3.gtk_image_set_from_gicon
import libgtk3.gtk_image_set_from_icon_name
import libgtk3.gtk_image_set_from_pixbuf
import libgtk3.gtk_image_set_from_resource
import libgtk3.gtk_image_set_pixel_size

inline fun Container.image(init: Image.() -> Unit = {}): Image = Image().apply { init();
        this@image.add(this) }

/**
 * The #GtkImage widget displays an image. Various kinds of object
 * can be displayed as an image; most typically, you would load a
 * #GdkPixbuf ("pixel buffer") from a file, and then display that.
 * There’s a convenience function to do this, gtk_image_new_from_file(),
 * used as follows:
 * |[<!-- language="C" -->
 *   GtkWidget *image;
 *   image = gtk_image_new_from_file ("myfile.png");
 * ]|
 * If the file isn’t loaded successfully, the image will contain a
 * “broken image” icon similar to that used in many web browsers.
 * If you want to handle errors in loading the file yourself,
 * for example by displaying an error message, then load the image with
 * gdk_pixbuf_new_from_file(), then create the #GtkImage with
 * gtk_image_new_from_pixbuf().
 *
 * The image file may contain an animation, if so the #GtkImage will
 * display an animation (#GdkPixbufAnimation) instead of a static image.
 *
 * #GtkImage is a subclass of #GtkMisc, which implies that you can
 * align it (center, left, right) and add padding to it, using
 * #GtkMisc methods.
 *
 * #GtkImage is a “no window” widget (has no #GdkWindow of its own),
 * so by default does not receive events. If you want to receive events
 * on the image, such as button clicks, place the image inside a
 * #GtkEventBox, then connect to the event signals on the event box.
 *
 * ## Handling button press events on a #GtkImage.
 *
 * |[<!-- language="C" -->
 *   static gboolean
 *   button_press_callback (GtkWidget      *event_box,
 *                          GdkEventButton *event,
 *                          gpointer        data)
 *   {
 *     g_print ("Event box clicked at coordinates %f,%f\n",
 *              event->x, event->y);
 *
 *     // Returning TRUE means we handled the event, so the signal
 *     // emission should be stopped (don’t call any further callbacks
 *     // that may be connected). Return FALSE to continue invoking callbacks.
 *     return TRUE;
 *   }
 *
 *   static GtkWidget*
 *   create_image (void)
 *   {
 *     GtkWidget *image;
 *     GtkWidget *event_box;
 *
 *     image = gtk_image_new_from_file ("myfile.png");
 *
 *     event_box = gtk_event_box_new ();
 *
 *     gtk_container_add (GTK_CONTAINER (event_box), image);
 *
 *     g_signal_connect (G_OBJECT (event_box),
 *                       "button_press_event",
 *                       G_CALLBACK (button_press_callback),
 *                       image);
 *
 *     return image;
 *   }
 * ]|
 *
 * When handling events on the event box, keep in mind that coordinates
 * in the image may be different from event box coordinates due to
 * the alignment and padding settings on the image (see #GtkMisc).
 * The simplest way to solve this is to set the alignment to 0.0
 * (left/top), and set the padding to zero. Then the origin of
 * the image will be the same as the origin of the event box.
 *
 * Sometimes an application will want to avoid depending on external data
 * files, such as image files. GTK+ comes with a program to avoid this,
 * called “gdk-pixbuf-csource”. This library
 * allows you to convert an image into a C variable declaration, which
 * can then be loaded into a #GdkPixbuf using
 * gdk_pixbuf_new_from_inline().
 *
 * # CSS nodes
 *
 * GtkImage has a single CSS node with the name image.Gets the #GdkPixbuf being displayed by the
        #GtkImage.
 * The storage type of the image must be %GTK_IMAGE_EMPTY or
 * %GTK_IMAGE_PIXBUF (see gtk_image_get_storage_type()).
 * The caller of this function does not own a reference to the
 * returned pixbuf.Gets the type of representation being used by the #GtkImage
 * to store image data. If the #GtkImage has no image data,
 * the return value will be %GTK_IMAGE_EMPTY.
 */
@GtkDsl
open class Image internal constructor(override val widgetPtr: CPointer<GtkWidget>? = null) : Misc()
        {
    private val self: CPointer<GtkImage>?
        get() = widgetPtr!!.reinterpret()

    val image: CPointer<GtkImage>?
        get() = widgetPtr!!.reinterpret()

    val pixbuf: CPointer<GdkPixbuf>
        get() = gtk_image_get_pixbuf(self)!!.reinterpret()

    /**
     * Gets the pixel size used for named icons.
     *
     * Sets the pixel size to use for named icons. If the pixel size is set
     * to a value != -1, it is used instead of the icon size set by
     * gtk_image_set_from_icon_name(). */
    var pixelSize: Int
        get() = gtk_image_get_pixel_size(self)
        set(value) {
            gtk_image_set_pixel_size(self, value)
        }

    val storageType: GtkImageType
        get() = gtk_image_get_storage_type(self)

    /**
     * Creates a new empty #GtkImage widget. */
    constructor() : this(gtk_image_new()?.reinterpret())

    /**
     * Resets the image to be empty.
     */
    fun clear(): Unit = gtk_image_clear(self)

    /**
     * See gtk_image_new_from_gicon() for details.
     */
    fun setFromGicon(icon: CPointer<GIcon>, size: GtkIconSize): Unit =
            gtk_image_set_from_gicon(self, icon, size)

    /**
     * See gtk_image_new_from_icon_name() for details.
     */
    fun setFromIconName(icon_name: String, size: GtkIconSize): Unit =
            gtk_image_set_from_icon_name(self, icon_name, size)

    /**
     * See gtk_image_new_from_file() for details.
     */
    fun setFromFile(filename: String): Unit = gtk_image_set_from_file(self, filename)

    /**
     * See gtk_image_new_from_pixbuf() for details.
     */
    fun setFromPixbuf(pixbuf: CPointer<GdkPixbuf>): Unit = gtk_image_set_from_pixbuf(self, pixbuf)

    /**
     * See gtk_image_new_from_resource() for details.
     */
    fun setFromResource(resource_path: String): Unit = gtk_image_set_from_resource(self,
            resource_path)
}

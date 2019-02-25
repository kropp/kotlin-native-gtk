import org.jdom2.input.SAXBuilder
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import java.io.File

class GeneratorTest {
    @Test fun properties() = doTest("properties")
    @Test fun enumparam() = doTest("enumparam")

    private val testDataPath = "testData/generator"

    private fun doTest(name: String) {
        val actual = StringBuilder()
        val document = SAXBuilder().build(File("$testDataPath/$name.gir"))
        document.rootElement.getChild("namespace", introspectionNs)?.let { ns ->
            ns.getChildren("class", introspectionNs)?.forEach {
                it.processClass(allEnums(document))?.writeTo(actual)
            }
        }
        assertEquals(File("$testDataPath/$name.kt").readText(), actual.toString())
    }
}
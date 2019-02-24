import org.jdom2.input.SAXBuilder
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import java.io.File

class GeneratorTest {
    @Test
    fun properties() = doTest("properties")

    private val testDataPath = "testData/generator"

    private fun doTest(name: String) {
        val actual = StringBuilder()
        SAXBuilder().build(File("$testDataPath/$name.gir")).rootElement.getChild("namespace", introspectionNs)?.let { ns ->
            ns.getChildren("class", introspectionNs)?.forEach {
                it.processClass()?.writeTo(actual)
            }
        }
//        assertThat(actual.toString(), IsEqual(File("$testDataPath/$name.kt").readText()))
        assertEquals(File("$testDataPath/$name.kt").readText(), actual.toString())
    }
}
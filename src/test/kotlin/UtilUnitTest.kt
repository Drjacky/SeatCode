import main.Commander
import org.junit.Assert
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4
import java.io.File

private const val TEST_CASES_PATH = "src/test/kotlin/jsons/"
private const val FILENAME_OUTPUT = "output.txt"

@RunWith(JUnit4::class)
class UtilUnitTest {

    @Test
    fun `check createOutput works perfectly`() {
        Commander(File(TEST_CASES_PATH + "input.json"))

        val outputFile = File(FILENAME_OUTPUT)
        Assert.assertTrue(outputFile.exists())
    }
}
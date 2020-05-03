import exception.ContentFormatException
import main.Commander
import org.junit.Assert
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4
import java.io.*

private const val TEST_CASES_PATH = "src/test/kotlin/jsons/"
private const val FILENAME_OUTPUT = "output.txt"

@RunWith(JUnit4::class)
class CommanderUnitTest {

    @Test
    fun `check movements is not empty`() {
        val command = Commander(File(TEST_CASES_PATH + "input.json")).result

        Assert.assertNotNull(command.movements)
    }

    @Test
    fun `check output file has been created`() {
        Commander(File(TEST_CASES_PATH + "input.json")).result

        val outputFile = File(FILENAME_OUTPUT)
        Assert.assertTrue(outputFile.exists())
    }

    @Test(expected = FileNotFoundException::class)
    @Throws(Exception::class)
    fun `wrong filename must return FileNotFoundException`() {
        Commander(File("wrong_file_name.json")).result
    }

    @Test(expected = ContentFormatException::class)
    @Throws(Exception::class)
    fun `wrong file content must return ContentFormatException`() {
        Commander(File(TEST_CASES_PATH + "input_corrupted_file.json")).result
    }

    @Test(expected = NoSuchElementException::class)
    fun `empty file`() {
        val command = Commander(File(TEST_CASES_PATH + "input_empty.json")).result

        Assert.assertNull(command)
    }

}
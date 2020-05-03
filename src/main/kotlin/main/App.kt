package main

import util.Constants.Companion.EXCEPTION_FILE_NOT_FOUND
import util.Constants.Companion.EXCEPTION_WRONG_CONTENT_FORMAT
import util.Utils.Companion.createOutput
import java.io.File
import java.io.FileNotFoundException
import kotlin.system.exitProcess
import exception.*

private const val FILENAME_INPUT = "input.json"

fun main() = try {
    createOutput(input = Commander(inputFileName = File(FILENAME_INPUT)))
} catch (inputFormatException: ContentFormatException) {
    System.err.println(EXCEPTION_WRONG_CONTENT_FORMAT + inputFormatException.message)
} catch (fileNotFoundException: FileNotFoundException) {
    System.err.println(EXCEPTION_FILE_NOT_FOUND)
} finally {
    exitProcess(1)
}
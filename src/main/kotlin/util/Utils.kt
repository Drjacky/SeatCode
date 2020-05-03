package util

import main.Commander
import java.io.File

private const val FILENAME_OUTPUT = "output.txt"

class Utils {

    companion object {
        fun <T> createOutput(input: T) {
            val myFile = File(FILENAME_OUTPUT)

            myFile.bufferedWriter().use { out ->
                when (input) {
                    is Commander -> {
                        val result =
                            "${input.result.roverPositionX} ${input.result.roverPositionY} ${input.result.roverDirection}"
                        println(result)
                        out.write(result)
                    }
                }
            }
        }
    }

}
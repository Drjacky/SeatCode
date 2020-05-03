package main

import dto.Command
import exception.ContentFormatException
import org.json.JSONException
import org.json.JSONObject
import util.Constants.Companion.EXCEPTION_WRONG_CONTENT_FORMAT
import java.io.File
import java.io.FileNotFoundException
import java.util.*

private const val JSON_KEY_TOP_RIGHT_CORNER = "topRightCorner"
private const val JSON_KEY_X = "x"
private const val JSON_KEY_Y = "y"
private const val JSON_KEY_ROVER_POSITION = "roverPosition"
private const val JSON_KEY_ROVER_DIRECTION = "roverDirection"
private const val JSON_KEY_MOVEMENTS = "movements"

class Commander constructor(
    private val inputFileName: File
) {

    val result: Command
        get() {
            readFile().let {
                return calculateMovements(it)
            }
        }

    private fun readFile(): Command? {
        try {
            Scanner(inputFileName).use { scanner ->
                val content = scanner.useDelimiter("\\A").next()
                val lineJsonObject = JSONObject(content)
                val topRightCorner = lineJsonObject.getJSONObject(JSON_KEY_TOP_RIGHT_CORNER)
                val topRightCornerX = topRightCorner[JSON_KEY_X] as Int
                val topRightCornerY = topRightCorner[JSON_KEY_Y] as Int
                val roverPosition = lineJsonObject.getJSONObject(JSON_KEY_ROVER_POSITION)
                val roverPositionX = roverPosition[JSON_KEY_X] as Int
                val roverPositionY = roverPosition[JSON_KEY_Y] as Int
                val roverDirection = lineJsonObject.getString(JSON_KEY_ROVER_DIRECTION)
                val movements = lineJsonObject.getString(JSON_KEY_MOVEMENTS)

                return Command(
                    topRightCornerX = topRightCornerX,
                    topRightCornerY = topRightCornerY,
                    roverPositionX = roverPositionX,
                    roverPositionY = roverPositionY,
                    roverDirection = roverDirection,
                    movements = movements
                )
            }
        } catch (exception: Exception) {
            when (exception) {
                is JSONException, is NumberFormatException -> {
                    throw ContentFormatException(exception.message + "")
                }
                is FileNotFoundException -> throw FileNotFoundException(exception.message)
                else -> throw exception
            }
        }
    }

    private fun calculateMovements(command: Command?): Command {
        command?.let {
            var direction = checkInitialDirection(it.roverDirection)

            it.movements.forEach { toWhere ->
                when (toWhere) {
                    'L' -> direction = direction.left()
                    'R' -> direction = direction.right()
                    'M' -> moveRover(direction, command)
                }
            }
        } ?: kotlin.run {
            throw ContentFormatException(EXCEPTION_WRONG_CONTENT_FORMAT)
        }

        return command
    }

    private fun checkInitialDirection(roverDirection: String): Direction {
        return when (roverDirection) {
            "N" -> Direction.N
            "W" -> Direction.W
            "S" -> Direction.S
            "E" -> Direction.E
            else -> throw ContentFormatException(EXCEPTION_WRONG_CONTENT_FORMAT)
        }
    }

    private fun moveRover(direction: Direction, command: Command): Command {
        command.apply {
            when (direction) {
                Direction.N -> this.roverPositionY += 1
                Direction.W -> this.roverPositionX -= 1
                Direction.S -> this.roverPositionY -= 1
                Direction.E -> this.roverPositionX += 1
            }

            this.roverDirection = direction.value()
        }

        return command
    }

}

enum class Direction(
    private val value: String,
    private val left: String,
    private val right: String
) {
    N("N", "W", "E"),
    W("W", "S", "N"),
    S("S", "E", "W"),
    E("E", "N", "S");

    fun value() = value
    fun right() = moveTo(right)
    fun left() = moveTo(left)

    private fun moveTo(direction: String) = values().first { currentDirection ->
        currentDirection.value == direction
    }

}
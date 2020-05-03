package dto

class Command(
    val topRightCornerX: Int,
    val topRightCornerY: Int,
    var roverPositionX: Int,
    var roverPositionY: Int,
    var roverDirection: String,
    val movements: String
)
import kotlin.io.path.readLines

fun main() {
    fun mySolution(input: List<String>): String {
        val keyPad = listOf(
            listOf('A', 'B', 'C', 'D'),
            listOf('E', 'F', 'G', 'H'),
            listOf('I', 'J', 'K', 'L'),
            listOf('M', 'N', 'O', 'P'),
        )

        val instructions = input.map { line ->
            line.split(',')
                .map { direction ->
                    direction.toDirectionWithDeltas()
                }
        }

        fun areCoordinatesInBounds(
            newI: Int,
            newJ: Int
        ) = newI in keyPad.indices && newJ in keyPad.first().indices

        return buildString {
            instructions.forEach { instruction ->
                val currentPosition = Position(0, 0)
                instruction.forEach { direction ->
                    val newI = currentPosition.i + direction.iDelta
                    val newJ = currentPosition.j + direction.jDelta
                    if (areCoordinatesInBounds(newI, newJ)) {
                        currentPosition.i = newI
                        currentPosition.j = newJ
                    }
                }
                append(keyPad[currentPosition.i][currentPosition.j])
            }
        }
    }

    val inputTest = pathToInput("Challenge04Test")
        .readLines()
    check("C" == mySolution(inputTest))

    val input = pathToInput("Challenge04")
        .readLines()
    val result = mySolution(input)
    check("EBENKEMBFGDIKIGICIPEDLKGMEBBCFKODHPFJJLBADHBFPBGIBHLOGABIFNKAIJAA" == result)
    result.println()
}

class Position(
    var i: Int,
    var j: Int
)

enum class DirectionWithDeltas(
    val iDelta: Int,
    val jDelta: Int
) {
    UP(-1, 0),
    DOWN(1, 0),
    LEFT(0, -1),
    RIGHT(0, 1),
}

private fun String.toDirectionWithDeltas(): DirectionWithDeltas {
    return when (this) {
        "DOWN" -> DirectionWithDeltas.DOWN
        "LEFT" -> DirectionWithDeltas.LEFT
        "RIGHT" -> DirectionWithDeltas.RIGHT
        else -> DirectionWithDeltas.UP
    }
}
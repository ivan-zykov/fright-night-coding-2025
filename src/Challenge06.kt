import kotlin.io.path.readLines
import kotlin.math.ceil
import kotlin.math.pow
import kotlin.math.sqrt

fun main() {
    fun mySolution(input: List<List<Double>>): Int {
        var totalDistance = 0

        for (pointIdx in (0..input.lastIndex - 1)) {
            var sum = 0.0
            (0..3).forEach { dimension ->
                sum += (input[pointIdx][dimension] - input[pointIdx + 1][dimension]).pow(2)
            }

            totalDistance += ceil(sqrt(sum)).toInt()
        }

        return totalDistance
    }

    val input = pathToInput("Challenge06")
        .readLines()
        .map { point ->
            point.split(',')
                .map { it.toDouble() }
        }

    mySolution(input).println()
}

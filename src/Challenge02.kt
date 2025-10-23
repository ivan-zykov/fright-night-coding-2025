import kotlin.io.path.readText

fun main() {
    fun mySolution(input: List<Int>): Int {
        val sumNormalized = input.sum() % 360

        return if (sumNormalized >= 0) sumNormalized else 360 + sumNormalized
    }

    val input = pathToInput("Challenge02")
        .readText()
        .trim()
        .split(',')
        .asSequence()
        .map { it.toInt() }
        .toList()

    "Result: ${mySolution(input)}".println()
}

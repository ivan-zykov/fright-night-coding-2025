import kotlin.io.path.readText

fun main() {
    fun mySolution(input: Long): String {
        var restNumber = input
        var overflowsCount = 0

        while (restNumber > UInt.MAX_VALUE.toLong() + 1) {
            restNumber -= UInt.MAX_VALUE.toLong() + 1
            overflowsCount++
        }

        val restNumberBinary = Integer.toBinaryString(restNumber.toInt())

        return "$overflowsCount,$restNumberBinary"
    }

    val input = pathToInput("Challenge07").readText().toLong()

    mySolution(input).println()
}

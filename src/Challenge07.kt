import kotlin.io.path.readText

fun main() {
    fun mySolution(input: Long): String {
        var restNumber = input
        var overflowsCount = 0

        val modulus = UInt.MAX_VALUE.toLong() + 1L
        while (restNumber > modulus) {
            restNumber -= modulus
            overflowsCount++
        }

        val restNumberBinary = Integer.toBinaryString(restNumber.toInt())

        return "$overflowsCount,$restNumberBinary"
    }

    val input = pathToInput("Challenge07").readText().toLong()

    mySolution(input).println()
}

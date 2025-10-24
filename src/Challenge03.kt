import kotlin.io.path.readText

fun main() {
    fun mySolution(input: List<Char>): String {
        val frequencies: Map<Char, Int> = buildMap {
            input.forEach { char ->
                put(
                    char, this.getOrDefault(char, 0) + 1
                )
            }
        }

        return frequencies.filter { it.value == 1 }
            .keys
            .joinToString("")
    }

    val input = pathToInput("Challenge03")
        .readText()
        .trim()
        .toList()

    mySolution(input).println()
}

private const val LAST_INDEX_OF_FIRST_HALF = 7
private const val FIRST_INDEX_OF_SECOND_HALF = 8

fun main() {
    fun mySolution(input: List<String>): String = buildString {
        input.forEach { line ->
            val halfCharsInSet = mutableSetOf<Char>()
            (0..LAST_INDEX_OF_FIRST_HALF).forEach { idx ->
                halfCharsInSet.add(line[idx])
            }

            var secondPairles = 'a'
            (FIRST_INDEX_OF_SECOND_HALF..line.lastIndex).forEach { idx ->
                val char = line[idx]
                if (halfCharsInSet.contains(char)) {
                    halfCharsInSet.remove(char)
                } else {
                    secondPairles = char
                }
            }

            append(halfCharsInSet.first())
            append(secondPairles)
        }
    }

    val inputTest = readInput("Challenge10Test")
    check("pi" == mySolution(inputTest))

    val input = readInput("Challenge10")
    check("Iamyouruncle" == mySolution(input))
}

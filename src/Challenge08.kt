import kotlin.io.path.readText

fun main() {
    fun mySolution(input: List<String>): String {
        val setsOfNameChars = input.map { name ->
            name.toCharArray().toSet()
        }

        val frequenciesOfSets = buildMap {
            setsOfNameChars.forEach { setOfChars ->
                put(setOfChars, this.getOrDefault(setOfChars, 0) + 1)
            }
        }

        val uniqueSet = frequenciesOfSets.filter { it.value == 1 }
            .keys
            .firstOrNull()
        checkNotNull(uniqueSet) { "Error. No unique set found" }

        val result = input.find { name ->
            uniqueSet.all { char ->
                name.contains(char)
            }
        }
        checkNotNull(result) { "Error. Failed to find name with uniques set."}

        return result
    }

    val input = pathToInput("Challenge08")
        .readText()
        .split(' ')

    check("kamoquzlnexbyw" == mySolution(input))
}

fun main() {
    fun mySolution(input: List<Int>): MutableList<Int> {
        val frequencies: MutableMap<Int, Int> = mutableMapOf()

        input.forEach { digit ->
            frequencies[digit] = frequencies.getOrDefault(digit, 0) + 1
        }

        val result = mutableListOf<Int>()

        repeat(4) {
            var maxVal = Int.MIN_VALUE
            var maxKey = -1
            frequencies.forEach { (key, value) ->
                if (value > maxVal) {
                    maxVal = value
                    maxKey = key
                }
            }
            result.add(maxKey)
            frequencies.remove(maxKey)
        }

        return result
    }

    // Read the input from the `src/Day01.txt` file.
    val input = readLongNumberAsList()

    mySolution(input).println()
}

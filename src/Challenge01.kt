fun main() {
    fun mySolution(input: List<Int>): MutableList<Int> {
        val frequencies: MutableMap<Int, Int> = mutableMapOf()

        input.forEach { digit ->
            frequencies[digit] = frequencies.getOrDefault(digit, 0) + 1
        }

        val result = mutableListOf<Int>()

        repeat(4) {
            var maxFreq = Int.MIN_VALUE
            var digitWithMaxFreq = -1
            frequencies.forEach { (digit, freq) ->
                if (freq > maxFreq) {
                    maxFreq = freq
                    digitWithMaxFreq = digit
                }
            }
            result.add(digitWithMaxFreq)
            frequencies.remove(digitWithMaxFreq)
        }

        return result
    }

    val input = readLongNumberAsList("Challenge01")

    mySolution(input).println()
}

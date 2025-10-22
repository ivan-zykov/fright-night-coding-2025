fun main() {
    fun mySolution(input: List<String>): Int {
        return input.size
    }

    // Read the input from the `src/Day01.txt` file.
    val input = readInput("Challenge00")
    mySolution(input).println()
}

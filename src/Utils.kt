import java.nio.file.Path
import kotlin.io.path.Path
import kotlin.io.path.readText

/**
 * Reads lines from the given input txt file.
 */
fun readInput(name: String) = Path("src/$name.txt").readText().trim().lines()

/**
 * The cleaner shorthand for printing output.
 */
fun Any?.println() = println(this)

fun readLongNumberAsList(filename: String): List<Int> = Path("src/$filename.txt")
    .readText()
    .trim()
    .map { it.digitToInt() }

fun pathToInput(filename: String): Path = Path("src/$filename.txt")
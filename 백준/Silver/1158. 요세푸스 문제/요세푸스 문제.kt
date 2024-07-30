import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val (n, k) = br.readLine().split(" ").map { it.toInt() }

    val result = getJosephusSequence(n, k)
    println(result.joinToString(prefix = "<", postfix = ">", separator = ", "))
}

fun getJosephusSequence(n: Int, k: Int): List<Int> {
    val people = (1..n).toMutableList()
    val result = mutableListOf<Int>()
    var index = 0

    while (people.isNotEmpty()) {
        index = (index + k -1) % people.size
        result.add(people.removeAt(index))
    }
    return result
}

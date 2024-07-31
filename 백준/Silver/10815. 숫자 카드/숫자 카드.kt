import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))

    // 상근이 N
    val N = br.readLine().toInt()
    // 상근이 가지고있는 카드
    val sangeunCards = br.readLine().split(" ").map { it.toInt() }.toSet()

    // 찾아야되는 M
    val M = br.readLine().toInt()
    // 찾아야되는 카드
    val findCards = br.readLine().split(" ").map { it.toInt() }

    val result = StringBuilder()

    //상근이 카드 있는지 확인
    for(card in findCards) {
        if (card in sangeunCards) {
            result.append("1 ")
        } else {
            result.append("0 ")
        }
    }

    println(result)
}
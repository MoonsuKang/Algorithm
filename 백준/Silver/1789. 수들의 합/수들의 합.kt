fun main() {
    val S = readln().toLong() // s를 입력받는다

    var sum: Long = 0
    var N: Long = 0

    // 1부터 차례대로 더해서 S를 넘지 않는 최대의 N을 찾아야됨
    while (sum <= S) {
        N ++
        sum += N
    }
    println(N-1) // 합이 S를 초과했으므로, N을 하나 줄여

}
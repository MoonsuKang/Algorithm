fun main() {
    val br = System.`in`.bufferedReader()
    val N = br.readLine().toInt()
    val requests = br.readLine().split(" ").map { it.toInt() }
    val M = br.readLine().toInt()

    require(requests.size == N)

    var low = 0
    var high = requests.maxOrNull() ?: 0
    var answer = 0

    while (low <= high) {
        val mid = (low + high) / 2
        val total = requests.sumOf { if (it > mid) mid else it }

        if (total <= M) {
            answer = mid
            low = mid + 1
        } else {
            high = mid - 1
        }
    }

    println(answer)
}

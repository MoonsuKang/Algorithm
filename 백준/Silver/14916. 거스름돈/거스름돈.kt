fun solution(n: Int): Int {
    var count = 0
    var remaining = n

    while (remaining >= 0) {
        if (remaining % 5 == 0) {
            return count + (remaining / 5)
        }
        remaining -= 2 // 2원 동전 사용해서 감소
        count ++
    }
    return -1 // 거스름돈 거슬러 줄 수 없으면
}
fun main() {
    val n = readln().toInt()
    println(solution(n))
}

//거스름 돈 액수 n
// 15원 이면 5
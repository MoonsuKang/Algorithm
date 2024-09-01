class Solution {
    fun solution(n: Long): Long {
        var answer: Long = 0
        //n의 제곱근 121의 제곱근은 11
        val sqrt = Math.sqrt(n.toDouble()).toLong()
        print(sqrt)
        return if (sqrt * sqrt == n) {
            (sqrt + 1) * (sqrt + 1)
        } else {
            -1
        }
    }
}
// x**z == n
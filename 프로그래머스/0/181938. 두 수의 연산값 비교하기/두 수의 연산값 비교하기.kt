class Solution {
    fun solution(a: Int, b: Int): Int {
        val joinValue = (a.toString() + b.toString()).toInt() // 연산자
        val  multyValue = 2 * a * b
        return if (joinValue >= multyValue) joinValue else multyValue
    }
}
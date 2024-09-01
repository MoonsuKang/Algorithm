class Solution {
    fun solution(x: Int): Boolean {
        val digitSum = x.toString().map {it.toString().toInt() }.sum() // 자릿수를 더한 값
        return x % digitSum == 0
    }
}
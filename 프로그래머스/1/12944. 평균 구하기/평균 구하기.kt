class Solution {
    fun solution(arr: IntArray): Double {
        var answer = 0
        val sum = arr.sum()
        val count = arr.size
        println(sum)
        println(count)
        return sum.toDouble() / count
    }
}
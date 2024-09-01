class Solution {
    fun solution(a: Int, b: Int): Long {
        var answer = 0L
        val start = minOf(a, b)
        val end = maxOf(a, b)
        println(start)
        println(end)
        return (start..end).sumOf {it.toLong()}
    }
}
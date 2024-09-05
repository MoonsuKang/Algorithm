class Solution {
    fun solution(s: String): String {
        val x = s.toCharArray().sortedDescending().joinToString("")
        
        println(x)
        return x
    }
}
class Solution {
    fun solution(s: String): Boolean {
        val sLength = s.length
        println(sLength)
        
        return (s.length == 4 || s.length == 6) && s.all {it.isDigit()}
    }
}
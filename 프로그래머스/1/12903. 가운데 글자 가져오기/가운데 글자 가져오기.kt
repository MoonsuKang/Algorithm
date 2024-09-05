class Solution {
    fun solution(s: String): String {
        val sLength = s.length
        val middle = sLength / 2
        println(sLength)
        return if (sLength % 2 == 0) {
            s.substring(middle-1, middle+1)
        } else {
            s.substring(middle, middle+1)
        }
    }
}
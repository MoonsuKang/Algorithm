class Solution {
    fun solution(n: Int, control: String): Int {
        var result = n
        
        for(c in control) {
            when(c) {
                'w' -> result += 1
                's' -> result -= 1
                'd' -> result += 10
                'a' -> result -= 10
                }
            }
        return result
        }
}
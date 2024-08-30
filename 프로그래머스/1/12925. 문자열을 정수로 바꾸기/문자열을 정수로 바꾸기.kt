class Solution {
    fun solution(s: String): Int {
        val sign = if (s[0] == '-') -1 else 1
        val num = s.substring(if (s[0] == '+' || s[0] == '-') 1 else 0).toInt()
        return sign * num
    }
}
// '-' -1 else 1
// subString 으로 숫자만 추출
// toInt로 숫자로
class Solution {
    fun solution(phone_number: String): String {
        // 전화번호의 길이를 구해
        val pnLength = phone_number.length
        println(pnLength)
        // 뒤에 4개 빼고 마스킹
        val masking = "*".repeat(pnLength -4)
        println(masking)
        // 마지막4자리
        val lastfour = phone_number.takeLast(4)
        println(lastfour)
        return masking + lastfour
    }
}
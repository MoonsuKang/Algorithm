class Solution {
    fun solution(n: Int): String {
        // n /2 만큼을 반복시키고 나머지가 1일 때 수
        return "수박".repeat(n/2) + if (n%2 == 1) "수" else ""
    }
}
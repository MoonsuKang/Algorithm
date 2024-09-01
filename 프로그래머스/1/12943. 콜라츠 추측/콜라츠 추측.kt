class Solution {
    fun solution(num: Int): Int {
        var count = 0
        var current = num.toLong()
        
        while (current != 1L) {
            if (count >= 500) return -1
            current = if (current % 2 == 0L) { //짝수일떄
                current / 2
            } else {
                (current * 3) + 1
            }
            count++
        }
        return count
    }
}

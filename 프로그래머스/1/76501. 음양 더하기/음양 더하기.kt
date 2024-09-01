class Solution {
    fun solution(absolutes: IntArray, signs: BooleanArray): Int {
        var sum = 0
        
        for (i in absolutes.indices) {
            if (signs[i]) { //참이면
                sum += absolutes[i]
            } else {
                sum -= absolutes[i]
            }
            println(sum)
        }
        return sum
    }
}
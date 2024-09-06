class Solution {
    fun solution(number: IntArray): Int {
        var count = 0
        for (i in 0 until number.size - 2) {
            for (j in i+1 until number.size - 1) {
                for (k in j+1 until number.size) {
                    println(k)
                    if (number[i] + number[j] + number[k] == 0) {
                        count ++
                    }
                }
            }
        }
        return count
    }
}

// number을 3개 더했을 때 0이면 삼총사
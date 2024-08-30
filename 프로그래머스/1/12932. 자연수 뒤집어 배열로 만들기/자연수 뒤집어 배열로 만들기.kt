class Solution {
    fun solution(n: Long): IntArray {
        return n.toString()
                .reversed()
                .map{ it.toString().toInt()}
                .toIntArray()
    }
}

// 문자열로 변환해.
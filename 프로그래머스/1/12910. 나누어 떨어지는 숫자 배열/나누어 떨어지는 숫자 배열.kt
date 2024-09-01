class Solution {
    fun solution(arr: IntArray, divisor: Int): IntArray {
        // divisor로 나누어 떨어지는 원소들을 필터링
        val result = arr.filter { it % divisor == 0 }
        println(result.sorted())
        return if (result.isNotEmpty()) {
            result.sorted().toIntArray()
        } else {
            intArrayOf(-1)
        }
    }
}
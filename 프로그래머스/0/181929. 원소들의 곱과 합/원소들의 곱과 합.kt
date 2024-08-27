class Solution {
    fun solution(num_list: IntArray): Int {
        val product = num_list.reduce { acc, num -> acc * num }
        val sum = num_list.sum() // 원소합
        val sumSquared = sum * sum // 합의 제곱
        
        return if (product < sumSquared) 1 else 0 // 곱의 합이 제곱보다 작으면1
    }
}
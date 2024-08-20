class Solution {
    fun solution(num_list: IntArray, n: Int): IntArray {
        val front = num_list.sliceArray(n until num_list.size)
        val back = num_list.sliceArray(0 until n)
        
        return front + back
    }
}
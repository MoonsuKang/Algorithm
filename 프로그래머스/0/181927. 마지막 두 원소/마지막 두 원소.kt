class Solution {
    fun solution(num_list: IntArray): IntArray {
        val last = num_list[num_list.size -1]
        val secondLast = num_list[num_list.size -2]
        
        val newValue = if (last > secondLast) {
            last - secondLast
        } else {
            last * 2
        }
        
        return num_list + newValue
    }
}
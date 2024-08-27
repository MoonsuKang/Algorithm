class Solution {
    fun solution(num_list: IntArray): Int {
        var odd = ""
        var even = ""
        
        for(num in num_list) {
            if(num % 2  == 0) {
                even += num.toString() //짝
            } else {
                odd += num.toString()
            }
        }
        return even.toInt() + odd.toInt()
    }
}
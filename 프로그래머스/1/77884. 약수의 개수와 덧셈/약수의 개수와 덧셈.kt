class Solution {
    fun solution(left: Int, right: Int): Int {
        var result = 0
        
        for(num in left..right) {
            // 완전 제곱수를 구해야됨
            if (Math.sqrt(num.toDouble()) % 1 == 0.0) {
                //완제곱수면 빼
                result -= num
            } else {
                result += num
            }
        }
        return result
    }
}
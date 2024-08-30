class Solution {
    fun solution(n: Int): Int {
        return n.toString().map { it.toString().toInt() }.sum()
    }
}


// class Solution {
//     fun solution(n: Int): Int {
//         var answer = 0
//         while (n > 0) {
//             val digit = n % 10
//             answer += digit
//             // println(answer) ?
//             n /= 10
            
//         }

//         return answer
//     }
// }

class Solution {
    fun solution(numbers: IntArray): Int {
        var sum = 45 //0~9 더하면 45
        // 배열의 원소들의 합
        val numberSum = numbers.sum()
        println(numberSum)
        return sum - numberSum
    }
}
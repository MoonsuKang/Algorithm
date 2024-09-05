class Solution {
    fun solution(a: IntArray, b: IntArray): Int {
        var result = 0
        for (i in a.indices) {
            // println(i)
            result += a[i] * b[i]
        }
        return result
    }
}

//내적. a1b1 + a2b2 + ... anbn
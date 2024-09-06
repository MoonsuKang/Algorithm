class Solution {
    fun solution(arr1: Array<IntArray>, arr2: Array<IntArray>): Array<IntArray> {
        // 행렬의 크기가 동일함
        val rowCount = arr1.size // [], [] == 2
        val columnCount = arr1[0].size // [1],[2] == 1
        println(rowCount)
        println(columnCount)
        val result = Array(rowCount) {IntArray(columnCount)}
    
        for (i in 0 until rowCount) {
            for (j in 0 until columnCount) {
                result[i][j] = arr1[i][j] + arr2[i][j]
            }
        }
        
        return result
    }
}
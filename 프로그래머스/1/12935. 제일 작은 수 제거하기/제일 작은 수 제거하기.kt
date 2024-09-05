class Solution {
    fun solution(arr: IntArray): IntArray {
        if (arr.size == 1) {
            return intArrayOf(-1)
        }
        
        val minValue = arr.minOrNull() //배열에서 젤 작은거
        
        //minValue를 제외한 배열
        return arr.filter {it != minValue }.toIntArray()
    }
}
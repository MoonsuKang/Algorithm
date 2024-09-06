class Solution {
    fun solution(sizes: Array<IntArray>): Int {
        var maxWidth = 0
        var maxHeight = 0
        var answer = 0
        
         // 각 명함을 순회하면서 가로와 세로를 정렬
        for(size in sizes) {
            // 가로와 세로 중 더 큰 값을 가로로 설정
            val width = maxOf(size[0], size[1])
            // 가로와 세로 중 더 작은 값을 세로로 설정
            val height = minOf(size[0], size[1])
            // println(width)
            // println(height)
            maxWidth = maxOf(maxWidth, width)
            // println(maxWidth)
            maxHeight = maxOf(maxHeight, height)
            // println(answer)
        }
        answer = maxHeight * maxWidth
        
        return answer
    }
}

//
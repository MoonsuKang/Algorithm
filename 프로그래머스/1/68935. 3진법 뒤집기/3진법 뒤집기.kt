class Solution {
    fun solution(n: Int): Int {
        // 3진법으로 바꿔 그리고 뒤집어 
        val reversedTernary = n.toString(3).reversed()
        println(reversedTernary)
    //그리고 10진법으로 바꿔
    val decimal = reversedTernary.toInt(3)
    println(decimal)
        return decimal
    }
}
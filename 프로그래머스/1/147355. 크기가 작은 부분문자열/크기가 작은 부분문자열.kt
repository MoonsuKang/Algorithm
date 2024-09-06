class Solution {
    fun solution(t: String, p: String): Int {
        var count = 0
        val pNum = p.toLong()
        //같은길이 문자열 돌아
        for(i in 0..t.length - p.length) {
            val subStr = t.substring(i, i+p.length)
            // println(subStr)
            val subNum = subStr.toLong()
            println(subNum)
            if(subNum <= pNum) {
            count ++
        }
        }
        return count
    }
    
}
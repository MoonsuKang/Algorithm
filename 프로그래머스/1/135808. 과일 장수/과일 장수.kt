class Solution {
    fun solution(k: Int, m: Int, score: IntArray): Int {
        var answer = 0
        var descendingScore = score.sortedDescending()
        // println(descendingScore)
        //배열을 m개씩 묶어서 처리하기 위해 step m을 사용해서 인덱스를 m씩 증가시켜
        // case 1경우 0..6 4만큼
        for(i in descendingScore.indices step m) {
            //남는 사과가 없는지 확인
            if (i + m <= descendingScore.size) {
                val lowestScoreInBox = descendingScore[i + m - 1]
                answer += lowestScoreInBox * m
            }
        }
        
        return answer
    }
}

// 1최하~k최상 의 점수
// 한 박스에 m개씩 담아 포장
// 가장 낮은 사과 점수 * m개 = 상자 가격
// 최대 이익을 return(조합(n*m) + 조합 + 조합...)
// indice 리스트가 7이야. 그러면 0..6
//step m으로 인덱스를 m만큼 증가시켜

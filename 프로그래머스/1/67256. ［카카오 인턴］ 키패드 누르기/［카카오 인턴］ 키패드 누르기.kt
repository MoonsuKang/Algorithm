class Solution {
    fun solution(numbers: IntArray, hand: String): String {
        val key = mapOf(
            1 to Pair(0,0),
            2 to Pair(0,1),
            3 to Pair(0,2),
            4 to Pair(1,0),
            5 to Pair(1,1),
            6 to Pair(1,2),
            7 to Pair(2,0),
            8 to Pair(2,1),
            9 to Pair(2,2),
            '*' to Pair(3,0),
            0 to Pair(3,1),
            '#' to Pair(3,2), 
        )
        //왼* 우#
        var leftHandStart = key['*']!!
        var rightHandStart = key['#']!!
        val sb = StringBuilder()
        
        for(number in numbers){
            when (number) {
                1, 4, 7 -> {
                    sb.append("L")
                    leftHandStart = key[number]!!
                    // println(leftHandStart)
                }
                3, 6, 9 -> {
                    sb.append("R")
                    rightHandStart = key[number]!!
                    // println(rightHandStart)
                }
                // 2580 거리 계산해서 같으면 주손으로. 좌표 점 사이 거리를 |x1 - x2| + |y1 - y2| (1,2) (4,5) 3 + 3 6
                else -> { 
                    val middleTarget = key[number]!!
                    val leftDistance = getDistance(leftHandStart, middleTarget)
                    val rightDistance = getDistance(rightHandStart, middleTarget)

                    if (leftDistance < rightDistance) {
                        sb.append("L")
                        leftHandStart = middleTarget
                    } else if (rightDistance < leftDistance) {
                        sb.append("R")
                        rightHandStart = middleTarget
                    } else {
                        if (hand == "left") {
                            sb.append("L")
                            leftHandStart = middleTarget
                        } else {
                            sb.append("R")
                            rightHandStart = middleTarget
                        }
                    }
                }
            }
        }

        return sb.toString()
    }

    private fun getDistance(position1: Pair<Int, Int>, position2: Pair<Int, Int>): Int {
        return Math.abs(position1.first - position2.first) + Math.abs(position1.second - position2.second)
    }
}

// 처음 왼* 우# 4가지 방향. 
// 왼손 147
// 오른손 369
// 2580까지의 거리가 같다면 주손으로
// 키에 대한 좌표를 만들어야 될듯 1 부터 0,0 
// 가운데 계산은 어카냐?음

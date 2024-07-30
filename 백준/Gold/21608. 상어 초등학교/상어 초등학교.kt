import java.io.BufferedReader
import java.io.InputStreamReader

data class Student(
    val id: Int,
    val likes: List<Int>,
)

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine().toInt()
    val students = Array(n * n) { Student(0, emptyList()) }
    val position = Array(n) { IntArray(n) }
    val likeMap = mutableMapOf<Int, List<Int>>()

    for(i in 0..< n*n) {
        val input = br.readLine().split(" ").map { it. toInt() }
        val id = input[0]
        val likes = input.subList(1, 5)
        students[i] = Student(id, likes)
        likeMap[id] = likes
    }

    val directions = arrayOf(Pair(-1,0), Pair(1,0), Pair(0,-1), Pair(0,1))

    fun findPosition(student: Student): Pair<Int, Int> {
        var bestPosition = Pair(-1,-1)
        var maxLikes = -1
        var maxEmpty = -1

        for(r in 0..< n) {
            for(c in 0..< n) {
                if(position[r][c] != 0) continue

                var likeCount = 0
                var emptyCount = 0

                for(dir in directions) {
                    val nr = r + dir.first
                    val nc = c + dir.second

                    if(nr in 0..< n && nc in 0..< n) {
                        if(position[nr][nc] == 0) {
                            emptyCount++
                        } else if(position[nr][nc] in student.likes) {
                            likeCount++
                        }
                    }
                }
                if (likeCount > maxLikes || (likeCount == maxLikes && emptyCount > maxEmpty)) {
                    bestPosition = Pair(r, c)
                    maxLikes = likeCount
                    maxEmpty = emptyCount
                }
            }
        }
        return bestPosition
    }
    fun calculateSatisfaction(): Int {
        var totalSatisfaction = 0

        for (r in 0..< n) {
            for (c in 0..< n) {
                val studentId = position[r][c]
                val likes = likeMap[studentId]!!
                var likeCount = 0

                for (dir in directions) {
                    val nr = r + dir.first
                    val nc = c + dir.second

                    if (nr in 0..< n && nc in 0..< n && position[nr][nc] in likes) {
                        likeCount++
                    }
                }

                totalSatisfaction += when (likeCount) {
                    1 -> 1
                    2 -> 10
                    3 -> 100
                    4 -> 1000
                    else -> 0
                }
            }
        }

        return totalSatisfaction
    }

    for (student in students) {
        val (r, c) = findPosition(student)
        position[r][c] = student.id
    }

    println(calculateSatisfaction())
}
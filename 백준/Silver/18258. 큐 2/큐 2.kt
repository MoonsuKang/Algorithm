import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val sb = StringBuilder() // 결과 저장
    val que = LinkedList<Int>() // 큐를 구현할 연결 리스트
    val n = br.readLine().toInt() // 입력 수

    repeat(n) {
        val command = br.readLine().split(" ") // 공백 기준으로 분리
        when(command[0]) {
            "push" -> que.add(command[1].toInt()) // 큐에 정수 추가
            "pop" -> sb.appendLine(if (que.isEmpty()) -1 else que.poll())
            "size" -> sb.appendLine(que.size)
            "empty" -> sb.appendLine(if (que.isEmpty()) 1 else 0)
            "front" -> sb.appendLine(if (que.isEmpty()) -1 else que.peek())
            "back" -> sb.appendLine(if (que.isEmpty()) -1 else que.peekLast())
        }
    }
    print(sb.toString())
}
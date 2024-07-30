import java.util.LinkedList
import java.util.Queue

/**
add: 지정된 요소를 리스트의 끝에 추가
poll(): 리스트의 첫 번째 요소를 제거하고 반환. 리스트가 비어 있으면 null을 반환
 */
fun main() {
    val n = readln().toInt() // 입력값
    val que: Queue<Int> = LinkedList() // 카드 순서 관리

    //1부터 N까지 카드를 큐에 삽입
    for (i in 1..n) {
        que.add(i)
    }
    // 카드가 한 장 남을 때 까지 반복
    while (que.size > 1) {
        que.poll() //제일 위에 있는 카드 버리기
        que.add(que.poll()) // 그 다음 카드를 제일 아래로 옮기
    }
    println(que.poll()) // 마지막에 남은 카드 출력
}

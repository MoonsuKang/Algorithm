import java.io.BufferedReader
import java.io.InputStreamReader

lateinit var stack: IntArray // 스택 저장 배열
var ptr = -1 // 스택의 현재 위치, -1로 현재 스택이 비어있다는 걸로

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val testCase = br.readLine().toInt()

    stack = IntArray(testCase)

    for (i in 0..<testCase) {
        when (val input = br.readLine()) {
            "top" -> println(top())
            "pop" -> println(pop())
            "empty" -> println(isEmpty())
            "size" -> println(size())
            else -> push(input.split(" ")[1].toInt())
        }
    }
}

fun push(x: Int) {
    stack[++ptr] = x // 입력받은 정수 스택에 추가하고 포인터 증가
}

fun size(): Int {
    return ptr + 1 // 현재 스택에 있는 정수의 개수 반환
}

fun isEmpty(): Int {
    return if (ptr == -1) 1 else 0 // 비어있으면 1 아니면 0
}

fun pop(): Int {
    return if (ptr == -1) -1 else stack[ptr--] // 가장 위에 있는 정수 제거하고 반환, 비어있으면 -1 반환
}

fun top(): Int {
    return if (ptr == -1) -1 else stack[ptr] // 가장 위에 있는 정수 반환
}
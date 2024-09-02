fun main() {
    val board = readln()
    
    val parts = board.split('.')
    val result = StringBuilder()

    for (part in parts) {
        if (part.isNotEmpty()) {
            if (part.length % 2 == 1) {
                println(-1)
                return
            }
            result.append("AAAA".repeat(part.length / 4))
            result.append("BB".repeat((part.length % 4) / 2))
        }
        result.append('.')
    }
    
    if (result.last() == '.') result.deleteCharAt(result.length - 1)

    println(result.toString())
}

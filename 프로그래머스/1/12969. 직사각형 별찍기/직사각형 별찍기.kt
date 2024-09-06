fun main(args: Array<String>) {
    val (n, m) = readLine()!!.split(' ').map(String::toInt)
    // println(n)
    // println(m)
    
    // 세로만큼 반복
    repeat(m) {
        println("*".repeat(n))
    }
}
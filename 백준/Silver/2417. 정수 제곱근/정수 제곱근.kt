import java.math.BigInteger

fun main() {
    val n = BigInteger(readln())
    var low = BigInteger.ZERO
    var high = n

    while (low <= high) {
        val mid = (low + high) / BigInteger.valueOf(2)
        val midSquared = mid * mid

        if (midSquared < n) {
            low = mid + BigInteger.valueOf(1)
        } else {
            high = mid - BigInteger.valueOf(1)
        }
    }

    println(low)
}

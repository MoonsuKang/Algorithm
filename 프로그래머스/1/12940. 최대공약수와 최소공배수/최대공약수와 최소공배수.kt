class Solution {
    fun solution(n: Int, m: Int): IntArray {
        //유클리드 알고리즘 사용
        // m을 n으로 나눈 나머지를 구하고, 나머지가 0이 될 때 까지 반복하는데 0되면 그게 최대공약수
        
        //최대공통약수
        val gcd = gcd(n, m)
        println(gcd)
        //최소공통배수
        val lcm = (n*m) / gcd
        println(lcm)
        
        return intArrayOf(gcd, lcm)
    }
    //b가 0이면 a가 최대공약수
    //else gcd(b, a%b)를 재귀호출해서 나머지가 0이 될 때까지 계산
    fun gcd(a: Int, b: Int): Int {
        return if (b == 0) a else gcd(b, a%b)
    }
    
}
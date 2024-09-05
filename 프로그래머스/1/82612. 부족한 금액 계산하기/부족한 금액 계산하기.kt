class Solution {
    fun solution(price: Int, money: Int, count: Int): Long {
        //등차수열 합 공식을 사용하면 될듯
        // count(count+1) 나누기 2
        var totalCost = price.toLong() * count*(count + 1) / 2
        println(totalCost)
        // 부족한 돈을 계산해
        var notEnoughMoney = totalCost - money
        println(notEnoughMoney)
        
        
        
        return if (notEnoughMoney > 0) notEnoughMoney else 0
    }
}
// 원래 3원이야. 이용료는 20원 count가 4회면 3+6+9+12 니까 30원이 되는데 가진돈이 20원이야 10원 부족해 그러면 그걸 리턴. 안부족하면 0
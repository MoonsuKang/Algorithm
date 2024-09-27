class Solution {
    public int solution(int number, int limit, int power) {
        int answer = 0;
        for(int i=1; i<= number; i++){
            int divisorCount = countDivisor(i);
            
            if (divisorCount > limit) {
                answer += power;
            } else {
                answer += divisorCount;
            }
        }
        return answer;
    }
    
    // 약수 개수 계산
    private int countDivisor(int num) {
        int count = 0;
        // 제곱근 까지 약수 확인
        for (int i = 1; i * i <= num; i++) {
            if (num % i == 0) {
                count++;
                if (i != num / i) {
                    count++;
                }
            }
        }
        return count;
    }
}


// 15 -> 1, 3, 5, 15 -> power=4 -> if limit 3 -> power=2
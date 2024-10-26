class Solution {
    public int solution(int[] nums) {
        return dfs(nums, 0, 0, 0);
    }

    // depth: 현재 선택한 숫자 개수
    // start: 다음 숫자 index
    private int dfs(int[] nums, int depth, int start, int sum) {
        if (depth == 3) {
            // 합이 소수면 1
            return isPrime(sum) ? 1 : 0;
        }
        
        int count = 0; // 소수 경우의 수
        for (int i = start; i < nums.length; i++) { // 배열 탐색
            count += dfs(nums, depth + 1, i + 1, sum + nums[i]); //+1 재귀 호출, 선택한 숫자 합을 다음 호출에 전달
        }
        return count;
    }

    // 소수 판별
    private boolean isPrime(int num) {
        if (num < 2) return false;
        for (int i = 2; i * i <= num; i++) { // 2~ num 제곱근
            if (num % i == 0) return false; // 나누어 떨어지면 소수가 아님
        }
        return true; // 소수인 경우 true
    }
}
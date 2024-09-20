class Solution {
    public int solution(int[] numbers, int target) {
        return dfs(numbers, target, 0, 0);
    }
    // index는 현재 탐색 중인 숫자의 위치, sum은 현재까지 계산한 값
    private int dfs(int[] numbers, int target, int index, int sum){
        if (index == numbers.length) {
            // 모든 숫자를 다 사용하면
            if(sum == target) {
                return 1; // 타겟 넘버와 같으면 1 증가
            } else {
                return 0;
            }
        }
        
        // 현재 숫자를 더하는 경우와 빼는 경우로 재귀적으로 호출
        return dfs(numbers, target, index+1, sum+numbers[index]) +
            dfs(numbers, target, index+1, sum-numbers[index]);
        
    }
}
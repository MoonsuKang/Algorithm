class Solution {
    public int solution(int[] numbers, int target) {
        // System.out.println(numbers.length);
        return dfs(numbers, target, 0, 0);
    }
    private int dfs(int[] numbers, int target, int index, int sum) {
        // 모든 숫자를 사용한 경우
        if(index == numbers.length) {
            //합이 타겟이랑 같은 경우
            if(sum == target) {
                return 1;
            } else {
                return 0;
            }
        }
         // 현재 숫자를 더하는 경우와 빼는 경우로 분기처리
        int count = 0;
        count += dfs(numbers, target, index+1, sum+numbers[index]); //더하기
        count += dfs(numbers, target, index+1, sum-numbers[index]); //빼기
        
        return count;
    }
}

// DFS로 현재 숫자를 더하거나 뺀 다음, 다음 숫자로 이동하는 방식으로 구현


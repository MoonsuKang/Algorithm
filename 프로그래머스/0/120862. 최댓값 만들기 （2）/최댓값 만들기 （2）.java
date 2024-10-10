import java.util.Arrays;

class Solution {
    public int solution(int[] numbers) {
        // 배열을 오름차순으로 정렬
        Arrays.sort(numbers);
        
        // 가장 큰 두 수의 곱
        int maxProduct1 = numbers[numbers.length - 1] * numbers[numbers.length - 2];
        
        // 가장 작은 두 수의 곱 (음수 곱의 경우)
        int maxProduct2 = numbers[0] * numbers[1];
        
        // 더 큰 값을 반환
        return Math.max(maxProduct1, maxProduct2);
    }
}

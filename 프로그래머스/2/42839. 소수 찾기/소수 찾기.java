import java.util.*;

class Solution {

    private boolean isPrime(int num) {
        if (num <= 1) return false;
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) return false;
        }
        return true;
    }

    // 모든 순열 생성
    private void generatePermutations(String prefix, String numbers, boolean[] visited, Set<Integer> set) {
        // 빈 문자열이 아닐 때 숫자로 변환하여 set에 추가
        if (!prefix.isEmpty()) {
            set.add(Integer.parseInt(prefix));
        }

        // 각 자리의 숫자를 하나씩 선택해 순열 생성
        for (int i = 0; i < numbers.length(); i++) {
            if (!visited[i]) { // 방문하지 않은 숫자만 사용
                visited[i] = true;
                generatePermutations(prefix + numbers.charAt(i), numbers, visited, set);
                visited[i] = false;
            }
        }
    }

    public int solution(String numbers) {
        Set<Integer> set = new HashSet<>();
        boolean[] visited = new boolean[numbers.length()];

        // 모든 순열 생성
        generatePermutations("", numbers, visited, set);

        // 소수의 개수 세기
        int count = 0;
        for (int num : set) {
            if (isPrime(num)) {
                count++;
            }
        }

        return count;
    }
}

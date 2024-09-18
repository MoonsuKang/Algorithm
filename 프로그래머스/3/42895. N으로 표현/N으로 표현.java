import java.util.*;

class Solution {
    public int solution(int N, int number) {
        
        Set<Integer>[] dp = new Set[9]; //n사용한 횟수. 1~8
        
        for(int i=1; i <= 8; i++){
            dp[i] = new HashSet<>();
        }
        
        
        int repeatedN = 0;
        for(int i=1; i<=8; i++){
            repeatedN = repeatedN * 10 + N; // 5, 55, 555, 5555
            dp[i].add(repeatedN);
        }
        
        //최소값 찾기
        for(int i =1; i<=8; i++){ //N 사용 횟수 i
            for(int j=1; j<i; j++) { //j와 i-j로 분할
                for(int a: dp[j]) {
                    for(int b: dp[i-j]) {
                        dp[i].add(a+b);
                        dp[i].add(a-b);
                        dp[i].add(a*b);
                        if(b != 0) {
                            dp[i].add(a/b);
                        }
                        
                    }
                }
            }
            if(dp[i].contains(number)){
                return i;
            }
        }
        //최솟값이 8보다 크면 -1을 return 합니다.
        return -1;
    }
}

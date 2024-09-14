import java.util.*;

class Solution {
    public int[] solution(int n) {
        List<Integer> answer = new ArrayList<>();
        for(int i=0; i<=n; i++){
            if(i%2 != 0){
                // System.out.println(i);
                answer.add(i);
            }
        }
        //정수 배열로 변환
        return answer.stream().mapToInt(i -> i).toArray();
    }
}
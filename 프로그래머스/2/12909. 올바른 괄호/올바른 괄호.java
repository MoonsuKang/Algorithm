import java.util.*;

class Solution {
    boolean solution(String s) {
        int count = 0; // 열린 개수 추적
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if(c == '(') {
                count ++;
            } else {
                count --;
            }
            // 중간에 닫힌 괄호가 더 많은 경우
            if(count < 0) {
                return false;
            }
            
        }
        

        return count == 0;
    }
}
import java.util.*;

class Solution {
    public String solution(String my_string) {
        StringBuilder sb = new StringBuilder();
            for (int i = 0; i < my_string.length(); i++) {
            char ch = my_string.charAt(i);
            // 모음이 아닌 경우만 result에 추가
            if (ch != 'a' && ch != 'e' && ch != 'i' && ch != 'o' && ch != 'u') {
                sb.append(ch);
            }
        }
        
        return sb.toString();
    }
}
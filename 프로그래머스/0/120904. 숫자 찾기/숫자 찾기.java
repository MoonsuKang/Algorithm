import java.util.*;

class Solution {
    public int solution(int num, int k) {
        String numStr = String.valueOf(num);
        String kToStr = String.valueOf(k);
        
        int index = numStr.indexOf(kToStr);
        System.out.println(index);
        
        return index != -1 ? index + 1 : -1;
    }
}
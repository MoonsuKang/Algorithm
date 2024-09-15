import java.util.*;

class Solution {
    public int solution(int[][] sizes) {
        int answer = 0;
        int maxHeight = 0;
        int maxWidth = 0;
        // 가로는 size[0] 세로는 size[1]
        for(int[] size: sizes) {
             // 각 명함을 회전해서 큰 값은 가로, 작은 값은 세로
            int width = Math.max(size[0], size[1]);
            int height = Math.min(size[0], size[1]);
            // System.out.println(width); // 6,7,6,8
            // System.out.println(height); // 5,3,3,4
            
            maxWidth = Math.max(maxWidth, width);
            maxHeight = Math.max(maxHeight, height);
        }
        
        return maxHeight * maxWidth;
    }
}
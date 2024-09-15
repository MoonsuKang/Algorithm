import java.util.*;

class Solution {
    public int solution(int[] nums) {
        int answer = 0;
        // 1. 폰켓몬 종류의 개수 파악 (Set을 사용하여 중복 제거)
        HashSet<Integer> poketMonType = new HashSet<>();
        for(int num: nums) {
            poketMonType.add(num);
        }
         // System.out.println(poketMonType);
        int maxSelect = nums.length / 2;
        // 선택 가능한 폰켓몬 종류의 수 계산
        int maxVariety = Math.min(poketMonType.size(), maxSelect);
        System.out.println(maxVariety);
        
        return maxVariety;
    }
}
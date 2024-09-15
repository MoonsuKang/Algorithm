import java.util.*;
class Solution {
    public int solution(String[][] clothes) {
        int answer = 0;
        HashMap<String, Integer> clothesMap = new HashMap<>();
        for(String[] cloth: clothes) {
            String type = cloth[1];
            clothesMap.put(type,clothesMap.getOrDefault(type, 0) + 1);
        }
        
        //조합 계산
        int combinations = 1;
        for(int count: clothesMap.values()) {
            combinations *= (count+1); 
        }
        // System.out.println(clothesMap);
        return combinations-1;
    }
}
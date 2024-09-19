import java.util.*;

class Solution {
    public int solution(String[] s1, String[] s2) {
        
        HashSet<String> set = new HashSet<>();
        for(String str: s1){
            set.add(str);
            // System.out.println("Added: " + str + ", Set: " + set);
        }
        int count = 0;
        for(String str: s2){
            if(set.contains(str)) {
                count ++;
            }
        }
        return count;
    }
}
import java.util.*;

public class Solution {
    public int[] solution(int []arr) {
        int[] answer = {};
        
        List<Integer> result = new ArrayList<>();
        result.add(arr[0]);
        // System.out.println(result);
        for(int i=1; i <arr.length; i++){
            if(arr[i] != arr[i-1]){
                result.add(arr[i]);
            }
        }
        

        return result.stream().mapToInt(i->i).toArray();
    }
}
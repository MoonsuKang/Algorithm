import java.util.*;

class Solution {
    public String solution(int[] numbers) {
        String answer = "";
        //문자열 배열로 바꿔
        String[] numStrings = new String[numbers.length];
        for(int i=0; i < numbers.length; i++){
            numStrings[i] = String.valueOf(numbers[i]);
        }
        // 정렬해
        Arrays.sort(numStrings, (a, b) -> (b + a).compareTo(a + b));
        
        // 정렬된 배열을 하나의 문자열로 합쳐
        StringBuilder sb = new StringBuilder();
        for (String num : numStrings) {
            sb.append(num);
        }
        // 결과가 "0000"처럼 0으로 시작하는 경우 처리
        if (sb.charAt(0) == '0') {
            return "0";
        }
        return sb.toString();
    }
}

//
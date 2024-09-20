class Solution {
    public String solution(String new_id) {
        // 1 대문자 -> 소문자
        StringBuilder answer = new StringBuilder(new_id.toLowerCase());
        
        // 2 알파벳 숫자 -_. 만
        for (int i = 0; i < answer.length(); i++) {
            char ch = answer.charAt(i);
            if (!(Character.isLowerCase(ch) || Character.isDigit(ch) || ch == '-' || ch == '_' || ch == '.')) {
                answer.deleteCharAt(i);
                i--; // index -1
            }
        }
        
        // 3 .. -> .
        for (int i = 1; i < answer.length(); i++) {
            if (answer.charAt(i) == '.' && answer.charAt(i - 1) == '.') {
                answer.deleteCharAt(i);
                i--; // 두개면 하나로
            }
        }
        
        // 4 0번이나 -1이면 제거
        if (answer.length() > 0 && answer.charAt(0) == '.') {
            answer.deleteCharAt(0);
        }
        if (answer.length() > 0 && answer.charAt(answer.length() - 1) == '.') {
            answer.deleteCharAt(answer.length() - 1);
        }
        
        // 5 비어있으면 a
        if (answer.length() == 0) {
            answer.append('a');
        }
        
        // 6 length16 -> 15
        if (answer.length() >= 16) {
            answer.setLength(15);
        }
        // 마지막에 마침표 있으면 없애기
        if (answer.charAt(answer.length() - 1) == '.') {
            answer.deleteCharAt(answer.length() - 1);
        }
        
        // 7 id길이 <3이면 마지막 문자 반복 3까지
        while (answer.length() < 3) { // 3보다 작은 동안만 반복
            answer.append(answer.charAt(answer.length() - 1));
        }
        
        return answer.toString();
    }
}


// 단계별로 처리하기
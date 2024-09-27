class Solution {
    public int[] solution(String s) {
        int[] answer = {};
        int count = 0 ; // 1개수
        int zeroCount = 0; // 제거된 0개수
        while(!s.equals("1")) {
            int originLength = s.length(); // 0제거 전
            s = s.replace("0", ""); // 111111
            int renewalLength = s.length(); // 0제거 후
            
            zeroCount += (originLength - renewalLength);
            s = Integer.toBinaryString(renewalLength);
            count ++;
            
        }
        return new int[] {count, zeroCount};
    }
}

// 0제거 -> 1111 -> 4 -> 100
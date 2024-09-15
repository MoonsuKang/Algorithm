class Solution {
    public String solution(String rsp) {
        StringBuilder sb = new StringBuilder();
        for(char c: rsp.toCharArray()){
            System.out.println(c);
            if(c == '2') {
                sb.append("0");
            }
            if(c == '0') {
                sb.append("5");
            }
            if(c == '5') {
                sb.append("2");
            }
        }
        return sb.toString();
    }
}

// 가위 2
// 바위 0
// 보 5

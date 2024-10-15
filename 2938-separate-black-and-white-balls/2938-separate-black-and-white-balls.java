class Solution {
    public long minimumSteps(String s) {
        long swapCount = 0;
        long oneCount = 0;
        for (char c : s.toCharArray()) {
            if (c == '1') {
                oneCount++;  // 1을 만날 때마다 1 개수 +
            } else if (c == '0') {
                // 0을 만났을 때, 앞에 있는 1들과 스왑처리. count ++
                swapCount += oneCount;
            }
        }
        
        return swapCount;
    }
}

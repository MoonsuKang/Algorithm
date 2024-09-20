class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = {};
        
        int total = brown + yellow;
        // 가능한 세로 길이 (height)는 1부터 시작
        for(int height =1; height <= total; height++){
            // 가로 길이 (width)는 전체 격자 수를 height로 나눈 값
            if (total % height == 0) {
                int width = total / height;
                
                // 가로가 세로보다 크거나 같아야 한다는 조건
                if(width >= height) {
                    // 갈색 격자의 개수를 만족하는지 체크
                    int border = (width*2) + (height*2) -4;
                    if(border == brown) {
                       return new int[]{width, height};
                    }
                }
            }
        }
        return new int[]{};
    }
}
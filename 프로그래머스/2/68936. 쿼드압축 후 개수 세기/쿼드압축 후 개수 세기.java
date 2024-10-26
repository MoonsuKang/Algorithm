class Solution {
    private int[] answer = new int[2];

    public int[] solution(int[][] arr) {
        compressZone(arr, 0, 0, arr.length);
        return answer;
    }

    private void compressZone(int[][] arr, int x, int y, int size) {
        // 영역이 동일한 값인지 확인
        if (isSingleValue(arr, x, y, size)) {
            answer[arr[x][y]]++; // 0이면 result[0], 1이면 result[1] 증가
            return;
        }

        // 동일한 값 아니면 4개로 나눠서 재귀호출
        int newSize = size / 2;
        compressZone(arr, x, y, newSize); // 왼.위
        compressZone(arr, x, y + newSize, newSize); // 오.위
        compressZone(arr, x + newSize, y, newSize); // 왼.아
        compressZone(arr, x + newSize, y + newSize, newSize); // 오.아
    }

    private boolean isSingleValue(int[][] arr, int x, int y, int size) {
        int value = arr[x][y]; // 첫째 값을 기준
        for (int i = x; i < x + size; i++) {
            for (int j = y; j < y + size; j++) {
                if (arr[i][j] != value) 
                    return false; // 다른 값이 있으면 false
            }
        }
        return true; // 전체값이 동일하면 true
    }
}
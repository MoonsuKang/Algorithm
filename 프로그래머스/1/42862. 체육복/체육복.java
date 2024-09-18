import java.util.*;

class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        // 학생들이 체육복을 잃어버린 상황에서 여벌 체육복을 가진 학생들의 중복을 제거
        Arrays.sort(lost);
        Arrays.sort(reserve);
        
        // 체육복이 도난당한 학생과 여벌 체육복이 있는 학생의 중복을 제거
        for (int i = 0; i < lost.length; i++) {
            for (int j = 0; j < reserve.length; j++) {
                if (lost[i] == reserve[j]) {
                    lost[i] = -1;     // 잃어버린 학생에서 제거
                    reserve[j] = -1;  // 여벌 학생에서도 제거
                    break;
                }
            }
        }
        
        // 남은 lost 배열의 학생들이 체육복을 빌릴 수 있는지 확인
        int ableToAttend = n - (int) Arrays.stream(lost).filter(x -> x != -1).count();
        
        for (int l : lost) {
            if (l == -1) continue; // 이미 처리된 학생은 건너뛰어
            for (int i = 0; i < reserve.length; i++) {
                if (reserve[i] == -1) continue; // 이미 빌려준 학생은 건너뛰어
                if (reserve[i] == l - 1 || reserve[i] == l + 1) { // 앞번호 또는 뒷번호 학생이 여벌이 있으면
                    reserve[i] = -1; // 그 학생의 여벌을 빌려줌
                    ableToAttend++;
                    break;
                }
            }
        }
        
        return ableToAttend;
    }
}

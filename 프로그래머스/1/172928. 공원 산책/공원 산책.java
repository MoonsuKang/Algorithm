import java.util.*;

class Solution {
    public int[] solution(String[] park, String[] routes) {
        int h = park.length; // 공원 height
        int w = park[0].length(); // 공원 width
        int x = 0, y = 0; // 시작좌표00

        // 시작 위치 찾기
        for (int i = 0; i < h; i++) {
            if (park[i].contains("S")) { // 시작지점이 포함되어잇으면
                x = i;
                y = park[i].indexOf("S");
                break;
            }
        }

        // 방향 벡터
        Map<String, int[]> directions = Map.of(
            "N", new int[]{-1, 0}, // 북
            "S", new int[]{1, 0},  // 남
            "W", new int[]{0, -1}, // 서
            "E", new int[]{0, 1}   // 동
        );

        for (String route : routes) {
            String[] splitRoute = route.split(" ");
            String dir = splitRoute[0]; // NSWE
            int steps = Integer.parseInt(splitRoute[1]); // 이동할 칸 수

            int[] move = directions.get(dir); // 방향에 따른 이동량
            int nx = x, ny = y; // 임시 위치
            boolean valid = true;

            // 범위랑 장애물 체크
            for (int i = 0; i < steps; i++) {
                nx += move[0]; // 행 갱신
                ny += move[1]; // 열 갱신

                // 범위 외부거나 장애물이 있는 경우 판별
                if (nx < 0 || nx >= h || ny < 0 || ny >= w || park[nx].charAt(ny) == 'X') {
                    valid = false;
                    break;
                }
            }

            // 유효한 경우 update
            if (valid) {
                x = nx;
                y = ny;
            }
        }

        return new int[]{x, y};
    }
}
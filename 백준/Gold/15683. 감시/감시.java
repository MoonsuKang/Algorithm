import java.io.*;
import java.util.*;

public class Main {
    // 방향 정의 (상, 우, 하, 좌)
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    //CCTV 종류 감시 나열
    static int[][][] cctvDirections = {
            {}, // 0번
            {{0}, {1}, {2}, {3}}, // 1번: 4가지 방향
            {{0, 2}, {1, 3}}, // 2번: 상하, 좌우
            {{0, 1}, {1, 2}, {2, 3}, {3, 0}}, // 3번: 상우, 우하, 하좌, 좌상
            {{0, 1, 3}, {0, 1, 2}, {1, 2, 3}, {0, 2, 3}}, // 4번: 3가지 방향
            {{0, 1, 2, 3}} // 5번: 4가지 방향
    };

    static int N, M; // 사무실 세로, 가로 갯수
    static int[][] office; // 사무실 형태 저장 2차원 배열  office[2][3] = 1 이면  (2, 3) 위치에 1번 CCTV가 있다는 것
    static List<int[]> cctvs = new ArrayList<>(); //cctv 종류랑 위치 저장 리스트
    static int minBlindSpots = Integer.MAX_VALUE; // 찾은 사각지대 최소크기

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        office = new int[N][M];

        // 입력 처리 및 CCTV 위치 저장
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                office[i][j] = Integer.parseInt(st.nextToken());
                if (office[i][j] >= 1 && office[i][j] <= 5) {
                    cctvs.add(new int[]{i, j, office[i][j]}); // cctv위치랑 종류 저장
                }
            }
        }
        dfs(0, office);

        System.out.println(minBlindSpots);

    }

    public static void dfs(int depth, int[][] office) {
        if (depth == cctvs.size()) {
            // 모든 CCTV 배치가 완료된 경우 사각지대 계산
            minBlindSpots = Math.min(minBlindSpots, countBlindSpots(office));
            return;
        }

        int[] cctv = cctvs.get(depth);
        int x = cctv[0];
        int y = cctv[1];
        int type = cctv[2];

        // 해당 CCTV의 가능한 방향을 모두 시도
        for (int[] directions : cctvDirections[type]) {
            int[][] tempOffice = copyOffice(office); // 사무실 복사
            // 현재 방향으로 감시 영역 표시
            for (int dir : directions) {
                watchOffice(tempOffice, x, y, dir);
            }
            // 다음 CCTV로 이동
            dfs(depth + 1, tempOffice);
        }
    }

    // 사무실 복사 함수
    public static int[][] copyOffice(int[][] office) {
        int[][] newOffice = new int[N][M];
        for (int i = 0; i < N; i++) {
            System.arraycopy(office[i], 0, newOffice[i], 0, M);
        }
        return newOffice;
    }

    // CCTV가 감시하는 영역 표시 함수
    public static void watchOffice(int[][] office, int x, int y, int dir) {
        int nx = x;
        int ny = y;

        while (true) {
            nx += dx[dir];
            ny += dy[dir];

            if (nx < 0 || ny < 0 || nx >= N || ny >= M || office[nx][ny] == 6) {
                break; // 경계 또는 벽을 만나면 중단
            }
            if (office[nx][ny] == 0) {
                office[nx][ny] = -1; // 감시영역 표시
            }
        }

    }


    // 사각지대 개수 계산 함수
    public static int countBlindSpots(int[][] office) {
        int count = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (office[i][j] == 0) {
                    count++;
                }
            }
        }
        return count;

    }

}

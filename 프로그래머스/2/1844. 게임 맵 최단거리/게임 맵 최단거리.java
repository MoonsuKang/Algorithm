import java.util.*;

class Solution {
        int[] dx = {-1,1,0,0}; // 상하좌우 순서
        int[] dy = {0,0,-1,1};
    public int solution(int[][] maps) {
        int n = maps.length; // 세로
        int m = maps[0].length; // 가로
        
        //BFS 탐색을 위해서 큐를 사용해야됨
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{0, 0}); // 시작지점은 0,0 에서 시작해
        maps[0][0] = 1; // 출발 초기값 처리
        
        //BFS 시작
        while(!queue.isEmpty()) { // 큐가 안비어잇을때
            int[] current = queue.poll(); // 큐의 첫 번째 값을 반환해. 초기에는 0,0을 반환
            int x = current[0];
            int y = current[1];
            
            // 목표에 도착한다면
            if(x == n-1 && y == m-1) {
                return maps[x][y]; // 목표지점의 좌표
            }
            
            // 상하좌우로 이동을 해
            for(int i=0; i<4; i++){
                int nx = x + dx[i];
                int ny = y + dy[i];
                // 지도 범위를 벗어나지 않고, 길이 있는 곳(1)만 이동 가능
                if(nx >= 0 && ny >= 0 && nx < n && ny < m && maps[nx][ny] == 1) {
                    queue.add(new int[]{nx, ny});
                    // 이동하면서 현재까지의 경로 길이를 기록
                    maps[nx][ny] = maps[x][y] + 1;
                }
            }
        }

        
        return -1;
    }
}

// 1은 길 0은 벽
// bfs를 풀때는 상하좌우 방향을 정의해야된다.
// 
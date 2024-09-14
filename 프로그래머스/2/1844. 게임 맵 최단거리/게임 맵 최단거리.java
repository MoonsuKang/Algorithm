import java.util.*;

class Solution {
    public int solution(int[][] maps) {
        int n = maps.length; // 가로
        int m = maps[0].length; // 세로
        
        // System.out.println(n);
        // System.out.println(m);
        
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{0,0});
        
        //상하좌우 4방향
        int[] dx = {-1,1,0,0};
        int[] dy = {0,0,-1,1};
        
        // 각 반복마다 현재 위치를 큐에서 꺼내서 네 방향으로 이동할 수 있는지 확인
        while(!queue.isEmpty()){
            int[] current = queue.poll(); // 현재 위치에서 큐를 꺼내 0,0이야
            int x = current[0];
            int y = current[1];
            
            //네방향 탐색
            for(int i=0; i < 4; i++){
                int nx = x + dx[i]; // 이동할 새 좌표
                int ny = y + dy[i];
                
                // 맵 범위를 넘어가거나 벽이거나 방문한 경우 스킵해야돼
                if(nx < 0 || ny < 0 || nx >= n || ny >= m || maps[nx][ny] == 0) {
                    continue;
                }
                //처음 방문하는 노드만 기록해
                if(maps[nx][ny] == 1) {
                    //이전 칸 까지의 거리에서 +1
                    maps[nx][ny] = maps[x][y] + 1;
                    //큐에 추가해
                    queue.add(new int[]{nx, ny});
                }
            }
        }
        // 목표 지점까지의 최단 거리 반환
        // 목표 지점에 도달할 수 없는 경우 -1 반환
        return maps[n-1][m-1] > 1 ? maps[n-1][m-1] : -1;
    }
}

//최단거리 : BFS
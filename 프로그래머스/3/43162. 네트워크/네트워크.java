class Solution {
    public int solution(int n, int[][] computers) {
        boolean[] visited = new boolean[n]; // 방문여부 저장
        int nodeCount = 0;
            
        // 모든 컴퓨터 순회
        for(int i=0; i < n; i++) {
            // 아직 방문하지 않은 컴퓨터가 있으면 새로운 네트워크로 간주
            if(!visited[i]) {
                dfs(computers, visited, i);
                nodeCount++;
            }
        }
        return nodeCount;
    }
    
    private void dfs(int[][] computers, boolean[] visited, int node) {
        //현재 노드를 방문 처리해
        visited[node] = true;
        // 현재 노드에 연결된 모든 노드 탐색을 해
        for(int i=0; i < computers.length; i++){
            // 연결되어 있고 방문 안한노드 dfs
            if(computers[node][i] == 1 && !visited[i]) {
                dfs(computers, visited, i);
            }
        }
    }
}

// 방문 추적 배열 변수
// 방문여부 카운트 변수
// dfs함수 0부터 n-1까지 순회
// 
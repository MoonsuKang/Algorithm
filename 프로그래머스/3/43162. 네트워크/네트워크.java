class Solution {
    public int solution(int n, int[][] computers) {
        int answer = 0;
        boolean[] visited = new boolean[n]; // 컴퓨터 방문 여부
        int networkCount = 0; // 네트워크 개수
        
        //모든 컴퓨터를 순회해
        for(int i=0; i <n; i++){
            // 아직 방문하지 않은 컴퓨터가 있다면 새로운 네트워크로 간주하고 DFS 수행
            if(!visited[i]) {
                dfs(computers, visited, i);
                networkCount ++;
            }
        }
        
        return networkCount;
    }
    
    private void dfs(int[][] computers, boolean[] visited, int node){
        visited[node] = true; // 현재 노드 방문처리
        
        // 현재 노드에 연결된 모든 노드 탐색
        for(int i=0;i<computers.length; i++){
            // 연결되어 있지 않고 방문하지 않은 노드에 대해서 재귀적으로 dfs
            if(computers[node][i] == 1 && !visited[i]) {
                dfs(computers, visited, i);
            }
        }
    }
}
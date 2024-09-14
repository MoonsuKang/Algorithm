import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    private static List<List<Integer>> graph = new ArrayList<>();
    private static boolean[] visited;
    private static int count = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //컴퓨터수
        int n = Integer.parseInt(br.readLine());
        //노드 수
        int m = Integer.parseInt(br.readLine());

        // 그래프 초기화
        visited = new boolean[n+1]; //1부터 n까지

        for(int i =0; i <= n; i ++){
            graph.add(new ArrayList<>());
        }
        //노드정보
        for(int i =0; i< m; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            // 양방향 연결
            graph.get(u).add(v);
            graph.get(v).add(u);
        }
        // 1번 컴퓨터부터 시작하여 DFS 탐색
        dfs(1);
        // 1번 컴퓨터 제외하고 감염된 컴퓨터 수 출력
        System.out.println(count - 1);

    }

    private static void dfs(int node) {
        visited[node] = true;
        count++;

        for (int next : graph.get(node)) {
            if (!visited[next]) {
                dfs(next);
            }
        }
    }
}

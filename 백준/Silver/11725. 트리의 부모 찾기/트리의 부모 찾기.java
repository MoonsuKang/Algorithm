import java.util.*;
import java.io.*;

public class Main {
    private static List<List<Integer>> graph; // 노드의 부모노드 저장
    private static int[] parents;
    private static boolean[] visited; // 방문 여부 체크

    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine()); // 노드 개수

        //그래프 초기화
        graph = new ArrayList<>();
        for(int i=0; i<=n; i++){
            graph.add(new ArrayList<>());
        }

        //간선 정보
        for(int i=0; i < n-1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            graph.get(a).add(b); // 양뱡향 간선 추가
            graph.get(b).add(a);
        }

        // 부모 노드와 방문 배열 초기화
        parents = new int[n+1];
        visited = new boolean[n+1];
        //dfs 돌려서 부모 노드 찾아
        dfs(1);

        //2번부터 부모노드 출력처리
        StringBuilder sb = new StringBuilder();
        for(int i=2; i<=n; i++){
            sb.append(parents[i]).append('\n');
        }
        System.out.println(sb);

    }

    private static void dfs(int node) {
        visited[node] = true; // 현재 노드 방문처리

        // 현재 노드와 연결된 모든 노드를 순회
        for (int next: graph.get(node)){
            if(!visited[next]){
                parents[next] = node; //부모노드를 현재노드로
                dfs(next); // 재귀호출
            }
        }
    }

}

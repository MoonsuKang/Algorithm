import java.io.*;
import java.util.*;

public class Main {
    private static List<List<Integer>> graph; // 인접리스트
    private static boolean[] visited;

    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // input 정점개수, 노드 개수, 시작 정점 번호
        int n = Integer.parseInt(st.nextToken()); //정점개수
        int m = Integer.parseInt(st.nextToken()); //노드개수
        int v = Integer.parseInt(st.nextToken()); //시작정점번호

        //그래프 초기화
        graph = new ArrayList<>();
        for(int i=0; i <=n; i++){
            graph.add(new ArrayList<>());
        }

        //노드 정보
        for(int i=0; i <m; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph.get(a).add(b);
            graph.get(b).add(a);
        }

        //정점에 연결된 노드를 번호순으로 정렬
        for(int i=1; i <=n; i++) {
            Collections.sort(graph.get(i));
        }

        //dfs
        visited = new boolean[n+1];
        dfs(v);
        System.out.println();

        visited = new boolean[n+1];
        bfs(v);
        //bfs
    }
    private static void dfs(int v) {
        // 현재 정점 방문
        visited[v] = true;
        System.out.print(v + " "); // 방문한 정점 출력
        // 현재 정점과 연결된 정점들을 방문
        for (int i : graph.get(v)) {
            if (!visited[i]) {
                dfs(i); // 방문하지 않은 정점에 대해 재귀적으로 호출
            }
        }
    }
    private static void bfs(int start) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        visited[start] = true; // 시작 정점을 방문 처리

        while (!queue.isEmpty()) {
            int v = queue.poll(); // 큐에서 정점을 꺼내옴
            System.out.print(v + " "); // 방문한 정점 출력

            // 현재 정점과 연결된 정점들을 방문
            for (int i : graph.get(v)) {
                if (!visited[i]) {
                    queue.add(i);
                    visited[i] = true; // 방문하지 않은 정점에 대해 방문 처리
                }
            }
        }
    }

}
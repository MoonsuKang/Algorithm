import java.io.*;
import java.util.*;

public class Main {
    private static List<List<Integer>> graph; // 역방향 그래프의 인접 리스트 표현
    private static boolean[] visited; // 방문 여부를 저장할 배열

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 컴퓨터의 수 N, 신뢰 관계의 수 M
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        // 그래프 초기화 (역방향 그래프)
        graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        // 신뢰 관계 입력
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            // A가 B를 신뢰한다면 B를 해킹하면 A도 해킹할 수 있으므로, 역방향으로 저장
            graph.get(b).add(a);
        }

        // 최대 해킹 가능한 컴퓨터 수를 저장할 배열
        int[] hackableCounts = new int[n + 1];
        int maxCount = 0; // 최대 해킹 가능한 수

        // 모든 컴퓨터를 대상으로 탐색 수행
        for (int i = 1; i <= n; i++) {
            visited = new boolean[n + 1];
            int count = bfs(i); // i번 컴퓨터를 해킹했을 때 해킹 가능한 컴퓨터 수
            hackableCounts[i] = count;
            maxCount = Math.max(maxCount, count); // 최대 해킹 가능한 수 갱신
        }

        // 결과 출력: 가장 많은 컴퓨터를 해킹할 수 있는 컴퓨터 번호를 오름차순으로 출력
        StringBuilder result = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            if (hackableCounts[i] == maxCount) {
                result.append(i).append(" ");
            }
        }

        System.out.println(result.toString().trim());
    }

    // BFS를 통한 해킹 가능한 컴퓨터 수 계산
    private static int bfs(int start) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        visited[start] = true;

        int count = 0;

        while (!queue.isEmpty()) {
            int current = queue.poll();
            count++; // 해킹 가능한 컴퓨터 수 증가

            for (int next : graph.get(current)) {
                if (!visited[next]) {
                    visited[next] = true;
                    queue.add(next);
                }
            }
        }

        return count;
    }
}

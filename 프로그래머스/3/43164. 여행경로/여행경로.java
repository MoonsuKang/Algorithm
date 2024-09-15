import java.util.*;

class Solution {
    List<String> route;
    boolean[] visited;
    String[][] tickets;
    int ticketCount;
    public String[] solution(String[][] tickets) {
        this.tickets = tickets;
        ticketCount = tickets.length;
        visited = new boolean[ticketCount];
        route = new ArrayList<>();

        // 티켓 정렬
        Arrays.sort(tickets, (a, b) -> a[1].compareTo(b[1]));

        // DFS 탐색
        dfs("ICN", "ICN", 0);

        // 첫 번째 경로 반환
        return route.get(0).split(" ");
    }

    private void dfs(String current, String path, int count) {
        if (count == ticketCount) {
            route.add(path);
            return;
        }

        for (int i = 0; i < ticketCount; i++) {
            if (!visited[i] && tickets[i][0].equals(current)) {
                visited[i] = true;
                dfs(tickets[i][1], path + " " + tickets[i][1], count + 1);
                visited[i] = false;  // 백트래킹
            }
        }
    }
}

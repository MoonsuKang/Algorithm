import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        Queue<Integer> queue = new LinkedList<>();

        for (int i = 1; i <= N; i++) {
            queue.add(i); // 1,2,3,4,5,6,7
        }

        StringBuilder sb = new StringBuilder();
        sb.append("<");

        while (!queue.isEmpty()) { // 큐가 비어 있지 않을 때
            for (int i = 0; i < K - 1; i++) {  // k-1번 째 사람들을 큐의 끝으로 보내
                queue.add(queue.poll()); // 맨 앞에 있는 사람을 큐에서 제거한 후, 그 사람을 다시 큐의 끝으로 추가
            }
            sb.append(queue.poll()); // k번째 사람 제거
            if (!queue.isEmpty()) {
                sb.append(", ");
            }
        }
        sb.append(">");

        System.out.println(sb.toString());

    }
}
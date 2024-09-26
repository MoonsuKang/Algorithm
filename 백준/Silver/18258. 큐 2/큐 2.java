import java.io.*;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Deque<Integer> deque = new ArrayDeque<>();

        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String command = st.nextToken();

            switch (command) {
                case "push":
                    int value = Integer.parseInt(st.nextToken());
                    deque.add(value);
                    break;
                case "pop":
                    if (deque.isEmpty()) {
                        bw.write("-1\n");
                    } else {
                        bw.write(deque.poll() + "\n");
                    }
                    break;
                case "size":
                    bw.write(deque.size() + "\n");
                    break;
                case "empty":
                    bw.write((deque.isEmpty() ? 1 : 0) + "\n");
                    break;
                case "front":
                    if (deque.isEmpty()) {
                        bw.write("-1\n");
                    } else {
                        bw.write(deque.peek() + "\n");
                    }
                    break;
                case "back":
                    if (deque.isEmpty()) {
                        bw.write("-1\n");
                    } else {
                        bw.write(deque.peekLast() + "\n");
                    }
                    break;
            }
        }
        bw.flush();
        bw.close();
        br.close();
    }
}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] split = br.readLine().split(" ");
        int N = Integer.parseInt(split[0]);
        int K = Integer.parseInt(split[1]);

        int[] dist = new int[100001];
        for (int i = 0; i < dist.length; i++) {
            dist[i] = -1;
        }
        Queue<Integer> q = new LinkedList<>();
        q.offer(N);
        dist[N] = 0;

        while (!q.isEmpty()) {
            Integer cur = q.poll();
//            int[] dx = {cur - 1, cur + 1, 2 * cur};

//            for (int i : dx) {
//                if (i < 0 || i > 100000) continue;
//                if (dist[i] != -1) continue;
//                dist[i] = dist[cur] + 1;
//                q.offer(i);
//            }

            if (cur - 1 >= 0 && dist[cur - 1] == -1) {
                dist[cur - 1] = dist[cur] + 1;
                q.offer(cur - 1);
            }
            if (cur + 1 <= 100000 && dist[cur + 1] == -1) {
                dist[cur + 1] = dist[cur] + 1;
                q.offer(cur + 1);
            }
            if (2 * cur <= 100000 && dist[2 * cur] == -1) {
                dist[2 * cur] = dist[cur] + 1;
                q.offer(2 * cur);
            }
        }
        System.out.println(dist[K]);
    }
}

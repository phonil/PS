
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int N;
    static ArrayList<Integer>[] adj;
    static int[] dist;
    static int min = 55;
    static List<Integer> ans;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        adj = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++)
            adj[i] = new ArrayList<>();

        while (true) {
            String[] split = br.readLine().split(" ");
            int u = Integer.parseInt(split[0]);
            int v = Integer.parseInt(split[1]);
            if (u == -1 && v == -1) break;
            adj[u].add(v);
            adj[v].add(u);
        }

        for (int i = 1; i <= N; i++) {
            dist = new int[N + 1];
            Queue<Integer> q = new LinkedList<>();
            q.offer(i);
            dist[i] = 1;
            while (!q.isEmpty()) {
                Integer poll = q.poll();
                for (Integer integer : adj[poll]) {
                    if (dist[integer] != 0) continue;
                    q.offer(integer);
                    dist[integer] = dist[poll] + 1;
                }
            }
            int max = Arrays.stream(dist).max().getAsInt();
            if (min < max) continue;
            if (min > max) {
                ans = new ArrayList<>();
                min = max;
            }
            ans.add(i);
        }
        Collections.sort(ans);
        StringBuilder sb = new StringBuilder();
        sb.append(min - 1).append(" ").append(ans.size()).append('\n');
        for (Integer an : ans)
            sb.append(an).append(" ");
        System.out.print(sb);
    }
}


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

    static int N, M;
    // adj node, dist
    static ArrayList<Pair>[] adj;
    static boolean[] visit;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] split = br.readLine().split(" ");
        N = Integer.parseInt(split[0]);
        M = Integer.parseInt(split[1]);
        adj = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++)
            adj[i] = new ArrayList<>();
        for (int i = 0; i < N - 1; i++) {
            split = br.readLine().split(" ");
            int u = Integer.parseInt(split[0]);
            int v = Integer.parseInt(split[1]);
            int d = Integer.parseInt(split[2]);
            adj[u].add(new Pair(v, d));
            adj[v].add(new Pair(u, d));
        }
        for (int i = 0; i < M; i++) {
            split = br.readLine().split(" ");
            int u = Integer.parseInt(split[0]);
            int v = Integer.parseInt(split[1]);
            visit = new boolean[N + 1];
            Queue<Pair> q = new LinkedList<>();
            q.offer(new Pair(u, 0));
            visit[u] = true;
            while (!q.isEmpty()) {
                Pair poll = q.poll();
                if (poll.node == v) {
                    sb.append(poll.dist).append('\n');
                    break;
                }
                for (Pair nxt : adj[poll.node]) {
                    if (visit[nxt.node]) continue;
                    q.offer(new Pair(nxt.node, nxt.dist + poll.dist));
                    visit[poll.node] = true;
                }
            }
        }
        System.out.print(sb);
    }
    static class Pair {
        int node, dist;
        public Pair(int node, int dist) {
            this.node = node;
            this.dist = dist;
        }
    }
}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Main {

    static int V, E, K;
    static int[] D;
    static ArrayList<Node>[] adj;
    static final int INF = 99999999;

    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] split = br.readLine().split(" ");
        V = Integer.parseInt(split[0]);
        E = Integer.parseInt(split[1]);
        K = Integer.parseInt(br.readLine());
        D = new int[V + 1];
        Arrays.fill(D, INF);
        adj = new ArrayList[V + 1];
        for (int i = 1; i <= V; i++)
            adj[i] = new ArrayList<>();

        for (int i = 0; i < E; i++) {
            split = br.readLine().split(" ");
            int u = Integer.parseInt(split[0]);
            int v = Integer.parseInt(split[1]);
            int w = Integer.parseInt(split[2]);
            adj[u].add(new Node(w, v));
        }

        D[K] = 0;
        PriorityQueue<Node> pq = new PriorityQueue<>(Comparator.comparingInt((Node n) -> n.d));
        pq.offer(new Node(0, K));
        while (!pq.isEmpty()) {
            Node cur = pq.poll();
            if (D[cur.n] != cur.d) continue;
            for (Node nxt : adj[cur.n]) {
                if (D[nxt.n] > nxt.d + cur.d) {
                    D[nxt.n] = nxt.d + cur.d;
                    pq.offer(new Node(D[nxt.n], nxt.n));
                }
            }
        }

        for (int i = 1; i <= V; i++) {
            if (D[i] >= INF) sb.append("INF");
            else {
                int num = D[i];
                if (i == K) num = 0;
                sb.append(num);
            }
            sb.append('\n');
        }
        System.out.print(sb);
    }

    static class Node {
        int d, n;
        public Node(int d, int n) {
            this.d = d;
            this.n = n;
        }
    }
}


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {
    static int N;
    static ArrayList<Integer>[] adj;
    static int[] p;

    static void dfs(int cur) {
        for (Integer nxt : adj[cur]) {
            if (p[cur] == nxt) continue;
            p[nxt] = cur;
            dfs(nxt);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        adj = new ArrayList[N + 1];
        p = new int[N + 1];
        for (int i = 1; i <= N; i++)
            adj[i] = new ArrayList<>();

        for (int i = 0; i < N - 1; i++) {
            String[] split = br.readLine().split(" ");
            int u = Integer.parseInt(split[0]);
            int v = Integer.parseInt(split[1]);
            adj[u].add(v);
            adj[v].add(u);
        }

        dfs(1);
        StringBuilder sb = new StringBuilder();
        for (int i = 2; i <= N; i++)
            sb.append(p[i]).append('\n');
        System.out.print(sb);
    }
}

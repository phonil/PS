
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int N, M, V;
    static ArrayList<Integer>[] adj = new ArrayList[1005];
    static boolean[] visit;
    static StringBuilder sb = new StringBuilder();

    static void dfs(int cur) {
        visit = new boolean[1005];
        Stack<Integer> st = new Stack<>();
        st.push(cur);
        while (!st.isEmpty()) {
            Integer pop = st.pop();
            if (visit[pop]) continue;
            sb.append(pop).append(" ");
            visit[pop] = true;
            for (Integer i : adj[pop]) {
                if (visit[i]) continue;
                st.push(i);
            }
        }
    }

    static void bfs(int cur) {
        visit = new boolean[1005];
        Queue<Integer> q = new LinkedList<>();
        q.offer(cur);
        visit[cur] = true;
        while (!q.isEmpty()) {
            Integer poll = q.poll();
            sb.append(poll).append(" ");
            for (Integer i : adj[poll]) {
                if (visit[i]) continue;
                q.offer(i);
                visit[i] = true;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] split = br.readLine().split(" ");
        N = Integer.parseInt(split[0]);
        M = Integer.parseInt(split[1]);
        V = Integer.parseInt(split[2]);
        for (int i = 1; i <= N; i++)
            adj[i] = new ArrayList<>();
        for (int i = 0; i < M; i++) {
            split = br.readLine().split(" ");
            int v1 = Integer.parseInt(split[0]);
            int v2 = Integer.parseInt(split[1]);
            adj[v1].add(v2);
            adj[v2].add(v1);
        }
        // for dfs
        for (int i = 1; i <= N; i++)
            Collections.sort(adj[i], Collections.reverseOrder());
        dfs(V);
        sb.append('\n');
        // for bfs
        for (int i = 1; i <= N; i++)
            Collections.reverse(adj[i]);
        bfs(V);
        System.out.print(sb);
    }
}

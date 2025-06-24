
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Main {

    static int vertex;
    static int edge;
    static ArrayList<Integer>[] adj;
    static boolean[] visit;
    static int ans = 0;

    static void dfs(int v) {
        ans++;
        visit[v] = true;
        for (Integer i : adj[v]) {
            if (visit[i]) continue;
            dfs(i);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        vertex = Integer.parseInt(br.readLine());
        edge = Integer.parseInt(br.readLine());
        adj = new ArrayList[vertex + 1];
        visit = new boolean[vertex + 1];
        for (int i = 1; i <= vertex; i++)
            adj[i] = new ArrayList<>();
        for (int i = 0; i < edge; i++) {
            String[] split = br.readLine().split(" ");
            int u = Integer.parseInt(split[0]);
            int v = Integer.parseInt(split[1]);
            adj[u].add(v);
            adj[v].add(u);
        }

        // bfs
        Queue<Integer> q = new LinkedList<>();
        q.offer(1);
        visit[1] = true;
        while (!q.isEmpty()) {
            Integer poll = q.poll();
            for (Integer i : adj[poll]) {
                if (visit[i]) continue;
                q.offer(i);
                visit[i] = true;
                ans++;
            }
        }
        System.out.print(ans);

        // recursion dfs
//        dfs(1);
//        System.out.print(ans - 1);

        // non ordered stack dfs
//        Stack<Integer> st = new Stack<>();
//        st.push(1);
//        visit[1] = true;
//        while (!st.isEmpty()) {
//            Integer poll = st.pop();
//            for (Integer i : adj[poll]) {
//                if (visit[i]) continue;
//                st.push(i);
//                visit[i] = true;
//                ans++;
//            }
//        }
//        System.out.print(ans);

        // ordered stack dfs
//        Stack<Integer> st = new Stack<>();
//        st.push(1);
//        while (!st.isEmpty()) {
//            Integer poll = st.pop();
//            if (visit[poll]) continue;
//            visit[poll] = true;
//            ans++;
//            for (Integer i : adj[poll]) {
//                if (visit[i]) continue;
//                st.push(i);
//            }
//        }
//        System.out.print(ans - 1);
    }
}

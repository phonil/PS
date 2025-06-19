import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Main {
    static int N, M;
    static boolean[][] matrix;
    static boolean[] visit;

    static void dfs(int i) {
        visit[i] = true;
        for (int j = 1; j <= N; j++) {
            if (!matrix[i][j]) continue;
            if (visit[j]) continue;
            dfs(j);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] split = br.readLine().split(" ");
        N = Integer.parseInt(split[0]);
        M = Integer.parseInt(split[1]);
        // 1. 인접 행렬
        matrix = new boolean[N+1][N+1];
        visit = new boolean[1001];
        for (int i = 0; i < M; i++) {
            split = br.readLine().split(" ");
            int u = Integer.parseInt(split[0]);
            int v = Integer.parseInt(split[1]);
            matrix[u][v] = true;
            matrix[v][u] = true;
        }
        int ans = 0;
//        // bfs
//        Queue<Integer> q = new LinkedList<>();
//        for (int i = 1; i <= N; i++) {
//            if (visit[i]) continue;
//            q.offer(i);
//            visit[i] = true;
//            ans++;
//            while (!q.isEmpty()) {
//                Integer poll = q.poll();
//                for (int j = 1; j <= N; j++) {
//                    if (!matrix[poll][j]) continue;
//                    if (visit[j]) continue;
//                    q.offer(j);
//                    visit[j] = true;
//                }
//            }
//        }

//        // 비재귀 dfs
//        Stack<Integer> st = new Stack<>();
//        for (int i = 1; i <= N; i++) {
//            if (visit[i]) continue;
//            st.push(i);
//            visit[i] = true;
//            ans++;
//            while (!st.isEmpty()) {
//                Integer pop = st.pop();
//                for (int j = 1; j <= N; j++) {
//                    if (!matrix[pop][j]) continue;
//                    if (visit[j]) continue;
//                    st.push(j);
//                    visit[j] = true;
//                }
//            }
//        }

//        // 순서 고려 비재귀 dfs
//        Stack<Integer> st = new Stack<>();
//        for (int i = 1; i <= N; i++) {
//            if (visit[i]) continue;
//            st.push(i);
//            ans++;
//            while (!st.isEmpty()) {
//                Integer pop = st.pop();
//                if (visit[pop]) continue;
//                visit[pop] = true;
//                for (int j = 1; j <= N; j++) {
//                    if (!matrix[pop][j]) continue;
//                    if (visit[j]) continue;
//                    st.push(j);
//                }
//            }
//        }

        // 재귀 dfs
        for (int i = 1; i <= N; i++) {
            if (visit[i]) continue;
            dfs(i);
            ans++;
        }

        System.out.print(ans);
    }
}

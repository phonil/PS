import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {

    static int N, R, Q;
    static ArrayList<Integer>[] adj;
    static boolean[] visit;
    static int[] size;

    static int recursion(int cur) {
        visit[cur] = true;
        for (Integer nxt : adj[cur]) {
            if (visit[nxt]) continue;
            size[cur] += recursion(nxt);
        }
        return ++size[cur];
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] split = br.readLine().split(" ");
        N = Integer.parseInt(split[0]);
        R = Integer.parseInt(split[1]);
        Q = Integer.parseInt(split[2]);
        adj = new ArrayList[N + 1];
        size = new int[N + 1];
        visit = new boolean[N + 1];
        for (int i = 1; i <= N; i++)
            adj[i] = new ArrayList<>();

        for (int i = 0; i < N - 1; i++) {
            split = br.readLine().split(" ");
            int u = Integer.parseInt(split[0]);
            int v = Integer.parseInt(split[1]);
            adj[u].add(v);
            adj[v].add(u);
        }
        recursion(R);
        // 쿼리 처리하기
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < Q; i++) {
            int q = Integer.parseInt(br.readLine());
            sb.append(size[q]).append('\n');
        }
        System.out.print(sb);
    }
}

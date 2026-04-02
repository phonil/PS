import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int T, K, M, P;
    static int[] indegree;
    static ArrayList<Integer>[] adj;
    static ArrayList<Integer>[] indes;
    static int[] strahler;

    static void topological_sort() {
        Queue<Integer> q = new LinkedList<>();
        for (int i = 1; i <= M; i++) {
            if (indegree[i] != 0) continue;
            strahler[i] = 1;
            q.offer(i);
        }

        while (!q.isEmpty()) {
            Integer cur = q.poll();
            calc_strahler(cur);
            for (Integer nxt : adj[cur]) {
                indegree[nxt]--;
                if (indegree[nxt] == 0)
                    q.offer(nxt);
            }
        }
    }

    static void calc_strahler(int cur) {
        ArrayList<Integer> list = indes[cur];
        if (list.isEmpty()) return;

        int cnt = 0;
        int max = 0;
        for (Integer inds : list) {
            int i = strahler[inds];
            if (i > max) {
                cnt = 1;
                max = i;
            } else if (i == max) {
                cnt++;
            }
        }

        if (cnt >= 2)
            strahler[cur] = max + 1;
        else if (cnt == 1)
            strahler[cur] = max;
    }

    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());
        while (T --> 0) {
            String[] split = br.readLine().split(" ");
            K = Integer.parseInt(split[0]);
            M = Integer.parseInt(split[1]);
            P = Integer.parseInt(split[2]);

            strahler = new int[M + 1];

            indegree = new int[M + 1];
            adj = new ArrayList[M + 1];
            for (int i = 1; i <= M; i++)
                adj[i] = new ArrayList<>();

            indes= new ArrayList[M + 1];
            for (int i = 1; i <= M; i++)
                indes[i] = new ArrayList<>();

            for (int i = 0; i < P; i++) {
                split = br.readLine().split(" ");
                int A = Integer.parseInt(split[0]);
                int B = Integer.parseInt(split[1]);

                indegree[B]++;
                adj[A].add(B);
                indes[B].add(A);

            }

            topological_sort();
            sb.append(K).append(" ").append(strahler[M]).append('\n');
        }
        System.out.print(sb);
    }
}

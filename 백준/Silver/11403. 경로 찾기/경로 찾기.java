
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int N;
    static int[][] matrix;
    static boolean[] visit;
    static int[][] ans;

    static void dfs(int row, int vertex) {
        visit[vertex] = true;
        for (int i = 1; i <= N; i++) {
            if (matrix[vertex][i] == 0) continue;
            ans[row][i] = 1;
            if (visit[i]) continue;
            dfs(row, i);
        }
    }

    // Todo
    //      Idea : DFS per one line
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        matrix = new int[N + 1][N + 1];
        ans = new int[N + 1][N + 1];
        for (int i = 0; i < N; i++) {
            String[] split = br.readLine().split(" ");
            for (int j = 0; j < N; j++)
                matrix[i+1][j+1] = Integer.parseInt(split[j]);
        }
        for (int i = 1; i <= N; i++) {
            visit = new boolean[N + 1];
            dfs(i, i);
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++)
                sb.append(ans[i][j]).append(" ");
            sb.append('\n');
        }
        System.out.print(sb);
    }
}

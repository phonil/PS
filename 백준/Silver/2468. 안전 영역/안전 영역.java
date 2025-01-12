import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] board = new int[N][N];
        int max = 0;
        for (int i = 0; i < N; i++) {
            String[] split = br.readLine().split(" ");
            for (int j = 0; j < N; j++) {
                board[i][j] = Integer.parseInt(split[j]);
                if (max < board[i][j]) max = board[i][j];
            }
        }
        int ans = 0;
        for (int i = 0; i < max; i++) {
            int cnt = 0;
            boolean[][] visit = new boolean[N][N];
            Queue<Pair> q = new LinkedList<>();
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < N; k++) {
                    if (visit[j][k]) continue;
                    if (board[j][k] <= i) continue;
                    q.offer(new Pair(j, k));
                    visit[j][k] = true;
                    cnt++;
                    while (!q.isEmpty()) {
                        Pair cur = q.poll();
                        for (int l = 0; l < 4; l++) {
                            int nx = cur.x + dx[l];
                            int ny = cur.y + dy[l];
                            if (nx < 0 || ny < 0 || nx >= N || ny >= N) continue;
                            if (visit[nx][ny] || board[nx][ny] <= i) continue;
                            q.offer(new Pair(nx, ny));
                            visit[nx][ny] = true;
                        }
                    }
                    if (ans < cnt) ans = cnt;
                }
            }
        }
        System.out.print(ans);
    }
    static class Pair {
        int x, y;
        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}

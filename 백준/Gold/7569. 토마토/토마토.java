
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(st.nextToken()); // 가로
        int N = Integer.parseInt(st.nextToken()); // 세로
        int H = Integer.parseInt(st.nextToken()); // 높이

        int[] dx = {-1, 0, 1, 0, 0, 0};
        int[] dy = {0, -1, 0, 1, 0, 0};
        int[] dz = {0, 0, 0, 0, -1, 1};

        int[][][] board = new int[N][M][H];
        int[][][] days = new int[N][M][H];
        Queue<Pair> q = new LinkedList<>();
        for (int i = 0; i < H; i++) {
            for (int j = 0; j < N; j++) {
                st = new StringTokenizer(br.readLine());
                for (int k = 0; k < M; k++) {
                    int a = Integer.parseInt(st.nextToken());
                    board[j][k][i] = a;
                    if (a == 0) days[j][k][i] = -1;
                    if (a == 1) q.offer(new Pair(j, k, i));
                }
            }
        }

        while (!q.isEmpty()) {
            Pair cur = q.poll();
            for (int i = 0; i < 6; i++) {
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];
                int nz = cur.z + dz[i];
                if (nx < 0 || ny < 0 || nz < 0 || nx >= N || ny >= M || nz >= H) continue;
                if (days[nx][ny][nz] != -1) continue;
                q.offer(new Pair(nx, ny, nz));
                days[nx][ny][nz] = days[cur.x][cur.y][cur.z] + 1;
            }
        }
        int ans = 0;
        all:
        for (int k = 0; k < H; k++) {
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (days[i][j][k] == -1) {
                        ans = -1;
                        break all;
                    }
                    if (ans < days[i][j][k])
                        ans = days[i][j][k];
                }
            }
        }
        System.out.println(ans);
    }

    static class Pair {
        int x, y, z;
        public Pair(int x, int y, int z) {
            this.x = x;
            this.y = y;
            this.z = z;
        }
    }
}


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

    static int N, M;
    static int[][] map;
    static int[][][] dist;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    static boolean bound(int nx, int ny) {
        return nx < 0 || ny < 0 || nx >= N || ny >= M;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] split = br.readLine().split(" ");
        N = Integer.parseInt(split[0]);
        M = Integer.parseInt(split[1]);
        map = new int[N][M];
        dist = new int[N][M][2];
        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < M; j++)
                map[i][j] = line.charAt(j) - '0';
        }
        Queue<Pair> q = new LinkedList<>();
        q.offer(new Pair(0, 0, 0));
        dist[0][0][0] = 1;
        while (!q.isEmpty()) {
            Pair cur = q.poll();
            for (int i = 0; i < 4; i++) {
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];
                if (bound(nx, ny)) continue;
                if (map[nx][ny] == 1) {
                    if (cur.z == 1)
                        continue;
                    if (dist[nx][ny][cur.z + 1] != 0)
                        continue;
                    q.offer(new Pair(nx, ny, cur.z + 1));
                    dist[nx][ny][cur.z + 1] = dist[cur.x][cur.y][cur.z] + 1;
                }
                else {
                    if (dist[nx][ny][cur.z] != 0)
                        continue;
                    q.offer(new Pair(nx, ny, cur.z));
                    dist[nx][ny][cur.z] = dist[cur.x][cur.y][cur.z] + 1;
                }
            }
        }
        int zero = dist[N-1][M-1][0];
        int one = dist[N-1][M-1][1];
        int ans = -1;
        if (zero != 0 && one != 0)
            ans = Math.min(zero, one);
        else if (zero != 0 || one != 0)
            ans = Math.max(zero, one);
        System.out.println(ans);
    }

    static class Pair {
        int x,y,z;
        public Pair(int x, int y, int z) {
            this.x = x;
            this.y = y;
            this.z = z;
        }
    }
}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    static int N, M;
    static char[][] map;
    static boolean[][] visit;
    static Queue<Pair> q;
    static int answer = 0;

    static boolean bound(int nx, int ny) {
        return nx < 0 || ny < 0 || nx >= N || ny >= M;
    }

    static void bfs(int r, int c) {
        visit = new boolean[N][M];
        q = new LinkedList<>();
        visit[r][c] = true;
        q.offer(new Pair(r, c, 0));
        while (!q.isEmpty()) {
            Pair cur = q.poll();
            answer = Math.max(answer, cur.dist);
            for (int k = 0; k < 4; k++) {
                int nx = cur.x + dx[k];
                int ny = cur.y + dy[k];
                if (bound(nx, ny)) continue;
                if (map[nx][ny] == 'W') continue;
                if (visit[nx][ny]) continue;
                visit[nx][ny] = true;
                q.offer(new Pair(nx, ny, cur.dist + 1));
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] split = br.readLine().split(" ");
        N = Integer.parseInt(split[0]);
        M = Integer.parseInt(split[1]);
        map = new char[N][M];
        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < M; j++)
                map[i][j] = line.charAt(j);
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 'W') continue;
                bfs(i, j);
            }
        }
        System.out.print(answer);
    }

    static class Pair {
        int x, y, dist;
        public Pair(int x, int y, int dist) {
            this.x = x;
            this.y = y;
            this.dist = dist;
        }
    }
}

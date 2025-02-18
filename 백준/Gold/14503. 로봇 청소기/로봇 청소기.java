
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

    static int N, M, R, C, dir;
    static int[][] room;
    static boolean[][] visit;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int cnt = 0;

    static boolean bound(int nx, int ny) {
        return nx < 0 || ny < 0 || nx >= N || ny >= M;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] split = br.readLine().split(" ");
        N = Integer.parseInt(split[0]);
        M = Integer.parseInt(split[1]);
        split = br.readLine().split(" ");
        R = Integer.parseInt(split[0]);
        C = Integer.parseInt(split[1]);
        dir = Integer.parseInt(split[2]);
        room = new int[N][M];
        visit = new boolean[N][M];

        // Description : Input
        for (int i = 0; i < N; i++) {
            split = br.readLine().split(" ");
            for (int j = 0; j < M; j++) {
                room[i][j] = Integer.parseInt(split[j]);
                if (room[i][j] == 1) visit[i][j] = true;
            }
        }

        Queue<Pair> q = new LinkedList<>();
        q.offer(new Pair(R, C, dir));
        while (!q.isEmpty()) {
            Pair cur = q.poll();
            if (!visit[cur.x][cur.y]) {
                visit[cur.x][cur.y] = true;
                cnt++;
            }
            boolean flag = false;
            for (int i = 0; i < 4; i++) {
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];
                if (bound(nx, ny)) continue;
                if (!visit[nx][ny]) {
                    flag = true;
                    break;
                }
            }
            if (!flag) {
                int nx = cur.x + dx[(cur.dir + 2) % 4];
                int ny = cur.y + dy[(cur.dir + 2) % 4];
                if (bound(nx, ny) || room[nx][ny] == 1) break;
                q.offer(new Pair(nx, ny, cur.dir));
            } else {
                for (int i = 0; i < 4; i++) {
                    if (cur.dir == 0) cur.dir = 3;
                    else cur.dir -= 1;
                    int nx = cur.x + dx[cur.dir];
                    int ny = cur.y + dy[cur.dir];
                    if (bound(nx, ny) || visit[nx][ny]) continue;
                    q.offer(new Pair(nx, ny, cur.dir));
                    break;
                }
            }
        }
        System.out.print(cnt);
    }

    static class Pair {
        int x, y, dir;
        public Pair(int x, int y, int dir) {
            this.x = x;
            this.y = y;
            this.dir = dir;
        }
    }
}

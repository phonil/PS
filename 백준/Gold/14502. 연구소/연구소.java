
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

    static int N, M;
    static int[][] map;
    static boolean[][] visited; // 바이러스 전파 용도
    static int[][] tmpMap;
    static int[] arr; // 백트래킹 total Conbine 3 용도
    static boolean[] isUsed; // n x m 1차원 배열 -> 백트래킹에서 사용, 0 용도
    static int ans = 0;
    static int total;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    static boolean bound(int nx, int ny) {
        return nx < 0 || ny  < 0 || nx >= N || ny >= M;
    }

    static void func(int cur, int startIdx) {
        if (cur == 3) {
            createWall();
            virusPropagation();
            countVirus();
            return;
        }
        for (int i = startIdx; i < total; i++) {
            if (isUsed[i]) continue;
            arr[cur] = i;
            isUsed[i] = true;
            func(cur + 1, i + 1);
            isUsed[i] = false;
        }
    }

    static void createWall() {
        tmpMap = new int[N][M];
        for (int i = 0; i < N; i++)
            for (int j = 0; j < M; j++)
                tmpMap[i][j] = map[i][j];

        for (int i = 0; i < 3; i++) {
            int r = arr[i] / M;
            int c = arr[i] % M;
            tmpMap[r][c] = 1;
        }
    }

    static void virusPropagation() {
        visited = new boolean[N][M];
        Queue<Pair> q = new LinkedList<>();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (tmpMap[i][j] == 0 || tmpMap[i][j] == 1) continue;
                q.offer(new Pair(i, j));
                visited[i][j] = true;
                while (!q.isEmpty()) {
                    Pair cur = q.poll();
                    for (int k = 0; k < 4; k++) {
                        int nx = cur.x + dx[k];
                        int ny = cur.y + dy[k];
                        if (bound(nx, ny)) continue;
                        if (visited[nx][ny]) continue;
                        if (tmpMap[nx][ny] == 1 || tmpMap[nx][ny] == 2) continue;
                        q.offer(new Pair(nx, ny));
                        visited[nx][ny] = true;
                        tmpMap[nx][ny] = 2;
                    }
                }
            }
        }
    }

    static void countVirus() {
        int max = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (tmpMap[i][j] == 0) max++;
            }
        }
        ans = Math.max(ans, max);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] split = br.readLine().split(" ");
        N = Integer.parseInt(split[0]);
        M = Integer.parseInt(split[1]);
        map = new int[N][M];
        total = N * M;
        arr = new int[3];
        isUsed = new boolean[total];
        // Input
        for (int i = 0; i < N; i++) {
            split = br.readLine().split(" ");
            for (int j = 0; j < M; j++) {
                int num = Integer.parseInt(split[j]);
                map[i][j] = num;
                if (num == 1) isUsed[M*i + j] = true;
                if (num == 2) isUsed[M*i + j] = true;
            }
        }

        // back tracking : nxm combine 3
        func(0, 0);
        System.out.print(ans);
    }
    static class Pair {
        int x, y;
        Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}

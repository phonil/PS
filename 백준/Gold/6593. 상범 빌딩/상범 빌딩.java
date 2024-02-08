
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] dx = {-1, 1, 0, 0, 0, 0};
        int[] dy = {0, 0, -1, 1, 0, 0};
        int[] dz = {0, 0, 0, 0, -1, 1};

        while (true) {
            int L = sc.nextInt(); // 층
            int R = sc.nextInt(); // 행
            int C = sc.nextInt(); // 열
            sc.nextLine();
            if (L == 0 && R == 0 && C == 0)
                break;
            char[][][] map = new char[R][C][L];
            int[][][] dist = new int[R][C][L];
            for (int i = 0; i < R; i++) {
                for (int j = 0; j < C; j++) {
                    Arrays.fill(dist[i][j], -1);
                }
            }
            // map 채우기
            int l = L;
            Queue<Pair> queue = new LinkedList<>();
            while (l-- > 0) {
                for (int i = 0; i < R; i++) {
                    String s = sc.nextLine();
                    for (int j = 0; j < C; j++) {
                        char a = s.charAt(j);
                        map[i][j][l] = a;
                        if (a == 'S') {
                            queue.offer(new Pair(i, j, l));
                            dist[i][j][l] = 0;
                        }
                    }
                }
                sc.nextLine();
            }
            int minute = 0;
            // BFS
            while (!queue.isEmpty()) {
                Pair now = queue.poll();
                if (map[now.x][now.y][now.z] == 'E') {
                    minute = dist[now.x][now.y][now.z];
                    break;
                }
                for (int i = 0; i < 6; i++) {
                    int nx = now.x + dx[i];
                    int ny = now.y + dy[i];
                    int nz = now.z + dz[i];

                    if (nx < 0 || ny < 0 || nz < 0 || nx >= R || ny >= C || nz >= L)
                        continue;
                    if (dist[nx][ny][nz] != -1)
                        continue;
                    if (map[nx][ny][nz] == '#')
                        continue;

                    queue.offer(new Pair(nx, ny, nz));
                    dist[nx][ny][nz] = dist[now.x][now.y][now.z] + 1;

                }
            }

            if (minute == 0)
                System.out.println("Trapped!");
            else
                System.out.println("Escaped in " + minute + " minute(s).");

        }

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

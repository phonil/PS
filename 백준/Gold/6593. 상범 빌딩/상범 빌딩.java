
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

    static int L, R, C;
    static char[][][] board;
    static int[][][] dist;
    static int[] dx = {-1, 0, 1, 0, 0, 0};
    static int[] dy = {0, 1, 0, -1, 0, 0};
    static int[] dz = {0, 0, 0, 0, -1, 1};

    public static boolean bound(int x, int y, int z) {
        return x < 0 || y < 0 || z < 0 || x >= R || y >= C || z >= L;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            String[] split = br.readLine().split(" ");
            L = Integer.parseInt(split[0]);
            R = Integer.parseInt(split[1]);
            C = Integer.parseInt(split[2]);
            if (L == 0 && R == 0 && C == 0)
                break;
            // init
            board = new char[R][C][L];
            dist = new int[R][C][L];
            Queue<Pair> q = new LinkedList<>();
            for (int i = 0; i < L; i++) {
                for (int j = 0; j < R; j++) {
                    String line = br.readLine();
                    for (int k = 0; k < C; k++) {
                        char c = line.charAt(k);
                        board[j][k][i] = c;
                        if (c == '.') dist[j][k][i] = -1;
                        if (c == 'S') q.offer(new Pair(j, k, i));
                    }
                }
                br.readLine();
            }
            // BFS
            while (!q.isEmpty()) {
                Pair cur = q.poll();
                for (int i = 0; i < 6; i++) {
                    int nx = cur.x + dx[i];
                    int ny = cur.y + dy[i];
                    int nz = cur.z + dz[i];
                    if (bound(nx, ny, nz) || board[nx][ny][nz] == '#') continue;
                    if (board[nx][ny][nz] != 'E' && dist[nx][ny][nz] != -1) continue;
                    q.offer(new Pair(nx, ny, nz));
                    dist[nx][ny][nz] = dist[cur.x][cur.y][cur.z] + 1;
                }
            }
            Pair exit = null;
            for (int i = 0; i < L; i++)
                for (int j = 0; j < R; j++)
                    for (int k = 0; k < C; k++)
                        if (board[j][k][i] == 'E') exit = new Pair(j, k, i);
            if (dist[exit.x][exit.y][exit.z] != 0)
                System.out.println("Escaped in " + dist[exit.x][exit.y][exit.z] + " minute(s).");
            else
                System.out.println("Trapped!");
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

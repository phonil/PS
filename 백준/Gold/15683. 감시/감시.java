
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static int N, M;
    public static int[][] board1, board2;
    public static int[] dx = {1, 0, -1, 0};
    public static int[] dy = {0, 1, 0, -1};
    public static List<Pair> cctv = new ArrayList<>();

    public static boolean isWall(int x, int y) {
        return x < 0 || y < 0 || x >= N || y >= M;
    }

    public static void dirCheck(int x, int y, int dir) {
        dir %= 4;
        while (true) {
            x += dx[dir];
            y += dy[dir];
            if (isWall(x, y) || board2[x][y] == 6) return;
            if (board2[x][y] != 0) continue;
            board2[x][y] = 7;
        }

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] split = br.readLine().split(" ");
        N = Integer.parseInt(split[0]);
        M = Integer.parseInt(split[1]);
        board1 = new int[N][M];
        board2 = new int[N][M];
        for (int i = 0; i < N; i++) {
            Arrays.fill(board1[i], 0);
            Arrays.fill(board2[i], 0);
        }
        int mn = 0;
        for (int i = 0; i < N; i++) {
            String[] line = br.readLine().split(" ");
            for (int j = 0; j < M; j++) {
                board1[i][j] = Integer.parseInt(line[j]);
                if (board1[i][j] != 0 && board1[i][j] != 6)
                    cctv.add(new Pair(i, j));
                if (board1[i][j] == 0)
                    mn++;
            }
        }
        for (int tmp = 0; tmp < 1 << (2 * cctv.size()); tmp++) {
            for (int i = 0; i < N; i++)
                for (int j = 0; j < M; j++)
                    board2[i][j] = board1[i][j];
            int brute = tmp;
            for (int i = 0; i < cctv.size(); i++) {
                int dir = brute % 4;
                brute /= 4;
                int x = cctv.get(i).x;
                int y = cctv.get(i).y;
                if (board1[x][y] == 1)
                    dirCheck(x, y, dir);
                else if (board1[x][y] == 2) {
                    dirCheck(x, y, dir);
                    dirCheck(x, y, dir + 2);
                } else if (board1[x][y] == 3) {
                    dirCheck(x, y, dir);
                    dirCheck(x, y, dir + 1);
                } else if (board1[x][y] == 4) {
                    dirCheck(x, y, dir);
                    dirCheck(x, y, dir + 1);
                    dirCheck(x, y, dir + 2);
                } else {
                    dirCheck(x, y, dir);
                    dirCheck(x, y, dir + 1);
                    dirCheck(x, y, dir + 2);
                    dirCheck(x, y, dir + 3);
                }
            }
            int val = 0;
            for (int i = 0; i < N; i++)
                for (int j = 0; j < M; j++)
                    if (board2[i][j] == 0) val++;
            mn = Math.min(val, mn);
        }
        System.out.print(mn);
    }
}

class Pair {
    int x, y;

    public Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }
}


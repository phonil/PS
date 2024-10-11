
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static int N;
    public static int[][] board1, board2;

    public static void rotate() {
        int[][] tmp = new int[N][N];
        for (int i = 0; i < N; i++)
            for (int j = 0; j < N; j++)
                tmp[i][j] = board2[i][j];

        for (int i = 0; i < N; i++)
            for (int j = 0; j < N; j++)
                board2[i][j] = tmp[N-1-j][i];
    }

    public static void tilt(int dir) {
        while (dir --> 0) rotate();
        for (int i = 0; i < N; i++) {
            int[] line = new int[N];
            int[] tmp = new int[N];
            boolean[] flag = new boolean[N];
            int idx = 0;
            for (int j = 0; j < N; j++)
                line[j] = board2[i][j];
            for (int j = 0; j < N; j++) {
                if (line[j] == 0) continue;
                if (tmp[idx] == 0)
                    tmp[idx] = line[j];
                else if (tmp[idx] == line[j] && !flag[j])
                    tmp[idx++] *= 2;
                else tmp[++idx] = line[j];
            }
            for (int j = 0; j < N; j++) {
                board2[i][j] = tmp[j];
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        board1 = new int[N][N];
        board2 = new int[N][N];
        int max = 0;
        for (int i = 0; i < N; i++) {
            String[] split = br.readLine().split(" ");
            for (int j = 0; j < N; j++) {
                board1[i][j] = Integer.parseInt(split[j]);
            }
        }

        for (int tmp = 0; tmp < 1024; tmp++) {
            for (int i = 0; i < N; i++)
                for (int j = 0; j < N; j++)
                    board2[i][j] = board1[i][j];

            int brute = tmp;
            for (int i = 0; i < 5; i++) {
                int dir = brute % 4;
                brute /= 4;
                tilt(dir);
            }
            int val = 0;
            for (int i = 0; i < N; i++)
                for (int j = 0; j < N; j++)
                    if (val < board2[i][j])
                        val = board2[i][j];
            max = Math.max(max, val);
        }
        System.out.print(max);

    }
}

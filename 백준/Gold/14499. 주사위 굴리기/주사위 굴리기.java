
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main{

    static int N, M, X, Y, K;
    static int[] dice = new int[7];
    static int[][] map;
    static int[] oper;

    static void rotate(int dir) {
        if (dir == 1) {
            int tmp = dice[2];
            dice[2] = dice[5];
            dice[5] = dice[4];
            dice[4] = dice[6];
            dice[6] = tmp;
        } else if (dir == 2) {
            int tmp = dice[6];
            dice[6] = dice[4];
            dice[4] = dice[5];
            dice[5] = dice[2];
            dice[2] = tmp;
        } else if (dir == 3) {
            int tmp = dice[1];
            dice[1] = dice[2];
            dice[2] = dice[3];
            dice[3] = dice[4];
            dice[4] = tmp;
        } else {
            int tmp = dice[4];
            dice[4] = dice[3];
            dice[3] = dice[2];
            dice[2] = dice[1];
            dice[1] = tmp;
        }
    }

    static void copy() {
        if (map[X][Y] == 0) {
            map[X][Y] = dice[4];
        } else {
            dice[4] = map[X][Y];
            map[X][Y] = 0;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] split = br.readLine().split(" ");
        N = Integer.parseInt(split[0]);
        M = Integer.parseInt(split[1]);
        map = new int[N][M];

        for (int i = 0; i < N; i++) {
            String[] line = br.readLine().split(" ");
            for (int j = 0; j < M; j++)
                map[i][j] = Integer.parseInt(line[j]);
        }
        X = Integer.parseInt(split[2]);
        Y = Integer.parseInt(split[3]);
        K = Integer.parseInt(split[4]);
        oper = new int[K];
        split = br.readLine().split(" ");
        for (int i = 0; i < K; i++)
            oper[i] = Integer.parseInt(split[i]);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < K; i++) {
            int dir = oper[i];
            if (dir == 1) {
                if (Y == M - 1) continue;
                Y++;
            }
            if (dir == 2) {
                 if (Y == 0) continue;
                 Y--;
            }
            if (dir == 3) {
                 if (X == 0) continue;
                 X--;
            }
            if (dir == 4) {
                 if (X == N - 1) continue;
                 X++;
            }
            rotate(dir);
            // 칠하기
            copy();
            sb.append(dice[2]).append('\n');
        }
        System.out.print(sb);
    }
}


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int[][] gear = new int[4][8];
    static int[] dirs = new int[4];

    static void check(int gearNum, int dir) { // 각 톱니바퀴 방향 결정
        for (int i = gearNum + 1; i < 4; i++) {
            if (gear[i-1][2] != gear[i][6])
                dirs[i] = (-1) * dirs[i-1];
            else
                dirs[i] = 0;
        }
        for (int i = gearNum - 1; i >= 0; i--) {
            if (gear[i+1][6] != gear[i][2])
                dirs[i] = (-1) * dirs[i+1];
            else
                dirs[i] = 0;
        }
    }

    static void rotate() { // 모든 톱니바퀴 회전
        for (int i = 0; i < 4; i++) {
            int dir = dirs[i];
            if (dir == 1) {
                int tmp = gear[i][7];
                for (int j = 7; j > 0; j--) {
                    gear[i][j] = gear[i][j - 1];
                }
                gear[i][0] = tmp;
            }
            else if (dir == -1) {
                int tmp = gear[i][0];
                for (int j = 0; j < 7; j++) {
                    gear[i][j] = gear[i][j + 1];
                }
                gear[i][7] = tmp;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < 4; i++) {
            String line = br.readLine();
            for (int j = 0; j < 8; j++) {
                gear[i][j] = line.charAt(j) - '0';
            }
        }
        int K = Integer.parseInt(br.readLine());
        for (int i = 0; i < K; i++) {
            String[] split = br.readLine().split(" ");
            int gearNum = Integer.parseInt(split[0]) - 1;
            int dir = Integer.parseInt(split[1]);
            dirs[gearNum] = dir;
            check(gearNum, dir);
            rotate();
        }
        int sum = 0;
        for (int i = 0; i < 4; i++) {
            if (gear[i][0] == 1)
                sum += 1 << i;
        }
        System.out.print(sum);
    }
}

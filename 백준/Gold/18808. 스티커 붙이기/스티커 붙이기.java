
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static int N, M, K;
    public static List<int[][]> stickerList = new ArrayList<>();
    public static int[][] board;

    public static boolean pastable(int x, int y, int[][] sticker) { // start (x, y) & sticker
        // === Check and Paste
        // Check
        for (int i = 0; i < sticker.length; i++)
            for (int j = 0; j < sticker[0].length; j++)
                if (board[x + i][y + j] == 1 && sticker[i][j] == 1)
                    return false;

        // Paste
        for (int i = 0; i < sticker.length; i++)
            for (int j = 0; j < sticker[0].length; j++)
                if (sticker[i][j] == 1)
                    board[x + i][y + j] = 1;
        return true;
    }

    public static int[][] rotate(int[][] sticker) {
        int[][] tmp = sticker;
        int r = sticker.length;
        int c = sticker[0].length;
        sticker = new int[c][r];
        for (int i = 0; i < c; i++) {
            for (int j = 0; j < r; j++)
                sticker[i][j] = tmp[r - 1 - j][i];
        }
        return sticker;
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // === User Input ===
        String[] split = br.readLine().split(" ");
        N = Integer.parseInt(split[0]);
        M = Integer.parseInt(split[1]);
        board = new int[N][M];
        for (int i = 0; i < N; i++)
            Arrays.fill(board[i], 0);

        K = Integer.parseInt(split[2]);
        for (int i = 0; i < K; i++) {
            String[] input = br.readLine().split(" ");
            int R = Integer.parseInt(input[0]);
            int C = Integer.parseInt(input[1]);
            int[][] sticker = new int[R][C];
            for (int j = 0; j < R; j++) {
                String[] line = br.readLine().split(" ");
                for (int k = 0; k < C; k++)
                    sticker[j][k] = Integer.parseInt(line[k]);
            }
            stickerList.add(sticker);
        }
        // === User Input ===
        for (int[][] sticker : stickerList) {
            for (int i = 0; i < 4; i++) {
                boolean flag = false;
                for (int x = 0; x <= N - sticker.length; x++) {
                    if (flag) break;
                    for (int y = 0; y <= M - sticker[0].length; y++) {
                        if (pastable(x, y, sticker)) {
                            flag = true;
                            break;
                        }
                    }
                }
                if (flag)
                    break;
                sticker = rotate(sticker);
            }
        }
        int val = 0;
        for (int i = 0; i < N; i++)
            for (int j = 0; j < M; j++)
                // 아래 두 연산은 동일. 0은 더해도 같기 때문. (if 연산을 줄일 수 있음)
//                if (board[i][j] == 1) val++;
                val += board[i][j];
        System.out.print(val);
    }
}


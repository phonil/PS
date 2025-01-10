
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int[][] board;
    static int white = 0;
    static int blue = 0;

    public static void func(int r, int c, int n) {
        if (check(r, c, n)) {
            int startNum = board[r][c];
            if (startNum == 0) white++;
            else blue++;
            return;
        }
        int bound = n / 2;
        func(r, c, bound);
        func(r, c + bound, bound);
        func(r + bound, c, bound);
        func(r + bound, c + bound, bound);
    }

    public static boolean check(int r, int c, int n) {
        if (n == 1) {
            return true;
        }
        for (int i = r; i < r + n; i++) {
            for (int j = c; j < c + n; j++) {
                if (board[r][c] != board[i][j]) return false;
            }
        }
        return true;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        board = new int[N][N];
        for (int i = 0; i < N; i++) {
            String[] split = br.readLine().split(" ");
            for (int j = 0; j < N; j++) {
                board[i][j] = Integer.parseInt(split[j]);
            }
        }
        func(0, 0, N);
        System.out.println(white);
        System.out.println(blue);
    }
}

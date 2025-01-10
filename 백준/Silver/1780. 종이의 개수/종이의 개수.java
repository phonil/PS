
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int[][] board;
    static int zero = 0;
    static int one = 0;
    static int minusOne = 0;

    static void recursion(int r, int c, int n) {
        if (check(r, c, n)) {
            int paperNum = board[r][c];
            if (paperNum == -1)
                minusOne++;
            else if (paperNum == 0)
                zero++;
            else
                one++;
            return;
        }
        int bound = n / 3;
        recursion(r, c, bound);
        recursion(r, c + bound, bound);
        recursion(r, c + (2 * bound), bound);

        recursion(r + bound, c, bound);
        recursion(r + bound, c + bound, bound);
        recursion(r + bound, c + (2 * bound), bound);

        recursion(r + (2 * bound), c, bound);
        recursion(r + (2 * bound), c + bound, bound);
        recursion(r + (2 * bound), c + (2 * bound), bound);
    }

    static boolean check(int r, int c, int n) {
        if (n == 0)
            return true;
        int start = board[r][c];
        for (int i = r; i < r + n; i++) {
            for (int j = c; j < c + n; j++) {
                if (start != board[i][j])
                    return false;
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
        recursion(0, 0, N);
        System.out.println(minusOne);
        System.out.println(zero);
        System.out.println(one);
    }
}

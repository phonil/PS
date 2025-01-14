
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static char[][] board;

    static void recursion(int r, int c, int n) {
        if (n == 3) {
            stamp(r, c);
            return;
        }
        recursion(r, c, n / 2);
        recursion(r + n / 2, c - n / 2, n / 2);
        recursion(r + n / 2, c + n / 2, n / 2);
    }

    static void stamp(int r, int c) {
        board[r][c] = '*';
        board[r + 1][c - 1] = '*';
        board[r + 1][c + 1] = '*';
        for (int i = c - 2; i <= c + 2; i++)
            board[r + 2][i] = '*';
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        board = new char[N][2 * N];
        for (int i = 0; i < N; i++)
            for (int j = 0; j < 2 * N; j++)
                board[i][j] = ' ';

        recursion(0, N  - 1, N);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < 2 * N; j++) {
                sb.append(board[i][j]);
            }
            sb.append('\n');
        }
        System.out.print(sb);
    }
}

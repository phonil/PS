
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    public static Character[][] board;

    public static void recursion(int r, int c, int N) {
        if (N == 1) {
            board[r][c] = '*';
            return;
        }

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (i == 1 && j == 1)
                    continue;


                recursion(r + i * N / 3, c + j * N / 3, N / 3);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        board = new Character[N][N];
        for (int i = 0; i < N; i++) {
            Arrays.fill(board[i], ' ');
        }

        StringBuilder sb = new StringBuilder();

        recursion(0, 0, N);
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                sb.append(board[i][j]);
            }
            sb.append('\n');
        }
        System.out.print(sb);
    }
}


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int[][] board;
    static StringBuilder sb = new StringBuilder();

    static void func(int r, int c, int n) {
        if (check(r, c, n)) {
            sb.append(board[r][c]);
            return;
        }
        sb.append("(");
        int bound = n / 2;
        // 순서대로 왼쪽 위, 오른쪽 위, 왼쪽 아래, 오른쪽 아래
        func(r, c, bound);
        func(r, c + bound, bound);
        func(r + bound, c, bound);
        func(r + bound, c + bound, bound);
        sb.append(")");
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
            String line = br.readLine();
            for (int j = 0; j < N; j++) {
                board[i][j] = line.charAt(j) - '0';
            }
        }
        func(0, 0, N);
        System.out.print(sb);
    }
}

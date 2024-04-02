
import java.util.Scanner;

// 종이의 개수
public class Main {

    public static int[][] board;
    public static int gray = 0; // -1
    public static int white = 0; // 0
    public static int black = 0; // 1

    public static void recursion(int r, int c, int N) {
        if (check(r, c, N)) {
            if (board[r][c] == -1)
                gray++;
            else if (board[r][c] == 0)
                white++;
            else
                black++;
            return;
        }

        int newSize = N / 3;

        recursion(r, c, newSize);
        recursion(r, c + newSize, newSize);
        recursion(r, c + 2 * newSize, newSize);

        recursion(r + newSize, c, newSize);
        recursion(r + newSize, c + newSize, newSize);
        recursion(r + newSize, c + 2 * newSize, newSize);

        recursion(r + 2 * newSize, c, newSize);
        recursion(r + 2 * newSize, c + newSize, newSize);
        recursion(r + 2 * newSize, c + 2 * newSize, newSize);
    }

    public static boolean check(int r, int c, int N) {
        int color = board[r][c];

        for (int i = r; i < r + N; i++) {
            for (int j = c; j < c + N; j++) {
                if (color != board[i][j])
                    return false;
            }
        }
        return true;
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        board = new int[N][N];

        for (int i = 0; i < N; i++)
            for (int j = 0; j < N; j++)
                board[i][j] = sc.nextInt();

        recursion(0, 0, N);

        System.out.println(gray);
        System.out.println(white);
        System.out.println(black);

    }
}

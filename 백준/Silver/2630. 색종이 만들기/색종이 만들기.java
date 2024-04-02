
import java.util.Scanner;

// 색종이 만들기
public class Main {

    public static int[][] paper;
    public static int[] ans = new int[2]; // 0, 1

    public static void recursion(int r, int c, int N) {
        if (check(r, c, N)) {
            if (paper[r][c] == 0)
                ans[0]++;
            else
                ans[1]++;

            return;
        }

        int newSize = N / 2;

//        recursion(r, c, newSize);
//        recursion(r, c + newSize, newSize);
//        recursion(r + newSize, c, newSize);
//        recursion(r + newSize, c + newSize, newSize);
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                recursion(r + i * newSize, c + j * newSize, newSize);
            }
        }
    }

    public static boolean check(int r, int c, int N) {
        int num = paper[r][c];

        for (int i = r; i < r + N; i++) {
            for (int j = c; j < c + N; j++) {
                if (num != paper[i][j])
                    return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        paper = new int[N][N];

        for (int i = 0; i < N; i++)
            for (int j = 0; j < N; j++)
                paper[i][j] = sc.nextInt();

        recursion(0, 0, N);
        System.out.println(ans[0]);
        System.out.println(ans[1]);
    }
}

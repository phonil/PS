
import java.util.Scanner;

// 쿼드트리
public class Main {

    private static int[][] video;
    private static String ans = "";

    private static void recursion(int r, int c, int N) {
        if (check(r, c, N) || N == 1) {
            ans += video[r][c] + "";
            return;
        }

        int newSize = N / 2;

        ans += "(";
        recursion(r, c, newSize);
        recursion(r, c + newSize, newSize);
        recursion(r + newSize, c, newSize);
        recursion(r + newSize, c + newSize, newSize);
        ans += ")";
    }

    private static boolean check(int r, int c, int N) {
        int val = video[r][c];

        for (int i = r; i < r + N; i++) {  // N은 늘 N/2로 재귀적으로 들어오므로 .. r + N (횟수라고 생각)
            for (int j = c; j < c + N; j++) {
                if (val != video[i][j])
                    return false;
            }
        }
        return true;
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        video = new int[N][N];

        for (int i = 0; i < N; i++) {
            String s = sc.next();
            for (int j = 0; j < N; j++) {
                video[i][j] = s.charAt(j) - '0';
            }
        }

        recursion(0, 0, N);
        System.out.println(ans);
    }
}

package boj.class2;

import java.util.Scanner;

public class B11050 {

    public static int P1(int N, int K) {
        // 1번 풀이
        int up = 1;
        int count = K;
        for (int i = N; count > 0; count--, i--) {
            up *= i;
        }

        int down = 1;
        for (int i = 1; i <= K; i++) {
            down *= i;
        }

        int result = up / down;
        return result;
    }

    // Description : Recursion
    public static int recursion(int N, int K) {
        if (N == K || K == 0) {
            return 1;
        }
        return recursion(N - 1, K - 1) + recursion(N - 1, K);
    }

    // Description : Dynamic Programming
    public static int dp(int N, int K, int[][] dpt) {
        if (dpt[N][K] > 0)
            return dpt[N][K];

        if (N == K || K == 0)
            return 1;

        return dpt[N][K] = dp(N - 1, K - 1, dpt) + dp(N - 1, K, dpt);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int K = sc.nextInt();

        int[][] dpt = new int[N + 1][K + 1];

        // P1
//        int result = P1(N, K);
//        int result = recursion(N, K);
        int result = dp(N, K, dpt);

        System.out.println(result);
    }
}

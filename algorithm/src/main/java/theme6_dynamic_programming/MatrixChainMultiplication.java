package theme6_dynamic_programming;

public class MatrixChainMultiplication {

    static int MatrixMult_DC(int[] r, int i, int j) {

        if (i == j)
            return 0;
        else {
            int min_val = Integer.MAX_VALUE;

            for (int k = i; k < j; k++) {
                min_val = Math.min(min_val, MatrixMult_DC(r, i, k) + MatrixMult_DC(r, k + 1, j) + r[i-1] * r[k] * r[j]);
            }
            return min_val;
        }
    }

    static int MatrixMult_DP(int[] r, int n) {
        int[][] m = new int[n][n];
        int j, len, q;

        for (int i = 1; i < n; i++)
            m[i][i] = 0; // 채우기

        for (len = 1; len < n - 1; len++) {
            for (int i = 1; i < n - len; i++) {
                j = i + len;
                m[i][j] = Integer.MAX_VALUE; // 채우기

                for (int k = i; k < j; k++) {
                    // q는 두 개의 행렬 곱으로 분할한 후 곱하는 경우의 최소 곱셈 횟수
                    q = m[i][k] + m[k+1][j] + r[i-1] * r[k] * r[j];
                    if (q < m[i][j])
                        m[i][j] = q;
                }
            }

        }
        return m[1][n-1];
    }

    public static void main(String[] args) {
        int[] arr = {10, 20, 50, 1, 100,};
        int size = arr.length;

        System.out.println("Divide and Conquer : " + MatrixMult_DC(arr, 1, size - 1));
        System.out.println("Dynamic Programming : " + MatrixMult_DP(arr, size));


    }
}

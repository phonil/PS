package theme6_dynamic_programming;

public class Knapsack {

    private static int knapSack(int W, int[] weight, int[] value, int n) {
        int[][] k = new int[n + 1][W + 1];

        for (int i = 0; i <= n; i++)
            k[i][0] = 0;
        for (int j = 0; j <= W; j++)
            k[0][j] = 0;

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= W; j++) {

                if (weight[i - 1] > j)
                    k[i][j] = k[i - 1][j];

                else
                    k[i][j] = Math.max(k[i - 1][j], value[i - 1] + k[i - 1][j - weight[i - 1]]);
            }
        }
        return k[n][W];
    }

    public static void main(String[] args) {
        int[] value = {25, 15, 20, 30};
        int[] weight = {3, 1, 2, 4};

        int C = 7; // 배낭의 용량
        int n = value.length;

        System.out.println("최대 가치 = " + knapSack(C, weight, value, n));
    }

}

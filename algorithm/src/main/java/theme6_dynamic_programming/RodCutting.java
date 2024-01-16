package theme6_dynamic_programming;

public class RodCutting {

    // Description : 분할 정복
    static int cutRod_DC(int[] price, int i) {
        int maxSell;

        if (i == 0)
            return 0;

        maxSell = 0;

        for (int j = 1; j <= i; j++) {
            maxSell = Math.max(maxSell, price[j - 1] + cutRod_DC(price, i - j));
        }

        return maxSell;
    }

    // Description : 동적 계획
    static int cutRod_DP(int[] price, int n) {
        int maxSell[] = new int[n + 1];
        maxSell[0] = 0;

        for (int j = 1; j <= n; j++) { // memoization 채우는 loop // j일 때의 max값 -> DP 테이블로 넣는 것 !!
            int max_val = 0;

            for (int k = 1; k <= j; k++) { // 이 loop는 max_val을 위한 것... 계속해서 max_val과 DP 테이블을 비교하여 Math.max를 해야하므로..
                // DP 테이블을 넣는 과정에서.. 결국 최댓값을 구하게 되지
                
                max_val = Math.max(max_val, price[k - 1] + maxSell[j - k]);

            }
            maxSell[j] = max_val;
        }
        return maxSell[n];
    }

    public static void main(String[] args) {
        int[] A = {2, 5, 9, 10};
        int size = A.length;
        System.out.println("분할 정복 : " + cutRod_DC(A, size));
        System.out.println("동적 계획 : " + cutRod_DP(A, size));
    }
}

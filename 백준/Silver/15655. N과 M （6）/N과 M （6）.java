
import java.util.Arrays;
import java.util.Scanner;

// N과 M (6)
public class Main {

    private static int N, M;
    private static int[] nums; // 배열 입력 받는지
    private static int[] arr;
    private static boolean[] isUsed; // 내꺼 중복
    private static StringBuilder sb = new StringBuilder();

    private static void func(int k) {
        if (k == M) {
            for (int i = 0; i < M; i++)
                sb.append(nums[arr[i]] + " ");
            sb.append("\n");
            return;
        }

        int start = k;
        if (k != 0)
            start = arr[k - 1] + 1;

        for (int i = start; i < N; i++) {
            if (!isUsed[i]) {
                arr[k] = i;
                isUsed[i] = true;
                func(k + 1);
                isUsed[i] = false;
            }
        }

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();

        arr = new int[M];
        nums = new int[N];
        isUsed = new boolean[N];

        for (int i = 0; i < N; i++)
            nums[i] = sc.nextInt();
        Arrays.sort(nums);
        func(0);
        System.out.println(sb);
    }
}

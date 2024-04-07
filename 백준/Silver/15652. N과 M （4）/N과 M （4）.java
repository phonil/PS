
import java.util.Scanner;

// N과 M (4)
public class Main {

    private static int N, M;
    private static int[] arr;
    private static StringBuilder sb = new StringBuilder();

    private static void func(int k) {
        if (k == M) {
            for (int i = 0; i < M; i++) {
                sb.append(arr[i] + " ");
            }
            sb.append("\n");
            return;
        }
        int start = 1;
        if (k != 0)
            start = arr[k - 1];

        for (int i = start; i <= N; i++) {
            arr[k] = i;
            func(k + 1);
        }

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();

        arr = new int[M];

        func(0);
        System.out.println(sb);
    }
}


import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Scanner;

// N과 M (5)
public class Main {

    private static int N, M;
    private static int[] store;
    private static int[] arr;
    private static boolean[] isUsed;

    private static StringBuilder sb = new StringBuilder();

    public static void func(int k) {
        if (k == M) {
            for (int i = 0; i < M; i++) {
                sb.append(arr[i] + " ");
            }
            sb.append("\n");
            return;
        }

        for (int i = 0; i < N; i++) {
            if (!isUsed[i]) {
                arr[k] = store[i];
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

        store = new int[N];
        arr = new int[M];
        isUsed = new boolean[N + 1];

        for (int i = 0; i < N; i++) {
            store[i] = sc.nextInt();
        }

        Arrays.sort(store);

        func(0);
        System.out.print(sb);
    }
}

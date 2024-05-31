
import java.util.Scanner;

public class Main {

    public static int[] arr;
    public static boolean[] isUsed;

    public static int N;
    public static int M;

    public static void func(int k) {

        // base condition
        if (k == M) {
            for (int i = 0; i < M; i++) {
                System.out.print(arr[i] + " ");
            }
            System.out.println();
            return;
        }

        for (int i = 1; i <= N; i++) {
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
        isUsed = new boolean[N + 1];

        func(0);
    }

}

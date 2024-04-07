
import java.util.Scanner;

// 부분 수열의 합
public class Main {
    // 백트래킹 : 상태공간트리 - 포함하는 경우와 포함하지 않는 경우

    private static int N, S;
    private static int[] arr;
    private static int count = 0;

    public static void func(int cur, int total) {
        if (cur == N) {
            if (total == S)
                count++;
            return;
        }

        func(cur + 1, total);
        func(cur + 1, total + arr[cur]);

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        S = sc.nextInt();

        arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }

        func(0, 0);
        if (S == 0)
            count--;
        System.out.println(count);
    }
}

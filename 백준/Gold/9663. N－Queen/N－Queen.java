
import java.util.Scanner;

public class Main {

    private static int N;
    private static int count = 0;
    private static boolean[] isUsed1;
    private static boolean[] isUsed2;
    private static boolean[] isUsed3;

    private static void func(int cur) {
        if (cur == N) {
            count++;
            return;
        }

        for (int i = 0; i < N; i++) { // cur을 행으로, i를 열로 사용
            if (isUsed1[i] || isUsed2[cur + i] || isUsed3[cur - i + N - 1])
                continue;
            isUsed1[i] = true;
            isUsed2[cur + i] = true;
            isUsed3[cur - i + N - 1] = true;
            func(cur + 1);
            isUsed3[cur - i + N - 1] = false;
            isUsed2[cur + i] = false;
            isUsed1[i] = false;
        }

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();

        isUsed1 = new boolean[N];
        isUsed2 = new boolean[2 * N - 1];
        isUsed3 = new boolean[2 * N - 1];

        func(0);
        System.out.println(count);

    }
}

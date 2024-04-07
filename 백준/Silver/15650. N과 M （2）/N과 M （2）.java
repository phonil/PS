
import java.util.Scanner;

// N과 M (2)
public class Main {

    public static int[] arr;
    public static boolean[] isUsed;

    public static int N;
    public static int M;

    public static void func(int k) {
        if (k == M) {
            for (int i = 0; i < M; i++)
                System.out.print(arr[i] + " ");
            System.out.println();
            return;
        }

        int start = 1;
        if (k != 0)
            start = arr[k - 1] + 1;

        for (int i = start; i <= N; i++) { // 반복문 사용 이유 : 숫자가 1~N이므로 그 '수'를 표현하기 위함
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

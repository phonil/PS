
import java.util.Scanner;

// N과 M (3)
public class Main {

    private static int N, M;
    private static int[] arr;
    private static StringBuilder sb = new StringBuilder();

    private static void func(int k) { // 'k는' 지금 arr의 어디를 가리키고 있냐 ! 라는 뜻
        if (k == M) {
            for (int i = 0; i < M; i++)
                sb.append(arr[i] + " ");
            sb.append("\n");
            return;
        }

        for (int i = 1; i <= N; i++) {
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

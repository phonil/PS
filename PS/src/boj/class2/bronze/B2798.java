package boj.class2.bronze;

import java.util.Scanner;

public class B2798 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();

        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }

        int result = 0;

        for (int i = 0; i < N - 2; i++) {
            int a = arr[i];
            for (int j = i + 1; j < N - 1; j++) {
                int b = arr[j];
                for (int k = j + 1; k < N; k++) {
                    int c = arr[k];
                    if (a + b + c > result && a + b + c <= M )
                        result = a + b + c;
                }
            }
        }
        System.out.println(result);
    }
}

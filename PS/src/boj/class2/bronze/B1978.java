package boj.class2.bronze;

import java.util.Scanner;

public class B1978 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        int result = 0;

        for (int i = 0; i < N; i++) {
            int a = sc.nextInt();

            if (a == 1)
                continue;

            int x = 0;
            for (int j = 2; j < a; j++) {
                if (a % j == 0) {
                    x++;
                    break;
                }
            }

            if (x == 0)
                result++;
        }
        System.out.println(result);
    }
}

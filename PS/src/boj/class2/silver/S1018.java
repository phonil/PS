package boj.class2.silver;

import java.util.Scanner;

public class S1018 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int M = sc.nextInt();
        int N = sc.nextInt();
        sc.nextLine();

        boolean[][] arr = new boolean[M][N];

        for (int i = 0; i < M; i++) {
            String s = sc.nextLine();
            for (int j = 0; j < N; j++) {
                if (s.charAt(j) == 'W')
                    arr[i][j] = true;
                else
                    arr[i][j] = false;
            }
        }
        
        // 구현
        int min = 64;

        for (int i = 0; i <= M - 8; i++) {
            for (int j = 0; j <= N - 8; j++) { // 시작점
                boolean ans = arr[i][j];
                int count = 0;
                for (int k = i; k < i + 8; k++) {
                    for (int l = j; l < j + 8; l++) { // 끝점까지
                        if (arr[k][l] != ans)
                            count++;

                        ans = !ans;
                    }
                    ans = !ans;
                }
                count = Math.min(count, 64 - count);
                min = Math.min(count, min);
            }
        }
        System.out.println(min);
    }
}

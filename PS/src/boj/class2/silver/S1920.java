package boj.class2.silver;

import java.util.Arrays;
import java.util.Scanner;

public class S1920 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }

        Arrays.sort(arr);

        int M = sc.nextInt();

        for (int i = 0; i < M; i++) {
            int a = sc.nextInt();

            int left = 0;
            int right = arr.length - 1;
            boolean ans = false;

            while (left <= right) {
                int mid = (left + right) / 2;

                if (arr[mid] > a) {
                    right = mid - 1;
                } else if (arr[mid] < a) {
                    left = mid + 1;
                } else { // find !!
                    ans = true;
                    break;
                }
            }

            if (ans)
                System.out.println(1);
            else
                System.out.println(0);

        }

    }
}

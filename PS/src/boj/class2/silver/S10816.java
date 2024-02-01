package boj.class2.silver;

import java.util.Arrays;
import java.util.Scanner;

public class S10816 {

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

            int upper = upper_bound(arr, a);
            int lower = lower_bound(arr, a);
            System.out.print(upper - lower +  " ");
        }

    }

    public static int upper_bound(int[] arr, int a) {
        int left = 0;
        int right = arr.length - 1;
        while (left < right) {
            int mid = (left + right) / 2;
            if (arr[mid] > a) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    public static int lower_bound(int[] arr, int a) {
        int left = 0;
        int right = arr.length - 1;
        while (left < right) {
            int mid = (left + right) / 2;
            if (arr[mid] >= a) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }
}

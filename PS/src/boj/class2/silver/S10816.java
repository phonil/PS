package boj.class2.silver;

import java.util.Arrays;
import java.util.Scanner;

public class S10816 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

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
            sb.append(upper - lower).append(' ');
        }
        System.out.println(sb);
    }

    public static int upper_bound(int[] arr, int a) {
        int left = 0;
        int right = arr.length;
        while (left < right) {
            int mid = (left + right) / 2;
            if (arr[mid] > a) {
                right = mid;
            } else { // == 경우 left가 이동 (+ 1) -> 시작 범위 초과!! (left 포함하지 않게 되니까..)
                left = mid + 1;
            }
        }
        return left;
    }

    public static int lower_bound(int[] arr, int a) {
        int left = 0;
        int right = arr.length;
        while (left < right) {
            int mid = (left + right) / 2;
            if (arr[mid] >= a) { // == 경우 right가 이동 (+ 1) --> 시작 범위 포함!! (left 포함한 수니까..)
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }
}

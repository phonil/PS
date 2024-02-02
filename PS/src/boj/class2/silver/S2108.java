package boj.class2.silver;

import java.util.Arrays;
import java.util.Scanner;

public class S2108 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }
        double avg = avg(arr);
        System.out.println((int) avg);

        int mid = mid(arr);
        System.out.println(mid);

        int mode = mode(arr);
        System.out.println(mode);

        int range = range(arr);
        System.out.println(range);
    }

    public static double avg(int[] arr) {
        int sum = 0;
        for (int i : arr) {
            sum += i;
        }
        double avg = sum / (double) arr.length;
        return Math.round(avg);
    }

    public static int mid(int[] arr) {
        Arrays.sort(arr);
        int midIndex = arr.length / 2;
        return arr[midIndex];
    }

    public static int mode(int[] arr) {
        int[] count = new int[8001];

        for (int i = 0; i < arr.length; i++) {
            count[arr[i] + 4000]++;
        }

        int max = 0; // 최빈 몇 번인지
        for (int i = 0; i < 8001; i++) {
            max = Math.max(max, count[i]);
        }

        boolean flag = false;
        int mode = 0;

        for (int i = 0; i < 8001; i++) {
            if (count[i] == max) {
                if (flag) { // 처음은 false => 첫 최빈은 false
                    mode = i - 4000;
                    break;
                }
                mode = i - 4000;
                flag = true;
            }
        }

        return mode;
    }

    public static int range(int[] arr) {
        Arrays.sort(arr);
        return arr[arr.length - 1] - arr[0];
    }

}

package boj.class2;

import java.util.Scanner;

public class B1546 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int[] arr = new int[N];
        int max = 0;
        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
            if (max < arr[i])
                max = arr[i];
        }
        double sum = 0;
        double avg = 0;
        for (int i = 0; i < N; i++) {
            sum +=  (arr[i] / (double) max) * 100;
        }
        avg = sum / (double) N;
        System.out.println(avg);
    }
}

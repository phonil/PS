package boj.class2.silver;

import java.util.Scanner;

public class S1676 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        // 5 x 2 가 포함된 경우 (소인수) 뒤가 0
        // 2의 개수가 5보다 자연히 많음
        int count = 0;

        while (N > 0) {
            count += N / 5;
            N /= 5;
        }
        System.out.println(count);

    }
}

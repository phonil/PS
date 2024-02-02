package boj.class2.silver;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class S1966 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();

        for (int i = 0; i < T; i++) {
            int N = sc.nextInt();
            int M = sc.nextInt();
            Queue<int[]> q = new LinkedList<>();

            for (int j = 0; j < N; j++) {
                q.offer(new int[]{j, sc.nextInt()});
            }

            int[] cur = q.poll();
            int count = 1;
            for (int[] curQ : q) {
                if (curQ[1] > cur[1]) {

                }

            }


        }
    }
}

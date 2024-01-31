package boj.class2.silver;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class S2164 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        Queue<Integer> q = new LinkedList();
        for (int i = 1; i <= N; i++) {
            q.offer(i);
        }

        while (q.size() != 1) {
            q.remove();
            Integer poll = q.poll();
            q.offer(poll);

        }
        System.out.println(q.poll());
    }
}

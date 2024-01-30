package boj.class2;

import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class S11866 {

//    Scanner sc = new Scanner(System.in);
//
//    int N = sc.nextInt();
//    int K = sc.nextInt();
//
//    Queue<Integer> q = new LinkedList();
//        for (int i = 0; i < N; i++) {
//        q.offer(i + 1);
//    }
//        System.out.print("<");
//        while (!q.isEmpty()) {
//
//        for (int i = 0; i < K - 1; i++) {
//            int value = q.poll();
//            q.offer(value);
//        }
//
//        if (q.size() == 1)
//            System.out.print(q.poll());
//        else
//            System.out.print(q.poll() + ", ");
//
//
//    }
//        System.out.print(">");
//}

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int K = sc.nextInt();

        Queue<Integer> q = new LinkedList();
        for (int i = 0; i < N; i++) {
            q.offer(i + 1);
        }
        System.out.print("<");
        
        // 구현
        
        
        System.out.print(">");
    }
}

package boj.baaaarkingdog.problem.deque;

import java.util.LinkedList;
import java.util.Scanner;

public class S1021 {

//    Scanner sc = new Scanner(System.in);
//
//    int N = sc.nextInt();
//    int M = sc.nextInt();
//    LinkedList<Integer> deque = new LinkedList<Integer>();
//    int count = 0;
//
//        for (int i = 1; i <= N; i++) {
//        deque.offer(i);
//    }
//
//    int[] arr = new int[M];
//        for (int i = 0; i < M; i++) {
//        arr[i] = sc.nextInt();
//    }
//
//        for (int i = 0; i < M; i++) {
//        int num = arr[i];
//        int dIndex = deque.indexOf(arr[i]);
//        int midIndex;
//
//        if (deque.size() % 2 == 0)
//            midIndex = deque.size() / 2 - 1;
//        else
//            midIndex = deque.size() / 2;
//
//        if (midIndex >= dIndex) { // 2번 연산
//            for (int j = 0; j < dIndex; j++) {
//                int a = deque.pollFirst();
//                deque.offerLast(a);
//                count++;
//            }
//        } else { // 3번 연산
//            for (int j = 0; j < deque.size() - dIndex; j++) {
//                int a = deque.pollLast();
//                deque.offerFirst(a);
//                count++;
//            }
//        }
//
//        deque.pollFirst(); // 1번 연산
//    }
//        System.out.println(count);

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();
        LinkedList<Integer> deque = new LinkedList<Integer>();
        int count = 0;

        for (int i = 1; i <= N; i++) {
            deque.offer(i);
        }

        int[] arr = new int[M];
        for (int i = 0; i < M; i++) {
            arr[i] = sc.nextInt();
        }

        // 구현
        for (int i = 0; i < M; i++) {
            int midIndex;
            int key = arr[i];
            int dIndex = deque.indexOf(key);

            if (deque.size() % 2 == 0)
                midIndex = deque.size() / 2 - 1;
            else
                midIndex = deque.size() / 2;

            if (midIndex >= dIndex) {
                for (int j = 0; j < dIndex; j++) {
                    int leftPoll = deque.pollFirst();
                    deque.offerLast(leftPoll);
                    count++;
                }
            } else {
                for (int j = 0; j < deque.size() - dIndex; j++) {
                    int rightPoll = deque.pollLast();
                    deque.offerFirst(rightPoll);
                    count++;
                }
            }
            deque.pollFirst();
        }
        System.out.println(count);
    }
}

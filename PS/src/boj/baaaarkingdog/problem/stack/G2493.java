package boj.baaaarkingdog.problem.stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.Stack;
import java.util.StringTokenizer;

public class G2493 {

//    Scanner sc = new Scanner(System.in);
//    int N = sc.nextInt();
//    Stack<Integer> stack = new Stack<>();
//    Stack<Integer> index = new Stack<>();
//
//        for (int i = 1; i <= N; i++) {
//        int top = sc.nextInt();
//
//        while (true) {
//            if (!stack.isEmpty()) {
//                if (top < stack.peek()) {
//                    System.out.print(index.peek() + " ");
//                    stack.push(top);
//                    index.push(i);
//                    break;
//                } else {
//                    stack.pop();
//                    index.pop();
//                }
//
//            } else {
//                System.out.print("0 ");
//                stack.push(top);
//                index.push(i);
//                break;
//            }
//
//        }
//    }

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Stack<Integer> stack = new Stack<>();
        Stack<Integer> index = new Stack<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        // 구현
        for (int i = 1; i <= N; i++) {
            int top = Integer.parseInt(st.nextToken());
            while (true) {
                if (!stack.isEmpty()) {
                    if (stack.peek() > top) {
                        System.out.print(index.peek() + " ");
                        stack.push(top);
                        index.push(i);
                        break;
                    } else {
                        stack.pop();
                        index.pop();
                    }
                } else {
                    System.out.print("0 ");
                    stack.push(top);
                    index.push(i);
                    break;
                }

            }
        }

    }
}

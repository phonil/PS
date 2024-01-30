package boj.class2;

import java.util.Scanner;
import java.util.Stack;

public class S10773 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int K = sc.nextInt();
        Stack<Integer> stack = new Stack<>();
        stack.push(0);

        for (int i = 0; i < K; i++) {
            int a = sc.nextInt();
            if (a != 0)
                stack.push(a);
            else
                stack.pop();
        }

        int sum = 0;
        for (int i = stack.size() - 1; i >= 0; i--) {
            sum += stack.get(i);
        }
        System.out.println(sum);
    }
}

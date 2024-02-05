package boj.baaaarkingdog.problem.advanced_stack;

import java.util.Scanner;
import java.util.Stack;

public class S3986 {

//    Scanner sc = new Scanner(System.in);
//    int N = sc.nextInt();
//        sc.nextLine();
//    int count = 0;
//
//        for (int i = 0; i < N; i++) {
//        String s = sc.nextLine();
//        Stack<Character> stack = new Stack<>();
//
//        if (s.length() % 2 == 1)
//            continue;
//        char a = s.charAt(0);
//        stack.push(a);
//        for (int j = 1; j < s.length(); j++) {
//            if (stack.size() > 0 && stack.peek() == s.charAt(j))
//                stack.pop();
//            else
//                stack.push(s.charAt(j));
//
//        }
//        if (stack.isEmpty())
//            count++;
//    }
//        System.out.println(count);

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        sc.nextLine();
        int count = 0;

        for (int i = 0; i < N; i++) {
            String s = sc.nextLine();
            Stack<Character> stack = new Stack<>();
            
            // 구현
            stack.push(s.charAt(0));
            for (int j = 1; j < s.length(); j++) {
                if (!stack.isEmpty() && stack.peek() == s.charAt(j))
                    stack.pop();
                else
                    stack.push(s.charAt(j));

            }
            if (stack.isEmpty())
                count++;
            
        }
        System.out.println(count);
    }
}

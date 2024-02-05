package boj.baaaarkingdog.problem.advanced_stack;

import java.util.Scanner;
import java.util.Stack;

public class S10799 {

//    Scanner sc = new Scanner(System.in);
//
//    String s = sc.nextLine();
//    Stack<Character> stack = new Stack<>();
//    int count = 0;
//        for (int i = 0; i < s.length(); i++) {
//        if (s.charAt(i) == '(') {
//            stack.push(s.charAt(i));
//        } else if (s.charAt(i) == ')'){
//            stack.pop();
//            if (s.charAt(i - 1) == '(')
//                count += stack.size();
//            else
//                count++;
//        }
//    }
//        System.out.println(count);

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String s = sc.nextLine();
        Stack<Character> stack = new Stack<>();
        int count = 0;

        // 구현
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(')
                stack.push(s.charAt(i));
            else {
                stack.pop();
                if (s.charAt(i - 1) == '(') {
                    count += stack.size();
                } else {
                    count++;
                }
            }
        }
        System.out.println(count);

    }
}

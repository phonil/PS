package boj.baaaarkingdog.problem.advanced_stack;

import java.util.Scanner;
import java.util.Stack;

public class G2504 {

//    Scanner sc = new Scanner(System.in);
//    String s = sc.nextLine();
//    Stack<Character> stack = new Stack<>();
//
//    int num = 1;
//    int sum = 0;
//
//        for (int i = 0; i < s.length(); i++) {
//        if (s.charAt(i) == '(') {
//            num *= 2;
//            stack.push(s.charAt(i));
//        } else if (s.charAt(i) == ')') {
//            if (stack.isEmpty() || stack.peek() != '(') {
//                sum = 0;
//                break;
//            }
//            if (s.charAt(i - 1) == '(')
//                sum += num;
//            stack.pop();
//            num /= 2;
//
//        } else if (s.charAt(i) == '[') {
//            num *= 3;
//            stack.push(s.charAt(i));
//        } else { // s.charAt(i) == ']'
//            if (stack.isEmpty() || stack.peek() != '[') {
//                sum = 0;
//                break;
//            }
//            if (s.charAt(i - 1) == '[')
//                sum += num;
//            stack.pop();
//            num /= 3;
//        }
//    }
//        if (stack.isEmpty())
//                System.out.println(sum);
//        else
//                System.out.println("0");

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        Stack<Character> stack = new Stack<>();

        int num = 1;
        int sum = 0;

        // 구현
        for (int i = 0; i < s.length(); i++) {


        }

    }
}

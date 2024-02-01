package boj.class2.silver;

import java.util.Scanner;
import java.util.Stack;

public class S4949 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String s = sc.nextLine();
        while (!(s.charAt(0) == '.' && s.length() == 1)) {
            String ans = "yes";
            Stack<Character> stack = new Stack<>();

            for (int i = 0; i < s.length(); i++) {
                char a = s.charAt(i);

                if (a == '(' || a == '[') {
                    stack.push(a);
                }

                else if (a == ')') {
                    if (stack.isEmpty() || stack.peek() != '(') {
                        ans = "no";
                        break;
                    }
                    stack.pop();
                }

                else if (a == ']') {
                    if (stack.isEmpty() || stack.peek() != '[') {
                        ans = "no";
                        break;
                    }
                    stack.pop();
                }
            }
            if (!stack.isEmpty())
                ans = "no";

            System.out.println(ans);

            s = sc.nextLine();
        }


    }
}

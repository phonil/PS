
import java.util.Scanner;
import java.util.Stack;

public class Main {


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        Stack<Character> stack = new Stack<>();

        int num = 1;
        int sum = 0;

        // 구현
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') {
                stack.push(c);
                num *= 2;
            } else if (c == '[') {
                stack.push(c);
                num *= 3;
            } else if (c == ')') {
                if (stack.isEmpty() || stack.peek() != '(') { // stack.peek() : 이제 뽑을 거
                    sum = 0;
                    break;
                }
                if (s.charAt(i - 1) == '(')
                    sum += num;
                stack.pop();
                num /= 2;
            } else {
                if (stack.isEmpty() || stack.peek() != '[') { // stack.peek() : 이제 뽑을 거
                    sum = 0;
                    break;
                }
                if (s.charAt(i - 1) == '[')
                    sum += num;
                stack.pop();
                num /= 3;
            }
        }
        if (!stack.isEmpty())
            System.out.println("0");
        else
            System.out.println(sum);

    }
}

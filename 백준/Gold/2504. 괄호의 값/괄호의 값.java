
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();

        int sum = 0; // 괄호 안 덧셈 시 사용
        int num = 1; // 곱셈 시 사용
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') {
                stack.push(c);
                num *= 2;
            } else if (c == '[') {
                stack.push(c);
                num *= 3;
            } else if (c == ')') {
                if (stack.isEmpty() || stack.peek() != '(') {
                    sum = 0;
                    break;
                }
                if (s.charAt(i - 1) == '(')
                    sum += num;
                stack.pop();
                num /= 2;
            } else { // if c == ']'
                if (stack.isEmpty() || stack.peek() != '[') {
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

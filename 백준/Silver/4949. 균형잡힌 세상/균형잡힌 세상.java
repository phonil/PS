
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String input = br.readLine();
        while (!input.equals(".")) {
            Stack<Character> stack = new Stack<>();
            String ans = "yes";
            for (int i = 0; i < input.length(); i++) {
                char c = input.charAt(i);
                if (c == '(' || c == '[') {
                    stack.push(c);
                } else if (c == ')') {
                    if (stack.isEmpty() || stack.peek() != '(') {
                        ans = "no";
                        break;
                    }
                    stack.pop();
                } else if (c == ']') {
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
            input = br.readLine();
        }


    }
}

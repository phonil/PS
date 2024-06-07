
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        // stack.peek > top -> ans : stack.peek.index
        // stack.peek < top -> stack.pop -> ...
        // stack.isEmpty -> ans : 0

        Stack<Integer> stack = new Stack<>();
        Stack<Integer> index = new Stack<>();
        for (int i = 1; i <= N; i++) {
            int top = Integer.parseInt(st.nextToken());
            while (true) {
                if (stack.isEmpty()) {
                    System.out.print("0 ");
                    stack.push(top);
                    index.push(i);
                    break;
                } else {
                    if (stack.peek() > top) {
                        System.out.print(index.peek() + " ");
                        stack.push(top);
                        index.push(i);
                        break;
                    } else {
                        stack.pop();
                        index.pop();
                    }
                }
            }

        }

    }
}

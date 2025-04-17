
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String[] split = br.readLine().split(" ");
        int[] arr = new int[N];
        Stack<Integer> st = new Stack<>();
        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(split[i]);
            arr[i] = num;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            int num = arr[i];
            while (!st.isEmpty() && arr[st.peek()] < num)
                st.pop();
            if (st.isEmpty()) sb.append(0).append(" ");
            else sb.append(st.peek() + 1).append(" ");
            st.push(i);
        }
        System.out.print(sb);
    }
}

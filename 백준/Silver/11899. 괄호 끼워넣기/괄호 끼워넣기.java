
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        Stack<Character> st = new Stack<>();
        int cnt = 0;
        for (int i = 0; i < line.length(); i++) {
            char c = line.charAt(i);
            if (c == ')') {
                if (st.isEmpty()) cnt++;
                else st.pop();
            } else
                st.push(c);
        }
        System.out.print(cnt + st.size());
    }
}

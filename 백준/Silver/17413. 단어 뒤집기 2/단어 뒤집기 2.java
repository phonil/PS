
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        Stack<Character> st = new Stack<>();
        StringBuilder sb = new StringBuilder();
        boolean tag = false;
        for (int i = 0; i < line.length(); i++) {
            char c = line.charAt(i);
            if (c == '<') {
                tag = true;
                while (!st.isEmpty())
                    sb.append(st.pop());
            } else if (c == '>') {
                tag = false;
                sb.append(c);
                continue;
            }
            if (tag)
                sb.append(c);
            else {
                if (c == ' ') {
                    while (!st.isEmpty())
                        sb.append(st.pop());
                    sb.append(c);
                } else
                    st.push(c);
            }
        }
        while (!st.isEmpty())
            sb.append(st.pop());
        System.out.print(sb);
    }
}

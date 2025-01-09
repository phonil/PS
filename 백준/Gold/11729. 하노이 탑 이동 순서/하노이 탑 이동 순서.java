
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static StringBuilder sb = new StringBuilder();
    static void recursive(int a, int b, int n) {
        if (n == 1) {
            sb.append(a).append(" ").append(b).append('\n');
            return;
        }
        recursive(a,6 - a - b, n - 1);
        sb.append(a).append(" ").append(b).append('\n');
        recursive(6 - a - b, b, n - 1);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        sb.append((1<<N) - 1).append('\n');
        recursive(1, 3, N);
        System.out.print(sb);
    }
}

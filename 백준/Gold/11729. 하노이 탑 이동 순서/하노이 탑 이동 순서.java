
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int N;
    static int cnt = 0;
    static StringBuilder sb = new StringBuilder();
    static void func(int st, int dest, int n) {
        if (n == 1) {
            sb.append(st).append(" ").append(dest).append('\n');
            cnt++;
            return;
        }
        func(st, 6 - st - dest, n - 1);
        func(st, dest, 1);
        func(6 - st - dest, dest, n - 1);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        func(1, 3, N);
        System.out.println(cnt);
        System.out.print(sb);
    }
}

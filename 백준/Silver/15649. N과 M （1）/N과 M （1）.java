
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int N, M;
    static StringBuilder sb = new StringBuilder();
    static int[] arr;
    static boolean[] visit;

    public static void func(int m) {
        if (m == M) {
            for (int i : arr)
                sb.append(i).append(" ");
            sb.append('\n');
            return;
        }
        for (int i = 1; i <= N; i++) {
            if (visit[i]) continue;
            visit[i] = true;
            arr[m] = i;
            func(m + 1);
            visit[i] = false;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] split = br.readLine().split(" ");
        N = Integer.parseInt(split[0]);
        M = Integer.parseInt(split[1]);
        arr = new int[M];
        visit = new boolean[N + 1];
        func(0);
        System.out.print(sb);
    }
}


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int N, M;
    static int[] arr;
    static StringBuilder sb = new StringBuilder();

    public static void func(int cur) {
        if (cur == M) {
            for (int i : arr)
                sb.append(i).append(" ");
            sb.append('\n');
            return;
        }
        int start = 1;
        if (cur != 0)
            start = arr[cur - 1];
        for (int i = start; i <= N; i++) {
            arr[cur] = i;
            func(cur + 1);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] split = br.readLine().split(" ");
        N = Integer.parseInt(split[0]);
        M = Integer.parseInt(split[1]);
        arr = new int[M];
        func(0);
        System.out.print(sb);
    }
}

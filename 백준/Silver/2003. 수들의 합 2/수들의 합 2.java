
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] split = br.readLine().split(" ");
        int N = Integer.parseInt(split[0]);
        int M = Integer.parseInt(split[1]);
        int[] sum = new int[N + 1];
        split = br.readLine().split(" ");
        for (int i = 1; i <= N; i++) {
            int num = Integer.parseInt(split[i - 1]);
            sum[i] = sum[i - 1] + num;
        }
        int lp = 0;
        int rp = 1;
        int cnt = 0;
        while (rp <= N) {
            int num = sum[rp] - sum[lp];
            if (num == M) cnt++;
            if (num > M)
                lp++;
            else
                rp++;
        }
        System.out.print(cnt);
    }
}

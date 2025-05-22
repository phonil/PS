import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int N, S;
    static int[] nums;
    static int[] D;
    static int mn = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] split = br.readLine().split(" ");
        N = Integer.parseInt(split[0]);
        S = Integer.parseInt(split[1]);
        nums = new int[N + 1];
        D = new int[N + 1];
        split = br.readLine().split(" ");
        for (int i = 1; i <= N; i++)
            nums[i] = Integer.parseInt(split[i-1]);
        for (int i = 1; i <= N; i++)
            D[i] = D[i - 1] + nums[i];

        int en = 1;
        for (int st = 0; st <= N; st++) {
            while (en <= N && S > D[en] - D[st]) en++;
            if (en == N + 1) break;
            mn = Math.min(mn, en - st);
        }
        if (mn == Integer.MAX_VALUE)
            mn = 0;
        System.out.print(mn);
    }
}

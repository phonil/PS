
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int N, S;
    static int[] nums;
    static int cnt = 0;

    static void func(int cur, int sum) {
        if (cur == N) {
            if (sum == S) cnt++;
            return;
        }
        func(cur + 1, sum + nums[cur]);
        func(cur + 1, sum);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] split = br.readLine().split(" ");
        N = Integer.parseInt(split[0]);
        S = Integer.parseInt(split[1]);
        nums = new int[N];
        String[] line = br.readLine().split(" ");
        for (int i = 0; i < N; i++)
            nums[i] = Integer.parseInt(line[i]);
        func(0, 0);
        if (S == 0)
            cnt--;
        System.out.print(cnt);
    }
}

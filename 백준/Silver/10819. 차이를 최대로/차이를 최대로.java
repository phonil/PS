
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main{

    static int N;
    static int[] arr;
    static int[] nums;
    static boolean[] visit;
    static int max = 0;

    static void func(int cur) {
        if (cur == N) {
            max = Math.max(max, calculate());
            return;
        }
        for (int i = 0; i < N; i++) {
            if (visit[i]) continue;
            arr[cur] = nums[i];
            visit[i] = true;
            func(cur + 1);
            visit[i] = false;
        }
    }

    static int calculate() {
        int sum = 0;
        for (int i = 0; i < N - 1; i++)
            sum += Math.abs(arr[i] - arr[i + 1]);
        return sum;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        nums = new int[N];
        visit = new boolean[N];
        String[] split = br.readLine().split(" ");
        for (int i = 0; i < N; i++)
            nums[i] = Integer.parseInt(split[i]);
        func(0);
        System.out.print(max);
    }
}

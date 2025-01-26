
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    static int N, M;
    static int[] arr, nums;
    static boolean[] visit;
    static StringBuilder sb = new StringBuilder();

    static void func(int cur) {
        if (cur == M) {
            for (int i : arr)
                sb.append(nums[i]).append(" ");
            sb.append('\n');
            return;
        }
        int tmp = 0;
        for (int i = 0; i < N; i++) {
            if (visit[i]) continue;
            if (tmp == nums[i]) continue;
            arr[cur] = i;
            visit[i] = true;
            tmp = nums[i];
            func(cur + 1);
            visit[i] = false;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] split = br.readLine().split(" ");
        N = Integer.parseInt(split[0]);
        M = Integer.parseInt(split[1]);
        arr = new int[M];
        nums = new int[N];
        visit = new boolean[N];
        String[] line = br.readLine().split(" ");
        for (int i = 0; i < N; i++)
            nums[i] = Integer.parseInt(line[i]);
        Arrays.sort(nums);
        func(0);
        System.out.print(sb);
    }
}


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    static int N, M;
    static int[] arr, nums;
    static StringBuilder sb = new StringBuilder();

    static void func(int cur) {
        if (cur == M) {
            for (int i : arr)
                sb.append(nums[i]).append(" ");
            sb.append('\n');
            return;
        }
        int startIdx = 0;
        if (cur != 0)
            startIdx = arr[cur - 1];
        for (int i = startIdx; i < N; i++) {
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
        nums = new int[N];
        String[] line = br.readLine().split(" ");
        for (int i = 0; i < N; i++)
            nums[i] = Integer.parseInt(line[i]);
        Arrays.sort(nums);
        func(0);
        System.out.print(sb);
    }
}

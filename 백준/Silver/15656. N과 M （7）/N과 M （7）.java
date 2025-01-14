
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
                sb.append(i).append(" ");
            sb.append('\n');
            return;
        }
        for (int i = 0; i < N; i++) {
            arr[cur] = nums[i];
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

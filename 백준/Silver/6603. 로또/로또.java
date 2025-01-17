
import java.io.*;

public class Main {

    static int K;
    static int[] arr, nums;
    static boolean[] visit;
    static StringBuilder sb;

    static void func(int cur) {
        if (cur == 6) {
            for (int i : arr)
                sb.append(nums[i]).append(" ");
            sb.append('\n');
            return;
        }
        int startIdx = 0;
        if (cur != 0)
            startIdx = arr[cur - 1];
        for (int i = startIdx; i < K; i++) {
            if (visit[i]) continue;
            arr[cur] = i;
            visit[i] = true;
            func(cur + 1);
            visit[i] = false;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            String[] split = br.readLine().split(" ");
            if (split[0].equals("0"))
                break;
            sb = new StringBuilder();
            K = Integer.parseInt(split[0]);
            arr = new int[6];
            nums = new int[K];
            visit = new boolean[K];
            for (int i = 0; i < K; i++)
                nums[i] = Integer.parseInt(split[i + 1]);
            func(0);
            System.out.println(sb);
        }
    }
}

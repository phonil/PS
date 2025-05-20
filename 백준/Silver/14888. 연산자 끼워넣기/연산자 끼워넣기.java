
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int N;
    static int[] arr;
    static int[] nums;
    static int[] ops = new int[4];
    static int max = Integer.MIN_VALUE;
    static int min = Integer.MAX_VALUE;
    static StringBuilder sb = new StringBuilder();

    static void func(int cur) {
        if (cur == N - 1) {
            calc();
            return;
        }
        for (int i = 0; i < 4; i++) {
            if (ops[i] == 0) continue;
            arr[cur] = i;
            ops[i]--;
            func(cur + 1);
            ops[i]++;
        }
    }

    static void calc() {
        int sum = nums[0];
        for (int i = 0; i < N - 1; i++) {
            int operator = arr[i];
            switch (operator) {
                case 0 -> sum += nums[i + 1];
                case 1 -> sum -= nums[i + 1];
                case 2 -> sum *= nums[i + 1];
                case 3 -> {
//                    if (sum < 0)
//                        sum = -(-sum / nums[i + 1]);
//                    else
                        sum /= nums[i + 1];
                }
            }
        }
        max = Math.max(max, sum);
        min = Math.min(min, sum);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N - 1];
        nums = new int[N];

        String[] split = br.readLine().split(" ");
        for (int i = 0; i < N; i++)
            nums[i] = Integer.parseInt(split[i]);

        split = br.readLine().split(" ");
        for (int i = 0; i < 4; i++)
            ops[i] = Integer.parseInt(split[i]);

        func(0);
        sb.append(max).append('\n').append(min);
        System.out.print(sb);
    }
}

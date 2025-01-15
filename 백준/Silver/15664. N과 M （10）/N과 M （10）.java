
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    static int N, M;
    static int[] arr, nums;
    static boolean[] isUsed;
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
        int tmp = 0; // 지역 변수이므로, 새로운 함수를 호출할 때는 0으로 유지됨 / 동일한 함수 호출 (깊이)에서 for문 돌 때 유지되고, 사용됨.
        for (int i = startIdx; i < N; i++) {
            if (isUsed[i]) continue;
            if (tmp == nums[i]) continue;
            tmp = nums[i];
            arr[cur] = i;
            isUsed[i] = true;
            func(cur + 1);
            isUsed[i] = false;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] split = br.readLine().split(" ");
        N = Integer.parseInt(split[0]);
        M = Integer.parseInt(split[1]);
        arr = new int[M];
        nums = new int[N];
        isUsed = new boolean[N];
        String[] line = br.readLine().split(" ");
        for (int i = 0; i < N; i++)
            nums[i] = Integer.parseInt(line[i]);
        Arrays.sort(nums);
        func(0);
        System.out.print(sb);
    }
}

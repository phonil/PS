
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    public static int N, M;
    public static int[] numArr;
    public static int[] arr;
    public static boolean[] isUsed;
    public static StringBuilder sb = new StringBuilder();

    public static void func(int k) {
        if (k == M) {
            for (int i : arr)
                sb.append(i + " ");
            sb.append("\n");
            return;
        }
        int tmp = 0;
        for (int i = 0; i < N; i++) {
            if (isUsed[i] || tmp == numArr[i]) continue;
            arr[k] = numArr[i];
            tmp = arr[k];
            isUsed[i] = true;
            func(k + 1);
            isUsed[i] = false;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] split = br.readLine().split(" ");
        N = Integer.parseInt(split[0]);
        M = Integer.parseInt(split[1]);
        arr = new int[M];
        numArr = new int[N];
        isUsed = new boolean[N];
        String[] nums = br.readLine().split(" ");
        for (int i = 0; i < N; i++)
            numArr[i] = Integer.parseInt(nums[i]);
        Arrays.sort(numArr);
        func(0);
        System.out.print(sb);
    }
}

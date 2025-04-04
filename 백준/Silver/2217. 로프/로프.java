
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] nums = new int[N];
        for (int i = 0; i < N; i++)
            nums[i] = Integer.parseInt(br.readLine());
        Arrays.sort(nums);

        int max = 0;
        for (int i = 0; i < N; i++)
            max = Math.max(max, nums[i] * (N - i));
        System.out.print(max);
    }
}

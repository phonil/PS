
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] nums = new int[10];
        while (N > 0) {
            int mod = N % 10;
            if (mod == 9)
                mod = 6;
            nums[mod]++;
            N /= 10;
        }
        int idx = 0;
        nums[6] = (nums[6] - 1) / 2 + 1;
        for (int i = 0; i < 10; i++) {
            if (idx < nums[i])
                idx = nums[i];
        }
        System.out.print(idx);
    }
}

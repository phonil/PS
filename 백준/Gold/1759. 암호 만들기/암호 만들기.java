
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    static int L, C;
    static int[] arr;
    static char[] nums;
    static boolean[] visit;
    static StringBuilder sb = new StringBuilder();

    static boolean check() {
        int ja = 0;
        int mo = 0;
        for (int i : arr) {
            if (nums[i] == 'a' || nums[i] == 'e' || nums[i] == 'i' || nums[i] == 'o' || nums[i] == 'u')
                mo++;
            else
                ja++;
        }
        if (ja >= 2 && mo >= 1)
            return true;
        return false;
    }
    static void func(int cur) {
        if (cur == L) {
            if (check()) {
                for (int i : arr)
                    sb.append(nums[i]);
                sb.append('\n');
            }
            return;
        }
        int startIdx = 0;
        if (cur != 0)
            startIdx = arr[cur - 1];
        for (int i = startIdx; i < C; i++) {
            if (visit[i]) continue;
            arr[cur] = i;
            visit[i] = true;
            func(cur + 1);
            visit[i] = false;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] split = br.readLine().split(" ");
        L = Integer.parseInt(split[0]);
        C = Integer.parseInt(split[1]);
        arr = new int[L];
        nums = new char[C];
        visit = new boolean[C];
        String[] line = br.readLine().split(" ");
        for (int i = 0; i < C; i++)
            nums[i] = line[i].charAt(0);
        Arrays.sort(nums);
        func(0);
        System.out.print(sb);
    }
}

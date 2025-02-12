
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    static int N, M;
    static int[] arr;


    static boolean solve(int x) {
        int sum = 0;
        for (int num : arr)
            sum += num / x;
        return sum >= M;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] split = br.readLine().split(" ");
        M = Integer.parseInt(split[0]);
        N = Integer.parseInt(split[1]);
        split = br.readLine().split(" ");
        arr = new int[N];
        for (int i = 0; i < N; i++)
            arr[i] = Integer.parseInt(split[i]);
        int st = 0;
        int en = Arrays.stream(arr).max().getAsInt();
        while (st < en) {
            int mid = (st + en + 1) / 2;
            if (solve(mid)) st = mid;
            else en = mid - 1;
        }
        System.out.print(st);
    }
}

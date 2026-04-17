import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    static int N, M;
    static int[] A;

    static int lower_bound(int target) {
        int st = 0;
        int en = N;
        while (st < en) {
            int mid = (st + en) / 2;
            if (A[mid] < target) st = mid + 1;
            else en = mid;
        }
        return st;
    }

    static int upper_bound(int target) {
        int st = 0;
        int en = N;
        while (st < en) {
            int mid = (st + en) / 2;
            if (A[mid] <= target) st = mid + 1;
            else en = mid;
        }
        return st;
    }

    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        String[] split = br.readLine().split(" ");
        A = new int[N];
        for (int i = 0; i < N; i++)
            A[i] = Integer.parseInt(split[i]);
        Arrays.sort(A);

        M = Integer.parseInt(br.readLine());
        split = br.readLine().split(" ");
        for (int i = 0; i < M; i++) {
            int target = Integer.parseInt(split[i]);
            int count = upper_bound(target) - lower_bound(target);
            sb.append(count).append(" ");
        }
        System.out.print(sb);
    }
}

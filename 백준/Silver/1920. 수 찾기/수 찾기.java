import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    static int[] A;
    static int N, M;

    static boolean binarySearch(int target) {
        int st = 0;
        int en = N - 1;
        while (st <= en) {
            int mid = (st + en) / 2;
            if (A[mid] > target)
                en = mid - 1;
            else if (A[mid] < target)
                st = mid + 1;
            else
                return true;
        }
        return false;
    }

    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        A = new int[N];
        String[] split = br.readLine().split(" ");
        for (int i = 0; i < N; i++)
            A[i] = Integer.parseInt(split[i]);

        Arrays.sort(A);
        M = Integer.parseInt(br.readLine());
        split = br.readLine().split(" ");
        for (int i = 0; i < M; i++) {
            int target = Integer.parseInt(split[i]);
            if (!binarySearch(target)) sb.append(0);
            else sb.append(1);
            sb.append('\n');
        }
        System.out.print(sb);
    }
}

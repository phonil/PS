import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int N, K;
    static int[] A;

    static long cut(long size) {
        long count = 0;
        for (int len : A)
            count += (len / size);
        return count;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] split = br.readLine().split(" ");
        K = Integer.parseInt(split[0]);
        N = Integer.parseInt(split[1]);

        A = new int[K];
        for (int i = 0; i < K; i++)
            A[i] = Integer.parseInt(br.readLine());

        long st = 0;
        long en = Integer.MAX_VALUE;
        while (st < en) {
            long mid = (st + en + 1) / 2;
            if (cut(mid) >= N) st = mid;
            else en = mid - 1;
        }
        System.out.print(st);
    }
}

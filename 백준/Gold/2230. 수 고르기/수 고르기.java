
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    static int N, M;
    static int[] arr;
    static int mn = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] split = br.readLine().split(" ");
        N = Integer.parseInt(split[0]);
        M = Integer.parseInt(split[1]);
        arr = new int[N];
        for (int i = 0; i < N; i++)
            arr[i] = Integer.parseInt(br.readLine());
        Arrays.sort(arr);
        int en = 0;
        for (int st = 0; st < N; st++) {
            while (en < N && arr[en] - arr[st] < M)
                en++;
            if (en == N) break;
            mn = Math.min(mn, arr[en] - arr[st]);
        }
        System.out.print(mn);
    }
}

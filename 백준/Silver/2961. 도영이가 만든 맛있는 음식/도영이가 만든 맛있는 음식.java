import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int N;
    static int[] S;
    static int[] B;
    static long diff = Long.MAX_VALUE;
    static int[] arr;

    static void func(int cur, int startIdx, int limit) {
        if (cur == limit) {
            long abs = calc();
            diff = Math.min(diff, abs);
            return;
        }

        for (int i = startIdx; i < N; i++) {
            arr[cur] = i;
            func(cur + 1, i + 1, limit);
        }
    }

    static long calc() {
        long sSum = 1;
        long bSum = 0;
        for (int i : arr) {
            sSum *= S[i];
            bSum += B[i];
        }
        return Math.abs(sSum - bSum);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        S = new int[N];
        B = new int[N];
        for (int i = 0; i < N; i++) {
            String[] split = br.readLine().split(" ");
            S[i] = Integer.parseInt(split[0]);
            B[i] = Integer.parseInt(split[1]);
        }

        for (int i = 1; i <= N; i++) {
            arr = new int[i];
            func(0, 0, i);
        }
        System.out.print(diff);
    }
}


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] split = br.readLine().split(" ");
        int N = Integer.parseInt(split[0]);
        int M = Integer.parseInt(split[1]);
        int[] a = new int[N];
        int[] b = new int[M];
        String[] lineA = br.readLine().split(" ");
        for (int j = 0; j < N; j++)
            a[j] = Integer.parseInt(lineA[j]);

        String[] lineB = br.readLine().split(" ");
        for (int j = 0; j < M; j++)
            b[j] = Integer.parseInt(lineB[j]);

        int[] tmp = new int[N + M];
        int aIdx = 0;
        int bIdx = 0;
        for (int i = 0; i < N + M; i++) {
            if (aIdx == N) tmp[i] = b[bIdx++];
            else if (bIdx == M) tmp[i] = a[aIdx++];
            else if (a[aIdx] <= b[bIdx]) tmp[i] = a[aIdx++];
            else tmp[i] = b[bIdx++];
        }
        StringBuilder sb = new StringBuilder();
        for (int i : tmp)
            sb.append(i).append(" ");
        System.out.print(sb);
    }
}

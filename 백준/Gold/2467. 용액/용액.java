import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int N;
    static int[] A;
    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        A = new int[N];
        String[] split = br.readLine().split(" ");
        for (int i = 0; i < N; i++)
            A[i] = Integer.parseInt(split[i]);

        int st = 0;
        int en = N - 1;
        int min = Integer.MAX_VALUE;
        int minA = 0;
        int minB = 0;
        while (st < en) {
            int sum = A[st] + A[en];
            if (Math.abs(sum) < min) {
                minA = A[st];
                minB = A[en];
                min = Math.abs(sum);
            }
            if (sum < 0) st++;
            else en--;
        }
        sb.append(minA).append(" ").append(minB);
        System.out.print(sb);
    }
}

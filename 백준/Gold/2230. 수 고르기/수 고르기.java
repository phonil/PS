
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    static int N, M;
    static int[] A;
    static int mn = Integer.MAX_VALUE;  // 초기 최소값 설정

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] split = br.readLine().split(" ");
        N = Integer.parseInt(split[0]);
        M = Integer.parseInt(split[1]);
        A = new int[N];
        for (int i = 0; i < N; i++)
            A[i] = Integer.parseInt(br.readLine());

        Arrays.sort(A);
        int en = 0;
        for (int st = 0; st < N; st++) {
            while (en < N && A[en] - A[st] < M) en++;
            if (en == N) break;
            mn = Math.min(mn, A[en] - A[st]);
        }
        System.out.print(mn);  // 결과 출력
    }
}


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] split = br.readLine().split(" ");
        int N = Integer.parseInt(split[0]);
        int M = Integer.parseInt(split[1]);
        int[][] rec = new int[N][M];
        // Input
        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < M; j++) {
                rec[i][j] = line.charAt(j) - '0';
            }
        }
        int mxSize = Math.min(N, M);
        int ansSize = 1;
        for (int s = 2; s <= mxSize; s++) {
            for (int i = 0; i <= N - s; i++) {
                for (int j = 0; j <= M - s; j++) {
                    if (rec[i][j] == rec[i][j + s - 1] && rec[i + s - 1][j] == rec[i + s - 1][j + s - 1] && rec[i][j + s - 1] == rec[i + s - 1][j])
                        ansSize = s;
                }
            }
        }
        System.out.print(ansSize * ansSize);
    }
}

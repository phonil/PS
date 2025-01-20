
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int N;
    static int[][] D;
    static int[] R, G, B;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        D = new int[N][3];
        R = new int[N];
        G = new int[N];
        B = new int[N];
        for (int i = 0; i < N; i++) {
            String[] line = br.readLine().split(" ");
            for (int j = 0; j < 3; j++) {
                D[i][j] = Integer.parseInt(line[j]);
            }
            R[i] = Integer.parseInt(line[0]);
            G[i] = Integer.parseInt(line[1]);
            B[i] = Integer.parseInt(line[2]);
        }
        D[0][0] = R[0];
        D[0][1] = G[0];
        D[0][2] = B[0];
        for (int i = 1; i < N; i++) {
            D[i][0] = Math.min(D[i - 1][1], D[i - 1][2]) + R[i];
            D[i][1] = Math.min(D[i - 1][0], D[i - 1][2]) + G[i];
            D[i][2] = Math.min(D[i - 1][0], D[i - 1][1]) + B[i];
        }
        int min = 1000 * 1000;
        min = Math.min(min, D[N - 1][0]);
        min = Math.min(min, D[N - 1][1]);
        min = Math.min(min, D[N - 1][2]);
        System.out.print(min);
    }
}

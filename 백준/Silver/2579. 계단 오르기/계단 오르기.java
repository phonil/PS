
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] D = new int[N + 1][3];
        int[] V = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            int num = Integer.parseInt(br.readLine());
            V[i] = num;
        }
        D[1][1] = V[1];
        for (int i = 2; i <= N; i++) {
            D[i][1] = Math.max(D[i-2][1], D[i-2][2]) + V[i];
            D[i][2] = D[i-1][1] + V[i];
        }
        System.out.print(Math.max(D[N][1], D[N][2]));
    }
}

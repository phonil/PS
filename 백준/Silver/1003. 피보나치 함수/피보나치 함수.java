
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        int[][] D = new int[41][41];
        D[0][0] = 1;
        D[1][1] = 1;
        for (int i = 2; i < 41; i++) {
            D[i][0] = D[i-1][0] + D[i-2][0];
            D[i][1] = D[i-1][1] + D[i-2][1];
        }
        while (T --> 0) {
            int N = Integer.parseInt(br.readLine());
            System.out.println(D[N][0] + " " + D[N][1]);
        }
    }
}

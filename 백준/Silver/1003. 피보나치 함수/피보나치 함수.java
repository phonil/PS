
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        int[][] d = new int[41][2];
        d[0][0] = 1;
        d[1][1] = 1;
        for (int i = 2; i < 41; i++) {
            d[i][0] = d[i - 1][0] + d[i - 2][0];
            d[i][1] = d[i - 1][1] + d[i - 2][1];
        }
        while (T-- > 0) {
            int N = Integer.parseInt(br.readLine());
            System.out.println(d[N][0] + " " + d[N][1]);
        }
    }
}

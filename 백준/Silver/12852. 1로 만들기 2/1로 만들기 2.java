
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] d = new int[N + 1][2];
        for (int i = 2; i <= N; i++) {
            d[i][0] = d[i - 1][0] + 1;
            d[i][1] = i - 1;
            if (i%2 == 0 && d[i][0] > d[i/2][0] + 1) {
                d[i][0] = d[i/2][0] + 1;
                d[i][1] = i/2;
            }
            if (i%3 == 0 && d[i][0] > d[i/3][0] + 1) {
                d[i][0] = d[i/3][0] + 1;
                d[i][1] = i/3;
            }
        }
        System.out.println(d[N][0]);
        while (true) {
            System.out.print(N + " ");
            if (N == 1) break;
            N = d[N][1];
        }

    }
}

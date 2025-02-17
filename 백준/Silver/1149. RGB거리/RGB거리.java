
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] s = new int[N + 1][3];
        for (int i = 1; i <= N; i++) {
            String[] split = br.readLine().split(" ");
            s[i][0] = Integer.parseInt(split[0]);
            s[i][1] = Integer.parseInt(split[1]);
            s[i][2] = Integer.parseInt(split[2]);
        }
        int[][] d = new int[N + 1][3];
        for (int i = 0; i < 3; i++)
            d[1][i] = s[1][i];
        for (int i = 2; i <= N; i++) {
            for (int j = 0; j < 3; j++) {
                d[i][j] = Math.min(d[i-1][(j+1) % 3], d[i-1][(j+2) % 3]) + s[i][j];
            }
        }
        int min = Math.min(d[N][0], d[N][1]);
        min = Math.min(min, d[N][2]);
        System.out.print(min);
    }
}

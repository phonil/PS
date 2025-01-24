
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] tri = new int[n + 1][n + 1];
        for (int i = 1; i <= n; i++) {
            String[] line = br.readLine().split(" ");
            for (int j = 1; j <= i; j++) {
                tri[i][j] = Integer.parseInt(line[j - 1]);
            }
        }
        int[][] d = new int[n + 1][n + 1];
        d[0][0] = 0;
        d[1][1] = tri[1][1];
        for (int i = 2; i <= n; i++) {
            d[i][1] = d[i - 1][1] + tri[i][1];
            for (int j = 2; j < i; j++)
                d[i][j] = Math.max(d[i - 1][j - 1], d[i - 1][j]) + tri[i][j];
            d[i][i] = d[i - 1][i - 1] + tri[i][i];
        }
        int max = 0;
        for (int i = 1; i <= n; i++)
            if (max < d[n][i]) max = d[n][i];
        System.out.print(max);
    }
}


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] split = br.readLine().split(" ");
        int N = Integer.parseInt(split[0]);
        int M = Integer.parseInt(split[1]);
        boolean[][] map = new boolean[N][M];
        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < M; j++) {
                if (line.charAt(j) == 'W') map[i][j] = true;
                else map[i][j] = false;
            }
        }
        int count = 64;
        for (int i = 0; i <= N - 8; i++) {
            for (int j = 0; j <= M - 8; j++) {
                boolean ans = map[i][j];
                int cnt = 0;
                for (int a = 0; a < 8; a++) {
                    for (int b = 0; b < 8; b++) {
                        if (map[i + a][j + b] != ans)
                            cnt++;
                        ans = !ans;
                    }
                    ans = !ans;
                }
                cnt = Math.min(cnt, 64 - cnt);
                count = Math.min(count, cnt);
            }
        }
        System.out.print(count);
    }
}

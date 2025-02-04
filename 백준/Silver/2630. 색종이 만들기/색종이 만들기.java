
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int N;
    static int[][] map;
    static int whiteCnt, blueCnt = 0;

    static void func(int r, int c, int k) {
        if (check(r, c, k)) {
            if (map[r][c] == 1) blueCnt++;
            else whiteCnt++;
            return;
        }

        int half = k / 2;
        func(r, c, half);
        func(r, c + half, half);
        func(r + half, c, half);
        func(r + half, c + half, half);
    }

    static boolean check(int r, int c, int k) {
        for (int i = r; i < r + k; i++) {
            for (int j = c; j < c + k; j++) {
                if (map[r][c] != map[i][j])
                    return false;
            }
        }
        return true;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        for (int i = 0; i < N; i++) {
            String[] line = br.readLine().split(" ");
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(line[j]);
            }
        }
        func(0, 0, N);
        System.out.println(whiteCnt);
        System.out.print(blueCnt);
    }
}

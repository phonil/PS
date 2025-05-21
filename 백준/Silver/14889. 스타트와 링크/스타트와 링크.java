
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int N;
    static int mn = Integer.MAX_VALUE;
    static int[][] matrix;
    static boolean[] team;
    static boolean[] isUsed;

    static void func(int cur, int idx) {
        if (cur == N / 2) {
            calc();
            return;
        }
        for (int i = idx; i <= N; i++) {
            if (isUsed[i]) continue;
            isUsed[i] = true;
            func(cur + 1, i + 1);
            isUsed[i] = false;
        }
    }

    static void calc() {
        int start = 0;
        int link = 0;
        for (int i = 1; i <= N; i++) {
            for (int j = i + 1; j <= N; j++) {
                if (isUsed[i] && isUsed[j])
                    start += matrix[i][j] + matrix[j][i];
                else if (!isUsed[i] && !isUsed[j])
                    link += matrix[i][j] + matrix[j][i];
            }
        }
        int diff = Math.abs(start - link);
        mn = Math.min(mn, diff);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // Input
        N = Integer.parseInt(br.readLine());
        matrix = new int[N + 1][N + 1];
        team = new boolean[N + 1];
        isUsed = new boolean[N + 1];
        for (int i = 1; i <= N; i++) {
            String line = br.readLine();
            String[] split = line.split(" ");
            for (int j = 1; j <= N; j++) {
                matrix[i][j] = Integer.parseInt(split[j-1]);
            }
        }
        func(0, 1);
        System.out.print(mn);
    }
}

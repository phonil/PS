
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int N, M;
    static int[][] matrix;
    static int[][] D;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] split = br.readLine().split(" ");
        N = Integer.parseInt(split[0]);
        M = Integer.parseInt(split[1]);
        matrix = new int[N+1][N+1];
        D = new int[N+1][N+1];
        for (int i = 1; i <= N; i++) {
            split = br.readLine().split(" ");
            for (int j = 1; j <= N; j++)
                matrix[i][j] = Integer.parseInt(split[j-1]);
        }

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++)
                D[i][j] = D[i][j-1] + matrix[i][j];
        }

//        for (int i = 1; i <= N; i++) {
//            int sum = 0;
//            for (int j = 1; j <= N; j++) {
//                sum += matrix[i][j];
//                D[i][j] = sum;
//            }
//        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < M; i++) {
            split = br.readLine().split(" ");
            int x1 = Integer.parseInt(split[0]);
            int y1 = Integer.parseInt(split[1]);
            int x2 = Integer.parseInt(split[2]);
            int y2 = Integer.parseInt(split[3]);
            int sum = 0;
            // 여러 줄에 걸친 경우 포함
            for (int a = x1; a <= x2; a++) {
                int lineSum = D[a][y2];
                if (y1 != 1)
                    lineSum -= D[a][y1 - 1];
                sum += lineSum;
            }
            sb.append(sum).append('\n');
        }
        System.out.print(sb);
    }
}

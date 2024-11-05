
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] split = br.readLine().split(" ");
        int N = Integer.parseInt(split[0]);
        int K = Integer.parseInt(split[1]);
        int[][] arr = new int[6][2];
        for (int i = 0; i < N; i++) {
            String[] line = br.readLine().split(" ");
            int sex = Integer.parseInt(line[0]);
            int year = Integer.parseInt(line[1]) - 1;
            arr[year][sex]++;
        }
        int cnt = 0;
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 2; j++) {
                if (arr[i][j] % K != 0) cnt += (arr[i][j] / K) + 1;
                else cnt += arr[i][j] / K;
            }
        }
        System.out.print(cnt);
    }
}

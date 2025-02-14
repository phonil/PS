
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] split = br.readLine().split(" ");
        int N = Integer.parseInt(split[0]);
        int M = Integer.parseInt(split[1]);
        String[] arr = new String[N];
        int[][] d = new int[M][4];
        for (int i = 0; i < N; i++) {
            arr[i] = br.readLine();
            for (int j = 0; j < M; j++) {
                switch (arr[i].charAt(j)) {
                    case 'A' -> d[j][0]++;
                    case 'C' -> d[j][1]++;
                    case 'G' -> d[j][2]++;
                    case 'T' -> d[j][3]++;
                }
            }
        }
        char[] ans = new char[M];
        int hamming = 0;
        for (int i = 0; i < M; i++) {
            int max = 0;
            int charIdx = 0;
            for (int j = 0; j < 4; j++) {
                if (max < d[i][j]) {
                    charIdx = j;
                    max = d[i][j];
                }
            }
            switch (charIdx) {
                case 0 -> ans[i] = 'A';
                case 1 -> ans[i] = 'C';
                case 2 -> ans[i] = 'G';
                case 3 -> ans[i] = 'T';
            }

            hamming += N - max;
        }
        System.out.println(ans);
        System.out.print(hamming);
    }
}

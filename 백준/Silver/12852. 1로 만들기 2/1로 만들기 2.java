
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] d = new int[N + 1];
        int[] ret = new int[N + 1];
        for (int i = 2; i <= N; i++) {
            d[i] = d[i - 1] + 1;
            ret[i] = i - 1;
            if (i % 2 == 0 && d[i] > d[i/2] + 1) {
                d[i] = d[i/2] + 1;
                ret[i] = i/2;
            }
            if (i % 3 == 0 && d[i] > d[i/3] + 1) {
                d[i] = d[i/3] + 1;
                ret[i] = i/3;
            }
        }
        System.out.println(d[N]);
        while (true) {
            System.out.print(N + " ");
            if (N == 1) break;
            N = ret[N];
        }
    }
}


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int N;
    static int[] freq = new int[2000001];
    static final int HALF = 1000000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(br.readLine());
            freq[num + HALF]++;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < freq.length; i++) {
            while (freq[i] != 0) {
                sb.append(i - HALF).append('\n');
                freq[i]--;
            }
        }
        System.out.print(sb);
    }
}

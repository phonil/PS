
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        boolean[] cnt = new boolean[2001];
        int HALF = 1000;
        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(br.readLine());
            cnt[num + HALF] = true;
        }
        for (int i = 0; i < 2001; i++) {
            if (cnt[i])
                System.out.println(i - HALF);
        }
    }
}


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        int N = Integer.parseInt(br.readLine());
        int ans = 0;
        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            line += line;
            if (line.contains(s)) ans++;
        }
        System.out.print(ans);
    }
}

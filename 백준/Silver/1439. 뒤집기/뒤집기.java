
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        char now = line.charAt(0);
        int zero = 0;
        int one = 0;
        if (now == '1') one++;
        else zero++;
        for (int i = 1; i < line.length(); i++) {
            char c = line.charAt(i);
            if (c == line.charAt(i - 1)) continue;
            if (c == '1') one++;
            else zero++;
        }
        System.out.print(Math.min(one, zero));
    }
}

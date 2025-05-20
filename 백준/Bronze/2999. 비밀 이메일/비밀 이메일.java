
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        int len = s.length();
        int r = 1;
        int c = len;
        for (int i = 2; i <= len / 2; i++) {
            if (len % i == 0) {
                int row = i;
                int col = len / i;
                if (row <= col) {
                    r = row;
                    c = col;
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                sb.append(s.charAt(i + (j * r)));
            }
        }
        System.out.print(sb);
    }
}
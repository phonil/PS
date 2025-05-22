
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        int[] al = new int[26];
        for (int i = 0; i < line.length(); i++) {
            char c = line.charAt(i);
            al[c - 'A']++;
        }
        int cnt = 0;
        char odd = ' ';
        for (int i = 0; i < 26; i++) {
            if (al[i] % 2 != 0) {
                cnt++;
                odd = (char) (i + 'A');
            }
        }
        StringBuilder sb = new StringBuilder();
        if (cnt > 1) sb.append("I'm Sorry Hansoo");
        else {
            for (int i = 0; i < 26; i++) {
                char c = (char) (i + 'A');

                int appdCnt = al[i] / 2;
                for (int j = 0; j < appdCnt; j++)
                    sb.append((char) (i + 'A'));
                al[i] -= appdCnt;

            }
            if (cnt == 1) {
                sb.append(odd);
                al[odd - 'A']--;
            }
            for (int i = 25; i >= 0; i--) {
                char c = (char) (i + 'A');
                for (int j = 0; j < al[i]; j++)
                    sb.append((char) (i + 'A'));
            }
        }
        System.out.print(sb);
    }
}

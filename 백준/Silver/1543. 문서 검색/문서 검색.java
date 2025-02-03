
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String docs = br.readLine();
        String word = br.readLine();
        docs = docs.replaceAll(word, "1");
        int cnt = 0;
        for (int i = 0; i < docs.length(); i++) {
            if (docs.charAt(i) == '1')
                cnt++;
        }
        System.out.print(cnt);
    }
}

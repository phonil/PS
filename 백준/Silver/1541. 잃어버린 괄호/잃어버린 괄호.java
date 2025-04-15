
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        String[] minusSplit = line.split("-");
        String s = minusSplit[0];
        String[] initSplit = s.split("\\+");
        int ans = 0;
        for (int i = 0; i < initSplit.length; i++) {
            ans += Integer.parseInt(initSplit[i]);
        }
        for (int i = 1; i < minusSplit.length; i++) {
            String[] plusSplit = minusSplit[i].split("\\+");
            for (int j = 0; j < plusSplit.length; j++)
                ans -= Integer.parseInt(plusSplit[j]);
        }
        System.out.print(ans);
    }
}

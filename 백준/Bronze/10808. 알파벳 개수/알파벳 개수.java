
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        int[] al = new int[26];
        for (int i = 0; i < line.length(); i++) {
            int idx = line.charAt(i) - 'a';
            al[idx]++;
        }
        for (int i = 0; i < al.length; i++) {
            System.out.print(al[i] + " ");
        }
    }
}

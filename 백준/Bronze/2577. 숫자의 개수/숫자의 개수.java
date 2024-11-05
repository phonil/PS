
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int A = Integer.parseInt(br.readLine());
        int B = Integer.parseInt(br.readLine());
        int C = Integer.parseInt(br.readLine());
        int mul = A * B * C;
        int[] used = new int[10];
        while (mul > 0) {
            int mod = mul % 10;
            used[mod]++;
            mul /= 10;
        }
        for (int i = 0; i < used.length; i++)
            System.out.println(used[i]);
    }
}

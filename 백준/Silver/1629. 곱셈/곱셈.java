
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static long pow(long a, long b, long m) {
        if (b == 1)
            return a % m;
        long val = pow(a, b/2, m);
        val = val * val % m;
        if (b % 2 == 0) return val;
        return val * a % m;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] split = br.readLine().split(" ");
        long A = Long.parseLong(split[0]);
        long B = Long.parseLong(split[1]);
        long C = Long.parseLong(split[2]);

        System.out.println(pow(A, B, C));
    }
}

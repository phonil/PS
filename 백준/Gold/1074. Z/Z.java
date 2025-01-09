
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static int recursion(int n, int r, int c) {
        if (n == 0) return 0;
        int half = (int) Math.pow(2, n - 1);
        if (r < half && c < half) return recursion(n - 1, r, c);
        else if (r < half && c >= half) return half * half + recursion(n - 1, r, c - half);
        else if (r >= half && c < half) return 2 * half * half + recursion(n - 1, r - half, c);
        else return 3 * half * half + recursion(n - 1, r - half, c - half);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] split = br.readLine().split(" ");
        int N = Integer.parseInt(split[0]);
        int r = Integer.parseInt(split[1]);
        int c = Integer.parseInt(split[2]);

        System.out.println(recursion(N, r, c));
    }
}

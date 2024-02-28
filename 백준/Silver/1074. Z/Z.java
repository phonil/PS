
import java.util.Scanner;

public class Main {

    public static int func(int N, int r, int c) {
        if (N == 0) // base condition
            return 0;

        int half = (int) Math.pow(2, N - 1);

        if (r < half && c < half)
            return func(N - 1, r, c);
        if (r < half && c >= half)
            return half * half + func(N - 1, r, c - half);
        if (r >= half && c < half)
            return 2 * half * half + func(N - 1, r - half, c);
        else
            return 3 * half * half + func(N - 1, r - half, c - half);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int r = sc.nextInt();
        int c = sc.nextInt();

        System.out.println(func(N, r, c));
    }
}

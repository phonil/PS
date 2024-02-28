
import java.util.Scanner;

public class Main {

    public static Long modRecursion(Long A, Long B, Long C) {
        if (B == 1)
            return A % C;

        Long val = modRecursion(A, B/2, C);
        val = val * val % C;

        if (B % 2 == 0)
            return val;
        return val * A % C;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Long A = sc.nextLong();
        Long B = sc.nextLong();
        Long C = sc.nextLong();

        System.out.println(modRecursion(A, B, C));
    }
}

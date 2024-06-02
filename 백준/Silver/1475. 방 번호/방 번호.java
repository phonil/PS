
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String N = sc.nextLine();
        int[] count = new int[9]; // 0 ~ 9

        for (int i = 0; i < N.length(); i++) {
            char c = N.charAt(i);
            if (c == '9')
                c = '6';
            count[Integer.parseInt(String.valueOf(c))]++;
        }
        count[6] = (count[6] + 1) / 2;
        int ans = 0;
        for (int i = 0; i < 9; i++) {
            if (ans < count[i])
                ans = count[i];
        }
        System.out.println(ans);
    }
}

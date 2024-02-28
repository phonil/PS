
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Main {
    public static StringBuilder sb = new StringBuilder();
    public static void func(int start, int end, int n) {
        if (n == 1) {
            sb.append(start + " " + end).append('\n');
//            System.out.println(start + " " + end);
            return;
        }
        func(start, 6 - start - end, n - 1);
        sb.append(start + " " + end).append('\n');
//        System.out.println(start + " " + end);
        func(6 - start - end, end, n - 1);

    }

    public static void main(String[] args) throws Exception {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        String s = br.readLine();
//        int n = Integer.parseInt(s);
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sb.append((int)(Math.pow(2, n) - 1)).append('\n');
//        System.out.println((int)(Math.pow(2, n) - 1));
        func(1, 3, n);
        System.out.println(sb);

    }
}

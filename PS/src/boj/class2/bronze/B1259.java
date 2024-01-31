package boj.class2.bronze;

import java.util.Scanner;

public class B1259 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String s = sc.nextLine();
        while(!s.equals("0")) {
            boolean b = true;
            int l = s.length();
            int mid = (l - 1) / 2;
            for (int i = 0; i <= mid; i++) {
                if (s.charAt(i) != s.charAt(l - 1 - i)) {
                    b = false;
                    break;
                }
            }
            if (b)
                System.out.println("yes");
            else
                System.out.println("no");
            s = sc.nextLine();
        }
    }
}

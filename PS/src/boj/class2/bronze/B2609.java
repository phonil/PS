package boj.class2.bronze;

import java.util.Scanner;

public class B2609 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int a = sc.nextInt();
        int b = sc.nextInt();

        int min = 0;
        if (a > b)
            min = b;
        else
            min = a;

        int gcd = 1;
        int lcm = 1;
        int i = 2;
        int a2 = a;
        int b2 = b;
        while (i <= min) {
            if(a2 % i == 0 && b2 % i == 0) {
                gcd *= i;
                a2 /= i;
                b2 /= i;
                continue;
            }
            i++;
        }

        lcm = gcd * a / gcd * b / gcd;
        System.out.println(gcd);
        System.out.println(lcm);
    }
}

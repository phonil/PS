package boj.class2;

import java.util.Scanner;

public class B15829 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int L = sc.nextInt();
        sc.nextLine();
        String s = sc.nextLine();

        long sum = 0;
        long pow = 1;

        for (int i = 0; i < L; i++) {
            sum += ((s.charAt(i) - 96) * pow) ;
            pow = (pow * 31) % 1234567891;
        }

        System.out.println(sum % 1234567891);


    }
}

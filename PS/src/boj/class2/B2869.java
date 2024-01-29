package boj.class2;

import java.util.Scanner;

public class B2869 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int a = sc.nextInt();
        int b = sc.nextInt();
        int v = sc.nextInt();

        int result = (v - a) / (a - b);

        if ((v - a) % (a - b) == 0) {
            System.out.println(result + 1);
        } else {
            System.out.println(result + 2);
        }

    }

}
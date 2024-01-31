package boj.class2.bronze;

import java.util.Scanner;

public class B4153 {

    private static final String RIGHT = "right";
    private static final String WRONG = "wrong";

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        while(true) {

            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();

            // 0 0 0 을 입력받으면 종료
            if(a == 0 && b == 0 && c == 0)
                break;

            if (c*c == (b*b + a*a))
                System.out.println(RIGHT);
            else if (b*b == (c*c + a*a))
                System.out.println(RIGHT);
            else if (a*a == (c*c + b*b))
                System.out.println(RIGHT);
            else
                System.out.println(WRONG);

        }

    }
}

package boj.class2.silver;

import java.util.Scanner;

public class S2839 {

//    Scanner sc = new Scanner(System.in);
//    int sugar = sc.nextInt();
//
//    int count = 0;
//        while(sugar > 0) {
//        if(sugar % 5 == 0) {
//            count += sugar / 5;
//            System.out.println(count);
//            return ;
//        }
//        if(sugar < 3) {
//            System.out.println(-1);
//            return ;
//        }
//        sugar-=3;
//        count++;
//    }
//
//        System.out.println(count);

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int ans = 0;

        while (N >= 0) {
            if (N % 5 == 0) {
                ans += N / 5;
                break;
            }
            if (N < 3) {
                ans = -1;
                break;
            }
            N -= 3;
            ans++;
        }
        System.out.println(ans);
    }
}

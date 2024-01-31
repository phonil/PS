package boj.class2.silver;

import java.util.Scanner;
import java.util.Stack;

public class S9012 {

    // 1번 풀이 - Stack 사용 x
//    for (int i = 0; i < T; i++) {
//        String s = sc.nextLine();
//        String ans = "YES";
//        int count = 0;
//        for (int j = 0; j < s.length(); j++) {
//            if (s.charAt(j) == '(')
//                count++;
//            else
//                count--;
//
//            if (count < 0)
//                break;
//
//        }
//        if (count != 0)
//            ans = "NO";
//        System.out.println(ans);
//    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();
        sc.nextLine();

        // 2번 풀이 - Stack 사용
        for (int i = 0; i < T; i++) {
            String s = sc.nextLine();
            Stack<Character> stack = new Stack<>();
            String ans = "YES";
            for (int j = 0; j < s.length(); j++) {
                if (s.charAt(j) == '(')
                    stack.push(s.charAt(j));
                else {
                    if (stack.isEmpty()) {
                        ans = "NO";
                        break;
                    }
                    stack.pop();
                }
            }
            if (!stack.isEmpty())
                ans = "NO";
            System.out.println(ans);
        }

    }
}

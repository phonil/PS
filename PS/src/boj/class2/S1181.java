package boj.class2;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class S1181 {


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        sc.nextLine();

        String[] arr = new String[N];

        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextLine();
        }
        Arrays.sort(arr, new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                if (s1.length() == s2.length())
                    // 단어 길이가 같을 경우 compareTo()로 사전순 정렬
                    return s1.compareTo(s2);
                else
                    return s1.length() - s2.length();
            }
        });

        System.out.println(arr[0]);

        for (int i = 1; i < N; i++) {
            // 중복되지 않는 단어만 출력
            if (!arr[i].equals(arr[i - 1])) {
                System.out.println(arr[i]);
            }
        }

    }
}

package boj.class2.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class S2751 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        boolean[] arr = new boolean[2000001];

        for(int i = 0; i < N; i++) {
            int a = Integer.parseInt(br.readLine());
            arr[a + 1000000] = true;
        }

        for (int i = 0; i < arr.length; i++) {
            if (arr[i])
                sb.append((i - 1000000)).append('\n');
        }
        System.out.print(sb);
    }
}

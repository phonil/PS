package boj.class2.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class S1929 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        boolean[] arr = new boolean[N + 1];
        Arrays.fill(arr, true);
        arr[0] = false;
        arr[1] = false;

        for (int i = 2; i <= N; i++) {
            if (!arr[i])
                continue;

            for (int j = i + i; j < arr.length; j += i) {
                // j = i + i :: i의 첫번째 배수 (i * 2)
                // j += i :: 배수만큼 증가
                arr[j] = false;
            }
        }
        for (int i = M; i <= N; i++) {
            if (arr[i])
                sb.append(i + "\n");
        }
        System.out.print(sb);
    }
}

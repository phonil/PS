package boj.class2.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class S18110 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(arr);

        int cut = (int) Math.round(n * 0.15);
        int left = cut;
        int right = n - cut;

        int sum = 0;
        for (int i = left; i < right; i++) {
            sum += arr[i];
        }

        int result = (int) Math.round((double) sum / (n - cut * 2));
        System.out.println(result);
    }
}

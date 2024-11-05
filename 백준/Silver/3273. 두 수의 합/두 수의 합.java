
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        int ans = 0;

        int[] arr = new int[n];
        String[] split = br.readLine().split(" ");
        for (int i = 0; i < n; i++)
            arr[i] = Integer.parseInt(split[i]);
        int x = Integer.parseInt(br.readLine());

        Stack<Integer> st = new Stack<>();
        boolean[] occur = new boolean[2000001];

        for (int i = 0; i < n; i++) {
            if (x - arr[i] > 0 && occur[x - arr[i]])
                ans++;
            occur[arr[i]] = true;
        }
        System.out.println(ans);
    }
}

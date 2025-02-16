
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[2000001];
        int HALF = 1000000;
        for (int i = 0; i < N; i++)
            arr[Integer.parseInt(br.readLine()) + HALF]++;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < arr.length; i++) {
            while (arr[i] != 0) {
                sb.append(i - HALF).append('\n');
                arr[i]--;
            }
        }
        System.out.print(sb);
    }
}

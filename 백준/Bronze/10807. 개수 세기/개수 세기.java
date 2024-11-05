
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int arr[] = new int[N];
        String[] split = br.readLine().split(" ");
        for (int i = 0; i < split.length; i++)
            arr[i] = Integer.parseInt(split[i]);
        int v = Integer.parseInt(br.readLine());
        int cnt = 0;
        for (int i : arr)
            if (i == v) cnt++;

        System.out.print(cnt);
    }
}

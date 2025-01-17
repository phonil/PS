
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        boolean[] arr = new boolean[2002];
        int half = 1000;
        for (int i = 0; i < N; i++)
            arr[Integer.parseInt(br.readLine()) + half] = true;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i])
                System.out.println(i - half);
        }
    }
}

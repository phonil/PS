
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] A = new int[N];
        int[] B = new int[N];
        String[] line = br.readLine().split(" ");
        for (int i = 0; i < N; i++)
            A[i] = Integer.parseInt(line[i]);
        Arrays.sort(A);
        line = br.readLine().split(" ");
        for (int i = 0; i < N; i++)
            B[i] = Integer.parseInt(line[i]);
        Arrays.sort(B);
        int S = 0;
        for (int i = 0; i < N; i++)
            S += A[i] * B[N-1-i];
        System.out.print(S);
    }
}

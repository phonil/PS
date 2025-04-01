
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {

    static int N, M;
    static int[] A, B;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] split = br.readLine().split(" ");
        N = Integer.parseInt(split[0]);
        A = new int[N];
        M = Integer.parseInt(split[1]);
        B = new int[M];

        String[] line = br.readLine().split(" ");
        for (int i = 0; i < N; i++)
            A[i] = Integer.parseInt(line[i]);

        line = br.readLine().split(" ");
        for (int i = 0; i < M; i++)
            B[i] = Integer.parseInt(line[i]);
        Arrays.sort(B);
        Arrays.sort(A);
        ArrayList<Integer> ans = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            if (Arrays.binarySearch(B, A[i]) >= 0) continue;
            ans.add(A[i]);
        }

        System.out.println(ans.size());
        for (Integer an : ans)
            System.out.print(an + " ");
        }
}

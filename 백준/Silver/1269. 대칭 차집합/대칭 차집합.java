
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] split = br.readLine().split(" ");
        int N = Integer.parseInt(split[0]);
        int M = Integer.parseInt(split[1]);
        Set<Integer> A = new HashSet<>();
        Set<Integer> B = new HashSet<>();
        split = br.readLine().split(" ");
        for (int i = 0; i < N; i++)
            A.add(Integer.parseInt(split[i]));
        split = br.readLine().split(" ");
        for (int i = 0; i < M; i++)
            B.add(Integer.parseInt(split[i]));
        A.retainAll(B);
        System.out.print(N + M - 2 * A.size());
    }
}

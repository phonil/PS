
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
        Set<String> A = new HashSet<>();
        for (int i = 0; i < N; i++)
            A.add(br.readLine());
        Set<String> B = new HashSet<>();
        for (int i = 0; i < N; i++)
            B.add(br.readLine());
        A.retainAll(B);
        System.out.println(A.size());
        A.stream().sorted().forEach(System.out::println);
    }
}

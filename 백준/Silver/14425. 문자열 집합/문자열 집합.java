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
        Set<String> set = new HashSet<>();
        for (int i = 0; i < N; i++)
            set.add(br.readLine());
        int cnt = 0;
        for (int i = 0; i < M; i++) {
            String line = br.readLine();
            if (set.contains(line))
                cnt++;
        }
        System.out.print(cnt);
    }
}

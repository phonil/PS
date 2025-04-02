
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashSet;
import java.util.Set;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] split = br.readLine().split(" ");
        int K = Integer.parseInt(split[0]);
        int L = Integer.parseInt(split[1]);
        Set<String> set = new LinkedHashSet<>();
        for (int i = 0; i < L; i++) {
            String line = br.readLine();
            if (set.contains(line))
                set.remove(line);
            set.add(line);
        }
        for (String line : set) {
            if (K == 0)
                break;
            System.out.println(line);
            K--;
        }
    }
}

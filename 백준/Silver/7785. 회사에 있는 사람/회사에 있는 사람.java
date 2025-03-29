
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Set<String> set = new HashSet<>();
        for (int i = 0; i < N; i++) {
            String[] split = br.readLine().split(" ");
            if (split[1].equals("enter"))
                set.add(split[0]);
            else
                set.remove(split[0]);
        }
        set.stream().sorted(Comparator.reverseOrder()).forEach(System.out::println);
    }
}

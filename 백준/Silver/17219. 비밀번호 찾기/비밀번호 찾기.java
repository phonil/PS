
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] split = br.readLine().split(" ");
        int N = Integer.parseInt(split[0]);
        int M = Integer.parseInt(split[1]);
        Map<String, String> map = new HashMap<>();
        for (int i = 0; i < N; i++) {
            split = br.readLine().split(" ");
            map.put(split[0], split[1]);
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < M; i++) {
            String line = br.readLine();
            sb.append(map.get(line)).append('\n');
        }
        System.out.print(sb);
    }
}

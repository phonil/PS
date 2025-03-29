
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String[] split = br.readLine().split(" ");
        int N = Integer.parseInt(split[0]);
        int M = Integer.parseInt(split[1]);
        List<String> arr = new ArrayList<>();
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            arr.add(line);
            map.put(line, i + 1);
        }

        for (int i = 0; i < M; i++) {
            String line = br.readLine();
            char c = line.charAt(0);
            if (c - '0' >= 0 && c - '9' <= 0)
                sb.append(arr.get(Integer.parseInt(line) - 1)).append('\n');
            else
                sb.append(map.get(line)).append('\n');
        }
        System.out.print(sb);
    }
}

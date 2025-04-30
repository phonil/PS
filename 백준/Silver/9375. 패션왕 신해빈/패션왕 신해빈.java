import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Set;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            HashMap<String, Integer> map = new HashMap<>();
            int N = Integer.parseInt(br.readLine());
            for (int j = 0; j < N; j++) {
                String[] split = br.readLine().split(" ");
                String key = split[1];
                if (map.containsKey(key))
                    map.put(key, map.get(key) + 1);
                else
                    map.put(key, 2);
            }
            int sum = 1;
            for (String s : map.keySet()) {
                int cnt = map.get(s);
                sum *= cnt;
            }
            System.out.println(sum - 1);
        }
    }
}

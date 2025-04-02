
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.TreeMap;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        while (T --> 0) {
            TreeMap<Integer, Integer> map = new TreeMap<>();
            int k = Integer.parseInt(br.readLine());
            for (int i = 0; i < k; i++) {
                String[] split = br.readLine().split(" ");
                String operator = split[0];
                int num = Integer.parseInt(split[1]);
                if (operator.equals("I"))
                    map.put(num, map.getOrDefault(num, 0) + 1);
                else {
                    if (map.isEmpty())
                        continue;
                    if (num == -1) {
                        if (map.get(map.firstKey()) == 1) map.remove(map.firstKey());
                        else map.put(map.firstKey(), map.get(map.firstKey()) - 1);
                    }
                    else {
                        if (map.get(map.lastKey()) == 1) map.remove(map.lastKey());
                        else map.put(map.lastKey(), map.get(map.lastKey()) - 1);
                    }
                }
            }
            if (map.isEmpty())
                sb.append("EMPTY").append('\n');
            else
                sb.append(map.lastKey()).append(" ").append(map.firstKey()).append('\n');
        }
        System.out.print(sb);
    }
}

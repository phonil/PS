
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.NavigableMap;
import java.util.TreeMap;
import java.util.TreeSet;

public class Main {

    static int N, M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        // <난이도, 문제번호집합>
        TreeMap<Integer, TreeSet<Integer>> map = new TreeMap<>();
        for (int i = 1; i <= 100; i++)
            map.put(i, new TreeSet<>());

        while (N --> 0) {
            String[] split = br.readLine().split(" ");
            int P = Integer.parseInt(split[0]);
            int L = Integer.parseInt(split[1]);
            TreeSet<Integer> set = map.get(L);
            set.add(P);
        }
        M = Integer.parseInt(br.readLine());
        while (M --> 0) {
            String[] split = br.readLine().split(" ");
            String oper = split[0];
            switch (oper) {
                case "add" -> {
                    int P = Integer.parseInt(split[1]);
                    int L = Integer.parseInt(split[2]);
                    TreeSet<Integer> set = map.get(L);
                    set.add(P);
                }
                case "solved" -> {
                    int P = Integer.parseInt(split[1]);
                    for (Map.Entry<Integer, TreeSet<Integer>> treeSetEntry : map.entrySet()) {
                        TreeSet<Integer> value = treeSetEntry.getValue();
                        if (value.contains(P)) {
                            value.remove(P);
                            break;
                        }
                    }
                }
                case "recommend" -> {
                    int x = Integer.parseInt(split[1]);
                    if (x == 1) {
                        NavigableMap<Integer, TreeSet<Integer>> navigableMap = map.descendingMap();
                        for (TreeSet<Integer> set : navigableMap.values()) {
                            if (set.isEmpty()) continue;
                            Integer last = set.last();
                            System.out.println(last);
                            break;
                        }
                    } else {
                        for (TreeSet<Integer> set : map.values()) {
                            if (set.isEmpty()) continue;
                            Integer first = set.first();
                            System.out.println(first);
                            break;
                        }
                    }
                }
            }
        }
    }
}


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class Main {

    static int vertex;
    static int edge;
    static ArrayList<Integer>[] adj;
    static boolean[] visit;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        vertex = Integer.parseInt(br.readLine());
        edge = Integer.parseInt(br.readLine());
        adj = new ArrayList[vertex + 1];
        visit = new boolean[vertex + 1];
        for (int i = 1; i <= vertex; i++)
            adj[i] = new ArrayList<>();
        for (int i = 0; i < edge; i++) {
            String[] split = br.readLine().split(" ");
            int u = Integer.parseInt(split[0]);
            int v = Integer.parseInt(split[1]);
            adj[u].add(v);
            adj[v].add(u);
        }
        Set<Integer> set = new HashSet<>();
        for (Integer i : adj[1]) {
            set.add(i);
            for (Integer integer : adj[i])
                set.add(integer);
        }
        set.remove(1);
        System.out.print(set.size());
    }
}

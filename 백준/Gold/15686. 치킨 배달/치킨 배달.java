import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static int N, M;
    public static List<Pair> chicken, house;
    public static int[][] city;
    public static boolean[] visited;
    public static int response = Integer.MAX_VALUE;

    public static void func(int start, int cnt) {
        if (cnt == M) {
            int cityDist = 0;
            for (Pair home : house) {
                int chickDist = Integer.MAX_VALUE;
                for (int i = 0; i < chicken.size(); i++) {
                    if (!visited[i]) continue;
                    Pair chick = chicken.get(i);
                    int dist = Math.abs(home.x - chick.x) + Math.abs(home.y - chick.y);
                    chickDist = Math.min(chickDist, dist);
                }
                cityDist += chickDist;
            }
            response = Math.min(response, cityDist);
            return;
        }
        for (int i = start; i < chicken.size(); i++) {
            visited[i] = true;
            func(i + 1, cnt + 1);
            visited[i] = false;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] split = br.readLine().split(" ");
        chicken = new ArrayList<>();
        house = new ArrayList<>();
        N = Integer.parseInt(split[0]);
        M = Integer.parseInt(split[1]);
        city = new int[N][N];
        for (int i = 0; i < N; i++) {
            String[] line = br.readLine().split(" ");
            for (int j = 0; j < N; j++) {
                int num = Integer.parseInt(line[j]);
                city[i][j] = num;
                if (num == 0) continue;
                else if (num == 1) house.add(new Pair(i, j));
                else if (num == 2) chicken.add(new Pair(i, j));
            }
        }
        visited = new boolean[chicken.size()];
        func(0, 0);
        System.out.print(response);
    }
}

class Pair {
    int x,y;
    public Pair(int x,int y) {
        this.x=x;
        this.y=y;
    }
}
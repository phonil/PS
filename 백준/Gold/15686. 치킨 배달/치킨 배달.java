
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {

    static int N, M;
    static int[][] city;
    static ArrayList<Pair> house = new ArrayList<>();
    static ArrayList<Pair> chicken = new ArrayList<>();
    static int[] arr;
    static boolean[] visit;
    static int mn = Integer.MAX_VALUE;

    static void func(int cur) {
        if (cur == M) {
            int cityDist = 0;
            for (int i = 0; i < house.size(); i++) {
                Pair home = house.get(i);
                int dist = Integer.MAX_VALUE;
                for (int chickIdx : arr) {
                    Pair chick = chicken.get(chickIdx);
                    dist = Math.min(Math.abs(home.x - chick.x) + Math.abs(home.y - chick.y), dist);
                }
                cityDist += dist;
            }
            mn = Math.min(cityDist, mn);
            return;
        }

        int startIdx = 0;
        if (cur != 0)
            startIdx = arr[cur - 1];
        for (int i = startIdx; i < chicken.size(); i++) {
            if (visit[i]) continue;
            arr[cur] = i;
            visit[i] = true;
            func(cur + 1);
            visit[i] = false;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] split = br.readLine().split(" ");
        N = Integer.parseInt(split[0]);
        M = Integer.parseInt(split[1]);
        city = new int[N][N];
        for (int i = 0; i < N; i++) {
            String[] line = br.readLine().split(" ");
            for (int j = 0; j < N; j++) {
                int num = Integer.parseInt(line[j]);
                city[i][j] = num;
                if (num == 1)
                    house.add(new Pair(i, j));
                else if (num == 2)
                    chicken.add(new Pair(i, j));
            }
        }
        arr = new int[M];
        visit = new boolean[chicken.size()];
        func(0);
        System.out.print(mn);
    }

    static class Pair {
        int x, y;
        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}

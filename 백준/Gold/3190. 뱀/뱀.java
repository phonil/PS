
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N, K, L;
    static int[][] arr;
    static boolean[][] apple;
    static int time = 0;
    static int dir;
    static Deque<Pair> dq = new ArrayDeque<>();
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    static boolean bound(int nx, int ny) {
        return nx < 0 || ny < 0 || nx >= N || ny >= N;
    }

    static boolean body(int nx, int ny) {
        Pair pair = new Pair(nx, ny);
        return dq.contains(pair);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N][N];

        apple = new boolean[N][N];
        K = Integer.parseInt(br.readLine());
        for (int i = 0; i < K; i++) {
            String[] split = br.readLine().split(" ");
            int r = Integer.parseInt(split[0]);
            int c = Integer.parseInt(split[1]);
            apple[r-1][c-1] = true;
        }

        TreeMap<Integer, String> map = new TreeMap<>();
        L = Integer.parseInt(br.readLine());
        for (int i = 0; i < L; i++) {
            String[] split = br.readLine().split(" ");
            int x = Integer.parseInt(split[0]);
            String s = split[1];
            map.put(x, s);
        }

        dir = 1;
        dq.offer(new Pair(0, 0));
        while (true) {
            time++;
            Pair head = dq.getLast();
            int nx = head.x + dx[dir];
            int ny = head.y + dy[dir];
            if (bound(nx, ny)) break;
            if (body(nx, ny)) break;
            dq.offer(new Pair(nx, ny));

            if (apple[nx][ny])
                apple[nx][ny] = false;
            else
                dq.pollFirst();

            if (map.isEmpty() || map.firstKey() != time) continue;
            String newDir = map.get(map.firstKey());
            if (newDir.equals("D")) dir = (dir + 1) % 4;
            else dir = (dir + 3) % 4;
            map.remove(map.firstKey());
        }
        System.out.print(time);
    }

    static class Pair {
        int x, y;
        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public boolean equals(Object object) {
            if (this == object) return true;
            if (object == null || getClass() != object.getClass()) return false;
            Pair pair = (Pair) object;
            return x == pair.x && y == pair.y;
        }
    }
}

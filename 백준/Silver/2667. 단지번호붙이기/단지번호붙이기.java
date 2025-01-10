
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] map = new int[N][N];
        boolean[][] visit = new boolean[N][N];
        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < N; j++) {
                map[i][j] = line.charAt(j) - '0';
            }
        }
        int cnt = 0;
        ArrayList<Integer> ansArr = new ArrayList<>();
        Queue<Pair> q = new LinkedList<>();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (map[i][j] == 0 || visit[i][j]) continue;
                q.offer(new Pair(i, j));
                visit[i][j] = true;
                int area = 1;
                cnt++;
                while (!q.isEmpty()) {
                    Pair cur = q.poll();
                    for (int k = 0; k < 4; k++) {
                        int nx = cur.x + dx[k];
                        int ny = cur.y + dy[k];
                        if (nx < 0 || ny < 0 || nx >= N || ny >= N) continue;
                        if (visit[nx][ny] || map[nx][ny] == 0) continue;
                        q.offer(new Pair(nx, ny));
                        visit[nx][ny] = true;
                        area++;
                    }
                }
                ansArr.add(area);
            }
        }
        Collections.sort(ansArr);
        System.out.println(cnt);
        for (Integer i : ansArr)
            System.out.println(i);
    }
    static class Pair {
        int x, y;
        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}

package boj.baaaarkingdog.problem.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class S2178 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int count = 0;
        int max = 0;

        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, -1, 0, 1};
        int[][] dist = new int[n][m]; // 거리 및 방문여부 포함
        int[][] arr = new int[n][m];
        Queue<Pair> queue = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            for(int j=0; j < m; j++) {
                dist[i][j] = -1; // -1 -> not visited
                arr[i][j] = s.charAt(j) - '0';
            }
        }

        dist[0][0] = 0;
        queue.offer(new Pair(0, 0));
        while (!queue.isEmpty()) {
            Pair pair = queue.poll();
            for (int i = 0; i < 4; i++) {
                int nx = pair.x + dx[i];
                int ny = pair.y + dy[i];

                if (nx < 0 || ny < 0 || nx >= n || ny >= m)
                    continue;
                if (dist[nx][ny] != -1 || arr[nx][ny] != 1)
                    continue;

                dist[nx][ny] = dist[pair.x][pair.y] + 1;
                queue.offer(new Pair(nx, ny));
            }
        }
        System.out.println(dist[n - 1][m - 1] + 1);

    }

    // pair
    static class Pair {
        int x, y;

        public Pair(int x, int y){
            this.x = x;
            this.y = y;
        }

        public int getX(){
            return x;
        }

        public int getY(){
            return y;
        }

        public void setX(int x){
            this.x = x;
        }

        public void setY(int y){
            this.y = y;
        }
    }
}

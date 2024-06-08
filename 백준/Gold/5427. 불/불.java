import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, -1, 0, 1};
        int T = Integer.parseInt(br.readLine());
        while (T --> 0) {
            int count = 0;
            String[] split = br.readLine().split(" ");
            int w = Integer.parseInt(split[0]); // 너비
            int h = Integer.parseInt(split[1]); // 높이
            char[][] board = new char[h][w];
            int[][] dist1 = new int[h][w]; // 뷸
            int[][] dist2 = new int[h][w]; // 상근
            Queue<Pair> queue1 = new LinkedList<>(); // 불
            Queue<Pair> queue2 = new LinkedList<>(); // 상근
            for (int i = 0; i < h; i++) {
                String s = br.readLine();
                for (int j = 0; j < w; j++) {
                    char c = s.charAt(j);
                    board[i][j] = c;
                    if (c == '.') {
                        dist1[i][j] = -1;
                        dist2[i][j] = -1;
                    }
                    if (c == '*') queue1.offer(new Pair(i, j));
                    if (c == '@') queue2.offer(new Pair(i, j));
                }
            }

            // 불 BFD
            while (!queue1.isEmpty()) {
                Pair cur = queue1.poll();
                for (int i = 0; i < 4; i++) {
                    int nx = cur.x + dx[i];
                    int ny = cur.y + dy[i];
                    if (nx < 0 || ny < 0 || nx >= h || ny >= w)
                        continue;
                    if (dist1[nx][ny] != -1)
                        continue;
                    queue1.offer(new Pair(nx, ny));
                    dist1[nx][ny] = dist1[cur.x][cur.y] + 1;
                }
            }
            String ans = "";
            // 상근이 BFS
            all: while (!queue2.isEmpty()) {
                Pair cur = queue2.poll();
                for (int i = 0; i < 4; i++) {
                    int nx = cur.x + dx[i];
                    int ny = cur.y + dy[i];
                    if (nx < 0 || ny < 0 || nx >= h || ny >= w) {
                        ans = Integer.toString(dist2[cur.x][cur.y] + 1);
                        break all;
                    }
                    if (dist2[nx][ny] != -1)
                        continue;
                    if (dist1[nx][ny] != -1 && dist2[cur.x][cur.y] + 1 >= dist1[nx][ny])
                        continue;
                    queue2.offer(new Pair(nx, ny));
                    dist2[nx][ny] = dist2[cur.x][cur.y] + 1;
                }
            }
            if (ans.equals(""))
                ans = "IMPOSSIBLE";
            System.out.println(ans);
        }
    }

    static class Pair {
        int x, y;
        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}

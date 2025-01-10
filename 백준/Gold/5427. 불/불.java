
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        while (T --> 0) {
            String[] split = br.readLine().split(" ");
            int w = Integer.parseInt(split[0]);
            int h = Integer.parseInt(split[1]);
            int[][] fireDist = new int[h][w];
            int[][] manDist = new int[h][w];
            Queue<Pair> fireQ = new LinkedList<>();
            Queue<Pair> manQ = new LinkedList<>();
            for (int i = 0; i < h; i++) {
                String line = br.readLine();
                for (int j = 0; j < w; j++) {
                    char c = line.charAt(j);
                    if (c == '.') {
                        fireDist[i][j] = -1;
                        manDist[i][j] = -1;
                    } else if (c == '@') {
                        manQ.offer(new Pair(i, j));
                    } else if (c == '*') {
                        fireQ.offer(new Pair(i, j));
                    }
                }
            }
            // 불 BFS
            while (!fireQ.isEmpty()) {
                Pair cur = fireQ.poll();
                for (int i = 0; i < 4; i++) {
                    int nx = cur.x + dx[i];
                    int ny = cur.y + dy[i];
                    if (nx < 0 || ny < 0 || nx >= h || ny >= w) continue;
                    if (fireDist[nx][ny] >= 0) continue;
                    fireQ.offer(new Pair(nx, ny));
                    fireDist[nx][ny] = fireDist[cur.x][cur.y] + 1;
                }
            }
            // 상근이 BFS
            String ans = "";
            all: while (!manQ.isEmpty()) {
                Pair cur = manQ.poll();
                for (int i = 0; i < 4; i++) {
                    int nx = cur.x + dx[i];
                    int ny = cur.y + dy[i];
                    if (nx < 0 || ny < 0 || nx >= h || ny >= w) {
                        ans = Integer.toString(manDist[cur.x][cur.y] + 1);
                        break all;
                    }
                    if (manDist[nx][ny] >= 0 ) continue;
                    if (fireDist[nx][ny] != -1 && fireDist[nx][ny] <= manDist[cur.x][cur.y] + 1) continue;
                    manQ.offer(new Pair(nx, ny));
                    manDist[nx][ny] = manDist[cur.x][cur.y] + 1;
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

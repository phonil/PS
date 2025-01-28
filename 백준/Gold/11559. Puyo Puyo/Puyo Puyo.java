
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

    static boolean[][] visit;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    static boolean bound(int nx, int ny) {
        return nx < 0 || ny < 0 || nx >= 12 || ny >= 6;
    }

    static void swap(char[][] map, int x1, int y1, int x2, int y2) {
        char tmp = map[x1][y1];
        map[x1][y1] = map[x2][y2];
        map[x2][y2] = tmp;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[][] map = new char[12][6];
        for (int i = 0; i < 12; i++) {
            String line = br.readLine();
            for (int j = 0; j < 6; j++) {
                char c = line.charAt(j);
                map[i][j] = c;
            }
        }

        int chainCnt = 0;
        while (true) {
            boolean flag = false;
            Queue<Pair> q = new LinkedList<>();
            visit = new boolean[12][6];
            for (int i = 0; i < 12; i++) {
                for (int j = 0; j < 6; j++) {
                    if (visit[i][j] || map[i][j] == '.') continue;
                    ArrayList<Pair> chain = new ArrayList<>();
                    chain.add(new Pair(i, j));
                    q.offer(new Pair(i, j));
                    visit[i][j] = true;
                    int cnt = 1;
                    while (!q.isEmpty()) {
                        Pair cur = q.poll();
                        for (int k = 0; k < 4; k++) {
                            int nx = cur.x + dx[k];
                            int ny = cur.y + dy[k];
                            if (bound(nx, ny)) continue;
                            if (map[nx][ny] != map[cur.x][cur.y]) continue;
                            if (visit[nx][ny]) continue;
                            chain.add(new Pair(nx, ny));
                            q.offer(new Pair(nx, ny));
                            visit[nx][ny] = true;
                            cnt++;
                        }
                    }
                    if (cnt >= 4) {
                        flag = true;
                        for (Pair pair : chain)
                            map[pair.x][pair.y] = '.';
                    }

                }
            }
            if (!flag)
                break;
            for (int i = 0; i < 6; i++) {
                for (int j = 10; j >= 0; j--) {
                    int tmp = j;
                    while (tmp < 11 && map[tmp + 1][i] == '.') {
                        swap(map, tmp, i, tmp + 1, i);
                        tmp++;
                    }
                }
            }
            chainCnt++;
        }
        System.out.print(chainCnt);

    }
    static class Pair {
        int x, y;
        Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}

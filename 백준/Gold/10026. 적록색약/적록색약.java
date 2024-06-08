
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int normal = 0;
        int blind = 0;
        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, -1, 0, 1};

        int N = Integer.parseInt(br.readLine());
        char[][] color = new char[N][N];
        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            for (int j = 0; j < N; j++)
                color[i][j] = s.charAt(j);
        }
        boolean[][] visitN = new boolean[N][N];
        boolean[][] visitB = new boolean[N][N];

        Queue<Pair> qN = new LinkedList<>();
        Queue<Pair> qB = new LinkedList<>();

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (visitN[i][j]) continue; // Blind의 경우가 더 많은 탐색을 한 번에 함. 따라서 Normal이 더 널널하므로 여기서 먼저 검사해도 ㅇㅋ
                qN.offer(new Pair(i, j));
                visitN[i][j] = true;
                while (!qN.isEmpty()) {
                    Pair cur = qN.poll();
                    for (int k = 0; k < 4; k++) {
                        int nx = cur.x + dx[k];
                        int ny = cur.y + dy[k];
                        if (nx < 0 || ny < 0 || nx >= N || ny >= N) continue;
                        if (visitN[nx][ny] || color[nx][ny] != color[cur.x][cur.y]) continue;
                        qN.offer(new Pair(nx, ny));
                        visitN[nx][ny] = true;
                    }
                }
                normal++;
                
                if (visitB[i][j]) continue;
                qB.offer(new Pair(i, j));
                visitB[i][j] = true;
                while (!qB.isEmpty()) {
                    Pair cur = qB.poll();
                    for (int k = 0; k < 4; k++) {
                        int nx = cur.x + dx[k];
                        int ny = cur.y + dy[k];
                        if (nx < 0 || ny < 0 || nx >= N || ny >= N) continue;
                        if (visitB[nx][ny]) continue;
                        // R & B / G & B / B & !B 이면 continue
                        if (color[cur.x][cur.y] != 'B' && color[nx][ny] == 'B') continue;
                        if (color[cur.x][cur.y] == 'B' && color[nx][ny] != 'B') continue;
                        qB.offer(new Pair(nx, ny));
                        visitB[nx][ny] = true;
                    }
                }
                blind++;
            }
        }
        System.out.println(normal + " " + blind);

    }

    static class Pair {
        int x, y;
        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}

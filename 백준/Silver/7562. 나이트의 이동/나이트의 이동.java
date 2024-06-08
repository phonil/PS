
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] dx = {-2, -1, 1, 2, 2, 1, -1, -2};
        int[] dy = {-1, -2, -2, -1, 1, 2, 2, 1};

        int T = Integer.parseInt(br.readLine());
        while (T --> 0) {
            int I = Integer.parseInt(br.readLine());
            int[][] board = new int[I][I];

            String[] night = br.readLine().split(" ");
            int nightX = Integer.parseInt(night[0]);
            int nightY = Integer.parseInt(night[1]);
            String[] dst = br.readLine().split(" ");
            int dstX = Integer.parseInt(dst[0]);
            int dstY = Integer.parseInt(dst[1]);
            Queue<Pair> q = new LinkedList<>();
            for (int i = 0; i < I; i++) {
                for (int j = 0; j < I; j++)
                    board[i][j] = -1;
            }
            q.offer(new Pair(nightX, nightY));
            board[nightX][nightY] = 0;

            while (!q.isEmpty()) {
                Pair cur = q.poll();
                for (int i = 0; i < 8; i++) {
                    int nx = cur.x + dx[i];
                    int ny = cur.y + dy[i];
                    if (nx >= I || ny >= I || nx < 0 || ny < 0) continue;
                    if (board[nx][ny] != -1) continue;
                    q.offer(new Pair(nx, ny));
                    board[nx][ny] = board[cur.x][cur.y] + 1;
                }
            }
            System.out.println(board[dstX][dstY]);
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

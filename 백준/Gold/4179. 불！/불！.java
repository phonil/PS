
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, -1, 0, 1};
        int R = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        char[][] board = new char[R][C];
        int[][] distF = new int[R][C]; // 불
        int[][] distJ = new int[R][C]; // 지훈

        for (int i = 0; i < R; i++) {
            String s = br.readLine();
            for (int j = 0; j < s.length(); j++) {
                char c = s.charAt(j);
                board[i][j] = c;
                distF[i][j] = -1;
                distJ[i][j] = -1;
            }
        }
        Queue<Pair> qF = new LinkedList<>();
        Queue<Pair> qJ = new LinkedList<>();
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                char c = board[i][j];
                if (c == 'F')  {
                    distF[i][j] = 0;
                    qF.offer(new Pair(i, j));
                }
                if (c == 'J') {
                    distJ[i][j] = 0;
                    qJ.offer(new Pair(i, j));
                }
            }
        }

        while (!qF.isEmpty()) {
            Pair cur = qF.poll();
            for (int i = 0; i < 4; i++) {
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];
                if (nx >= R || ny >= C || nx < 0 || ny < 0) continue;
                if (distF[nx][ny] != -1 || board[nx][ny] == '#') continue; // 이미 방문 || 벽
                qF.offer(new Pair(nx, ny));
                distF[nx][ny] = distF[cur.x][cur.y] + 1;
            }
        }

        while (!qJ.isEmpty()) {
            Pair cur = qJ.poll();
            for (int i = 0; i < 4; i++) {
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];
                if (nx >= R || ny >= C || nx < 0 || ny < 0) {
                    System.out.println(distJ[cur.x][cur.y] + 1);
                    return;
                }
                if (distF[nx][ny] != -1 && distF[nx][ny] <= distJ[cur.x][cur.y] + 1) continue;
                if (distJ[nx][ny] != -1 || board[nx][ny] == '#') continue; // 이미 방문 || 벽
                qJ.offer(new Pair(nx, ny));
                distJ[nx][ny] = distJ[cur.x][cur.y] + 1;
            }
        }

        System.out.println("IMPOSSIBLE ");

    }
}

class Pair {
    int x, y;

    public Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

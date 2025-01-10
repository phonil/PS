
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
        String[] split = br.readLine().split(" ");
        int M = Integer.parseInt(split[0]);
        int N = Integer.parseInt(split[1]);
        int K = Integer.parseInt(split[2]);
        int[][] board = new int[M + 1][N + 1];
        while (K --> 0) {
            String[] line = br.readLine().split(" ");
            int startRow = Integer.parseInt(line[0]);
            int startColumn = Integer.parseInt(line[1]);
            int endRow = Integer.parseInt(line[2]);
            int endColumn = Integer.parseInt(line[3]);
            for (int i = startColumn; i < endColumn; i++) {
                for (int j = startRow; j < endRow; j++) {
                    if (board[i][j] == 0) board[i][j]++;
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        Queue<Pair> q = new LinkedList<>();
        int areaCnt = 0;
        ArrayList<Integer> ansArr = new ArrayList<>();
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (board[i][j] != 0) continue;
                q.offer(new Pair(i, j));
                board[i][j]++;
                areaCnt++;
                int area = 1;
                while (!q.isEmpty()) {
                    Pair cur = q.poll();
                    for (int k = 0; k < 4; k++) {
                        int nx = cur.x + dx[k];
                        int ny = cur.y + dy[k];
                        if (nx < 0 || ny < 0 || nx >= M || ny >= N) continue;
                        if (board[nx][ny] != 0) continue;
                        q.offer(new Pair(nx, ny));
                        board[nx][ny] = board[cur.x][cur.y] + 1;
                        area++;
                    }
                }
                ansArr.add(area);
            }
        }
        System.out.println(areaCnt);
        Collections.sort(ansArr);
        for (Integer i : ansArr) 
            System.out.print(i + " ");
    }

    static class Pair {
        int x, y;
        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

    /*
    빨간색 - 초록색 구분 o / x 경우 각각 구역 구하기
    구역 - BFS
     */

    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        char[][] grid = new char[N][N];
        boolean[][] visitNormal = new boolean[N][N];
        boolean[][] visitBlind = new boolean[N][N];
        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < N; j++) {
                grid[i][j] = line.charAt(j);
            }
        }

        Queue<Pair> queueNormal = new LinkedList<>();
        Queue<Pair> queueBlind = new LinkedList<>();
        int normalCnt = 0;
        int blindCnt = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                // 일반 사람
                if (visitNormal[i][j]) continue; // 한 for문에서 normal과 blind 모두에게 영향이 가는 continue임. normal의 경우가 cnt가 더 많다(visitxxx[][] == true일 경우가 적다는 소리) 따라서 normal 먼저 해야함.
                queueNormal.offer(new Pair(i, j));
                visitNormal[i][j] = true;
                normalCnt++;
                while (!queueNormal.isEmpty()) {
                    Pair cur = queueNormal.poll();
                    for (int k = 0; k < 4; k++) {
                        int nx = cur.x + dx[k];
                        int ny = cur.y + dy[k];
                        if (nx < 0 || ny < 0 || nx >= N || ny >= N) continue;
                        if (visitNormal[nx][ny] || grid[nx][ny] != grid[cur.x][cur.y]) continue;
                        queueNormal.offer(new Pair(nx, ny));
                        visitNormal[nx][ny] = true;
                    }
                }

                // 적록색약
                if (visitBlind[i][j]) continue;
                queueBlind.offer(new Pair(i, j));
                visitBlind[i][j] = true;
                blindCnt++;
                while (!queueBlind.isEmpty()) {
                    Pair cur = queueBlind.poll();
                    for (int k = 0; k < 4; k++) {
                        int nx = cur.x + dx[k];
                        int ny = cur.y + dy[k];
                        if (nx < 0 || ny < 0 || nx >= N || ny >= N) continue;
                        if (visitBlind[nx][ny]) continue;
                        if (grid[cur.x][cur.y] != 'B' && grid[nx][ny] == 'B') continue;
                        if (grid[cur.x][cur.y] == 'B' && grid[nx][ny] != 'B') continue;
                        queueBlind.offer(new Pair(nx, ny));
                        visitBlind[nx][ny] = true;
                    }
                }
            }
        }
        System.out.print(normalCnt + " " + blindCnt);
    }
    static class Pair {
        int x, y;
        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}



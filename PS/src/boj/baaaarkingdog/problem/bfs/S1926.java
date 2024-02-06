package boj.baaaarkingdog.problem.bfs;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class S1926 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); // 세로
        int m = sc.nextInt(); // 가로

        int count = 0;
        int max = 0;

        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, -1, 0, 1};
        boolean[][] visit = new boolean[n][m];
        int[][] arr = new int[n][m];
        Queue<Pair> queue = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                visit[i][j] = false;
                arr[i][j] = sc.nextInt();
            }
        }

        for (int i = 0; i < n; i++) { // 그림 개수 위한 이중 loop / i, j는 시작 가능 판단 점(그림 가능 여부)
            for (int j = 0; j < m; j++) {
                int area = 0;
                if (!visit[i][j] && arr[i][j] == 1) {
                    queue.offer(new Pair(i, j));
                    visit[i][j] = true;
                    count++;
                    area++;
                }

                while (!queue.isEmpty()) {
                    Pair pair = queue.poll();
                    for (int k = 0; k < 4; k++) {
                        int nx = pair.x + dx[k];
                        int ny = pair.y + dy[k];

                        if (nx < 0 || ny < 0 || nx >= n || ny >= m)
                            continue;
                        if (visit[nx][ny] || arr[nx][ny] != 1)
                            continue;

                        queue.offer(new Pair(nx, ny));
                        visit[nx][ny] = true;
                        area++;
                    }
                }

                if (max < area)
                    max = area;
            }
        }
        System.out.println(count);
        System.out.println(max);

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

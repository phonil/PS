package boj.baaaarkingdog.problem.bfs;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class G7576 {

//    answer
//    Scanner sc = new Scanner(System.in);
//    int m = sc.nextInt(); // 세로
//    int n = sc.nextInt(); // 가로
//    int[] dx = {-1, 0, 1, 0};
//    int[] dy = {0, -1, 0, 1};
//    int[][] dist = new int[n][m];
//    int[][] arr = new int[n][m];
//    Queue<Pair> queue = new LinkedList<>();
//
//        for (int i = 0; i < n; i++) {
//        for (int j = 0; j < m; j++) {
//            arr[i][j] = sc.nextInt();
//            if (arr[i][j] == 1)
//                queue.offer(new Pair(i, j));
//            if (arr[i][j] == 0)
//                dist[i][j] = -1;
//        }
//    }
//        while (!queue.isEmpty()) {
//        Pair pair = queue.poll();
//        for (int i = 0; i < 4; i++) {
//            int nx = pair.x + dx[i];
//            int ny = pair.y + dy[i];
//            if (nx < 0 || ny < 0 || nx >= n || ny >= m)
//                continue;
//            if (dist[nx][ny] >= 0)
//                continue;
//
//            dist[nx][ny] = dist[pair.x][pair.y] + 1;
//            queue.offer(new Pair(nx, ny));
//        }
//    }
//    int ans = 0;
//    all: for (int i = 0; i < n; i++) {
//        for (int j = 0; j < m; j++) {
//            if (dist[i][j] == -1) { // 종료 조건 - 안익은 토마토 있을 경우..!
//                ans = -1;
//                break all;
//            }
//            if (ans < dist[i][j])
//                ans = dist[i][j];
//        }
//    }
//        System.out.println(ans);

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt(); // 세로
        int n = sc.nextInt(); // 가로
        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, -1, 0, 1};
        int[][] dist = new int[n][m];
        int[][] arr = new int[n][m];
        Queue<Pair> queue = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                arr[i][j] = sc.nextInt();
                if (arr[i][j] == 1)
                    queue.offer(new Pair(i, j));
                if (arr[i][j] == 0)
                    dist[i][j] = -1;
            }
        }

        // 구현
        while (!queue.isEmpty()) {
            Pair pair = queue.poll();
            for (int i = 0; i < 4; i++) {
                int nx = pair.x + dx[i];
                int ny = pair.y + dy[i];
                if (nx < 0 || ny < 0 || nx >= n || ny >= m)
                    continue;
                if (dist[nx][ny] >= 0)
                    continue;

                dist[nx][ny] = dist[pair.x][pair.y] + 1;
                queue.offer(new Pair(nx, ny));
            }
        }

        int ans = 0;
        all: for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (dist[i][j] == -1) {
                    ans = -1;
                    break all;
                }
                if (ans < dist[i][j])
                    ans = dist[i][j];
            }
        }
        System.out.println(ans);

    }

    // pair
    static class Pair {
        int x, y;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}

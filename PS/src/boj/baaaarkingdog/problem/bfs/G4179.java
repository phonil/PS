package boj.baaaarkingdog.problem.bfs;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class G4179 {

//    // Answer
//    Scanner sc = new Scanner(System.in);
//
//    int R = sc.nextInt();
//    int C = sc.nextInt();
//        sc.nextLine();
//
//    int[] dx = {-1, 0, 1, 0};
//    int[] dy = {0, -1, 0, 1};
//    char[][] maze = new char[R][C];
//    int[][] dist1 = new int[R][C]; // 불 전파 시간
//    int[][] dist2 = new int[R][C]; // 지훈이 이동 시간
//    Queue<Pair> queue1 = new LinkedList<>(); // 불 큐
//    Queue<Pair> queue2 = new LinkedList<>(); // 지훈이 큐
//
//        for (int i = 0; i < R; i++) {
//        String s = sc.nextLine();
//        for (int j = 0; j < C; j++) {
//            maze[i][j] = s.charAt(j);
//            dist1[i][j] = -1;
//            dist2[i][j] = -1;
//        }
//    }
//
//        for (int i = 0; i < R; i++) {
//        for (int j = 0; j < C; j++) {
//            if (maze[i][j] == 'F') {
//                queue1.offer(new Pair(i, j));
//                dist1[i][j] = 0;
//            }
//            if (maze[i][j] == 'J') {
//                queue2.offer(new Pair(i, j));
//                dist2[i][j] = 0;
//            }
//        }
//    }
//
//    // 불의 BFS
//        while (!queue1.isEmpty()) {
//        Pair pair = queue1.poll();
//        for (int i = 0; i < 4; i++) {
//            int nx = pair.x + dx[i];
//            int ny = pair.y + dy[i];
//            if (nx < 0 || ny < 0 || nx >= R || ny >= C)
//                continue;
//            if (maze[nx][ny] == '#' || dist1[nx][ny] >= 0)
//                continue;
//            dist1[nx][ny] = dist1[pair.x][pair.y] + 1;
//            queue1.offer(new Pair(nx, ny));
//        }
//    }
//    // 지훈이의 BFS
//        while (!queue2.isEmpty()) {
//        Pair pair = queue2.poll();
//        for (int i = 0; i < 4; i++) {
//            int nx = pair.x + dx[i];
//            int ny = pair.y + dy[i];
//            if (nx < 0 || ny < 0 || nx >= R || ny >= C) { // 범위 밖 -> 탈출 성공
//                System.out.println(dist2[pair.x][pair.y] + 1);
//                return;
//            }
//            if (maze[nx][ny] == '#' || dist2[nx][ny] >= 0)
//                continue;
//            if (dist1[nx][ny] != -1 && dist1[nx][ny] <= dist2[pair.x][pair.y] + 1)
//                continue;
//            dist2[nx][ny] = dist2[pair.x][pair.y] + 1;
//            queue2.offer(new Pair(nx, ny));
//        }
//    }
//        System.out.println("IMPOSSIBLE");

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int R = sc.nextInt();
        int C = sc.nextInt();
        sc.nextLine();

        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, -1, 0, 1};
        char[][] maze = new char[R][C];
        int[][] dist1 = new int[R][C]; // 불 전파 시간
        int[][] dist2 = new int[R][C]; // 지훈이 이동 시간
        Queue<Pair> queue1 = new LinkedList<>(); // 불 큐
        Queue<Pair> queue2 = new LinkedList<>(); // 지훈이 큐
        
        for (int i = 0; i < R; i++) {
            String s = sc.nextLine();
            for (int j = 0; j < C; j++) {
                maze[i][j] = s.charAt(j);
                dist1[i][j] = -1;
                dist2[i][j] = -1;
            }
        }

        // 구현

        // Queue, dist Fill

        // 불 DFS

        // 지훈 BFS
    }

    // Pair
    static class Pair {
        int x, y;
        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}


import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, -1, 0, 1};
        int[][] map = new int[N][N];

        int max = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                map[i][j] = sc.nextInt();
                if (max < map[i][j])
                    max = map[i][j];
            }
        }
        int[] countArr = new int[max]; // 다 잠기는 건 할 필요 없음
        for (int i = 0; i < max; i++) {
            Queue<Pair> queue = new LinkedList<>();
            boolean[][] visit = new boolean[N][N];
            // start loop
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < N; k++) {
                    if (map[j][k] <= i)
                        continue;
                    if (visit[j][k])
                        continue;

                    queue.offer(new Pair(j, k));
                    visit[j][k] = true;

                    while (!queue.isEmpty()) {
                        Pair pair = queue.poll();
                        for (int l = 0; l < 4; l++) {
                            int nx = pair.x + dx[l];
                            int ny = pair.y + dy[l];
                            if (nx < 0 || ny < 0 || nx >= N || ny >= N)
                                continue;
                            if (visit[nx][ny])
                                continue;
                            if (map[nx][ny] <= i)
                                continue;

                            queue.offer(new Pair(nx, ny));
                            visit[nx][ny] = true;
                        }
                    }
                    countArr[i]++;
                }
            }
        }
        int result = 0;
        for (int count : countArr) {
            if (result < count)
                result = count;
        }
        System.out.println(result);

    }

    static class Pair {
        int x, y;
        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}

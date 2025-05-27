import java.util.*;

class Solution {
    
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int[][] dist;
    static int N, M;
    
    static boolean bound(int nx, int ny) {
        return nx < 0 || ny < 0 || nx >= N || ny >= M;
    }
    
    public int solution(int[][] maps) {
        int answer = 0;
        N = maps.length;
        M = maps[0].length;
        dist = new int[N][M];
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                if(maps[i][j] == 1)
                    dist[i][j] = -1;
            }
        }
        Queue<Pair> q = new LinkedList<>();
        q.offer(new Pair(0, 0));
        dist[0][0] = 1;
        while(!q.isEmpty()) {
            Pair cur = q.poll();
            for(int i = 0; i < 4; i++) {
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];
                if(bound(nx, ny)) continue;
                if(dist[nx][ny] != -1) continue;
                q.offer(new Pair(nx, ny));
                dist[nx][ny] = dist[cur.x][cur.y] + 1;
            }
        }
        answer = dist[N - 1][M - 1];
        return answer;
    }
    
    static class Pair {
        int x, y;
        public Pair (int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
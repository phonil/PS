import java.util.*;

class Solution {
    
    static int answer = 0;
    static int N;
    static boolean[] visit;
    static int K;
    
    static void func(int cur, int f, int cnt, int[][] dungeons) {
        if(cur == N) {
            answer = Math.max(answer, cnt);
            return;
        }
        for(int i = 0; i < N; i++) {
            if(visit[i]) continue;
            int dungeonSF = dungeons[i][0];
            int dungeonNF = dungeons[i][1];
            int nowF = K - f;
            if(nowF < dungeonSF) 
                func(cur + 1, f + dungeonNF, cnt, dungeons);
            else {
                visit[i] = true;
                func(cur + 1, f + dungeonNF, cnt + 1, dungeons);
                visit[i] = false;
            }
        }
    }
    
    public int solution(int k, int[][] dungeons) {
        K = k;
        N = dungeons.length;
        visit = new boolean[N];
        func(0, 0, 0, dungeons);
        
        return answer;
    }
}
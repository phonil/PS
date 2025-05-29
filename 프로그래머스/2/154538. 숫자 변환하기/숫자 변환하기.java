import java.util.*;

class Solution {
    public int solution(int x, int y, int n) {
        /*
        Goal : x -> y
        - x += n
        - x *= 2
        - x *= 3
        y / x => 몇을 곱할 수 있는지
        y % x => 몇을 더할 수 있는지
        
        체크 조건
        1. (y - x) % n == 0
            -> o : 가능
            -> x : 현재는 덧셈 사용 불가능 -> return -1
        2. y % x != 0 && (y % x) % n != 0 -> 안됨
        
        y / x 의 몫이 2 or 3으로 나누어 떨어지는가?
            -> only 2 : x *= 2
            -> only 3 : x *= 3
            -> both 2 and 3 : x *= 6, answer++
        ...
        
        위처럼 수학적으로 접근 -> 넘 복잡
        알고리즘 적용하기
        마침 풀어본 것 같은 느낌
        BFS or DP
        
        1. 1차원 배열 BFS 
            int arr[y + 1];
            init 
                q first -> x
                
            q.poll
            dx[] -> {n, 2, 3};
        */
        int[] arr = new int[y + 1]; // 각 idx별 필요 연산 횟수, bfs -> 최소 연산
        int[] dist = new int[y + 1]; // 연산 횟수, 초기 -1(!= -1 : visited)
        int[] dx = {n, 2, 3};
        Arrays.fill(dist, -1);
        Queue<Integer> q = new LinkedList<>();
        q.offer(x);
        dist[x] = 0;
        while(!q.isEmpty()) {
            Integer cur = q.poll();
            for(int i = 0; i < 3; i++) {
                int nx = cur;
                if(i == 0)
                    nx += n;
                else
                    nx *= dx[i];
                if(nx < 0 || nx > y) continue;
                if(dist[nx] != -1) continue;
                q.offer(nx);
                dist[nx] = dist[cur] + 1;
            }
        }
        return dist[y];
    }
}
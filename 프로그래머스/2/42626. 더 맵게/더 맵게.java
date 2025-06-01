import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i : scoville)
            pq.offer(i);
        while(pq.size() > 1) {
            int min = pq.poll();
            if(min >= K)
                break;
            int second = pq.poll();
            int mix = min + (second * 2);
            pq.offer(mix);
            answer++;
        }
        if(pq.poll() < K)
            answer = -1;
        return answer;
        
//         int answer = 0;
//         // 최소 힙 -> 0. init : pq.add -> 1. loop true -> 2. check pq.poll < K -> 3. calc with poll2 -> 4. offer 
//         PriorityQueue<Integer> pq = new PriorityQueue<>();
//         for(int i : scoville)
//             pq.offer(i);
        
//         while(pq.peek() < K) {
//             if(pq.size() == 1) {
//                 answer = -1;
//                 break;
//             }
//             int min = pq.poll();
//             int secMin = pq.poll();
//             int calc = min + 2 * secMin;
//             pq.offer(calc);
//             answer++;
//         }
//         return answer;
    }
}
import java.util.*;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        // 시간 단위로 돌릴 것인지(idx 필요), 트럭 단위로 돌릴 것인지(idx는 loop variable로 가능)
        // 트럭 단위 -> 다리에서 하나 빼는 타이밍 신경쓸 것

        // 트럭 단위
        // int answer = 0;
        // Queue<Integer> q = new LinkedList<>();
        // int now = 0;
        // for(int i = 0; i < bridge_length - 1; i++) 
        //     q.offer(0);
        // for(int truck : truck_weights) {
        //     while(now + truck > weight) {
        //         q.offer(0);
        //         now -= q.poll();
        //         answer++;
        //     }
        //     q.offer(truck);
        //     now += truck;
        //     now -= q.poll();
        //     answer++;
        // }
        // return answer + bridge_length;
        
        // 시간 단위
        int answer = 0;
        Queue<Integer> q = new LinkedList<>();
        int now = 0;
        for(int i = 0; i < bridge_length; i++) 
            q.offer(0);
        int idx = 0;
        while(idx < truck_weights.length) {
            answer++;
            int over = q.poll();
            now -= over;
            int truck = truck_weights[idx];
            if (now + truck > weight) 
                q.offer(0);
            else {
                q.offer(truck);
                now += truck;
                idx++;
            }
        }
        return answer + bridge_length;
        
        
        
        
        
        
        
        
        
        
        // int answer = 1;
        // Queue<Integer> q = new LinkedList<>();
        // for(int i = 0; i < bridge_length - 1; i++) {
        //     q.offer(0);
        // }
        // q.offer(truck_weights[0]);
        // int w = truck_weights[0];
        // int idx = 1;
        // while(idx < truck_weights.length) {
        //     answer++;
        //     w -= q.poll();
        //     int truck = truck_weights[idx];
        //     if(w + truck <= weight) {
        //         q.offer(truck);
        //         w += truck;
        //         idx++;
        //     } else 
        //         q.offer(0);
        // }
        // return answer + q.size();
    }
}
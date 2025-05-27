import java.util.*;

class Solution {
    public int solution(int[] priorities, int location) {
        int answer = 0;
        /*
        Queue 2개
        q1 : process priority Queue
        q2 : process index Queue
        
        Priority Queue 1개 : 우선순위 판별 : 최대힙
        loop
            answer++;
            poll = q1.poll
            idx = q2.poll
            if(pq.peek() == poll)
                if(location == idx)
                    break;
                pq.poll
            else
                q1.offer(poll)
                q2.offer(idx)
        */
        Queue<Integer> processQ = new LinkedList<>();
        Queue<Integer> idxQ = new LinkedList<>();
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for(int i = 0; i < priorities.length; i++) {
            processQ.offer(priorities[i]);
            idxQ.offer(i);
            pq.offer(priorities[i]);
        }
        
        while(true) {
            int poll = processQ.poll();
            int idx = idxQ.poll();
            if(pq.peek() == poll) {
                answer++;
                if(location == idx)
                    break;
                pq.poll();
            } else {
                processQ.offer(poll);
                idxQ.offer(idx);
            }
        }
        return answer;
    }
}
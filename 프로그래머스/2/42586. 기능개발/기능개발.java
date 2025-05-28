import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        ArrayList<Integer> list = new ArrayList<>(); // 정답 담는 배열
        
        int len = progresses.length;
        Queue<Integer> q = new LinkedList<>(); // 남은 날짜 담는 큐
        for(int i = 0; i < len; i++) {
            int progress = progresses[i];
            int speed = speeds[i];
            int day = (100 - progress) / speed;
            if((100 - progress) % speed != 0)
                day++;
            if(!q.isEmpty() && q.peek() < day) {
                list.add(q.size());
                q.clear();
            }
            q.offer(day);
        }
        list.add(q.size());
        
        
//         int len = progresses.length;
//         int[] leasts = new int[len];
//         int[] needs = new int[len];
//         Stack<Integer> st = new Stack<>();
        
//         Queue<Integer> q = new LinkedList<>();
//         for(int i = 0; i < len; i++) {
//             leasts[i] = 100 - progresses[i];
//             needs[i] = leasts[i] / speeds[i];
//             if(leasts[i] % speeds[i] != 0)
//                 needs[i]++;
//             q.offer(needs[i]);
//         }
//         Integer poll = q.poll();
//         int cnt = 1;
//         while(!q.isEmpty()) {
//             if(poll >= q.peek()) {
//                 q.poll();
//                 cnt++;
//             } else {
//                 list.add(cnt);
//                 cnt = 1;
//                 poll = q.poll();
//             }
//             if(q.isEmpty()) {
//                 list.add(cnt);
//                 break;
//             }
//         }
        int[] answer = new int[list.size()];
        for(int i = 0; i < list.size(); i++) 
            answer[i] = list.get(i);
        return answer;
    }
}
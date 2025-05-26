import java.util.*;

class Solution {
    public int solution(int cacheSize, String[] cities) {
        int answer = 0;
        /*
        Queue q
        loop i : 0 -> cities.length
            if(q.isEmpty)
                answer += 5;
                q.offer(cities[i])
                continue;
                
            if(q.contains(cities[i]))
                answer++;
                continue;
                
            if(q.size != cacheSize)
                answer += 5;
                q.offer(cities[i]);
                continue;
            
            if(q.size == cacheSize)
                answer += 5;
                q.poll();
                q.offer(cities[i]);
        */
        if (cacheSize == 0)
            return 5 * cities.length;
        
        Queue<String> q = new LinkedList<>();
        for(int i = 0; i < cities.length; i++) {
            String city = cities[i];
            city = city.toLowerCase();
            if(q.isEmpty() || !q.contains(city)) {
                answer += 5;
                q.offer(city);
                if(q.size() > cacheSize)
                    q.poll();
            } else {
                // LRU 처리 필요 !!
                // LRU : 가장 오랫동안 '사용되지 않은' 것부터 제거 
                // -> 큐 중간에 있어도 사용되면 최신화 해줘야 함
                q.remove(city);
                q.offer(city);
                answer++;
            }
                
        }
        return answer;
    }
}
import java.util.*;

class Solution {
    public int solution(int[] topping) {
        int answer = 0;
        Set<Integer> set = new HashSet<>();
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < topping.length; i++) {
            int top = topping[i];
            map.put(top, map.getOrDefault(top, 0) + 1);
        }
            
        for(int i = 0; i < topping.length; i++) {
            int top = topping[i];
            set.add(top);
            map.put(top, map.get(top) - 1);
            if(map.get(top) == 0)
                map.remove(top);
            if(set.size() == map.size())
                answer++;
        }
        return answer;
        
        
        
        
        
        
        
        
        
        
        
        
        // 무조건 시간초과 풀이..
        // Set<Integer> set1 = new HashSet<>();
        // Set<Integer> set2 = new HashSet<>();
        // for(int i = 1; i < topping.length; i++) {
        //     for(int j = 0; j < i; j++) 
        //         set1.add(topping[j]);
        //     for(int j = i; j < topping.length; j++) 
        //         set2.add(topping[j]);
        //     if(set1.size() == set2.size())
        //         answer++;
        // }
        
        // // <요소, 개수>
        // Map<Integer, Integer> map1 = new HashMap<>();
        // Map<Integer, Integer> map2 = new HashMap<>();
        // int N = topping.length;
        // for(int i = 0; i < N; i++) 
        //     map2.put(topping[i], map2.getOrDefault(topping[i], 0) + 1);
        // for(int i = 0; i < N; i++) {
        //     int top = topping[i];
        //     map1.put(top, map1.getOrDefault(top, 0) + 1);
        //     map2.put(top, map2.get(top) - 1);
        //     if(map2.get(top) == 0)
        //         map2.remove(top);
        //     if(map1.size() == map2.size())
        //         answer++;
        // }
        // return answer;
    }
}
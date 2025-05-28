import java.util.*;

class Solution {
    
    static Set<String> set = new HashSet<>();
    static char[] ca = new char[5];
    static char[] mo = {'A', 'E', 'I', 'O', 'U', ' '};
        
    static void func(int cur) {
        if(cur == 5) {
            String s = new String(ca).trim();
            set.add(s.replaceAll(" ", ""));
            return;
        }
        for(int i = 0; i < 6; i++) {
            ca[cur] = mo[i];
            func(cur + 1); 
        }
    }
    
    public int solution(String word) {
        int answer = 0;
        func(0);
        List<String> list = new ArrayList<>();
        for(String a : set)
            list.add(a);
        Collections.sort(list);
        answer = list.indexOf(word);
        return answer;
    }
}
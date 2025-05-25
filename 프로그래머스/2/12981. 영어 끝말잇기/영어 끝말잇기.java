import java.util.*;

class Solution {
    public int[] solution(int n, String[] words) {
        int[] answer = new int[2];
        Set<String> set = new HashSet<>();
        int len = words.length;
        set.add(words[0]);
        for(int i = 1; i < len; i++) {
            char before = words[i - 1].charAt(words[i - 1].length() - 1);
            char now = words[i].charAt(0);
            
            if(set.contains(words[i]) || now != before) {
                // 탈락
                int idx = i + 1;
                int num = (i % n) + 1;
                int ord = idx / n;
                if(idx % n != 0)
                    ord++;
                answer[0] = num;
                answer[1] = ord;
                break;
            } 
            set.add(words[i]);
        }
        return answer;
    }
}
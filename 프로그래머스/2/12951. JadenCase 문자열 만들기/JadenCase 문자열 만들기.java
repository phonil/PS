import java.util.*;

class Solution {
    public String solution(String s) {
        StringBuilder sb = new StringBuilder();
        boolean isStart = true;
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(isStart)
                sb.append(Character.toUpperCase(c));
            else
                sb.append(Character.toLowerCase(c));
            if(c == ' ')
                isStart = true;
            else
                isStart = false;
        }
        return sb.toString();       
        
        // StringBuilder sb = new StringBuilder();
        // boolean isStart = true;
        // for(char c : s.toCharArray()) {
        //     if(isStart)
        //         sb.append(Character.toUpperCase(c));
        //     else
        //         sb.append(Character.toLowerCase(c));
        //     if(c == ' ')
        //         isStart = true;
        //     else
        //         isStart = false;
        // }
        // return sb.toString();
    }
}
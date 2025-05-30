import java.util.*;

class Solution {
    public int solution(String s) {
        /*
        peek == c
            -> pop
        peek != c
            -> push
        */
        Stack<Character> st = new Stack<>();
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(st.isEmpty() || st.peek() != c)
                st.push(c);
            else
                st.pop();
        }
        return st.isEmpty() ? 1 : 0;
    }
}
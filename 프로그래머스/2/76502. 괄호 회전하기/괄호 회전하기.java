import java.util.*;

class Solution {
    
    static boolean check(String s) {
        Stack<Character> st = new Stack<>();
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(!st.isEmpty()) {
                if(st.peek() == '(' && c == ')') st.pop();
                else if(st.peek() == '[' && c == ']') st.pop();
                else if(st.peek() == '{' && c == '}') st.pop();
                else st.push(c);
            } else {
                st.push(c);
            }
        }
        return st.isEmpty();
    }
    
    public int solution(String s) {
        int answer = 0;
        for(int i = 0; i < s.length(); i++) {
            String rotated = s.substring(i) + s.substring(0, i);
            if(check(rotated)) answer++;
        }
        return answer;
//         char[] cs = s.toCharArray();
//         for(int a = 0; a < cs.length - 1; a++) {
//             Stack<Character> st = new Stack<>();
//             boolean cnt = true;
//             // 괄호 check
//             for(int i = 0; i < cs.length; i++) {
//                 boolean flag = true;
//                 char c = cs[i];
//                 switch (c) {
//                     case '[', '(', '{' -> st.push(c);
//                     case ']' -> {
//                         if(st.isEmpty() || st.peek() != '[') {
//                             flag = false;
//                             break;
//                         }
//                         st.pop();
//                     }
//                     case ')' -> {
//                         if(st.isEmpty() || st.peek() != '(') {
//                             flag = false;
//                             break;
//                         }
//                         st.pop();
//                     }
//                     case '}' -> {
//                         if(st.isEmpty() || st.peek() != '{') {
//                             flag = false;
//                             break;
//                         }
//                         st.pop();
//                     }
//                 }
//                 if(!flag) {
//                     cnt = false;
//                     break;
//                 }
//             }
//             if(cnt && st.isEmpty())
//                 answer++;
//             // 회전
//             for(int i = 0; i < cs.length - 1; i++) {
//                 char tmp = cs[i];
//                 cs[i] = cs[i + 1];
//                 cs[i + 1] = tmp;
//             }
//         }

//         return answer;
    }
}
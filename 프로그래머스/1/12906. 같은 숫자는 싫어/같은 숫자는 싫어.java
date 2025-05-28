import java.util.*;

public class Solution {
    public int[] solution(int []arr) {
        Stack<Integer> st = new Stack<>();
        for(int i = arr.length - 1; i >= 0; i--) {
            if(!st.isEmpty() && st.peek() == arr[i])
                continue;
            st.push(arr[i]);
        }
        int[] answer = new int[st.size()];
        int idx = 0;
        while(!st.isEmpty())
            answer[idx++] = st.pop();
        return answer;
    }
}
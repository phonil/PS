import java.util.*;

class Solution {
    public int solution(int[] order) {
        int len = order.length;
        boolean[] checked = new boolean[len + 1];
        Stack<Integer> st = new Stack<>();
        for(int i = 0; i < len; i++) {
            int boxOrder = order[i];
            if(!st.isEmpty() && st.peek() - 1 > boxOrder) {
                boolean flag = false;
                for(int j = boxOrder + 1; j < st.peek(); j++) {
                    if(!checked[j]) {
                        flag = true;
                        break;
                    }
                }
                if(flag)
                    break;
            }
            st.push(boxOrder);
            checked[boxOrder] = true;
        }
        return st.size();
    }
}
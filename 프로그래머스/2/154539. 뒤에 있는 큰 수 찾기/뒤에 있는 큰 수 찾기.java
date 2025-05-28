import java.util.*;

class Solution {
    public int[] solution(int[] numbers) {
        /*
        while !isEmpty and peek <= number
            -> st.pop()
            
        if(isEmpty)
            -> ansSt.push(-1)
        else if(peek > number)
            -> ansSt.push(peek)
        st.push(number)
        */
        Stack<Integer> st = new Stack<>();
        Stack<Integer> ansSt = new Stack<>();
        for(int i = numbers.length - 1; i >= 0; i--) {
            int number = numbers[i];
            while(!st.isEmpty() && st.peek() <= number)
                st.pop();
            if(st.isEmpty())
                ansSt.push(-1);
            else if(st.peek() > number)
                ansSt.push(st.peek());
            st.push(number);
        }
        int[] answer = new int[ansSt.size()];
        for(int i = 0; i < answer.length; i++) 
            answer[i] = ansSt.pop();
        return answer;
    }
}
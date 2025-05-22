import java.util.*;

class Solution {
    public int solution(int[] elements) {
        Set<Integer> set = new HashSet<>();
        int len = elements.length;
        int[] nums = new int[len * 2 + 1];
        for(int i = 1; i <= len; i++) {
            nums[i] = elements[i - 1];
            nums[i + len] = elements[i - 1];
        }
        int[] D = new int[nums.length];
        for(int i = 1; i < nums.length; i++) 
            D[i] = D[i - 1] + nums[i];
        
        for(int i = 1; i <= len; i++) {
            for(int j = i; j < D.length; j++) {
                int sum = D[j] - D[j - i];
                set.add(sum);
            }
        }
        return set.size();
    }
}
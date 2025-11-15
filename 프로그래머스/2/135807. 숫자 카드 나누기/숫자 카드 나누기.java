import java.util.*;

class Solution {
    
    static List<Integer> divs;
    
    static int gcd(int a, int b) {
        if(b == 0) return a;
        return gcd(b, a % b);
    }
    
    static int check(int[] arr, int gcd) {
        for(int num : arr)
            if(num % gcd == 0)
                return 0;
        return gcd;
    }
    
    public int solution(int[] arrayA, int[] arrayB) {
        int answer = 0;
        Arrays.sort(arrayA);
        int gcd = arrayA[0];
        for(int i = 1; i < arrayA.length; i++)
            gcd = gcd(gcd, arrayA[i]);
        
        answer = check(arrayB, gcd);
        
        Arrays.sort(arrayB);
        gcd = arrayB[0];
        for(int i = 1; i < arrayB.length; i++)
            gcd = gcd(gcd, arrayB[i]);
        
        answer = Math.max(answer, check(arrayA, gcd));
        
        return answer;
    }
}
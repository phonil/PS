import java.util.*;

class Solution {
    
    static List<String> list;
    
    static void split(String s) {
        StringBuilder sb = new StringBuilder();
        list = new ArrayList<>();
        for(char c : s.toCharArray()) {
            if(c != '0') sb.append(c);
            else {
                if(sb.length() == 0) continue;
                list.add(sb.toString());
                sb = new StringBuilder();
            }
        }
        if(sb.length() != 0)
            list.add(sb.toString());
    }
    
    static boolean isPrime(long num) {
        if(num == 1) return false;
        for(int i = 2; i <= Math.sqrt(num); i++)
            if(num % i == 0) return false;
        return true;
    }
    
    public int solution(int n, int k) {
        int answer = 0;
        
        // 1. n -> k진수 변환
        String s = Integer.toString(n, k);
        // 2. 0 단위 구분
        split(s);
        // 3. 각 청크의 소수 판별
        for(String str : list)
            if(isPrime(Long.parseLong(str))) answer++;
    
        return answer;
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
//         int answer = 0;
//         String trans = Integer.toString(n, k);
        
//         StringBuilder sb = new StringBuilder();
//         for(char c : trans.toCharArray()) {
//             if(c != '0') sb.append(c);
//             else {
//                 if(sb.length() == 0) continue;
//                 long parseNum = Long.parseLong(sb.toString());
//                 if(isPrime(parseNum)) answer++;
//                 sb = new StringBuilder();
//             }
//         }
        
//         if(sb.length() > 0) {
//             long parseNum = Long.parseLong(sb.toString());
//             if(isPrime(parseNum)) answer++;
//         }
//         return answer;
    }
    
    // static boolean isPrime(long num) {
    //     // 1의 경우 별도 소수 판별 처리 필요
    //     if(num == 1) return false;
    //     for(int i = 2; i <= Math.sqrt(num); i++) {
    //         if(num % i == 0) return false;
    //     }
    //     return true;
    // }
}
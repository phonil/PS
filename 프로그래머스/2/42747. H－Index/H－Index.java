import java.util.*;

class Solution {
    
    static int lower_bound(int target, int len, int[] citations) {
        int st = 0;
        int en = len;
        while(st < en) {
            int mid = (st + en) / 2;
            if(target <= citations[mid]) en = mid;
            else st = mid + 1;
        }
        return st;
    }
    
    // len - lower_bound();
    public int solution(int[] citations) {
        int answer = 0;
        Arrays.sort(citations);
        int len = citations.length;
        int max = citations[len - 1];
        for(int i = 0; i <= max; i++) { // 인용 횟수 loop
            int idx = lower_bound(i, len, citations);
            if(len - idx >= i)
                answer = i;
            
            // int cnt = 0;
            // for(int j = 0; j < len; j++) { // 논문 check loop
            //     if(i <= citations[j])
            //         cnt++;
            // }
            // if(i == cnt)
            //     answer = i;
        }
        return answer;
    }
}
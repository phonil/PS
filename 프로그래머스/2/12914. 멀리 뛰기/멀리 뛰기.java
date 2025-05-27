class Solution {
    public long solution(int n) {
        long answer = 0;
        int[] d = new int[n + 3];
        d[1] = 1;
        d[2] = 2;
        for(int i = 3; i <= n; i++) 
            d[i] = (d[i-1] + d[i-2]) % 1234567;
        answer = d[n];
        return answer;
    }
}
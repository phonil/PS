class Solution {
    public int solution(int n) {
        int[] D = new int[n + 1];
        D[1] = 1;
        if(n == 1)
            return 1;
        D[2] = 2;
        for(int i = 3; i <= n; i++) 
            D[i] = (D[i - 1] + D[i - 2]) % 1000000007;
        return D[n];
    }
}
class Solution {
    public int solution(int n) {
        int answer = 0;
        int bit = Integer.bitCount(n);
        while(true) {
            if(bit == Integer.bitCount(++n)) {
                answer = n;
                break;
            }
        }
        return answer;
    }
}
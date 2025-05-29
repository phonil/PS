class Solution {
    public int[] solution(String s) {
        int[] answer = new int[2];
        while(s.length() > 1) {
            answer[0]++;
            int c = s.replaceAll("0", "").length();
            answer[1] += s.length() - c;
            s = Integer.toBinaryString(c);
        }
        return answer;
    }
}
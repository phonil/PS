class Solution {
    public String solution(String s) {
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        String[] line = s.split(" ");
        for(int i = 0; i < line.length; i++) {
            int num = Integer.parseInt(line[i]);
            max = Math.max(max, num);
            min = Math.min(min, num);
        }
        StringBuilder sb = new StringBuilder();
        sb.append(min).append(" ").append(max);
        return sb.toString();
    }
}
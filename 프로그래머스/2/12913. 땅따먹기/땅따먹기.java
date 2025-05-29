class Solution {
    int solution(int[][] land) {
        int answer = 0;
        int N = land.length;
        int[][] D = new int[N][4];
        for(int i = 0; i < 4; i++) 
            D[0][i] = land[0][i];
        for(int i = 1; i < N; i++) {
            for(int j = 0; j < 4; j++) {
                int max = 0;
                for(int k = 1; k < 4; k++) 
                    max = Math.max(max, D[i - 1][(j + k) % 4]);
                D[i][j] = max + land[i][j];
            }
        }
        for(int i = 0; i < 4; i++) 
            answer = Math.max(answer, D[N - 1][i]);
        return answer;
    }
}
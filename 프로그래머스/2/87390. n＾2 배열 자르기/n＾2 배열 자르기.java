class Solution {
    public int[] solution(int n, long left, long right) {
        /*
        1 2 3 4 5
        2 2 3 4 5
        3 3 3 4 5
        4 4 4 4 5
        5 5 5 5 5
        
        i == j : i (or j)
        i > j : i
        j < i : j
        
        1차원 배열 -> 2차원 배열 변환
            -> idx (left or right) : (idx / n, idx % n);
        (0, 2) / (1, 2)
        */
        int[] answer = new int[(int)(right - left) + 1];
        int idx = 0;
        for(long i = left; i <= right ; i++) {
            long max = Math.max(i / n, i % n) + 1;
            answer[idx++] = (int) max;
        }
        
        
        /*
        row i : column : 0 ~ i까지 i,
        column i : row : 0 ~ i까지
        1 2 3 4 5 -> 1 2 3 4 5
        2 2 3 4 5 -> 6 7 8 9 10
        3 3 3 4 5 -> 11 12 13 14 15
        4 4 4 4 5 -> 16 17 18 19 20
        5 5 5 5 5 -> 21 22 23 24 25
        
        left, right : idx -> (idx / n, idx % n)
        left cord = left / n, left % n : (0, 2)
        right cord = right / n, right % n : (1, 2)
        
        (i, j) : max(i, j) + 1;
        */
        
        // int[] answer = new int[(int) (right - left + 1)];
        // int idx = 0;
        // for(int i = (int)left; i <= right; i++) {
        //     int r = i / n;
        //     int c = i % n;
        //     int num = Math.max(r, c) + 1;
        //     answer[idx++] = num;
        // }
        return answer;
    }
}
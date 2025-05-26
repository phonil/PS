class Solution {
    
    static boolean[] arr;
    static int N;
    static int x;
    static int answer = 0;
    
    static void func(int cur, int sum, int[] numbers) {
        if(cur == N) {
            if(sum == x) 
                answer++;
            return;
        }
        arr[cur] = true;
        func(cur + 1, sum + numbers[cur], numbers);
        arr[cur] = false;
        func(cur + 1, sum - numbers[cur], numbers);
    }
    
    public int solution(int[] numbers, int target) {
        N = numbers.length;
        arr = new boolean[N];
        x = target;
        func(0, 0, numbers);
        return answer;
    }
}
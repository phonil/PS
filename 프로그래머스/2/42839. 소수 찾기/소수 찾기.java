class Solution {
    static int len;
    static int answer = 0;
    static int[] arr;
    static int[] nums;
    static boolean[] exist;
    static boolean[] isUsed;
    
    static boolean check(int num) {
        if(num < 2) return false;
        for(int i = num - 1; i > 1; i--) {
            if(num % i == 0)
                return false;
        }
        return true;
    }
    
    static void func(int cur) {
        if(cur == len) {
            String s = "";
            for(int i : arr) {
                if(i == -1)
                    continue;
                s += Integer.toString(i);
            }
            if(s.length() == 0)
                return;
            if(s.length() > 1 && s.charAt(0) == '0')
                s = s.substring(1, s.length());
            int num = Integer.parseInt(s);
            if(!exist[num]) {
                if(check(num))
                    answer++;
                exist[num] = true;
            }
            return;
        }
        for(int i = 0; i < nums.length; i++) {
            if(isUsed[i]) continue;
            arr[cur] = nums[i];
            if(i != nums.length - 1)
                isUsed[i] = true;
            func(cur + 1);
            isUsed[i] = false;
        }
    }
    
    public int solution(String numbers) {
        len = numbers.length();
        arr = new int[len];
        exist = new boolean[10000001];
        isUsed = new boolean[len + 1];
        nums = new int[len + 1];
        for(int i = 0; i < len; i++) 
            nums[i] = numbers.charAt(i) - '0';
        nums[len] = -1;
        func(0);
        /*
        백트래킹
            1. func(int cur)
                -> cur : 몇 번째 무엇 넣을 건지?
                -> 종이들에 있는 것 or 안넣기 (-1);
            2. Base Condition
                -> cur == numbers.len
                    -> arr를 String으로 변환
                        -> 돌면서 -1 포함 : 빈 칸 (continue)
                    -> 맨 앞에 0인 경우 지우기
                    -> check 한 건 set에 넣기 (중복 방지) : set vs boolean[] -> 시간 복잡도 vs 공간 복잡도
                -> 중복 확인 및 소수 check()
                    -> 소수면 cnt++;
            3. impl
        */
        return answer;
    }
}
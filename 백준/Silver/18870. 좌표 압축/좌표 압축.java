
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Main {

    static int[] arr;
    static int[] tmp;
    static int N;
    static List<Integer> copyArr = new ArrayList<>();
    static int lowerIdx(int target) {
        int st = 0;
        int en = copyArr.size();
        while (st < en) {
            int mid = (st + en) / 2;
            if (copyArr.get(mid) >= target) en = mid;
            else st = mid + 1;
        }
        return st;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        String[] split = br.readLine().split(" ");
        arr = new int[N];
        tmp = new int[N];
        for (int i = 0; i < N; i++) {
             int num = Integer.parseInt(split[i]);
             arr[i] = num;
             tmp[i] = num;
        }
        Arrays.sort(tmp);
        for (int i = 0; i < N; i++) {
            if (i == 0 || tmp[i] != tmp[i - 1])
                copyArr.add(tmp[i]);
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            int low = lowerIdx(arr[i]);
            sb.append(low).append(" ");
        }
        System.out.print(sb);
    }
}

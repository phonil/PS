
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    static int N, M;
    static int[] arr;

    static int lowerIdx(int target) {
        int st = 0;
        int en = N;
        while (st < en) {
            int mid = (st + en) / 2;
            if (target <= arr[mid]) en = mid;
            else st = mid + 1;
        }
        return st;
    }

    static int upperIdx(int target) {
        int st = 0;
        int en = N;
        while (st < en) {
            int mid = (st + en) / 2;
            if (target < arr[mid]) en = mid;
            else st = mid + 1;
        }
        return st;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        String[] split = br.readLine().split(" ");
        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(split[i]);
            arr[i] = num;
        }
        Arrays.sort(arr);
        M = Integer.parseInt(br.readLine());
        split = br.readLine().split(" ");
        for (int i = 0; i < M; i++) {
            int target = Integer.parseInt(split[i]);
            sb.append(upperIdx(target) - lowerIdx(target)).append(" ");
        }
        System.out.print(sb);
    }
}

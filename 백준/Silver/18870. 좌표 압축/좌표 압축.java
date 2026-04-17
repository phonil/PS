import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    static int N;
    static int[] A, B;

    static int lower_bound(int target, int[] arr) {
        int st = 0;
        int en = arr.length;
        while (st < en) {
            int mid = (st + en) / 2;
            if (arr[mid] >= target) en = mid;
            else st = mid + 1;
        }
        return st;
    }

    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        A = new int[N];
        B = new int[N];
        String[] split = br.readLine().split(" ");
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(split[i]); // 원본
            B[i] = A[i];
        }
        int[] arr = Arrays.stream(B).sorted().distinct().toArray();
        for (int i = 0; i < N; i++)
            sb.append(lower_bound(A[i], arr)).append(" ");
        System.out.print(sb);
    }
}

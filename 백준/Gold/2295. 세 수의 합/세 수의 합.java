import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Main {

    static int N;
    static int[] A;
    static List<Integer> sum;
    static int max = 0;

    static boolean binarySearch(int target) {
        int st = 0;
        int en = sum.size() - 1;
        while (st <= en) {
            int mid = (st + en) / 2;
            if (sum.get(mid) > target) en = mid - 1;
            else if (sum.get(mid) < target) st = mid + 1;
            else return true;
        }
        return false;
    }

    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        A = new int[N];
        sum = new ArrayList<>();
        for (int i = 0; i < N; i++)
            A[i] = Integer.parseInt(br.readLine());

        Arrays.sort(A);

        for (int i = 0; i < N; i++)
            for (int j = i; j < N; j++)
                sum.add(A[i] + A[j]);

        Collections.sort(sum);

        for (int i = N - 1; i > 0; i--) {
            int d = A[i];
            for (int j = 0; j < i; j++) {
                int c = A[j];
                int target = d - c;
                if (!binarySearch(target)) continue;
                else max = Math.max(max, d);
            }
        }
        System.out.print(max);
    }
}


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    static int[] arr;
    static int N, M;
    static int binarySearch(int target) {
        int st = 0;
        int en = N - 1;
        while (st <= en) {
            int mid = (st + en) / 2;
            if (target < arr[mid]) en = mid - 1;
            else if (target > arr[mid]) st = mid + 1;
            else return 1;
        }
        return 0;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        String[] split = br.readLine().split(" ");
        arr = new int[N];
        for (int i = 0; i < N; i++)
            arr[i] = Integer.parseInt(split[i]);
        Arrays.sort(arr);
        M = Integer.parseInt(br.readLine());
        split = br.readLine().split(" ");
        for (int i = 0; i < M; i++) {
            int target = Integer.parseInt(split[i]);
            System.out.println(binarySearch(target));
        }
    }
}

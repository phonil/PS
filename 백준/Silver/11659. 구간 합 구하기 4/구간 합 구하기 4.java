
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] split = br.readLine().split(" ");
        int N = Integer.parseInt(split[0]); // 수의 개수
        int M = Integer.parseInt(split[1]); // 합을 구해야 하는 횟수
        String[] line = br.readLine().split(" ");
        int[] nums = new int[N + 1];
        int[] d = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            nums[i] = Integer.parseInt(line[i - 1]);
            d[i] = d[i - 1] + nums[i];
        }
        for (int i = 0; i < M; i++) {
            String[] lines = br.readLine().split(" ");
            int stIdx = Integer.parseInt(lines[0]);
            int enIdx = Integer.parseInt(lines[1]);
            System.out.println(d[enIdx] - d[stIdx - 1]);
        }
    }
}

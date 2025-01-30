
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Pair[] meeting = new Pair[N];
        for (int i = 0; i < N; i++) {
            String[] line = br.readLine().split(" ");
            int start = Integer.parseInt(line[0]);
            int end = Integer.parseInt(line[1]);
            meeting[i] = new Pair(start, end);
        }
        Arrays.sort(meeting, Comparator.comparingInt((Pair m) -> m.y).thenComparingInt(m -> m.x));
        int cnt = 1;
        Pair now = meeting[0];
        for (int i = 1; i < N; i++) {
            if (now.y > meeting[i].x) continue;
            now = meeting[i];
            cnt++;
        }
        System.out.print(cnt);
    }

    static class Pair {
        int x, y;
        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Meeting[] meetings = new Meeting[N];
        for (int i = 0; i < N; i++) {
            String[] split = br.readLine().split(" ");
            int st = Integer.parseInt(split[0]);
            int en = Integer.parseInt(split[1]);
            meetings[i] = new Meeting(st, en);
        }
        Arrays.sort(meetings, Comparator.comparingInt((Meeting m) -> m.en).thenComparingInt((Meeting m) -> m.st));
        int cnt = 1;
        Meeting now = meetings[0];
        for (int i = 1; i < N; i++) {
            Meeting meet = meetings[i];
            if (now.en > meet.st) continue;
            now = meet;
            cnt++;
        }
        System.out.print(cnt);
    }
    static class Meeting {
        int st, en;
        public Meeting(int st, int en) {
            this.st = st;
            this.en = en;
        }
    }
}

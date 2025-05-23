
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

    static char[] map = new char[25];
    static int[] arr = new int[7];
    static boolean[] isUsed = new boolean[25];
    static int[] dx = {-1, 1, -5, 5};
    static int cnt = 0;

    static void func(int cur, int som, int startIdx) {
        if (cur == 7) {
            if (som >= 4 && isConnected()) cnt++;
            return;
        }
        for (int i = startIdx; i < 25; i++) {
            if (isUsed[i]) continue;
            arr[cur] = i;
            isUsed[i] = true;
            if (map[i] == 'S')
                func(cur + 1, som + 1, i + 1);
            else
                func(cur + 1, som, i + 1);
            isUsed[i] = false;
        }
    }

    static boolean isConnected() {
        boolean[] visit = new boolean[7];
        Queue<Integer> q = new LinkedList<>();
        q.offer(arr[0]);
        visit[0] = true;
        int cnt = 1;
        while (!q.isEmpty()) {
            Integer poll = q.poll();
            for (int i = 0; i < 4; i++) {
                int nx = poll + dx[i];
                if (bound(nx)) continue;
                if (dx[i] == 1 && poll % 5 == 4) continue;
                if (dx[i] == -1 && poll % 5 == 0) continue;
                for (int j = 0; j < 7; j++) {
                    if (arr[j] == nx) {
                        if (visit[j]) continue;
                        q.offer(nx);
                        visit[j] = true;
                        cnt++;
                        break;
                    }
                }
            }
        }
        return cnt == 7;
    }

    static boolean bound(int nx) {
        return nx < 0 || nx >= 25;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < 5; i++) {
            String line = br.readLine();
            for (int j = 0; j < 5; j++)
                map[i*5 + j] = line.charAt(j);
        }
        func(0, 0, 0);
        System.out.print(cnt);
    }
}

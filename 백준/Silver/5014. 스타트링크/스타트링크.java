
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] split = br.readLine().split(" ");
        final int F = Integer.parseInt(split[0]); // 건물 높이
        final int S = Integer.parseInt(split[1]); // 강호 현재 위치
        final int G = Integer.parseInt(split[2]); // 목적지
        final int U = Integer.parseInt(split[3]); // 한 번에 위로 몇 칸
        final int D = Integer.parseInt(split[4]); // 한 번에 아래로 몇 칸

        int[] dx = {U, -D};
        int[] build = new int[F + 1];
        Arrays.fill(build, -1);
        Queue<Integer> q = new LinkedList<>();
        q.offer(S);
        build[S] = 0;
        while (!q.isEmpty()) {
            Integer cur = q.poll();
            for (int i = 0; i < 2; i++) {
                int move = cur + dx[i];
                if (move > F || move <= 0) continue;
                if (build[move] >= 0) continue;
                q.offer(move);
                build[move] = build[cur] + 1;
            }
        }
        int ans = build[G];
        if (ans == -1)
            System.out.println("use the stairs");
        else
            System.out.println(ans);
    }
}

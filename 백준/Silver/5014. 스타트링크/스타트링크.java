
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int F = sc.nextInt(); // 건물 층
        int S = sc.nextInt(); // 현재 강호가 있는 층
        int G = sc.nextInt(); // 스타트링크 층
        int U = sc.nextInt(); // 위로 U층 가는 버튼 / 맨 위면 엘리베이터는 움직이지 않음
        int D = sc.nextInt(); // 아래로 D층 가는 버튼 / 맨 밑이면 엘리베이터는 움직이지 않음
        
        // Q. G층 가려면 버튼 최소 몇 번 눌러야 하는지?
        int[] dist = new int[1000002];
        Arrays.fill(dist, -1);
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(S);
        dist[S] = 0;

        while (!queue.isEmpty()) {
            Integer poll = queue.poll();
            if (G > poll) {
                if (U == 0)
                    break;
                int up = poll + U;
                if (up > F) {
                    if (dist[poll - D] == -1) {
                        if (poll - D < 1)
                            continue;
                        up = poll - D;
                    }
                    else
                        continue;
                }
                if (dist[up] != -1)
                    continue;
                queue.offer(up);
                dist[up] = dist[poll] + 1;
            }
            else if (G < poll) {
                if (D == 0)
                    break;
                int down = poll - D;
                if (down < 1) {
                    if (dist[poll + U] == -1) {
                        if (poll + U > F)
                            continue;
                        down = poll + U;
                    }
                    else
                        continue;
                }
                if (dist[down] != -1)
                    continue;
                queue.offer(down);
                dist[down] = dist[poll] + 1;
            }
            else { // (G == poll)
                break;
            }
        }

        if (dist[G] == -1)
            System.out.println("use the stairs");
        else
            System.out.println(dist[G]);


    }
}

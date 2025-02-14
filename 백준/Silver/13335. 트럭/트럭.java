
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] split = br.readLine().split(" ");
        int n = Integer.parseInt(split[0]); // 트럭의 수
        int w = Integer.parseInt(split[1]); // 다리의 길이
        int L = Integer.parseInt(split[2]); // 다리의 최대 하중

        split = br.readLine().split(" ");
        int[] trucks = new int[n];
        for (int i = 0; i < n; i++)
            trucks[i] = Integer.parseInt(split[i]);
        Queue<Integer> bridge = new LinkedList<>();
        int time = 0;
        int idx = 0;
        int bridgeWeigth = 0;
        for (int i = 0; i < w; i++)
            bridge.offer(0);
        while (idx < n) {
            time++;
            bridgeWeigth -= bridge.poll();
            if (bridgeWeigth + trucks[idx] <= L) {
                bridgeWeigth += trucks[idx];
                bridge.offer(trucks[idx++]);
            } else
                bridge.offer(0);
        }
        time += w;
        System.out.print(time);
    }
}

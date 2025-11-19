import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

public class Main {

    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Pair[] lines = new Pair[N];
        for (int i = 0; i < N; i++) {
            String[] split = br.readLine().split(" ");
            int st = Integer.parseInt(split[0]);
            int en = Integer.parseInt(split[1]);
            lines[i] = new Pair(st, en);
        }
        Arrays.sort(lines, Comparator.comparingInt((Pair p) -> p.st));
        int answer = 0;
        int st = lines[0].st;
        int en = lines[0].en;
        for (int i = 1; i < N; i++) {
            Pair line = lines[i];
            if (en >= line.st)
                en = Math.max(en, line.en);
            else {
                answer += en - st;
                st = line.st;
                en = line.en;
            }
        }
        answer += en - st;
        System.out.print(answer);
    }

    static class Pair {
        int st, en;
        public Pair(int st, int en) {
            this.st = st;
            this.en = en;
        }
    }
}

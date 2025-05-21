
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int T;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        T = Integer.parseInt(br.readLine());
        while (T --> 0) {
            String[] words = br.readLine().split(" ");
            List<String> list = Arrays.asList(words);
            ArrayList<String> other = new ArrayList<>();
            while (true) {
                String line = br.readLine();
                if (line.equals("what does the fox say?")) break;
                String[] split = line.split(" ");
                other.add(split[2]);
            }
            for (String s : list) {
                boolean flag = false;
                for (String o : other) {
                    if (s.equals(o)) {
                        flag = true;
                        break;
                    }
                }
                if (!flag)
                    sb.append(s).append(" ");
            }
            sb.append('\n');
        }
        System.out.print(sb);
    }
}

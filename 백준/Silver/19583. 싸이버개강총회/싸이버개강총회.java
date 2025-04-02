
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalTime;
import java.util.HashSet;
import java.util.Set;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] split = br.readLine().split(" ");
        LocalTime start = LocalTime.parse(split[0]);
        LocalTime end = LocalTime.parse(split[1]);
        LocalTime quit = LocalTime.parse(split[2]);
        Set<String> set = new HashSet<>();
        int cnt = 0;
        String input;
        while ((input = br.readLine()) != null) {
            String[] lineSplit = input.split(" ");
            String timeStr = lineSplit[0];
            LocalTime log = LocalTime.parse(timeStr);
            String name = lineSplit[1];

            if (log.isBefore(start) || log.equals(start))
                set.add(name);
            else if ((log.isAfter(end) || log.equals(end)) && (log.isBefore(quit) || log.equals(quit))) {
                if (set.contains(name)) {
                    cnt++;
                    set.remove(name);
                }
            }
        }
        System.out.print(cnt);
    }
}

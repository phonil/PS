
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String[] split = br.readLine().split(" ");
        int N = Integer.parseInt(split[0]);
        int M = Integer.parseInt(split[1]);
        // <TeamName, MemberList>
        Map<String, List<String>> teamMap = new HashMap<>();
        // <MemberName, TeamName>
        Map<String, String> memberMap = new HashMap<>();
        for (int i = 0; i < N; i++) {
            String team = br.readLine();
            int memberCnt = Integer.parseInt(br.readLine());
            List<String> members = new ArrayList<>();
            for (int j = 0; j < memberCnt; j++) {
                String member = br.readLine();
                members.add(member);
                memberMap.put(member, team);
            }
            teamMap.put(team, members);
        }

        for (int i = 0; i < M; i++) {
            String query = br.readLine();
            int quizType = Integer.parseInt(br.readLine());
            if (quizType == 0) {
                List<String> members = teamMap.get(query);
                Collections.sort(members);
                for (String member : members)
                    sb.append(member).append('\n');
            } else {
                String team = memberMap.get(query);
                sb.append(team).append('\n');
            }
        }
        System.out.print(sb);
    }
}

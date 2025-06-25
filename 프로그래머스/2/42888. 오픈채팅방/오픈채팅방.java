import java.util.*;

class Solution {
    public String[] solution(String[] record) {
        final String ENTER_MESSAGE = "님이 들어왔습니다.";
        final String LEAVE_MESSAGE = "님이 나갔습니다.";
        // <uid, nickname>
        Map<String, String> map = new HashMap<>();
        for(int i = 0; i < record.length; i++) {
            String[] split = record[i].split(" ");
            String action = split[0];
            String uid = split[1];
            String nickname;
            if(action.equals("Enter") || action.equals("Change")) {
                nickname = split[2];
                map.put(uid, nickname);
            }
        }
        List<String> answer = new ArrayList<>();
        for(int i = 0; i < record.length; i++) {
            StringBuilder sb = new StringBuilder();
            String[] split = record[i].split(" ");
            String action = split[0];
            String uid = split[1];
            String nickname = map.get(uid);
            if(!action.equals("Change")) {
                sb.append(nickname);
                if(action.equals("Enter"))  
                    sb.append(ENTER_MESSAGE);
                else if(action.equals("Leave"))
                    sb.append(LEAVE_MESSAGE);
                answer.add(sb.toString());
            }
        }
        return answer.toArray(new String[0]);
    }
}
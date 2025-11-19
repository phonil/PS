import java.util.*;

class Solution {
    
    static String parse(String file, int startIdx) {
        StringBuilder sb = new StringBuilder();
        for(int i = startIdx; i < file.length(); i++) {
            char c = file.charAt(i);
            if(startIdx == 0 && Character.isDigit(c)) break;
            if(startIdx != 0 && !Character.isDigit(c)) break;
            else sb.append(c);
        }
        return sb.toString();
    }
    
    public String[] solution(String[] files) {
        int len = files.length;
        String[] answer = new String[len];
        Name[] names = new Name[len];
        
        for(int i = 0; i < len; i++) {
            // parsing 후 names add
            String file = files[i];
            String head = parse(file, 0);
            String number = parse(file, head.length());
            String tail = file.substring(head.length() + number.length());
            names[i] = new Name(head, number, i, tail);
        }
        Arrays.sort(names, 
                Comparator.comparing((Name n) -> n.head.toUpperCase())
                         .thenComparingInt(n -> Integer.parseInt(n.number))
                         .thenComparingInt(n -> n.idx)
        );
        
        for(int i = 0; i < len; i++) {
            Name name = names[i];
            answer[i] = name.head + name.number + name.tail;
        }
        return answer;
    }
    
    static class Name {
        String head, number, tail;
        int idx;
        public Name(String head, String number, int idx, String tail) {
            this.head = head;
            this.number = number;
            this.idx = idx;
            this.tail = tail;
        }
    }
}

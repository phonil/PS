import java.util.*;

class Solution {
    
    static String parse_head(String file) {
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < file.length(); i++) {
            char c = file.charAt(i);
            if(Character.isDigit(c)) break;
            else sb.append(c);
        }
        return sb.toString();
    }
    
    static String parse_number(String file, int startIdx) {
        StringBuilder sb = new StringBuilder();
        for(int i = startIdx; i < file.length(); i++) {
            char c = file.charAt(i);
            if(!Character.isDigit(c)) break;
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
            String head = parse_head(file);
            String number = parse_number(file, head.length());
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
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
//     static FileName[] fileNames;
    
//     static void parse(String[] files) {
//         fileNames = new FileName[files.length];
    
//         for(int fileIdx = 0; fileIdx < files.length; fileIdx++) {
//             String file = files[fileIdx];
//             int idx = 0;
            
//             // Head 파싱
//             StringBuilder sb = new StringBuilder();
//             for(int i = idx; i < file.length(); i++) {
//                 char c = file.charAt(i);
//                 idx = i;
//                 if(!Character.isDigit(c)) sb.append(c);
//                 else break;
//             }
//             String head = sb.toString();
            
//             // Number 파싱
//             sb = new StringBuilder();
//             boolean last = false;
//             for(int i = idx; i < file.length(); i++) {
//                 char c = file.charAt(i);
//                 idx = i;
//                 if(sb.length() < 5 && Character.isDigit(c)) sb.append(c);
//                 else break;
//                 if(idx == file.length() - 1) last = true;
//             }
//             String number = sb.toString();
            
//             if(last) idx++;
                
//             // Tail 파싱
//             sb = new StringBuilder();
//             for(int i = idx; i < file.length(); i++) {
//                 char c = file.charAt(i);
//                 sb.append(c);
//             }
//             String tail = sb.toString();
            
//             fileNames[fileIdx] = new FileName(head, number, tail);
//         }
//     }
    
//     public String[] solution(String[] files) {
//         String[] answer = new String[files.length];
//         parse(files);
//         Arrays.sort(fileNames,
//                    Comparator.comparing((FileName fn) -> fn.head.toUpperCase())
//                     .thenComparingInt(fn -> Integer.parseInt(fn.number))
//                    );
        
//         for(int i = 0; i < files.length; i++) {
//             StringBuilder sb = new StringBuilder();
//             FileName fn = fileNames[i];
//             String head = fn.head;
//             String number = fn.number;
//             String tail = fn.tail;
//             sb.append(head).append(number).append(tail);
//             answer[i] = sb.toString();
//         }
//         return answer;
//     }
    
//     static class FileName {
//         String head, number, tail;
//         public FileName(String head, String number, String tail) {
//             this.head = head;
//             this.number = number;
//             this.tail = tail;
//         }
//     }
}

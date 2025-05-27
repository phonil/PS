    import java.util.*;

    class Solution {
        public int[] solution(String s) {
            /*
            split "},"
            split[0] = {2
            split[1] = {2,1
            split[2] = {2,1,3

            TreeMap<Integer, Integer>
            -> <split 하나하나의 요소 개수 (split.split(",") 필요 !), split 하나하나의 idx>
            후에 순서대로 꺼내기
            */
            TreeMap<Integer, Integer> map = new TreeMap<>();
            int len = s.length();
            String[] split = s.substring(1, len - 1).split("\\},");
            for(int i = 0; i < split.length; i++) {
                map.put(split[i].length(), i);
                split[i] = split[i].replaceAll("\\{", "").replaceAll("\\}", "").trim();
            }
            List<Integer> list = new ArrayList<>();
            for(Integer i : map.values()) {
                String[] subs = split[i].split(",");
                for(int j = 0; j < subs.length; j++) {
                    if(list.contains(Integer.parseInt(subs[j]))) 
                        continue;
                    list.add(Integer.parseInt(subs[j]));
                }
            }

            return list.stream().mapToInt(Integer::intValue).toArray();
        }
    }
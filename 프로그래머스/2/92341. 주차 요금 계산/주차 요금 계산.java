import java.util.*;
import java.time.*;

class Solution {
    
    static int basicTime;
    static int basicFee;
    static int unitTime;
    static int unitFee;
    
    static int calcFee(int time) {
        int price = basicFee;
        time -= basicTime;
        if(time > 0) {
            int cnt = (int) Math.ceil((double) time / unitTime);
            price += cnt * unitFee;
        }
        return price;
    }
    
    public int[] solution(int[] fees, String[] records) {
        basicTime = fees[0];
        basicFee = fees[1];
        unitTime = fees[2];
        unitFee = fees[3];
        
        TreeMap<Integer, Integer> timeMap = new TreeMap<>(); // <차량 번호, 누적 시간(분)>
        HashMap<String, LocalTime> parkMap = new HashMap<>(); // <차량 번호, 입차 시간>
        for(int i = 0; i < records.length; i++) {
            String record = records[i];
            String[] split = record.split(" ");
            LocalTime time = LocalTime.parse(split[0]);
            String car = split[1];
            boolean in = split[2].equals("IN");
            if(in)
                parkMap.put(car, time);
            else {
                LocalTime inTime = parkMap.get(car);
                int diff = (int) Duration.between(inTime, time).toMinutes();
                timeMap.put(Integer.parseInt(car), timeMap.getOrDefault(Integer.parseInt(car), 0) + diff);
                parkMap.remove(car);
            }
        }
        
        for(String car : parkMap.keySet()) {
            LocalTime inTime = parkMap.get(car);
            LocalTime endTime = LocalTime.of(23, 59);
            int diff = (int) Duration.between(inTime, endTime).toMinutes();
            timeMap.put(Integer.parseInt(car), timeMap.getOrDefault(Integer.parseInt(car), 0) + diff);
        }
        
        int[] answer = new int[timeMap.size()];
        int idx = 0;
        for(Integer car : timeMap.keySet()) {
            int price = calcFee(timeMap.get(car));
            answer[idx++] = price;
        }
        return answer;
    }
}
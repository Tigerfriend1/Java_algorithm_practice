//프로그래머스 Lv.2 오픈채팅방
import java.util.*;
class Solution {
    static String[] record;
    static String[] answer = {};
    static HashMap<String,String> user = new HashMap<>();
    public String[] solution(String[] record) {
        this.record=record;
        for(String line : record){
            String[] rec = line.split(" ");
            if(rec[0].equals("Enter")){
                user.put(rec[1],rec[2]);
            }
            if(rec[0].equals("Change")){
                user.put(rec[1],rec[2]);
            }
            
        }
        List<String> list = new ArrayList<>();
        
        for(String line : record){
            StringBuilder sb = new StringBuilder();
            String[] rec = line.split(" ");
            if(rec[0].equals("Enter")){
                sb.append(user.get(rec[1])).append("님이 들어왔습니다.");
                list.add(sb.toString());
            }
            if(rec[0].equals("Leave")){
                sb.append(user.get(rec[1])).append("님이 나갔습니다.");
                list.add(sb.toString());
            }
            
        }
        
        return list.toArray(new String[0]);
    }

}
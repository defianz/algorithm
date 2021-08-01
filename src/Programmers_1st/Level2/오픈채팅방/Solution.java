package Programmers_1st.Level2.오픈채팅방;

import java.util.ArrayList;
import java.util.HashMap;

class Solution {
    public String[] solution(String[] record) {

        HashMap<String,String> hm = new HashMap<>();
        ArrayList<String> arl = new ArrayList<>();

        for (int i = 0; i < record.length; i++) {
            String[] tmp = record[i].split(" ");
            if(tmp[0].equals("Enter")){
                hm.put(tmp[1],tmp[2]);
            } else if (tmp[0].equals("Change")){
                hm.put(tmp[1],tmp[2]);
            }
        }

        for (int i = 0; i < record.length; i++) {
            String[] tmp = record[i].split(" ");
            String nick = hm.get(tmp[1]);
            if(tmp[0].equals("Enter")){
                arl.add(nick+"님이 들어왔습니다.");
            } else if (tmp[0].equals("Leave")){
                arl.add(nick+"님이 나갔습니다.");
            }
        }

        String[] answer = new String[arl.size()];
        for (int i = 0; i < answer.length; i++) {
            answer[i] = arl.get(i);
        }

        return answer;
    }
}

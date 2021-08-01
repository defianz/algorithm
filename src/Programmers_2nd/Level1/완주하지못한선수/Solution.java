package Programmers_2nd.Level1.완주하지못한선수;

import java.util.HashMap;

class Solution {
    public String solution(String[] participant, String[] completion) {
        String answer = "";

        HashMap<String,Integer> hm = new HashMap<>();

        for (String part : participant){
            hm.put(part,hm.getOrDefault(part,0)+1);
        }

        for (String comp : completion){
            hm.put(comp,hm.get(comp)-1);
        }

        for (String key : hm.keySet()){
            if(hm.get(key) != 0) {
                answer = key;
                break;
            }
        }


        return answer;
    }
}
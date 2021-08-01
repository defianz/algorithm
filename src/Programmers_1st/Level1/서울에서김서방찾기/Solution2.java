package Programmers_1st.Level1.서울에서김서방찾기;

import java.util.HashMap;

class Solution2 {
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        HashMap<String,Integer> map = new HashMap<>();

        for (int i = 0; i < participant.length; i++) {
            int cnt = map.get(participant[i]) == null ? 0 : map.get(participant[i]);
            map.put(participant[i],cnt+1);
        }

        for (int i = 0; i < completion.length; i++) {
            int cnt2 = map.get(completion[i]);
            if(cnt2 == 1) {
                map.remove(completion[i]);
                continue;
            }
            map.put(completion[i], cnt2-1);
        }


        return map.entrySet().iterator().next().getKey();
    }
}

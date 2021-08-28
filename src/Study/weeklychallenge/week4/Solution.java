package Study.weeklychallenge.week4;

import java.util.HashMap;

class Solution {


    public String solution(String[] table, String[] languages, int[] preference) {
        String answer = "";
        int maxPt = 0;
        HashMap<String, HashMap> hm = new HashMap<>();

        for (String row : table){
            String[] spl = row.split(" ");

            HashMap<String, Integer> pt = new HashMap<>();
            for (int i = 1; i <= 5; i++) {
                pt.put(spl[i],6-i);
            }
            hm.put(spl[0],pt);
        }

        for (String key : hm.keySet()){
            int tmp = 0;
            for (int i = 0 ; i<languages.length; i++) {
                if(hm.get(key).containsKey(languages[i])) {
                    tmp += ((int) hm.get(key).get(languages[i])) * preference[i];
                }
            }
            if(tmp>maxPt){
                answer = key;
                maxPt = tmp;
            }
            else if (tmp==maxPt) {
                if(key.charAt(0) < answer.charAt(0)){
                    answer = key;
                }
            }
        }

        return answer;
    }
}
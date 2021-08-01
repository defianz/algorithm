package Programmers_1st.Level2.뉴스클러스터링;

import java.util.ArrayList;
import java.util.HashMap;

class Solution {
    public int solution(String str1, String str2) {
        int answer = 0;

        HashMap<String,Integer> hm = new HashMap<>();
        ArrayList<String> inter = new ArrayList<>();
        ArrayList<String> hap = new ArrayList<>();

        str1 = str1.toLowerCase();
        str2 = str2.toLowerCase();

        for (int i = 0; i < str1.length()-1; i++) {
            String splitStr1 = str1.substring(i,i+2).replaceAll("[^a-z]","");
            if(splitStr1.length() != 2 ) continue;
            if(hm.containsKey(splitStr1)) hm.put(splitStr1,hm.get(splitStr1)+1);
            else {
                hm.put(splitStr1,1);
            }
            hap.add(splitStr1);
        }

        for (int i = 0; i < str2.length()-1; i++) {
            String splitStr2 = str2.substring(i,i+2).replaceAll("[^a-z]","");
            if(splitStr2.length() != 2 ) continue;
            if(hm.containsKey(splitStr2) && hm.get(splitStr2) != 0){
                inter.add(splitStr2);
                hm.put(splitStr2,hm.get(splitStr2)-1);
            } else {
                hap.add(splitStr2);
            }
        }
        if(inter.size() == 0 && hap.size() == 0){
            answer = 65536;
        } else {
            answer = (int)(((double) inter.size() / (double)hap.size()) * (double)65536);

        }

        return answer;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println("s.solution(\"FRANCE\",\"french\\t\") = " + s.solution("FRANCE", "french\t"));
    }
}
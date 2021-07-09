package Programmers.Level1.숫자문자열과영단어;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

class Solution {
    public int solution(String s) {
        int answer = 0;

        HashMap<String, String> hm = new HashMap<>();
        hm.put("zero","0");
        hm.put("one","1");
        hm.put("two","2");
        hm.put("three","3");
        hm.put("four","4");
        hm.put("five","5");
        hm.put("six","6");
        hm.put("seven","7");
        hm.put("eight","8");
        hm.put("nine","9");

        for (String key : hm.keySet()){
            s = s.replaceAll(key,hm.get(key));
        }
        answer = Integer.parseInt(s);
        return answer;
    }

    public static void main(String[] args) {
        Solution s= new Solution();
        System.out.println("s.solution(\"one4seveneight\") = " + s.solution("one4seveneight"));
    }
}
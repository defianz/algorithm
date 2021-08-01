package Programmers_2nd.Level1.숫자문자열과영단어;

import java.util.HashMap;

class Solution {
    public int solution(String s) {

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
            if(s.contains(key)){
                s = s.replaceAll(key,hm.get(key));
            }
        }

        return Integer.parseInt(s);
    }
}

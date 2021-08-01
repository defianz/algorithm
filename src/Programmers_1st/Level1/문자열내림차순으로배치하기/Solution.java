package Programmers_1st.Level1.문자열내림차순으로배치하기;

import java.util.Arrays;
import java.util.Collections;

class Solution {
    public String solution(String s) {
        String answer = "";
        String[] tmp = new String[s.length()];
        for(int i=0;i<s.length();i++){
            tmp[i] = String.valueOf(s.charAt(i));
        }
        Arrays.sort(tmp, Collections.reverseOrder());

        StringBuilder sb = new StringBuilder();

        for(int i=0;i<s.length();i++){
            answer += tmp[i];
        }
        
        return answer;
    }
}

//# 특별한 답
//import java.util.Arrays;
//import java.util.Collections;
//
//class Solution {
//    public String solution(String s) {
//        String answer = "";
//        char[] tmp = s.toCharArray();
//        Arrays.sort(tmp);
//        return new StringBuilder(new String(tmp)).reverse().toString();
//    }
//}
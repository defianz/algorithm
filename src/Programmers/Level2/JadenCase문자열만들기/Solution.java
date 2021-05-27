package Programmers.Level2.JadenCase문자열만들기;

class Solution {
    public String solution(String s) {
        String answer = "";

        boolean capFlag = true;
        for (int i = 0; i < s.length(); i++) {
            char tmp = s.charAt(i);
            if(capFlag && tmp != ' '){
                answer += (tmp + "").toUpperCase();
                capFlag=false;
            } else if (tmp == ' '){
                answer += tmp;
                capFlag = true;
            } else {
                answer += (tmp + "").toLowerCase();
            }
        }

        return answer;
    }
}
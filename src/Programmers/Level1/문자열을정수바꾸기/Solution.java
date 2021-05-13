package Programmers.Level1.문자열을정수바꾸기;

class Solution {
    public int solution(String s) {
        int answer = 0;
        boolean minus = false;
        String[] tmp = s.split("");
        if(tmp[0].equals("-")) minus = true;

        if(minus) answer = -1 * Integer.parseInt(s.substring(1,s.length()));
        else {
            answer = tmp[0].equals("+") ? Integer.parseInt(s.substring(1,s.length())) : Integer.parseInt(s.substring(0,s.length()));
        }

        return answer;
    }
}

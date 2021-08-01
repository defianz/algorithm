package Programmers_1st.Level1.삼진법뒤집기;

class Solution {
    public int solution(int n) {
        int answer = 0;

        String tmp = "";
        while(n != 0){
            tmp += String.valueOf(n%3);
            n /= 3;
        }

        int idx = 0;
        for (int i = tmp.length()-1; i >= 0; i--) {
            answer += Integer.parseInt(tmp.charAt(i)+"") * Math.pow(3,idx++);
        }

        return answer;
    }
}

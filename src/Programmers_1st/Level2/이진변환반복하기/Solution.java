package Programmers_1st.Level2.이진변환반복하기;

class Solution {
    public int[] solution(String s) {
        int[] answer = new int[2];

        int cnt = 0;
        int zeroNum = 0;

        while(!s.equals("1")){
            cnt++;
            String makeS = "";
            for (int i = 0; i < s.length(); i++) {
                if(s.charAt(i) == '0'){
                    zeroNum++;
                } else {
                    makeS += s.charAt(i);
                }
            }
            s = Integer.toBinaryString(makeS.length());
        }

        answer[0] = cnt;
        answer[1] = zeroNum;

        return answer;
    }
}

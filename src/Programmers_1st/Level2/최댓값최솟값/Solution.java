package Programmers_1st.Level2.최댓값최솟값;

class Solution {
    public String solution(String s) {
        String answer = "";
        String[] tmp = s.split(" ");

        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < tmp.length; i++) {
            int a = Integer.parseInt(tmp[i]);
            if(max < a) max = a;
            if(min > a) min = a;
        }
        answer = String.valueOf(min) + " " + String.valueOf(max);

        return answer;
    }
}

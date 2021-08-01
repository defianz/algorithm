package Programmers_1st.Level1.자연수뒤집배열;

class Solution {

    public int[] solution(long n) {

        char[] tmp = String.valueOf(n).toCharArray();
        int[] answer = new int[tmp.length];

        int idx =0;
        for (int i = tmp.length-1; i >= 0 ; i--) {
            answer[idx++]=tmp[i]-'0';
        }

        return answer;
    }
}

package Programmers_1st.Level1.완주하지못한선수;

import java.util.Arrays;

class Solution {
    public String solution(String[] participant, String[] completion) {
        String answer = "";

        Arrays.sort(participant);
        Arrays.sort(completion);

        int idx = 0;
        while(true) {
            if (idx == completion.length) {
                answer = participant[idx];
                break;
            }
            if (!completion[idx].equals(participant[idx])) {
                answer = participant[idx];
                break;
            }
            idx++;
        }
        int arr[][] = new int[3][3];

        return answer;
    }
}
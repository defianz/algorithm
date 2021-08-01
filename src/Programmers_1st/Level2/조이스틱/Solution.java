package Programmers_1st.Level2.조이스틱;

public class Solution {
    public int solution(String name) {

        int answer = 0;

        int len = name.length();

        int[] upDown = new int[len];
        char[] charName = new char[len];

        for (int i = 0; i < len; i++) {
            upDown[i] = Math.min(name.charAt(i) - 'A','Z' - name.charAt(i) + 1);
            charName[i] = name.charAt(i);
        }

        int currIdx = 0;
        answer += upDown[currIdx];
        charName[currIdx] = 'A';

        boolean flag = true;
        while(flag){
            int closeRightIdx = currIdx;
            int closeLeftIdx = currIdx;

            int rightCnt = 0;
            while(charName[closeRightIdx] == 'A'){
                closeRightIdx += 1;
                rightCnt += 1;
                if(closeRightIdx == len) closeRightIdx = 0;
                if(closeRightIdx == currIdx) break;
            }

            int leftCnt = 0;
            while(charName[closeLeftIdx] == 'A'){
                closeLeftIdx -= 1;
                leftCnt += 1;
                if(closeLeftIdx == -1) closeLeftIdx = len-1;
                if(closeLeftIdx == currIdx) break;
            }

            if(rightCnt <= leftCnt){
                answer += rightCnt;
                currIdx = closeRightIdx;
            } else {
                answer += leftCnt;
                currIdx = closeLeftIdx;
            }

            answer += upDown[currIdx];
            charName[currIdx] = 'A';

            flag = false;
            for (int i = 0; i < len; i++) {
                if(charName[i] != 'A') {
                    flag = true;
                    break;
                }
            }

        }
        return answer;
    }
}

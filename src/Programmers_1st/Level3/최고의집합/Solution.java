package Programmers_1st.Level3.최고의집합;

import java.util.Arrays;

class Solution {
    public int[] solution(int n, int s) {
        int[] answer = new int[n];
        if(n==1 ) return new int[]{s};

        int mok = s / n;
        int rem = s % n;

        if(mok == 0 ) return  new int[]{-1};

        Arrays.fill(answer,mok);
        int idx = n-1;
        while(rem > 0){
            answer[idx] = answer[idx]+1;
            idx--;
            rem--;
        }

        return answer;
    }

}

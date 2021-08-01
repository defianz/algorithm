package Programmers_1st.Level3.하노이의탑;

import java.util.ArrayList;

class Solution {

    ArrayList<int[]> arl = new ArrayList<>();
    public int[][] solution(int n) {

        hanoi(n,1,3,2);
        int[][] answer = new int[arl.size()][2];
        for (int i = 0; i < arl.size(); i++) {
            int[] tmp = arl.get(i);
            answer[i][0] = tmp[0];
            answer[i][1] = tmp[1];
        }

        return answer;
    }

    void hanoi(int n, int from, int to , int via){
        int[] move = {from, to};

        if(n==1){
            arl.add(move);
        } else {
            hanoi(n-1,from,via,to);
            arl.add(move);
            hanoi(n-1,via,to,from);
        }

    }

}

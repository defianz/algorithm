package Programmers_2nd.Level1.체육복;

class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        int answer = 0;
        boolean[] lostCheck = new boolean[n+2];
        boolean[] reserveCheck = new boolean[n+1];

        for (int lnum: lost) {
            lostCheck[lnum] = true;
        }

        for (int rnum : reserve){
            if(lostCheck[rnum]) {
                lostCheck[rnum] = false;
                reserveCheck[rnum] = true;
            }
        }

        for(int rnum : reserve){
            if(reserveCheck[rnum]) continue;
            if(lostCheck[rnum-1]) lostCheck[rnum-1] = false;
            else lostCheck[rnum+1] = false;
        }

        for (int i = 1; i <= n ; i++) {
            if(lostCheck[i]== false) answer++;
        }

        return answer;
    }
}
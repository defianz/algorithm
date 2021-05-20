package Programmers.Level2.피보나치수;

import java.util.ArrayList;

class Solution {

    public int solution(int n) {
        int answer = 0;
        ArrayList<Integer> arl = new ArrayList<>();
        arl.add(0);
        arl.add(1);
        arl.add(1);

        for (int i = 3; i <=n ; i++) {
            arl.add(arl.get(i-2) % 1234567 +arl.get(i-1) % 1234567);
        }

        answer = arl.get(n) % 1234567 ;

        return answer;
    }
}

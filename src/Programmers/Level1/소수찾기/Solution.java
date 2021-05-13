package Programmers.Level1.소수찾기;

import java.util.ArrayList;

class Solution {
    public int solution(int n) {
        int answer = 0;
        ArrayList<Integer> odd = new ArrayList<>();
        boolean[] check = new boolean[n+1];
        for(int i=2; i< Math.sqrt(n); i++){
            if(check[i] == false){
                for (int j = i+i; j <= n; j += i) {
                    check[j] = true;
                }
            }
        }

        for (int i = 2; i <= n ; i++) {
            if(check[i]==false) odd.add(i);
        }
        answer = odd.size();

        return answer;
    }
}
package Programmers_1st.Level1.체육복;


import java.util.Arrays;

class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        int answer = 0;
        boolean[] check = new boolean[reserve.length];
        boolean[] clear = new boolean[lost.length];
        answer = n - lost.length;
        Arrays.sort(lost);
        Arrays.sort(reserve);

        for (int i = 0; i < lost.length; i++) {
            for (int j = 0; j < reserve.length; j++) {
                if(reserve[j] == lost[i] && check[j] == false){
                    check[j] = true;
                    clear[i] = true;
                    answer += 1;
                    break;
                }
            }
        }


        for (int i = 0; i < lost.length; i++) {
            if(clear[i] == true) continue;
            for (int j = 0; j < reserve.length; j++) {
                if((reserve[j] == lost[i]-1 && check[j] == false) || (reserve[j] == lost[i]+1 && check[j] == false)){
                    check[j] = true;
                    answer += 1;
                    break;
                }
            }
        }

        return answer;
    }
}

package Programmers_2nd.Level1.K번째수;

import java.util.ArrayList;
import java.util.Arrays;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        int idx = 0;
        for (int[] tmp : commands){
            int i = tmp[0];
            int j = tmp[1];
            int k = tmp[2];

            ArrayList<Integer> arl = new ArrayList<>();
            for (int l = i-1; l <=j-1 ; l++) {
                arl.add(array[l]);
            }
            int[] arlSliced = new int[arl.size()];
            for (int l = 0; l < arl.size(); l++) {
                arlSliced[l] = arl.get(l);
            }
            Arrays.sort(arlSliced);
            answer[idx++] = arlSliced[k-1];
        }

        return answer;
    }
}
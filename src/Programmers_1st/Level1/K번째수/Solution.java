package Programmers_1st.Level1.K번째수;

import java.util.ArrayList;
import java.util.Collections;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = {};

        answer = new int[commands.length];

        for (int x = 0; x < commands.length; x++) {
            ArrayList<Integer> arl = new ArrayList<>();
            int i = commands[x][0];
            int j = commands[x][1];
            int k = commands[x][2];

            for (int l = i-1; l < j; l++) {
                arl.add(array[l]);
            }
            Collections.sort(arl);
            answer[x]= arl.get(k-1);
        }

        return answer;
    }
}

//
//import java.util.Arrays;
//class Solution {
//    public int[] solution(int[] array, int[][] commands) {
//        int[] answer = new int[commands.length];
//
//        for(int i=0; i<commands.length; i++){
//            int[] temp = Arrays.copyOfRange(array, commands[i][0]-1, commands[i][1]);
//            Arrays.sort(temp);
//            answer[i] = temp[commands[i][2]-1];
//        }
//
//        return answer;
//    }
//}
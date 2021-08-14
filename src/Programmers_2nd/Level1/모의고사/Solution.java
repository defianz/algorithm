package Programmers_2nd.Level1.모의고사;

import java.util.ArrayList;
import java.util.Arrays;

class Solution {

    public int[] solution(int[] answers) {


        int[] soopo1 = new int[]{1,2,3,4,5};
        int idx1 = 0;
        int pt1 = 0 ;

        int[] soopo2 = new int[]{2,1,2,3,2,4,2,5};
        int idx2 = 0;
        int pt2 = 0;

        int[] soopo3 = new int[]{3,3,1,1,2,2,4,4,5,5};
        int idx3 = 0;
        int pt3 = 0;


        for (int i = 0; i < answers.length ; i++) {
            int answer = answers[i];
            if(answer == soopo1[idx1]) pt1++;
            if(answer == soopo2[idx2]) pt2++;
            if(answer == soopo3[idx3]) pt3++;

            idx1 = (idx1 + 1) % 5;
            idx2 = (idx2 + 1) % 8;
            idx3 = (idx3 + 1) % 10;
        }

        int tmp = Math.max(Math.max(pt1,pt2),pt3);
        ArrayList<Integer> arl = new ArrayList<>();
        if(tmp == pt1) arl.add(1);
        if(tmp == pt2) arl.add(2);
        if(tmp == pt3) arl.add(3);

        return arl.stream().mapToInt(i -> i.intValue()).toArray();
    }
}
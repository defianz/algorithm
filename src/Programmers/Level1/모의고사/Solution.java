package Programmers.Level1.모의고사;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public int[] solution(int[] answers) {

        int[] man1 = {1,2,3,4,5};
        int[] man2 = {2,1,2,3,2,4,2,5};
        int[] man3 = {3,3,1,1,2,2,4,4,5,5};
        int[] cnt ={0,0,0};
        boolean[] flag = {false,false,false};

        for (int i = 0; i < answers.length; i++) {
            if(answers[i] == man1[i%5]) cnt[0]++;
            if(answers[i] == man2[i%8]) cnt[1]++;
            if(answers[i] == man3[i%10]) cnt[2]++;
        }
        int maxPt = Math.max(Math.max(cnt[0],cnt[1]),cnt[2]);
        int anssize =0;

        for (int i = 0; i < cnt.length; i++) {
            if (cnt[i] == maxPt) {
                anssize++;
                flag[i] = true;
            }
        }
        int[] answer = new int[anssize];
        int ansidx = 0;
        for(int i=0;i<3;i++){
            if(flag[i]) answer[ansidx++]=i;
        }

        List<Integer> test = new ArrayList<>(Arrays.asList(1,2,3,4,5,6));

        int[] ints = new int[test.size()];
        for (int i = 0; i < ints.length; i++) {
            ints[i] = test.get(i);
        }


        return answer;
    }
}

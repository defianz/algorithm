package Programmers_1st.Level1.실패율;

import java.util.Arrays;
import java.util.Comparator;

class Solution {
    public int[] solution(int N, int[] stages) {
        int[] answer = new int[N];
        int[] bj = new int[N+2];
        int[] bm = new int[N+2];
        double[] tmp = new double[N];
        Integer[] tmp2 = new Integer[N];


        for (int i = 0; i < stages.length; i++) {
            for (int j = 1; j <= stages[i]; j++) {
                bm[j]++;
            }
            bj[stages[i]]++;
        }


        for (int i = 1; i < N+1; i++) {
            tmp2[i-1]=i;
            if(bm[i] == 0 ) {

                tmp[i-1] = 0;
                continue;
            }
            tmp[i-1] = (double) bj[i]/(double) bm[i];

        }


        Arrays.sort(tmp2, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                if(tmp[o1-1] - tmp[o2-1] == 0) return o1-o2;
                return tmp[o1-1] - tmp[o2-1] > 0 ? -1 : 1;
            }
        });

        for (int i = 0; i < answer.length; i++) {
            answer[i]=(int)tmp2[i];
        }

        return answer;
    }
}
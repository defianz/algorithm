package Programmers_2nd.Level1.실패율;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

class Solution {

    class  node{
        int idx;
        double rate;

        node(int a, double b){
            this.idx = a;
            this.rate = b;
        }
    }
    public int[] solution(int N, int[] stages) {
        int[] answer = new int[N];

        double[] failed = new double[N+2];
        double[] tried = new double[N+2];

        ArrayList<node> arl = new ArrayList<>();

        for (int i = 0; i < stages.length; i++) {
            failed[stages[i]]++;
            for (int j = 1; j <= stages[i]; j++) {
                tried[j]++;
            }
        }

        for (int i = 1; i <= N; i++) {
            double t;
            if (tried[i] == 0) t = 0;
            else t = failed[i]/tried[i];

            node tmp = new node(i,t);
            arl.add(tmp);
        }
        Collections.sort(arl, new Comparator<node>() {
            @Override
            public int compare(node o1, node o2) {
                double tmp2 = o1.rate-o2.rate;
                return tmp2 > 0 ? -1 : tmp2 == 0 ? o1.idx - o2.idx : 1;
            }
        });

        for (int i = 0; i < N; i++) {
            answer[i] = arl.get(i).idx;
        }

        return answer;
    }
}
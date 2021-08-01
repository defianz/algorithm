package Programmers_1st.Level1.같은숫자는싫어;

import java.util.ArrayList;

public class Solution {
    public int[] solution(int []arr) {
        int[] answer = {};

        ArrayList<Integer> al = new ArrayList<>();
        int former=-1;
        for(int a : arr){
            if(a==former) continue;
            else {
                former=a;
                al.add(a);
            }
        }

        answer = new int[al.size()];
        for (int i = 0; i < al.size(); i++) {
            answer[i] = al.get(i);
        }
        return answer;
    }
}

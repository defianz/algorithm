package Programmers_1st.Level1.제일작은수제거하기;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public int[] solution(int[] arr) {

        int arrmin = Arrays.stream(arr).min().getAsInt();
        List<Integer> tmp = new ArrayList<>();

        for(int a : arr){
            if(a != arrmin){
                tmp.add(a);
            }
        }

        if (tmp.size() == 0) {
//            int[] tmp2 = {-1};
//            return tmp2;
            return new int[]{-1};
        }

        int[] answer = new int[tmp.size()];
        for (int i = 0; i < tmp.size() ; i++) {
            answer[i] = tmp.get(i);
        }
        return answer;
    }
}

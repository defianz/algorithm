package Programmers_1st.Level2.엔제곱배열자르기;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public long[] solution(int n, long left, long right) {
        long[] answer = {};
        List<Long> list = new ArrayList<>();

        for (long i = left; i <= right; i++) {
            list.add(Math.max(i/n,i%n)+1);
        }

        answer = new long[list.size()];
        for (int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i);
        }

        return answer;
    }
}
package Programmers_1st.Level2.프린터;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

class Solution {
    public int solution(int[] priorities, int location) {
        int answer = 0;

        int[] tmp = Arrays.copyOf(priorities,priorities.length);
        Arrays.sort(tmp);

        Queue<Integer> q = new ArrayDeque<>();
        for (int i = 0; i < priorities.length; i++) {
            q.add(priorities[i]);
        }

        int idx = 0;
        int qidx = 0;

        while(!q.isEmpty()){
            int nxt = q.poll();

            if(nxt == tmp[priorities.length-1-idx]){
                if(qidx == location) return idx +1;
                idx++;
            }

            qidx = (qidx + 1) % priorities.length;
            q.add(nxt);
        }


        return answer;
    }

    public static void main(String[] args) {
        System.out.println("new Solution().solution(new int[]{1, 1, 9, 1, 1, 1},0) = " + new Solution().solution(new int[]{1, 1, 9, 1, 1, 1},0));
    }
}

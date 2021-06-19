package Programmers.Level3.야근지수;


import java.util.Collections;
import java.util.PriorityQueue;

class Solution {
    public long solution(int n, int[] works) {
        long answer = 0;
        int m = works.length;

        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for (int i = 0; i < m; i++) {
            pq.add(works[i]);
        }

        while(n != 0){
            int tmp = pq.peek();
            if(tmp == 0) break;
            tmp = pq.poll()-1;
            n -= 1;
            pq.add(tmp);
        }

        for (int i = 0; i < m; i++) {
            answer += (long)Math.pow(pq.poll(),2);
        }

        return answer;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println("s.solution(new int[]{4,3,3},4) = " + s.solution(4, new int[]{4, 3, 3}));
    }
}
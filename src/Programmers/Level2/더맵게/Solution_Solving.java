package Programmers.Level2.더맵게;

import java.util.PriorityQueue;

class Solution_Solving {
    public int solution(int[] scoville, int K) {
        int answer = 0;

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i < scoville.length; i++) {
            pq.offer(scoville[i]);
        }

        while(pq.peek() < K){
            if(pq.size() == 1) return -1;

            int a = pq.poll();
            int b = pq.poll();
            pq.offer((a+2*b));
            answer++;
        }

        return answer;
    }
}
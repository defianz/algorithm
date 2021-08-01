package Programmers_1st.Level2.다리를지나는트럭;

import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
        Queue<Integer> q = new LinkedList<>();
        int idx = 0;
        for (int i = 0; i < bridge_length; i++) {
            q.offer(0);
        }

        while(true){
            if(idx > truck_weights.length-1) {
                answer += bridge_length;
                break;
            }
            weight += q.poll();
            if(weight-truck_weights[idx] >= 0){
                q.offer(truck_weights[idx]);
                weight -= truck_weights[idx];
                idx++;
            } else {
                q.offer(0);
            }
            answer++;
        }

        return answer;
    }

    public static void main(String[] args) {
        System.out.println("new Solution().solution(2,10,new int[]{7,4,5,6}) = " + new Solution().solution(2,10,new int[]{7,4,5,6}));
        System.out.println("new Solution().solution(100,100,new int[]{10}) = " + new Solution().solution(100,100,new int[]{10}));
        System.out.println("new Solution().solution(100,100,new int[]{10,10,10,10,10,10,10,10,10,10}) = " + new Solution().solution(100,100,new int[]{10,10,10,10,10,10,10,10,10,10}));
    }
}

package Programmers.Level3.이중우선순위큐;

import java.util.Collections;
import java.util.PriorityQueue;

class Solution {
    public int[] solution(String[] operations) {

        PriorityQueue<Integer> maxq = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> minq = new PriorityQueue<>();

        for (int i = 0; i < operations.length; i++) {
            String[] query = operations[i].split(" ");
            String doIM = query[0];
            int num = Integer.parseInt(query[1]);

            if(doIM.equals("I")){
                maxq.add(num);
                minq.add(num);
            } else {
                if(maxq.isEmpty()) continue;

                if(num == 1){
                    int maxNum = maxq.poll();
                    minq.remove(maxNum);
                } else {
                    int minNum = minq.poll();
                    maxq.remove(minNum);
                }
            }
        }

        if(maxq.isEmpty()) return new int[]{0,0};


        return new int[]{maxq.peek(), minq.peek()};
    }
}

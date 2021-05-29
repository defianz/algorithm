package Programmers.Level2.예상대진표;

import java.util.LinkedList;
import java.util.Queue;

class Solution
{
    public int solution(int n, int a, int b)
    {
        int answer = 0;

        Queue<Integer> q = new LinkedList<>();

        for (int i = 1; i <= n; i++) {
            q.add(i);
        }

        Queue<Integer> nxtQ = new LinkedList<>();
        boolean flag = true;
        while(flag){
            answer++;
            nxtQ.clear();
            while(!q.isEmpty()){
                int first = q.poll();
                int second = q.poll();
                if((first == a && second == b )|| (first == b && second == a)){
                    flag = false;
                    break;
                } else if(first == a || first == b){
                    nxtQ.add(first);
                } else if (second == b || second == a){
                    nxtQ.add(second);
                } else {
                    nxtQ.add(second);
                }
            }

            while(!nxtQ.isEmpty()){
                q.add(nxtQ.poll());
            }
        }

        return answer;
    }
}

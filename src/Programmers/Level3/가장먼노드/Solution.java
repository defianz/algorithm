package Programmers.Level3.가장먼노드;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

class Solution {

    public int solution(int n, int[][] edge) {
        int answer = 0;
        ArrayList<ArrayList<Integer>> map= new ArrayList<>();
        int[] cntTotal = new int[n+1];
        boolean[] visited = new boolean[n+1];

        for (int i = 0; i <= n ; i++) {
            map.add(new ArrayList<>());
        }

        for (int i = 0; i < edge.length; i++) {
            int[] tmp = edge[i];
            map.get(tmp[0]).add(tmp[1]);
            map.get(tmp[1]).add(tmp[0]);
        }

        Queue<Integer> q = new LinkedList<>();
        cntTotal[1] = 1;
        visited[1] = true;
        q.add(1);

        while(!q.isEmpty()){
            int cur = q.poll();
            for (int i = 1; i <= n; i++) {
                int nxt = i;
                if(map.get(cur).contains(nxt) && !visited[nxt]){
                    visited[nxt] = true;
                    cntTotal[nxt] = cntTotal[cur]+1;
                    q.add(nxt);
                }
            }
        }

        int cMax = Arrays.stream(cntTotal).max().getAsInt();
        answer = (int)Arrays.stream(cntTotal).filter(a -> a==cMax).count();

        return answer;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println("s.solution(6,new int[][]{{3, 6}, {4, 3}, {3, 2}, {1, 3}, {1, 2}, {2, 4}, {5, 2}}) = " + s.solution(6, new int[][]{{3, 6}, {4, 3}, {3, 2}, {1, 3}, {1, 2}, {2, 4}, {5, 2}}));
    }
}

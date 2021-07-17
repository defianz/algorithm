package Programmers.Level3.모두0으로만들기;

import java.util.ArrayList;

class Solution {
    ArrayList<Integer>[] arl;
    boolean[] visited;
    long[] long_a;
    long answer = 0;

    long dfs(int v){
        visited[v] = true;

        for (int i = 0; i < arl[v].size(); i++) {
            int next = arl[v].get(i);
            if(!visited[next]){
                long_a[v] += dfs(next);
            }
        }
        answer += Math.abs(long_a[v]);

        return long_a[v];
    }

    public long solution(int[] a, int[][] edges) {
        arl = new ArrayList[a.length];
        long_a = new long[a.length];
        visited = new boolean[a.length];

        // check possible && all 0
        long checkPossible = 0;
        boolean flag = false;
        for (int i = 0; i < a.length; i++) {
            checkPossible += a[i];
            long_a[i] = a[i];
            arl[i] = new ArrayList<>();
            if(a[i] != 0) flag = true;
        }
        if(flag == false) return 0;
        if(checkPossible != 0) return -1;


        // do
        for (int i = 0; i < edges.length; i++) {
            int first = edges[i][0];
            int second = edges[i][1];

            arl[first].add(second);
            arl[second].add(first);
        }

        dfs(0);

        return answer;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println("s.solution(new int[]{-5,0,2,1,2}, new int[][]{{0,1},{3,4},{2,3},{0,3}}) = " + s.solution(new int[]{-5, 0, 2, 1, 2}, new int[][]{{0, 1}, {3, 4}, {2, 3}, {0, 3}}));
    }
}

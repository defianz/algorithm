package Programmers_1st.Level3.가장먼노드;

import java.util.Arrays;

class Solution_Fail {
    int[][] map;
    int[] cntTotal;
    int N;
    boolean[] visited;

    void foo(int st, int cnt){
        for (int i = 1; i <= N; i++) {
            if(visited[i] || map[st][i] ==0) continue;
            visited[i] = true;
            cntTotal[i] = Math.min(cnt+1,cntTotal[i]);
            foo(i,cnt+1);
            visited[i] = false;
        }
        return;
    }


    public int solution(int n, int[][] edge) {
        int answer = 0;
        map= new int[n+1][n+1];
        cntTotal = new int[n+1];
        visited = new boolean[n+1];

        cntTotal[1] = 1;
        for (int i = 2; i < cntTotal.length; i++) {
            cntTotal[i] = 20001;
        }

        for (int i = 0; i < edge.length; i++) {
            int[] tmp = edge[i];
            map[tmp[0]][tmp[1]] = 1;
            map[tmp[1]][tmp[0]] = 1;
        }

        visited[1] = true;
        foo(1,0);

        int eMax = Arrays.stream(cntTotal).max().getAsInt();
        answer = (int)Arrays.stream(cntTotal).filter(a-> a==eMax).count();

        return answer;
    }

    public static void main(String[] args) {
        Solution_Fail s = new Solution_Fail();
        System.out.println("s.solution(6,new int[][]{{3, 6}, {4, 3}, {3, 2}, {1, 3}, {1, 2}, {2, 4}, {5, 2}}) = " + s.solution(6, new int[][]{{3, 6}, {4, 3}, {3, 2}, {1, 3}, {1, 2}, {2, 4}, {5, 2}}));
    }
}
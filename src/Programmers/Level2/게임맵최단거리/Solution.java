package Programmers.Level2.게임맵최단거리;

import java.util.LinkedList;
import java.util.Queue;

class Solution {
    class node {
        int r,c;
        node(int a, int b){
            this.r = a;
            this.c = b;
        }

    }

    public int solution(int[][] maps) {
        int answer = -1;

        int n = maps.length;
        int m = maps[0].length;

        int[][] dist = new int[n][m];
        int[] dr = new int[]{-1,0,1,0};
        int[] dc = new int[]{0,1,0,-1};
        Queue<node> q = new LinkedList<>();

        dist[0][0] = 1;
        q.add(new node(0,0));

        while(!q.isEmpty()){
            node curr = q.poll();
            int cr = curr.r;
            int cc = curr.c;
            for (int i = 0; i < 4; i++) {
                int nr = cr + dr[i];
                int nc = cc + dc[i];
                if(nr<0 || nr >n-1 || nc < 0 || nc > m-1) continue;
                if(maps[nr][nc] == 0 ) continue;
                if(maps[nr][nc] == 1 && dist[nr][nc] == 0){
                    dist[nr][nc] = dist[cr][cc] + 1;
                    if(nr == n-1 && nc == m-1 ) return dist[nr][nc];
                    q.add(new node(nr,nc));
                }
            }
        }

        return answer;
    }
}

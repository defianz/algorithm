package Programmers.Level2.카카오프렌즈컬러링북;

import java.util.LinkedList;
import java.util.Queue;

class Solution {
    class node {
        int row,col;

        node(int sr,int sc){
            this.row = sr;
            this.col = sc;
        }
    }

    int[] dr = new int[]{-1,0,1,0};
    int[] dc = new int[]{0,1,0,-1};

    int bfs(int[][] picture, boolean[][] check, int sr, int sc,int col, int m, int n){
        int res =0;
        Queue<node> q = new LinkedList<>();
        q.offer(new node(sr,sc));
        
        while(!q.isEmpty()){
            node st = q.poll();
            res++;
            for (int dir = 0; dir < 4; dir++) {
                int nr = st.row + dr[dir];
                int nc = st.col + dc[dir];
                if(nr <0 || nr > m-1 || nc <0 || nc > n-1 ) continue;

                if(picture[nr][nc] ==col && !check[nr][nc]){
                    check[nr][nc] = true;
                    q.offer(new node(nr,nc));
                }

            }
            
        }
        return res;
    }

    public int[] solution(int m, int n, int[][] picture) {
        int numberOfArea = 0;
        int maxSizeOfOneArea = 0;

        boolean[][] check = new boolean[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if(picture[i][j] == 0 ) continue;
                if(check[i][j]) continue;

                check[i][j] = true;
                numberOfArea++;
                int movecnt = bfs(picture,check,i,j,picture[i][j],m,n);
                if(maxSizeOfOneArea < movecnt ) maxSizeOfOneArea = movecnt;
            }
        }



        int[] answer = new int[2];
        answer[0] = numberOfArea;
        answer[1] = maxSizeOfOneArea;
        return answer;
    }
}

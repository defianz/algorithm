package Programmers.Level3.카드짝맞추기;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

class Solution {

    ArrayList<int[]> orders;
    int[] dr = new int[]{-1,0,1,0};
    int[] dc = new int[]{0,1,0,-1};

    void permutation(int n, int r, int[] perms, int[] input, int depth, int flag){
        if(depth == r){
            int[] temp = new int[n];
            System.arraycopy(perms,0,temp,0,n);
            orders.add(temp);
            return;
        }

        for (int i = 0; i < n; i++) {
            if((flag & (1<<i)) == 0 ){
                perms[depth] = input[i];
                permutation(n,r,perms,input,depth+1,flag | (1<<i));
            }
        }
    }

    int[] findCard(int[][] board, int r, int c, int dir){
        r += dr[dir];
        c += dc[dir];
        while(r>=0 && r< 4 && c>= 0 && c <4){
            if(board[r][c] != 0){
                return new int[]{r,c};
            }
            r += dr[dir];
            c += dc[dir];
        }
        return new int[]{r-dr[dir],c-dc[dir]};
    }

    int bfs(int[][] board, int target, int[] point){
        int r = point[0];
        int c = point[1];
        Queue<int[]> q = new LinkedList<>();
        boolean[][] visited = new boolean[4][4];
        q.add(new int[]{r,c,0});
        visited[r][c] = true;

        while(!q.isEmpty()){
            int[] cur = q.poll();
            if(board[cur[0]][cur[1]] == target){
                point[0] = cur[0];
                point[1] = cur[1];
                return cur[2];
            }

            for (int dir = 0; dir < 4; dir++) {
                int nr = cur[0] + dr[dir];
                int nc = cur[1] + dc[dir];
                if(nr < 0 || nr >3 || nc <0 || nc > 3) continue;
                if(visited[nr][nc]) continue;
                visited[nr][nc] = true;
                q.add(new int[]{nr,nc,cur[2]+1});
            }

            for (int dir = 0; dir < 4; dir++) {
                int[] result = findCard(board, cur[0],cur[1],dir);
                if((result[0] != cur[0] || result[1] != cur[1]) && !visited[result[0]][result[1]]){
                    visited[result[0]][result[1]] = true;
                    q.add(new int[]{result[0],result[1],cur[2]+1});
                }
            }

        }
        return 0;
    }

    public int solution(int[][] board, int r, int c) {
        int answer = Integer.MAX_VALUE;
        int n = 0;
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                if(board[i][j] != 0 ) n++;
            }
        }
        n /= 2;

        int[] tmp = new int[n];
        for (int i = 0; i < tmp.length; i++) {
            tmp[i] = i+1;
        }
        orders = new ArrayList<>();
        permutation(n, n, new int[n], tmp, 0, 0);

        for (int[] order : orders){
            int total = 0;
            int[] point = new int[2];
            point[0] = r;
            point[1] = c;
            int[][] cBoard = new int[4][4];
            for (int i = 0; i < 4; i++) {
                for (int j = 0; j < 4; j++) {
                    cBoard[i][j] = board[i][j];
                }
            }

            for (int card : order){
                int cnt = 0;
                cnt += bfs(cBoard,card,point) + 1;
                cBoard[point[0]][point[1]] = 0;
                cnt += bfs(cBoard,card,point) + 1;
                cBoard[point[0]][point[1]] = 0;
                total += cnt;
            }
            answer = Math.min(total,answer);

        }


        return answer;
    }
}
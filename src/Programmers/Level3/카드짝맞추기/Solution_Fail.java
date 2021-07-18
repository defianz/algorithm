package Programmers.Level3.카드짝맞추기;

class Solution_Fail {

    int lastidx = 0;
    int answer = Integer.MAX_VALUE;

    int[] dr = new int[]{-1,0,1,0};
    int[] dc = new int[]{0,1,0,-1};

    int[] findIdx(int nowIdx, int[][] board){
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                if(board[i][j] == nowIdx) return new int[]{i,j};
            }
        }
        return new int[]{0,0};
    }

    void dfs(int r, int c, int[][] board,  int nowIdx, int catchCnt, int inputCnt, boolean[][] visited ){
        if(catchCnt == lastidx){
            answer = Math.min(inputCnt,answer);
            return;
        }

        if(inputCnt >= answer) return;

        // 잡아야될게 있을 경우
        if(nowIdx != 0) {
            if(board[r][c] == nowIdx){
                inputCnt += 1;
                nowIdx = 0;
                catchCnt += 1;
            }
        } else {
            if(board[r][c] != 0){
                inputCnt += 1;
                nowIdx = board[r][c];
            }
        }

        // 방향 누르기
        for (int dir = 0; dir < 4; dir++) {
            int nr = r + dr[dir];
            int nc = c + dc[dir];
            if(nr < 0 || nr > 3 || nc < 0 || nc > 3) continue;
            if(visited[nr][nc]) continue;
            visited[nr][nc] = true;
            dfs(nr,nc,board,nowIdx, catchCnt,inputCnt+1,visited);
            visited[nr][nc] = false;
        }

        for (int dir = 0; dir < 4; dir++) {
            int nr = r + dr[dir];
            int nc = c + dc[dir];
            if (nr < 0 || nr > 3 || nc < 0 || nc > 3) continue;

            boolean flag = false;
            while(board[nr][nc] == 0){
                nr += dr[dir];
                nc += dc[dir];
                if (nr < 0 || nr > 3 || nc < 0 || nc > 3) {
                    flag = true;
                    break;
                }
            }


            if(flag == false) {
                if(visited[nr][nc]) continue;
                visited[nr][nc] = true;
                dfs(nr,nc,board,nowIdx,catchCnt,inputCnt+1, visited);
                visited[nr][nc]  = false;
            }
            else {
                nr = nr-dr[dir];
                nc = nc-dc[dir];
                if(visited[nr][nc]) continue;
                visited[nr][nc] = true;
                dfs(nr,nc,board,nowIdx,catchCnt,inputCnt+1, visited);
                visited[nr][nc]  = false;
            }
        }
    }


    public int solution(int[][] board, int r, int c) {


        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                if(board[i][j] > lastidx) lastidx = board[i][j];
            }
        }


        boolean[][] visited = new boolean[4][4];
        int nowIdx = 0;
        int inputCnt = 0;
        dfs(r,c,board,nowIdx,0,inputCnt, visited);


        return answer;
    }

    public static void main(String[] args) {
        Solution_Fail s = new Solution_Fail();
        System.out.println("s.solution(new int[][]{{1,0,0,3},{2,0,0,0},{0,0,0,2},{3,0,1,0}}\t,1,0) = " + s.solution(new int[][]{{1, 0, 0, 3}, {2, 0, 0, 0}, {0, 0, 0, 2}, {3, 0, 1, 0}}, 1, 0));
        System.out.println("s.solution(new int[][]{{3,0,0,2},{0,0,1,0},{0,1,0,0},{2,0,0,3}},0,1) = " + s.solution(new int[][]{{3, 0, 0, 2}, {0, 0, 1, 0}, {0, 1, 0, 0}, {2, 0, 0, 3}}, 0, 1));
    }
}
package Programmers.Level3.기둥과보설치;

class Solution {

    int N;
    boolean[][] column;
    boolean[][] bo;
    int cnt = 0;

    boolean canColumn(int x, int y){
        if(y == 1) { // 기둥이 바닥 위에 있을 때
            return true;
        } else if(bo[x][y] == true || bo[x-1][y] == true) { // 보의 한쪽 끝 부분 위에 있을 때
            return true;
        } else if(column[x][y-1] == true) { // 다른 기둥 위에 있을 때
            return true;
        }

        return false;
    }

    boolean canBo(int x, int y){
        if(column[x][y-1] == true || column[x+1][y-1] == true) { // 한쪽 끝 부분이 기둥 위일 때
            return true;
        } else if(bo[x+1][y] == true && bo[x-1][y] == true) { // 양쪽 끝 부분이 다른 보와 동시에 연결되어있을 때
            return true;
        }

        return false;
    }


    void create( int x, int y, int a){
        if(a == 0 ){
            if(canColumn(x,y)){
                column[x][y] = true;
                cnt++;
            }
        } else {
            if(canBo(x,y)){
                bo[x][y] = true;
                cnt++;
            }
        }
    }

    boolean canDelete(){
        for(int i = 1; i <= N+1; i++) {
            for(int j = 1; j <= N+1; j++) {
                if(column[i][j] && !canColumn(i, j))  // 기둥 삭제 가능한지 확인
                    return false;

                if(bo[i][j] && !canBo(i, j))  // 보 삭제 가능한지 확인
                    return false;
            }
        }
        return true;
    }

    void delete(int x, int y, int a){
        if ( a == 0){
            column[x][y] = false;
            cnt--;
        } else {
            bo[x][y] = false;
            cnt--;
        }

        if(!canDelete()){
            if( a == 0){
                column[x][y] = true;
                cnt++;
            } else {
                bo[x][y] = true;
                cnt++;
            }
        }

    }


    public int[][] solution(int n, int[][] build_frame) {


        N = n;
        column = new boolean[N+2][N+2];
        bo = new boolean[N+2][N+2];

        for (int i = 0; i < build_frame.length; i++) {

            int x = build_frame[i][0]+1;
            int y = build_frame[i][1]+1;
            int a = build_frame[i][2];
            int b = build_frame[i][3];

            if(b==0){
                delete(x,y,a);
            } else {
                create(x,y,a);
            }
        }

        int[][] answer = new int[cnt][3];
        int idx =0;

        for (int i = 1; i <= n+1; i++) {
            for (int j = 1; j <= n+1; j++) {
                if(column[i][j]){
                    answer[idx][0] = i-1;
                    answer[idx][1] = j-1;
                    answer[idx][2] = 0;
                    idx++;
                }
                if(bo[i][j]){
                    answer[idx][0] = i-1;
                    answer[idx][1] = j-1;
                    answer[idx][2] = 1;
                    idx++;
                }
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int tmp[][] = s.solution(5,new int[][]{{1,0,0,1},{1,1,1,1},{2,1,0,1},{2,2,1,1},{5,0,0,1},{5,1,0,1},{4,2,1,1},{3,2,1,1}});
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.println("tmp[i][j] = " + tmp[i][j]);
            }
            System.out.println();
        }
    }
}
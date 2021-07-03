package Programmers.Level3.기둥과보설치;

class Solution_Solving {

    int[][] gmap;
    int[][] bmap;


    boolean checkBo(int x, int y){
        int n = gmap.length-1;
        if(y==0) return false;
        if(x-1 >= 0 && gmap[y-1][x]== 1) return true;
        if(x+1 <= n && gmap[y-1][x+1] ==1 ) return true;
        if(bmap[y][x-1] == 1 || bmap[y][x+1] ==1) return true;
        else return false;
    }


    boolean checkGi(int x, int y){
        if(y == 0) return true;
        else {
            if(x-1 >= 0 && gmap[y][x-1] == 1 ) return true;
            if(bmap[y-1][x-1] == 1) return true;
            else return false;
        }
    }

    boolean canDestruct(){
        int n = gmap.length-1;
        for (int i = 0; i < n+1; i++) {
            for (int j = 0; j < n+1; j++) {
                if(gmap[i][j] == 1 && !checkGi(i,j)){
                    return false;
                }

                if(bmap[i][j] == 1 && !checkBo(i,j)){
                    return false;
                }
            }
        }
        return true;
    }

    public int[][] solution(int n, int[][] build_frame) {


        gmap = new int[n+1][n+1];
        bmap = new int[n+1][n+1];

        int structCnt = 0;

        for (int i = 0; i < build_frame.length; i++) {
            int x = build_frame[i][0];
            int y = build_frame[i][1];

            int a = build_frame[i][2];
            int b = build_frame[i][3];

            if( b == 1 ){
                if (a == 0 && checkGi(x, y)) {
                    gmap[y][x]= 1;
                    structCnt++;
                }

                if( a == 1 && checkBo(x,y)){
                    bmap[y][x] = 1;
                    structCnt++;
                }
            } else {
                //삭제
                if( a == 0){
                    gmap[y][x] = 0;
                } else{
                    bmap[y][x] = 0;
                }
                structCnt--;

                if(!canDestruct()){
                    if( a == 0){
                        gmap[y][x] = 1;
                    } else{
                        bmap[y][x] = 1;
                    }
                    structCnt++;
                }
            }
        }


        int[][] answer = new int[structCnt][3];
        int idx =0;

        for (int i = 0; i < n+1; i++) {
            for (int j = 0; j < n+1; j++) {
                System.out.print(gmap[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();

        for (int i = 0; i < n+1; i++) {
            for (int j = 0; j < n+1; j++) {
                System.out.print(bmap[i][j] + " ");
            }
            System.out.println();
        }

        for (int i = 0; i < n+1; i++) {
            for (int j = 0; j < n+1; j++) {
                if(gmap[i][j] == 1){
                    answer[idx][0]=i;
                    answer[idx][1]=j;
                    answer[idx][2]=0;
                    idx++;
                }

                if(bmap[i][j] == 1){
                    answer[idx][0]=i;
                    answer[idx][1]=j;
                    answer[idx][2]=1;
                    idx++;
                }

            }
        }


        return answer;
    }

    public static void main(String[] args) {
        Solution_Solving s = new Solution_Solving();
        int[][] tmp = s.solution(5,new int[][]{{1,0,0,1},{1,1,1,1},{2,1,0,1},{2,2,1,1},{5,0,0,1},{5,1,0,1},{4,2,1,1},{3,2,1,1}});
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.println("tmp[i][j] = " + tmp[i][j]);
            }
        }
    }
}
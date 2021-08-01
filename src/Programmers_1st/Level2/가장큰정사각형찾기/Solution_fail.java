package Programmers_1st.Level2.가장큰정사각형찾기;

class Solution_fail
{
    public int solution(int [][]board)
    {
        int answer = 0;
        int rowN = board.length;
        int colN = board[0].length;
        int maxB = Math.max(rowN,colN);


        for (int i = 0; i < rowN; i++) {
            for (int j = 0; j < colN; j++) {

                if(board[i][j] == 0 ) continue;
                int sr = i;
                int sc = j;
                int dotMin = maxB;
                int k = sr;

                for (; k < rowN; k++) {
                    if(board[k][sc] == 0) {
                        dotMin = Math.min(dotMin,k-1-sr);
                        break;
                    }
                    int l = sc+1;
                    for ( ; l < colN; l++) {
                        if(board[k][l] == 0){
                            dotMin = Math.min(dotMin,l-1-sc);
                            break;
                        }
                    }
                    if ( l == colN){
                        dotMin = Math.min(dotMin,l-1-sc);
                    }

                }
                if( k == rowN){
                    dotMin = Math.min(dotMin,k-1-sr);
                }

                answer = Math.max(answer,(dotMin+1)*(dotMin+1));
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        Solution_fail s = new Solution_fail();
        System.out.println("s.solution(new int[][]{{0,0,1,1},{1,1,1,1}}) = " + s.solution(new int[][]{{0, 0, 1, 1}, {1, 1, 1, 1}}));
        System.out.println("s.solution(new int[][]{{0,1,1,1},{1,1,1,1},{1,1,1,1},{0,0,1,0}}) = " + s.solution(new int[][]{{0, 1, 1, 1}, {1, 1, 1, 1}, {1, 1, 1, 1}, {0, 0, 1, 0}}));
    }
}
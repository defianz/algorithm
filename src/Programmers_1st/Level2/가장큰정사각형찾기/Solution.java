package Programmers_1st.Level2.가장큰정사각형찾기;

class Solution
{
    public int solution(int [][]board)
    {
        int answer = 0;
        int rowN = board.length;
        int colN = board[0].length;

        int[][] dp = new int[rowN][colN];

        for (int i = 0; i < colN; i++) {
            dp[0][i] = board[0][i];
            if(answer < dp[0][i]) answer = dp[0][i];
        }

        for (int i = 0; i < rowN; i++) {
            dp[i][0] = board[i][0];
            if(answer < dp[i][0]) answer = dp[i][0];
        }


        for (int i = 1; i < rowN; i++) {
            for (int j = 1; j < colN; j++) {
                if(board[i][j] == 1){
                    dp[i][j] = Math.min(Math.min(dp[i-1][j-1],dp[i][j-1]),dp[i-1][j]) +1;
                    if(answer < dp[i][j]) answer = dp[i][j];
                } else {
                    dp[i][j] = 0;
                }
            }
        }


        return answer*answer;
    }
}
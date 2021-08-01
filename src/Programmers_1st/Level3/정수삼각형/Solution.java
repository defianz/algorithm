package Programmers_1st.Level3.정수삼각형;

class Solution {



    public int solution(int[][] triangle) {


        int r = triangle.length;
        int c = triangle[r-1].length;

        int[][] dp = new int[r][c];

        dp[0][0] = triangle[0][0];


        for (int i = 1; i < r; i++) {
            for (int j = 0; j < triangle[i].length; j++) {
                if(j==0) dp[i][j] = dp[i-1][j]+triangle[i][j];
                else if (j == triangle[i].length-1) dp[i][j] = dp[i-1][j-1] + triangle[i][j];
                else dp[i][j] = Math.max(dp[i-1][j-1],dp[i-1][j]) + triangle[i][j];
            }
        }
        int answer = 0;
        for (int i = 0; i < c; i++) {
            answer = Math.max(answer,dp[r-1][i]);
        }


        return answer;
    }
}

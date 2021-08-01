package Programmers_1st.Level2.땅따먹기;

class Solution {

    int solution(int[][] land) {
        int answer = 0;

        int n = land.length;
        int[][] dp = new int[land.length][4];

        for (int i = 0; i < 4; i++) {
            dp[0][i] = land[0][i];
        }

        for (int i = 1; i < n; i++) {
            dp[i][0] = Math.max(Math.max(dp[i-1][1],dp[i-1][2]),dp[i-1][3]) + land[i][0];
            dp[i][1] = Math.max(Math.max(dp[i-1][0],dp[i-1][2]),dp[i-1][3]) + land[i][1];
            dp[i][2] = Math.max(Math.max(dp[i-1][0],dp[i-1][1]),dp[i-1][3]) + land[i][2];
            dp[i][3] = Math.max(Math.max(dp[i-1][0],dp[i-1][1]),dp[i-1][2]) + land[i][3];
        }

        for (int i = 0; i < 4; i++) {
            answer = Math.max(dp[n-1][i],answer);
        }

        return answer;
    }


    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println("s.solution(new int[][]{{1,2,3,5},{5,6,7,8},{4,3,2,1}}) = " + s.solution(new int[][]{{1, 2, 3, 5}, {5, 6, 7, 8}, {4, 3, 2, 1}}));
        System.out.println("s.solution(new int[][]{{4, 3, 2, 1}, {2, 2, 2, 1}, {6, 6, 6, 4}, {8, 7, 6, 5}}) = " + s.solution(new int[][]{{4, 3, 2, 1}, {2, 2, 2, 1}, {6, 6, 6, 4}, {8, 7, 6, 5}}));
    }
}
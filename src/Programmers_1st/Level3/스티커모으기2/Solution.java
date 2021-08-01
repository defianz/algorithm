package Programmers_1st.Level3.스티커모으기2;

class Solution {
    public int solution(int sticker[]) {
        int n = sticker.length;
        int[][] dp = new int[n][2];


        // 0이 고른거
        // 1이 안고른거
        dp[0][0] = sticker[0];
        dp[0][1] = 0;

        if (n > 1) {
            dp[1][0] = dp[0][0];
            dp[1][1] = sticker[1];
            if (n > 2) {
                for (int i = 2; i <= n - 2; i++) {
                    dp[i][0] = Math.max(dp[i - 1][0], dp[i - 2][0] + sticker[i]);
                    dp[i][1] = Math.max(dp[i - 1][1], dp[i - 2][1] + sticker[i]);
                }
                dp[n - 1][0] = dp[n - 2][0];
                dp[n - 1][1] = Math.max(dp[n - 2][1], dp[n - 3][1] + sticker[n - 1]);
            }
        }


        return Math.max(dp[n - 1][0], dp[n - 1][1]);
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println("s.solution(new int[]{14, 6, 5, 11, 3, 9, 2, 10}) = " + s.solution(new int[]{14, 6, 5, 11, 3, 9, 2, 10}));
//        System.out.println("s.solution(new int[]{1, 3, 2, 5, 4}) = " + s.solution(new int[]{1, 3, 2, 5, 4}));
        System.out.println("s.solution(new int[]{1}) = " + s.solution(new int[]{1, 3}));
    }
}

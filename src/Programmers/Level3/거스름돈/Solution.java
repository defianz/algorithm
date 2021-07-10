package Programmers.Level3.거스름돈;


import java.util.Arrays;

class Solution {
    public int solution(int n, int[] money) {

        long[] dp = new long[n+1];

        Arrays.sort(money);

        dp[0] = 1;

        for (int i = 0; i < money.length; i++) {
            for (int j = money[i]; j <= n; j++) {
                dp[j] = dp[j]+dp[j-money[i]];
            }
        }

        return (int) (dp[n]%1000000007);
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println("s.solution(5,new int[]{1,2,5}) = " + s.solution(5, new int[]{1, 2, 5}));
    }
}
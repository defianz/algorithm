package Programmers.Level3.이곱하기엔타일링;

class Solution {

    int[] dp;

    int foo(int n){
        if(dp[n] == 0){
            dp[n] = (foo(n-1)+foo(n-2)) % 1000000007;
        }
        return dp[n];
    }
    public int solution(int n) {
        dp = new int[n+1];
        dp[0]= 1;
        dp[1]= 1;

        int answer = foo(n) % 1000000007;

        return answer;
    }
}
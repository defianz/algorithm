package Programmers_1st.Level1.약수의합;

class Solution {
    public int solution(int n) {
        int answer = 0;
        if( n == 0 ) return 0;

        for(int i=1; i<=n; i++){
            answer += n % i == 0 ? i : 0;
        }

        return answer;
    }
}
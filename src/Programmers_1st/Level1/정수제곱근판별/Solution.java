package Programmers_1st.Level1.정수제곱근판별;

class Solution {
    public long solution(long n) {
        long answer = 0;
        if(Math.sqrt(n) != (long)Math.sqrt(n)){
            answer = -1;
        } else {
            long tmp = (long)Math.sqrt(n) + 1;
            answer = tmp * tmp;
        }
        return answer;
    }
}

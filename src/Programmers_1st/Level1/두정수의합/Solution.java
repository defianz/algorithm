package Programmers_1st.Level1.두정수의합;

class Solution {
    public long solution(int a, int b) {
        long answer = 0;

        if (a==b) return a;

        if( a > b ){
            int tmp = a;
            a = b;
            b = tmp;
        }

        for(int i = a; i <= b; i++){
            answer += i;
        }
        return answer;
    }


}
//
//    public long solution(int a, int b) {
//        return sumAtoB(Math.min(a, b), Math.max(b, a));
//    }
//
//    private long sumAtoB(long a, long b) {
//        return (b - a + 1) * (a + b) / 2;
//    }
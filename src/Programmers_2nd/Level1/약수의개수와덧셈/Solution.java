package Programmers_2nd.Level1.약수의개수와덧셈;

class Solution {

    boolean check (int a ){
        int cnt = 0;
        for (int i = 1; i <=  a; i++) {
            if(a % i == 0) cnt++;
        }
        if(cnt % 2 == 0) return true;
        else return false;
    }


    public int solution(int left, int right) {
        int answer = 0;

        for (int i = left; i <= right ; i++) {
            if(check(i)){
                answer += i;
            } else {
                answer -= i;
            }
        }

        return answer;
    }
}